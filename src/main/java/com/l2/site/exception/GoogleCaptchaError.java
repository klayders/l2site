package com.l2.site.exception;


public class GoogleCaptchaError extends RuntimeException {
  public GoogleCaptchaError(String message) {
    super(message);
  }
}
