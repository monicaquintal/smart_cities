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
- após criar o projeto, será necessário configurar o IntelliJ IDEA para o desenvolvimento dos testes automatizados instalando plugins específicos. 
- os plugins `Cucumber for Java` e `Lombok` são essenciais para facilitar a escrita e a gestão dos testes.
- passos para instalação:
  - 1. No menu superior do projeto, clique em "File" e depois em "Settings". 
  - 2. No painel esquerdo, selecione "Plugins". Em seguida, na barra de pesquisa do painel de plugins, digite "Cucumber for Java" e clique no botão "Install" ao lado do plugin correspondente. Após a instalação, reinicie o IntelliJ IDEA quando solicitado.
  - 3. Repita o procedimento de busca, desta vez digitando "Lombok" na barra de pesquisa e clicando no botão "Install" ao lado do plugin Lombok. Após a instalação, reinicie o IntelliJ IDEA quando solicitado.
  - 4. No final, clique em "Apply" e depois em "OK" para salvar as configurações.

- o próximo passo é ajustar a configuração de idioma da IDE. 
- para escrever os testes em português (PT-BR), você deve desativar a verificação automática de erros gramaticais e ortográficos para inglês. 
  - caso contrário, a IDE pode interpretar palavras em português como erros e isso pode atrapalhar o desenvolvimento.
- para isso:
  - 1. Ainda na tela de "Settings" vamos até a opção editor e inspections.
  - 2. Na tela de “inspections” vamos procurar pela opção typo e desligar a opção Proofreading typo.
  - 3. No final, clique em "Apply" e depois em "OK" para salvar as configurações.

- após instalar os plugins e desabilitar o proofreading typo, para terminar de preparar seu projeto Maven para a automação de testes, você precisará ***adicionar algumas dependências essenciais no arquivo pom.xml***. 
  - essas dependências são bibliotecas e ferramentas que facilitam a escrita e execução de testes automatizados e a manipulação de dados. 
- explicação de cada uma das dependências listadas:
  - `Cucumber Java`:
    - é a ferramenta que suporta Behavior-Driven Development (BDD), permitindo que você escreva testes automatizados em uma linguagem natural, chamada Gherkin. 
    - utilizando a dependência cucumber-java, você pode criar cenários de teste em arquivos .feature e definir a lógica desses testes em classes Java.
    - executa os testes e verifica se o comportamento da aplicação corresponde às expectativas descritas nos cenários.
  - `Cucumber JUnit`:
    - é uma dependência que integra o Cucumber com o framework de testes JUnit. 
    - permite executar os cenários de teste escritos em Gherkin utilizando o JUnit, facilitando a incorporação dos testes de BDD na sua suíte de teste automatizados. 
    - com o cucumber-junit, você pode rodar os testes diretamente do IDE ou da linha de comando, aproveitando todas as funcionalidades de relatórios e integração contínua que o JUnit oferece.
  - `Lombok`:
    - é a biblioteca que ajuda a reduzir o código boilerplate em suas classes Java, como getters, setters, construtores e métodos toString(). 
    - a dependência lombok fornece anotações que são processadas pelo compilador para gerar automaticamente esse código. 
    - isso melhora a legibilidade do código e reduz a necessidade de escrever código repetitivo.
  - `Rest Assured`:
    - é a biblioteca para testes de APIs REST. 
    - simplifica a realização de requisições HTTP e a validação das respostas, tornando mais fácil testar APIs. 
    - com a dependência rest-assured, você pode escrever testes que enviam requisições para sua API, validam as respostas e verificam se a API está funcionando corretamente.
  - `Google Gson`:
    - é a biblioteca para converter objetos Java para JSON e vice-versa. 
    - a dependência gson permite manipular dados JSON de forma eficiente, facilitando a serialização e deserialização de objetos em seus testes.
- para incluir essas dependências no projeto Maven, adicione o seguinte bloco de código ao seu arquivo pom.xml:

~~~xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <groupId>org.example</groupId>
    <artifactId>testes-automatizados</artifactId>
    <version>1.0-SNAPSHOT</version>
    <properties>
        <maven.compiler.source>21</maven.compiler.source>
        <maven.compiler.target>21</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>
    <dependencies>
        <!-- Cucumber Java -->
        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-java</artifactId>
            <version>7.18.1</version>
            <scope>test</scope>
        </dependency>
        <!-- Lombok -->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>1.18.34</version>
            <scope>provided</scope>
        </dependency>
        <!-- Rest Assured -->
        <dependency>
            <groupId>io.rest-assured</groupId>
            <artifactId>rest-assured</artifactId>
            <version>5.5.0</version>
            <scope>test</scope>
        </dependency>
        <!-- Google Gson -->
        <dependency>
            <groupId>com.google.code.gson</groupId>
            <artifactId>gson</artifactId>
            <version>2.11.0</version>
        </dependency>
        <!-- Cucumber Junit -->
        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-junit</artifactId>
            <version>7.18.1</version>
            <scope>test</scope>
        </dependency>
    </dependencies>
</project>
~~~

- após adicionar essas dependências, atualize seu projeto Maven para garantir que todas as bibliotecas sejam baixadas e configuradas corretamente. 

> IMPORTANTE: Para garantir a compatibilidade com o Cucumber, é necessário colocar a versão 21 do Javaa ser usada durante a compilação, pois a versão 22 ainda não é totalmente suportada pela biblioteca. No arquivo pom.xml do projeto, definimos a versão 21 como o alvo de compilação, utilizando as propriedades maven.compiler.source e maven.compiler.target.

## 1.4 Automatizando

- agora que o ambiente está preparado, iniciaremos o desenvolvimento do projeto automatizado de testes para a API de entregas que subimos no docker. 
- durante este processo, abordaremos diferentes cenários de testes, incluindo aqueles que verificam o comportamento esperado da API (caminho feliz) e aqueles que validam como a API lida com situações inesperadas ou entradas inválidas (caminho não favorável).
- além disso, validaremos os testes de contrato, que são essenciais para garantir que a comunicação entre serviços mantenha o formato, estrutura e dados esperados. 
  - os testes de contrato verificam se o contrato entre o cliente (consumidor) e o servidor (provedor) é respeitado, garantindo que ambos os lados mantenham consistência na troca de informações.

### 1.4.1 Arquitetura da automação
- nesta etapa, definiremos a arquitetura do projeto de automação. 
- toda a estrutura de testes estará contida dentro da `pasta padrão src/test` do projeto Maven, garantindo a organização e fácil manutenção dos testes automatizados.
- dentro da estrutura de automação, teremos uma série de pacotes organizados para facilitar a manutenção e o entendimento dos testes, agora que entendemos isso vamos preparar a arquitetura do projeto.
- ***crie uma `pasta features`, localizada dentro do diretório src/test/resources***, lá estarão os arquivos de testes iniciais escritos em linguagem natural, utilizando o formato Gherkin. 
  - esses arquivos especificam os cenários de teste de forma descritiva, permitindo que qualquer membro da equipe, mesmo sem conhecimentos técnicos profundos, entenda o comportamento esperado da aplicação.
- ***crie um `pacote steps` dentro da pasta src/test/java***, ele será responsável pelas definições de passos que executarão as ações descritas nos arquivos de feature. 
  - aqui, os métodos traduzirão as etapas escritas em Gherkin para código Java, conectando os cenários de teste diretamente à lógica real da aplicação.
- ***outro pacote importante que devemos criar é o `services`, também dentro da pasta src/test/java***, ele conterá classes que representam serviços ou operações reutilizáveis dentro dos testes, como as chamadas HTTP para APIs, utilizando o Rest Assured.
  - centralizando todas as interações com serviços externos ou internos, promovemos a reutilização de código e reduzimos duplicações.
- por fim, ***crie um `pacote model` dentro da pasta src/test/java***, nele manteremos as classes de modelo e objetos de transferência de dados (DTOs). 
  - eles serão usados para representar dados durante as requisições e validações dos testes, facilitando a conversão entre diferentes formatos, como JSON e objetos Java, com a ajuda da biblioteca Google Gson.

### 1.4.2 Implementando o nosso primeiro cenário de teste
- o primeiro passo será criar um teste focado na validação dos códigos de status da API, garantindo que cada endpoint retorne o código de resposta HTTP esperado.
- a validação de status code é um tipo de verificação essencial para determinar se a API está respondendo corretamente aos diferentes tipos de requisições. 
- essa abordagem consiste em enviar uma requisição HTTP para um endpoint específico e verificar se o código de status retornado está de acordo com o comportamento esperado.
- `o primeiro teste será para validar o processo de cadastro de uma nova entrega através da API de entregas`.
  - nosso objetivo é garantir que, quando enviarmos uma requisição POST com os dados da entrega, a API retorne o status code 201 (Created) e o corpo da resposta confirme que a entrega foi registrada corretamente. 
  - este tipo de teste é crucial para assegurar que a funcionalidade de criação de novos registros de entrega esteja funcionando conforme esperado.
- primeiramente, ***criar um arquivo chamado CadastroEntregas.feature dentro da pasta features*** , que está localizada em src/test/resources/featuresno projeto Maven. 
  - esse arquivo servirá como o ponto inicial para definir nossos testes automatizados.
  - após criar o arquivo CadastroEntregas.feature, escrever o seguinte teste:

~~~
# language: pt
Funcionalidade: Cadastro de nova entrega
  Como usuário da API
  Quero cadastrar uma nova entrega
  Para que o registro seja salvo corretamente no sistema
  Cenário: Cadastro bem-sucedido de entrega
    Dado que eu tenha os seguintes dados da entrega:
      | campo          | valor        |
      | numeroPedido   | 1            |
      | nomeEntregador | Ana Silva    |
      | statusEntrega  | EM_SEPARACAO |
      | dataEntrega    | 2024-08-22   |
    Quando eu enviar a requisição para o endpoint "/entregas" de cadastro de entregas
    Então o status code da resposta deve ser 201
~~~

- no Gherkin, ao escrever dados em tabelas, você pode utilizar aspas ("") para denotar valores que devem ser tratados como strings, mesmo que não contenham espaços ou caracteres especiais. 
- no entanto, quando você está passando números inteiros, não é necessário usar aspas, pois o Gherkin reconhece automaticamente que esses valores são números e não strings.
- outro ponto impotente e que no Gherkin, o pipe (|) é utilizado para definir as colunas e separar os valores em tabelas, conhecido como `dataTables`. 
  - ele ajuda a organizar e visualizar os dados de maneira clara e estruturada. 
  - ao usá-los, você pode facilmente definir e manipular os dados necessários para os testes.

> DICA: A linha # language: pt é usada para definir a linguagem em que o arquivo de feature será escrito. Nesse caso, indicamos que o arquivo estará em português, permitindo que as palavras-chave do Gherkin (Funcionalidade, Cenário, Dado, Quando, E, Então) sejam reconhecidas no idioma escolhido.

- agora que escrevemos o primeiro teste “Cadastro bem-sucedido de entrega” em linguagem natural utilizando Gherkin, podemos continuar criando o ***arquivo de steps***. 
- esse arquivo será responsável por definir a camada intermediária entre os cenários de teste e a implementação do código de automação. 
- os steps traduzem cada linha do cenário para comandos em Java, que irão executar as ações descritas, como enviar uma requisição ou verificar o retorno da API.
- `para gerar o arquivo de steps`, vamos fazer os seguintes passos:
  - no arquivo de CadastroEntrega.feature, clique na lâmpada amarela de sugestão ao lado de qualquer passo destacado no arquivo de feature. Alternativamente, você pode pressionar Alt + Enter para abrir as opções. Em seguida, selecione a opção "Create all step definitions".
  - após selecionar a opção "Create all step definition" na caixa de sugestões, na janela que aparece, preencha os campos da seguinte forma: no campo "File Name", insira CadastroEntregasSteps; no campo "File Type", selecione a opção Java; e no campo "File Location", selecione src/test/java/steps e clique em “OK”.
  - um arquivo será gerado contendo as definições dos passos em Gherkin no formato Java. Esse arquivo estará vinculado ao arquivo feature e permitirá que os testes sejam executados de acordo com os cenários descritos.
  - agora que o step CadastroEntregasSteps foi gerado, é recomendável modificar o código para tornar os parâmetros mais compreensíveis. Os parâmetros arg0, arg1, etc., podem ser muito abstratos. Renomeie para algo mais significativo de acordo com o contexto do teste, o que facilitará a leitura e a manutenção do código.

~~~
package steps;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
public class CadastroEntregasSteps {
    @Dado("que eu tenha os seguintes dados da entrega:")
    public void queEuTenhaOsSeguintesDadosDaEntrega() {
    }
    @Quando("eu enviar a requisição para o endpoint {string} de cadastro de entregas")
    public void euEnviarARequisiçãoParaOEndpointDeCadastroDeEntregas(String endPoint) {
    }
    @Então("o status code da resposta deve ser {int}")
    public void oStatusCodeDaRespostaDeveSer(int statusCode) {
    }
}
~~~

- após o ajuste dos steps, vamos criar uma `classe de modelo EntregaModel` dentro da pasta src/teste/java/model. 
- este arquivo representará a entidade de criação de entrega e incluirá campos que correspondem ao corpo de uma requisição para cadastro de entregas. 
- os atributos principais do modelo serão numeroPedido, nomeEntregador, statusEntrega e dataEntrega.
- além dos campos que representam os dados da entrega, o modelo também incluirá um campo adicional chamado numeroEntrega, que servirá como um identificador único da entrega.
- para evitar que o campo numeroEntrega seja incluído ao enviar a requisição de cadastro, mas ainda permitir que ele seja usado ao receber a resposta da API, usaremos a `anotação @Expose(serialize = false)`.
  - isso faz com que o campo numeroEntrega seja excluído do processo de serialização (quando o objeto Java é convertido para JSON), mas ainda esteja disponível para desserialização (quando o JSON é convertido de volta para o objeto Java). 
  - assim, o objetivo é ter o numeroEntrega apenas para recuperar o ID de uma entrega após a criação ou para testes futuros, sem enviá-lo desnecessariamente na requisição inicial.
  - ao marcar os outros campos com @Expose, estamos especificando que esses campos sempre devem ser considerados durante os processos de conversão entre o objeto Java e o JSON.
  - isso é especialmente útil quando se deseja ter controle total sobre quais campos serão expostos ou ocultados durante a serialização ou desserialização.
- usaremos também a `anotação @Data` do Lombok na classe EntregaModel. 
  - a anotação @Data fornece automaticamente implementações para métodos comuns de uma classe de modelo, economizando tempo e reduzindo a quantidade de código que você precisa escrever. 
  - especificamente, @Data gera os métodos getters e setters para todos os campos da classe, cria uma implementação do método toString() que retorna uma representação legível dos atributos da classe, e implementa os métodos equals() e hashCode() com base nos campos da classe, permitindo comparações e uso da classe em coleções baseadas em hash. 
  - além disso, @Data cria um construtor que inicializa todos os campos da classe, facilitando a criação de objetos com todos os atributos definidos.
  - assim, ao usar @Data, você mantém o código da classe EntregaModel limpo e conciso, enquanto ainda aproveita todas essas funcionalidades automaticamente.

~~~
package model;
import com.google.gson.annotations.Expose;
import lombok.Data;
@Data
public class EntregaModel {
    @Expose(serialize = false)
    private int numeroEntrega;
    @Expose
    private int numeroPedido;
    @Expose
    private String nomeEntregador;
    @Expose
    private String statusEntrega;
    @Expose
    private String dataEntrega;
}
~~~

- o objetivo do arquivo de modelo é garantir que os dados possam ser corretamente serializados e desserializados quando enviados ou recebidos pela API, o que facilita a integração entre o cliente e o servidor, assegurando que os dados estejam no formato correto durante o processo de comunicação.

- criar o `arquivo CadastroEntregasService` dentro da pasta src/teste/java/services. 
  - este arquivo será responsável por encapsular a lógica de negócios relacionada ao cadastro de entregas. 
  - ele atuará como uma camada final entre a lógica de teste e o código da aplicação, facilitando a execução dos testes de forma organizada e eficiente. 
  - o CadastroEntregasService deve incluir métodos que interajam com a API ou o sistema a ser testado, possibilitando a realização das operações necessárias para validar os cenários definidos nos testes.
  - com a classe criada, passamos para a definição das variáveis e dependências necessárias. 
  - incluiremos uma instância do modelo EntregaModel, uma instância do Gson para manipulação de JSON, uma variável response para armazenar a resposta da API e por fim a variável baseUrl para ser a URL base da API.

~~~java
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.response.Response;
public class CadastroEntregasService {
    
    final EntregaModel entregaModel = new EntregaModel();
    public final Gson gson = new GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .create();
    public Response response;
    String baseUrl = "http://localhost:8080";
}
~~~

- a variável entregaModel é uma instância do modelo que representa uma entrega; será utilizada para criar e manipular os dados da entrega durante os testes. 
- a variável gson é uma instância da biblioteca Gson, que facilita a serialização e desserialização de objetos Java em JSON e vice-versa.
- a configuração excludeFieldsWithoutExposeAnnotation garante que apenas os campos anotados com @Expose sejam incluídos na conversão JSON, oferecendo um controle mais preciso sobre os dados manipulados.
- a variável response servirá para armazenar a resposta das requisições feitas à API, permitindo a análise e validação dos resultados durante os testes.
- a variável baseUrl armazenará a URL base da API, que será usada para compor as URLs das requisições feitas durante os testes. 
  - neste exemplo, estamos utilizando http://localhost:8080, que é a URL local onde a API está sendo executada.

- com a estrutura básica da classe CadastroEntregasService e a definição das variáveis essenciais já estabelecidas, vamos focar na implementação do `método setFieldsDelivery()`. 
  - este método permitirá a configuração dinâmica dos campos do modelo EntregaModel, facilitando a preparação de dados para os testes.
  - o método setFieldsDelivery() é projetado para ajustar os campos do objeto entregaModel com base nos parâmetros fornecidos.

~~~java
public void setFieldsDelivery(String field, String value) {
        switch (field) {
            case "numeroPedido" -> entregaModel.setNumeroPedido(Integer.parseInt(value));
            case "nomeEntregador" -> entregaModel.setNomeEntregador(value);
            case "statusEntrega" -> entregaModel.setStatusEntrega(value);
            case "dataEntrega" -> entregaModel.setDataEntrega(value);
            default -> throw new IllegalStateException("Unexpected feld" + field);
        }
    }
~~~

- o método setFieldsDelivery() aceita dois parâmetros: ***field***, que é uma string representando o nome do campo a ser ajustado, e ***value***, que é o valor a ser atribuído a esse campo. 
- dependendo do valor de field, o método utiliza um bloco switch para determinar qual setter do entregaModel deve ser chamado.
- se o valor de field não corresponder a nenhum dos casos esperados, o método lança uma ***exceção IllegalStateException***, indicando que um campo inesperado foi fornecido.

- após configurarmos os campos da entrega com o método setFieldsDelivery(), o próximo passo é implementar o `método createDelivery()`.
- este método é responsável por enviar uma requisição POST para a API, criando uma entrega com base nos dados passados para a variável entregaModel.

~~~java
public void createDelivery(String endPoint) {
        String url = baseUrl + endPoint;
        String bodyToSend = gson.toJson(entregaModel);
        response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(bodyToSend)
                .when()
                .post(url)
                .then()
                .extract()
                .response();
    }
~~~

- o método createDelivery()é responsável por enviar uma requisição POST para a API com o intuito de criar uma nova entrega. 
- para isso, o método inicia construindo a URL completa necessária para a requisição. 
  - essa URL é formada pela combinação da URL base (baseUrl) com o endpoint (endPoint) fornecido como parâmetro, permitindo especificar diferentes endpoints conforme o tipo de requisição que se deseja realizar.
  - em seguida, o método serializa a variável entregaModel para uma representação JSON utilizando a instância do Gson. 
  - esse processo de serialização é feito através do método gson.toJson(), que converte o objeto entregaModel em uma string JSON chamada bodyToSend, contendo todos os dados da entrega que serão enviados na requisição.
  - depois de preparar o corpo da requisição, o método configura e envia a requisição POST utilizando a biblioteca Rest Assured, amplamente usada para realizar testes automatizados de APIs em Java e permite uma abordagem fluente e legível para a construção de requisições e validação de respostas.
- para configurar e enviar a requisição POST, utilizamos a abordagem fluente da Rest Assured, que é composta pelos métodos given(), when(), then(), e outros:
  - a) `given()`: 
    - utilizado para configurar a requisição. 
    - nele, você define os parâmetros e os dados que serão enviados com a requisição. 
    - no caso do método createDelivery, utilizamos given() para definir o tipo de conteúdo da requisição e o corpo da requisição. 
    - especificamente, contentType(ContentType.JSON) indica que o tipo de conteúdo da requisição é JSON, e body(bodyToSend) define o corpo da requisição, que é a string JSON contendo os dados da entrega.
    - também configuramos accept(ContentType.JSON) para indicar que esperamos uma resposta no formato JSON.
  - b) `when()`:
    - é um método utilizado para definir a ação que será realizada, como POST, GET, PUT e DELETE, que são os métodos HTTP mais comuns. 
    - neste caso específico, estamos utilizando o método POST, então implementamos: when().post(url), que especifica que uma requisição POST será enviada para a URL construída. 
    - a URL é a combinação da URL base e do endpoint fornecido, para onde os dados da entrega serão enviados.
  - c) `método then()`:
    - é utilizado para definir as etapas de validação da resposta.
    - é responsável por especificar as expectativas para a resposta da API. 
    - no exemplo, then() prepara o pipeline para extrair e analisar a resposta retornada pela API.
  - d) `método extract()`:
    - extrai a resposta da requisição, e `response()` retorna o objeto Response que contém todos os detalhes da resposta, como o status code, o corpo da resposta, e os headers. 
    - esta resposta é então armazenada na variável response, permitindo que você a análise e valide em testes subsequentes.

- em resumo, o método createDelivery() configura e envia uma requisição POST para a API, definindo o tipo de conteúdo e o corpo da requisição com a biblioteca Rest Assured. 
- após enviar a requisição, a resposta é extraída e armazenada para que possa ser validada, assegurando que a operação de criação de entrega foi bem-sucedida e que a API está funcionando conforme o esperado.
- após a implementação de todos os métodos descritos, a classe CadastroEntregasService() final será:

~~~java
package services;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.EntregaModel;
import static io.restassured.RestAssured.given;
public class CadastroEntregasService {
    final EntregaModel entregaModel = new EntregaModel();
    public final Gson gson = new GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .create();
    public Response response;
    String baseUrl = "http://localhost:8080";
    public void setFieldsDelivery(String field, String value) {
        switch (field) {
            case "numeroPedido" -> entregaModel.setNumeroPedido(Integer.parseInt(value));
            case "nomeEntregador" -> entregaModel.setNomeEntregador(value);
            case "statusEntrega" -> entregaModel.setStatusEntrega(value);
            case "dataEntrega" -> entregaModel.setDataEntrega(value);
            default -> throw new IllegalStateException("Unexpected feld" + field);
        }
    }
    public void createDelivery(String endPoint) {
        String url = baseUrl + endPoint;
        String bodyToSend = gson.toJson(entregaModel);
        response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(bodyToSend)
                .when()
                .post(url)
                .then()
                .extract()
                .response();
    }
}
~~~

- com o CadastroEntregasService configurado e pronto para ser usado, o próximo passo é voltarmos e ***integrar esse serviço na classe de passos CadastroEntregasSteps***, que será responsável pelas interações com a API e pela serialização dos objetos durante os testes.
- primeiramente, precisamos garantir que a classe CadastroEntregasSteps inclua uma instância do CadastroEntregasService. 
  - isso permitirá que os métodos da classe de passos façam uso do serviço para realizar operações de criação de entregas e outras ações necessárias para os testes.
  - criar o seguinte objeto cadastroEntregasService:

~~~java
package steps;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import services.CadastroEntregasService;
public class CadastroEntregasSteps {
    CadastroEntregasService cadastroEntregasService = new CadastroEntregasService();
}
~~~

- com o objeto cadastroEntregasService instanciado, podemos agora passar para a implementação do código Java do primeiro passo, que será responsável por configurar os dados da entrega a partir de uma lista de mapas fornecida no cenário de teste.
- o método anotado com ***@Dado("que eu tenha os seguintes dados da entrega:")*** precisa ser implementado para ler os dados da entrega e configurar o modelo usando o serviço. 
- no método que antes estava vazio, vamos adicionar o código para iterar sobre a lista de mapas que vem como DataTable fornecido pelo cenário de teste no arquivo CadastroEntrega.feature e usar o setFieldsDelivery()para definir os valores dos campos da entrega.

~~~java
@Dado("que eu tenha os seguintes dados da entrega:")
public void queEuTenhaOsSeguintesDadosDaEntrega(List<Map<String, String>> rows) {
        for(Map<String, String> columns : rows) {
            cadastroEntregasService.setFieldsDelivery(columns.get("campo"), columns.get("valor"));
        }
 }
~~~

- nesse código, o método recebe uma lista de mapas, onde cada mapa representa um conjunto de dados para a entrega. 
- o método itera sobre cada mapa e utiliza o método setFieldsDelivery()do objeto cadastroEntregasService para configurar os campos com os valores fornecidos.
- o próximo passo é a implementação do código Java no método anotado com ***@Quando("eu enviar a requisição para o endpoint {string} de cadastro de entregas")***, que antes estava vazio. 
- esse método será responsável por enviar a requisição para o endpoint de cadastro de entregas.

~~~java
@Quando("eu enviar a requisição para o endpoint {string} de cadastro de entregas")
    public void euEnviarARequisiçãoParaOEndpointDeCadastroDeEntregas(String endPoint) {
        cadastroEntregasService.createDelivery(endPoint);
    }
~~~ 

- dentro do método chamamos o método createDelivery() do cadastroEntregasService, passando o endPoint fornecido pelo cenário de teste no arquivo CadastroEntrega.feature.
- o método createDelivery() constrói a URL completa para a requisição POST combinando a URL base com o endpoint fornecido. Além disso, ele serializa o objeto entregaModepara JSON e envia a requisição POST para a URL construída.
- com o esses passos já preparados, o último passo é adicionar a implementação do código Java no método anotado com ***@Então("o status code da resposta deve ser {int}")***, que antes estava vazio.
  - o método é utilizado para verificar se o código de status da resposta da API corresponde ao valor esperado fornecido pelo cenário de teste no arquivo CadastroEntrega.feature.

~~~java
@Então("o status code da resposta deve ser {int}")
    public void oStatusDaRespostaDeveSer(int statusCode) {
        Assert.assertEquals(statusCode, cadastroEntregasService.response.statusCode());
    }
~~~

- neste método, o parâmetro {int} é utilizado para receber o código de status esperado da resposta. 
  - este valor é fornecido como um inteiro no cenário de teste no arquivo CadastroEntrega.feature, e representa o código de status HTTP que a resposta da API deve retornar.
- o método compara o código de status esperado com o código de status da resposta obtida pela requisição.
  - a comparação é feita utilizando o método Assert.assertEquals(), que verifica se o código de status da resposta cadastroEntregasService.response.statusCode() é igual ao código esperado fornecido no parâmetro.
- a classe CadastroEntregasSteps final, após a inclusão de todos os métodos, ficará assim:

~~~java
package steps;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import services.CadastroEntregasService;
import java.util.List;
import java.util.Map;
public class CadastroEntregasSteps {
    CadastroEntregasService cadastroEntregasService = new CadastroEntregasService();
    @Dado("que eu tenha os seguintes dados da entrega:")
    public void queEuTenhaOsSeguintesDadosDaEntrega(List<Map<String, String>> rows) {
        for(Map<String, String> columns : rows) {
            cadastroEntregasService.setFieldsDelivery(columns.get("campo"),  columns.get("valor"));
        }
    }
    @Quando("eu enviar a requisição para o endpoint {string} de cadastro de entregas")
    public void euEnviarARequisiçãoParaOEndpointDeCadastroDeEntregas(String endPoint) {
        cadastroEntregasService.createDelivery(endPoint);
    }
    @Então("o status code da resposta deve ser {int}")
    public void oStatusDaRespostaDeveSer(int statusCode) {
        Assert.assertEquals(statusCode, cadastroEntregasService.response.statusCode());
    }
}
~~~

- após seguirmos esses passos, o primeiro teste está pronto para ser executado. 
- para isso, voltamos ao arquivo CadastroEntregas.feature, onde temos o cenário escrito para o cadastro bem-sucedido de entrega. 
- no ambiente de desenvolvimento Intellij onde o Cucumber está integrado, você encontrará um botão verde, geralmente simbolizando a execução dos testes, que pode ser identificado como um botão "Play" ou similar.
- ao clicar no botão verde, o Cucumber irá executar o cenário de teste definido no arquivo CadastroEntregas.feature.
  - o Cucumber começará lendo o arquivo e identificando o cenário de teste, preparando o ambiente necessário para a execução. 
  - em seguida, ele executará os métodos anotados com @Dado, @Quando e @Então na classe CadastroEntregasSteps, seguindo a ordem estabelecida no cenário. 
  - isso envolve preencher os dados da entrega, enviar a requisição para o endpoint e validar o código de status da resposta. 
  - após a execução, um relatório será gerado, mostrando quais cenários passaram ou falharam, permitindo uma análise detalhada dos resultados dos testes.
- se o teste passar, confirmará que a automação está funcionando conforme o esperado, validando que o processo de cadastro de entrega está operando corretamente. 

> IMPORTANTE: [Link da solução implementada até o momento para download no GITHUB](https://github.com/proflealvjo/testes-automatizados/tree/3.4-primeiro-cenario).

### 1.4.3 Validação do corpo das respostas API de entregas
- agora que já criamos o primeiro cenário de teste, cujo foco é validar o status code da resposta, podemos evoluir esse teste para torná-lo ainda mais robusto. 
- além de validar o código de status, é importante considerar que, em muitos casos, também precisamos validar o corpo da resposta do endpoint, verificando se mensagens de erro, sucesso, ou outros detalhes específicos estão presentes. 
- esse tipo de validação adicional permite que o teste seja mais completo, garantindo não apenas que a API responde, mas que ela responde de maneira correta e esperada em todos os aspectos.
- já temos o cenário de sucesso "Cadastro bem-sucedido de entrega" implementado, então vamos criar um cenário no arquivo CadastroEntregas.feature para cobrir uma situação em que o cadastro da entrega não seja realizado com sucesso. 
- este novo cenário será chamado de ***"Cadastro de entrega sem sucesso ao passar o campo statusEntrega inválido"***, e deverá seguir alguns passos adicionais escritos em Gherkin para simular uma condição onde a requisição falha, como quando há dados inválidos ou ausentes.
- neste novo cenário, vamos testar o comportamento da endpoint da API quando o campo statusEntrega recebe um valor inválido.
- neste caso, ao tentar cadastrar uma entrega, ela só aceita três valores específicos: EM_SEPARACAO, EM_TRANSPORTE e ENTREGUE. 
  - qualquer valor fora desses três será considerado inválido e resultará em um erro de validação. 
  - ao enviar o valor diferente "EM_ROTA", esperamos que o endpoint da API retorne um código de status 400, indicando que a requisição é inválida. 
  - além disso, vai fornecer uma mensagem clara no corpo da resposta explicando o motivo da falha, como: 

~~~json
{
  "message": "Dados fornecidos estão em formato inválido."
}
~~~

- vamos escrever o novo cenário abaixo do cenário de sucesso, para simular esse comportamento de falha da requisição.

~~~
Cenário: Cadastro de entrega sem sucesso ao passar o campo statusEntrega inválido
    Dado que eu tenha os seguintes dados da entrega:
      | campo          | valor      |
      | numeroPedido   | 1          |
      | nomeEntregador | Ana Silva  |
      | statusEntrega  | EM_ROTA    |
      | dataEntrega    | 2024-08-22 |
    Quando eu enviar a requisição para o endpoint "/entregas" de cadastro de entregas
    Então o status code da resposta deve ser 400
~~~

- ainda assim, mesmo com o cenário "Cadastro de entrega sem sucesso ao passar o campo statusEntrega inválido" escrito dessa forma, não está totalmente preparado para validar o corpo de resposta da requisição, que é o objetivo neste momento. 
- atualmente, o cenário apenas verifica se o status code retornado é 400, mas não garante que a mensagem de erro correta seja exibida no corpo da resposta.
- para alcançar essa validação mais completa, precisamos incluir um novo passo no Gherkin chamado `"E"`, e que assegure que a mensagem de erro retornada pela API corresponda exatamente ao esperado. 
  - esse novo passo irá verificar se o corpo da resposta contém a mensagem específica "Dados fornecidos estão em formato inválido".
- ocenário atualizado, com a verificação adicional, ficará assim:

~~~
Cenário: Cadastro de entrega sem sucesso ao passar o campo statusEntrega inválido
    Dado que eu tenha os seguintes dados da entrega:
      | campo          | valor      |
      | numeroPedido   | 1          |
      | nomeEntregador | Ana Silva  |
      | statusEntrega  | EM_ROTA    |
      | dataEntrega    | 2024-08-22 |
    Quando eu enviar a requisição para o endpoint "/entregas" de cadastro de entregas
    Então o status code da resposta deve ser 400
    E o corpo de resposta de erro da api deve retornar a mensagem "Dados fornecidos estão em formato inválido."
~~~

- com este novo passo adicionado ***"E o corpo de respostade erroda api deve retornar a mensagem "Dados fornecidos estão em formato inválido."***, garantimos que, além de verificar o código de status, o teste também valida se a mensagem de erro esperada é realmente retornada pela API, proporcionando um nível de verificação mais robusto para o cenário de falha.
- ao adotar essa abordagem, conseguimos reaproveitar os passos já escritos, uma das principais vantagens do Gherkin.
- agora que escrevemos esse novo passo, vamos implementá-lo na classe de CadastroEntregasSteps e prosseguir com as implementações necessárias em Java para garantir que a validação desse passo seja realizada com sucesso.
- no `arquivo CadastroEntrega.feature`, clique na lâmpada amarela de sugestão ao lado do novo passo destacado no arquivo. Esse novo passo, estará sublinhados em amarelo. Alternativamente, você pode pressionar Alt + Enterpara abrir as opções. Em seguida, selecione a opção "Createstep definition".

- após selecionar o arquivo CadastroEntregasSteps, será criado um novo passo no arquivo com a seguinte definição.

~~~java
@E("o corpo de resposta de erro da api deve retornar a mensagem {string}")
    public void oCorpoDeRespostaDeErroDaApiDeveRetornarAMensagem(String arg0) {
    }
~~~

- por boas práticas, renomear o argumento arg0 para algo mais significativo e alinhado com o contexto do passo. 
- no caso, o argumento pode ser renomeado para message, que representará a mensagem de erro a ser validada.

~~~java
@E("o corpo de resposta de erro da api deve retornar a mensagem {string}")
    public void oCorpoDeRespostaDeErroDaApiDeveRetornarAMensagem(String message) {
    }
~~~

- o próximo passo é criar o modelo que represente a resposta de erro, o que permitirá deserializar o JSON para objeto Java e acessar a mensagem de erro. 
- criaremos um novo modelo dentro do pacote src/test/java/model chamado ErrorMessageModel. 
- a classe ErrorMessageModel será responsável por mapear a estrutura da resposta de erro e facilitar a manipulação dos dados em nossos testes.

~~~java
package model;
import com.google.gson.annotations.Expose;
import lombok.Data;
@Data
public class ErrorMessageModel {
    @Expose
    private String message;
}
~~~

- após criar o modelo ErrorMessageModel, o próximo passo é voltar ao arquivo de CadastroEntregasSteps e concluir a implementação do código java no passo ***"@E("o corpo de resposta de erro da api deve retornar a mensagem {string}")"*** que estava vazio.

~~~java
@E("o corpo de resposta de erro da api deve retornar a mensagem {string}")
    public void oCorpoDeRespostaDeErroDaApiDeveRetornarAMensagem(String message) {
        ErrorMessageModel errorMessageModel = cadastroEntregasService.gson.fromJson(
                cadastroEntregasService.response.jsonPath().prettify(), ErrorMessageModel.class);
        Assert.assertEquals(message, errorMessageModel.getMessage());
    }
~~~

- primeiro, usamos o método fromJson do gson, acessado através do objeto cadastroEntregasService, para converter a resposta da API em um objeto da classe ErrorMessageModel. 
- a resposta da API, armazenada em cadastroEntregasService.response, é convertida para uma string formatada em JSON usando jsonPath().prettify(). 
- em seguida, fromJson transforma essa string JSON em um objeto da classe ErrorMessageModel.
- com o objeto errorMessageModel criado, acessamos a mensagem de erro com o método getMessage(). 
- comparamos essa mensagem com a mensagem esperada, fornecida pelo cenário de teste no arquivo CadastroEntrega.feature. para o método, utilizando Assert.assertEquals. 
- essa asserção garante que a mensagem retornada pela API corresponde à mensagem esperada. 
- se a comparação falhar, o teste indicará que houve um problema com a mensagem de erro retornada pela API.
- agora que implementamos a validação e entendemos o que o código faz, podemos executar o teste. 
- no arquivo CadastroEntrega.feature, localizamos o ***cenário "Cadastro de entrega sem sucesso ao passar o campo statusEntrega inválido"***, e clicamos no ícone de execução (play). Em seguida, selecionamos a opção "Run" para executar o teste e verificar se tudo está funcionando corretamente.

> IMPORTANTE: [Link da solução implementada até o momento para download no GITHUB](https://github.com/proflealvjo/testes-automatizados/tree/3.4.3-validando-response).

### 1.4.4 Usando contexto nos testes da API de entregas
- outro ponto importante no desenvolvimento de testes com Gherkin é o uso de contexto.
- o contexto no Gherkin permite definir condições ou estados iniciais que precisam estar presentes antes da execução de um cenário. 
- isso ajuda a preparar o ambiente de teste e a garantir que os testes sejam executados de maneira consistente, independentemente da ordem ou da combinação de cenários. 
- é fundamental para garantir que todos os cenários sejam reproduzidos sob as mesmas condições, aumentando a confiabilidade e a reprodutibilidade dos testes automatizados.
- imagine que queremos criar um cenário para deletar uma entrega; esse cenário deve ser autossuficiente, ou seja, não podemos usar um ID fixo para a entrega a ser deletada, pois isso faria o teste falhar caso não houvesse dados no banco. O que devemos fazer, então, é sempre criar uma entrega antes de tentar deletá-la. Após criar a entrega, recuperamos o ID gerado para então realizar a deleção. Isso garante um ciclo de teste ponta a ponta, onde o estado inicial é configurado dinamicamente, aumentando a robustez e a precisão dos nossos testes.
- agora que entendemos a parte teórica sobre o uso de contexto no Gherkin, vamos colocar esse conhecimento em prática e criar um ***cenário de deleção de entrega*** utilizando o conceito de contexto.
- criar um novo arquivo de feature dentro da pasta src/test/resources chamado `ExemploContexto.feature`.
- após criar o arquivo ExemploContexto.feature, escrever a parte de contexto necessária para o nosso cenário de deleção de entrega; reaproveitar os códigos já existentes para criar o contexto adequado.

~~~java
# language: pt
Funcionalidade: Deletar uma entrega
  Como usuário da API
  Quero conseguir deletar uma entrega
  Para que o registro seja apagado corretamente no sistema
  Contexto: Cadastro bem-sucedido de entrega
    Dado que eu tenha os seguintes dados da entrega:
      | campo          | valor        |
      | numeroPedido   | 1            |
      | nomeEntregador | Ana Silva    |
      | statusEntrega  | EM_SEPARACAO |
      | dataEntrega    | 2024-08-22   |
    Quando eu enviar a requisição para o endpoint "/entregas" de cadastro de entregas
    Então o status code da resposta deve ser 201
~~~

- neste arquivo ExemploContexto.feature, pegamos o cenário de criação bem-sucedida de entrega e o colocamos no topo como um contexto, o que indica ao Gherkin que esses passos devem ser executados antes de cada cenário definido no arquivo.
- agora que já estruturamos o contexto, vamos escrever o primeiro cenário de deleção.
- para incluir este cenário, ele deve ser escrito logo abaixo do contexto definido.

~~~java
Cenário: Deve ser possível deletar uma entrega
    Dado que eu recupere o ID da entrega criada no contexto
    Quando eu enviar a requisição com o ID para o endpoint "/entregas" de deleção de entrega
    Então o status code da resposta deve ser 204
~~~

- neste cenário, reutilizamos o passo já existente para validar que o status code da resposta que é 204 para a deleção realizada com sucesso. 
- além disso, implementamos dois novos passos:
  - o primeiro passo é ***recuperar o ID da entrega criada no contexto***. Isso é essencial para que possamos buscar o ID da entrega que foi criada durante a execução do contexto, garantindo que o ID correto seja passado na requisição de deleção.
  - o segundo passo é ***enviar a requisição de deleção utilizando o ID recuperado***; irá executar a requisição HTTP de deleção, empregando o ID obtido anteriormente para direcionar a requisição ao recurso específico que deve ser deletado.
- agora que escrevemos esses novos passos, vamos implementá-lo na nossa classe de CadastroEntregasSteps e prosseguir com as implementações necessárias em Java para garantir que a validação desses passos seja realizada com sucesso.
- no arquivo de ExemploContexto.feature, clique na lâmpada amarela de sugestão ao lado de um dos novos passos destacados no arquivo de feature, sublinhados em amarelo (ou pressionar Alt + Enter para abrir as opções). Em seguida, selecione a opção "Create all step definitions".
- após selecionar o arquivo CadastroEntregasSteps, serão criados dois novos passos no arquivo com a seguinte definição.

~~~java
@Dado("que eu recupere o ID da entrega criada no contexto")
    public void queEuRecupereOIDDaEntregaCriadaNoContexto() {
    }
    @Quando("eu enviar a requisição com o ID para o endpoint {string} de deleção de entrega")
    public void euEnviarARequisiçãoComOIDParaOEndpointDeDeleçãoDeEntrega(String arg0) {
    }
~~~

- por boas práticas, renomear o argumento arg0 para algo mais significativo e alinhado com o contexto do passo. 
- no caso, o argumento pode ser renomeado para endPoint.

~~~java
@Quando("eu enviar a requisição com o ID para o endpoint {string} de deleção de entrega")
    public void euEnviarARequisiçãoComOIDParaOEndpointDeDeleçãoDeEntrega(String endPoint) {
    }
~~~

- agora que geramos os steps, eles ainda estão vazios, sem nenhuma validação de lógica. 
- ***adicionar a lógica correspondente na classe CadastroEntregasService***, localizada em src/test/java/service.  
- primeiramente, criar um método para recuperar o ID; vamos definir a variável String idDelivery na classe, e será responsável por armazenar o ID que vamos recuperar.
- após isso, vamos criar um método chamado retrieveIdDelivery(), que será responsável por recuperar o ID a ser deletado.

~~~java
public void retrieveIdDelivery() {
        idDelivery = String.valueOf(gson.fromJson(response.jsonPath().prettify(), EntregaModel.class).getNumeroEntrega());
    }
~~~

- nesse método, o response representa a criação de delivery realizada no contexto do arquivo de ExemploContexto.feature, portanto, armazena o ID que precisamos deletar. 
- o método irá converter a resposta JSON em um objeto da classe EntregaModel, extrair o campo numeroEntrega que nesse contexto é o ID que precisamos e armazená-lo na variável idDelivery. 
- depois de definir o método retrieveIdDelivery(), avançar para a requisição de deleção. 
- diferente do método createDelivery(), que utiliza o método POST, para a deleção usamos o método DELETE.
- criar um novo método chamado deleteDelivery(), onde a requisição não possui um corpo (body) e o delivery a ser deletado é especificado como um parâmetro na URL.
- a URL é construída concatenando o baseUrl, o endPoint e o idDelivery, que é o ID do delivery a ser deletado utilizando o método when().delete(url). E o response da requisição é extraído e armazenado para futuras validações.

~~~java
public void deleteDelivery(String endPoint) {
        String url = String.format("%s%s/%s", baseUrl, endPoint, idDelivery);
        response = given()
                .accept(ContentType.JSON)
                .when()
                .delete(url)
                .then()
                .extract()
                .response();
    }
~~~

- com as implementações dos métodos retrieveIdDelivery() e deleteDelivery(), podemos passar para a implementação do código Java nos steps na classe CadastroEntregasSteps, que estão vazios.
- o método anotado com @Dado("que eu recupere o ID da entrega criada no contexto") precisa ser implementado o código Java para recuperação do ID a ser deletado.

~~~java
@Dado("que eu recupere o ID da entrega criada no contexto")
    public void queEuRecupereOIDDaEntregaCriadaNoContexto() {
        cadastroEntregasService.retrieveIdDelivery();
    }
~~~

- nesse código, o método é responsável por recuperar o ID da entrega criada no contexto do teste usando o método retrieveIdDelivery() da instância cadastroEntregasService.
- o próximo passo é a implementação do código Java no método anotado com ***@Quando("eu enviar a requisição com o ID para o endpoint {string} de deleção de entrega")***, o qual será responsável por enviar a requisição para o endpoint de deleçãode entregas.

~~~java
@Quando("eu enviar a requisição com o ID para o endpoint {string} de deleção de entrega")
    public void euEnviarARequisiçãoComOIDParaOEndpointDeDeleçãoDeEntrega(String endPoint) {
        cadastroEntregasService.deleteDelivery(endPoint);
    }
~~~

- nesse código, o método é responsável por enviar uma requisição de deleção para o endpoint especificado com o ID da entrega recuperado anteriormente.
- o método deleteDelivery da instância cadastroEntregasService é chamado, recebendo o endPoint fornecida pelo cenário de teste no arquivo ExemploContexto.feature. 
- ao chamar deleteDelivery(endPoint), a requisição DELETE é enviada para o endpoint fornecido, permitindo assim a remoção da entrega do sistema.
- agora podemos executar o teste: voltamos ao arquivo ExemploContexto.feature, localizamos o cenário "Deve ser possível deletar uma entrega", e clicamos no ícone de execução (play). Em seguida, selecionamos a opção "Run" para executar o teste e verificar se tudo está funcionando corretamente.

> IMPORTANTE: [Link da solução implementada até o momento para download no GITHUB](https://github.com/proflealvjo/testes-automatizados/tree/3.4.4-usando-contexto).

### 1.4.5 Testes de contrato usandoJSON Schema
- testes de contrato são uma técnica fundamental no desenvolvimento de APIs que visa assegurar que a comunicação entre o cliente e o servidor esteja em conformidade com um "contrato" previamente definido. 
- esse contrato especifica a estrutura e os requisitos dos dados trocados entre os sistemas, garantindo que qualquer mudança no sistema não quebre a integração com outros serviços.
- um contrato de API tipicamente inclui detalhes sobre os formatos dos dados, as estruturas esperadas e os valores permitidos. 
- validar o contrato ajuda a identificar discrepâncias e problemas antes que afetem o funcionamento de sistemas dependentes. 
- JSON Schema é uma ferramenta usada para definir e validar a estrutura dos dados JSON, permitindo descrever o formato, os tipos e as restrições dos dados. 
- com JSON Schema, podemos definir as estruturas esperadas dos dados, validar se os dados recebidos ou enviados estão de acordo com o esquema definido e até gerar documentação para outros desenvolvedores entenderem a estrutura esperada dos dados.
- para implementar testes de contrato usando JSON Schema, é necessário seguir alguns passos:
  - primeiro, criamos um arquivo de esquema JSON que descreva a estrutura esperada da resposta da API. Esse arquivo servirá como referência para validação. 
  - em seguida, utilizamos uma ferramenta de teste de APIs, Rest Assured, para fazer requisições à API e obter as respostas. 
  - com o JSON Schema, validamos as respostas da API contra o esquema definido, garantindo que a resposta esteja em conformidade com o contrato. 
  - finalmente, analisamos os resultados da validação para identificar quaisquer erros ou discrepâncias e, se houver problemas, eles devem ser corrigidos para garantir a conformidade.

- vamos aplicar esses conceitos ao projeto de testes.
- para isso, primeiro devemos preparar o ambiente de desenvolvimento incluindo mais duas bibliotecas necessárias no arquivo pom.xml do nosso projeto:

~~~xml
<!-- Json Schema Validator -->
        <dependency>
            <groupId>com.networknt</groupId>
            <artifactId>json-schema-validator</artifactId>
            <version>1.5.1</version>
        </dependency>
        <!-- Json -->
        <dependency>
            <groupId>org.json</groupId>
            <artifactId>json</artifactId>
            <version>20240303</version>
        </dependency>
~~~

- `biblioteca json-schema-validator`:
  - é usada para validar dados JSON contra um esquema definido, garantindo que eles estejam em conformidade com a versão 4 do JSON Schema.
  - é crucial para assegurar que as respostas da API correspondam à estrutura esperada e identificar quaisquer inconsistências.
- `biblioteca org.json`:
  - fornece ferramentas para criar, manipular e consultar objetos JSON em Java. 
  - facilita a conversão da resposta da API para um formato que pode ser validado contra o esquema e permite integrar o esquema JSON com a resposta para realizar a validação.

- feito isso, a resposta da API será baseada em um teste já escrito chamado "Cadastro bem-sucedido de entrega" do arquivo CadastroEntregas.feature. 
- escolhemos esse teste porque, quando ele nos devolve o status 201, também retorna um corpo como resposta, tornando-o ideal para basear nosso contrato. 
  - a ideia é garantir que a resposta esteja de acordo com o esperado,caso contrário, quem consome essa API poderia ter problemas de integração.
- o contrato vai ser baseado nessa resposta:

~~~json
{
    "numeroEntrega": 1,
    "numeroPedido": 2,
    "nomeEntregador": "Ana Silva",
    "statusEntrega": "EM_SEPARACAO",
    "dataEntrega": "2024-08-22"
}
~~~

- o próximo passo é criar a pasta onde os arquivos de esquema serão armazenados.
- crie a `pasta schemas` em src/test/resources para organizar os arquivos de esquema JSON necessários para a validação.
- o próximo passo é gerar o nosso contrato. 
  - há várias ferramentas online que ajudam a converter JSON em JSON Schema; utilizaremos [esse site](https://extendsclass.com/json-schema-validator.html). 
  - basta colar o JSON no campo fornecido e clicar em “Generate Schema From JSON”.
  - o JsonSchema correspondente será gerado automaticamente, fornecendo a estrutura necessária para validar nossas respostas da API.

~~~json
{
	"definitions": {},
	"$schema": "http://json-schema.org/draft-07/schema#", 
	"$id": "https://example.com/object1730134052.json", 
	"title": "Root", 
	"type": "object",
	"required": [
		"numeroEntrega",
		"numeroPedido",
		"nomeEntregador",
		"statusEntrega",
		"dataEntrega"
	],
	"properties": {
		"numeroEntrega": {
			"$id": "#root/numeroEntrega", 
			"title": "Numeroentrega", 
			"type": "integer",
			"examples": [
				1
			],
			"default": 0
		},
		"numeroPedido": {
			"$id": "#root/numeroPedido", 
			"title": "Numeropedido", 
			"type": "integer",
			"examples": [
				2
			],
			"default": 0
		},
		"nomeEntregador": {
			"$id": "#root/nomeEntregador", 
			"title": "Nomeentregador", 
			"type": "string",
			"default": "",
			"examples": [
				"Ana Silva"
			],
			"pattern": "^.*$"
		},
		"statusEntrega": {
			"$id": "#root/statusEntrega", 
			"title": "Statusentrega", 
			"type": "string",
			"default": "",
			"examples": [
				"EM_SEPARACAO"
			],
			"pattern": "^.*$"
		},
		"dataEntrega": {
			"$id": "#root/dataEntrega", 
			"title": "Dataentrega", 
			"type": "string",
			"default": "",
			"examples": [
				"2024-08-22"
			],
			"pattern": "^.*$"
		}
	}
}
~~~

- após gerar o JsonSchema no site, o próximo passo é copiar o esquema gerado e criar um `arquivo chamado cadastro-bem-sucedido-de-entrega.json` na pasta src/test/resources/schemas. 
- cole o Json Schema copiado dentro desse arquivo e salve-o.
- este esquema define a estrutura esperada para a resposta da API ao cadastrar uma entrega com sucesso. 
- principais elementos:
  - ***$schema***: especifica a versão do JSON Schema usada.
  - ***$id***: identificador único para o esquema.
  - ***title***: título descritivo para o esquema.
  - ***type***: define que o objeto esperado é um "object".
  - ***required***: lista dos campos que são obrigatórios na resposta. Aqui, numeroEntrega, numeroPedido, nomeEntregador, statusEntrega, e dataEntrega são obrigatórios.
  - ***properties***: define as propriedades do objeto esperado, incluindo seus tipos e valores padrão. Por exemplo, numeroEntrega e numeroPedido devem ser inteiros, enquanto nomeEntregador, statusEntrega e dataEntrega devem ser strings.
- cada propriedade do esquema Json Schema é detalhada com um título (title), um tipo (type), um valor padrão (default), e exemplos (examples). 
- alguns campos também possuem um padrão de expressão regular (pattern), que define as regras que o valor da string deve seguir. 
- o contrato é totalmente personalizável, permitindo que você inclua as modificações necessárias para validar os aspectos específicos que deseja garantir.

- agora vamos criar o teste de contrato propriamente dito. 
- para manter a estrutura clara e facilitar o entendimento, separaremos os testes de contrato criando um novo `arquivo ExemploContrato.feature` dentro da pasta “src/test/resources/features”.
- o próximo passo é escrever o teste no arquivo ExemploContrato.feature. 
- como o teste de contrato será baseado no teste existente de "Cadastro bem-sucedido de entrega", podemos reaproveitar esse teste e adicionar apenas os passos necessários para validar o contrato.
- inicialmente, o arquivo ficará estruturado da seguinte forma:

~~~java
# language: pt
Funcionalidade: Validar o contrato ao realizar um cadastro bem-sucedido de entrega
  Como usuário da API
  Quero cadastrar uma nova entrega bem-sucedido
  Para que eu cosniga validar se o contrato esta conforme o esperado
  Cenario: Validar contrato do cadastro bem-sucedido de entrega
    Dado que eu tenha os seguintes dados da entrega:
      | campo          | valor        |
      | numeroPedido   | 1            |
      | nomeEntregador | Ana Silva    |
      | statusEntrega  | EM_SEPARACAO |
      | dataEntrega    | 2024-08-22   |
    Quando eu enviar a requisição para o endpoint "/entregas" de cadastro de entregas
    Então o status code da resposta deve ser 201
~~~














--- 

[Voltar ao início!](https://github.com/monicaquintal/smart_cities)