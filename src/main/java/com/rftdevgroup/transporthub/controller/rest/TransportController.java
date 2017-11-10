package com.rftdevgroup.transporthub.controller.rest;

import com.rftdevgroup.transporthub.data.dto.transport.TransportDTO;
import com.rftdevgroup.transporthub.service.TransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping(value = "/api/transport")
public class TransportController {

    private static final String ADMIN = "ROLE_ADMIN";
    private static final String USER = "ROLE_USER";

    @Autowired
    private TransportService transportService;

    @Secured(USER)
    @RequestMapping(value = "/", method = GET)
    public Page<TransportDTO> transports(Pageable pageable) {
        return transportService.listTransports(pageable);
    }
}
