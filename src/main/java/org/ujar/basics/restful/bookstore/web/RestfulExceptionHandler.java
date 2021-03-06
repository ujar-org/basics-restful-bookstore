package org.ujar.basics.restful.bookstore.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.ujar.basics.restful.bookstore.exception.EntityNotFoundException;
import org.ujar.basics.restful.bookstore.web.dto.ErrorResponse;
import org.ujar.boot.starter.restful.web.DefaultRestfulErrorHandler;

@RestControllerAdvice
public class RestfulExceptionHandler extends DefaultRestfulErrorHandler {

  @ExceptionHandler(EntityNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ErrorResponse entityNotFoundException(EntityNotFoundException exception) {
    return ErrorResponse.singleError(exception);
  }
}
