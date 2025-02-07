package dev.josk.movies.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(title = "Films API", version = "1.0", description = "API Documentation"),
        servers = @Server(url = "http://localhost:8080")
)
public class SwaggerConfig {
}
