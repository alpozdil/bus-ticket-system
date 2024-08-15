package com.example.demo.Config;

import org.springframework.web.reactive.config.CorsRegistry;

public interface WebMvcConfigurer {
    void addCorsMappings(CorsRegistry registry);
}
