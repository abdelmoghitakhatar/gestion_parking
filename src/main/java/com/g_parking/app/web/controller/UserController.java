package com.g_parking.app.web.controller;

import com.g_parking.app.dto.customResponse.UserResponse;
import com.g_parking.app.dto.UserDTO;
import com.g_parking.app.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/message")
    public String getMessage(){
        return "Hello World!\n it works";
    }

    @PostMapping("/signin")
    public UserResponse signin(@RequestBody UserDTO userDTO){
        if(userDTO.getId() != null) {
            throw new ResponseStatusException(HttpStatus.ALREADY_REPORTED);
        }
        return userService.addUser(userDTO);
    }

    @GetMapping("/profile/{email}")
    public UserResponse getUserInfo(@PathVariable String email){
        UserResponse response = userService.findUserByEmail(email);
        if(response == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return response;
    }
}
