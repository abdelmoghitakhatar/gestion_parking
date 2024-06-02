package com.g_parking.app.service;

import com.g_parking.app.dto.customResponse.UserResponse;
import com.g_parking.app.dto.UserDTO;

public interface UserService {

    public UserResponse addUser(UserDTO userDTO);

    public UserResponse findUserByEmail(String email);

    public UserResponse getConnectedUser();

}
