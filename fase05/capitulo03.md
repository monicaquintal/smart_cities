<div align="center">
<a href="https://github.com/monicaquintal" target="_blank"><img align="right" height="120px" src="../assets/logo.png" /></a>
<h1>FASE 5 - Data Universe</h1>
<h2>Capítulo 03: Conhecendo o MongoDB.</h2>
</div>

<div align="center">
<h2>1. CONHECENDO O MONGODB</h2>
</div>

- MongoDB deriva da palavra inglesa humongous, traduzida como “gigantesco”. 
- é um banco orientado a documentos.
- não possui conceito de tabelas, esquemas, transações, joins e chaves estrangeiras.
- desenvolvido em C++, tem como filosofia facilitar o desenvolvimento de aplicações. 
- `é desprovido de esquema (schema free ou schemaless)` e `seus dados são armazenados no formato BSON (Binary JSON)`. 
- um único servidor MongoDB pode armazenar vários bancos sem perder performance graças a sua arquitetura de escala horizontal.

## 1.1 Características e funcionalidades

- é um produto de servidor de banco de dados de ***software livre***.
- usado para armazenamento orientado a documentos.
- melhorou o desempenho, porque torna o armazenamento de dados mais rápido e fácil usando esquemas de bancos de dados dinâmicos semelhantes ao JSON, em vez de sistemas de bancos de dados relacionais tradicionais de tabelas e SQL, sendo categorizado como ***servidor de banco de dados NoSQL***. 
- o esquema do banco de dados dinâmico usado no MongoDB é chamado de ***BSON***.
- nesse tipo de banco (`document-based` ou `document-oriented`), temos coleções de documentos, nas quais cada documento é autossuficiente, contém todos os dados que possa precisar, em vez do conceito de não repetição + chaves estrangeiras do modelo relacional.
- ***a ideia é que não tenhamos de fazer JOINs***, pois prejudicam a performance em suas queries: você modela a sua base de forma que a cada query vai uma vez ao banco e com apenas uma chave primária pega tudo o que precisa.
- o `escalonamento horizontal` com `Sharding` é muito bem implementado no MongoDB:
  - `Sharding` é utilizado quando temos muitos dados e estamos no limite do disco, e dessa forma, dividimos esses dados entre várias máquinas e temos mais rendimento e maior capacidade de armazenamento em disco. 
  - quanto mais Shards, maior será o armazenamento e o desempenho, e o MongoDB disponibiliza essa opção. 
  - para mais detalhes sobre Sharding, consultar a documentação oficial na [página oficial do MongoDB](https://www.mongodb.com/pt-br). 
  - banco de dados relacionais muito utilizados como o MySQL não suportam esse tipo de solução por padrão, para isso teríamos que manipular os dados em uma camada acima da base de dados, sendo muito mais trabalhoso.

## 1.2 Chave-valor e formato BSON

- dados desestruturados são um problema para a maioria dos bancos de dados relacionais, mas não tanto para o MongoDB. 
- quando o schema é variável/livre, usar MongoDB vem a calhar. 
- os documentos BSON (JSON binário) do Mongo são schemaless e aceitam quase qualquer coisa que você quiser armazenar, sendo um mecanismo de persistência perfeito para uso com tecnologias que trabalham com JSON nativamente, como ***JavaScript*** (e, consequentemente, ***Node.js***).
- `BSON Document`: 
  - cenários altamente recomendados e utilizados atualmente são os catálogos de produtos de e-commerces. 
  - telas de detalhes de produto em ecommerces são extremamente complicadas devido à diversidade de informações, aliadas a milhares de variações de características entre os produtos, que acabam resultando em dezenas de tabelas se aplicado sobre o modelo relacional. 
  - em MongoDB, essa problemática é tratada de uma maneira mais simples.
- além do formato de documentos utilizado pelo MongoDB ser ***perfeitamente intercambiável com o JSON serializado do JS***, MongoDB ***opera basicamente de maneira assíncrona em suas operações, assim como o próprio Node.js***, permitindo uma persistência veloz, aliado a uma plataforma de programação rápida.
- os bancos de dados orientados a documentos são uma das principais categorias de bancos de dados NoSQL. 
  - bancos de dados de gráficos são semelhantes, mas adicionam outra camada, o relacionamento, o que lhes permite vincular documentos para uma passagem rápida.
  - `bancos de dados orientados a documentos são inerentes aos bancos de dados chave-valor`: ***a diferença reside na forma como os dados são processados***; em um banco de dados chave-valor, os dados são considerados inerentemente para o banco de dados, enquanto um sistema orientado a documentos depende da estrutura interna no documento para extrair metadados que o mecanismo de banco de dados usa para otimização adicional.
- `bancos de dados de documentos armazenam todas as informações para um determinado objeto em uma única instância`, fazendo com que o mapeamento de objetos no banco de dados seja uma tarefa simples, eliminando o mapeamento objeto-relacional, tornando-os atraentes para aplicativos web, que estão sujeitos a mudanças contínuas, sendo a velocidade uma questão importante.

## 1.3 Vantagens e considerações

### a) `Simplicidade`:
  - o MongoDB, sendo um sistema de gerenciamento de banco de dados não sql, é muito mais simples, e as complexidades que vêm com bancos de dados relacionais são removidas no MongoDB. 
  - como JSON, o armazenamento orientado a documentos simplifica os sistemas de banco de dados.
  
### b) `Replicação e Confiabilidade de Dados`:
  - permite que os usuários repliquem dados em vários servidores espelhados, o que garante a confiabilidade dos dados. 
  - no caso de um servidor travar, seu espelho ainda estará disponível e o processamento do banco de dados permanecerá inalterado.
  
### c) `Consultas NoSQL`:
  - o MongoDB possui um mecanismo de consulta não sql que resulta em funcionalidades de armazenamento e recuperação de dados extremamente rápidas. 
  - consultas orientadas a documentos com base em JSON são extremamente rápidas em comparação com as consultas sql tradicionais.

### d) `Migrações Gratuitas de Esquema`:
  - no MongoDB, o esquema é definido pelo código. 
  - portanto, no caso de migrações de banco de dados, não ocorre nenhum problema de compatibilidade de esquema.

### e) `Escalabilidade Horizontal Eficiente`: 
  - como o MongoDB é um banco de dados não relacional, ele é mais adequado para os cenários em que a escalabilidade horizontal é importante.

### f) `Código aberto`:
  - o MongoDB é um servidor de banco de dados que é de código aberto e personalizável de acordo com os requisitos da organização.

### Considerações:
- o MongoDB é altamente recomendado em cenários em que o processamento rápido e a simplicidade são a chave. 
- devido ao seu mecanismo de consulta baseado no NoSQL, ele é robusto, escalável e altamente eficiente. 
- uma `desvantagem`: quando queremos alterar todos os registros relacionados a uma unidade semântica, nesse caso é preciso tratar um a um.
- muitas empresas de grande porte têm utilizado em projetos de complexidade média.

### Limitações:
- seu documento pode ter no máximo 16 Mb de tamanho.
- o nível máximo de profundidade de um documento é 100.

## 1.4 Visão geral da arquitetura

- a arquitetura do MongoDB Enterprise Server possui várias camadas e componentes.

<div align="center">
<img src="./images/cap03-arquitetura-mongodb.png" width="90%"><br>
<em>Arquitetura MongoDB.</em>
</div>

- as camadas centrais e mais importantes são: ***Ops Manager***, ***Compass*** e ***Connector for BI***.
  - `MongoDB Ops Manager`: é um módulo para realizar o gerenciamento do banco de dados com funcionalidades como monitoração e alertas, otimização de consultas, automação, configuração e backup e recovery.
  - `MongoDB Compass`: interface gráfica client para acessar o banco de dados, permitindo a visualização do schema de dados, a exploração dos dados armazenados e consultas ad-hoc. 
  - `MongoDB Connector for BI`: tem diversos dispositivos para conexão com as mais diferentes ferramentas de visualização analíticas do mercado, como Tableau, Microstrateg e Looker.
  - `camada do Enterprise Server`: tem recursos como engine para gravação em memória, auditoria, autenticação e criptografia. 

- os ***administradores*** podem usar o log de auditoria nativo do MongoDB para registrar todas as atividades e alterações realizadas no banco de dados.
- a ***autenticação*** é usada para simplificar o controle de acesso ao banco de dados, incluindo LDAP, Windows Active Directory, Kerberos, certificados x.509 e AWS IAM. 
- a ***criptografia dos dados*** está presente no MongoDB enquanto os dados estiverem circulando pela rede, no uso do banco de dados e nos dados armazenados, seja no disco ou em backups.

- uma ***camada à esquerda*** destaca `suporte 24x7` composta por plataforma para certificações, patches emergenciais, trocas de experiências entre clientes e treinamentos.
- uma ***camada à direita*** para `licenciamento comercial` com aspectos relacionados a indenizações, limitação de responsabilidades e garantias.

- o MongoDB é `altamente escalável` e `não possui um ponto único de falha`. 
- é `composto por um nó árbitro (heartbeat)`, `um nó primário (primary ou master)` e `muitos nós secudários (secondary ou slaves)`, ou seja, ***replicação master-slave***. 
  - os nós secundários são cópias do nó primário e usados para leituras ou backups.

- o MongoDB usa arquivos mapeados de memória para gerenciamento de arquivos, portanto, nesse componente, ele ***depende muito do lado do sistema operacional*** - vamos ver isso com base no sistema operacional Linux. 
- o MongoDB mapeia arquivos na memória usando a `chamada padrão mmap da glibc`.

### 1.4.1 Como funciona?

- no início, o MongoDB mapeia todos os seus arquivos de armazenamento de dados na memória. 
  - RAM não é usado de todo, esse processo só reserva o espaço de endereço, o que é refletido como uso de memória virtual pelo processo mongod.
- eles podem ser encontrados no topo (VIRT) ou no monitor MongoDB (Memory Virt). 
  - basicamente, eles refletem o tamanho dos dados + índices. 
  - o uso de memória Res / RSS não reflete nada de relevante.
- então, de certo modo, todos os dados e índices estão na memória, divididos por pequenas páginas de memória. O MongoDB possui ponteiros para cada página, mas eles ainda não estão na RAM.
- quando uma consulta real é feita, o MongoDB localiza a página que contém os dados necessários e lê esses dados a partir da memória em geral, e não importa se os dados estão na RAM ou não; como não pode saber disso, apenas envia o pedido para o endereço na memória, e o resto vai até o sistema operacional. Inicializa essas páginas na RAM no primeiro uso. 
  - essas páginas inicializadas são conhecidas como `páginas de cache`, seu tamanho total pode ser visto com o `comando 'free' (coluna 'cache')`. 
  - o problema é que o sistema operacional expira depois de algum tempo, o que é inevitável, não importa o quanto de RAM esteja disponível (sistema operacional baseado em recência de uso). 
  - existe um `processo kswapd` que é executado periodicamente e verifica se a página foi acessada desde a execução anterior. Se tiver, não faz nada. Se não, divide a idade por dois. Quando a idade chega a zero, essa página se torna candidata a despejo.
  - esse mecanismo, `arquivo mmap'ing`, é usado para todos os arquivos no sistema.
  - arquivos de log também são mapeados, portanto, quanto mais logs, mais RAM é usada pelas páginas de cache.
- há alguma dependência no uso de RAM: quanto maior o uso de RAM "ativa" (consulte `vmstat -s`), mais frequentemente o kswapd é executado e mais rápido é o processo de envelhecimento. 
- o MongoDB informa o tamanho real dos dados na RAM e a idade máxima desses dados; no caso do gerenciamento de memória, mongodb depende muito do lado do sistema operacional e isso poderia causar alguns efeitos negativos, como expiração do cache e eliminação de dados da RAM, apenas porque o sistema operacional acha que os dados já devem ter expirado.

### 1.4.2 Replicação e alta disponibilidade
- um conjunto de réplicas no MongoDB é um grupo de processos mongod que mantém o mesmo conjunto de dados. 
- `conjuntos de réplicas` fornecem redundância e alta disponibilidade e são a base para todas as implantações de produção. 

### 1.4.3 Redundância e disponibilidade de dados
- a `replicação` fornece redundância e aumenta a disponibilidade dos dados. 
  - com várias cópias de dados em diferentes servidores de banco de dados, a replicação fornece um nível de tolerância a falhas contra a perda de um único servidor de banco de dados.
  - em alguns casos, a replicação pode fornecer maior capacidade de leitura, pois os clientes podem enviar operações de leitura para servidores diferentes. 
- manter cópias de dados em diferentes data centers pode aumentar a localização e disponibilidade dos dados para aplicativos distribuídos. 
- você também pode manter cópias adicionais para fins dedicados, como recuperação de desastres, relatórios ou backup.

### 1.4.4 Replicação no MongoDB
- `Replica Sets` é um grupo de processos do mongod que mantém o mesmo conjunto de dados. 
  - os conjuntos de réplicas fornecem redundância e alta disponibilidade. 
  - quando o nó primário falha, o árbitro escolherá qual nó secundário será o novo primário. Quando o nó primário anterior retornar, o novo nó primário promove seu recovery. 
- Replica set define ***regras (rules) para escrita e para controlar onde os dados são escritos e lidos***; regras podem ser alteradas sem modificar a aplicação.

<div align="center">

Replica Set regra | Descrição
-------------------|------------------
primary | Always read from the primary (default)
primaryPreferred | Always read from the primary, read from secondary if primary is unavailable
secondary | Always read from a secondary
secondaryPreferred | Always read from a secondary, read from the primary if no secondary is available
nearest | Always read from the node with the lowest network latency

</div>

- um conjunto de réplicas é um grupo de instâncias mongod que mantém o mesmo conjunto de dados. 
- um conjunto de réplicas contém vários nós de suporte de dados e, opcionalmente, um nó de árbitro. 
- dos nós portadores de dados, um e apenas um membro é consideradoo nó primário, enquanto os outros nós são considerados secundários.

> O nó primário recebe todas as operações de gravação. Um conjunto de réplicas pode ter apenas um primário capaz de confirmar gravações com preocupação de gravação {w: "majoritária"}; embora, em algumas circunstâncias, outra instância mongod possa temporariamente acreditar que também é primária. O primário registra todas as alterações em seus conjuntos de dados em seu log de operação, ou seja, oplog.

### 1.4.5 Sharding
- o MongoDB tem uma funcionalidade de `autosharding`, que aumenta a escrita, permitindo scale-out. 
- o MongoDB executa automaticamente sharding e quando os nós contêm uma quantidade diferente de dados, redistribui automaticamente os dados, para que a carga seja igualmente distribuída pelos nós. 
- o mongod funciona como um roteador de consultas, uma interface entre a aplicação e o sharded cluster. 
- o config servers possui parâmetros de configuração para o cluster e os metadados e não é um replica set. 
- Replica Sets são para alta disponibilidade e leitura performática, não para escrita performática. 
- cada Partição/Sharding tem sua própria réplica.

> o MongoDB suporta a indexação de campos da mesma maneira que um banco de dados relacional; no entanto, não há junções entre coleções. Cada coleção pode ter até 64 índices. Ao criar uma coleção, um índice exclusivo é criado automaticamente para _id. 

- documentos do MongoDB são armazenados em uma forma binária de JSON chamada `formato BSON`, o qual ***suporta Boolean, float, string, número inteiro, data e tipos binários***. 
- devido à estrutura do documento, o MongoDB é um banco de dados schema less sendo assim fácil adicionar novos campos num documento ou alterar a estrutura existente de um modelo.

## 1.5 Modelo de dados

- em termos gerais, o MongoDB segue uma mesma estrutura quando se trata de macro-objetos, porém, para que haja performance, outros objetos são referência de sua arquitetura:

<div align="center">

SQL | MONGODB
------|----------
DATABASE | DATABASE
TABLE | COLLECTION
ROW | DOCUMENT
INDEX | INDEX
JOIN | EMBEDDED DOCUMENT
FOREIGN KEY | REFERENCE
COLLUMN | KEY

</div>

- dentro da modelagem relacional, o ponto-chave são a não redundância e os relacionamentos, já no MongoDB isso seria um empecilho: ***não há JOINs***!
- ***O MongoDB não pode substituir bancos de dados relacionais, mas deve ser visto como uma alternativa*** a ele:
  - MongoDB pode ser instalado no Windows, Linux e MAC, portanto, é um banco de dados de plataforma cruzada.
  - ele não suporta junções, mas pode representar estruturas de dados hierárquicas avançadas.
  - o melhor recurso é o mais fácil: é facilmente escalável e pode proporcionar alto desempenho.

- o banco de dados MongoDB consiste em um conjunto de bancos de dados no qual cada banco de dados contém várias coleções. 
  - o MongoDB é sem esquema, o que significa que cada coleção pode conter diferentes tipos de objetos. 
  - todo objeto também é chamado de documento, que é representado como uma estrutura JSON (JavaScript Object Notation): uma lista de pares de valores-chave. 
  - o valor pode ser de três tipos: um valor primitivo, uma matriz de documentos ou novamente uma lista de pares de valores-chave.

## 1.6 Setup local

- para estudarmos o MongoDB, teremos algumas alternativas de como utilizá-lo, sendo a mais comum a instalação local do banco. 
- um banco de escala horizontal tende a ser complexo para configurar manualmente, pois existe a necessidade de construir um cluster (conjunto de computadores conectados) com diferentes máquinas (físicas ou virtuais) para que o processamento e armazenamento paralelo de dados possa ser distribuído entre os nós (cada computador de um cluster).
- essa abordagem é muito útil para ambientes escaláveis e produtivos, mas para nosso ambiente de desenvolvimento, não precisaremos desse tipo de configuração, pois podemos instalar a `versão Standalone` (nó único) na nossa máquina, possibilitando uma configuração simples e que não limitará os estudos.
- a diferença principal será a falta de replicabilidade e a alta disponibilidade, mas como nosso ambiente é local e para fins acadêmicos, isso não será um problema.
- a instalação local requer uma série de etapas que foram documentadas pelo próprio time do MongoDB e disponibilizados em português [no site]( https://www.mongodb.com/pt-br/docs/manual/administration/install-community/).

### 1.6.1 MongoDB no Windows
- para quem prefere uma instalação utilizando gerenciadores de pacotes, o Windows conta com o Chocolatey. 
- para instalar a ferramenta e conhecer mais sobre suas possibilidades, [visite o site](https://chocolatey.org/install).
- para instalar o MongoDB através do Chocolatey, abra o PowerShell como administrador e rode o seguinte comando: $ choco install mongodb.

## 1.7 MongoDB Atlas

- alguns softwares não precisam estar instalados para que possamos estudá-los. 
- o MongoDB é um banco Open Source mantido ativamente pela empresa Atlas, cujo produto é uma versão em nuvem deste poderoso banco de dados.
- o MongoDB Atlas é o serviço autogerenciado que abstrai para os usuários a complexidade de configuração do banco, seja para uma versão Standalone ou em um gigantesco cluster para ambientes produtivos. 
- esse serviço é pago, porém a Atlas oferece uma versão gratuita onde podemos utilizar uma instancia de MongoDB diretamente na nuvem, usufruindo da flexibilidade de um serviço online, a simplicidade de não precisar instalar o software localmente, e a robustez de um produto atualizado constantemente pelos maiores contribuidores do projeto.

### 1.7.1 Configurando uma instância do MongoDB Atlas
- criar uma conta gratuita no Atlas. 
- acessar o [site](https://www.mongodb.com/cloud/atlas/register) e se registrar com um endereço de e-mail da FIAP ou pessoal.
- escolha o `tier M0`, que é gratuito, em qualquer uma das provedoras de nuvem e aguarde o cluster ser inicializado.
  - na própria interface do Atlas, poderemos utilizar os recursos já disponíveis, carregar dados, consultar, criar visualizações etc.
- o que nos interessa aqui é viabilizar a conexão deste banco através de outras ferramentas; portanto, criar um novo usuário de banco de dados para o nosso cluster (que será utilizado fora do ambiente Atlas) e abrir os endereços de IP para qualquer lugar, assim não teremos problemas em acessar o serviço de diferentes dispositivos.
- para ***criar um novo usuário***: Database Access > Add new database user. Adicione um usuário e senha e selecione a role desse novo usuário como Atlas Admin. Depois clique no botão Add User para concluir.
- por fim, vá para a aba Network Access e ***adicione a regra de IP para o endereço 0.0.0.0/0, que significa toda a internet***. 
  - essa não é uma prática segura do ponto de vista profissional, mas para o ambiente de estudos isso facilitará para não ficarmos bloqueados por questões de configuração de rede no futuro.
- pronto, agora podemos começar a acessar nosso banco através da ferramenta de nossa escolha. 
  - ***para verificar as possibilidade e strings de conexão***: Database > Connect. Aqui o Atlas vai fornecer algumas formas de se conectar ao nosso novo cluster, sendo que o MongoDB Atlas é a mais comum por ser a ferramenta mantida pelo próprio MongoDB.

<div align="center">
<h2>2. AMBIENTE DE DESENVOLVIMENTO</h2>
</div>

## 2.1 MongoDB Compass

- é a ferramenta mais utilizada para acessar bancos MongoDB, seja no ambiente Atlas ou não.
- para instalar o compass, acessar o site oficial e baixar o executável para a plataforma que estiver utilizando.
- também temos a opção de instalar através dos gerenciadores de pacote Chocolatey e Home Brew, de preferência para estas instalações sempre que possível pois são mais fáceis de gerenciar versões e desinstalar softwares sem deixar traços na máquina.
- se estiver utilizando o MongoDB instalado localmente, a sua string de conexão será, provavelmente, o local host: mongodb://localhost:27017.
- `para se conectar em um cluster Atlas`: na lista de opções que vimos no tópico anterior, clique em Compass e veja a string de conexão que precisará ser editada com suas credenciais de usuário.
  - edite a string de conexão adicionando o usuário e senha criados anteriormente, como no exemplo: ***mongodb+srv://lbrandi:senha123@cluster0.b0ysxkl.mongodb.net/***.
  - cole a string de conexão no Compass e clique em connect.

## 2.2 Mongosh

- é a CLI do MongoDB.
- é a forma mais básica de acessarmos o banco, e normalmente é como configuramos servidores e desenvolvemos automações para ambientes produtivos, pois não temos nenhuma assistência visual, apenas a linha de comando.
- podemos instalar o Mongosh diretamente no terminal, mas ao instalar o MongoDB compass, o Mongosh vem instalando automaticamente e podemos utilizar os recursos de linha de comando diretamente por lá, o que evitaria uma instalação adicional e traz mais comodidade para os estudos.

## 2.3 VS Code

- outra alternativa que agrada desenvolvedores que buscam centralizar seu ambiente de trabalho em poucos softwares, é a instalação da extensão do MongoDB no VS Code.
- as strings de conexão são as mesmas utilizadas anteriormente.
- o principal diferencial da extensão é que o mongosh não vem instalado, então para utilizar dos recursos de linha de comando precisamos fazer a instalação manual da ferramenta para uma experiência mais completa.

## 2.4 DataGrip

- agora entramos nas opções de cliente de banco de dados. 
- assim como já utilizamos o Oracle SQL Developer para acessar nossos bancos de dados Oracle, podemos acessar o Mongo através de uma interface mais parecida com o que já estamos acostumados, com a vantagem de que algumas dessas ferramentas oferecem suporte a SQL tradicional em algumas consultas.
- o DataGrip é a ferramenta paga mais completa em relação a conexões com bancos de dados, e com um e-mail de estudante é possível utilizar a ferramenta por 1 ano gratuitamente, podendo ser renovada enquanto estiver com um e-mail estudantil ativo. 
- para realizar a instalação é possível utilizar os gerenciadores de pacote Chocolatey e Home Brew ou através do site oficial da JetBrains.

## 2.5 NoSQLBooster

- é a alternativa gratuita ao DataGrip, pois oferece um serviço muito interessante especificamente para MongoDB, podendo converter SQL puro em consultas ao MongoDB. 
- a limitação dessa ferramenta é que ela não seria utilizada para outros bancos apesar de ter uma maior integração e algumas funcionalidades que não estão presentes nativamente no DataGrip.
- para instalar e testar, podemos utilizar os gerenciadores de pacotes, ou baixar pelo site oficial da ferramenta a versão correta para nossa plataforma.

---

## FAST TEST

### 1. No MongoDB, conjuntos de documentos são chamados de:
> Coleções.

### 2. Analise a frase a seguir: "_____________ é utilizado quando temos muitos dados e estamos no limite do disco, e dessa forma, dividimos esses dados entre várias máquinas e temos mais rendimento e maior capacidade de armazenamento em disco". Em seguida, assinale a alternativa que complete a frase:
> Sharding.

### 3. O MongoDB apresenta um bom desempenho pois torna o armazenamento de dados mais rápido e fácil utilizando esquemas de bancos de dados dinâmicos, em vez de sistemas de bancos de dados relacionais tradicionais de tabelas e SQL. O esquema do banco de dados dinâmico utilizado no MongoDB é chamado de:
> BSON. 

--- 

[Voltar ao início!](https://github.com/monicaquintal/smart_cities)