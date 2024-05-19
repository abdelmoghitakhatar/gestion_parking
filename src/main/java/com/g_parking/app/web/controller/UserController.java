package com.g_parking.app.web.controller;

import com.g_parking.app.domain.UserEntity;
import com.g_parking.app.dto.customResponse.UserResponse;
import com.g_parking.app.dto.UserDTO;
import com.g_parking.app.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signin")
    public UserResponse signin(@RequestBody UserDTO userDTO){
        if(userDTO.getId() != null) {
            throw new RuntimeException("User not accepted");
        }
        if(userService.findUserByEmail(userDTO.getEmail()) != null){
            throw new RuntimeException("User already exists");
        }
        return userService.addUser(userDTO);
    }

    @GetMapping("/{userName}")
    public UserResponse getUserInfo(@PathVariable String userName){
        UserResponse response = userService.findUserByUserName(userName);
        if(response == null){
            throw new RuntimeException("User not found");
        }
        return response;
    }
}
