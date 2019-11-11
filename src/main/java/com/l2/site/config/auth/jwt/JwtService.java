package com.l2.site.config.auth.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.l2.site.model.jwt.JwtUser;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Calendar;
import java.util.Date;


@Slf4j
@Component
@ConfigurationProperties(prefix = "app.jwt")
public class JwtService {

  private static final String SERVICE_ISSUER_NAME = "lineage-2-site";
  @Setter
  private String secret;
  @Setter
  private Integer expirationDays;


  private JWTVerifier jwtVerifier;
  private Algorithm algorithm;

  @PostConstruct
  public void init() {
    algorithm = Algorithm.HMAC256(secret);
    jwtVerifier = JWT.require(algorithm).build();
  }


  public String createToken(JwtUser jwtUser) {

    var calendar = Calendar.getInstance();
    calendar.setTime(new Date());
    calendar.add(Calendar.DAY_OF_YEAR, expirationDays);

    var expirationDate = calendar.getTime();

    return JWT.create()
      .withIssuer(SERVICE_ISSUER_NAME)
      .withClaim("displayName", jwtUser.getDisplayName())
//      .withClaim("id", jwtUser.getId())
//      .withArrayClaim("roles", jwtUser.getRoles().toArray(new String[]{}))
      .withExpiresAt(expirationDate)
      .sign(algorithm);
  }


  public JwtUser verifyAndGetCurrentUser(String jwtToken) {
    try {
      var decodedJWT = jwtVerifier.verify(jwtToken);
      var displayName = decodedJWT.getClaim("displayName").asString();
//      var userId = decodedJWT.getClaim("id").asLong();
//      var roles = decodedJWT.getClaim("roles").asList(String.class);
      var current = JwtUser.of(displayName);
      log.debug("verifyAndGetCurrentUser: jwtUser ={}", current);
      return current;
    } catch (Exception e) {
      log.debug("verifyAndGetCurrentUser: parse token exception is ={}", e.getMessage());
      return null;
    }
  }


}


