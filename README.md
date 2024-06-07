# Car User System

## Estórias de Usuário

1. **Como um usuário, quero poder registrar uma conta fornecendo meus dados pessoais e de carro para que eu possa acessar o sistema.**
2. **Como um usuário registrado, quero fazer login no sistema usando meu login e senha para acessar minhas informações.**
3. **Como um usuário logado, quero poder ver a lista de todos os usuários registrados para ter uma visão geral dos usuários no sistema.**
4. **Como um usuário logado, quero poder buscar informações de um usuário específico pelo seu ID para obter detalhes desse usuário.**
5. **Como um usuário logado, quero poder atualizar minhas informações pessoais e de carro para manter meus dados atualizados.**
6. **Como um usuário logado, quero poder deletar minha conta para que meus dados sejam removidos do sistema.**
7. **Como um usuário logado, quero ver minhas informações detalhadas, incluindo o último login e a data de criação da conta para monitorar minha atividade.**
8. **Como um usuário logado, quero poder cadastrar novos carros na minha conta para manter meu registro de veículos atualizado.**
9. **Como um usuário logado, quero ver a lista de todos os meus carros registrados para gerenciar meus veículos.**
10. **Como um usuário logado, quero poder buscar informações de um carro específico pelo seu ID para obter detalhes desse veículo.**
11. **Como um usuário logado, quero poder atualizar as informações de um carro registrado para manter os dados dos meus veículos atualizados.**
12. **Como um usuário logado, quero poder deletar um carro registrado na minha conta para remover veículos que não possuo mais.**

## Solução

A solução utiliza a seguinte stack tecnológica:
- **Java 8**: Linguagem de programação.
- **Spring Boot**: Framework para facilitar a criação de aplicações Java.
- **Spring Security**: Para gerenciar autenticação e autorização.
- **JWT**: Para autenticação baseada em token.
- **JPA/Hibernate**: Para persistência de dados.
- **H2 Database**: Banco de dados em memória para facilitar o desenvolvimento e testes.
- **Maven**: Gerenciador de dependências e build da aplicação.
- **Angular**: Para o front-end.

### Justificativas Técnicas
1. **Spring Boot** facilita a criação de APIs RESTful de forma rápida e eficiente, com configuração mínima.
2. **Spring Security** e **JWT** proporcionam um mecanismo robusto para autenticação e autorização, essencial para proteger as rotas da API.
3. **JPA/Hibernate** simplifica a interação com o banco de dados, permitindo mapeamento objeto-relacional eficiente.
4. **H2 Database** é utilizado para facilitar o desenvolvimento e testes, eliminando a necessidade de configurar um banco de dados externo.
5. **Maven** é amplamente utilizado na comunidade Java para gerenciamento de dependências e construção de projetos.
6. **Angular** permite a criação de um front-end dinâmico e responsivo, facilitando a interação do usuário com a API.


## Como Executar o Projeto

### Pré-requisitos
- Java 8 ou superior
- Maven
- Node.js e npm (para o front-end Angular)

### Build e Deploy

1. Clone o repositório:
   ```sh
   git clone https://github.com/seu-usuario/car-user-system.git
   cd car-user-system

2. Build da aplicação:
   ```sh
   mvn clean install

3. Execute a aplicação:
   ```sh
   mvn spring-boot:run

4. Acesse a aplicação em http://localhost:8080.

### Testes:
   ```sh
   mvn test
```

## Endpoints da API
### Usuário
1. GET /api/users: Lista todos os usuários.
2. POST /api/users: Cria um novo usuário.
3. GET /api/users/{id}: Busca um usuário pelo ID.
4. DELETE /api/users/{id}: Remove um usuário pelo ID.
5. PUT /api/users/{id}: Atualiza um usuário pelo ID.

### Carro
1. GET /api/cars: Lista todos os carros do usuário logado.
2. POST /api/cars: Cadastra um novo carro para o usuário logado.
3. GET /api/cars/{id}: Busca um carro do usuário logado pelo ID.
4. DELETE /api/cars/{id}: Remove um carro do usuário logado pelo ID.
5. PUT /api/cars/{id}: Atualiza um carro do usuário logado pelo ID.

## Exemplo de Requisição
### Criar Usuário
  ```sh
  POST /api/users
  {
      "firstName": "Hello",
      "lastName": "World",
      "email": "hello@world.com",
      "birthday": "1990-05-01",
      "login": "hello.world",
      "password": "h3ll0",
      "phone": "988888888",
      "cars": [
          {
              "year": 2018,
              "licensePlate": "PDV-0625",
              "model": "Audi",
              "color": "White"
          }
      ]
  }
  ```

### Login
  ```sh
  POST /api/signin
{
    "login": "hello.world",
    "password": "h3ll0"
}
```
### Erros Possíveis
1. Login inexistente ou senha inválida: Retornar um erro com a mensagem "Invalid login or password".
2. E-mail já existente: Retornar um erro com a mensagem "Email already exists".
3. Login já existente: Retornar um erro com a mensagem "Login already exists".
4. Campos inválidos: Retornar um erro com a mensagem "Invalid fields".
5. Campos não preenchidos: Retornar um erro com a mensagem "Missing fields".

Essa seção cobre as estórias de usuário, a solução técnica, os passos para construir e executar o projeto, rodar os testes, e o endpoint de autenticação com um exemplo de requisição de login.
