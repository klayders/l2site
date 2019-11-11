package com.l2.site.config;

import com.l2.site.config.auth.AuthenticationSuccessHandler;
import com.l2.site.config.auth.CustomAuthenticationProvider;
import com.l2.site.config.auth.FailureHandler;
import com.l2.site.config.auth.LogoutHandler;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Slf4j
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
@AllArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  private final CustomAuthenticationProvider customAuthenticationProvider;
  private final AuthenticationSuccessHandler successHandler;
  private final FailureHandler failureHandler;
  private final LogoutHandler defaultLogoutHandler;

  @Override
  protected AuthenticationManager authenticationManager() throws Exception {
    return super.authenticationManager();
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
      .authorizeRequests()
      .and().headers()
      .frameOptions().sameOrigin()
      .and().formLogin()
      .loginPage("/login")
      .permitAll()
      .successHandler(successHandler)
      .failureHandler(failureHandler)
      .and()
      .csrf().disable()

      .logout()
      .logoutUrl("/logout")
      .logoutSuccessUrl("/")
      .logoutSuccessHandler(defaultLogoutHandler)
      .invalidateHttpSession(true)
      .permitAll();
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) {
    auth.authenticationProvider(customAuthenticationProvider);
  }

}

