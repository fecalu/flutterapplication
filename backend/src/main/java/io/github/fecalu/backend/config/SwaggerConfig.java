package io.github.fecalu.backend.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Agenda de Contatos API",
                description = "API de agenda de contatos telefônicos.",
                contact = @Contact(
                        name = "Marcos André",
                        email = "marcosdev2002@gmail.com"
                )
        )
)
public class SwaggerConfig {
}
