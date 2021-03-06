package com.l2.site.api;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class MainController {

  @Value("${spring.profiles.active}")
  private String profile;

  @GetMapping
  public String main(Model model) {
//    HashMap<Object, Object> data = new HashMap<>();
//    model.addAttribute("frontendData", data);
    model.addAttribute("isDevMode", "dev".equals(profile));

    return "index";
  }
}
