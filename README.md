# CleanArchProducts 

## Visão Geral
Este projeto é uma demonstração de implementação dos princípios da Clean Architecture, juntamente com a integração do Redis e Kafka em uma aplicação Spring Boot.
A Clean Architecture fornece uma maneira estruturada de desenvolver aplicações, separando preocupações e tornando a base de código mais manutenível e escalável.


## Recursos
**Clean Architecture**: O projeto segue os princípios da Clean Architecture, com uma clara separação de preocupações em camadas: Domínio, Aplicação e Infraestrutura.
**Spring Boot**: Utiliza o Spring Boot para criar uma aplicação robusta e escalável.

**Integração Redis**: Integra o Redis para o armazenamento em cache de dados, fornecendo acesso mais rápido aos dados frequentemente acessados.

**Integração Kafka**: Integra o Kafka para mensagens assíncronas entre diferentes componentes da aplicação, garantindo escalabilidade e tolerância a falhas.


## Estrutura do Projeto
O projeto está estruturado seguindo os princípios da Clean Architecture:

core: A camada core contém a lógica central do domínio da aplicação. Aqui estão definidas as entidades que representam os principais conceitos do domínio, bem como as regras de negócio que regem o comportamento da aplicação.

dataprovider: A camada dataprovider é responsável por se comunicar com provedores externos de dados, como bancos de dados, serviços web ou qualquer outra fonte de dados externa. Esta camada implementa interfaces definidas na camada core para acesso e manipulação de dados.

entrypoint: A camada entrypoint é a entrada da aplicação, onde as solicitações externas são recebidas e processadas. Isso inclui controladores REST.

config: A camada config é responsável pela configuração do Spring. Aqui são definidas todas as configurações necessárias para o funcionamento da aplicação, como configurações do kafka, configurações de beans, entre outras.
