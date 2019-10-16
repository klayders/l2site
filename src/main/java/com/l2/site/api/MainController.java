package com.l2.site.api;

import com.l2.site.message.MessageRepository;
import com.l2.site.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;

//@Controller
//@RequestMapping("/")
public class MainController {

  @Value("${spring.profiles.active}")
  private String profile;

  private final MessageRepository messageRepository;

  @Autowired
  public MainController(MessageRepository messageRepository) {
    this.messageRepository = messageRepository;
  }


  @GetMapping
  public String main(Model model, @AuthenticationPrincipal User user) {
    HashMap<Object, Object> data = new HashMap<>();
    if (user != null) {
      data.put("profile", user);
      data.put("messages", messageRepository.findAll());
    }
    model.addAttribute("frontendData", data);
    model.addAttribute("isDevMode", "dev".equals(profile));

    return "index";
  }
}