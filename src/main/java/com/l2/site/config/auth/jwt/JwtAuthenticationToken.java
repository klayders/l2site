package com.l2.site.config.auth.jwt;

import com.l2.site.model.jwt.JwtUser;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class JwtAuthenticationToken extends AbstractAuthenticationToken {

  private JwtUser activeUser;

  public JwtAuthenticationToken(JwtUser activeUser, Collection<? extends GrantedAuthority> roles) {
    super(roles);
    this.setAuthenticated(true);
    this.activeUser = activeUser;
  }


  @Override
  public Object getCredentials() {
    return activeUser.getRoles();
  }

  @Override
  public Object getPrincipal() {
    return activeUser;
  }
}
