package com.rftdevgroup.transporthub.data.repository.transport;

import com.rftdevgroup.transporthub.data.model.transport.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CargoRepository extends JpaRepository<Cargo, Long> {
}
