# 📌 Padronização de Commits

Este projeto adota uma padronização baseada em **Conventional Commits**, com uso de **escopos explícitos** para deixar claro **onde** a mudança ocorreu e **qual o impacto** dela no sistema.

## 📐 Estrutura do commit

```
<tipo>(<escopo>): descrição curta e objetiva
```

## 🔹 Tipos de commit utilizados

- **feat**  
  Novas funcionalidades adicionadas ao sistema.

- **refactor**  
  Alterações estruturais no código que **não adicionam funcionalidade** e **não corrigem bugs**, mas melhoram clareza, organização, segurança ou resiliência.

- **fix**  
  Correção de bugs ou comportamentos incorretos.

- **docs**  
  Alterações exclusivamente relacionadas à documentação (README, Swagger, comentários explicativos, etc).

- **test**  
  Adição ou ajuste de testes automatizados.

- **perf**  
  Melhorias de desempenho.

- **chore**  
  Ajustes de build, dependências, configurações e tarefas auxiliares.

## 🧩 Escopos mais comuns

Os escopos indicam **qual camada ou parte do sistema foi afetada**:

- **api** → Controllers, endpoints, Swagger  
- **core** → Fluxo principal de análise, regras centrais  
- **domain** → Modelos, heurísticas, regras de domínio  
- **application** → Services e orquestração de casos de uso  
- **infrastructure** → Integrações externas, clients, WebClient  
- **docs** → README e documentação técnica  
- **shared** → Utilitários e componentes compartilhados  

## ✅ Exemplos reais do projeto

```
feat(api): adiciona controllers e service de análise
```

```
feat(application): coleta métricas do GitHub e executa heurísticas
```

```
feat(infrastructure): adiciona client do GitHub e configuração do WebClient
```

```
refactor(core): torna fluxo de análise resiliente a falhas externas e estados vazios
```

```
docs(api): adiciona Swagger e documenta uso da API no README
```

## 🎯 Objetivo da padronização

Essa convenção garante:

- Histórico de commits claro e profissional  
- Fácil entendimento do impacto de cada mudança  
- Melhor revisão de código  
- Clareza arquitetural entre camadas do sistema  
