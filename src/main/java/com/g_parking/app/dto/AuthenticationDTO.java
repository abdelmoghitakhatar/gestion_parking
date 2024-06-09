package com.g_parking.app.dto;

import com.g_parking.app.domain.enumeration.ErrorConstants;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class AuthenticationDTO {

  @Email(message = ErrorConstants.EMAIL_ERROR)
  @NotNull(message = ErrorConstants.NULL_ERROR)
  @Size(min = 5, message = ErrorConstants.MIN_ERROR)
  @Size(max = 254, message = ErrorConstants.MAX_ERROR)
  private String email;

  @NotNull(message = ErrorConstants.NULL_ERROR)
  @Size(min = 8, message = ErrorConstants.MIN_ERROR)
  private String password;

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
