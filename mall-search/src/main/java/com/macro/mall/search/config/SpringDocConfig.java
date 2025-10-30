package com.macro.mall.search.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * SpringDoc related configuration
 * Created by macro on 2024/3/5.
 */
@Configuration
public class SpringDocConfig implements WebMvcConfigurer {

    @Bean
    public OpenAPI mallSearchOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("mall Search System")
                        .description("mall search related API documentation")
                        .version("v1.0.0")
                        .license(new License().name("Apache 2.0")
                                .url("https://github.com/macrozheng/mall-learning")))
                .externalDocs(new ExternalDocumentation()
                        .description("SpringBoot e-commerce project mall (60K+ Star) full documentation")
                        .url("http://www.macrozheng.com"));
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // Configure redirect `/swagger-ui/` to `/swagger-ui/index.html`
        registry.addViewController("/swagger-ui/").setViewName("redirect:/swagger-ui/index.html");
    }

}

