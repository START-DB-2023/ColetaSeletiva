package com.desafio.Coleta_Seletiva.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SpringDocOpenApiConfig {
  @Bean
  public OpenAPI openAPI() {
    return new OpenAPI().info(
        new Info()
            .title("REST API - Coleta Seletiva")
            .description(
                "API Rest desenvolvida com Spring, usando o PostgreSQL para persistência de dadaos, que visa visualizar pontos de coleta seletiva e suas características, por instituição administradora.")
            .version("v1")
            .license(new License().name("MIT").url("https://opensource.org/license/mit/"))
            .contact(new Contact().name("GitHub").url("https://github.com/START-DB-2023/desafio_db_grupo_03")));
  }
}
