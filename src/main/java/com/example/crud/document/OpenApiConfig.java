package com.example.crud.document;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration
@OpenAPIDefinition(info = @Info(title = "REST API", version = "1.0",
        description = "REST API description...",
        contact = @Contact(
        		name = "RaajPath",
        		email= "raajpath@gamil.com",
        		url="http://raajpath.github.io"
        		)
))
       
public class OpenApiConfig {
}
