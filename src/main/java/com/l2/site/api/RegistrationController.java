package com.l2.site.api;

import com.l2.site.account.AccountService;
import com.l2.site.exception.GoogleCaptchaError;
import com.l2.site.exception.RegistrationException;
import com.l2.site.model.CaptchaResponse;
import com.l2.site.model.account.Account;
import com.l2.site.model.account.AccountSnapshot;
import com.l2.site.model.account.RegistrationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/registration")
public class RegistrationController {

  private static final String GOOGLE_CAPTCHA_VALIDATE = "https://www.google.com/recaptcha/api/siteverify?secret=%s&response=%s";

  @Value("${app.captcha.secret}")
  private String secret;

  private final AccountService accountService;
  private final BCryptPasswordEncoder passwordEncoder;
  private final RestTemplate restTemplate;

  @PostMapping
  public AccountSnapshot registration(@RequestBody RegistrationRequest registrationForm) {

    String url = String.format(GOOGLE_CAPTCHA_VALIDATE, secret, registrationForm.getCaptcha());
    CaptchaResponse response = restTemplate.postForObject(url, Collections.emptyList(), CaptchaResponse.class);

    if (response == null || !response.isSuccess()) {
      throw new GoogleCaptchaError("заполни каптчу");
    }


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
