package cl.duoc.campuscafe.categoria_service.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        // ─── Cambia estos valores por microservicio ───
                        .title("CampusCafe - Categoria Service API")
                        .version("1.0.0")
                        .description("API REST para la gestión de categorías del sistema CampusCafe")
                        // ─────────────────────────────────────────────
                        .contact(new Contact()
                                .name("Equipo CampusCafe")
                                .email("campuscafe@duoc.cl"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://springdoc.org")));
    }
}