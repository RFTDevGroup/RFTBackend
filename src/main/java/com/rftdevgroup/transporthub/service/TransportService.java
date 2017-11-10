package com.rftdevgroup.transporthub.service;

import com.rftdevgroup.transporthub.data.dto.transport.TransportDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface TransportService {
    Page<TransportDTO> listTransports(Pageable pageable);
}
