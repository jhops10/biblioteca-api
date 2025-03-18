# 📚 Biblioteca Online

Projeto desenvolvido para gerenciamento de uma biblioteca online, permitindo cadastro de livros, usuários e empréstimos.

## 🚀 Tecnologias Utilizadas

- **Java 17**
- **Spring Boot** (Spring Web, Spring Data JPA, Spring Validation)
- **Maven**
- **MySQL**

## ⚙️ Como Rodar o Projeto

### Pré-requisitos
- Java 17
- Maven 
- Banco de dados MySQL

### Passos para rodar

1. Clone o repositório:
   ```bash
   git clone https://github.com/jhops10/library-api.git
   cd library-api
   ```
2. Configure o banco de dados no `application.properties`.
3. Execute o projeto com Maven:
   ```bash
   mvn spring-boot:run
   ```
4. Acesse a API pelo endereço:
   ```
   http://localhost:8080
   ```


## 🔗 Endpoints Principais

### Usuários (/users)
- `GET /users` - Lista todos os usuários
- `GET /users/{id}` - Busca um usuário pelo ID
- `GET /users/email/{email}` - Busca um usuário pelo email
- `POST /users` - Cadastra um novo usuário
- `DELETE /users/{id}` - Remove um usuário

### Livros (/books)
- `GET /books` - Lista todos os livros
- `GET /books/{id}` - Busca um livro pelo ID
- `POST /books` - Cadastra um novo livro
- `DELETE /books/{id}` - Remove um livro

### Empréstimos (/loans)
- `GET /loans/user/{userId}` - Busca um empréstimo pelo ID do usuário
- `POST /loans/{userId}/{bookID}` - Cadastra um novo empréstimo
- `POST /loans/{loanId}/return` - Faz a devolução do empréstimo de livro

---


