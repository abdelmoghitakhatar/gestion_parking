package com.g_parking.app.web.utils;

import com.g_parking.app.domain.UserEntity;
import com.g_parking.app.dto.UserDTO;
import com.g_parking.app.repository.UserRepository;
import com.g_parking.app.service.UserService;
import com.g_parking.app.service.mapper.UserMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.Optional;
import java.util.Random;

@Component
public class UserUtils {

  private static final int LENGTHID = 32;

    private final Random RANDOM = new SecureRandom();
    private final String LEXICON = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

  private final PasswordEncoder passwordEncoder;
  private final UserRepository userRepository;
  private final UserMapper userMapper;

  public UserUtils(PasswordEncoder passwordEncoder, UserRepository userRepository, UserMapper userMapper) {
    this.passwordEncoder = passwordEncoder;
    this.userRepository = userRepository;
    this.userMapper = userMapper;
  }

  public String generateUserId(){
        StringBuilder generatedValue = new StringBuilder(LENGTHID);
        for (int i=0 ; i<LENGTHID ; i++){
            generatedValue.append(LEXICON.charAt(RANDOM.nextInt(LEXICON.length())));
        }
        return generatedValue.toString();
    }

    public String getHashedPassword(String password){
      return passwordEncoder.encode(password);
    }

  public UserDTO getConnectedUser() {
    Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    String userEmail;
    if (principal instanceof UserDetails) {
      userEmail = ((UserDetails) principal).getUsername();
    } else {
      userEmail = principal.toString();
    }
    Optional<UserEntity> user = userRepository.findUserEntityByEmail(userEmail);
    return user.map(userMapper::toDto).orElse(null);
  }
}
