package com.rftdevgroup.transporthub.data.repository;

import com.rftdevgroup.transporthub.data.model.user.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepository extends JpaRepository<UserDetails, Long> {
}
