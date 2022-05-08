package com.edudev.emailsenderapi.dtos;

import java.util.Collection;

public record EmailDTO(
        String from,
        Collection<String> to,
        String subject,
        String body
) {}