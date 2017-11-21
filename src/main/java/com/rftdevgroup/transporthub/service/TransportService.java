package com.rftdevgroup.transporthub.service;

import com.rftdevgroup.transporthub.data.dto.transport.TransportCreateDTO;
import com.rftdevgroup.transporthub.data.dto.transport.TransportListViewDTO;
import com.rftdevgroup.transporthub.data.model.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TransportService {
    Page<TransportListViewDTO> listTransports(Pageable pageable);
    boolean save(TransportCreateDTO createDTO, User owner);
    boolean delete(long id, User user);
    boolean adminDelete(long id);
}