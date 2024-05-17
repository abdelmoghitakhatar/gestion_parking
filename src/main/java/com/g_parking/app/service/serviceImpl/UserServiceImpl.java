package com.g_parking.app.service.serviceImpl;

import com.g_parking.app.dto.customResponse.UserResponse;
import com.g_parking.app.domain.UserEntity;
import com.g_parking.app.dto.UserDTO;
import com.g_parking.app.repository.UserRepository;
import com.g_parking.app.service.UserService;
import com.g_parking.app.service.mapper.UserMapper;
import com.g_parking.app.web.utils.UserUtils;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    private static final int LENGTHID = 32;

    private UserRepository userRepository;
    private UserMapper userMapper;
    private PasswordEncoder passwordEncoder;
    private UserUtils utils;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper, PasswordEncoder passwordEncoder, UserUtils utils) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
        this.utils = utils;
    }

    @Override
    public UserResponse addUser(UserDTO userDTO) {

        userDTO.setGeneratedId(utils.generateUserId(LENGTHID));
        userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));

        UserEntity user = userMapper.toEntity(userDTO);

        user = userRepository.save(user);

        UserResponse response = new UserResponse();

        return response.dtoToResponse(userMapper.toDto(user));
    }

    @Override
    public UserResponse findUserByEmail(String email) {

        Optional<UserEntity> user = userRepository.findUserEntityByEmail(email);
        if(user.isPresent()){

            UserResponse response = new UserResponse();
            return response.dtoToResponse(userMapper.toDto(user.get()));
        }
        return null;
    }
}
