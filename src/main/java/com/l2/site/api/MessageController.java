package com.l2.site.api;

import com.fasterxml.jackson.annotation.JsonView;
import com.l2.site.message.MessageRepository;
import com.l2.site.model.Views;
import com.l2.site.model.message.Message;
import com.l2.site.model.pojo.EventType;
import com.l2.site.model.pojo.MetaDto;
import com.l2.site.model.pojo.ObjectType;
import com.l2.site.utils.WsSender;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("message")
public class MessageController {

  private static String URL_PATTERN = "https?:\\/\\/?[\\w\\d\\._\\-%\\/\\?=&#]+";
  private static String IMAGE_PATTERN = "\\.(jpeg|jpg|gif|png)$";

  private static Pattern URL_REGEX = Pattern.compile(URL_PATTERN, Pattern.CASE_INSENSITIVE);
  private static Pattern IMG_REGEX = Pattern.compile(IMAGE_PATTERN, Pattern.CASE_INSENSITIVE);

  private final MessageRepository messageRepository;
  private final BiConsumer<EventType, Message> wsSender;

  public MessageController(MessageRepository messageRepository, WsSender wsSender) {
    this.messageRepository = messageRepository;
    this.wsSender = wsSender.getSender(ObjectType.MESSAGE, Views.Id.class);
  }


  @GetMapping
  @JsonView(Views.IdName.class)
  public List<Message> list() {
    return messageRepository.findAll();
  }

  @GetMapping("{id}")
  public Message getOne(@PathVariable("id") Message message) {
    return message;
  }

  @PostMapping
  public Message create(@RequestBody Message message) throws IOException {
    fillMeta(message);
    message.setCreationDate(LocalDateTime.now());
    Message create = messageRepository.save(message);

    wsSender.accept(EventType.CREATE, create);

    return create;
  }

  @PutMapping("{id}")
  public Message update(@PathVariable("id") Message messageFromDb,
                        @RequestBody Message message) throws IOException {
    BeanUtils.copyProperties(message, messageFromDb, "id");

    fillMeta(messageFromDb);

    Message update = messageRepository.save(messageFromDb);

    wsSender.accept(EventType.UPDATE, update);

    return update;
  }

  @DeleteMapping("{id}")
  public void delete(@PathVariable("id") Message message) {
    Message update = messageRepository.save(message);

    wsSender.accept(EventType.REMOVE, update);

    messageRepository.delete(message);
  }

  private void fillMeta(Message message) throws IOException {
    String text = message.getText();
    Matcher matcher = URL_REGEX.matcher(text);

    if (matcher.find()) {
      String url = text.substring(matcher.start(), matcher.end());
      matcher = IMG_REGEX.matcher(url);

      message.setLink(url);

      if (matcher.find()) {
        message.setLinkCover(url);
      } else if (url.contains("youtube")) {
        MetaDto meta = getMeta(url);
        message.setLinkCover(meta.getCover());
        message.setLinkTitile(meta.getTitle());
        message.setLinkDescription(meta.getDescription());
      }
    }
  }

  private MetaDto getMeta(String url) throws IOException {
    Document doc = Jsoup.connect(url).get();

    Elements title = doc.select("meta[name$=title],meta[property$=title]");
    Elements description = doc.select("meta[name$=description],meta[property$=description]");
    Elements cover = doc.select("meta[name$=image],meta[property$=image]");

    return new MetaDto(
      getContent(title.first()),
      getContent(description.first()),
      getContent(cover.first())
    );
  }

  private String getContent(Element element) {
    return element == null ? "" : element.attr("content");
  }
}
