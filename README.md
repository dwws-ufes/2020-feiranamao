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

# BackEnd 
### Utilize uma das opções abaixo para execução da API Feira na mão
1. Baixar  [FeiraNaMao-0.0.1-SNAPSHOT.jar]( https://drive.google.com/file/d/1aO6LG4faPHh14jSJD2-Wt7eCkV4bQc3-/view?usp=sharing "Google Drive")
adicionando a raiz do projeto. 
 
    ``` 
     cd backend/
     java -jar FeiraNaMao-0.0.1-SNAPSHOT.jar```
     > Não foi possível inserir no git visto que é um arquivo fat jar, que ultrapassa o limite máximo permitido.
    
2.  Gerar build e iniciar na maquina local 
     ```
        cd backend/
        mvn build (Obrigatório configurar variáveis de ambiente) ou no eclipse utilize a opção run as Maven Install 
        copy C:\Users\%username%\.m2\repository\br\com\feiranamao\FeiraNaMao\0.0.1-SNAPSHOT\FeiraNaMao-0.0.1-SNAPSHOT.jar FeiraNaMao-0.0.1-SNAPSHOT.jar 
        java -jar FeiraNaMao-0.0.1-SNAPSHOT.jar```
     
3. No eclipse ou sua IDE de preferência execute a aplicação Maven com Spring Boot por meio do arquivo 
     > Executar a classe principal do Spring `FeiraNaMaoAplication.java` 


----

# FrontEnd
### Utilize uma das opções abaixo para execução FrondEnd

1. Execute o ambiente de desenvolvimento do Angular
```
cd frontend/
npm install
ng serve --open

```
2. Subir servidor na máquina local
```
cd frontend\dist\frontend
http-server -a localhost -p 80 
```

3. Gerar build e subir servidor na máquina local
```
cd frontend\
ng build --prod
npm install -g http-server
cd dist\frontend
http-server -a localhost -p 80 
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


