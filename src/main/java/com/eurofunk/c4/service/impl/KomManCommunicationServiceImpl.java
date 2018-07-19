package com.eurofunk.c4.service.impl;

import com.eurofunk.c4.dto.ClientDTO;
import com.eurofunk.c4.service.KomManCommunicationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

import java.util.Objects;

public class KomManCommunicationServiceImpl implements KomManCommunicationService {
    private static final Logger LOGGER = LoggerFactory.getLogger(KomManCommunicationServiceImpl.class);
    private static final String REGISTER_CLIENT_URI = "/client/register";

    private final RestTemplate komManConnector;

    public KomManCommunicationServiceImpl(final String host,
                                          final Integer port) {
        LOGGER.info("Initialize with Komman on {}:{}", Objects.requireNonNull(host), Objects.requireNonNull(port));

        this.komManConnector = new RestTemplate();
        this.komManConnector.setUriTemplateHandler(
                new DefaultUriBuilderFactory(String.format("http://%s:%s", host, port)));
    }

    @Override
    public ClientDTO registerClient(final ClientDTO clientDTO) {
        LOGGER.info("Try to register client with id='{}' to the KomMan Messaging System", clientDTO.getClientId());

        final ClientDTO registeredClientDTO
                = komManConnector.postForObject(REGISTER_CLIENT_URI, clientDTO, ClientDTO.class);

        LOGGER.info("Successfully registered client with id='{}' on node='{}'",
                registeredClientDTO.getClientId(), registeredClientDTO.getNodeId());

        return registeredClientDTO;
    }
}
