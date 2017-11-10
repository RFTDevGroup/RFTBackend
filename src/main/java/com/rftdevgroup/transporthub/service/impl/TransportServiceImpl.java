package com.rftdevgroup.transporthub.service.impl;

import com.rftdevgroup.transporthub.data.dto.transport.TransportDTO;
import com.rftdevgroup.transporthub.data.repository.transport.TransportRepository;
import com.rftdevgroup.transporthub.service.TransportService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransportServiceImpl implements TransportService {

    @Autowired
    private TransportRepository transportRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Page<TransportDTO> listTransports(Pageable pageable) {
        return transportRepository.findAll(pageable).map(t -> modelMapper.map(t, TransportDTO.class));
    }
}
