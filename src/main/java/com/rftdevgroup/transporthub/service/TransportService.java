package com.rftdevgroup.transporthub.service;

import com.rftdevgroup.transporthub.data.dto.transport.TransportViewDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TransportService {
    Page<TransportViewDTO> listTransports(Pageable pageable);
}