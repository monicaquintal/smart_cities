<div align="center">
<a href="https://github.com/monicaquintal" target="_blank"><img align="right" height="120px" src="../assets/logo.png" /></a>
<h1>FASE 6 - DevOps</h1>
<h2>Capítulo 05: Continuous Integration e Continuous Delivery.</h2>
</div>

<div align="center">
<h2>1. CONTINUOUS INTEGRATION E CONTINUOUS DELIVERY</h2>
</div>

## 1.1 Continuous Integration

- ***na ausência de CI***:
  - sem integração contínua, os desenvolvedores precisam coordenar e comunicar à mão quando estão contribuindo com código para o produto final.
  - esta coordenação vai além das equipes de desenvolvimento até operações, bem como o restante da organização. 
  - equipes de produto devem coordenar quando funções e correções vão ser lançadas em sequência e quais membros da equipe vão ser os responsáveis.
  - a comunicação excessiva em um ambiente sem integração contínua pode se tornar uma tarefa de sincronização complexa e intricada, que acrescenta custos burocráticos desnecessários ao projeto. 
  - as versões de códigos ficam mais lentas e com maiores taxas de falha, pois requer que os desenvolvedores sejam sensíveis e cuidadosos com relação às integrações. 
  - os riscos crescem muito conforme o tamanho da equipe de engenharia e da base de código aumenta.
  - sem um pipeline de integração contínua robusto, pode haver uma desconexão entre a equipe de engenharia e o restante da organização.
  - a comunicação entre o produto e a engenharia pode ser complicada. , dificultando estimar o tempo de entrega das solicitações, pois o tempo para integrar as novas alterações acaba sendo um risco desconhecido.
- a `integração contínua (Continuous Integration/CI)`:
  - é uma prática de software que requer a confirmação frequente de código em um repositório compartilhado, o que detecta erros mais cedo e reduz a quantidade de código que um desenvolvedor precisa depurar ao encontrar a origem de um erro. 
  - atualizações frequentes de código também facilitam a mesclagem de alterações de diferentes membros de uma equipe de desenvolvimento de software. 
  - desenvolvedores podem gastar mais tempo escrevendo código e menos tempo depurando erros ou resolvendo conflitos de mesclagem. 
  - ao comitar o código em seu repositório, você pode compilar e testar continuamente o código para garantir que o commit não introduza erros. 
  - seus testes podem incluir linters de código (que verificam a formatação de estilo), verificações de segurança, cobertura de código, testes funcionais e outras verificações personalizadas. 
  - construir e testar seu código requer um servidor; você pode criar e testar atualizações localmente antes de enviar o código para um repositório ou pode usar um servidor de CI que verifica novos commits de código em um repositório.

## 1.2 Continuous Delivery (CD)

- a Entrega contínua (CD) é um conjunto de práticas recomendadas ágeis e organizacionais anteriores bem-sucedidas. 
- a CD direciona uma empresa na criação de um processo simplificado e automatizado de lançamento de software.
- no centro desse processo há um ciclo de feedback iterativo, que gira em torno da entrega de software para o usuário final o mais rápido possível, aprendendo com sua experiência prática e, em seguida, incorporando esse feedback na próxima versão.
- a CD é uma abordagem na qual as equipes lançam produtos de qualidade com frequência e previsão do repositório do código fonte para produção de maneira automatizada. 

## 1.3 Aplicação

- você foi designado para implementar uma API desenvolvida em Java com Spring Boot, responsável pela gestão do cadastro de produtos.
- o código-fonte está hospedado no [GitHub](https://github.com/acnaweb/simple-api-java); é necessário que faça um Fork deste repositório. 
- a aplicação utiliza configurações definidas no arquivo application.properties para gerenciar a conexão com o banco de dados; dados de conexão ao servidor de bd, como usuário e senha, devem ser fornecidos por meio de variáveis de ambiente, o que aumenta a segurança e permite que a aplicação seja configurada de forma flexível em diferentes ambientes sem necessidade de alterações no código.

~~~
server.port=8080
spring.datasource.url=${DATABASE_URL}
spring.datasource.username=${DATABASE_USER}
spring.datasource.password=${DATABASE_PWD}
spring.jpa.show-sql=false
spring.jpa.open-in-view=true
~~~

- ao implementar CI/CD, garantirá que qualquer atualização no código seja automaticamente testada e, se bem-sucedida, entregue de forma contínua ao ambiente de produção. 
- isso agiliza o processo de desenvolvimento, além de reduzir o risco de erros na aplicação ao vivo.

## 1.4 Container

- em implantações modernas, containers se destacam como uma solução robusta para garantir a consistência entre os ambientes de desenvolvimento, teste e produção. 
- utilizando o Docker, é possível encapsular a aplicação e suas dependências em um container isolado, o que simplifica as configurações e aumenta a segurança ao reduzir discrepâncias entre os ambientes.
- para essa aplicação Java com Spring Boot, configuramos o Docker para facilitar a implantação e o gerenciamento em qualquer ambiente de nuvem que suporte containers. 
- Dockerfile utilizado para construir a imagem da API:

~~~
FROM maven:3.9.8-eclipse-temurin-21 AS build
RUN mkdir /opt/app
COPY . /opt/app
WORKDIR /opt/app
RUN mvn clean package
FROM eclipse-temurin:21-jre-alpine
RUN mkdir /opt/app
COPY --from=build  /opt/app/target/app.jar /opt/app/app.jar
WORKDIR /opt/app
ENV PROFILE=prd
EXPOSE 8080
ENTRYPOINT ["java", "-Dspring.profiles.active=${PROFILE}", "-jar", "app.jar"]
~~~

- explicação detalhada do Dockerfile:
  - ***Build Stage***: utilizamos uma imagem base do Maven para compilar o projeto Java e empacotá-lo em um arquivo JAR.
  - ***Runtime Stage***: em seguida, partimos de uma imagem base do JRE Alpine para manter a imagem final leve. O arquivo JAR é copiado para a nova imagem, configurado para rodar no ambiente de produção.
- o processo de criação da imagem do Docker é feito com o seguinte comando, que constrói a imagem usando o Dockerfile presente no diretório atual e a marca com a tag api:

~~~
docker build -t api .
~~~

- para executar a aplicação, o container é iniciado a partir da imagem construída, com configuração de rede e variáveis de ambiente específicas que controlam os detalhes da conexão ao banco de dados e o perfil da aplicação.

~~~
docker run -p 8080:8080 --net=host \
-e PROFILE=prd \
-e DATABASE_URL=jdbc:mysql://localhost:3306/api?createDatabaseIfNotExist=true \
-e DATABASE_USER=root \
-e DATABASE_PWD=1234 \
api
~~~ 

- essa abordagem garante que a aplicação execute em um ambiente isolado e controlado, além de facilitar o processo de CI/CD ao permitir que cada etapa do desenvolvimento, teste e produção seja replicada de forma confiável e segura. 
- ao adotar containers, você maximiza a eficiência operacional e minimiza os riscos associados ao deploy e à manutenção de aplicações em ambientes diversos.

## 1.5 Funcionalidades

- a API oferece funcionalidades essenciais para o gerenciamento de produtos, incluindo operações CRUD (Create, Read, Update, Delete) que são fundamentais para manutenção do cadastro de produtos no negócio.
- a documentação completa da API está disponível através da [interface do Swagger](http://localhost:8080/swagger-ui/index.html), que fornece uma visão interativa e detalhada de todos os endpoints disponíveis.
- após configurar a aplicação em um ambiente controlado usando Docker, o próximo passo é automatizar os processos de integração e entrega contínua (CI/CD) usando GitHub Actions.

## 1.6 Introdução ao GitHub Actions

- GitHub Actions é uma plataforma disponibilizada pelo GitHub que facilita a automação de todas as fases do desenvolvimento de software, desde a construção até o teste e a implantação.
- é possível criar fluxos de trabalho que compilam e testam cada pull request em seu repositório ou implantam pull requests mesclados em produção. 
- além de simplificar tarefas de DevOps, GitHub Actions permite a execução de fluxos de trabalho baseados em outros eventos dentro do seu repositório. 
  - exemplo: é possível configurar um fluxo de trabalho para adicionar automaticamente etiquetas sempre que um novo problema for criado.

## 1.7 Componentes

- é possível configurar um fluxo de trabalho do GitHub Actions para ser disparado por eventos específicos no seu repositório, como a abertura de uma solicitação de pull ou a criação de um problema. 
- cada fluxo de trabalho contém um ou mais trabalhos que podem ser executados tanto em ordem sequencial quanto em paralelo. 
- cada trabalho opera em um executor próprio, seja uma máquina virtual ou um contêiner, e inclui várias etapas que executam scripts definidos por você ou ações, que são extensões reutilizáveis projetadas para simplificar seu processo.

## 1.8 Fluxos de trabalho

- fluxo de trabalho é um processo automatizado configurável que executa um ou mais trabalhos, definidos por um arquivo YAML no `diretório .github/workflows` de um repositório, e serão executados quando acionados por um evento no repositório, manualmente ou conforme cronograma pré-definido.
- um repositório pode ter múltiplos fluxos de trabalho, cada um realizando diferentes tarefas, como:
  - compilar e testar pull requests.
  - implantar a aplicação sempre que uma versão for criada.
  - adicionar um rótulo sempre que um novo problema for aberto.
- também é possível referenciar um fluxo de trabalho dentro de outro, aumentando a modularidade e a reutilização das tarefas.

## 1.9 Eventos 

- eventos são atividades específicas no repositório que disparam a execução de um fluxo de trabalho. 
- podem ser originados pelo GitHub quando alguém cria uma solicitação de pull, abre um problema, ou faz um push de um commit. 
- além disso, fluxos de trabalho podem ser acionados por eventos programados, postagens em uma API REST, ou de forma manual.

## 1.10 Trabalhos

- um trabalho é um conjunto de etapas dentro de um fluxo de trabalho, todas executadas no mesmo executor. 
- cada etapa consiste em um script de shell ou uma ação predefinida que é executada. 
- essas etapas são executadas em sequência e cada uma depende da conclusão da anterior para o seu início.
- uma vez que todas as etapas ocorrem no mesmo executor, é possível compartilhar dados entre elas, facilitando a continuidade e a integridade do processo.
  - exemplo: você pode configurar uma etapa que compila sua aplicação, seguida imediatamente por outra que realiza testes no aplicativo recém-compilado.
- há a flexibilidade de definir dependências entre diferentes trabalhos dentro do mesmo fluxo de trabalho; por padrão, os trabalhos são independentes e executados em paralelo. No entanto, quando um trabalho depende de outro, ele só inicia após a conclusão do trabalho do qual depende. 
  - exemplo: é possível configurar múltiplos trabalhos de build, cada um para uma arquitetura diferente, sem dependências entre eles, e um trabalho de empacotamento que só inicia após a conclusão bem-sucedida de todos os trabalhos de build. 
  - essa abordagem garante que o empacotamento só ocorra quando todos os componentes necessários estiverem prontos e testados, maximizando a eficiência e reduzindo o potencial de erros no processo final de construção do software.

## 1.11 Ações

- uma ação é um aplicativo personalizado dentro da plataforma GitHub Actions, projetado para executar tarefas complexas que são frequentemente necessárias nos processos de desenvolvimento. 
- use uma ação para minimizar a quantidade de código repetitivo em seus arquivos de fluxo de trabalho. 
  - exemplo: uma ação pode clonar automaticamente seu repositório Git do GitHub, configurar a cadeia de ferramentas adequada para seu ambiente de build, ou estabelecer autenticação com seu provedor de nuvem.
- há a opção de criar suas próprias ações personalizadas ou explorar uma variedade de ações pré-configuradas disponíveis no GitHub Marketplace, que podem ser facilmente integradas aos seus fluxos de trabalho.
- essa flexibilidade permite que você otimize e automatize as operações de desenvolvimento sem comprometer a eficácia ou a qualidade do código produzido.

## 1.12 Executores

- um executor é um servidor dedicado que processa seus fluxos de trabalho assim que são acionados. 
- cada executor é capaz de gerenciar um único trabalho por vez, garantindo que cada tarefa receba os recursos necessários para sua execução. 
- o GitHub oferece uma gama de executores padrão, incluindo sistemas operacionais Ubuntu Linux, Microsoft Windows e macOS, para acomodar a diversidade de fluxos de trabalho. 
- cada tarefa dentro de um fluxo de trabalho é realizada em uma máquina virtual recém-provisionada e isolada, garantindo um ambiente limpo e controlado para cada execução.
- se as suas necessidades exigirem um sistema operacional específico ou uma configuração de hardware diferenciada, você tem a opção de hospedar seus próprios executores, o que permite uma personalização adicional e pode ser especialmente útil para fluxos de trabalho que exigem configurações de hardware ou software não padrão.

> DICA: Acessar a [documentação oficial do GitHub Actions](https://docs.github.com/pt/actions/about-github-actions/understanding-github-actions), recurso que oferece informações detalhadas, tutoriais e melhores práticas para maximizar o uso da plataforma.

## 1.13 Personal Acess Token

- o uso de um Personal Access Token (PAT) no GitHub é essencial para garantir operações seguras e automatizadas, como git push e git pull, em repositórios remotos.
- este token substitui a autenticação tradicional de usuário e senha, proporcionando um método mais seguro e controlável de acesso ao GitHub, especialmente útil em scripts de automação e integrações de CI/CD que exigem acesso frequente ao repositório sem intervenção manual.
- acesse as [configurações do tokens no GitHub](https://github.com/settings/tokens), e clique em "Generate new token" e selecione a opção "Generate new token (classic)".
- ***permissões (scopes) do Token***: 
  - 1) Insira uma descrição no campo "Note" para identificar o propósito do token.
  - 2) Escolha um período de validade para o token.
  - 3) Selecione os scopes 'repo' e 'workflow', necessários para operações de repositório e automação de workflows, respectivamente.
  - 4) Role a tela até o final e clique em "Generate new token".
- anote o token gerado, pois ele será necessário para realizar operações de 'git push' durante a criação ou atualização de workflows no GitHub.
- essas etapas garantem que você tenha as permissões adequadas para gerenciar seu repositório e workflows de forma segura e eficaz.

> IMPORTANTE: O token gerado pode ser excluído ou regenerado a qualquer momento através das configurações de token no GitHub, garantindo controle total sobre sua segurança e acesso.

<div align="center">
<h2>2. PRIMEIRO WORKFLOW</h2>
</div>

- neste segmento, vamos detalhar como definir e executar um workflow inicial no GitHub Actions, composto por dois jobs distintos, ambos executando em um ambiente 'Ubuntu'.
- a seguir, teremos uma sequência de passos e comandos para configurar o primeiro workflow de CI/CD do projeto.
- acessar o terminal, clonando o repositório e configurando suas credenciais com os seguintes comandos:

~~~
git clone https://github.com/antonioclj/simple-api-java.git
cd simple-api-java
git config user.email "seuemail@dominio.com" 
git config user.name "Seu Nome"
~~~

- mude para a branch "develop" para buscar as atualizações mais recentes:

~~~
git switch develop 
git pull -r
~~~

- em seguida, crie uma branch de feature local e remota; utilize o Personal Access Token criado anteriormente se necessário:

~~~
git checkout -b feature/primeiro-workflow
git push --set-upstream origin feature/primeiro-workflow
~~~

- para iniciar a automação de tarefas usando GitHub Actions, é essencial criar e configurar um arquivo YAML que defina os workflows. 
- este arquivo descreve uma sequência de jobs que são executados em resposta a eventos específicos dentro de um repositório GitHub.
- na pasta .github/workflows do repositório, crie o `arquivo 01-primeiro-workflow.yaml`. 
  - ele contém a configuração do workflow que será disparado por eventos de push ao repositório. 
  - o conteúdo do arquivo define dois jobs distintos, ***job1-hello*** e ***job2-goodbye***, que executam tarefas simples para demonstrar a funcionalidade do GitHub Actions.

~~~
on: push

jobs:
    job1-hello:
        runs-on: ubuntu-latest
        steps:
        - name: Imprimir mensagem
          run: echo "Olá, Mundo"
    job2-goodbye:
        runs-on: ubuntu-latest
        steps:
        - name: Step 1 - Sequencia de instruções
          run: |
            echo "Uma nova instrução"
            ls            
        - name: Step 2 - Imprimir mensagem
          run: echo "Até logo!"
~~~

- um script de workflow é composto de 4 partes obrigatórias: name, on, jobs e pelo menos um job deve ser criado -observe que job1-hello e job2-goodbye são 2 jobs distintos.

## 2.1 Componentes do Workflow

- `name`: o nome do workflow não é explicitamente mostrado neste arquivo YAML, mas geralmente é definido no topo do arquivo para identificar o workflow dentro do GitHub Actions.
- `on`: esta chave define o evento que dispara o workflow. No exemplo fornecido, o workflow é ativado por qualquer ação de push no repositório.
- `jobs`: esta seção contém a definição dos jobs que serão executados quando o workflow for disparado. Cada job pode ser configurado para rodar em diferentes ambientes ou executores.
	- `job1-hello`: este job roda no ambiente ubuntu-latest e possui uma única etapa que executa o comando para imprimir "Olá, Mundo".
	- `job2-goodbye`: este job também roda em ubuntu-latest e é composto por duas etapas: a primeira etapa executa uma sequência de comandos que inclui imprimir uma mensagem e listar os arquivos no diretório atual, enquanto a segunda etapa imprime "Até logo!".
- este workflow é uma introdução prática à configuração de Git Hub Actions, mostrando como tarefas automatizadas simples podem ser configuradas para responder a atividades comuns do repositório, como commits e pushes.

## 2.2 Finalização e monitoramento do Workflow

- depois de definir e configurar seu workflow no GitHub Actions, o próximo passo é incorporar as mudanças no repositório remoto e monitorar a execução para garantir que tudo está funcionando conforme esperado. 
- este processo envolve fazer o commit das alterações, empurrá-las para o repositório e, em seguida, acessar e analisar os resultados do workflow através da interface do GitHub. 
- vamos explorar esses passos em detalhes para entender como cada um contribui para o ciclo de vida do desenvolvimento de software automatizado.
- após a criação ou modificação dos arquivos de workflow, é crucial salvá-los no repositório para que o GitHub Actions possa acessá-los e executar conforme configurado. 
- comandos necessários para adicionar as alterações ao controle de versão e enviá-las ao repositório remoto:

~~~
git add .github/workflows/01-primeiro-workflow.yaml
git commit -m "Adicionar primeiro workflow"
git push
~~~

- este processo salva suas mudanças localmente, e as sincroniza com o repositório na nuvem, permitindo que o GitHub Actions detecte e execute o novo workflow.
- após o push, você pode monitorar a execução do workflow diretamente no GitHub:
	- 1. ***Acessando workflows***: entre no repositório pelo navegador e navegue até o menu "Actions".
	- 2. ***Visualizando Execuções***: clique em "01–Primeiro Workflow" para ver os detalhes de como o workflow está sendo executado.
	- 3. ***Verificando o Status do Workflow***: observe o ícone verde ao lado do nome do commit "Adicionar primeiro workflow", que indica que o workflow foi executado com sucesso.
	- 4. ***Analisando Jobs Específicos***: clique no commit "Adicionar primeiro workflow" para verificar a existência dos dois jobs (job1-hello e job2-goodbye) executados com sucesso.
	- 5. ***Detalhes do Job job1-hello***: ao clicar em 'job1-hello', você pode ver detalhes do job, incluindo a execução do step "Imprimir mensagem". Expandindo o step, você pode confirmar a saída "Olá, Mundo".
- este fluxo garante que as alterações sejam adequadamente incorporadas e versionadas, e permite uma visão clara de como cada componente do workflow contribui para o funcionamento geral do processo, possibilitando ajustes rápidos e eficientes conforme necessário.

## 2.3 Workflow de eventos filtrados

- em alguns cenários, é essencial que diferentes workflows sejam executados com base na branch onde ocorreram as alterações de código-fonte. 
	- por exemplo, podemos configurar que os pushes em branches com o prefixo "feature" disparem jobs de testes unitários, enquanto os pushes em branches "develop" acionem apenas jobs de validação do container.
- o GitHub Actions permite que workflows sejam configurados para serem disparados por eventos em branches específicas, o que é particularmente útil para gerenciar diferentes estágios de desenvolvimento e garantir que apenas as ações apropriadas sejam executadas em cada fase.
- para o exemplo a seguir, o workflow será ativado por eventos de push, mas especificamente nas branches que começam com o prefixo "feature".
- `preparação das Branches`:
	- ***Branch develop***: troque para a branch "develop" para buscar atualizações remotas:

~~~
git checkout develop
git pull
~~~

- ***Branch feature/workflow-filtro***: crie branch de feature local e remota. Se necessário, utilize o token criado em Personal Access Token.

~~~
git checkout -b feature/workflow-filtro 
git push --set-upstream origin feature/workflow-filtro
~~~

- ***Script de workflow***: na pasta base .github/workflows, crie o arquivo 02-workflow-filtro.yaml e configure o filtro de branches. Observe que o atributo "branches" é definido após o evento "push", garantindo que o workflow seja disparado em todos os eventos de push das branches iniciadas por "feature".

~~~
name: 02 - Workflow Filtro

on:
  push:
    branches: 'feature/**'

jobs:
  echo:
    runs-on: ubuntu-latest
    steps:
      - name: Exibir o evento
        run: echo "Workflow disparado por ${{ github.event_name }}"
~~~

- após criar ou modificar o arquivo, adicione as mudanças ao stage local, comite e faça o upload para o repositório remoto:

~~~
git add .
git commit -m "Adicionar workflow disparado em branches feature"
git push
~~~

- acesse o menu "Actions" no repositório para visualizar os workflows. No painel esquerdo, você encontrará dois workflows e, na parte central, poderá identificar pelo commit "Adicionar workflow disparado em branches feature" qual job foi executado.

> IMPORTANTE: O workflow "02–Workflow Filtro" será executado apenas em branches com o prefixo "feature", enquanto outros workflows podem ser configurados para disparar a partir de qualquer branch. Esta flexibilidade permite uma gestão eficaz dos diferentes estágios de desenvolvimento dentro do projeto!

## 2.4 Ações pré-configuradas

- em diversos cenários, os workflows necessitam de ações que se repetem com frequência. 
	- por exemplo: instalar o Java 17 com Maven para o build da aplicação, instalar o Docker para a criação de imagens ou realizar o checkout do repositório. 
- para esses casos, podemos fazer uso das "actions" disponíveis no [Marketplace do GitHub](https://github.com/marketplace?type=actions).
- a utilização dessas "actions" pré-configuradas oferece vários benefícios, como:
	- 1. Evitar o uso de comandos repetitivos.
	- 2. Reduzir a duplicação de código.
	- 3. Proporcionar flexibilidade através da parametrização.
	- 4. Facilitar a combinação de diferentes actions para otimizar os workflows.
- o próximo workflow visa demonstrar o uso efetivo de actions para:	
	- [Checkout do código](https://github.com/marketplace/actions/checkout).
	- [Setup do Java Sdk](https://github.com/marketplace/actions/setup-java-jdk).
	- [Build de imagem Docker](https://github.com/marketplace/actions/build-and-push-docker-images).

## 2.5 Preparação das Branches

- `Branch develop`: Mude para a branch "develop" para buscar as últimas atualizações:

~~~
git checkout develop
git pull
~~~

- `Branch feature/actions`: Crie uma branch de feature local e remota. Utilize o token criado anteriormente em Personal Access Token, se necessário:

~~~
git checkout -b feature/actions
git push --set-upstream origin feature/actions
~~~

- `Script de workflow`: Na pasta base .github/workflows, crie o arquivo 03-workflow-actions.yaml, e insira o seguinte código para definir o job:

~~~
name: 03 - Actions

on: 
    push:
        branches: "feature/**"

jobs:
    checkout_java_docker:
        runs-on: ubuntu-latest
        steps:            
            - name: Git Checkout
              uses: actions/checkout@v4

            - name: Setup Java SDK
              uses: actions/setup-java@v4
              with:
                distribution: 'temurin' 
                java-version: '21'

            - name: Build
              uses: docker/build-push-action@v6
              with:
                push: false                    

            - name: Executar scripts
              run: |
                git branch
                java --version 
                mvn clean package
~~~

- no workflow, as actions foram definidas no atributo "uses" seguido do nome da action. O nome da action pode ser encontrado nos links das referidas actions no Marketplace do GitHub.
	- `actions/checkout@v4`: executa o checkout do código-fonte para branch atual.
	- `actions/setup-java@v4`: instala o Java SDK para a versão expecífica definida em "java-version". Adicionalmente a action instala o Maven.
	- `docker/build-push-action@v6`: instala o Docker e realiza o build da imagem sem realizar push para repositório de imagens.
	- `step "Executar scripts"`: neste step são executados 3 instruções.

- após criar ou modificar o arquivo, adicione as alterações ao stage local, comite e faça o upload para o repositório remoto:

~~~
git add .github/workflows/03-workflow-actions.yaml
git commit -m "Adicionar workflow com actions"
git push
~~~

- no menu "Actions" do repositório, localize e selecione o workflow "03–Actions".
- clique sobre o commit "Adicionar workflow com actions" e verifique o job "checkout_java_docker", onde você pode analisar os detalhes de cada step executado.

## 2.6 Script de CI/CD

- com um entendimento claro sobre o GitHub Actions, incluindo seus eventos, filtros e actions pré-configuradas, estamos prontos para definir dois workflows essenciais: um para integração contínua e outro para deploy. 
- esses workflows automatizam tarefas críticas no ciclo de vida do desenvolvimento de software, assegurando qualidade e eficiência nas entregas.
- este workflow é designado para executar testes unitários automaticamente em cada pull request criado a partir das branches "feature". 
- se algum teste falhar, o merge para a branch principal será bloqueado, garantindo que apenas código testado e aprovado seja integrado.

~~~
name: Continuous Integration
on:
    pull_request:
        types: [opened, reopened]
        branches: "feature/**"
jobs:
    tests:
        runs-on: ubuntu-latest
        steps:             
        -  
            name: Git Checkout 
            uses: actions/checkout@v4 
 
        -   name: Setup Java SDK 
            uses: actions/setup-java@v4 
            with: 
              distribution: 'temurin'  
              java-version: '21' 
        -   name: Unit tests
            run: mvn test
~~~

- o workflow de deploy será disparado a cada push na branch "main", este workflow contém dois jobs críticos: build e deploy. 
- o job 'build' é responsável por criar e fazer upload da imagem Docker no Docker Hub, enquanto o job 'deploy' gerencia a publicação da imagem no Azure Web App.name: Continuous Deployment.

~~~
on:
    push:
        branches: "feature/main"
 
env:
  IMAGE_NAME: simple-api-java
  AZURE_WEBAPP_NAME: simple-api-java
 
jobs:
    build:
        runs-on: ubuntu-latest
        steps:             
        -  
            name: Git Checkout 
            uses: actions/checkout@v4 
 
        -   name: Setup Java SDK 
            uses: actions/setup-java@v4 
            with: 
              distribution: 'temurin'  
              java-version: '21'
        -
            name: Login to Docker Hub
            uses: docker/login-action@v3
            with:
                username: ${{ secrets.DOCKERHUB_USERNAME }}
                password: ${{ secrets.DOCKERHUB_TOKEN }}
        - 
            name: Build 
            uses: docker/build-push-action@v6 
            with: 
                push: true
                tags: ${{ secrets.DOCKERHUB_USERNAME }}/${{ env.IMAGE_NAME }}:latest
    deploy:
        runs-on: ubuntu-latest
        needs: build
        steps:
        - 
            name: Deploy to Azure Web App
            id: deploy-to-webapp
            uses: azure/webapps-deploy@v2
            with:
              app-name: ${{ env.AZURE_WEBAPP_NAME }}
              publish-profile: ${{ secrets.AZURE_WEBAPP_PUBLISH_PROFILE }}
              images: 'ghcr.io/${{ secrets.DOCKERHUB_USERNAME }}/${{ env.IMAGE_NAME }}:latest'
~~~

- os scripts devem ser inicialmente criados na branch "develop". Posteriormente, branches "feature" serão derivadas desta para o desenvolvimento específico de funcionalidades. 
- conforme o desenvolvimento evolui e as tarefas são completadas, Pull Requests e merges serão feitos das branches "feature" para "develop".
- finalmente, o deploy ocorrerá após o merge da branch "develop" na "main", assegurando que o código promovido está estável e pronto para produção.

--- 

## FAST TEST

### 1. Sobre integração contínua (Continuous Integration - CI), assinale a alternativa correta:
> A integração contínua (Continuous Integration/CI) é uma prática de software que requer a confirmação frequente de código em um repositório compartilhado.

### 2. Assinale a alternativa que completa corretamente a frase a seguir: "_________ é uma plataforma líder em conteinerização, que permite encapsular a aplicação e suas dependências em um container isolado, o que simplifica as configurações e aumenta a segurança ao reduzir discrepâncias entre os ambientes".
> Docker.

### 3. Leia a descrição a seguir: "Direciona uma empresa na criação de um processo simplificado e automatizado de lançamento de software. No centro desse processo há um ciclo de feedback que gira em torno da entrega de software para o usuário final o mais rápido possível, aprendendo com sua experiência prática e, em seguida, incorporando esse feedback na próxima versão". Essa descrição refere-se a:
> Entrega Contínua.

--- 

[Voltar ao início!](https://github.com/monicaquintal/smart_cities)