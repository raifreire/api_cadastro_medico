# Persistindo Dados da Nossa API no Banco MySQL

##Preparando o ambiente

- acessar o spring initializr ‘https://start.spring.io/’
- criar o nosso projeto spring com as dependências iniciais
- utilizando o gerenciador de pacotes maven, que guarda nossas bibliotecas instaladas em uma pasta no usuário do s.o chamada .m2 dessa forma diminui o fluxo de rede entre projetos que demandam as mesmas bibliotecas pois não precisa baixar tudo de novo.

- Ao finalizar a criação do projeto, geramos e abrimos o projeto na nossa ide, e aguardamos o gerenciador de pacotes finalizar a sua configuração inicial.
  estrutura que é criada por esse projeto.

Uma estrutura padrão do maven com a pasta com nome do projeto, pasta src com main java e main resources, a pasta para testes.
arquivo pom.xml onde ficam informações que preenchemos do nosso projeto como nome, descrição, parte de dependências do projeto, configurações de algum pacote, 
o spring boot não como dependência do projeto, neste arquivo a uma área de ‘parent’ que seria a herança onde esse arquivo pom herda do arquivo pom do spring boot.
dentro de src > main > java ele cria o pacote raiz do nosso projeto com uma classe dentro que é criada por padrão com o método main, onde a partir dela rodamos nosso projeto.
dentro src > main > resources temos a pasta para os arquivos estáticos do nosso projeto e em templates as páginas html do projeto.
aplication.properties  é o arquivo de configurações do projeto.

a execução das aplicações web normalmente necessitavam de um servidor de aplicações tomcat, jet, glassfish, weblogic… onde nós colocamos nosso projeto dentro do servidor, 
para poder rodar nosso projeto, no spring boot isso foi simplificado. Agora dentro da nossa aplicação já vem um servidor por padrão que é o Tomcat que já vem embutido nas 
dependências. Não aparece no pom.xml do projeto porque ele vem do pom.xml que é herdado do spring boot. 


Este guia descreve como persistir dados de uma API no banco de dados MySQL utilizando o Spring Data JPA e Flyway para controle de migrações.

## Dependências e Configurações

Primeiro, adicione as dependências necessárias no arquivo `pom.xml`. Em seguida, configure o arquivo `application.properties` em `src/main/resources`.

### Propriedades do `application.properties`

Adicione as seguintes propriedades no `application.properties`:
- URL de conexão com o banco de dados
- Login do banco de dados
- Senha do banco de dados

## Criação do Banco de Dados

Para criar o banco de dados no MySQL, abra o terminal e digite:
```bash
mysql -u root -p ******
```

### gerando continuação e correção...
### obs: projeto inspirado no curso do alura Spring Boot 3: desenvolva uma API Rest em Java voll_med api.
