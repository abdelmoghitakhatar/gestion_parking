package com.g_parking.app.web.controller;

import com.g_parking.app.domain.enumeration.ErrorMessage;
import com.g_parking.app.dto.customResponse.UserResponse;
import com.g_parking.app.dto.UserDTO;
import com.g_parking.app.service.UserService;
import com.g_parking.app.web.exceptions.UserException;
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
    public ResponseEntity<UserResponse> getUserInfo(){
        UserResponse response = userService.getConnectedUser();
        if(response == null){
            throw new UserException(ErrorMessage.USER_NOT_FOUND.getMessage());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
