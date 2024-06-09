package com.g_parking.app.web.exceptions.error_manipulation;

import com.g_parking.app.dto.customResponse.ErrorMessageResponse;
import com.g_parking.app.web.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.View;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionHandlerMessage {

  private final View error;

  public ExceptionHandlerMessage(View error) {
    this.error = error;
  }

  @ExceptionHandler(value = UserException.class)
  public ResponseEntity<Object> userExceptionHandler(UserException exception, WebRequest request){
    ErrorMessageResponse response = new ErrorMessageResponse(exception.getMessage(), "user information");
    return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(value = ParkingException.class)
  public ResponseEntity<Object> parkingExceptionHandler(ParkingException exception, WebRequest request){
    ErrorMessageResponse response = new ErrorMessageResponse(exception.getMessage(), "parking information");
    return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(value = ReservationException.class)
  public ResponseEntity<Object> reservationExceptionHandler(ReservationException exception, WebRequest request){
    ErrorMessageResponse response = new ErrorMessageResponse(exception.getMessage(), "reservation information");
    return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(value = AuthenticationException.class)
  public ResponseEntity<Object> authenticationExceptionHandler(AuthenticationException exception, WebRequest request){
    ErrorMessageResponse response = new ErrorMessageResponse(exception.getMessage(), "auth information");
    return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(value = VehicleException.class)
  public ResponseEntity<Object> vehicleExceptionHandler(VehicleException exception, WebRequest request){
    ErrorMessageResponse response = new ErrorMessageResponse(exception.getMessage(), "vehicle information");
    return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(value = MethodArgumentNotValidException.class)
  public ResponseEntity<Object> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException exception, WebRequest request){

    Map<String, String> response = new HashMap<>();

    exception.getBindingResult().getFieldErrors().forEach(
      error -> response.put(error.getField(), error.getDefaultMessage())
    );

    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(value = Exception.class)
  public ResponseEntity<Object> ExceptionHandler(Exception exception, WebRequest request){
    ErrorMessageResponse response = new ErrorMessageResponse(exception.getMessage(), "unknown place");
    return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
