package com.edudev.emailsenderapi.configurations;

import com.edudev.emailsenderapi.services.EmailService;
import com.edudev.emailsenderapi.services.MailGunEmailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DevConfig {

    @Bean
    public EmailService create() {
        return new MailGunEmailService();
    }
}
