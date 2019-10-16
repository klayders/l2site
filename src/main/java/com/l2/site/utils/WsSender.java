package com.l2.site.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.l2.site.model.pojo.EventType;
import com.l2.site.model.pojo.ObjectType;
import com.l2.site.model.pojo.WsEventDTO;
import lombok.AllArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import java.util.function.BiConsumer;

@Component
@AllArgsConstructor
public class WsSender {

  private final SimpMessagingTemplate template;
  private final ObjectMapper objectMapper;

  public <T> BiConsumer<EventType, T> getSender(ObjectType objectType, Class view) {
    ObjectWriter mapper = this.objectMapper.setConfig(this.objectMapper.getSerializationConfig())
      .writerWithView(view);

    return (EventType eventType, T payload) -> {
      String value;
      try {
        value = mapper.writeValueAsString(payload);
      } catch (JsonProcessingException e) {
        throw new RuntimeException(e);
      }

      template.convertAndSend("/topic/activity",
        new WsEventDTO(objectType, eventType, value));
    };
  }
}
