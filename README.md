# 🛰️ Sistema de Monitoramento Agrícola com Drones

## Visão Geral do Projeto

Este projeto consiste em um sistema de software para uma cooperativa rural focado no **monitoramento periódico de plantações utilizando drones**. O objetivo é coletar imagens e dados ambientais (temperatura, umidade e pragas) de forma eficiente e, principalmente, **segura**.

O desenvolvimento inicial segue os princípios da Orientação a Objetos (OO) com foco rigoroso em **Engenharia de Software e Segurança**.

## 🚀 Funcionalidades Mínimas Implementadas

O sistema atende aos seguintes requisitos funcionais e de segurança:

| Funcionalidade | Status | Destaque em Segurança |
| :--- | :--- | :--- |
| **Cadastro de Áreas Agrícolas** | Modelado | - |
| **Cadastro de Drones** | Modelado/Codificado | **Checklist de Pré-Voo** (`checarPreVoo()`) |
| **Agendamento de Missões** | Modelado | **Validação de Não Sobreposição** |
| **Registro de Dados Coletados** | Modelado | **Persistência Segura** (Prevenção contra Injeção de SQL) |
| **Controle de Acesso** | Modelado | Diferenciação entre Administrador e Operador |

---

## 🏗️ Modelagem e Arquitetura (Sprint 1)

O primeiro ciclo de desenvolvimento (Sprint 1) focou na modelagem estrutural e comportamental, e na integração inicial com o banco de dados.

### 1. Diagrama de Classes (Estrutura Estática)

O modelo identifica as entidades centrais do domínio e seus relacionamentos:

* **Classes Principais:** `Usuario`, `AreaAgricola`, `Drone`, `MissaoVoo`, `DadoColetado`.
* **Relacionamentos Chave:**
    * **Composição:** Uma `MissaoVoo` **gera** vários `DadoColetado` (os dados não existem sem a missão).
    * **Associação:** `MissaoVoo` **utiliza** um `Drone` e **cobre** uma `AreaAgricola`.

### 2. Diagrama de Sequência (Comportamento Dinâmico)

Modelamos o fluxo crítico de **"Agendar Missão de Voo"** para validar a integração dos requisitos de segurança:

1.  O **Sistema** inicia a validação chamando `Drone.checarPreVoo()`.
2.  Somente se o checklist de segurança for aprovado, a validação de `MissaoVoo.validarNaoSobreposta()` é executada.
3.  A persistência no banco de dados ocorre somente após todas as validações de segurança e negócio.

### 3. Integração de Modelos (Classes + Banco de Dados)

A persistência de dados foi implementada seguindo rigorosos padrões de segurança:

#### A. Modelo Relacional (SQL DDL)

O modelo de classes foi mapeado para as seguintes tabelas no banco de dados, com a definição de Chaves Primárias (`PRIMARY KEY`) e Chaves Estrangeiras (`FOREIGN KEY`):
* `TB_USUARIO`, `TB_AREA`, `TB_DRONE`, `TB_MISSAO`, `TB_DADOS_COLETADOS`.

#### B. Persistência Segura em Java

* **Classe:** `MissaoDAO.java`
* **Técnica de Segurança:** Utiliza **`PreparedStatement`** para todos os comandos de `INSERT` e `UPDATE`. Isso garante que as entradas de dados do usuário (ou sensores) sejam tratadas **apenas como dados** e **nunca como código SQL**, prevenindo ataques de Injeção de SQL.

---

## 🛠️ Tecnologias Utilizadas

* **Linguagem:** Java
* **Modelagem:** UML (Diagrama de Classes, Diagrama de Sequência)
* **Persistência:** SQL (JDBC)
