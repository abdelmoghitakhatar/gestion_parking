package com.g_parking.app.web.controller;

import com.g_parking.app.domain.UserEntity;
import com.g_parking.app.dto.AuthenticationDTO;
import com.g_parking.app.dto.UserDTO;
import com.g_parking.app.dto.customResponse.UserResponse;
import com.g_parking.app.security.config.SecurityConstants;
import com.g_parking.app.service.AuthenticationService;
import com.g_parking.app.service.UserService;
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
  public ResponseEntity<String> login(@RequestBody AuthenticationDTO user){
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.set(
      SecurityConstants.AUTHORIZATION_HEADER,
      SecurityConstants.PREFIX_TOKEN + authenticationService.authenticate(user)
    );
    return new ResponseEntity<>(httpHeaders, HttpStatus.OK);
  }

  @PostMapping("/signup")
  public UserResponse signup(@RequestBody UserDTO userDTO){
    if(userDTO.getId() != null) {
      throw new RuntimeException("User not accepted");
    }
    if(userService.findUserByEmail(userDTO.getEmail()) != null){
      throw new RuntimeException("User already exists");
    }
    return userService.addUser(userDTO);
  }
}
