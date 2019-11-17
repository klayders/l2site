package com.l2.site.config.auth;

import com.l2.site.config.auth.jwt.JwtService;
import com.l2.site.model.jwt.JwtUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;


@Slf4j
@Component
@RequiredArgsConstructor
public class AuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

  private final JwtService jwtService;
  @Value("${app.domain}")
  private String cookieDomain;

  @Override
  public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
    var session = (JwtUser) authentication.getPrincipal();
    var token = jwtService.createToken(session);

    setCookieAndHeaderWithJwtToken(response, token, cookieDomain);
  }

  @Override
  public void setRequestCache(RequestCache requestCache) {
  }

  private static final String COOKIE_PATH = "/";

  private static void setCookieAndHeaderWithJwtToken(HttpServletResponse httpResponse, String tokenValue, String domain) {
    var cookie = new Cookie(AUTHORIZATION, tokenValue);
    cookie.setPath(COOKIE_PATH);
    cookie.setDomain(domain);
    cookie.setMaxAge(60 * 60 * 24 * 14); // 14 days

    httpResponse.addCookie(cookie);
//    if need add headers
//    httpResponse.addHeader(AUTHORIZATION, tokenValue);
  }
}
