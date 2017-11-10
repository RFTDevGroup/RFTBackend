package com.rftdevgroup.transporthub.data.repository.user;

import com.rftdevgroup.transporthub.data.model.user.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
