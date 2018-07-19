package com.eurofunk.c4.configuration;

import com.eurofunk.c4.configuration.properties.KomManProperties;
import com.eurofunk.c4.service.KomManCommunicationService;
import com.eurofunk.c4.service.impl.KomManCommunicationServiceImpl;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(KomManProperties.class)
public class KomManConfiguration {
    @Bean
    public KomManCommunicationService komManCommunicationService(final KomManProperties komManProperties) {
        return new KomManCommunicationServiceImpl(komManProperties.getHost(), komManProperties.getPort());
    }
}
