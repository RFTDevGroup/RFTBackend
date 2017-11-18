package com.rftdevgroup.transporthub.service.impl;

import com.rftdevgroup.transporthub.data.dto.transport.TransportListViewDTO;
import com.rftdevgroup.transporthub.data.dto.transport.TransportViewDTO;
import com.rftdevgroup.transporthub.data.repository.transport.TransportRepository;
import com.rftdevgroup.transporthub.service.TransportService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
public class TransportServiceImpl implements TransportService {

    @Autowired
    private TransportRepository transportRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Page<TransportListViewDTO> listTransports(Pageable pageable) {
        return transportRepository.findAll(pageable).map(transport -> {
            TransportListViewDTO listViewDTO = new TransportListViewDTO();

            //Map transport to dto
            listViewDTO.setCargoName(transport.getCargo().getName());
            listViewDTO.setCityFrom(transport.getPlaceOfLoad().getCity());
            listViewDTO.setCityTo(transport.getPlaceOfUnload().getCity());
            listViewDTO.setDescription(transport.getCargo().getDescription());
            listViewDTO.setOwner(transport.getOwner().getUserName());
            listViewDTO.setCurrentPrice(transport.getCurrentPrice());
            listViewDTO.setDaysRemaining(ChronoUnit.DAYS.between(LocalDate.now(), transport.getTimeOfLoad()));

            return listViewDTO;
        });
    }
}
