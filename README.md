![logo](https://i.ibb.co/41jhpNj/68747470733a2f2f692e696d6775722e636f6d2f564f636d4636572e706e67-removebg-preview.png)

*****

[![License](https://img.shields.io/badge/license-MIT-blue.svg)](/LICENSE)

  * <a href="#clonar-repositório">Clonar Repositório</a>
  * <a href="#backend">BackEnd</a>
  * <a href="#frontend">FrontEnd</a>
  * <a href="#primeiro-acesso">Primeiro Acesso</a>
  * <a href="#funções-Extras-implementadas">Extras</a>

Trabalho desenvolvido na disciplina Desenvolvimento Web e Web Semântica da UFES 2020/2, com proposito de aplicar conceitos de arquitetura, desenvolvimento web e web semântica.

O projeto é baseado nas tecnologias Java com Spring Boot para backend e Angular para o frontend. Como base de dados é usado o Postgres.

# Clonar Repositório

```bash
# Clonar pasta do projeto
> git clone https://github.com/dwws-ufes/2020-feiranamao
```

## Banco de dados
```bash
# Executar container Docker
> docker-compose up -d
```
----
# BackEnd 
### :checkered_flag: Utilizar uma das opções abaixo para execução da API Feira na mão
1. Baixar  [FeiraNaMao-0.0.1-SNAPSHOT.jar]( https://drive.google.com/file/d/1UeypFa6dQNBXesuMpKAEj0-IP-n78J97/view?usp=sharing "Google Drive")
adicionando a raiz do backend. 
 
 1. Subir servidor na máquina local 
     ```bash
     # Navegar até a pasta do backend
     > cd backend/
     # Executar o FatJar
     > java -jar FeiraNaMao-0.0.1-SNAPSHOT.jar
     ```
     > :warning: Não foi possível inserir no GitHub visto que é um arquivo fat jar, ultrapassa o tamanho máximo de arquivo permitido na plataforma.
    
    [Abrir navegador Localhost](http://localhost:8380/swagger-ui/index.html?configUrl=/v3/api-docs/ "localhost")
    
2.  Gerar build e subir servidor na máquina local
        
     ```bash
     # Navegue até a pasta do backend
     > cd backend/
     # Gerar o build da versão
     > mvn build (Obrigatório configurar variáveis de ambiente) ou no eclipse utilize a opção run as Maven Install 
     # Copiar o arquivo de build gerado para pasta local utilizando prompt de comando (CMD)
     > copy C:\Users\%username%\.m2\repository\br\com\feiranamao\FeiraNaMao\0.0.1-SNAPSHOT\FeiraNaMao-0.0.1-SNAPSHOT.jar FeiraNaMao-0.0.1-SNAPSHOT.jar 
     # Executar o FatJar
     > java -jar FeiraNaMao-0.0.1-SNAPSHOT.jar
     ```
      
    [Abrir navegador Localhost](http://localhost:8380/swagger-ui/index.html?configUrl=/v3/api-docs/ "localhost")
    
3. Executar o ambiente de desenvolvimento do Spring Boot de sua preferência ( Utilizamos a IDE Eclipse ) 
     > Executar a classe principal do Spring `FeiraNaMaoAplication.java` 

   
    [Abrir navegador Localhost](http://localhost:8380/swagger-ui/index.html?configUrl=/v3/api-docs/ "localhost")
    
----

# FrontEnd
### :checkered_flag: Utilizar uma das opções abaixo para execução FrontEnd


1. Subir servidor na máquina local
```bash
# Navegar até a pasta que tem um build previamente gerado
> cd frontend\dist\frontend
# Instalar servidor Web Local (Necessário NodeJS)
> npm install -g http-server
# Iniciar Servidor Web
> http-server -a localhost -p 80 
```
 [Abrir navegador Localhost](http://localhost"localhost")
 
2. Gerar build e subir servidor na máquina local
```bash
# Navegar até a pasta do FrontEnd
> cd frontend\
# Gerar o build do projeto para produção
> ng build --prod
# Navegar até a pasta que tem um build previamente gerado
> cd frontend\dist\frontend
# Instalar servidor Web Local (Necessário NodeJS)
> npm install -g http-server
# Iniciar Servidor Web
> http-server -a localhost -p 80 
```
 [Abrir navegador Localhost](http://localhost:"localhost")

3. Executar o ambiente de desenvolvimento do Angular de sua preferência (Utilizamos o VS Code)
```bash
# Navegar até a pasta do FrontEnd
> cd frontend/
# Instalar as independências do projeto
> npm install
# Executar aplicação Angular 11
> ng serve --open

```
 [Abrir navegador Localhost](http://localhost:"localhost")
 
----
## Primeiro Acesso
Credenciais do usuário Super Admin

| :trollface: Usuário |:key: Senha |
| ------------- | ------------- |
| application-user  | password  |

## Funções Extras implementadas
* :one: Comparação dos códigos gerados pelo frameweb com o código efetivamente implementado. (Utilizamos o código php disponibilizado)
* :two: Implementação de funcionalidades em containers (Docker com docker- composer)
* :three: Testes Unitários    (Junit)  
* :four: Cobertura de Testes (Jacoco)
* :five: Documentação de API (Swagger)

## Documentação da API disponível em: 
http://localhost:8380/swagger-ui/index.html?url=/v3/api-docs/

![Print Swagger](https://i.ibb.co/F3wCYG2/feiranamao.png)
**************
