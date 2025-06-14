# Task API - Atividade Prática

API REST simples em Spring Boot de Lista de Tarefas

## 🎯 Objetivos

* Entender os verbos HTTP (GET, POST) e status codes (201, 400)
* Criar endpoints REST em Java com Spring Boot

## 📝 Especificação

**Dependências**:

* Spring Web
* Lombok

**Endpoints**:

* **GET** `/tasks`

  * Retorna uma lista estática de tarefas
  * Exemplo de resposta (200 OK):

* **POST** `/tasks`

  * Adiciona uma nova tarefa à lista em memória
  * **Validação**: se o corpo for vazio ou só espaços → **400 Bad Request**
  * **Sucesso**: retorna **201 Created** sem corpo

## 🚀 Como executar

1. Inicie a aplicação:

   ```bash
   # Com Maven instalado globalmente
   mvn spring-boot:run

   # Ou usando o wrapper (Windows PowerShell)
   .\mvnw.cmd spring-boot:run
   ```

2. Acesse: `http://localhost:8080/tasks`

3. Testes

Use Insomnia:

1. **GET /tasks**

   * **Status**: 200 OK
   * **Body**:

     ```json
     ["Treino","Avante!"]
     ```


2. **POST /tasks** (tarefa válida)

   * **Header**: `Content-Type: text/plain`
   * **Body**: `Minha tarefa teste`
   * **Status**: 201 Created


3. **POST /tasks** (tarefa vazia)

   * **Header**: `Content-Type: text/plain`
   * **Body**: \`\`
   * **Status**: 400 Bad Request
   * **Body de erro**:

     ```json
     {
       "timestamp": "...",
       "status": 400,
       "error": "Bad Request",
       "path": "/tasks"
     }
     ```
