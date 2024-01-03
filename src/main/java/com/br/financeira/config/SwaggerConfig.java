package com.br.financeira.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.tags.Tag;
import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

@Configuration
public class SwaggerConfig {
    @Value(value = "${api.versao}")
    private String versao;

    @Value(value = "${api.nome}")
    private String nome;

    @Value(value = "${api.descricao}")
    private String descricao;

    @Bean
    public OpenAPI OpenApi()
    {
        return new OpenAPI()
                .info(new Info()
                        .title(nome)
                        .description(descricao)
                        .version(versao)
                        .contact(contact())
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("DPT - Documentação")
                        .url("http://www.uol.com.br"));
    }

    @Bean
    public OpenApiCustomizer sortSchemasAlphabetically()
    {
        return openApi -> {
            Map<String, Schema> schemas = openApi.getComponents().getSchemas();
            openApi.getComponents().setSchemas(new TreeMap<>(schemas));

            openApi.getTags()
                    .stream()
                    .sorted((Comparator.comparing(Tag::getName, String.CASE_INSENSITIVE_ORDER)))
                    .collect(Collectors.toList());
        };
    }

    private Contact contact()
    {
        Contact contact = new Contact();
        contact.setEmail("Informar o email aqui");
        contact.setName("Informar o nome aqui");
        contact.setUrl("Informar a url aqui");

        return contact;
    }
}
