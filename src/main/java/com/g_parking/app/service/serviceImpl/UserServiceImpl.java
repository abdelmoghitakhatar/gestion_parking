package com.g_parking.app.service.serviceImpl;

import com.g_parking.app.domain.enumeration.ErrorMessage;
import com.g_parking.app.dto.customResponse.UserResponse;
import com.g_parking.app.domain.UserEntity;
import com.g_parking.app.dto.UserDTO;
import com.g_parking.app.repository.UserRepository;
import com.g_parking.app.service.UserService;
import com.g_parking.app.service.mapper.UserMapper;
import com.g_parking.app.web.exceptions.UserException;
import com.g_parking.app.web.utils.UserUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final UserUtils utils;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper, UserUtils utils) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.utils = utils;
    }

    @Override
    public UserResponse addUser(UserDTO userDTO) throws UserException {

      if(userRepository.findUserEntityByEmail(userDTO.getEmail()).isPresent()){
        throw new UserException(ErrorMessage.EMAIL_ALREADY_EXISTS.getMessage());
      }
      if(userRepository.findUserEntityByPhone(userDTO.getPhone()).isPresent()){
        throw new UserException(ErrorMessage.PHONE_ALREADY_EXISTS.getMessage());
      }

        userDTO.setUserName(utils.generateUserId());
        userDTO.setPassword(utils.getHashedPassword(userDTO.getPassword()));

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

  @Override
  public UserResponse getConnectedUser() {

    UserDTO user = utils.getConnectedUser();

    UserResponse response = new UserResponse();
    return response.dtoToResponse(user);
  }

  @Override
  public UserDTO getProfile() {

    UserDTO user = utils.getConnectedUser();
    user.setReservations(
      user.getReservations()
        .stream()
        // .filter(
        //   reservation -> (
        //     !reservation.isCanceled() &&
        //     reservation.getFacture() != null &&
        //     reservation.getDateFin().isAfter(LocalDateTime.now())
        //   )
        // )
        .collect(Collectors.toSet())
    );
    return user;
  }
}
