package com.l2.site.api;

import com.l2.site.message.MessageRepository;
import com.l2.site.model.jwt.CurrentUser;
import com.l2.site.model.jwt.JwtUser;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class MainController {

  @Value("${spring.profiles.active}")
  private String profile;

  private final MessageRepository messageRepository;

  @GetMapping
  public String main(Model model, @CurrentUser(required = false) JwtUser jwtUser) {
    HashMap<Object, Object> data = new HashMap<>();

    data.put("profile", jwtUser);
    data.put("messages", messageRepository.findAll());

    model.addAttribute("isDevMode", "dev".equals(profile));
    model.addAttribute("frontendData", data);

    return "index";
  }


//  @GetMapping
//  public String main(Model model, @AuthenticationPrincipal User user) {
//    HashMap<Object, Object> data = new HashMap<>();
//    if (user != null) {
//      data.put("profile", user);
//      data.put("messages", messageRepository.findAll());
//    }
//    model.addAttribute("frontendData", data);
//    model.addAttribute("isDevMode", "dev".equals(profile));
//
//    return "index";
//  }
}
