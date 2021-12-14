package com.appsdeveloperblog.rentalapp.api.users.rentalappapiusers.dataAccess;

import com.appsdeveloperblog.rentalapp.api.users.rentalappapiusers.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<UserEntity, Integer> {

    UserEntity getByEmail(String email);
    boolean existsByEmail(String email);
    boolean existsById(int userId);

    UserEntity findByEmail(String email);

}
