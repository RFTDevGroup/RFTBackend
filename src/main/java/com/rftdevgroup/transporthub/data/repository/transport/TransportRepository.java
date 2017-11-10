package com.rftdevgroup.transporthub.data.repository.transport;

import com.rftdevgroup.transporthub.data.model.transport.Transport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransportRepository extends JpaRepository<Transport, Long>{
}
