package com.rftdevgroup.transporthub.data.repository;

import com.rftdevgroup.transporthub.data.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
