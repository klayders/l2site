package com.l2.site.config;

import com.l2.site.model.user.User;
import com.l2.site.user.UserDetailsRepository;
import org.springframework.boot.autoconfigure.security.oauth2.resource.PrincipalExtractor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import java.time.LocalDateTime;

//@Configuration
//@EnableWebSecurity
//@EnableOAuth2Sso
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
      .antMatcher("/**")
      .authorizeRequests()
      .antMatchers("/", "/login**", "/js/**", "/error**").permitAll()
      .anyRequest().authenticated()
      .and().logout().logoutSuccessUrl("/").permitAll()
      .and()
      .csrf().disable();
  }

  @Bean
  public PrincipalExtractor principalExtractor(UserDetailsRepository userDetailsRepository) {
    return map -> {
      String id = (String) map.get("sub");
      User user = userDetailsRepository.findById(id).orElseGet(() -> {
        User newUser = new User();
        newUser.setId(id);
        newUser.setName((String) map.get("name"));
        newUser.setEmail((String) map.get("email"));
        newUser.setGender((String) map.get("gender"));
        newUser.setLocale((String) map.get("locale"));
        newUser.setUserpic((String) map.get("picture"));

        return newUser;
      });
      user.setLastVisit(LocalDateTime.now());
      return userDetailsRepository.save(user);
    };
  }

}
