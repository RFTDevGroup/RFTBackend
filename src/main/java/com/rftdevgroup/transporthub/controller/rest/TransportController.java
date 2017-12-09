package com.rftdevgroup.transporthub.controller.rest;

import com.rftdevgroup.transporthub.data.dto.transport.TransportCreateDTO;
import com.rftdevgroup.transporthub.data.dto.transport.TransportDetailsDTO;
import com.rftdevgroup.transporthub.data.dto.transport.TransportListViewDTO;
import com.rftdevgroup.transporthub.data.model.transport.Transport;
import com.rftdevgroup.transporthub.data.model.user.User;
import com.rftdevgroup.transporthub.data.repository.transport.TransportRepository;
import com.rftdevgroup.transporthub.service.MessageService;
import com.rftdevgroup.transporthub.service.TransportService;
import com.rftdevgroup.transporthub.service.UserService;
import com.rftdevgroup.transporthub.validator.ValidationErrors;
import com.rftdevgroup.transporthub.validator.Validators;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.security.Principal;
import java.util.Optional;
import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping(value = "/api/transport")
@Slf4j
public class TransportController {

    private static final String ADMIN = "ROLE_ADMIN";
    private static final String USER = "ROLE_USER";

    @Autowired
    private TransportService transportService;

    @Autowired
    private UserService userService;

    @Autowired
    private TransportRepository repository;

    @Autowired
    private Validators validators;

    @Secured(ADMIN)
    @RequestMapping(value = "/details", method = GET)
    public Page<Transport> transportPage(Pageable pageable) {
        log.debug("Admin requested all transports.");
        return repository.findAll(pageable);
    }

    @Secured(USER)
    @RequestMapping(value = "/", method = GET)
    public Page<TransportListViewDTO> transportList(Pageable pageable) {
        log.debug("Listing transports.");
        return transportService.listTransports(pageable);
    }

    @Secured(USER)
    @RequestMapping(value = "/new", method = POST)
    public ResponseEntity<?> newTransport(@RequestBody TransportCreateDTO transportCreateDTO, Principal principal) {

        Optional<ValidationErrors> error = validators.validate(transportCreateDTO);
        if (error.isPresent()) {
            log.warn("Transport creation form had field errors.");
            return new ResponseEntity<>(error.get().getErrors(), HttpStatus.BAD_REQUEST);
        }

        Optional<User> owner = userService.findAndMapUser(principal.getName(), User.class);

        if (owner.isPresent() && transportService.save(transportCreateDTO, owner.get())) {
            log.debug("New transport added");
            return new ResponseEntity<>("New transport added.", HttpStatus.OK);
        } else {
            log.warn("Failed to add new transport.");
            return new ResponseEntity<>("Failed to add new transport.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Secured(USER)
    @RequestMapping(value = "/{id}", method = DELETE)
    public ResponseEntity<?> userDeleteTransport(@PathVariable("id") long id, Principal principal) {
        Optional<User> user = userService.findAndMapUser(principal.getName(), User.class);
        if (user.isPresent() && transportService.delete(id, user.get())) {
            log.debug("Transport({}) deleted by {}.",id,user.get().getUserName());
            return new ResponseEntity<>("Transport deleted.", HttpStatus.OK);
        } else {
            log.warn("Transport({}) deletion by {} failed.", id, principal.getName());
            return new ResponseEntity<>("Failed to delete transport.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Secured(ADMIN)
    @RequestMapping(value = "/{id}/admin", method = DELETE)
    public ResponseEntity<?> adminDeleteTransport(@PathVariable("id") long id) {
        if (transportService.adminDelete(id)) {
            log.debug("Transport({}) deleted by admin.", id);
            return new ResponseEntity<>("Transport deleted.", HttpStatus.OK);
        } else {
            log.warn("Failed to delete transport({}).", id);
            return new ResponseEntity<>("Failed to delete transport.", HttpStatus.BAD_REQUEST);
        }
    }

    @Secured(USER)
    @RequestMapping(value = "/{id}", method = GET)
    public ResponseEntity<?> getTransportDetails(@PathVariable("id") long id) {
        Optional<TransportDetailsDTO> detailsDTO = transportService.findAndMapTransport(id, TransportDetailsDTO.class);
        if(detailsDTO.isPresent()){
            log.debug("Transport({}) details served.",id);
            return new ResponseEntity<>(detailsDTO.get(), HttpStatus.OK);
        } else {
            log.warn("Failed to serve transport({}) details.",id);
            return new ResponseEntity<>("Failed to get transport.", HttpStatus.BAD_REQUEST);
        }
    }
}
