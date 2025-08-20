# Fórum Hub - API REST

API REST para o desafio Fórum Hub do programa Oracle Next Education.

## Tecnologias Utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- Spring Security
- JWT para autenticação
- H2 Database (para desenvolvimento)
- Flyway (para migrações de banco de dados)
- Maven

## Funcionalidades

- ✅ CRUD de tópicos
- ✅ Autenticação JWT
- ✅ Autorização por usuário
- ✅ Validações de entrada
- ✅ Banco de dados em memória (H2)

## Como Executar

1. Clone o repositório
2. Execute `mvn spring-boot:run`
3. Acesse `http://localhost:8080`

## Endpoints

### Autenticação
- `POST /auth` - Realiza login e retorna token JWT

### Tópicos
- `GET /topicos` - Lista todos os tópicos
- `GET /topicos/{id}` - Busca um tópico por ID
- `POST /topicos` - Cria um novo tópico (requer autenticação)
- `PUT /topicos/{id}` - Atualiza um tópico (requer autenticação)
- `DELETE /topicos/{id}` - Exclui um tópico (requer autenticação)

## Exemplo de Uso

### Autenticação
```bash
curl -X POST http://localhost:8080/auth \
  -H "Content-Type: application/json" \
  -d '{"email":"ana@email.com","senha":"123456"}'
