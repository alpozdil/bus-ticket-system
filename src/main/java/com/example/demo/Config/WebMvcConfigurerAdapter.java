package com.example.demo.Config;

import org.springframework.web.reactive.config.CorsRegistry;

public abstract class WebMvcConfigurerAdapter {
    public abstract void addCorsMappings(CorsRegistry registry);
}
