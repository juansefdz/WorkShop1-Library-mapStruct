package com.example.librosYa.config;


import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "LibrosYa",
                version = "1.0",
                description = "workshop project LibrosYa. using Mapstruct",

                license = @License(
                        name = "JSFM"
                ),
                contact = @Contact(
                        name = "Juan Sebastián Fernández Montoya",
                        url = "https://juansefdz.com/"

                )


        )
)
public class SwaggerConfig {

}