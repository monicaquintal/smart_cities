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












--- 

[Voltar ao início!](https://github.com/monicaquintal/smart_cities)