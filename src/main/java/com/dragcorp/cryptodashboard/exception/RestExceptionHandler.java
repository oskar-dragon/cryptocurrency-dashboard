package com.dragcorp.cryptodashboard.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice
public class RestExceptionHandler {
  Logger logger = LoggerFactory.getLogger(RestExceptionHandler.class);

  @ExceptionHandler(HttpClientErrorException.class)
  public void handleHttpClientErrorException(HttpClientErrorException exception,
                                             HttpServletResponse response) throws IOException {
    response.sendError(exception.getStatusCode().value(), exception.getMessage());
  }
}
