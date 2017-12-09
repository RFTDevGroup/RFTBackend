package com.rftdevgroup.transporthub.data.repository.transport;

import com.rftdevgroup.transporthub.data.model.transport.Transport;
import com.rftdevgroup.transporthub.data.model.user.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import java.util.List;

public interface TransportRepository extends PagingAndSortingRepository<Transport, Long> {
    List<Transport> findAllByOwner(User owner);
}
