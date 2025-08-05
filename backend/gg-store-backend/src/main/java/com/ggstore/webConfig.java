package com.ggstore;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.file.Paths;

@Configuration
public class webConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
      
        String frontendPath = Paths.get("frontend").toAbsolutePath().toString();
        registry.addResourceHandler("/assets/**")
                .addResourceLocations("file:" + frontendPath + "/assets/");
        registry.addResourceHandler("/**")
                .addResourceLocations("file:" + frontendPath + "/");
    }
}
