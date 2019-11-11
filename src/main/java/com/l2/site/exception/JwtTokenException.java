package com.l2.site.exception;

public class JwtTokenException extends RuntimeException {

  public JwtTokenException(String message) {
    super(message);
  }
}
