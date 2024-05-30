package com.g_parking.app.service.serviceImpl;

import com.g_parking.app.dto.AuthenticationDTO;
import com.g_parking.app.security.jwt.JwtProvider;
import com.g_parking.app.service.AuthenticationService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AuthenticationServiceImpl implements AuthenticationService {

  private final AuthenticationManager authenticationManager;
  private final JwtProvider jwtProvider;

  public AuthenticationServiceImpl(AuthenticationManager authenticationManager, JwtProvider jwtProvider) {
    this.authenticationManager = authenticationManager;
    this.jwtProvider = jwtProvider;
  }

  @Override
  public String authenticate(AuthenticationDTO user) {
    if(user!=null && user.getUsername()!=null && user.getPassword()!=null) {
      Authentication authentication = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
      );
      SecurityContextHolder.getContext().setAuthentication(authentication);
      return jwtProvider.generateToken(authentication);
    }
    throw new RuntimeException("null username or password");
  }
}
