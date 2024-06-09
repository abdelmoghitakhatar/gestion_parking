package com.g_parking.app.security.user_details;

import com.g_parking.app.domain.UserEntity;
import com.g_parking.app.domain.enumeration.ErrorMessage;
import com.g_parking.app.repository.UserRepository;
import com.g_parking.app.web.exceptions.CustomAuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

  private final UserRepository userRepository;

  public CustomUserDetailsService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws CustomAuthenticationException {

    Optional<UserEntity> user = userRepository.findUserEntityByEmail(username);
    if(user.isEmpty()) {
      throw new CustomAuthenticationException(ErrorMessage.USER_NOT_FOUND.getMessage());
    }
    Collection<GrantedAuthority> authorities = new ArrayList<>();

    return new User(user.get().getEmail(), user.get().getPassword(), authorities);
  }
}
