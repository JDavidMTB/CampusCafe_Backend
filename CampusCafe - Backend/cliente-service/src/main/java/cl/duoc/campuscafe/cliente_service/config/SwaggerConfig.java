package cl.duoc.campuscafe.cliente_service.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("CampusCafe - cliente Service API") // ← cambia esto
                        .version("1.0.0")
                        .description("API para gestión de categorías") // ← y esto
                        .contact(new Contact()
                                .name("Equipo CampusCafe")
                                .email("campuscafe@duoc.cl")));
    }
}