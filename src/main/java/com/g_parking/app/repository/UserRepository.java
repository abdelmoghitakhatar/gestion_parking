package com.g_parking.app.repository;

import com.g_parking.app.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findUserEntityByEmail(String email);

  Optional<UserEntity> findUserEntityByUserName(String userId);

  Optional<UserEntity> findUserEntityByPhone(String phone);

}
