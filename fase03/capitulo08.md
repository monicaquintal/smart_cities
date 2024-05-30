<div align="center">
<a href="https://github.com/monicaquintal" target="_blank"><img align="right" height="120px" src="../assets/logo.png" /></a>
<h1>FASE 3 - FRAMEWORKS JAVA</h1>
<h2>Capítulo 08: Microsserviços com Spring.</h2>
</div>

<div align=”center”>
<h2>1. MICROSSERVIÇOS COM SPRING BOOT</h2>
</div>

- a forma mais tradicional de construção de uma aplicação é através da `arquitetura monolítica`, onde a aplicação inteira é uma única unidade de software que mantém todos os componentes da aplicação, como a interface do usuário, a lógica de negócios e o acesso aos dados. ***Fica tudo junto e misturado em um único código***.
- `microsserviço` é uma abordagem de construção de software onde construímos um conjunto de serviços independentes e pequenos, de modo que cada um desses serviços tenha um propósito bem definido e responsável por uma única funcionalidade na aplicação. ***Cada microsserviço tem o seu próprio banco de dados e regras de negócio que não interferem em outros microsserviços***.
	- o conceito de um microsserviço é uma pequena aplicação que executa uma única tarefa de forma eficiente. 
	- é um pequeno componente que pode ser substituído e que é desenvolvido e implantado de forma independente.
	- nos últimos anos, grandes empresas como Netflix, Uber, Amazon , eBay etc. começaram a migrar suas aplicações monolíticas para a arquitetura de microsserviços.
	- ***motivações***: necessidades por escalabilidade, maior eficiência, aumento da velocidade de desenvolvimento e a facilidade de adotar novas tecnologias.
	- essa adoção pode ser feita a partir do zero, ou seja, iniciamos a construção de uma nova aplicação utilizando a arquitetura de microsserviços, ou podemos migrar uma aplicação monolítica através do desenvolvimento gradual, onde determinadas funcionalidades são extraídas do monólito paulatinamente, até que toda a aplicação esteja disponível em diversas aplicações menores (serviços) e bem definidas quanto ao seu papel na aplicação como um todo.

## 1.1 Comparando monólitos e microsserviços

- aplicações são divididas em três elementos: frontend , backend e banco de dados.
- as solicitações são feitas pelo frontend que são processadas pelo backend, que eventualmente pode consultar ou persistir dados em um sistema gerenciador de banco de dados.
- no ***desenvolvimento tradicional*** (monolítica), o backend possui todas as funcionalidades da aplicação. 
- diferentemente da estrutura monolítica, a ***arquitetura de microsserviços*** possui a sua própria infraestrutura, que é totalmente independente de outros microsserviços , onde o objetivo é construir um conjunto de pequenas aplicações, cada uma responsável por efetuar uma única tarefa, bem definida. 
- a comunicação entre um microsserviço e outro se dá através de APIs, assim, cada microsserviço expõe um conjunto de APIs, que permite que outros microsserviços consumam o serviço para o qual ele foi projetado.

## 1.2 Equipes diversas

- como cada microsserviço é uma aplicação independente, é comum que cada uma delas possua a sua própria equipe de desenvolvimento, que escolhe quais tecnologias serão utilizadas no desenvolvimento, como linguagem de programação, bibliotecas, tipo de banco de dados, metodologia de projeto etc.
- independentemente das tecnologias escolhidas pela equipe o que garante a comunicação entre os microsserviços será a API que o microsserviço expõe.

## 1.3 Arquitetura de microsserviços

- não é muito diferente de uma aplicação monolítica, já que o microsserviço também possui os três elementos presentes em qualquer aplicação; são eles:
	- `Cliente`: é um microsserviço que precisa do serviço fornecido por outro microsserviço.
	- `Backend`: é o microsserviço que processa as requisições de outros microsserviços, processando a solicitação de entrada, obtendo as informações de uma fonte de dados, formatando e devolvendo essas informações para o cliente, que geralmente é outro microsserviço que fez a solicitação.
	- `Banco de dados`: os microsserviços armazenam os dados em uma fonte de dados, em memória ou em um banco de dados externo. De modo geral, cada microsserviço possui o seu próprio banco de dados, já que ele é uma aplicação completa.
- essa arquitetura garante que os microsserviços funcionem de forma conjunta, entregando os recursos que antes eram disponibilizados por uma grande aplicação, o monólito.
- deste modo, é necessário que os elementos dessa arquitetura sejam padronizados de modo que a comunicação entre os diferentes microsserviços ocorra de forma eficiente.

### 1.3.1 Os endpoints de um microsserviço
- endpoints da API de um microsserviço devem ser padronizados, de modo que utilizem o mesmo tipo de endpoint; se o tipo de endpoint escolhido for do tipo REST, o ideal seria que os outros também seguissem esse modelo.
- as decisões sobre a arquitetura devem ser feitas de acordo com as escolhas determinadas pela organização.
- um microsserviço bem construído deve entregar ao consumidor do microsserviço o que ele se propõe a entregar.

### 1.3.2 Infraestrutura para microsserviços
- o ecossistema de microsserviços pode ser dividido em quatro camadas:
	- `Camada 1 - Hardware`: são toda a infraestrutura física necessárias para que o microsserviço possa ser executado e compreende os servidores físicos, máquinas virtuais e contêineres em nuvem.
	- `Camada 2 - Comunicação`: que permite a comunicação entre os microsserviços de forma eficiente e confiável. Essa camada compreende os serviços de balanceamento de carga, descoberta de serviço, registro de serviço e protocolos de comunicação como o HTTP/REST e RPC (Remote Procedure Calls).
	- `Camada 3 - Aplicações`: que é responsável por fornecer o ambiente necessário para executar e gerenciar os microsserviços, como o Kubernetes, Docker Swarm, Nomad etc.
	- `Camada 4 - Microsserviços`: que é a camada principal da infraestrutura com a sua própria lógica de negócio e banco de dados independentes que se comunicam através de APIs.

### 1.3.3 Vantagens e desvantagens
- vantagens:
	- `Independência`: cada microsserviço pode utilizar tecnologias independentes, assim um microsserviço pode utilizar a linguagem Java e outro a linguagem Kotlin. Além disso, cada microsserviço possui a sua própria equipe de desenvolvimento que foca o seu trabalho nas funcionalidades específicas daquele microsserviço.
	- `Foco em domínios de negócio`: os microsserviços são projetados para serem específicos para um único domínio de negócio, melhorando a divisão de responsabilidades e garantindo um melhor entendimento sobre os requisitos pela equipe de desenvolvimento.
	- `Resiliência`: a indisponibilidade de um microsserviço não impacta o funcionamento de todo o sistema. Outros serviços continuarão funcionando
normalmente.
	- `Escalabilidade`: cada microsserviço pode ser escalado para cima ou para baixo de forma independente de modo a otimizar o consumo de recursos.
	- `Manutenção mais fácil`: como o microsserviço é uma unidade de código menor, é mais simples identificar, corrigir e atualizar funcionalidades, além de permitir o reuso de código.
	- `Monitoramento`: pela natureza capilarizada dos microsserviços é mais simples identificar observar e monitorar cada microsserviço.

- desvantagens:
	- `Complexidade de infraestrutura`: como teremos a aplicação pulverizada em diversos serviços diferentes , há uma maior complexidade na configuração e
gerenciamento da infraestrutura.
	- `Comunicação entre serviços`: como os microsserviços se comunicam, na maior parte do tempo, por meio de APIs, podemos enfrentar atrasos de rede e aumentar a complexidade de integração entre os diferentes serviços.
	- `Testes`: a implementação dos testes deve levar em consideração a interação entre os microsserviços , o que torna os testes mais complexos.

<div align="center">
<h2>2. CRIANDO MICROSSERVIÇOS</h2>
</div>

## 2.1 Requisitos

- pré-requisitos:
	- `Java JDK`: ferramentas necessárias para desenvolver, compilar e executar aplicativos Java. [Link para download](https://www.oracle.com/br/java/technologies/downloads/#java21).
	- `Maven`: ferramenta de gerenciamento de projetos e automatização de
builds e dependências. [Link para download](https://dlcdn.apache.org/maven/maven-3/3.9.6/binaries/apache-maven-3.9.6-bin.zip).
  - `IntelliJ Community Edition`: Ambiente de desenvolvimento integrado.
[Link para download](https://www.jetbrains.com/idea/download).
  - `Insomnia`: cliente HTTP utilizado para efetuar requisições HTTP para APIs REST. [Link para download](https://insomnia.rest/download).
	- `Docker Desktop`: será utilizado para rodar o contêiner do banco de dados MySQL. [Link para download](https://www.docker.com/products/docker-desktop/).

## 2.2 Proposta de projeto
- sempre que estamos aprendendo uma nova tecnologia, é importante começarmos com um projeto mais simples, para entendermos de forma bastante clara todos os passos envolvidos.
- o projeto será composto por dois microsserviços:
	- ***Microsserviço de gestão de pedidos***: esse microsserviço será responsável pelo CRUD de pedidos. Ao criarmos um pedido, ele receberá o status de entrega inicial com o valor “EM_SEPARACAO”. Em cada registro de pedido teremos o número do pedido, o nome do cliente, a data do pedido, o valor do pedido e o status de entrega.
	- ***Microsserviço de gestão de entregas***: esse microsserviço será responsável por gerenciar a entrega do pedido. Em cada registro de entrega armazenaremos o número da entrega, o número do pedido, o nome do entregador, o status da entrega e a data da entrega.

### 2.2.1









---

## FAST TEST

### 1. Como se chama a arquitetura de construção de software constituída de uma única unidade que mantém todos os componentes da aplicação?
> Monolítica.
> 
### 2. Ao trabalhar com microsserviços, precisamos catalogar todos os microsserviços de modo que possam ser encontrados. Qual o nome desse mecanismo?
> Service Discovery ou Serviço de Descoberta.

### 3. Qual é o mecanismo utilizado na arquitetura de microsserviços que tem por objetivo melhorar a escalabilidade e disponibilidade dos microsserviços?
> Load Balance ou Balanceamento de Carga.

### 4. Qual é a biblioteca Java utilizada para criar clientes REST responsável por permitir a comunicação entre microsserviços?
> OpenFeign.









--- 

[Voltar ao início!](https://github.com/monicaquintal/smart_cities)