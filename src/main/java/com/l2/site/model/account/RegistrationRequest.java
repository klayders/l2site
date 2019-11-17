package com.l2.site.model.account;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RegistrationRequest {
  private String login;
  private String password;
  private String captcha;
}
