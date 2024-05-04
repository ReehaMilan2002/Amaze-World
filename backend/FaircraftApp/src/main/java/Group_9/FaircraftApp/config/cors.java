package Group_9.FaircraftApp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class cors implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(@NonNull CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000,http://localhost:3001")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTION", "PATCH")
                .allowedHeaders("*");
    }
}
