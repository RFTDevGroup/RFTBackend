package com.rftdevgroup.transporthub;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * The main entry point of the Spring Boot application.
 */
@SpringBootApplication
@Slf4j
public class Application {

    public static void main(String[] args) {
        log.debug("Application starting.");
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public WebMvcConfigurer mvcConfig() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*").allowedMethods("PUT","DELETE","GET","POST");
            }
        };
    }
}
