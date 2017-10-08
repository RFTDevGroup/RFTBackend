package com.rftdevgroup.transporthub.data.repository;

import com.rftdevgroup.transporthub.data.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByUserName(String username);
}
