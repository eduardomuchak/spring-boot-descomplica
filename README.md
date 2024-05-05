# CRUD Livros - Atividade Faculdade Descomplica 2024

Este é um projeto Spring Boot que usa Java 17.

## Pré-requisitos

- Java 17
- Maven

## Como rodar o projeto

1. Clone o repositório para a sua máquina local usando `git clone git@github.com:eduardomuchak/spring-boot-descomplica.git`.
2. Navegue até o diretório do projeto.
3. Execute o comando `mvn spring-boot:run` para iniciar a aplicação.

A aplicação estará disponível no endereço `http://localhost:8080`.

## Banco de dados

Estamos usando um banco de dados H2 em memória. Você pode acessá-lo em `http://localhost:8080/h2`.

As credenciais para acesso ao banco são:
```
Driver Class: org.h2.Driver
JDBC URL: jdbc:h2:mem:descomplica
Username: sa
Password: senha123
```

## Documentação da API

A documentação da API está disponível em `http://localhost:8080/swagger-ui/index.html`.
