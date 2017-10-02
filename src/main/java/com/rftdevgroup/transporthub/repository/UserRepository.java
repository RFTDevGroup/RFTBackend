package com.rftdevgroup.transporthub.repository;

import com.rftdevgroup.transporthub.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
