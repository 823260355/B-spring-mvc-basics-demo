package com.thoughtworks.capacity.gtb.demo4;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

//  @ExceptionHandler(CarNotFoundException.class)
//  @ResponseStatus(HttpStatus.NOT_FOUND)
//  @ResponseBody
//  public ErrorResult handle(CarNotFoundException ex) {
//    return new ErrorResult(ex.getMessage());
//  }

  @ExceptionHandler(CarNotFoundException.class)
  public ResponseEntity<ErrorResult> handle(CarNotFoundException ex) {
    ErrorResult errorResult = new ErrorResult(ex.getMessage());
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResult);
  }
}
