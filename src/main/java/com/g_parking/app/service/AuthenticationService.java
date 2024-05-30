package com.g_parking.app.service;


import com.g_parking.app.dto.AuthenticationDTO;

public interface AuthenticationService {

  String authenticate(AuthenticationDTO auth);
}
