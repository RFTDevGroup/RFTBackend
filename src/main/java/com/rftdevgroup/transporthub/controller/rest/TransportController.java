package com.rftdevgroup.transporthub.controller.rest;

import com.rftdevgroup.transporthub.data.dto.transport.TransportViewDTO;
import com.rftdevgroup.transporthub.data.model.transport.Transport;
import com.rftdevgroup.transporthub.data.repository.transport.TransportRepository;
import com.rftdevgroup.transporthub.service.TransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping(value = "/api/transport")
public class TransportController {

    private static final String ADMIN = "ROLE_ADMIN";
    private static final String USER = "ROLE_USER";

    @Autowired
    private TransportService transportService;

    @Autowired
    private TransportRepository repository;

    @Secured(USER)
    @RequestMapping(value = "/", method = GET)
    public Page<TransportViewDTO> transports(Pageable pageable) {
        return transportService.listTransports(pageable);
    }

    @Secured(ADMIN)
    @RequestMapping(value = "/details", method = GET)
    public Page<Transport> transportPage(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
