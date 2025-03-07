﻿# Sistema de Gerenciamento de Biblioteca 📚

Este é um projeto simples em Java que implementa um sistema de gerenciamento de biblioteca. Ele permite realizar operações básicas de CRUD (Create, Read, Update, Delete) para gerenciar livros.

## Funcionalidades

- **Cadastrar Livro (Create):** Adicione um novo livro com título, autor, ano de publicação e gênero.
- **Listar Livros (Read):** Exiba todos os livros cadastrados.
- **Atualizar Livro (Update):** Atualize as informações de um livro específico.
- **Excluir Livro (Delete):** Remova um livro do sistema pelo ID.

---

## Pré-requisitos

Antes de rodar o projeto, certifique-se de que você tem os seguintes itens instalados:

1. **Java Development Kit (JDK)** - Versão 8 ou superior.
   - [Baixe o JDK aqui](https://www.oracle.com/java/technologies/javase-downloads.html) ou use o OpenJDK.
2. **IDE para Java** (opcional, mas recomendado):
   - [IntelliJ IDEA](https://www.jetbrains.com/idea/download/)
   - [VSCode com Extensão Java](https://code.visualstudio.com/)
3. **Git** (para clonar o repositório):
   - [Baixe o Git aqui](https://git-scm.com/)

---

## Como Rodar o Projeto

Siga os passos abaixo para rodar o projeto em sua máquina:

### 1. Clone o Repositório

Abra o terminal e execute o comando abaixo para clonar o repositório:

```bash
git clone https://github.com/seu-usuario/dinamica-em-grupo-biblioteca.git
```

Substitua seu-usuario pelo nome do seu usuário no GitHub.

### 2. Navegue até o Diretório do Projeto

Entre na pasta do projeto:

```bash
cd dinamica-em-grupo-biblioteca
```

### Dependencies
Spring WebWEB
Spring Data JPASQL
H2 DatabaseSQL

# Exemplo de requisicao para autenticacao 

Registar admin
POST http://localhost:8080/admin
````json
{
    "name": "Joao candido",
    "username":"joao",
    "email":"joao@email.com",
    "password": "admin123",
    "roles": ["ROLE_ADMIN"]
}
````

Login admin
POST http://localhost:8080/api/auth/login
````json
{
   "username":"joao",
   "password": "admin123"
}
````
Registar user
POST http://localhost:8080/user
````json
{
    "name": "maria helena",
    "username":"maria",
    "email":"maria@email.com",
    "password": "user123",
    "roles": ["ROLE_USER"]
}
````

Login user
POST http://localhost:8080/api/auth/login
````json
{
   "username":"maria",
   "password": "user123"
}
````

# Exemplo de uso dos endponts 
Regra de uso nessa API:<br>
a role(user) esta autorizado a utilizar os endponters (listar e refresh-token).<br>
a role(admin) esta autorizado a utilizar os endponters (cadastrar,atualizar,deletar e refresh-token).<br> 
### 1. para listar todos os livros(user) é necessario adcionar o token gerado no endpont login<br> 
GET http://localhost:8080/livros<br> 
exemplo de como passar o token nos Headers
````yml
 Authorization   Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJtYXJpYSIsImlhdCI6MTc0MDU3Njc5MiwiZXhwIjoxNzQwNTc3MDkyfQ.uY2eDSc9SameDruy8KTJcNU9c8L5ijCnKgdeVXoh-do
````
### 2. para cadastrar um livro(admin) é necessario adcionar o token gerado no endpont login<br> 
POST http://localhost:8080/livros<br> 
exemplo de como passar o token nos Headers
````yml
 Authorization   Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJtYXJpYSIsImlhdCI6MTc0MDU3Njc5MiwiZXhwIjoxNzQwNTc3MDkyfQ.uY2eDSc9SameDruy8KTJcNU9c8L5ijCnKgdeVXoh-do
````
exemplo de payload do body
````json
{
  "titulo": "livro",
  "autor": "joao",
  "anoPublicacao": 2020
}
````
### 3. para atualizar um livro(admin) é necessario adcionar o token gerado no endpont login e passar o id na url da requisição<br> 
PUT http://localhost:8080/livros/1<br> 
exemplo de como passar o token nos Headers
````yml
 Authorization   Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJtYXJpYSIsImlhdCI6MTc0MDU3Njc5MiwiZXhwIjoxNzQwNTc3MDkyfQ.uY2eDSc9SameDruy8KTJcNU9c8L5ijCnKgdeVXoh-do
````
exemplo de payload do body
````json
{
  "titulo": "livro atualizado",
  "autor": "joao",
  "anoPublicacao": 2025
}
````
### 4. para deletar um livro(admin) é necessario adcionar o token gerado no endpont login e passar o id na url da requisição<br> 
DELETE http://localhost:8080/livros/1<br> 
exemplo de como passar o token nos Headers
````yml
 Authorization   Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJtYXJpYSIsImlhdCI6MTc0MDU3Njc5MiwiZXhwIjoxNzQwNTc3MDkyfQ.uY2eDSc9SameDruy8KTJcNU9c8L5ijCnKgdeVXoh-do
````
### 5.  para atualizar o token é necessario adcionar o token gerado no endpont login <br> 
POST http://localhost:8080/user/refresh-token<br> 
exemplo de como passar o token nos Headers
````yml
 Authorization   Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJtYXJpYSIsImlhdCI6MTc0MDU3Njc5MiwiZXhwIjoxNzQwNTc3MDkyfQ.uY2eDSc9SameDruy8KTJcNU9c8L5ijCnKgdeVXoh-do
````

