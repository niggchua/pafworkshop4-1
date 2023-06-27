package sg.edu.nus.iss.paf_day24workshop_jul2023.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenAPIConfig {

        @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
        .info(new Info()
        .title("My PAF Day24 workshop")
        .description("PAF Day24 Workshop")
        .version("version 1.0"));

    }
    
    
}
