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
- há apenas uma imagem disponível localmente. 
- colunas da saída da instrução "docker image ls":
	- `REPOSITORY`: nome da imagem.
	- `TAG`: versão da imagem.
	- `IMAGE ID`: identificação única da imagem.
	- `CREATED`: tempo de criação da imagem.
	- `SIZE`: tamanho da imagem.

- importante lembrar que a partir de uma imagem é possível criarmos quantos contêineres precisarmos. 
- executar novamente o comando `docker container run hello
-worl`.
- desta vez não foi necessário efetuar o download da imagem, pois ela já está disponível localmente, e um novo contêiner foi criado e executado logo em seguida.
- listar novamente os contêineres disponíveis na aplicação, usando o comando `docker container ls -a`.
	- agora temos dois contêineres criados no host.
- se listarmos as imagens disponíveis (`docker image ls`) notaremos que temos apenas uma, que foi utilizada para criar os dois contêiners.

### 1.2.4 Executando um contêiner do Apache Web Server
- para um exemplo mais próximo da realidade, executar um contêiner que nos proverá um servidor web, que poderá ser utilizado para publicarmos nossos sites. 
- o servidor que vamos subir será o `Apache`.
- primeiro vamos precisar da imagem deste serviço.
- o **[Docker Hub](https://hub.docker.com)** é um repositório público onde podemos encontrar as imagens das principais aplicações, além de disponibilizar as imagens das nossas aplicações.
	- no campo de busca, digite “apache” e pressione Enter.
	- a imagem que vamos utilizar é a `httpd`, nome servidor web Apache.

> O selo que está ao lado do nome da imagem indica que a imagem oficial, ou seja, foi criada pela equipe do produto. Sempre prefira as imagens oficiais.

- com o nome da imagem, acesse o prompt de comando e execute o comando: `docker container run --name apache httpd`.
	- **--name apache**: parâmetro que informa o nome que queremos utilizar para o contêiner, que neste caso será “apache”.
	- **httpd**: nome da imagem que encontramos no Docker Hub. Essa imagem é maior do que a imagem do “hello-world”, então, ao pressionar Enter, deverá ver na sua tela algumas barrinhas de progresso indicando que a imagem está sendo baixada.
- ao finalizar o download o Docker cria o contêiner e já o executa. 
- apesar de parecer que o comando travou, na verdade o que está ocorrendo é que estamos vendo os logs do Apache. Para sair você deve pressionar `CTRL + C`, que **irá finalizar o processo e matar a execução do contêiner**.
- verificar se o contêiner do Apache foi criado através do comando: `docker container ls -a`, que deve mostrar um novo contêiner chamado “apache”.

### 1.2.5 Iniciando e parando um contêiner existente
- ***para iniciar um contêiner que já existe***, utilizar o comando `docker container start [NAME]`.
	- para inicializar o contêiner chamado apache, executar os comandos: `docker container start apache`e `docker container ls`.
	- no resultado, a coluna “STATUS” possui o valor “Up”, indicando que o contêiner chamado “apache” está em execução.
- ***para parar a execução do contêiner***, basta executar os comandos: `docker container stop apache` e `docker container ls-a`.
	- nesse caso, o contêiner “apache” estará com o status “Exited”, indicando que está parado.
	
### 1.2.6 Removendo contêiners
- para removermos um contêiner que não precisamos mais, executar o comando `docker container rm` seguido do nome ou identificador do contêiner.
- ***para excluir um contêiner ele deve estar parado***.
- digitar os comandos para excluir os contêineres hello-world, utilizando nomes ou identificadores que foram gerados automaticamente pelo Docker (verificar essas informações nos seus contêineres antes de executar os comandos), para exclui-los:
	- `docker container rm goofy_williams`.
	- `docker container rm 9990c`.
	- `docker container ls -a`.

> Importante! Ao utilizar o identificador do contêiner, não é necessário digitar o código todo: basta digitar os caracteres iniciais que não conflitam com as iniciais dos identificadores de outros contêineres.

### 1.2.7 Visualizando detalhes do contêiner
- muitas vezes é necessário obtermos alguma informação mais detalhada de um determinado contêiner, como a data de criação do contêiner, configurações de rede do contêiner, dados sobre uso de CPU e/ou memória etc.
- para isso temos o comando `docker container inspect`.
	- execute o comando `docker container inspect apache` para verificar os dados do contêiner apache.
	- o resultado deste comando é bem extenso.

~~~json
{
    "Id": "f3d2ce597d7916c6a83af67c15139498f9f5302d75fe8a7d151dd2989bbb1ddc",
    "Created": "2024-03-18T12:03:18.913799019Z",
    "Path": "httpd-foreground",
    "Args": [],
    "State": {
        "Status": "exited",
        "Running": false,
        "Paused": false,
        "Restarting": false,
        "OOMKilled": false,
        "Dead": false,
        "Pid": 0,
        "ExitCode": 0,
        "Error": "",
        "StartedAt": "2024-03-18T12:03:19.429250413Z",
        "FinishedAt": "2024-03-18T12:13:43.993604446Z"
    },
    "Image": "sha256:ac45b24b92cc0527c6af660679d0701f680a6d4214cf5cf9a147f20127d9685e",
    "ResolvConfPath": "/var/lib/docker/containers/f3d2ce597d7916c6a83af67c15139498f9f5302d75fe8a7d151dd2989bbb1ddc/resolv.conf",
    "HostnamePath": "/var/lib/docker/containers/f3d2ce597d7916c6a83af67c15139498f9f5302d75fe8a7d151dd2989bbb1ddc/hostname",
    "HostsPath": "/var/lib/docker/containers/f3d2ce597d7916c6a83af67c15139498f9f5302d75fe8a7d151dd2989bbb1ddc/hosts",
    "LogPath": "/var/lib/docker/containers/f3d2ce597d7916c6a83af67c15139498f9f5302d75fe8a7d151dd2989bbb1ddc/f3d2ce597d7916c6a83af67c15139498f9f5302d75fe8a7d151dd2989bbb1ddc-json.log",
    "Name": "/apache",
    "RestartCount": 0,
    "Driver": "overlay2",
    "Platform": "linux",
    "MountLabel": "",
    "ProcessLabel": "",
    "AppArmorProfile": "",
    "ExecIDs": null,
    "HostConfig": {
        "Binds": null,
        "ContainerIDFile": "",
        "LogConfig": {
            "Type": "json-file",
            "Config": {}
        },
        "NetworkMode": "default",
        "PortBindings": {},
        "RestartPolicy": {
            "Name": "no",
            "MaximumRetryCount": 0
        },
        "AutoRemove": false,
        "VolumeDriver": "",
        "VolumesFrom": null,
        "ConsoleSize": [
            21,
            85
        ],
        "CapAdd": null,
        "CapDrop": null,
        "CgroupnsMode": "host",
        "Dns": [],
        "DnsOptions": [],
        "DnsSearch": [],
        "ExtraHosts": null,
        "GroupAdd": null,
        "IpcMode": "private",
        "Cgroup": "",
        "Links": null,
        "OomScoreAdj": 0,
        "PidMode": "",
        "Privileged": false,
        "PublishAllPorts": false,
        "ReadonlyRootfs": false,
        "SecurityOpt": null,
        "UTSMode": "",
        "UsernsMode": "",
        "ShmSize": 67108864,
        "Runtime": "runc",
        "Isolation": "",
        "CpuShares": 0,
        "Memory": 0,
        "NanoCpus": 0,
        "CgroupParent": "",
        "BlkioWeight": 0,
        "BlkioWeightDevice": [],
        "BlkioDeviceReadBps": [],
        "BlkioDeviceWriteBps": [],
        "BlkioDeviceReadIOps": [],
        "BlkioDeviceWriteIOps": [],
        "CpuPeriod": 0,
        "CpuQuota": 0,
        "CpuRealtimePeriod": 0,
        "CpuRealtimeRuntime": 0,
        "CpusetCpus": "",
        "CpusetMems": "",
        "Devices": [],
        "DeviceCgroupRules": null,
        "DeviceRequests": null,
        "MemoryReservation": 0,
        "MemorySwap": 0,
        "MemorySwappiness": null,
        "OomKillDisable": false,
        "PidsLimit": null,
        "Ulimits": null,
        "CpuCount": 0,
        "CpuPercent": 0,
        "IOMaximumIOps": 0,
        "IOMaximumBandwidth": 0,
        "MaskedPaths": [
            "/proc/asound",
            "/proc/acpi",
            "/proc/kcore",
            "/proc/keys",
            "/proc/latency_stats",
            "/proc/timer_list",
            "/proc/timer_stats",
            "/proc/sched_debug",
            "/proc/scsi",
            "/sys/firmware"
        ],
        "ReadonlyPaths": [
            "/proc/bus",
            "/proc/fs",
            "/proc/irq",
            "/proc/sys",
            "/proc/sysrq-trigger"
        ]
    },
    "GraphDriver": {
        "Data": {
            "LowerDir": "/var/lib/docker/overlay2/673933cc5ef69cd229a87ffef00beb90f3257fadb721f1d68d722ca9f2bf63e8-init/diff:/var/lib/docker/overlay2/3c32459f70898bc8ad33b429ff2954a6f4289addea764bc64f4ece056dcd8c69/diff:/var/lib/docker/overlay2/d22f37535b96d9cebe4e813ea9aea6e21e20b4715e8345a73fa54cf1d8187185/diff:/var/lib/docker/overlay2/9a80f26f2e27e767676d2df33b1d4b8dfacf0e955168ba4ee2f7863a2383168f/diff:/var/lib/docker/overlay2/0fd6c717071f432b2a65c4c46fa67b0bbd7df1f86af15fcc9fec968ba4c712be/diff:/var/lib/docker/overlay2/6c779c2cc2707830080d28329bdcdab6cf273eb64f985e2f067118558426929e/diff:/var/lib/docker/overlay2/861663556dcd1e485cbafa4ced2428f668e9eb483b1ab639f430ae029c27d679/diff",
            "MergedDir": "/var/lib/docker/overlay2/673933cc5ef69cd229a87ffef00beb90f3257fadb721f1d68d722ca9f2bf63e8/merged",
            "UpperDir": "/var/lib/docker/overlay2/673933cc5ef69cd229a87ffef00beb90f3257fadb721f1d68d722ca9f2bf63e8/diff",
            "WorkDir": "/var/lib/docker/overlay2/673933cc5ef69cd229a87ffef00beb90f3257fadb721f1d68d722ca9f2bf63e8/work"
        },
        "Name": "overlay2"
    },
    "Mounts": [],
    "Config": {
        "Hostname": "f3d2ce597d79",
        "Domainname": "",
        "User": "",
        "AttachStdin": false,
        "AttachStdout": true,
        "AttachStderr": true,
        "ExposedPorts": {
            "80/tcp": {}
        },
        "Tty": false,
        "OpenStdin": false,
        "StdinOnce": false,
        "Env": [
            "PATH=/usr/local/apache2/bin:/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin",
            "HTTPD_PREFIX=/usr/local/apache2",
            "HTTPD_VERSION=2.4.58",
            "HTTPD_SHA256=fa16d72a078210a54c47dd5bef2f8b9b8a01d94909a51453956b3ec6442ea4c5",
            "HTTPD_PATCHES="
        ],
        "Cmd": [
            "httpd-foreground"
        ],
        "Image": "httpd",
        "Volumes": null,
        "WorkingDir": "/usr/local/apache2",
        "Entrypoint": null,
        "OnBuild": null,
        "Labels": {},
        "StopSignal": "SIGWINCH"
    },
    "NetworkSettings": {
        "Bridge": "",
        "SandboxID": "e47ae4b437e2fe3645efda20818851b6a2ce981757893e7b8251f5eeea5fd224",
        "HairpinMode": false,
        "LinkLocalIPv6Address": "",
        "LinkLocalIPv6PrefixLen": 0,
        "Ports": {},
        "SandboxKey": "/var/run/docker/netns/e47ae4b437e2",
        "SecondaryIPAddresses": null,
        "SecondaryIPv6Addresses": null,
        "EndpointID": "",
        "Gateway": "",
        "GlobalIPv6Address": "",
        "GlobalIPv6PrefixLen": 0,
        "IPAddress": "",
        "IPPrefixLen": 0,
        "IPv6Gateway": "",
        "MacAddress": "",
        "Networks": {
            "bridge": {
                "IPAMConfig": null,
                "Links": null,
                "Aliases": null,
                "NetworkID": "f5807c0e737d300a9e13228f56583a87a288559caf04ba788490afbfcf49ce80",
                "EndpointID": "",
                "Gateway": "",
                "IPAddress": "",
                "IPPrefixLen": 0,
                "IPv6Gateway": "",
                "GlobalIPv6Address": "",
                "GlobalIPv6PrefixLen": 0,
                "MacAddress": "",
                "DriverOpts": null
            }
        }
    }
}
]
~~~

- na listagem acima, é possível ter acesso a diferentes informações sobre o contêiner, como configurações de rede, nome, sistema operacional base, dentre outras informações.

### 1.2.8 Acessando o serviço do contêiner
- já temos um contêiner no sistema responsável por entregar o serviço web, ou seja, podemos hospedar um site neste contêiner para que os usuários possam acessá-lo. 
- como faremos esse acesso se a rede do contêiner é isolada do host?
	- ***precisamos fazer um redirecionamento de portas, ou seja, a requisição será feita para o host, mas será direcionada para o contêiner***.
- servidores web utilizam a ***porta 80 como porta padrão para acesso externo***, então precisamos configurar o Docker para que as requisições para a porta 80 no host seja direcionado ao contêiner. 
- executar o comando:
	- `docker container run -d -p 80:80 --name apache-fiap httpd` e
	- `docker container ls` .
	- em alguns casos, o Microsoft Windows solicita autorização para executar o comando; basta autorizar.
- na execução do comando para criar um contêiner, utilizamos os parâmetros:
	- `-d` : inicia o contêiner como serviço em segundo plano, devolvendo o comando ao prompt logo após a execução.
	- `-p`: indica o redirecionamento de portas, sendo:
		- **valor à esquerda dos dois pontos (:)**: porta do host e 
		- **valor da direita**: porta do contêiner. Assim, *estamos configurando o Docker para direcionar as requisições na porta 80 do host para a porta 80 do contêiner e acessamos o serviço*!
- ao listarmos todos os contêiners, agora temos dois contêineres, um “apache” e outro “apache-fiap”.
- no contêiner “apache-fiap”, a indicação da coluna “STATUS” nos dá a informação de que o contêiner está em execução através do valor “Up”, 
enquanto a coluna “PORTS” indica o direcionamento de porta que foi efetuado.
- com essas configurações, podemos acessar o serviço do contêiner “apache-fiap”. 
	- abra o navegador e digite na linha de endereço “localhost”. 
	- você deverá ter acesso ao site que o contêiner está hospedando, que é uma mensagem de “It works!”.

### 1.2.9 Acessando o contêiner
- mas e se precisarmos alterar o site que está hospedado no contêiner? 
- também é bastante simples, basta acessarmos o contêiner através de um terminal e efetuarmos as alterações necessárias.
- nesta prática, vamos alterar o conteúdo do site hospedado no contêiner “apache-fiap”, de modo que ele mostre a mensagem “Oi galera da FIAP!!”. 
	- digite o comando `docker container exec --tty --interactive apache-fiap bash`. Parâmetros:
	- ***docker container exec***: informa ao Docker que queremos executar um processo em um contêiner existente.
	- ***--tty***: aloca um pseudo terminal ao contêiner, permitindo que possamos interagir com ele utilizando comandos de shell.
	- ***--interactive***: deixa o processo em execução em segundo plano e nos permite interagir com o contêiner digitando comandos nele.
	- ***apache-fiap***: nome do contêiner que desejamos acessar.
	- ***bash***: nome do shell padrão do GNU/Linux.
- após a execução, o prompt de comando fica diferente, pois neste momento ***não estamos mais no prompt de comando do Windows, mas no prompt de comando do GNU/Linux***, que chamamos de `shell`. T
	- todos os comandos executados aqui serão interpretados pelo contêiner.
- **para vermos a lista de arquivos e pastas existente no contêiner**, utilizar o comando `ls`, responsável por listar o conteúdo de uma pasta em sistemas operacionais baseados em Unix, como é o caso do GNU/Linux, que se baseia o nosso contêiner. 
	- digite o comando `ls -l`.
	- ao pressionar Enter, você verá a lista de arquivos e pastas da pasta atual, onde é possível observarmos uma pasta chamada "htdocs", onde ficam os arquivos de um site hospedado pelo servidor web Apache.
	- acessar esta pasta digitando o comando `cd htdocs`.
	- após execução, observe que o prompt de comando mudou, pois agora estamos dentro da pasta htdocs.
	- rode novamente o comando `ls -l` para listar o conteúdo desta pasta.
	- como podemos ver, existe apenas um arquivo chamado “index.html”, no qual vamos alterar a mensagem do site. 
- para editarmos o arquivo vamos ***utilizar um programa chamado nano***, que não está instalado no contêiner.
	- como o contêiner é baseado no GNU/Linux Debian, podemos utilizar o `utilitário apt` para instalar um novo programa.
	- digite os comandos `apt update` e `apt install nano` para instalar o aplicativo nano em nosso contêiner.
		- o comando **apt update** atualiza os repositórios de programas do Debian, o que é importante para garantirmos que estamos utilizando os repositórios mais atualizados. 
		- o comando **apt install nano** instala o aplicativo nano no contêiner.
- com o aplicativo nano instalado, execute o comando `nano index.html` para abrir o arquivo index.html.
	- ao executar o comando  o arquivo index.html será aberto, permitindo
que alteremos o seu conteúdo.
	- altere a mensagem dentro das tags h1, inserindo "Oi galera da FIAP!".
	- para salvar as alterações no arquivo index.html pressione as teclas `CTRL + O`, e em seguida pressione Enter.
	- para sair do aplicativo nano e retornar ao shell do contêiner, pressione `CTRL + X`.
- abra novamente o navegador no host e acesse o site através do endereço **localhost**.

<div align="center">
<h2>2. DOCKERIZANDO NOSSA APLICAÇÃO SPRING BOOT</h2>
</div>

## 2.1 Por que criar uma imagem Docker?

- o Docker oferece muitas facilidades, como a portabilidade, isolamento, escalabilidade etc. 
- o principal motivo para querermos criar uma imagem da nossa aplicação, e posteriormente executá-la como um contêiner, é poder utilizar todas essas facilidades.
- a ***possibilidade de executar a nossa aplicação em qualquer ambiente sem a necessidade de efetuarmos configurações exaustivas em servidores de aplicação*** é um dos principais motivos para “dockerizar” uma aplicação.
- o processo é simples e precisa de algumas ferramentas.

### 2.1.1 Instalação do Maven
- o Maven é um **Build Tool**: 
	- responsável por preparar todo o ambiente necessário para criarmos uma aplicação Spring Boot obtendo e configurando todas as dependências utilizadas pelo projeto.
	- também é responsável por empacotar o nosso projeto com tudo o que é necessário para executar a aplicação em uma JVM (Java Virtual Machine).
- a instalação do Maven é bastante simples, bastando efetuar o download do
pacote com os binários do Maven e descompactá-lo em uma pasta de sua preferência. 
	- caso queira executá-lo de qualquer lugar do seu computador, adicioná-
lo às variáveis de ambiente do seu sistema operacional.
- **passos para baixar o Maven** (pacote de binários do Maven):
	- 1. Acesse o [link](https://maven.apache.org/download.cgi).
	- 2. Na página de download do Maven, selecione a opção de acordo com o seu sistema operacional.
	- 3. Descompacte o arquivo que você baixou em uma pasta qualquer do seu computador.
	- 4. Adicione o path do Maven nas variáveis de ambiente do seu sistema operacional. No Windows, clique no botão “Super” (ícone do Windows na barra de tarefas) e digite "variáveis de ambiente".
	- 5. Na janela "Propriedades do Sistema", clique no botão "Variáveis de ambiente...".
	- 6. Na janela "Variáveis de Ambiente", clique no botão "Novo...".
	- 7. Na janela "Variáveis de Ambiente", selecione a variável de sistema chamada "Path",  da seção "Variáveis do sistema", e clique no botão "Editar...".
	- 8. Na janela "Editar a variável de ambiente", clique no botão "Novo".
	- 9. Na Janela "Editar a variável de ambiente", será aberto um campo no final da lista de paths. Adicione o caminho para a pasta "bin" do Maven, de acordo com o local que você escolheu, e aperte o botão OK.
	- 10. Pressione o botão OK de todas as telas da configuração das variáveis de ambiente.
- após configuração das variáveis de ambiente , abra uma nova sessão do prompt de comando do Windows e execute o comando `mvn -v` (no exemplo, "Apache Maven 3.9.6).

### 2.1.2 Gerando o arquivo .jar do projeto
- gerar o arquivo “.jar” de um projeto Spring Boot para que possamos testar a criação de uma imagem de contêiner personalizada. 
- para isso, você pode utilizar um projeto Spring Boot que você desenvolveu em outro momento, ou faça o clone do projeto disponibilizado [neste link](https://github.com/FIAP/ON_TDS_JAVA_ADVANCED_SPRING_DOCKER.git).
- de posse de um projeto Spring Boot, vamos criar o arquivo “.jar” do projeto.
- passo a passo:
	- 1. No IntelliJ, clique no ícone "Terminal".
	- 2. Digite o comado `dir` para listar o conteúdo da pasta atual, que é a pasta do nosso projeto.
	- 3. De acordo com a listagem, existe uma pasta chamada ***target***. Esta pasta, por padrão, é utilizada para guardar o arquivo executável (.jar) da aplicação. Digite o comando `dir target` para vermos que ainda não temos esse arquivo.
	- 4. Para criarmos o arquivo executável da aplicação (.jar), vamos rodar o comando `mvn install` (resposta: BUILD SUCCESS).
	- 5. Rode novamente o comando `dir target` no terminal.

### 2.1.3 Criação da imagem Docker da aplicação
- para criarmos a imagem da aplicação, vamos criar um arquivo chamado ***Dockerfile*** na raiz do projeto, o qual conterá as instruções necessárias para que o Docker crie a imagem que será utilizada posteriormente para subirmos a aplicação em um servidor local ou em um serviço de aplicação em nuvem.
- passos:
	- 1. Crie um arquivo de texto chamado “Dockerfile”, na raiz do projeto. Com o Windows, podemos usar o comando `notepad DockerFile`. Ao pressionar Enter, será solicitada uma confirmação sobre o nome do arquivo; pressione o botão Sim.
	- 2. Assim que o arquivo for aberto, insira as configurações da imagem:

~~~
FROM eclipse-temurin:21-alpine
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=target/contatos-0.0.1-SNAPSHOT.jar
ADD JAR_FILE app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
~~~

- o arquivo Dockerfile possui as configurações:
	- **Linha 1**: a palavra-chave FROM especifica a imagem base da imagem que vamos criar , ou seja, a nossa imagem será criada a partir de uma imagem do GNU/Linux Alpine com o OpenJDK 21. Essa imagem é necessária para rodarmos a nossa aplicação.
	- **Linha 2**: a palavra-chave VOLUME diz ao Docker para criar um volume no caminho /tmp no contêiner. Volumes são pastas que armazenam os dados da aplicação mesmo quando o contêiner é reiniciado, assim, os dados armazenados nesta pasta serão recuperados ao reiniciar o contêiner.
	- **Linha 3**: a palavra-chave EXPOSE diz ao Docker que a aplicação atenderá as requisições na porta “8080”.
	- **Linha 4**: o argumento ARG JAR_FILE informa ao Docker o caminho do arquivo “.jar” que deverá ser adicionado à imagem Docker.
	- **Linha 5**: o argumento ADD ${JAR_FILE} copia o arquivo informado no argumento ARG JAR_FILE para a imagem com o nome app.jar.
	- **Linha 6**: o argumento ENTRYPOINT informa ao Docker qual será o comando executado quando o contêiner for iniciado. De acordo com as configurações desse argumento, deverá ser executado o comando que executa a nossa aplicação, sendo:
		- *java*: executável da JRE (Java Runtime Environment)
		- *jar*: informa a JRE que ela executará um arquivo .jar.
		- *app.jar*: informa a JRE qual será o arquivo executado.

- salve o arquivo Dockerfile e feche o Bloco de Notas. 
- digite o comando `dir` para certificar que o arquivo foi criado corretamente.
- o arquivo foi criado com a extensão txt: devemos remover a extensão. Para isso rode o comando `ren Dockerfile.txt Dockerfile`, em seguida execute novamente o comando `dir` para certificar que o nome do arquivo foi corrigido.
- finalmente, digite o comando `docker build -t contatos:spring-docker .` para gerar a imagem.
- para confirmar a criação da imagem, execute o comando `docker image ls`.

### 2.1.4 Criação de um contêiner a partir da imagem personalizada
- agora que a imagem da aplicação foi criada, digite o comando `docker container run --name contatos-container -d -p 8080:8080 contatos:spring-docker` para criarmos um contêiner a partir da nossa imagem, onde:
	- **--name**: determina o nome do contêiner.
	- **-d**: indica que o contêiner será executado como serviço (daemon).
	- **-p**: mapeia a porta 8080 do host para a porta 8080 do contêiner, assim podemos acessar o contêiner a partir do host local.
	- **contatos:spring-docker**: é o nome da nossa imagem seguida pela tag.
- para verificarmos se o contêiner está executando, rode o comando `docker container ls`.

### 2.1.5 Testando o contêiner
- verificar se todas as suas funcionalidades estão funcionando corretamente. 
- abra o Insomnia e faça alguns testes. 
- exemplos:
	-  Inserir contatos: método `POST`, url `http://localhost:8080/api/contatos`.
	- Listar todos os contatos: método `GET`, url `http://localhost:8080/api/contatos`.
	- Consultar contatos pelo id: método `GET`, url `http://localhost:8080/api/contatos/2`.

---

## FAST TEST

### 1. Qual a função do arquivo Dockerfile?
>Guardar as instruções necessárias para que o Docker crie a imagem do aplicativo.

### 2. Sabendo-se que a imagem de contêiner do Apache é httpd, qual é o comando utilizado para criar um novo container Apache com o nome apache2 que atende requisições na porta local 8080?
> docker container run --name apache2 -d -p 8080:80 httpd

### 3. Qual o comando utilizador para parar um contêiner chamado apache2?
> docker container stop apache2

--- 

[Voltar ao início!](https://github.com/monicaquintal/smart_cities)
