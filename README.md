# Projeto Agrosustentável - Etapa 6

**Curso:** Técnico em Desenvolvimento de Sistemas  
**Unidade Curricular:** UC11 - Controle de Versão  
**Aluno:** Odair Jose Malaggi  

## Descrição do Projeto
Projeto desenvolvido para gerenciar processos de sustentabilidade agrícola, com foco em consumo de água e energia por propriedades rurais.  
Nesta Etapa 6, todas as funcionalidades foram implementadas e testadas.

## Funcionalidades
- Cadastro de produtores e propriedades
- Registro de consultas de consumo de água e energia
- Cálculo automático do tipo de consumo:
  - Água  
  - Energia  
  - Água/Energia  
- Validação de dados obrigatórios e formato de data
- Integração com banco de dados MySQL através de DAO (ConsultaDAO e ProdutorDAO)
- Retorno booleano indicando sucesso ou falha no cadastro (`true`/`false`)

## Tecnologias Utilizadas
- Java  
- MySQL  
- Git/GitHub  

## Estrutura do Projeto
- `/src` → código-fonte Java  
- `/resources` → arquivos de configuração  
- `/README.md` → este arquivo

## Observações
- Branch principal: `master`  
- Projeto versionado usando Git, com commits claros e organizados  
- Cada etapa do projeto está registrada no histórico de commits
- Para cadastrar uma consulta, o método `cadastrarConsulta` do `ConsultaService` é utilizado, recebendo:
  ```java
  boolean consultaCadastrada = consultaService.cadastrarConsulta(
      produtor,          // Nome do produtor
      consumoAgua,       // Consumo de água (L)
      consumoEnergia,    // Consumo de energia (kWh)
      data               // Data da consulta
  );
