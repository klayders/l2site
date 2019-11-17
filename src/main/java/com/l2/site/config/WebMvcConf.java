package com.l2.site.config;

import com.l2.site.config.auth.UserArgumentResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class WebMvcConf implements WebMvcConfigurer {

  private final UserArgumentResolver userArgumentResolver;

  /**
   * возращает заданную страничку, если статус 404
   */
  @Bean
  public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> webServerCustomizer() {
    return container -> {
      container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/"));
    };
  }

  @Override
  public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
    resolvers.add(userArgumentResolver);
  }
}
