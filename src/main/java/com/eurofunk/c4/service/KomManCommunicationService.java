package com.eurofunk.c4.service;

import com.eurofunk.c4.dto.ClientDTO;


public interface KomManCommunicationService {
    ClientDTO registerClient(final ClientDTO clientDTO);
}
