package com.rftdevgroup.transporthub.service.impl;

import com.rftdevgroup.transporthub.data.dto.transport.TransportDTO;
import com.rftdevgroup.transporthub.data.repository.transport.TransportRepository;
import com.rftdevgroup.transporthub.service.TransportService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<TransportDTO> listTransports() {
        return transportRepository.findAll().stream()
                .map(t -> modelMapper.map(t, TransportDTO.class)).collect(Collectors.toList());
    }
}
