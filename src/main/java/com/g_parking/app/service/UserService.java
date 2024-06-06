package com.g_parking.app.service;

import com.g_parking.app.dto.customResponse.UserResponse;
import com.g_parking.app.dto.UserDTO;

public interface UserService {

    UserResponse addUser(UserDTO userDTO);

    UserResponse findUserByEmail(String email);

    UserResponse getConnectedUser();

}
