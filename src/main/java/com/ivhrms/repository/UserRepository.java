package com.ivhrms.repository;

import com.ivhrms.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByLoginId(String loginId);
    void deleteByLoginId(String loginId);
}
