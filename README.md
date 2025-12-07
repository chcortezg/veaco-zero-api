# VEACO ZERO
### API para gestão de despesas compartilhadas

Este projeto é uma API RESTful desenvolvida em Java para gerenciamento de despesas em grupo e consolidação de dívidas. Ele foi desenvolvido como prática laboratorial para a disciplina de Linguagem de Programação II do Bacharelado em Tecnologia da Informação do IMD/UFRN no período 2025.2.

---

## Funcionalidades

- **Gerenciar usuários**
  - Permite cadastrar novos usuários informando nome e email;  
  - Gera IDs sequenciais automaticamente;  
  - Lista todos os usuários cadastrados.  

- **Gerenciar grupos**
  - Permite criar grupos de despesas;  
  - Permite adicionar participantes existentes ao grupo através de seus IDs;  
  - Mantém o registro dos membros vinculados a cada contexto.  

- **Registrar despesas**
  - Solicita a descrição, o valor total, o ID de quem pagou e o ID do grupo;  
  - Valida se o grupo existe antes de registrar;  
  - Armazena a transação vinculada ao contexto do grupo.  

- **Calcular saldo**
  - Percorre todas as despesas lançadas em um grupo específico;  
  - Calcula o gasto médio por participante;  
  - Confronta o valor pago por cada um versus o valor consumido;  
  - Retorna o saldo líquido de cada integrante.  

- **Documentação interativa**
  - Integração com Swagger UI;  
  - Permite testar todos os endpoints diretamente pelo navegador.  

---

## Estrutura do projeto

- **com.veacozero.api.model**:  
  - Usuario.java: representa a pessoa física no sistema;  
  - Grupo.java: representa o contexto onde as despesas ocorrem;  
  - Despesa.java: representa a transação financeira, vinculando valor, pagador e grupo.  

- **com.veacozero.api.repository**:  
  - UsuarioRepository.java, GrupoRepository.java, DespesaRepository.java: classes responsáveis pela persistência de dados utilizando HashMap em memória.  

- **com.veacozero.api.service**:  
  - DespesaService.java: contém a lógica de negócio principal, responsável por validar as transações e executar o algoritmo de cálculo de saldos.  

- **com.veacozero.api.controller**:  
  - UsuarioController.java, GrupoController.java, DespesaController.java: classes que expõem os endpoints REST para comunicação via HTTP.
