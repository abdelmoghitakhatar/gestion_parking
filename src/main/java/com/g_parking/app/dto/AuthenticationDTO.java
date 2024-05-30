package com.g_parking.app.dto;

public class AuthenticationDTO {

  private String username;

  private String Password;

  public String getPassword() {
    return Password;
  }

  public void setPassword(String password) {
    Password = password;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }
}
