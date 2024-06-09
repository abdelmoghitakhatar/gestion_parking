package com.g_parking.app.web.exceptions.error_manipulation;

import com.g_parking.app.dto.customResponse.ErrorMessageResponse;
import com.g_parking.app.web.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionHandlerMessage {

  @ExceptionHandler(value = UserException.class)
  public ResponseEntity<Object> userExceptionHandler(UserException exception){
    ErrorMessageResponse response = new ErrorMessageResponse(exception.getMessage(), "user information");
    return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(value = ParkingException.class)
  public ResponseEntity<Object> parkingExceptionHandler(ParkingException exception){
    ErrorMessageResponse response = new ErrorMessageResponse(exception.getMessage(), "parking information");
    return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(value = ReservationException.class)
  public ResponseEntity<Object> reservationExceptionHandler(ReservationException exception){
    ErrorMessageResponse response = new ErrorMessageResponse(exception.getMessage(), "reservation information");
    return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(value = {CustomAuthenticationException.class, AuthenticationException.class})
  public ResponseEntity<Object> authenticationExceptionHandler(Exception exception){
    ErrorMessageResponse response = new ErrorMessageResponse(exception.getMessage(), "authentication information");
    return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(value = VehicleException.class)
  public ResponseEntity<Object> vehicleExceptionHandler(VehicleException exception){
    ErrorMessageResponse response = new ErrorMessageResponse(exception.getMessage(), "vehicle information");
    return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(value = NoHandlerFoundException.class)
  public ResponseEntity<Object> noHandlerFoundException(NoHandlerFoundException exception){
    ErrorMessageResponse response = new ErrorMessageResponse(exception.getMessage(), "URI not found");
    return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(value = MethodArgumentNotValidException.class)
  public ResponseEntity<Object> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException exception){

    Map<String, String> response = new HashMap<>();

    exception.getBindingResult().getFieldErrors().forEach(
      error -> response.put(error.getField(), error.getDefaultMessage())
    );

    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(value = Exception.class)
  public ResponseEntity<Object> ExceptionHandler(Exception exception){
    ErrorMessageResponse response = new ErrorMessageResponse(exception.getMessage(), "unknown place");
    return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
