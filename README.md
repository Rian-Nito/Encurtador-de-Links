# Encurtador de URLs com Java e Spring Boot 🔗

![Status](https://img.shields.io/badge/status-concluído-brightgreen)

Projeto de API REST para um serviço de encurtamento de URLs, desenvolvido como parte dos meus estudos em desenvolvimento backend com o ecossistema Spring.

A aplicação permite que um usuário envie uma URL longa e receba em troca um código curto. Ao acessar a URL com esse código, o usuário é redirecionado para o site original.

## ✨ Funcionalidades

* **Encurtamento de URL:** Endpoint `POST` para criar um novo link encurtado.
* **Redirecionamento:** Endpoint `GET` que recebe o código curto e redireciona para a URL original com um status HTTP 302.
* **Geração de Código Único:** Lógica para gerar um código alfanumérico aleatório de 6 dígitos e garantir que ele não se repita no banco de dados.
* **Persistência de Dados:** As URLs e seus respectivos códigos são salvos em um banco de dados PostgreSQL.

## 🛠️ Tecnologias Utilizadas

* **Java 17+**
* **Spring Boot 3**
* **Spring Data JPA (Hibernate)**
* **PostgreSQL** (Banco de Dados)
* **Maven** (Gerenciador de Dependências)

## 🚀 Como Executar o Projeto

1.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/](https://github.com/)Rian-Nito/Encurtador-de-Links.git
    ```
2.  **Configure o banco de dados:**
    * Abra o arquivo `src/main/resources/application.properties`.
    * Altere os campos `spring.datasource.url`, `spring.datasource.username` e `spring.datasource.password` com as credenciais do seu banco de dados PostgreSQL.

3.  **Execute a aplicação:**
    * Você pode rodar a classe principal `ShortenApplication.java` a partir da sua IDE (Eclipse, IntelliJ) ou via linha de comando com o Maven:
    ```bash
    mvn spring-boot:run
    ```
A aplicação estará rodando em `http://localhost:8081`.

## ⚙️ Uso da API

### 1. Encurtar uma URL

* **Endpoint:** `POST /shorten`
* **Corpo (Body):**
    ```json
    {
        "originalUrl": "[https://www.sua-url-longa-e-completa.com/alguma/coisa](https://www.sua-url-longa-e-completa.com/alguma/coisa)"
    }
    ```
* **Resposta de Sucesso (200 OK):**
    ```json
    {
        "id": 1,
        "code": "aB1cD2",
        "originalUrl": "[https://www.sua-url-longa-e-completa.com/alguma/coisa](https://www.sua-url-longa-e-completa.com/alguma/coisa)"
    }
    ```

### 2. Redirecionar para a URL Original

* **Endpoint:** `GET /shorten/{code}`
* **Exemplo:**
    Acesse no seu navegador: `http://localhost:8081/shorten/aB1cD2`
* **Resposta de Sucesso:**
    * O servidor responderá com um status `302 Found`.
    * O navegador será redirecionado automaticamente para a `originalUrl` correspondente.

## 👨‍💻 Autor

Feito por **Rian Nito**.

[![LinkedIn](https://img.shields.io/badge/linkedin-%230077B5.svg?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/rian-nito-233765265/)
