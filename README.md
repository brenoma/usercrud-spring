<h1 align="center">Desafio Desenvolvedor Backend</h1>

Tabela de conteúdos
=================
<!--ts-->
* [Tabela de conteúdos](#tabela-de-conteúdos)
* [Descrição do Projeto](#descrição-do-projeto)
    * [Requisitos](#requisitos)
    * [Bônus](#bônus)
* [Features](#features)
    * [Features Backend](#features-backend)
    * [Features Container](#features-container)
    * [Features Documentação](#features-docs)
* [Instalação](#instalação)
    * [Instalando o repositório](#rodando-o-backend)
    * [Subindo os containers](#subindo-os-containers)
* [Tecnologias](#tecnologias)
<!--te-->

## Descrição do Projeto

<p align="left">O teste consiste na criação de uma API Rest com Spring Boot contendo um CRUD de usuário, com requisições
a uma API pública do Github.</p>

<h2 align="center"> 
	🚧  Backend 🚀 Em construção...  🚧
</h4>

<h2 align="center"> 
	🚧  Container 🚀 Em construção...  🚧
</h4>

<h2 align="center"> 
	🚧  Documentação 🚀 Em construção...  🚧
</h4>

### Requisitos

- [x] CRUD Usuário.
- [x] Consumo de API externa do github.

### Bônus

- [x] Construir Imagem Docker e Publicar no Dockerhub.
- [x] Criar Arquivo docker-compose com todos os serviços e versionar juntamente com o projeto.
- [x] As configurações dos bancos de dados, porta, etc devem ser recuperadas através de variáveis de
  ambiente.
- [x] Documentação da API REST.
- [ ] Testes unitários

### Features Backend

- [x] Criação das Rotas
- [x] Controller de usuário
- [x] DTO usuário
- [x] GET listar usuários
- [x] GET achar usuário por ID 
- [x] POST Cadastro de usuário
- [x] PUT Atualização de dados do usuário
- [x] DELETE Remoção de usuário da base
- [x] GET requisição externa para API do Github

### Features Container

- [x] Criação da imagem Dockerfile
- [x] Criação do docker-compose
- [x] Controller de usuário
- [x] Variáveis de ambiente

### Features Documentação

- [x] Swagger-ui

## Instalação


### Instalando o repositório

```bash
# Clone este repositório
$ git clone <https://github.com/brenoma/usercrud-spring>

# Acesse a pasta do backend no terminal/cmd
$ cd usercrud-spring

# Faça o build do projeto Maven
$ mvn clean install
```
### Subindo os containers

```bash
# Faça o build dos containers
$ docker-compose up -d --build

# O servidor Tomcat inciará na porta -> 8081 - Use o postman na rota <http://localhost:8081>
# O Swagger estará na mesma porta do Tomcat -> 8081
# O banco iniciará na porta -> 5432
```
## Tecnologias

As seguintes ferramentas foram usadas na construção do projeto:

- [JavaSDK 11]()
- [Sring Boot]()
- [Spring Web]()
- [Spring Data JPA]()
- [Jersey]()
- [PostgreSQL Driver]()
- [Postgresql]()
- [Postman]()
- [Docker]()
- [Swagger]()

