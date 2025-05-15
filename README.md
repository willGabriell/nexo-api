# Nexo - Sistema de Flashcards

Nexo é uma API REST para gerenciamento de flashcards, permitindo que usuários criem, organizem e consultem flashcards agrupados por categorias. O sistema possui autenticação JWT, controle de acesso e foi desenvolvido com Spring Boot.

## Tecnologias Utilizadas
- Java 21
- Spring Boot 3
- Spring Security
- Spring Data JPA
- PostgreSQL
- Lombok
- JWT (Auth0)
- Maven
- Docker

## Instalação e Execução

### Pré-requisitos
- Java 21+
- Maven
- PostgreSQL
- Docker (opcional)

### Configuração
1. Configure as variáveis de ambiente no `application.yml`:
   - `DB_URL`, `DB_USERNAME`, `DB_PASSWORD` (dados do PostgreSQL)
   - `API_SECRET` (segredo para geração dos tokens JWT)

2. Para rodar localmente:
```shell
mvn clean install
mvn spring-boot:run
```

## Endpoints Principais

### Autenticação
- `POST /auth/login` — Login do usuário (retorna JWT)
- `POST /auth/register` — Cadastro de novo usuário

### Categorias
- `POST /categorias` — Criar categoria
- `GET /categorias` — Listar categorias do usuário
- `PUT /categorias/{id}` — Atualizar categoria
- `DELETE /categorias/{id}` — Remover categoria

### Flashcards
- `POST /flashcards` — Criar flashcard em uma categoria
- `GET /flashcards/{id}` — Listar flashcards de uma categoria

## Estrutura Básica do Projeto
- `controller/` — Controllers REST
- `service/` — Regras de negócio
- `model/` — Entidades JPA
- `repository/` — Repositórios JPA
- `dto/` — Data Transfer Objects
- `config/` — Configurações de segurança, CORS, etc.
