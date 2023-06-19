package com.adriano.helpedesk.config;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.ApiResourceController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.swagger2.web.WebMvcSwaggerTransformationFilter;

import java.util.Collections;

@Configuration
@EnableSwagger2
@SecurityScheme(
        name = "OAuth2",
        type = SecuritySchemeType.OAUTH2,
        flows = @io.swagger.v3.oas.annotations.security.OAuthFlows(
                authorizationCode = @io.swagger.v3.oas.annotations.security.OAuthFlow(
                        authorizationUrl = "https://example.com/oauth2/authorize",
                        tokenUrl = "https://example.com/oauth2/token",
                        scopes = {
                                @io.swagger.v3.oas.annotations.security.OAuthScope(name = "read", description = "Grants read access"),
                                @io.swagger.v3.oas.annotations.security.OAuthScope(name = "write", description = "Grants write access")
                        }
                )
        )
)
@SecurityRequirement(name = "OAuth2")
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.OAS_30)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.adriano.helpedesk"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo())
                .ignoredParameterTypes(ApiResourceController.class, WebMvcSwaggerTransformationFilter.class);
    }

    private ApiInfo apiInfo() {
        return new ApiInfo("Rest API HelpDesk Spring Boot", "Plataforma para helpdesk ", "v1",
                "Terms Of Service Url",
                new Contact("Adriano Cardoso", "https://github.com/Adriano-Cardoso", "goularta97@gmail.com"),
                "License of API", "License of URL", Collections.emptyList());
    }
}
