![logo](https://i.imgur.com/VOcmF6W.png)

*****

[![License](https://img.shields.io/badge/license-MIT-blue.svg)](/LICENSE)

Trabalho desenvolvido na disciplina Desenvolvimento Web e Web Semântica da UFES 2020/2, com proposito de aplicar conceitos de arquitetura, desenvolvimento web e web semântica.

O projeto é baseado nas tecnologias Java com Spring Boot para backend e Angular para o frontend. Como base de dados é usado o Postgres.


# Configurações recomendadas de desenvolvimento

```
git clone https://github.com/dwws-ufes/2020-feiranamao
```

## Banco de dados
```
docker-compose up -d
```

## Backend
No eclipse ou sua IDE de preferencia execute a aplicação Maven com Spring Boot por meio do arquivo 
```
java -jar FeiraNaMao-0.0.1-SNAPSHOT.jar
```

## Frontend
Execute o ambiente de desenvolvimento do Angular
```
cd .\frontend\

npm install

ng serve --open

```
## Primeiro Acesso
Utilize as credenciais do usuario Super Admin

| Usuário |Senha |
| ------------- | ------------- |
| aplication-user  | feiranamao  |

## Funções Extras implementadas
* Comparação dos códigos gerados pelo frameweb com o código efetivamente implementado. (Utilizamos o código php disponibilizado)
* Implementação de funcionalidades em containers (Docker com docker- composer)
* Testes Unitários    (Junit)  
* Cobertura de Testes (Jacoco)
* Documentação de API (swagger)

## Documentação da API disponível em: 
http://localhost:8380/swagger-ui/index.html?url=/v3/api-docs/

![Print Swagger](https://i.ibb.co/F3wCYG2/feiranamao.png)
**************


