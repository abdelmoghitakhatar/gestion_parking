package com.g_parking.app.web.exceptions;

public class AuthenticationException extends RuntimeException{

  public AuthenticationException(String message) {
    super(message);
  }
}
