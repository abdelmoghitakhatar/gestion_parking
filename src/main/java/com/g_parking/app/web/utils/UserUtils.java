package com.g_parking.app.web.utils;

import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.Random;

@Component
public class UserUtils {

    private final Random RANDOM = new SecureRandom();
    private final String LEXICON = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public String generateUserId(int length){
        StringBuilder generatedValue = new StringBuilder(length);
        for (int i=0 ; i<length ; i++){
            generatedValue.append(LEXICON.charAt(RANDOM.nextInt(LEXICON.length())));
        }
        return generatedValue.toString();
    }
}
