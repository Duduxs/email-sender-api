package com.edudev.emailsenderapi.services;

import com.edudev.emailsenderapi.dtos.EmailDTO;

import com.edudev.emailsenderapi.dtos.EmailResponseDTO;
import jdk.jfr.ContentType;
import org.apache.tomcat.util.http.HeaderUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.yaml.snakeyaml.external.biz.base64Coder.Base64Coder;

import static org.springframework.http.HttpMethod.POST;

@Service
public class EmailService {

    @Value("${mailgun.domain}")
    private final String mailgunDomain;

    @Value("${mailgun.api-key}")
    private final String mailgunApiKey;

    private static final String MAILGUN_URL = "https://api.mailgun.net/v3/";

    private static final Logger LOG = LoggerFactory.getLogger(EmailService.class);

    public EmailService() {
        this.mailgunDomain = null;
        this.mailgunApiKey = null;
    }

    public final EmailResponseDTO send(final EmailDTO dto) {

        LOG.info("Sending email from {} to {} ", dto.from(), dto.to());

        final var template = new RestTemplate();

        final String requestURL = MAILGUN_URL + mailgunDomain + "/messages";
        final var parts = dto.prepareEmailParts(mailgunDomain);

        final var requestEntity = new HttpEntity<>(parts, createHeader("api", mailgunApiKey));

        return template.exchange(requestURL, POST, requestEntity, EmailResponseDTO.class).getBody();

    }

    private MultiValueMap<String, String> createHeader(final String username, final String password) {
        final MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("Authorization", "Basic " + Base64Coder.encodeString(username + ":" + password));
        return map;
    }

}
