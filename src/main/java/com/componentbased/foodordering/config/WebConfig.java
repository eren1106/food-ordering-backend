package com.componentbased.foodordering.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // Allows all endpoints (you can narrow this down to specific paths)
                .allowedOrigins("http://localhost:3000") // Allow CORS from localhost:3000
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Specify allowed HTTP methods
                .allowedHeaders("*") // Allows all headers
                .allowCredentials(true); // Allow credentials if necessary
    }
}

