package com.g_parking.app.domain.enumeration;

public enum ErrorMessage {

  USER_NOT_FOUND("username not found!"),
  INCORRECT_EMAIL_OR_PASSWORD("incorrect username or password!"),
  NULL_EMAIL_OR_PASSWORD("null username or password!"),
  UNACCEPTED_USER("unaccepted user information!"),

  VEHICLE_NOT_FOUND("vehicle not found!"),
  VEHICLE_NOT_ACCEPTED("vehicle not accepted!"),

  RESERVATION_NOT_FOUND("reservation not found!"),
  RESERVATION_NOT_ACCEPTED("reservation not accepted!"),
  RESERVATION_ALREADY_PAYED("reservation already has a facture!"),
  RESERVATION_ALREADY_CANCELED("reservation already canceled!"),

  UNAVAILABLE_PLACE("unavailable place!"),
  PLACE_NOT_FOUND("place not found!"),
  PLACE_NOT_ACCEPTED("place not accepted!"),

  UPDATE_NOT_ACCEPTED("update not accepted!");

  private String message;

  ErrorMessage(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
