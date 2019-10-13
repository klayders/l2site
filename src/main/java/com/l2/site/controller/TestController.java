package com.l2.site.controller;

import com.l2.site.model.Accounts;
import com.l2.site.repository.AccountsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TestController {

  private final AccountsRepository accountsRepository;

  @GetMapping("/test")
  public List<Accounts> doIt(){
    return accountsRepository.findAll();
  }
}
