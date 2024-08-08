package br.uem.backendspringboot.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(title = "PCC Backend", version = "1.0", description = "api rest PCC"))
public class SwaggerConfig {
}
