package com.rftdevgroup.transporthub.service.impl;

import com.rftdevgroup.transporthub.data.dto.transport.TransportCreateDTO;
import com.rftdevgroup.transporthub.data.dto.transport.TransportListViewDTO;
import com.rftdevgroup.transporthub.data.model.transport.Transport;
import com.rftdevgroup.transporthub.data.model.user.User;
import com.rftdevgroup.transporthub.data.repository.transport.TransportRepository;
import com.rftdevgroup.transporthub.service.TransportService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

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
            listViewDTO.setId(transport.getId());
            listViewDTO.setCargoName(transport.getCargo().getName());
            listViewDTO.setCityFrom(transport.getPlaceOfLoad().getCity());
            listViewDTO.setCityTo(transport.getPlaceOfUnload().getCity());
            listViewDTO.setDescription(transport.getCargo().getDescription());
            listViewDTO.setOwner(transport.getOwner().getUserName());
            if (transport.getBids().size() > 0) {
                listViewDTO.setCurrentPrice(transport.getBids().stream().mapToInt(b -> b.getAmount()).min().getAsInt());
            } else {
                listViewDTO.setCurrentPrice(transport.getStartingPrice());
            }
            listViewDTO.setDaysRemaining(ChronoUnit.DAYS.between(LocalDate.now(), transport.getTimeOfLoad()));

            return listViewDTO;
        });
    }

    @Override
    public boolean save(TransportCreateDTO createDTO, User owner) {
        Assert.notNull(createDTO, "Transport create dto must not be null!");

        Transport transportToSave = new Transport();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        modelMapper.map(createDTO, transportToSave);
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);

        transportToSave.setOwner(owner);
        Transport saved = transportRepository.save(transportToSave);
        return saved != null;
    }

    @Override
    public boolean delete(long id, User user) {
        Transport transportToDelete = transportRepository.findOne(id);
        if (transportToDelete != null && transportToDelete.getOwner().equals(user)) {
            transportRepository.delete(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean adminDelete(long id) {
        transportRepository.delete(id);
        return true;
    }

    @Override
    public <T> Optional<T> findAndMapTransport(long id, Class<T> mapTo) {
        Transport transport = transportRepository.findOne(id);
        return transport == null ? Optional.empty() : Optional.of(modelMapper.map(transport, mapTo));
    }
}
