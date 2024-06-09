package com.g_parking.app.dto.customResponse;

import java.util.Date;

public class ErrorMessageResponse {

  private Date timestamp;
  private String message;
  private String errorPosition;

  public ErrorMessageResponse(String message, String errorPosition) {
    this.message = message;
    this.errorPosition = errorPosition;
    this.timestamp = new Date();
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Date getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Date timestamp) {
    this.timestamp = timestamp;
  }

  public String getErrorPosition() {
    return errorPosition;
  }

  public void setErrorPosition(String errorPosition) {
    this.errorPosition = errorPosition;
  }
}
