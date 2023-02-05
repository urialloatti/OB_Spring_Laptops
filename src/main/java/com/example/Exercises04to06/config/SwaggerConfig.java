package com.example.Exercises04to06.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@Configuration
public class SwaggerConfig {

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Laptop APIRest",
                "APIRest test project",
                "1.0.1",
                "Terms of service",
                new Contact(
                        "Uriel Alloatti",
                        "www.google.com",
                        "vergiliusmaro812@gmail.com"),
                "License",
                "www.google.com",
                Collections.emptyList());
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).
                apiInfo(apiInfo()).
                select().
                apis(RequestHandlerSelectors.any()).
                paths(PathSelectors.any()).
                build();
    }
}
