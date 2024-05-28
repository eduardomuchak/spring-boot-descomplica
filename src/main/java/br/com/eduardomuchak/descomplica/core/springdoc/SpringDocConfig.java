package br.com.eduardomuchak.descomplica.core.springdoc;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.tags.Tag;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class SpringDocConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API Faculdade Descomplica 2024")
                        .version("v1")
                        .description("REST API para atividade do curso de Análise e Desenvolvimento de Sistemas da Faculdade Descomplica 2024")
                )
                .tags(Arrays.asList(
                        new Tag().name("Projetos").description("Operações relacionadas a projetos"),
                        new Tag().name("Tarefas").description("Operações relacionadas a tarefas"),
                        new Tag().name("Recursos").description("Operações relacionadas a recursos"),
                        new Tag().name("Books").description("Operações relacionadas a livros")
                ));
    }
}