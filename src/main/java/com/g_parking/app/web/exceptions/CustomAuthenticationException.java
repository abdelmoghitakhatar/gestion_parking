package com.g_parking.app.web.exceptions;

public class CustomAuthenticationException extends RuntimeException{

  public CustomAuthenticationException(String message) {
    super(message);
  }
}
