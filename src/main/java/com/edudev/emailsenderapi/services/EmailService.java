package com.edudev.emailsenderapi.services;

import com.edudev.emailsenderapi.dtos.EmailDTO;
import com.edudev.emailsenderapi.dtos.EmailResponseDTO;

public interface EmailService {

    EmailResponseDTO send(final EmailDTO dto);
}
