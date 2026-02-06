package com.kauanunes.github_practices_analyzer.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("GitHub Practices Analyzer API")
                        .description("API para análise de boas práticas em repositórios GitHub")
                        .version("v1.0.0")
                );
    }
}
