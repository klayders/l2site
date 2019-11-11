package com.l2.site.config.auth;

import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LogoutHandler extends SimpleUrlLogoutSuccessHandler {


  @Override
  protected String determineTargetUrl(HttpServletRequest request,
                                      HttpServletResponse response) {
    setTargetUrlParameter("targetUrl");
    setDefaultTargetUrl("/login");
    return super.determineTargetUrl(request, response);
  }

}
