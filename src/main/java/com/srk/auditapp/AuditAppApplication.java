package com.srk.auditapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class AuditAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuditAppApplication.class, args);
    }
}
