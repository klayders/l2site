package com.l2.site.config;

import com.l2.site.exception.RegistrationException;
import com.l2.site.model.ErrorResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;


@ControllerAdvice
@RestController
@AllArgsConstructor
@Slf4j
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

  @ResponseStatus(value = HttpStatus.FORBIDDEN)
  @ExceptionHandler(value = RegistrationException.class)
  public ErrorResponse registrationException(HttpServletRequest request,
                                             RegistrationException exception) {
//    String message = context.getMessage(exception.getMessage(), null, Locale.getDefault());
    var message = exception.getMessage();
    log.warn("registrationException: exception={}, request url={}, query={}", message, request.getRequestURI(), request.getQueryString());
    return ErrorResponse.of(exception.getClass().getSimpleName(), message);
  }


}
