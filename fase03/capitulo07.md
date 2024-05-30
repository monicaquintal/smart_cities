<div align="center">
<a href="https://github.com/monicaquintal" target="_blank"><img align="right" height="120px" src="../assets/logo.png" /></a>
<h1>FASE 3 - FRAMEWORKS JAVA</h1>
<h2>Capítulo 07: Deploy da aplicação em cloud.</h2>
</div>

<div align=”center”>
<h2>1. DEPLOY DA APLICAÇÃO EM CLOUD</h2>
</div>

- disponibilizar a aplicação de modo que ela possa ser acessada de qualquer lugar exige infraestrutura e serviços diversos, como espaço físico, energia, servidores, armazenamento, backup, aplicações, infraestrutura de rede, disponibilidade, segurança etc.
- adquirir essa infraestrutura e mantê-la custa caro; além disso, mesmo que tenhamos elaborado um bom estudo sobre o dimensionamento dessa infra, ainda estaremos vulneráveis aos fatores externos que podem aumentar ou diminuir a demanda, tornando a infraestrutura de TI super ou subdimensionada.
- graças aos serviços de nuvem (cloud), podemos aumentar ou diminuir os recursos necessários para mantermos a aplicação de acordo com a demanda.
- o termo nuvem foi criado para representar toda essa gama de serviços computacionais que é invisível ao usuário final e que é acessível de qualquer lugar.
- atualmente é muito raro uma empresa manter 100% dos seus serviços por conta própria; pelo menos uma parte, quando não toda a infraestrutura, é mantida através dos serviços de nuvem.

## 1.1 Vantagens do Deploy em nuvem

- um dos grandes motivos que nos leva a publicar aplicações em serviços de nuvem como a Microsoft Azure, AWS, Oracle Cloud, Google Cloud, dentre outras, é o fato de não precisarmos investir em toda infraestrutura lógica, física e de mão-de-obra necessários para isso.
- principais vantagens:
	- `Escalabilidade`: permite aumentar ou diminuir os recursos computacionais de acordo com a demanda.
	- `Redução de custos`: pagamos apenas o que consumimos, podendo economizar nos momentos em que a demanda é menor e não corrermos o risco de ficar sem recursos quando a demanda é maior.
	- `Alta disponibilidade`: manter a aplicação disponível para o usuário sempre que ele precisar é importantíssimo para o sucesso de uma aplicação. Os provedores de serviço de nuvem disponibilizam serviços que garantem a disponibilidade e tolerância a falhas, garantindo que a aplicação estará disponível sempre que o usuário precisar dela.
	- `Gerenciamento`: provedores de serviços em nuvem oferecem ferramentas de gestão, monitoramento e deploy de forma centralizada, de modo que podemos gerenciar toda a nossa infraestrutura computacional em um único lugar e de qualquer lugar.
	- `Segurança`: provedores oferecem recursos de segurança como firewalls, criptografia, monitoramento de ameaças etc., que garantem a segurança dos dados e dos sistemas por eles mantidos.
	- `Implantação rápida`: geralmente colocar uma aplicação no ar é muito mais rápido do que em uma infraestrutura local, já que o provedor possui diversas ferramentas e recursos que facilitam esse processo.

<div align="center">
<h2>2. FAZENDO DEPLOY EM NUVEM</h2>
</div>

- vamos publicar o contêiner da aplicação que criamos no capítulo 5, que é um dos métodos de publicação mais utilizados hoje.
- vamos aprender sobre mais alguns conceitos importantes, como o uso do Docker Hub.

## 2.1 O que é o Docker Hub?

- Docker Hub é um repositório de imagens de contêineres Docker. 
- é o repositório central onde podemos buscar e compartilhar imagens de contêineres para nossas aplicações. 
- através do Docker Hub que podemos disponibilizar as nossas imagens para outros desenvolvedores, assim como facilitar a publicação de nossas aplicações através de algum serviço de nuvem.
- quando criamos a imagem personalizada da aplicação “contatos”, no capítulo anterior, utilizamos a imagem do GNU/Linux Alpine com o OpenJDK 21, e essa imagem foi obtida no Docker Hub.

## 2.2 Criando um perfil no Docker Hub

- para utilizarmos o Docker Hub para armazenar e distribuir as nossas imagens, é necessário criarmos uma conta de acesso. 
- pode ser utilizado de forma gratuita, mas com algumas limitações, ou você pode pagar uma licença para obter mais recursos.
	- a partir de uma conta gratuita você tem direito a 5GB de armazenamento
para suas imagens, na qual 1 (uma) poderá ser privada e o restante deverão ser
públicas.
- passos para criar uma conta no Docker Hub:
	- 1. Acesse o [link](https://hub.docker.com/).
	- 2. Clique no botão Sign Up.
	- 3. Na janela "Create your account", selecione um modo de autenticação, que poderá ser através de uma conta no Google, no GitHub ou até mesmo uma personalizada.
	- 4. Após a criação da sua conta, você já poderá efetuar a autenticação informando seus dados de acesso.
	- 5. Assim que efetuar o primeiro acesso, você será questionado sobre escolher o seu plano de acesso. Clique no botão "Continue with personal", que é o plano gratuito.
	- 6. Verifique seu e-mail para validar o cadastro.
	- 7. Após a confirmação, você será direcionado a página inicial do Docker Hub e já poderá criar o seu primeiro repositório.

## 2.3 Criando um repositório de imagens no Docker Hub

- passos:
	- 1. Clique no botão "Create a Repository".
	- 2. Na janela "Create repository", preencha o nome do repositório e clique no botão "Create".
	- 3. Assim que você clicar no botão “Create”, será direcionado para o repositório que acabou de ser criado.

## 2.4 Renomeando uma imagem Docker

- após a criação do repositório, já podemos enviar a nossa imagem para ele, mas antes será necessário ajustarmos o nome da imagem em nosso computador para que fique de acordo com o nome do repositório no Docker Hub.
- abra o prompt de comandos e digite o comando: `docker image ls`, que mostrará as imagens disponíveis no seu computador.
- a imagem que será usada para enviar ao Docker Hub é a "contatos".
- o nome da imagem deve ter o seguinte formato: `[namespace/]nome[:tag]`, onde:
	- `namespace`: é o nome do usuário que possui a imagem. Esse nome deve ser o seu nome de login no Docker Hub.
	- `nome`: nome do repositório.
	- `tag`: é um rótulo que identifica a imagem, por exemplo, é bastante comum utilizarmos a versão da imagem como tag.
- não podemos renomear uma imagem, mas podemos criar uma cópia da imagem com outro nome. Então vamos renomear a imagem “contatos” com o comando: `docker tag contatos:spring-docker celsofurtadodev/contatos:v1`.
	- não esquecer de alterar o namespace para o seu nome de login no Docker Hub.
- ao pressionar Enter, se tudo estiver correto, você não receberá nenhuma mensagem. 
- digite o comando `docker image ls` novamente para certificar-se de que a imagem foi criada.
- se desejar, pode apagar a imagem antiga com o comando `docker rmi contatos`.

## 2.5 Enviando a imagem para o repositório Docker Hub

- passos:
	- 1. No prompt de comando, efetue o login no Docker Hub digitando o comando: `docker login`. Ao pressionar Enter, será solicitado o nome do usuário. Digite o nome do usuário e senha (a senha não será mostrada no terminal).
	- 2. Após a autenticação execute o comando `docker push celsofurtadodev/contatos:v1` para enviar a imagem ao repositório no Docker Hub. Esse comando enviará a imagem do computador local para o repositório no Docker Hub.
	- 3. Acesse o repositório no Docker Hub, para confirmar que a imagem foi enviada. Se tudo estiver certo, você deverá ver a sua imagem disponibilizada no repositório.

> IMPORTANTE! Podemos ter várias versões de uma imagem no Docker Hub. Sempre que alguma alteração for efetuada em um contêiner você irá gerar a nova imagem com uma tag diferente, indicando a nova versão.

### 2.5.1 Publicando a aplicação em nuvem
- utilizaremos o Microsoft Azure, um dos serviços de cloud mais utilizados, juntamente com a AWS e Google Cloud. 
- a Microsoft oferece um período de uso gratuito.

### 2.5.2 Criando uma conta no Azure
- é possível criarmos uma conta gratuita para testes.
- há duas formas de criar uma conta gratuita, são elas:
	- `Conta estudantil`:
		- você deverá ter uma conta de e-mail vinculada a alguma instituição de ensino reconhecida pela Microsoft.
		- neste tipo de conta você não precisa fornecer um cartão de crédito para validar a sua conta.
		- para criar um perfil estudantil no Azure clique [neste link](https://azure.microsoft.com/pt-br/free/students/).
		- para efetuar o cadastro é bem simples, clique no botão "Experimente gratuitamente" e siga os passos.
		- com uma conta estudantil você pode utilizar os serviços gratuitos e, além disso, você tem um crédito de U$100 para utilizar os serviços pagos.
	- `Conta gratuita do Azure`:
		- neste tipo de conta você não precisa ter um vínculo com alguma instituição de ensino, mas precisa fornecer um cartão de crédito para validar a sua conta.
		- para criar uma conta gratuita no Azure, utilize [este link](https://azure.microsoft.com/pt-br/free).
		- com uma conta gratuita do Azure você poderá utilizar os serviços gratuitos e, além disso, você recebe um crédito de US$200 para testar os serviços pagos. 
		- após o período de testes ou o fim do crédito de US$200, você poderá ser cobrado pelos serviços pagos, então utilize com bastante atenção.
		- para criar uma conta do Azure gratuita, clique no botão “Experimente gratuitamente” e siga os passos fornecidos pela plataforma.

> ATENÇÃO! Pare todos os serviços que você criou no Azure se você não for utilizá-los. Além disso, lembre-se que alguns serviços serão cobrados, mesmo se estiverem parados, já que a Microsoft cobrará pelo serviço de armazenamento. Se tiver dúvidas, apague os serviços que não for utilizar!

### 2.5.3 Publicando a aplicação no Azure
- vamos publicar o contêiner no Azure para que todos possam utilizar a aplicação. 
- o tipo de serviço que utilizaremos será o “Aplicativo Web”.

### 2.5.4 Criando o serviço Aplicativo Web no Azure
- para publicarmos uma aplicação web, ou um contêiner que utilize um serviço web, utilizamos um serviço no Azure chamado de `Serviços de Aplicativos`.
- para criar este serviço, siga os passos:
	- 1. Faça uma busca para "Serviços de Aplicativo".
	- 2. Clique na opção Serviços de Aplicativos.
	- 3. Na janela “Serviços de Aplicativos”, clique no botão “Criar”, e em seguida clique na opção “Aplicativo Web”.
	- 4. Na janela “Aplicativo Web”, no campo "Grupo de Recursos", clique no link “Criar novo”, forneça um nome para o grupo e pressione o botão “OK”.
	- 5. Preencha o campo “Nome”. Marque a opção “Contêiner do Docker” e altere o campo “Plano de preços” para “Básico B1...”.
	- 6. Clique na opção “Docker”, e altere o campo “Origem da imagem” para “Docker Hub”.
	- 7. Em “Tipo de Acesso”, marque o tipo de acesso ao contêiner no Docker Hub. No caso, o contêiner está “Público”. Em seguida, no campo “Imagem e marca”, preencha com o nome do contêiner e a sua tag e conclua o cadastro clicando no botão “Revisar + criar”.
	- 8. Se o preenchimento dos dados do Aplicativo Web estiver correto, a 
tela de resumo será apresentada com o botão “Criar” disponível.
	- 9. Clique no botão “Criar” para que o Aplicativo Web seja criado. Este passo pode demorar um pouco.
	- 10. Ao concluir a implantação (deploy) do contêiner, você será redirecionado para a página "Implantação concluída".
	- 11. Clique no botão “Ir para o recurso”, para acessar o Aplicativo Web que acabamos de criar.

## 2.6 Testando a aplicação na nuvem

- quando acessamos a página do aplicativo no Azure, podemos ver diversas informações sobre a nossa aplicação, como o “status”, “localização”, “Sistema Operacional” , “Domínio Padrão” etc.
- ***Domínio Padrão*** é a URL da aplicação: para acessarmos os endpoints devemos utilizar esse endereço seguido de `/api/contatos`.
- para testarmos se a nossa aplicação foi implantada corretamente, abra o Insomnia e faça uma requisição para o endpoint responsável por listar todos os contatos. 

--- 

## FAST TEST

### 1. Qual é o serviço Microsoft Azure que pode ser utilizado para publicar aplicações conteinerizadas?
> Aplicativo Web ou Web App.

### 2. Qual das opções melhor descreve as vantagens da utilização de serviços em nuvem em contraste a utilização de servidores locais para publicação de aplicações?
> Não é necessário investir em infraestrutura lógica, física, mão-de-obra, energia elétrica etc.

### 3. Quando houver a necessidade de distribuir a imagem de um contêiner Docker de forma pública ou privada, qual deverá ser a ferramenta utilizada?
> Docker Hub.

--- 

[Voltar ao início!](https://github.com/monicaquintal/smart_cities)











--- 

[Voltar ao início!](https://github.com/monicaquintal/smart_cities)