<div align="center">
<a href="https://github.com/monicaquintal" target="_blank"><img align="right" height="120px" src="../assets/logo.png" /></a>
<h1>FASE 3 - FRAMEWORKS JAVA</h1>
<h2>Capítulo 06: Nossa aplicação no contêiner.</h2>
</div>

<div align=”center”>
<h2>1. NOSSA APLICAÇÃO NO CONTÊINER </h2>
</div>

## 1.1 Motivação para o uso de contêiner

- como desenvolvedores de software é bastante comum precisarmos configurar o ambiente em que a aplicação será disponibilizada para os usuários, e o uso de contêiner torna isso possível de forma bastante dinâmica de flexível.
- utilizando uma tecnologia de contêiner, também será possível transportar todo o ambiente de desenvolvimento para o ambiente de produção de modo que tudo continue funcionando, já que não será mais necessário a configuração do ambiente em um servidor, bastando apenas publicar o contêiner em um ambiente de nuvem, por exemplo, e tudo funcionará da mesma forma como funcionava na sua máquina. 
- permite escalar o ambiente, aumentando ou diminuindo os recursos necessários para a execução da aplicação de acordo com a demanda.

### 1.1.1 O que é um contêiner?
- é um contêiner virtual que manterá tudo o que é necessário para que uma aplicação específica funcione, como o banco de dados, acesso a rede, serviços web etc. 
- cada contêiner é isolado do sistema operacional hospedeiro (host) e dos demais contêineres, garantindo que a execução de uma aplicação não interfira nas aplicações mantidas pelos outros contêineres. E
- podemos mover um contêiner de um sistema operacional para outro sem que nenhuma configuração seja necessária. 
- a plataforma de conteinerização mais utilizada atualmente é o `Docker`.
- contêineres se parecem muito com máquinas virtuais, com a diferença de serem muito mais leves e totalmente integrados ao sistema operacional hospedeiro (host). 
  - enquanto máquinas virtuais emulam um sistema operacional inteiro, virtualizando todo seu hardware e consumindo mais recursos da máquina hospedeira, o contêiner utiliza o kernel do sistema operacional da máquina hospedeira, assim como o seu hardware.
  - podemos rodar muito mais contêineres na máquina hospedeira do que seria possível utilizando máquinas virtuais.
  - resumindo: 
    - com máquinas virtuais você vai emular um novo sistema operacional dentro do seu computador, ou seja, recursos de memória, disco, hardware e tudo mais que seja necessário para que a máquina virtual funcione. 
    - com contêineres a emulação ocorre apenas para as aplicações e suas dependências, tornando o contêiner uma solução mais leve e totalmente portátil.

### 1.1.2 O que é o Docker?
- é uma plataforma de código aberto criado em 2013 pela DotCloud para conteinerização de aplicações. 
- permite empacotar um aplicativo e todas as suas dependências em uma imagem leve e portátil que roda em diversos sistemas operacionais sem que nenhuma configuração seja necessária.
- ou seja, o contêiner que você criou no GNU/Linux vai rodar no Microsoft Windows ou MacOS.
- as principais aplicações de contêineres Docker estão na facilidade de criação de ambientes para testes, produção e microsserviços.

- o Docker cria um contêiner que encapsula basicamente os seguintes componentes:
  - `Código-fonte da aplicação`: todas as instruções que fazem a aplicação funcionar.
  - `Bibliotecas e frameworks`: componentes de software necessários para a execução do aplicativo.
  - `Sistema Operacional`: sistema operacional mínimo para executar o aplicativo.
  - `Configurações`: configurações necessárias para que a aplicação funcione.

- o Docker nos oferece os ***benefícios***:
  - `Portabilidade`: contêineres Docker podem ser portados de um ambiente para outro independentemente de sistema operacional ou hardware sem que nenhuma configuração adicional seja necessária, bastando que o Docker engine esteja instalado no host destino.
  - `Isolamento`: os contêineres são isolados uns dos outros. Isso melhora a estabilidade e segurança dos sistemas.
  - `Agilidade`: contêineres Docker podem ser criados e destruídos rapidamente, facilitando a depuração e testes de aplicação em diferentes ambientes.
  - `Escalabilidade`: podem ser escalados para cima e para baixo de acordo com a demanda de carga.

### 1.1.3 Conceito de Imagem
- imagens são pacotes que contém tudo o que é necessário para que uma aplicação funcione adequadamente. 
- ***dentro da imagem nós temos a aplicação, suas dependências, bibliotecas, binários e os arquivos que são necessários para que a aplicação possa ser executada***.
- é o que torna o contêiner portável. 
- não é possível editar a imagem depois que ela foi criada.
- a imagem será utilizada para “subir” o contêiner que será colocado em execução no ambiente de produção e deverá funcionar exatamente como na máquina do desenvolvedor.
- podem ser compostas (e na maioria das vezes é) por diversas camadas.
  - **camadas** são os recursos que a aplicação precisa para funcionar. 
  - exemplo: a imagem do servidor web Tomcat é baseada na imagem do GNU/Linux Debian.
- importante lembrar que através de uma imagem é possível criar diversos contêiners.

### 1.1.4 Instalação do Docker
- passos:
  - 1. download do [Docker Desktop](https://www.docker.com/products/docker-desktop/).
  - 2. Ao acessar a página de download do Docker Desktop, clique no botão Download for Windows.
  - 3. Após conclusão do download, acesse a pasta onde o download foi efetuado e dê um duplo clique no arquivo “Docker Desktop Installer”.
  - 4. Se for solicitado permitir que o aplicativo faça alterações no seu dispositivo, responda "Sim".
  - 5. Na tela “Configuration”, mantenha as duas opções selecionadas e pressione “OK”.
  - 6. A Janela “Docker Desktop” será exibida para acompanharmos o processo de instalação.
  - 7. Assim que a instalação for concluída, reiniciar o sistema clicando no botão “Close and restart”.

> ATENÇÃO! O Docker é baseado no conceito e tecnologias de sistemas operacionais tipo Unix, como o GNU/Linuxe MacOS. Para o Docker funcionar no Windows, é necessária uma camada de compatibilidade que é o Windows Subsystemfor Linux (WSL), que fornece um ambiente GNU/Linux virtual dentro do Windows.

### 1.1.5 Testando a instalação do Docker
- efetuar alguns testes para verificar se o Docker foi instalado corretamente. 
- digite o comando no prompt do Windows: `docker -v`.

## 1.2 Utilizando o Docker

- é uma ferramenta muito poderosa, utilizada para criar as imagens dos nossos aplicativos e executar nossos contêineres. 
- apesar do Docker disponibilizar um ambiente gráfico, vamos utilizar o terminal, que é a forma mais utilizada.

### 1.2.1 Executando o primeiro contêiner
- para executar o contêiner “hello-world”, digite o comando: `docker container run hello-world`. 
  - ao pressionar Enter, a mensagem exibida indica que o serviço Docker não foi inicializado. 
  - para iniciar o serviço Docker, abra o aplicativo Docker Desktop.
  - ao abrir o Docker Desktop, aceite os termos de uso, depois clique no link “Skip survey”.
  - assim que a tela inicial do Docker Desktop for aberta, o serviço Docker já estará pronto para começar.

- rodar novamente o comando para executaro nosso primeiro contêiner.
  - ao rodar o comando acima, o Docker buscou localmente pela imagem responsável por executar esta aplicação.
  - a imagem não foi encontrada localmente, então o Docker buscou a imagem da aplicação “hello-world” no “Docker Hub”, que é um repositório público de imagens Docker mantidos pela comunidade.
  - ao concluir o download da imagem o Docker cria o contêiner “hello-world” que é executado para nos mostrar as mensagens de boas-vindas e testar se o ambiente Docker está instalado e configurado corretamente. 
  - logo após a execução o contêiner é parado.

### 1.2.2 Listando os contêineres do sistema
- comando `docker container ls`.
  - o resultado da instrução “docker container ls” não nos mostrou nenhum container. 
  - isso se deve ao fato de que esse comando exibe apenas os contêineres em execução, e não temos nenhum.
- para exibir a lista completa de contêineres, inclusive os que estão parados, acrescentar o parâmetro “-a”: `docker container ls -a`.
  - temos apenas 1 contêiner em nosso sistema. 
  - a saída do comando “docker container ls” é dividida em 5 colunas:
    - ***CONTAINER_ID***: identificação única do contêiner.
    - ***IMAGE***: imagem que foi utilizada para a execução do contêiner.
    - ***COMMAND***: comando em execução.
    - ***CREATED***: data de criação do contêiner.
    - ***STATUS***: o status atual do contêiner.
    - ***PORT***: a porta do contêiner e do hospedeiro (host) que o contêiner utiliza.
    - ***NAMES***: o nome do contêiner. Se não for fornecido um nome no momento da criação do contêiner um nome aleatório será criado pelo Docker.

### 1.2.3 Listando as imagens locais
- quando executamos um contêiner, é necessário a imagem com a aplicação que queremos executar. 
- se a imagem estiver disponível no host, o contêiner será criado com essa imagem. 
- caso a imagem não esteja disponível localmente ela será baixada do Docker Hub. 
- para listar as imagens disponíveis no host, execute: `docker image ls`.









--- 

[Voltar ao início!](https://github.com/monicaquintal/smart_cities)