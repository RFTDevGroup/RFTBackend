package com.rftdevgroup.transporthub.controller.rest;

import com.rftdevgroup.transporthub.controller.response.Response;
import com.rftdevgroup.transporthub.controller.response.ResponseStatus;
import com.rftdevgroup.transporthub.data.dto.transport.TransportCreateDTO;
import com.rftdevgroup.transporthub.data.dto.transport.TransportListViewDTO;
import com.rftdevgroup.transporthub.data.model.transport.Transport;
import com.rftdevgroup.transporthub.data.repository.transport.TransportRepository;
import com.rftdevgroup.transporthub.service.TransportService;
import com.rftdevgroup.transporthub.validator.ValidationErrors;
import com.rftdevgroup.transporthub.validator.Validators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.security.Principal;
import java.util.Optional;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(value = "/api/transport")
public class TransportController {

    private static final String ADMIN = "ROLE_ADMIN";
    private static final String USER = "ROLE_USER";

    @Autowired
    private TransportService transportService;

    @Autowired
    private TransportRepository repository;

    @Autowired
    private Validators validators;

    @Secured(ADMIN)
    @RequestMapping(value = "/details", method = GET)
    public Page<Transport> transportPage(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Secured(USER)
    @RequestMapping(value = "/", method = GET)
    public Page<TransportListViewDTO> transportList(Pageable pageable) {
        return transportService.listTransports(pageable);
    }

    @Secured(USER)
    @RequestMapping(value = "/new", method = POST)
    public Response newTransport(@RequestBody TransportCreateDTO transportCreateDTO, Principal principal) {
        Response response = new Response();

        Optional<ValidationErrors> error = validators.validate(transportCreateDTO);
        if (error.isPresent()) {
            return new Response(ResponseStatus.VALIDATION_ERROR, error.get());
        }


        response.setResponseObject(transportCreateDTO);
        response.setStatus(ResponseStatus.OK);
        return response;
    }
}
