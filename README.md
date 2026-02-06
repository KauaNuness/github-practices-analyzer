# GitHub Practices Analyzer 🚀

API que analisa perfis do GitHub e gera insights **não-julgativos** sobre boas práticas de desenvolvimento,
focando em manutenção, organização e hábitos de contribuição.

O objetivo não é "avaliar" desenvolvedores, mas **ajudar a adotar melhores práticas** com base em dados públicos.

---

## ✨ O que essa API faz

Dado um username do GitHub, a API:
- Busca repositórios públicos
- Calcula métricas agregadas
- Aplica heurísticas de boas práticas
- Retorna pontos fortes e recomendações

Tudo isso **sem usar IA generativa** — apenas regras claras e transparentes.

---

## 📦 Tecnologias

- Java 17
- Spring Boot
- Spring Web / WebClient
- Reactor (Flux / Mono)
- GitHub REST API
- Swagger (OpenAPI)

---

## ▶️ Como rodar o projeto

### Pré-requisitos
- Java 17+
- Maven

### Rodando localmente

```bash
mvn spring-boot:run
```

A aplicação sobe em:
```
http://localhost:8080
```

---

## 🔍 Como usar

### Endpoint principal

```http
GET /api/analysis/{username}
```

Exemplo:
```
http://localhost:8080/api/analysis/torvalds
```

### Exemplo de resposta

```json
{
  "strengths": [
    {
      "title": "Boa manutenção de repositórios",
      "context": "A maioria dos projetos apresenta atualizações recentes."
    }
  ],
  "recommendations": [
    {
      "title": "Commits muito espaçados",
      "context": "O intervalo médio entre commits é alto.",
      "suggestion": "Considere dividir entregas em mudanças menores."
    }
  ]
}
```

---

## 📊 Métricas analisadas

- Total de repositórios
- Repositórios com descrição
- Taxa de abandono (sem atualização > 6 meses)
- Intervalo médio aproximado entre atualizações

---

## 🧠 Heurísticas

As heurísticas:
- São regras determinísticas
- Não fazem julgamento pessoal
- Geram apenas feedback acionável

---

## 📘 Swagger

Após rodar o projeto, acesse:

```
http://localhost:8080/swagger-ui.html
```

---

## 🛣️ Próximos passos (Roadmap)

- [ ] Analisar frequência real de commits
- [ ] Cache de requisições GitHub
- [ ] Rate limit handling
- [ ] Métricas por linguagem
- [ ] Comparação entre usuários

---

## 👨‍💻 Autor

**Kauã Nunes**  
Backend Developer | Java & Spring
