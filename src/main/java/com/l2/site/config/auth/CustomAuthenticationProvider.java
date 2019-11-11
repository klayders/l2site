package com.l2.site.config.auth;


import com.l2.site.account.AccountService;
import com.l2.site.config.auth.jwt.JwtAuthenticationToken;
import com.l2.site.model.jwt.JwtUser;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Component
@Slf4j
@AllArgsConstructor
public class CustomAuthenticationProvider implements AuthenticationProvider {

  private static final String USER_ROLE = "USER";
  private static final List<SimpleGrantedAuthority> ROLES = Collections.singletonList(new SimpleGrantedAuthority(USER_ROLE));
  private final AccountService accountService;

  @Bean
  public BCryptPasswordEncoder encoder() {
    return new BCryptPasswordEncoder();
  }


  @Override
  @Transactional(readOnly = true)
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    String username = authentication.getPrincipal() + "";
    String password = authentication.getCredentials() + "";

    var account = accountService.findByl2Email(username);

    if (!encoder().matches(password, account.getPassword())) {
      throw new BadCredentialsException("form.error.bad.credentials");
    }
    var session = JwtUser.builder()
      .displayName(account.getL2email())
      .build();
    return new JwtAuthenticationToken(session, ROLES);
  }

  @Override
  public boolean supports(Class<?> aClass) {
    return aClass.equals(UsernamePasswordAuthenticationToken.class);
  }


}
