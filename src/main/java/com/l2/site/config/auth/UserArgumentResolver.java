package com.l2.site.config.auth;


import com.l2.site.config.auth.jwt.JwtService;
import com.l2.site.exception.JwtTokenException;
import com.l2.site.model.jwt.CurrentUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;


@Slf4j
@Component
@RequiredArgsConstructor
public class UserArgumentResolver implements HandlerMethodArgumentResolver {


  private final JwtService jwtService;

  @Override
  public boolean supportsParameter(MethodParameter methodParameter) {
    return methodParameter.hasParameterAnnotation(CurrentUser.class);
  }

  @Override
  public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) {
    CurrentUser annotation = parameter.getParameterAnnotation(CurrentUser.class);
    var httpServletRequest = (HttpServletRequest) nativeWebRequest.getNativeRequest();
    var token = getToken(httpServletRequest);

    if (annotation != null) {

      if (!StringUtils.isEmpty(token)) {
        var user = jwtService.verifyAndGetCurrentUser(token);
        if (user != null) {
//          addUserOnlineStatus(user);
          return user;
        } else if (!annotation.required()) {
          return null;
        } else {
          throw new JwtTokenException("auth.wrong.jwt");
        }
      } else {
        if (!annotation.required()) {
          return null;
        } else {
          throw new JwtTokenException("auth.wrong.jwt");
        }
      }

    } else {
      log.warn("resolveArgument: wrong token ={}", token);
      throw new JwtTokenException("auth.wrong.jwt");
    }
  }

  private static String getToken(HttpServletRequest httpServletRequest) {
    var cookie = WebUtils.getCookie(httpServletRequest, AUTHORIZATION);
    if (cookie != null) {
      return cookie.getValue();
    }
    return httpServletRequest.getHeader(AUTHORIZATION);
  }
//  private void addUserOnlineStatus(JwtUser activeUser) {
//    Objects.requireNonNull(cacheManager.getCache(CACHE_NAME)).put(String.valueOf(activeUser.getId()), activeUser.getId());
//  }


}

