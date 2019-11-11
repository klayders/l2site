package com.l2.site.api;

import com.l2.site.account.AccountService;
import com.l2.site.model.account.Account;
import com.l2.site.model.account.RegistrationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/registration")
public class RegistrationController {

  private final AccountService accountService;

  @PostMapping
  public void registration(@RequestBody RegistrationRequest registrationForm){
    Account accounts = new Account();
    accounts.setLogin(registrationForm.getLogin());
    accounts.setPassword(registrationForm.getPassword());
//    accountService.save(accounts);
  }

}
