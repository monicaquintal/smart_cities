<div align="center">
<a href="https://github.com/monicaquintal" target="_blank"><img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/kotlin/kotlin-original.svg" width="100px" align="left"/></a>
<h1>FASE 1 - APP WORLD</h1>
<h2>Capítulo 3A: A casa do Android.</h2>
</div>

<div align="center">
<h2>1. A CASA DO ANDROID</h2>
</div>

## 1.1 O Android Studio e os procedimentos para instalação

- `Android Studio`: ambiente de desenvolvimento indicado pela Google para o desenvolvimento de aplicativos em Android.
- baseado no ambiente de desenvolvimento IntelliJ IDEA.
- permite criar aplicativos utilizando recursos de produtividade que vão desde a autoconfiguração do projeto (Gradle) até o gerenciamento de emuladores de diferente dispositivos.
- pode ser instalado nos sistemas operacionais mais populares (Windows, distribuições Linux, macOS).
- o portal do Android Studio possui informações e vídeos que auxiliam no download e na configuração inicial.

## 1.2 Instalando a IDE do Android Studio

- acessar o [portal do Android Studio](https://developer.android.com/studio).
- o instalador do Android Studio fará todas as configurações e outros downloads necessários para o sistema operacional escolhido.
- a instalação do SDK (Software Development Kit) é a principal etapa de instalação. Ocasionalmente, a instalação do JDK (Java Development Kit) pode ser solicitada.

## 1.3 Criando o primeiro app: Hello, World

- depois de aberto o Android Studio, selecione a primeira opção New Project.
- na tela de seleção do tipo de projeto inicial, há opções de layouts iniciais para o projeto Android. Selecionar "Empty Activity" e clicar no botão Next.
  - observe que podem ser criados projetos para outros aplicativos das plataformas que o Android suporta: Automotive, Wear OS e Android TV.
- a primeira tela é referente às configurações do projeto:
  - campo Name (nome do aplicativo), no qual deve ser colocado o nome do projeto ("HelloWorld").
  - campo Package name: é uma junção do domínio invertido com o nome do projeto, que ficou assim: br.com.fiap.helloworld; esse item precisa ser único, pois é o pacote que identifica o aplicativo no Google Play.
  - campo Save location: pode ser alterado caso exista a necessidade de alterar o local onde o projeto será salvo.
  - ao final, deve ser especificada a API mínima que o projeto deve suportar. Essa opção é importante, visto que ela afeta diretamente a configuração de componentes.Nesse caso, será mantida a API 24 (Nougat), o que não impede que o aplicativo criado seja executado em versões posteriores. 
- depois de realizar todas as configurações, pressione o botão Finish. Com isso, é iniciada a configuração do projeto para usar o ambiente de desenvolvimento. 

> É importante ressaltar que, para algumas etapas, é preciso haver conexão com a internet para o download de componentes necessários para a configuração do projeto.

> O processamento do Gradle pode demorar um pouco devido à configuração da máquina que está executando o Android Studio. Recomenda-se a utilização de computador com 16GB de RAM e uso de SSD.

- após a compilação ser concluída, uma tela com a estrutura do projeto aparecerá e, para evitar qualquer problema de travamento, é preciso ficar atento à barra inferior da IDE, pois ela informa o que está acontecendo durante o processamento e se o projeto realmente já está pronto para utilização.
- a estrutura do projeto de exemplo consiste em duas pastas principais: 
  - `app`: na qual se encontram três subpastas intituladas manifests, java e res.
    - `MANIFESTS`: AndroidManifest.xml é responsável pelo gerenciamento de permissões, configurações do projeto, como estilo da activity, qual será a activity principal, qual será o nome do app, o ícone,entre outras funções.
    - `JAVA`: três subpastas:
      - na primeira, são criadas as classes do projeto;
      - na segunda (***androidTest***), pode ser elaborado o teste automatizado da nossa aplicação (testes de funcionalidades), e 
      - na terceira (***test***), criamos o teste de interface gráfica.
    - `RES`: quatro subpastas, sendo possível criar mais algumas de acordo com a necessidade.
      - a primeira (***drawable***): na qual haverá imagens, ícones, backgrounds de dimensões fixas que não vão sofrer alterações de acordo com o tamanho da tela do dispositivo; 
      - a segunda (***mipmap***): na qual haverá imagens, ícones, backgrounds de diversas dimensões que se adaptam de acordo com o dispositivo;
      - e a terceira (***values***): na qual criam-se xml padrões de cores, strings e themes, facilitando a reutilização no projeto. 
  - `Gradle Scripts`: em que se encontram os arquivos de bibliotecas internas e externas, configurações do Gradle, como versão, pacote, dependências, versão de SDK, etc.

## 1.4 Criando um emulador (AVD)

- para testar e verificar se o aplicativo está de acordo com o esperado,pode-se utilizar um dispositivo físico, configurando-o como desenvolvedor, ou criar um emulador que simule a configuração de um dispositivo físico.
- para criar um emulador, é necessário executar o aplicativo Device Manager pelo caminho: Tools > DeviceManager, ou pelos atalhos localizados na barra de ferramentas.
- no primeiro uso do Device Manager, nenhum emulador estará configurado.
  - para criar um novo emulador, clique no botão "Create Virtual Device".
  - na próxima página, o hardware desejado para criar o emulador deve ser selecionado; nessa primeira experiência, criar um emulador de ***Phone modelo Pixel 2***.
  - na próxima tela deve ser selecionada a imagem (versão do sistema Android) que vamos utilizar. Nesse caso, utilizar a ***versão API 30 (R)***.
  - na última página, inserir o nome do emulador e, caso pretenda alterar alguma configuração, selecionar a opção desejada, fazer a alteração e finalizar a criação do emulador.
- depois de criar o emulador, ele aparecerá na lista de dispositivos. Para executar, selecionar o desejado e clicar no botão Run (botão verde triangular). Nessa tela, é possível alterar também as configurações de qualquer emulador. 
- depois de executar o emulador, o progresso de configuração aparecerá na tela, fazendo algumas configurações necessárias.
- também é possível alterar a forma de visualização do emulador clicando na engrenagem à direita e selecionando alguma das opções do menu View Mode.

## 1.5 Executando apps no emulador e no dispositivo

- para testar os apps desenvolvidos, há duas opções: criar um emulador ou executar o aplicativo direto em dispositivo físico. 
- para realizar os testes, clicar no botão Run, na barra de ferramentas.
  - ao lado do Run, há um combo que apresenta o valor ***app***, referente ao módulo app do projeto. 
  - um projeto no Android Studio é ***composto de vários módulos*** (por exemplo, se for criado um projeto com suporte a Wear, ou até mesmo se for criado um teste Expresso, haverá a opção para executar o teste Expresso, a versão Wear e a versão Mobile do projeto).
- ao clicar no botão Run, uma janela será aberta com a lista de dispositivos disponíveis para executar o projeto; selecionar o dispositivo e clicar no botão OK. O Android Studio vai compilar o projeto e executar no dispositivo selecionado se não houver erros.
- ***para executar o projeto em device físico conectado via USB***, é necessário habilitar, nas configurações do aparelho, a opção Configurações > Segurança > Fontes desconhecidas e a opção Configurações > Opções do desenvolvedor > Depuração USB.
  - a opção de desenvolvedor não aparece por padrão no Android 3.2 ou superior, para habilitá-la, é preciso entrar em Configurações > Sobre o telefone > Informações do software e clicar sete vezes em Número de compilação, ao fazer isso, uma mensagem vai aparecer informando que agora você é desenvolvedor e o menu Opções de desenvolvedor estará habilitado. 
  - caso o computador não reconheça o dispositivo, verifique no site do fabricante se é necessária a instalação de algum driver; feito isso,siga os passos anteriores para executar o projeto!

--- 

[Voltar ao início!](https://github.com/monicaquintal/smart_cities)