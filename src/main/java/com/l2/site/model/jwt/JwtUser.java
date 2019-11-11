package com.l2.site.model.jwt;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JwtUser implements Serializable {
  private String displayName;
  private List<String> roles = List.of("USER");

  public static JwtUser of(String displayName) {
    return JwtUser.builder()
      .displayName(displayName)
      .build();
  }
}
