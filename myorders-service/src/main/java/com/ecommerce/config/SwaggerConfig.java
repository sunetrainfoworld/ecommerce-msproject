package com.ecommerce.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("E-Commerce Product Service API")
                        .version("1.0")
                        .description("This service manages order processing including order creation, tracking, status updates, and history. " +
                                "It integrates with user and product services to handle complete order lifecycle management."));
    }
}