package com.carros.oasc.repositories;

import com.carros.oasc.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserModel, String> {
    boolean existsByLogin(String login);

    boolean existsByEmail(String email);

    UserModel findByLogin(String login);
}
