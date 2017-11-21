package com.rftdevgroup.transporthub.data.repository.user;

import com.rftdevgroup.transporthub.data.model.user.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
