package com.edudev.emailsenderapi.services;

import com.edudev.emailsenderapi.dtos.EmailDTO;
import com.edudev.emailsenderapi.dtos.EmailResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

public class MockEmailService implements EmailService {

    private static final Logger LOG = LoggerFactory.getLogger(MockEmailService.class);

    @Override
    public final EmailResponseDTO send(final EmailDTO dto) {

        LOG.info("Sending email from {} to {} ", dto.from(), dto.to());
        LOG.info("Email sent, status - 200");

        return new EmailResponseDTO(UUID.randomUUID().toString(), "Queued. Thank you.");

    }
}
