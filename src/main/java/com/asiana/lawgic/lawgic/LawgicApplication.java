package com.asiana.lawgic.lawgic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class LawgicApplication {

    public static void main(String[] args) {
        SpringApplication.run(LawgicApplication.class, args);
    }

}
