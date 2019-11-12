package com.l2.site.api;

import com.l2.site.account.AccountService;
import com.l2.site.exception.RegistrationException;
import com.l2.site.model.account.Account;
import com.l2.site.model.account.AccountSnapshot;
import com.l2.site.model.account.RegistrationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/registration")
public class RegistrationController {

  private final AccountService accountService;
  private final BCryptPasswordEncoder passwordEncoder;

  @PostMapping
  public AccountSnapshot registration(@RequestBody RegistrationRequest registrationForm) {
    if (accountService.getAccountById(registrationForm.getLogin()) != null) {
      throw new RegistrationException("login уже занят");
    } else {
      var accounts = new Account();
      accounts.setLogin(registrationForm.getLogin());
      var encodedPassword = passwordEncoder.encode(registrationForm.getPassword());
      accounts.setPassword(encodedPassword);
      return accountService.save(accounts);
    }
  }

}
