package com.rftdevgroup.transporthub.data.repository;

import com.rftdevgroup.transporthub.data.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

/**
 * Spring {@link JpaRepository} for storing {@link User} objects.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByUserName(String username);
}
