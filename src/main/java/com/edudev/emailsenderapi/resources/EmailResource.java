package com.edudev.emailsenderapi.resources;

import com.edudev.emailsenderapi.dtos.EmailDTO;
import com.edudev.emailsenderapi.dtos.EmailResponseDTO;
import com.edudev.emailsenderapi.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emails")
public class EmailResource {

    private final EmailService service;

    @Autowired
    public EmailResource(final EmailService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<EmailResponseDTO> send(@RequestBody final EmailDTO dto) {

        final var result = this.service.send(dto);

        return ResponseEntity.status(201).body(result);
    }

}
