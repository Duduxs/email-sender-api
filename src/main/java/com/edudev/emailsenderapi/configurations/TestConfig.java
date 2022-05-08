package com.edudev.emailsenderapi.configurations;

import com.edudev.emailsenderapi.services.EmailService;
import com.edudev.emailsenderapi.services.MockEmailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig {

    @Bean
    public EmailService create() {
        return new MockEmailService();
    }
}
