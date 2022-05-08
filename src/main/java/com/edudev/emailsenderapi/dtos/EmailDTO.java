package com.edudev.emailsenderapi.dtos;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.Collection;

public record EmailDTO(
        String from,
        Collection<String> to,
        String subject,
        String body
) {

    public MultiValueMap<String, Object> prepareEmailParts(final String mailgunDomain) {
        final MultiValueMap<String, Object> parts = new LinkedMultiValueMap<>();

        parts.add("from", from + " <mailgun@" + mailgunDomain + ">");
        to.forEach(to -> parts.add("to", to));
        parts.add("subject",subject);
        parts.add("text", body);

        return parts;
    }
}