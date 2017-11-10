package com.rftdevgroup.transporthub.service;

import com.rftdevgroup.transporthub.data.dto.transport.TransportDTO;
import java.util.List;

public interface TransportService {
    List<TransportDTO> listTransports();
}
