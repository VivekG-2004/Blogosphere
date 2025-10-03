package com.vivek.blog.blog_backend.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(@org.jetbrains.annotations.NotNull CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("https://your-vercel-domain.vercel.app") // replace later
                .allowedMethods("GET","POST","PUT","DELETE","OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}

