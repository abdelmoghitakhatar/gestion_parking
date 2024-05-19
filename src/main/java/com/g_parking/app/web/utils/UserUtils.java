package com.g_parking.app.web.utils;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.Random;

@Component
public class UserUtils {

  private static final int LENGTHID = 32;

    private final Random RANDOM = new SecureRandom();
    private final String LEXICON = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

  private PasswordEncoder passwordEncoder;

  public UserUtils(PasswordEncoder passwordEncoder) {
    this.passwordEncoder = passwordEncoder;
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
}
