package com.eurofunk.c4.controller;

import com.eurofunk.c4.dto.ClientDTO;
import com.eurofunk.c4.service.KomManCommunicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/client")
public class RegistrationController {
    private final KomManCommunicationService komManCommunicationService;

    @Autowired
    public RegistrationController(final KomManCommunicationService komManCommunicationService) {
        this.komManCommunicationService = komManCommunicationService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public void registerClient(@RequestBody final ClientDTO clientDTO) {
        komManCommunicationService.registerClient(clientDTO);
    }

}
