![logo](https://i.ibb.co/41jhpNj/68747470733a2f2f692e696d6775722e636f6d2f564f636d4636572e706e67-removebg-preview.png)

*****

[![License](https://img.shields.io/badge/license-MIT-blue.svg)](/LICENSE)

  * <a href="#abstract">Resumo</a>
  * <a href="#rest-api---configuracao-">Configurações recomendadas de desenvolvimento</a>
  * <a href="#web-app---backend-">BackEnd</a>
  * <a href="#web-app---frontend-">FrontEnd</a>
  * <a href="#web-app---primeiroacesso-">Primeiro Acesso</a>
  * <a href="#web-app---extra-">Extras</a>



Trabalho desenvolvido na disciplina Desenvolvimento Web e Web Semântica da UFES 2020/2, com proposito de aplicar conceitos de arquitetura, desenvolvimento web e web semântica.

O projeto é baseado nas tecnologias Java com Spring Boot para backend e Angular para o frontend. Como base de dados é usado o Postgres.


# Configurações recomendadas de desenvolvimento

```bash

git clone https://github.com/dwws-ufes/2020-feiranamao
```

## Banco de dados
```bash

docker-compose up -d
```

# BackEnd 
### Utilize uma das opções abaixo para execução da API Feira na mão
1. Baixar  [FeiraNaMao-0.0.1-SNAPSHOT.jar]( https://drive.google.com/file/d/1aO6LG4faPHh14jSJD2-Wt7eCkV4bQc3-/view?usp=sharing "Google Drive")
adicionando a raiz do projeto. 
 
     ```bash
     # Navegue até a pasta do backend
     > cd backend/
     # Gere o build da versão
     > java -jar FeiraNaMao-0.0.1-SNAPSHOT.jar
     ```
     > Não foi possível inserir no GitHub visto que é um arquivo fat jar, ultrapassa o tamanho máximo de arquivo permitido na plataforma.
    
2.  Gerar build e iniciar na maquina local 
        
     ```bash
     # Navegue até a pasta do backend
     > cd backend/
     # Gere o build da versão
     > mvn build (Obrigatório configurar variáveis de ambiente) ou no eclipse utilize a opção run as Maven Install 
     # Copie o arquivo de build gerado para pasta local
     > copy C:\Users\%username%\.m2\repository\br\com\feiranamao\FeiraNaMao\0.0.1-SNAPSHOT\FeiraNaMao-0.0.1-SNAPSHOT.jar FeiraNaMao-0.0.1-SNAPSHOT.jar 
     # Execute o FatJar
     > java -jar FeiraNaMao-0.0.1-SNAPSHOT.jar
     ```
     
3. Execute o ambiente de desenvolvimento do Spring Boot de sua preferência ( Utilizamos a IDE Eclipse ) 
     > Executar a classe principal do Spring `FeiraNaMaoAplication.java` 


----

# FrontEnd
### Utilize uma das opções abaixo para execução FrondEnd

1. Execute o ambiente de desenvolvimento do Angular de sua preferência (Utilizamos o VS Code)
```bash
cd frontend/
npm install
ng serve --open

```
2. Subir servidor na máquina local
```bash
cd frontend\dist\frontend
npm install -g http-server
http-server -a localhost -p 80 
```

3. Gerar build e subir servidor na máquina local
```bash
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


