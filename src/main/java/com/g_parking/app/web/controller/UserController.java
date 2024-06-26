package com.g_parking.app.web.controller;

import com.g_parking.app.dto.UserDTO;
import com.g_parking.app.dto.customResponse.UserResponse;
import com.g_parking.app.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/profile")
  public ResponseEntity<UserDTO> getUserInfo(){
    UserDTO response = userService.getProfile();
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @GetMapping("/my-profile")
  public ResponseEntity<UserResponse> getUserProfile(){
    UserResponse response = userService.getConnectedUser();
    return new ResponseEntity<>(response, HttpStatus.OK);
  }
}
