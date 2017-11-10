package com.rftdevgroup.transporthub.data.repository.transport;

import com.rftdevgroup.transporthub.data.model.transport.Transport;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TransportRepository extends PagingAndSortingRepository<Transport, Long> {
}
