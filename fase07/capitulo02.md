<div align="center">
<a href="https://github.com/monicaquintal" target="_blank"><img align="right" height="120px" src="../assets/logo.png" /></a>
<h1>FASE 7 - Emerging Technologies</h1>
<h2>Capítulo 02: É hora de testar.</h2>
</div>

<div align="center">
<h2>1. É HORA DE TESTAR</h2>
</div>

## 1.1 O que é BDD (Gherkin)

- é essencial compreender os testes automatizados, que são a base do BDD.
- `testes automatizados`:
  - consistem em scripts que validam o comportamento de uma aplicação, assegurando que ela funcione conforme esperado. 
  - substituem os testes manuais repetitivos, economizando tempo e recursos, além de reduzir a margem de erro humano. 
  - são fundamentais para garantir que o código se mantenha estável após modificações, permitindo que desenvolvedores e equipes de Quality Assurance (QA) verifiquem rapidamente se novos recursos ou correções de bugs não introduziram novos problemas.
- `Behavior-Driven Development (BDD)` e `linguagem Gherkin`:
  - ***BDD*** é ma metodologia que vai além do TDD (Test Driven Development (Desenvolvimento Orientado por Testes)), focando no comportamento do software do ponto de vista do usuário. 
  - utilizando a linguagem Gherkin, que permite a escrita de cenários de teste em linguagem natural, o BDD facilita a colaboração entre desenvolvedores, testadores e stakeholders não técnicos. 
  - garante que todos compartilhem um entendimento comum do que o software deve fazer, resultando em uma aplicação tecnicamente sólida e alinhada às necessidades do usuário final.

### 1.1.1 Como surgiu o BDD e seus frameworks
- o BDD nasceu como uma evolução do Test-Driven Development (TDD), criado por Dan North em 2003, com o objetivo de tornar os testes mais compreensíveis para todos os membros da equipe de desenvolvimento, incluindo aqueles sem conhecimento técnico. 
  - ele propôs que os testes fossem escritos em uma linguagem natural, facilitando a comunicação entre desenvolvedores, testadores e stakeholders.
- com o tempo, diversos frameworks foram desenvolvidos para suportar essa abordagem, sendo o ***Cucumber*** um dos mais populares, especialmente no ecossistema Java. 
  - o Cucumber permite a escrita de cenários de teste usando a linguagem Gherkin, que é simples e intuitiva, transformando esses cenários em testes executáveis. 
  - embora estejamos focando no Java Cucumber, há outros frameworks, como o SpecFlow para .NET e o Behave para Python, cada um adaptado para sua respectiva linguagem de programação. 

### 1.1.2 Documentação do framework BDD (Cucumber)
- a documentação do Cucumber desempenha papel fundamental na implementação bem-sucedida do Behavior-Driven Development (BDD). 
- o Cucumber é projetado para ser intuitivo, mas sua documentação detalhada garante que as equipes possam tirar o máximo proveito de suas funcionalidades. 
- a documentação é constantemente atualizada para refletir as mudanças e melhorias na ferramenta.

> Dica: Para aproveitar ao máximo as capacidades do Cucumber, é essencial explorar a [documentação detalhada](https://cucumber.io/docs/cucumber/).

### 1.1.3 Entendendo as diferenças e vantagens do TDD e BDD (Gherkin)
- `TDD`:
  - foca em garantir que o código funcione conforme esperado, começando com a criação de testes unitários antes mesmo do código funcional. 
  - é uma abordagem mais técnica e orientada ao desenvolvimento de pequenas partes do software de forma isolada. 
- `BDD`:
  - expande essa ideia ao envolver uma comunicação mais clara entre desenvolvedores e stakeholders, usando uma linguagem comum para especificar o comportamento esperado do software.
  - ajuda a alinhar expectativas e a criar um entendimento compartilhado do que está sendo construído.
  - optar por BDD não é apenas uma questão de testar o software, mas de garantir que o software atenda às necessidades do negócio de forma clara e compreensível para todos os envolvidos. 
  - BDD promove uma colaboração mais próxima entre as equipes e assegura que todos estejam na mesma página sobre os requisitos e funcionalidades, o que pode levar a um produto final mais alinhado com as expectativas dos usuários.

## 1.2 Escrevendo casos de teste em BDD (Gherkin)

- escrever casos de teste em BDD é um processo que requer uma compreensão clara do comportamento esperado do sistema e a capacidade de traduzir esse comportamento em cenários de teste compreensíveis por todos os membros da equipe. 
- o BDD utiliza a linguagem Gherkin para descrever esses cenários de forma simples e estruturada.

### 1.2.1 Como pensar nos cenários de teste BDD (Gherkin)
- requer uma abordagem orientada ao comportamento do sistema sob a perspectiva do usuário final. 
- é importante focar nas funcionalidades principais e nas interações que os usuários terão com o sistema. 
- ao criar cenários de teste, considere tanto as situações em que tudo ocorre conforme o esperado quanto os casos em que problemas podem surgir, assim você garante que todos os comportamentos relevantes sejam cobertos.
- para começar, pergunte-se: "Quais são os principais comportamentos que o sistema deve exibir? E o que pode dar errado?". 
  - isso ajuda a gerar uma lista abrangente de cenários que incluem tanto os casos em que tudo corre bem quanto aqueles em que o sistema lida com erros ou situações inesperadas. 
  - essa abordagem garante uma cobertura mais completa e eficaz dos testes.

### 1.2.2 Como escrever os cenários de teste em BDD (Gherkin)
- Gherkin é uma linguagem que facilita a escrita de cenários de teste de maneira clara e compreensível. 
- a estrutura básica segue o `formato "Dado-Quando-Então-E"`, que define o contexto inicial, a ação realizada pelo usuário, e o resultado esperado.
- para ilustrar, considerar exemplos de testes de API, abordando tanto um cenário onde tudo funciona corretamente eum cenário onde o sistema precisa lidar com um erro.

### a) Requisição bem-sucedida para obter detalhes do usuário
- este é um exemplo de um "caminho ideal", onde o sistema responde corretamente a uma solicitação válida.

~~~
Cenário: Requisição de detalhes do usuário com ID válido
Dado que existe um usuário com ID "12345" no sistema
Quando uma requisição GET é enviada para "/api/usuarios/12345"
Então o status da resposta deve ser 200
E a resposta deve conter os detalhes do usuário com ID "12345"
~~~

### b) Requisição falha para obter detalhes do usuário com ID inválido
- exemplo de um "caminho alternativo", onde o sistema precisa lidar com uma solicitação que não pode ser atendida devido a um erro, como um ID inválido.

~~~
Cenário: Requisição de detalhes do usuário com ID inválido
Dado que não existe um usuário com ID "99999" no sistema
Quando uma requisição GET é enviada para "/api/usuarios/99999"
Então o status da resposta deve ser 404
E a resposta deve conter uma mensagem de erro "Usuário não encontrado"
~~~

- esses cenários em Gherkin são simples e diretos, descrevendo tanto o caso em que a API responde corretamente quando requisitada com um ID válido, quanto o caso em que um ID inválido resulta em um erro apropriado. 
- essa abordagem permite que todos os stakeholders compreendam facilmente o que está sendo testado e qual é o comportamento esperado, garantindo que o sistema funcione conforme o esperado, mesmo em situações não ideais.

### 1.2.3 Boas práticas nas escritas dos cenários de teste em BDD (Gherkin)
- seguir boas práticas na escrita dos cenários de teste é fundamental para garantir que os testes sejam eficazes e fáceis de manter. 
- uma das principais práticas é evitar o excesso de detalhes técnicos nos cenários e manter o foco em uma única funcionalidade ou comportamento por cenário, o que torna os testes mais legíveis e compreensíveis.
- outra prática importante é utilizar uma linguagem consistente e evitar ambiguidades, o que é essencial para que todos os membros da equipe entendam claramente o que está sendo testado. 
  - o uso da linguagem Gherkin, em particular, facilita o reaproveitamento de passos em diferentes cenários, o que contribui para a eficiência e manutenção dos testes. 
  - ao escrever passos que podem ser reutilizados, você simplifica a criação de novos cenários e mantém a consistência na execução dos testes.
- revisar e refatoraros cenários de teste regularmente também é crucial. 
  - à medida que o sistema evolui, alguns cenários podem precisar ser atualizados para refletir mudanças na API ou no comportamento esperado. 
  - manter os cenários de teste atualizados garante que continuem a ser úteis na detecção de problemas, contribuindo para a qualidade geral do software.
- além disso, é recomendável escrever cenários que sejam independentes uns dos outros, para que possam ser executados em qualquer ordem. 
  - isso aumenta a robustez dos testes e facilita a identificação de problemas específicos quando um teste falha. 

## 1.3 Configurando o ambiente

- vamos configurar e subir um projeto dentro de um contêiner Docker, representando nossa API de entregas. 
- o projeto base já está pronto e oferece funcionalidades fundamentais para gerenciar entregas, incluindo:
  - Criar Entregas: Permite adicionar novas entregas ao sistema.
  - Deletar Entregas: Possibilita a remoção de entregas existentes.
  - Atualizar Entregas: Permite editar informações de entregas já cadastradas.
  - Buscar Entregas: Facilita a recuperação de detalhes de entregas específicas ou de todas as entregas registradas.
- após seguirmos os passos de configuração, poderemos acessar a documentação da API através do Swagger.
- nossos testes serão desenvolvidos em um projeto separado, apontando diretamente para esse ambiente Docker. 
- a ideia é simular um cenário real, como se estivéssemos fazendo requisições para uma API já em funcionamento em um servidor.
  - essa abordagem facilita a manutenção e a escalabilidade dos testes, garantindo que sejam executados em um ambiente controlado e isolado, replicando de forma precisa as condições de produção. 
- durante o processo, será necessário ter o Docker instalado na máquina e seguir alguns passos específicos no terminal para garantir que tudo esteja configurado corretamente e que o contêiner esteja pronto para receber as requisições dos testes.

> Passos:

- 1. Abrir um terminal (prompt de comando) e clonar o repositório do projeto que será executado em Docker. 

~~~
git clone https://github.com/proflealvjo/ON_TDS_JAVA_ADVANCED_MICROSSERVICES_ENTREGAS.git
~~~

- 2. Depois de clonar o projeto, navegue até o diretório que contém o Dockerfile:

~~~
cd c:\pasta-projeto\ON_TDS_JAVA_ADVANCED_MICROSSERVICES_ENTREGAS
~~~

- 3. Com o Docker já instalado no sistema, você pode construir a imagem do projeto:

~~~
docker build -t api-entregas-image .
~~~

- 4. Para garantir que a imagem foi construída com sucesso, liste as imagens Docker disponíveis:

~~~
docker images
~~~

- 5. Agora, execute o contêiner a partir da imagem criada, mapeando a porta 8080 para acessar a aplicação:

~~~
docker run -d --name my-app-entregas -p 8080:8080 api-entregas-image
~~~

- 6. Por fim, certifique-se de que o contêiner está em execução:

~~~
docker ps
~~~

- para validar se o serviço está de pé e se nossas configurações foram efetuadas com sucesso, acessar a URL /health no navegador em (http://localhost:8080/entregas/health).
- se tudo estiver funcionando corretamente, você verá a mensagem "O serviço está UP!" na tela, confirmando que a aplicação está rodando conforme esperado.

- seguindo esses passos, você terá a aplicação rodando em um contêiner Docker, pronta para ser testada de forma automatizada.

> IMPORTANTE: [Documentação da api de entregas](http://localhost:8080/swagger-ui/index.html).

### 1.3.1 Instalando e configurando a IDE (IntelliJ)
- vamos iniciar a criação da automação de testes. 
- o primeiro passo é baixar e instalar a [IntelliJ IDEA Community Edition](https://www.jetbrains.com/idea/) na sua máquina, principal ferramenta para desenvolvermos os testes automatizados.
- após instalação ou configuraçãodo IntelliJ, o próximo passo é criar o projeto onde desenvolveremos os testes automatizados.
  - para isso, utilizaremos o `Java Maven`, uma ferramenta poderosa para gerenciamento de dependências e automação do build. 

> Passos para criar o seu projeto Maven:

- 1. Após a instalação, abra a IDE. Na tela inicial, selecione a opção "New Project" para criar um novo projeto.
- 2. Na janela que se abre, clique na opção Java e escolha "Maven" como o tipo de projeto. O Maven já deve estar integrado ao IntelliJ, facilitando a configuração inicial.
- 3. Na mesma janela, você deve selecionar a JDK que será utilizada no projeto. Certifique-se de escolher uma versão compatível (como JDK 17 ou superior).
- 4. Em seguida, configurar as informações do projetoGroupId e ArtifactId.
- 5. Clique em "Create" para concluir a criação do projeto. O IntelliJ IDEA irá automaticamente configurar o projeto e baixar as dependências necessárias definidas no arquivo pom.xml.

### 1.3.2 Instalando dependências de teste e plugins






--- 

[Voltar ao início!](https://github.com/monicaquintal/smart_cities)