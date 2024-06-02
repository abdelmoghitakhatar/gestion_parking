package com.g_parking.app.web.controller;

import com.g_parking.app.dto.customResponse.UserResponse;
import com.g_parking.app.dto.UserDTO;
import com.g_parking.app.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/profile")
    public UserResponse getUserInfo(){
        UserResponse response = userService.getConnectedUser();
        if(response == null){
            throw new RuntimeException("User not found");
        }
        return response;
    }
}
