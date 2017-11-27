package com.rftdevgroup.transporthub.controller.rest;

import com.rftdevgroup.transporthub.controller.response.Response;
import com.rftdevgroup.transporthub.controller.response.ResponseStatus;
import com.rftdevgroup.transporthub.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.security.Principal;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    private static final String ADMIN = "ROLE_ADMIN";
    private static final String USER = "ROLE_USER";

    @Autowired
    private MessageService messageService;

    @Secured(USER)
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Response getAllMessagesForUser(Principal principal) {
        return new Response(ResponseStatus.OK, messageService.findMessagesFor(principal.getName()));
    }
}
