package com.l2.site.controller;

import com.l2.site.model.Accounts;
import com.l2.site.repository.AccountsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AccountController {

  private final AccountsRepository accountsRepository;

  @GetMapping("/user/all")
  public List<Accounts> doIt() {
    return accountsRepository.findAll();
  }

  @GetMapping("/user/{login}")
  public Accounts doIt(@PathVariable String login) {
    return accountsRepository.getOne(login);
  }

  @PostMapping("/user/save")
  public Accounts doIt(@RequestParam String login, @RequestParam String password) {
    var accounts = new Accounts();
    accounts.setLogin(login);
    accounts.setPassword(password);
    return accountsRepository.save(accounts);
  }
}
