package com.g_parking.app.web.controller;

import com.g_parking.app.domain.enumeration.ErrorMessage;
import com.g_parking.app.dto.AuthenticationDTO;
import com.g_parking.app.dto.UserDTO;
import com.g_parking.app.dto.customResponse.JWTTokenResponse;
import com.g_parking.app.dto.customResponse.UserResponse;
import com.g_parking.app.security.config.SecurityConstants;
import com.g_parking.app.service.AuthenticationService;
import com.g_parking.app.service.UserService;
import com.g_parking.app.web.exceptions.UserException;
import jakarta.validation.Valid;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class AuthenticationController {

  private final UserService userService;
  private final AuthenticationService authenticationService;

  public AuthenticationController(UserService userService, AuthenticationService authenticationService) {
    this.userService = userService;
    this.authenticationService = authenticationService;
  }

  @PostMapping("/login")
  public ResponseEntity<JWTTokenResponse> login(@RequestBody @Valid AuthenticationDTO user){
    HttpHeaders httpHeaders = new HttpHeaders();
    String token = authenticationService.authenticate(user);
    httpHeaders.set(
      SecurityConstants.AUTHORIZATION_HEADER,
      SecurityConstants.PREFIX_TOKEN + token
    );
    return new ResponseEntity<>(new JWTTokenResponse(token), httpHeaders, HttpStatus.OK);
  }

  @PostMapping("/signup")
  public ResponseEntity<UserResponse> signup(@RequestBody @Valid UserDTO userDTO) throws UserException{
    if(userDTO.getId() != null) {
      throw new UserException(ErrorMessage.UNACCEPTED_USER.getMessage());
    }
    return new ResponseEntity<>(userService.addUser(userDTO), HttpStatus.CREATED);
  }
}
