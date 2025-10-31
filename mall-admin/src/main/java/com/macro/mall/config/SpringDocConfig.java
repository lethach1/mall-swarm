package com.macro.mall.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.customizers.GlobalOpenApiCustomizer;
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

    private static final String SECURITY_SCHEME_NAME = "Authorization";

    @Bean
    public OpenAPI mallAdminOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("mall Admin System")
                        .description("API documentation for mall Admin")
                        .version("v1.0.0")
                        .license(new License().name("Apache 2.0")
                                .url("https://github.com/macrozheng/mall-learning")))
                .externalDocs(new ExternalDocumentation()
                        .description("Complete documentation for the SpringBoot e-commerce project mall (60K+ Stars)")
                        .url("http://www.macrozheng.com"))
                .addSecurityItem(new SecurityRequirement().addList(SECURITY_SCHEME_NAME))
                .components(new Components()
                        .addSecuritySchemes(SECURITY_SCHEME_NAME,
                                new SecurityScheme()
                                        .name(SECURITY_SCHEME_NAME)
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")));
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // Configure redirect from `/swagger-ui/` to `/swagger-ui/index.html`
        registry.addViewController("/swagger-ui/").setViewName("redirect:/swagger-ui/index.html");
    }

    @Bean
    public GlobalOpenApiCustomizer orderGlobalOpenApiCustomizer() {
        // Fix the issue where Knife4j cannot automatically add the auth header after enabling authentication
        return openApi -> {
            // Globally add security requirement
            if (openApi.getPaths() != null) {
                openApi.getPaths().forEach((s, pathItem) -> {
                    pathItem.readOperations().forEach(operation -> {
                        operation.addSecurityItem(new SecurityRequirement().addList(SECURITY_SCHEME_NAME));
                    });
                });
            }
        };
    }

}

