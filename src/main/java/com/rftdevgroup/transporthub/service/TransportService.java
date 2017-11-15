package com.rftdevgroup.transporthub.service;

import com.rftdevgroup.transporthub.data.dto.transport.TransportListViewDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TransportService {
    Page<TransportListViewDTO> listTransports(Pageable pageable);
}