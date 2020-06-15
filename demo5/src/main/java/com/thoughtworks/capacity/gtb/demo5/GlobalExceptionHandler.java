package com.thoughtworks.capacity.gtb.demo5;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
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

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ErrorResult> handle(MethodArgumentNotValidException ex) {
    String message = ex.getBindingResult().getFieldError().getDefaultMessage();
    ErrorResult errorResult = new ErrorResult(message);
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResult);
  }

  @ExceptionHandler(ConstraintViolationException.class)
  public ResponseEntity<ErrorResult> handle(ConstraintViolationException ex) {
    Set<ConstraintViolation<?>> violations = ex.getConstraintViolations();

    String message = "";
    for (ConstraintViolation<?> constraint : ex.getConstraintViolations()) {
      message = constraint.getMessage();
      break;
    }
    ErrorResult errorResult = new ErrorResult(message);
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResult);
  }
}
