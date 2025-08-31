<!-- Área do Banner -->
<div align="center" style="background-color: white; max-width: 100%;">
  <img alt="BANNER TFT" title="Banner TFT" src="https://github.com/wanessabrito/api-tft/blob/main/api-tft/src/main/img/img3.tf.webp" width="100%" />
</div>

<!-- Título e breve descrição do repositório -->
<div align="center">
  <h1>🛡️ API TFT - Campeões</h1>
  <p><b>CRUD desenvolvido em Spring Boot para gerenciar campeões do jogo Teamfight Tactics (TFT)</b></p>
  <p>O projeto utiliza H2 Database (em memória, apenas para testes) e já vem com 7 campeões cadastrados por padrão.</p>
  <p>A documentação é disponibilizada via <b>Swagger UI</b>.</p>
</div>

<!-- Ícones ou links das tecnologias usadas -->
<p align="center">
  <a href="https://www.java.com/" title="Java"><img src="https://img.shields.io/badge/Java-ED8B00?style=flat&logo=java&logoColor=white" alt="Java"></a>
  +
  <a href="https://spring.io/projects/spring-boot" title="Spring Boot"><img src="https://img.shields.io/badge/Spring%20Boot-6DB33F?style=flat&logo=spring&logoColor=white" alt="Spring Boot"></a>
  +
  <a href="https://www.h2database.com/" title="H2 Database"><img src="https://img.shields.io/badge/H2%20Database-17A2B8?style=flat&logo=h2database&logoColor=white" alt="H2 Database"></a>
  +
  <a href="https://swagger.io/" title="Swagger"><img src="https://img.shields.io/badge/Swagger-85EA2D?style=flat&logo=swagger&logoColor=white" alt="Swagger"></a>
  +
  <a href="https://maven.apache.org/" title="Maven"><img src="https://img.shields.io/badge/Maven-007396?style=flat&logo=apachemaven&logoColor=white" alt="Maven"></a>
</p>

<!-- Escudos de licença e contribuidores -->
<p align="center">
  <a href="https://github.com/wanessabrito/api-tft/graphs/contributors">
    <img src="https://img.shields.io/github/contributors/wanessabrito/api-tft?color=%237159c1&logoColor=%237159c1&style=flat" alt="Contributors">
  </a>
  <a href="https://opensource.org/license/gpl-3-0">
    <img src="https://img.shields.io/github/license/wanessabrito/api-tft?color=%23BD0000" alt="License">
  </a>
</p>

---

## 📜 Sumário
- [Visão Geral](#-visão-geral)
- [Tecnologias Utilizadas](#-tecnologias-utilizadas)
- [Endpoints](#-endpoints)
- [Status Codes HTTP](#-status-codes-http)
- [Instalação e Execução](#-instalação-e-execução)
- [Contribuindo](#-contribuindo)
- [Licença](#-licença)

---

## 📖 Visão Geral
A **API TFT - Campeões** permite gerenciar campeões do jogo **Teamfight Tactics (TFT)**.  
Funcionalidades:
- Buscar campeões (todos ou por ID)
- Adicionar novos campeões
- Atualizar campeões existentes
- Deletar campeões  

Cada campeão possui:
- `id` (gerado automaticamente)
- `nome`
- `classe`
- `origem`
- `custo` (1 a 5)
- `dificuldade` (1 fácil → 5 difícil)

---

## 🛠 Tecnologias Utilizadas
- **Linguagem**: Java 17+
- **Framework**: Spring Boot
- **Banco de Dados**: H2 (em memória)
- **ORM**: Spring Data JPA
- **Documentação**: Swagger (OpenAPI 3)
- **Build e Dependências**: Maven

---

## 🏷 Endpoints
A API possui as seguintes rotas para gerenciar campeões do TFT:

| Método | Rota             | Descrição                      |
|--------|-----------------|--------------------------------|
| GET    | /campeoes        | Retorna todos os campeões       |
| GET    | /campeoes/{id}   | Retorna um campeão pelo ID      |
| POST   | /campeoes        | Adiciona um novo campeão        |
| PUT    | /campeoes/{id}   | Atualiza um campeão existente   |
| DELETE | /campeoes/{id}   | Remove um campeão pelo ID       |

### 💻 Exemplos de Requisições e Respostas

**1️⃣ Listar campeões**
```bash
curl -X GET http://localhost:8080/campeoes
```

**✅Resposta (200 OK):**
```bash
[
  {
    "id": 1,
    "nome": "Lux",
    "classe": "Mago",
    "origem": "Luz",
    "custo": 2,
    "dificuldade": 3
  },
  {
    "id": 2,
    "nome": "Ahri",
    "classe": "Feiticeiro",
    "origem": "Ionia",
    "custo": 5,
    "dificuldade": 3
  },
  {
    "id": 3,
    "nome": "Annie",
    "classe": "Mago",
    "origem": "Gadgeteen",
    "custo": 1,
    "dificuldade": 2
  },
  ...
]
```
**2️⃣ Buscar campeão por ID**
```bash
curl -X GET http://localhost:8080/campeoes/1
```
**✅Resposta (200 OK):**
```bash
{
  "id": 1,
  "nome": "Lux",
  "classe": "Mago",
  "origem": "Luz",
  "custo": 2,
  "dificuldade": 3
}
```
**3️⃣ Adicionar novo campeão**
```bash
curl -X POST "http://localhost:8080/campeoes" \
  -H "Content-Type: application/json" \
  -d '{
        "nome": "Yasuo",
        "classe": "Lutador",
        "origem": "Ionia",
        "custo": 4,
        "dificuldade": 4
      }'
```
**✅Resposta (201 Created):**
```bash
{
  "id": 8,
  "nome": "Yasuo",
  "classe": "Lutador",
  "origem": "Ionia",
  "custo": 4,
  "dificuldade": 4
}
```
**4️⃣ Atualizar campeão**
```bash
curl -X PUT "http://localhost:8080/campeoes/1" \
  -H "Content-Type: application/json" \
  -d '{
        "nome": "Lux",
        "classe": "Mago",
        "origem": "Luz",
        "custo": 2,
        "dificuldade": 4
      }'
```
**✅Resposta (200 OK):**
```bash
{
  "id": 1,
  "nome": "Lux",
  "classe": "Mago",
  "origem": "Luz",
  "custo": 2,
  "dificuldade": 4
}
```
**5️⃣ Deletar campeão**
```bash
curl -X DELETE http://localhost:8080/campeoes/1
```
--- 



---

## 📄 Status Codes HTTP

| Código | Descrição |
|--------|-----------|
| **200 OK** | Requisição bem-sucedida |
| **201 Created** | Recurso criado com sucesso |
| **204 No Content** | Requisição bem-sucedida, mas sem retorno |
| **400 Bad Request** | Erro na requisição |
| **404 Not Found** | Recurso não encontrado |
| **500 Internal Server Error** | Erro interno do servidor |

---

## 🚀 Instalação e Execução

## Pré-requisitos

- Java 17+  
- Maven  

## Passos

```bash
# Clonar repositório
git clone https://github.com/wanessabrito/api-tft.git
cd api-tft
```
```bash
# Rodar aplicação
mvn spring-boot:run
```
--- 

## 🗄️ Acessar H2 Database

- **URL:** [http://localhost:8080/h2-console](http://localhost:8080/h2-console)  
- **JDBC URL:** `jdbc:h2:mem:campeoesdb`  
- **Usuário:** `sa`  
- **Senha:** (em branco)

## 📖 Acessar Swagger UI
📌 A documentação interativa da API pode ser acessada no navegador:  
🔗 [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
<details>
  <summary><b>Captura de tela Swagger UI</b></summary>
  <img src="https://github.com/wanessabrito/api-tft/blob/main/api-tft/src/main/img/Swagger.png" alt="Swagger UI" width="100%">
</details>

---

## 🤝 Contribuindo

1. Fork do projeto  
2. Criar branch:  
   ```bash
   git checkout -b feature/nova-funcionalidade
   ```
3. Commit:
   ```bash
   git commit -m 'Adiciona nova funcionalidade'
   ```
4. Push:
   ```bash
   git push origin feature/nova-funcionalidade
   ```
5. Abrir Pull Request

---

## 📄 Licença

Este projeto está licenciado sob a **MIT License**.


