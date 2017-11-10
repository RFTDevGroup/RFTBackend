package com.rftdevgroup.transporthub.controller.rest;

import com.rftdevgroup.transporthub.data.model.transport.Transport;
import com.rftdevgroup.transporthub.data.repository.transport.TransportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping(value = "/api/transport")
public class TransportController {

    @Autowired
    private TransportRepository transportRepository;

    @RequestMapping(value = "/", method = GET)
    public List<Transport> getTransports() {
        return transportRepository.findAll();
    }
}
