package com.l2.site.config.auth;

import lombok.AllArgsConstructor;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@Component
@AllArgsConstructor
public class FailureHandler implements AuthenticationFailureHandler {

  @Override
  public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
    Cookie jsessionid = new Cookie("JSESSIONID", null);
    Cookie authorized = new Cookie(AUTHORIZATION, null);

    jsessionid.setMaxAge(0);
    jsessionid.setPath("/");

    response.setCharacterEncoding("UTF-8");
    response.setContentType("application/json; charset=utf-8");
    response.setStatus(401);
    response.addCookie(jsessionid);
    response.addCookie(authorized);

    PrintWriter writer = response.getWriter();
    writer.flush();
  }
}
