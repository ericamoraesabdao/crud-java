# CRUD de Produtos

## Visão Geral
Esta API RESTful foi desenvolvida em **Java** utilizando **Spring Boot**, seguindo os padrões de Engenharia de Software (SOLID, Clean Code) e melhores práticas de arquitetura (camadas Controller, Service, DTO, Exception Handler, etc). O projeto é resultado de uma migração estruturada de Node.js para Java, guiada e acelerada pela **StackSpot AI**.

> **Trabalho desenvolvido com suporte da StackSpot AI.  
> Veja como a IA pode turbinar sua produtividade e qualidade em engenharia de software!  
> [Acesse o agente que auxiliou neste projeto](https://ai.stackspot.com/agents/01JZ8S5T6NZRA7SAVC38FCKKAW?tabIndex=0)**

---

## Tecnologias Utilizadas
- Java 17+
- Spring Boot 3.x
- Spring Web
- Spring Data JPA (para persistência)
- Lombok (para reduzir boilerplate)
- H2 Database (para testes locais)
- JUnit 5 & Mockito (testes)

---

## Estrutura do Projeto

```text
src/main/java/com/crud/crud_java
├── controller/   # Endpoints REST
├── service/      # Regras de negócio
├── dto/          # Data Transfer Objects
├── exception/    # Tratamento global de erros
├── model/        # Modelos de domínio (Entity)
├── repository/   # Acesso a dados (JPA)
└── config/       # Configurações globais
src/test/java/com/crud/crud_java
├── controller/
└── service/
```

---

## Como Executar

. **Pré-requisitos**
- Java 17+
- Maven ou Gradle

. **Clone o projeto**
   ```bash
   git clone https://github.com/ericamoraesabdao/crud-java.git
   cd crud-java
   ```

. **Build & Run**
   ```bash
   ./mvnw spring-boot:run
   ```
ou
   ```bash
   ./gradlew bootRun
   ```

. **API disponível em:** [http://localhost:8080](http://localhost:8080)

---

## Exemplos de Endpoints

### Criar Produto
```http
POST http://localhost:8080/produtos
Content-Type: application/json

{
  "nome": "Produto Teste",
  "data_criacao": "2024-07-10",
  "quantidade_disponivel": 10
}
```

### Listar Produtos
```http
GET http://localhost:8080/produtos/{id}
```

### Exemplo de Resposta de Erro
```json
{
  "message": "Internal Server Error"
}
```

---

## Executando Testes

```bash
./mvnw test
```

ou
```bash
./gradlew test
```

Testes cobrem controladores, serviços e tratamento de exceção.

---

## Boas Práticas Adotadas
- Camadas separadas (Controller, Service, DTO, Exception Handler)
- Validação com Bean Validation
- Tratamento de erros centralizado
- Testes unitários e de integração
- Lombok para código limpo
- Arquitetura limpa e desacoplada

---

## 🎯 Feito com StackSpot AI

> Este projeto foi desenvolvido com suporte do agente inteligente da StackSpot AI, acelerando desde a arquitetura até a implementação e documentação.
>
> [Clique aqui para conhecer o agente que ajudou neste projeto!](https://ai.stackspot.com/agents/01JZ8S5T6NZRA7SAVC38FCKKAW?tabIndex=0)

Saiba mais sobre a StackSpot AI em: [https://www.stackspot.com/pt/ai-pt](https://www.stackspot.com/pt/ai-pt)

---

## Referências

- [Documentação Spring Boot](https://spring.io/projects/spring-boot)
- [Lombok](https://projectlombok.org/)
- [StackSpot AI](https://www.stackspot.com/pt/ai-pt)