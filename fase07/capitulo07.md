<div align="center">
<a href="https://github.com/monicaquintal" target="_blank"><img align="right" height="120px" src="../assets/logo.png" /></a>
<h1>FASE 7 - Emerging Technologies</h1>
<h2>Capítulo 07: Tá, mas isso é seguro?</h2>
</div>

<div align="center">
<h2>1. TÁ, MAS ISSO É SEGURO?</h2>
</div>

- segundo um estudo, as plataformas IoT como soluções de software devem ser capazes de gerenciar tecnicamente os dados. Além disso, é fundamental saber definir qual plataforma é a mais adequada para cada negócio, visto que todas as empresas vão precisar de plataformas que garantam flexibilidade e escalabilidade, ou seja, a expansão de seus desenvolvimentos na área. Assim, o estudo aponta ***três funcionalidades essenciais a uma boa plataforma IoT***:
  - `suporte a aplicações`: para a customização de soluções IoT.
  - `consolidação de dados e armazenamento`: para capturar e armazenar dados e gerar insights, como Banco de Dados, ferramentas de Big Data Analytics e Machine Learning.
  - `gerenciamento de conectividade`: para conectar automaticamente sistemas, redes e equipamentos.

> Outro elemento crucial para a escalabilidade das plataformas IoT envolve a integração entre os elementos do ecossistema: alcançar a integração completa para ativos conectados à IoT é provavelmente mais desafiador do que se pensa, porque envolve muitos terminais diferentes da TI. É crucial qualificar as expectativas em torno de uma implementação e assegurar que ela entregará os benefícios esperados.

- e de um lado existem múltiplas soluções corporativas, do outro, os líderes corporativos, frequentemente referenciados como “C level” (CEO, CTO, CMO), devem possuir competências e habilidades que acompanhem de forma equilibrada essas novas necessidades. 
- para atender a essas demandas, os líderes de TI corporativos devem:
  - projetar e desenvolver plataformas que sejam extensíveis e abertas para uso de serviços IoT.
  - adotar modelos de precificação que garantam rápido retorno a partir de uma plataforma padronizada.
  - fomentar o desenvolvimento de novos serviços, como bibliotecas analíticas, monetização de dados, ferramentas de governança e segurança avançada, que fortaleçam sua plataforma.

## 1.1 Indicadores para a melhor escolha 

- como a oferta de aplicações e plataformas é bem vasta, se não houver alguns indicadores, o processo de escolha se torna totalmente aleatório e sua incorporação não conseguirá atender as demandas e necessidades da empresa.
- alguns indicadores essenciais para facilitar o processo de aquisição:
  - `Compatibilidade`: a plataforma deve integrar-se facilmente ao seu sistema de back-end. Além da interoperabilidade entre dispositivos, deve haver uma forte comunicação entre aparelhos e sistemas externos. Ele também deve permitir que você use APIs ou Interfaces de Programa de Aplicativos para interagir e compartilhar dados com outras empresas.
  - `Largura de banda`: em casos normais, existe uma capacidade de terminação e conectividade da plataforma de nuvem para dispositivos que possuam conectividade de largura de banda limitada, provavelmente causada por limitação de infraestrutura. Isso pode acontecer porque as plataformas de IoT são executadas em plataformas de nuvem pública, como o Google Cloud, Microsoft Azure, IBM Bluemix, Oracle Cloud, o AWS,entre outras. A baixa latência e alta largura de banda são necessárias para a movimentação eficiente dos pacotes de dados, informações e comunicações entre os dispositivos conectados.
  - `Parcerias`: ao selecionar uma plataforma, o ecossistema de parceiros da nuvem é uma consideração valiosa. A escolha pode depender tanto do valor oferecido pelo parceiro (experiência de domínio, experiência em nuvem, visão estratégica etc.) quanto do escopo da sua oferta (soluçõesde software e hardware).
  - `Ferramentas analíticas e preditivas`: a razão pela qual temos dispositivos conectados é que estes podem coletar dados grandes em torno de produtos, empresas, clientes e fluxos de trabalho e usar esses dados para tomar decisões de negócios ou novos lançamentos. Converter dados em insights acionáveis é crucial por causa da monstruosidade dos dados que estão chegando. À medida que os dados chegam continuamente de todos os sensores e dispositivos conectados, uma enorme quantidade de dados permanece inexplorada, subutilizada.
  - `Customização`: o fornecedor da plataforma deve proporcionar a liberdade de personalização de acordo com suas necessidades. Na maioria dos casos, existem ferramentas low code (arrastar e soltar)para construção rápida de cenários de IoT para validação, e é altamente recomendável escolher um fornecedor que tenha fluxos de trabalho consistentes.
  - `Segurança`: é a principal preocupação ao escolher uma plataforma e cada componente deve ter suas próprias opções de segurança. Secure Socket Layer ou SSL, o gatekeeper confiável é aquele usado pelas empresas, incluindo os bancos, para segurança máxima no nível de acesso à nuvem.

## 1.2 Exemplos de soluções corporativas

- em um mundo extremamente dinâmico, as soluções dentro do ecossistema de IoT surgem a todo momento.
- em um período curto é possível que novas soluções entrem no mercado, fazendo com que as atuais se tornem obsoletas.

### 1.2.1 Dojot
- a plataforma Dojot surgiu com o objetivo de desenvolver e demonstrar tecnologias para as cidades inteligentes (smart cities), tendo como pilares de sustentação: ***segurança pública***, ***mobilidade urbana*** e ***saúde***. 
- por ser uma plataforma genuinamente brasileira, foi concebida com uma proposta open source, para facilitar o desenvolvimento de soluções e o ecossistema IoT, com a prerrogativa de atender as características regionais, tendo como principais características:
  - APIs abertas, permitindo o acesso fácil das aplicações aos recursos da plataforma.
  - Armazenamento versátil, suporta grandes volumes de dados em diferentes formatos.
  - Conexão e coleta de dados de dispositivos.
  - Fluxos visuais permitem rápida prototipação e validação de cenários de aplicações IoT.
  - Processamento em tempo real, aplicando regras definidas pelo desenvolvedor conforme os eventos ocorrem.
- por se tratar de uma solução completa, na visão da empresa, é preciso ter em mãos os dispositivos inteligentes (conectados na rede), e que para o Dojot é uma representação digital para um dispositivo real ou gateway com um ou mais sensores ou uma representação para um dispositivo virtual com sensores/atributos inferidos de outros dispositivos.
  - o painel de controle da plataforma é web.
  - a interface de gerenciamento permite que seja utilizado o Node-Red como camada intermediária e todos os fluxos sejam também construídos por ela.
  - com um fluxo, é possível analisar dinamicamente cada nova mensagem para aplicar validações, inferir informações e acionar ações ou notificações, de uma forma simples e intuitiva.
  - um item a ser considerado é a utilização de elementos do Node-Red para a criação simples de um dashboard, que proporciona a visualização de dados de um modo visual e em tempo real.
  - para o desenvolvimento de aplicações mais sofisticadas, existe a possibilidade de seguir a linha de raciocínio de utilizar na camada de front-end o Node-js, completando todo o ciclo relativo à solução customizada propriamente dita.
- passo a passo para integrar uma “aplicação legada” com a plataforma Dojot:
  - ***Recuperando dados históricos***: caso seja necessário, periodicamente, ler todos os dados históricos relacionados a um dispositivo, isso deve ser feito por meio da API fornecida.
  - ***Assinando eventos relacionados a dispositivos***: se seu aplicativo puder “escutar” eventos, ele precisará assinar os tópicos via MQTT, isso também pode ser feito por meio de uma API.
  - ***Usando mashup*** (aplicação web que usa conteúdo de mais de uma fonte para criar um novo serviço completo) a fim de pré-processar dados: se você quiser fazer algo mais, pode usar fluxos que ajudem a processar e transformar dados para que possam ser enviados adequadamente para a aplicação legada por solicitação HTTP, por e-mail ou armazenados em um dispositivo virtual (que pode ser usado para gerar notificações).

> SAIBA MAIS: Para conhecermais detalhes, acesse [este link](https://github.com/dojot).

### 1.2.2 HPE Universal IoT Platform
- com a Universal IoT Platform, a Hewlett Packard Enterprise (HPE) permite as empresas adquirirem uma solução vertical e independente, com escalabilidade, modularidade e versatilidade, o que possibilita aos clientes gerenciarem suas soluções de IoT e fornecerem valor por meio da monetização da grande quantidade de dados gerados por dispositivos conectados e disponibilizá-los aos aplicativos legados. 
- além da conectividade onipresente, a HPE Universal IoT Platform fornece toda a base para o gerenciamento de dispositivos e serviços, aquisição de dados e exposição a aplicativos. 
- a plataforma também fornece suporte para ecossistemas inteligentes e pode ser implantada nas instalações locais, bem como em qualquer ambiente de nuvem, para um modelo genérico como serviço.
- permite a descoberta, configuração e gerenciamento de software e facilita pontos de controle em dados, para que seja possível gerenciar remotamente milhões de dispositivos IoT e aplicações inteligentes na mesma plataforma. 
- além disso, não depende de fornecedor de dispositivo nem de conectividade. A solução opera a um baixo TCO com alta escalabilidade e flexibilidade ao combinar o modelo de dados integrado com padrões M2M (Machine to Machine). 
- também apresenta segurança incorporada diretamente na base, permitindo proteção de ponta a ponta ao longo do ciclo de vida dos dados.
- em termos de escalabilidade, é fundamentalmente projetada para suportar milhões de conexões com dispositivos heterogêneos e modular ao ponto de ser implantada como tal, em que somente os módulos principais necessários podem ser adquiridos como licenças ou como serviço, com uma opção para adicionar módulos avançados, conforme necessário.
- como um bom exemplo de parcerias estratégicas, a HPE estabeleceu uma parceria com a Tata Communications para converter a “Cidade do Aço” de Jamshedpur em Jharkhand, na Índia, em uma cidade inteligente, e também firmou uma parceria com a PwC (parceira de aliança estratégica global de longa data) a fim de oferecer a plataforma para suportar iniciativas de desenvolvimento, teste e gerenciamento de aplicativos IoT no Smart Cities Experience Centerda PwC.

> SAIBA MAIS: Para conhecermais detalhes, acesse [este link](https://www.hpe.com/us/en/solutions/internet-of-things.html).

### 1.2.3 Siemens MindSphere
- o MindSphere (sistema operacional aberto), baseado na nuvem e criado pela empresa Siemens, conecta as coisas reais ao mundo digital e permite alto valor baseado na indústria de aplicações e serviços digitais para impulsionar os negócios. 
- como a plataforma é aberta (Platform as a Service, ou PaaS), permite um ecossistema de parceiros, incluindo parceiros de soluções, desenvolvedores de aplicativos e conectividade, além de parceiros para oferecer soluções inovadoras de IoT.
- a Siemens, responsável pela criação da plataforma, está trabalhando lado a lado com aproximadamente 20 empresas parceiras, tendo como objetivo fundar a MindSphere World, uma organização mundial dos seus respectivos usuários. 
  - tal organização foi projetada para oferecer suporte a seus membros individuais no desenvolvimento e aprimoramento de soluções de IoT na plataforma e na exploração de novos mercados na economia digital, o que incluirá sugestões sobre os requisitos colocados no sistema operacional e recomendações a respeito da definição de regras uniformes para a utilização de dados. 
  - outro papel da organização será o de promover a ciência, a pesquisa e o ensino no ambiente do próprio MindSphere.
- um dos pontos importantes para se destacar da plataforma, que é uma solução industrial de IoT como serviço, está na flexibilidade de interoperar de forma segura serviços e aplicativos. O MindSphere consiste em três camadas distintas:
  - O MindSphere Application System, que fornece uma solução gerenciada como serviço para hospedar seus aplicativos diretamente no MindSphere.
  - Os Serviços MindSphere, que permitem que você use nossos serviços por meio de APIs públicas em suas próprias soluções.
  - Os elementos MindConnect, que fornecem hardware plug and play e componentes de software personalizáveis para colocar seus dados no MindSphere.
- com a integração perfeita de dados operacionais em toda a cadeia de valor, as empresas não só impulsionam a transparência operacional, mas também comparam resultados de simulação e teste com observações do mundo real para ganhar vantagem competitiva.
- a digitalização e a transformação dos dados da IoT em resultados de negócios produtivos são os principais impulsionadores do MindSphere. Além disso, as empresas podem aproveitar a plataforma para fechar o ciclo por meio da ideação, realização e utilização de produtos para integrar dados operacionais em toda a cadeia de valor, não apenas impulsionando a eficiência operacional, mas também comparando resultados de simulação e testes com observações do mundo real.
- como parte de uma estratégia completa de digitalização, permite novas maneiras de resolver problemas e que as empresas considerem novos modelos de negócios inovadores. É possível desenvolver, implantar e executar imediatamente serviços digitais, criar os próprios aplicativos ou até mesmo novos modelos de negócios.
- a segurança é uma das prioridades da Siemens, uma das principais empresas fornecedoras de automação do mundo, com aproximadamente 30 milhões de sistemas automatizados, 75 milhões de contadores inteligentes contratados e um milhão de produtos conectados no campo.
- o quadro de segurança da plataforma está alinhado aos princípios padrões da indústria (IEC 62443, ISO / IEC 27001) e às recomendações governamentais para manipulação de dados em ambientes de nuvem.

> SAIBA MAIS: Para conhecer mais detalhes, acesse [este link](https://plm.sw.siemens.com/en-US/insights-hub/).

### 1.2.4 Amazon AWS IoT
- é uma plataforma de nuvem que permite conectar e gerenciar dispositivos variados, possibilitando a criação de aplicações IoT para coletar, analisar e gerenciar dados, bem como enviar comandos para os dispositivos da nuvem. 
- criada em 2006 com o objetivo de oferecer serviços de infraestrutura de TI para empresas por meio de nuvem na web, reduzindo custos de aquisição de servidores e agilizando a rodagem de dados e resultados. 
- os data centers estão localizados nos EUA, Europa, Brasil, Singapura, Japão e Austrália.
- características que indicam vantagens competitivas e merecem destaque:
  - Permite conectar e gerenciar dispositivos utilizando protocolos que servem facilmente para tolerar diversas conexões prolongadas, diminuir códigos nos dispositivos e otimizar recursos de banda larga.
  - Disponibiliza autenticação e criptografia nos diferentes pontos de conexão, mantendo em segurança todas as pontas de acesso. Ainda é possível customizar as permissões por níveis de acesso.
  - É possível filtrar e intervir sobre os dados de acordo com as regras de negócio definidas previamente.
  - Também armazena o estado mais recente do dispositivo, mesmo que ele não esteja on-line. Dessa forma, o aplicativo pode ler o dispositivo mesmo se não estiver conectado à rede.
- alguns clientes que fazem uso de produtos da AWS:
  - ***Bigfinite***: empresa que fornece soluções para a indústria farmacêutica e de biotecnologia que abrange toda a cadeia de produção, desde a pesquisa e o desenvolvimento até a distribuição de medicamentos. Utilizou a AWS para construir uma plataforma chamada Bengegine, que analisa diferentes fontes de dados e gera insights para melhorar a produtividade de produtos em conformidade.
  - ***Amway***: líder mundial em vendas diretas de produtos nutricionais, de beleza e para a casa, começou a investir em IoT quando decidiu incluir dispositivos de Bluetooth e Wi-Fi em um sistema de tratamento de ar. A escolha pela AWS foi pela abrangência global,que permite à empresa implementar o produto em vários locais pelo mundo.
  - ***Chai Point***: maior varejista de chai na Índia.

### 1.2.5 Samsung ARTIK
- a empresa Samsung possui uma visão estratégica muito apropriada e direcionada ao ecossistema de IoT: "Na Samsung, acreditamos que a Internet das Coisas deve ser fácil como apertar um botão. Com os novos produtos e serviços anunciados, estamos tornando a IoT mais fácil, mais transparente. Estamos comprometidos em acelerar a adoção da IoT por todos e levar inteligência a todos os dispositivos Samsung conectados até 2020. Esses avanços vão ajudar os consumidores a perceber os benefícios de uma vida conectada simples e integrada."
- a plataforma ARTIK Smart IoT da Samsung foi projetada desde o início para lidar com evoluções cada vez mais aceleradas em conectividade do dispositivo. 
  - os módulos são sistemas integrados concebidos para a Internet das Coisas. 
  - eles são projetados para fornecer rapidamente uma gama completa de aplicativos IoT com a capacidade de integração com o Artik Cloud ou qualquer outro serviço de nuvem. 
  - os módulos Artik também podem ser dimensionados do desenvolvimento para a produção com facilidade. 
  - os modelos de lançamento atuais variam desde a placa Artik 1, uma placa de sensor IoT de baixa potência, até os módulos Artik 520, Artik 710 e Artik 1020, que possuem mais capacidade e capacidade de processamento.
- embora apresente muitos atributos, o Samsung ARTIK tem ***três principais diferenciais***:
  - `Capacidades avançadas de segurança`: tanto dispositivos quanto aplicativos de terceiros podem ser conectados à nuvem usando protocolos seguros. A maioria dos módulos adiciona segurança baseada em hardware para armazenar certificados e chaves, que compartilham uma raiz de confiança com a nuvem e favorecem a proteção dos dispositivos e dados contra picos de tráfego inesperados ou não autorizados, além das interações de dispositivos, aplicativos e usuários com os padrões abertos baseados na Internet, autenticação e autorização. 
  - `Interoperabilidade de dispositivos e dados`: ARTIK Cloud, uma plataforma de troca de dados aberta, é o caminho mais rápido para conectar dispositivos em silos e ativar novos serviços e aplicativos, fornecendo um modo fácil de usar APIs, SDKs e ferramentas para coletar, armazenar e agir com segurança em qualquer dado de qualquer dispositivo conectado ou serviço na nuvem. Usando APIs e ferramentas de nível empresarial, as empresas podem gerenciar facilmente sua frota de implementos dispositivos, levam rapidamente a novas soluções e serviços de IoT para o mercado e, naturalmente, motivando a expansão dos seus negócios.
  - `Time-to-Market e simplicidade`: fornecer a unificação eficiente de hardware, software, nuvem, segurança e parceria em uma única oferta integrada significa que o tempo médio de implementação para ARTIK projetos é de 6 a 9 meses, o que é até quatro vezes mais rápido do que a média da indústria (24 meses). Não só economiza tempo considerável na implementação, como também é mais rentável, uma vez que o tamanho das equipes necessárias para integrar os produtos ARTIK é muito menor em comparação com a maioria dos concorrentes.
- é interessante observar que, em muitas plataformas, o padrão relacionado com a parte de cloud está diretamente associada com o uso de fluxos em Node-RED, como é o caso da ARTIK. 

<div align="center">
<h2>2. SEGURANÇA DE APLICAÇÕES DISTRIBUÍDAS</h2>
</div>

- a Internet das Coisas (IoT) visa melhorar a vida das pessoas e aumentar a interconectividade de uma maior variedade de dispositivos inteligentes incorporados usando os componentes de infraestrutura da Internet existente. Isso permite comunicações entre sensores em eletrodomésticos, telefones, carros, notebooks, maquinários de fábrica e muitos outros dispositivos têm acesso à rede por meio de protocolos como 3G, Wi-Fi, Bluetooth e ZigBee.
- é importante entender os riscos de segurança e as ações do usuário (consumidor) com relação a IoT, a fim de torná-la compatível em aplicações do mundo real.
- existem diversas técnicas que podem ser aplicadas para adicionar segurança em IoT, algumas delas estão relacionadas a camada de troca de mensagens entre dispositivos, geralmente utilizamos o `sistema de mensagens MQTT` (Message Queuing Telemetry Transport) de código aberto usado para comunicação entre dispositivos na Internet das Coisas (IoT). Dessa forma a autenticação é um aspecto importante para garantir que apenas dispositivos autorizados possam se conectar e trocar mensagens.
- para configurar a autenticação dos dispositivos os Brokers MQTT disponibilizam diferentes métodos, dependendo dos requisitos de segurança. Alguns métodos comuns incluem:
  - ***Nome de Usuário e Senha*** (Username/Password).
  - ***Certificados TLS/SSL***: especialmente importante quando a segurança é uma prioridade, pois apenas dispositivos com certificados válidos podem se conectar.
  - ***Tokens de Autenticação***: são chaves geradas que os dispositivos precisam apresentar para se conectar.
  - ***Integração com Sistemas de Autenticação Externos***: como LDAP, OAuth ou SAML, para gerenciar a autenticação de dispositivos.
- a escolha do método de autenticação depende das necessidades específicas do seu projeto e dos níveis de segurança exigido.

## 2.1 Por que se preocupar com segurança?

- os problemas de segurança e privacidade no ecossistema da IoT não aumentam linearmente com o número de conexões de dispositivos, porém cresce em um ritmo muito mais rápido. 
  - isso se deve ao fato de que, mesmo assumindo que tudo é igual, o número de canais de comunicação em uma rede aumenta mais rápido que o número de nós (um ponto de conexão, seja um ponto de redistribuição ou um terminal de comunicação).
- espera-se que a IoT seja bem mais heterogênea do que as atuais redes de computadores, integrando uma grande variedade de dispositivos de diferentes fabricantes, plataformas de software e comunicação de protocolos. 
  - na arquitetura atual de redes, enquanto servidores e estações de trabalho são protegidos em data centers e escritórios, computadores pessoais, notebooks e dispositivos portáteis são protegidos pela presença do proprietário, em uma configuração de IoT, sensores e outros dispositivos estão localizados em todos os lugares e expostos a roubo e danos maliciosos. 
- outro ponto a ser considerado como vulnerável é que os dispositivos IoT geralmente são sistemas acionados por bateria, propensos a falhas e há menor poder de processamento e memória, o que dificulta o cumprimento dos requisitos para a implementação de segurança apropriada, pois estes exigem uma quantidade considerável de recursos de processamento e memória. 
- à medida que o número de coisas conectadas aumenta em diferentes bases de dados, crescem os riscos continuamente. Embora tais dados confidenciais possam ser removidos ou protegidos anonimamente, quando os dados são divulgados, uma combinação imprevisível de dados aparentemente não sensíveis e de diferentes fontes pode criar um identificador único que resulta em violações de privacidade. 
- a IoTimpulsionou os riscos de segurança para um nível superior; atuadores e sistemas de controle serão interligados com outros sistemas, atacantes podem ser capazes de direcionar diretamente os dispositivos conectados e promover a destruição física dos equipamentos e das infraestruturas, tais como automóveis autônomos, casas inteligentes, redes elétricas, campos petrolíferos, sistemas de transporte e plantas. 
- a IoT, inerentemente, tem uma característica dinâmica e dispositivos difusos como wearables, que podem entrar e sair da rede IoT a qualquer momento, o que torna as medidas tradicionais de segurança da informação insuficientes para a IoT.
- outro fator que precisa ser observado em projetos IoT é a coleta dos dados sobre os usuários e seu ambiente em diversos dispositivos para fornecer algum tipo de serviço. Torná-los anônimos, ou seja, a substituição de informações pessoais por IDs gerados exclusivamente, não é suficiente para garantir o anonimato dos usuários e tem sido demonstrado que a identidade dos usuários pode ser inferida a partir dos conjuntos de dados anônimos.

## 2.2 Desafios, ameaças e restrições de segurança

- é muito importante garantir que haja disponibilidade contínua dos dispositivos baseados em IoT para que sejam evitadas possíveis falhas nas operações e interrupções nos serviços corporativos.
- até mesmo para tarefas simples, como adição de novos pontos de extremidade à rede ou novos dispositivos, a empresa deve considerar alguns dos ataques que podem ser realizados em tais dispositivos. 
- a empresa deve apresentar medidas para garantir que existe inicialmente segurança física para impedir qualquer acesso não autorizado aos dispositivos que estão localizados dentro do perímetro de segurança.
- Os `ataques cibernéticos disruptivos`, como os de ***negação de serviço (DDOS)***, podem ter consequências terríveis para a empresa, pois se milhares de dispositivos IoT tentarem acessar um determinado site cujos dados não estão mais presentes, os clientes podem ficar frustrados e, consequentemente, levar à sua perda, além de uma aceitação ruim do mercado, culminando com a perdade receita.
  - Mirai: um worm autopropagado, ou seja, um programa mal-intencionado que se replica ao localizar, atacar e infectar dispositivos de IoT vulneráveis; também é considerado um botnet porque os dispositivos infectados são controlados por meio de um conjunto central de servidores de comando e controle (C&C). 
- no mundo real, as empresas geralmente enfrentam desafios quando tentam descobrir como devem corrigir rapidamente as vulnerabilidades do dispositivo IoTe como deve ser priorizada a ordem de resolução.
  - na maioria desses dispositivos IoT, é necessária atualização de firmware para que as vulnerabilidades sejam corrigidas e realizar isso em tempo real pode ser bastantedesafiador. 
  - um ponto de vulnerabilidade bastante explorado está relacionado com as credenciais padrão que são fornecidas quando os dispositivos IoT são usados pela primeira vez. A recomendação é a de que logo após a aquisição, seja feita a alteração dos usuários e senhas.
  - se o ponto de vulnerabilidade estiver relacionado com a comunicação entre dispositivos, a resposta está associada a algoritmos de criptografia, particularmente aqueles envolvidos com o conceito de chave pública e privada. Com o uso dos esquemas existentes de criptografia de chave pública, é possível verificar a integridade e a autenticidade do conteúdo digital. 
    - ***Integridade*** é uma indicação de que o conteúdo digital não foi modificado desde a época de sua criação. 
    - ***Autenticidade*** significa que o conteúdo digital foi liberado para a pessoa correta. 
    - essas duas características são fornecidas pela assinatura digital e é necessário para que os dispositivos eletrônicos confiem no conteúdo digital.
    - “message digest” é um mecanismo bastante usado para garantir a integridade do conteúdo digital, construído por meio de um algoritmo hash seguro.
    - o esquema de **assinatura digital de chave pública** é usado com a finalidade de garantir a autenticidade do conteúdo digital. No caso,é usado um par de chaves, uma chave privada que é secretamente armazenada e utilizada para assinar o conteúdo e uma chave pública que qualquer um pode acessar.
  
## 2.3 Utilização de APIs

- as APIs (Application Programming Interfaces, ou Interfaces de Programação de Aplicativos) estão fortemente ligadas à IoT, pois permitem a exposição com segurança dos dispositivos conectados a clientes, canais de entrada no mercado e outros aplicativos na infraestrutura de TI local. 
- é essencial implantar o `gerenciamento de APIs`, por ser flexível, escalável e, acima de tudo, seguro; é um grande arcabouço tecnológico sobre o qual estão agrupados uma coleção de soluções como gateways, segurança e gerenciamento de acessos, cada uma com o seu próprio cenário de potencial desastre caso as coisas não saiam conforme planejado.
- acredita-se que as APIs serão a principal maneira de permitir interações entre objetos que foram conectados à Internet, e parte do que torna a IoT tão importante é a habilidade de conectar aplicações a dispositivos, sejam individuais ou agregados.
- exemplos de APIs na categoria Internet das Coisas:
  - ***Netbeast***: faz uso do painel de controle automatizado com o objetivo de sincronizar as funcionalidades das aplicações e dispositivos IoT. Suporta os recursos de hospedagem do sistema operacional para os dispositivos embarcados como o Raspberry Pi, sendo capaz também de suportar várias plataformas, como Windows e Linux. Tecnicamente, as solicitações e as respostas são transmitidas em um formato padrão JSON (JavaScript Object Notation).
  - ***Kaa Admin***: permite que os desenvolvedores integrem seus próprios aplicativos dentro do ecossistema. Um ponto importante é a possibilidade de interconexão com a nuvem, sob a qual os usuários podem estabelecer uma conexão para o gerenciamento de seus dispositivos, produtos inteligentes, protótipo, coleta e, em seguida, analisar dados em tempo real, dimensionar as soluções de IoT e estar em posição de implantar as soluções em qualquer outro lugar. Saiba mais [aqui](https://docs.kaaiot.io/KAA/docs/v1.4.0/Welcome/).
  - ***Axway5***: é uma solução de entrega e governança de API com o objetivo de desbloquear qualquer dispositivo conectado, permitindo a coleta dos dados dos dispositivos/sensores e as ações de integração facilmente consumidas pelos aplicativos móveis, sistemas internos e parceiros externos.
  - ***Seeedstudio***: soluções voltadas à prototipação eletrônica e que fornece soluções de sistemas completos voltados para IoT desde placas, sensores/atuadores passando por sistemas para integração e gerenciamento de dispositivos até dashboards em nuvem.

## 2.4 Autenticação na IOT

- as questões de segurança na IoT podem ser resolvidas, por exemplo, aproveitando os `padrões 3GPP`, entidade responsável pelo mecanismo de autenticação de rede que faz parte das redes celulares. 
  - 3GPP une sete organizações de desenvolvimento de padrões de telecomunicações (ARIB, ATIS, CCSA, ETSI, TSDSI, TTA, TTC), conhecidos como “Parceiros Organizacionais”, e fornece a seus membros um ambiente estável para produzir os relatórios e especificações 
- dentro das redes de celular, são usados mecanismos de autenticação fortes, além de outros sistemas de segurança, como o `Cartão de Circuito Integrado Universal (UICC)`.
- para que o processo de autenticação seja considerado confiável, é preciso fazer a associação direta com a camada de transporte (de acordo com os modelos de referência OSI ou TCP/IP).
- um dos elementos-chave de uma arquitetura IoT segura é ter uma identidade segura e forte para cada uma de suas entidades.
- a melhor solução para esses problemas é o uso da `tecnologia GBA` (Generic Bootstrapping Architecture), pois emprega o mecanismo de geração de chaves limitadas no tempo. 
  - após a autenticação do serviço, as chaves podem ser usadas para configurar qualquer tipo de comunicação segura, como a sessão compartilhada TLS (Transport Layer Security) baseada em chave, entre o serviço e o cliente. 

## 2.5 Estratégias para a segurança
- o primeiro passo para implementar a segurança deve ser a realização de uma avaliação que deve incorporar a implementação da IoT no perfil geral de risco da empresa (lista de checagem).
  - dar início a uma pesquisa minuciosa que auxiliará na identificação dos riscos a que a empresa está suscetível, haja vista que cada implementação de IoT é sempre única.
- boas práticas:
  - Acompanhe as soluções IoT. Realize uma auditoria completa nos dispositivos, redes, protocolos de comunicação e aplicativos. É sempre bom estar ciente do número de dispositivos IoT presentes na organização.
  - Determine as vulnerabilidades de segurança para cada um dos elementos pertencentes ao projeto; é bom avaliar também as redes e protocolos de comunicação, as bases de dados e aplicativos, e qualquer outra rede com a qual a rede IoT pode interagir.
  - Mapeie os piores cenários. 
  - Determine se é possível isolar os dispositivos de IoT e os dados de algumas redes. O objetivo por trás disso é minimizar ao máximo a exposição do banco de dados.
  - Determine a sensibilidade dos dados de cada dispositivo de IoT.
- outro escopo: verificação se as informações e dispositivos conectados estão protegidos.

## 2.6 Algumas boas práticas

- uma forma de manter a solução segura contra os ataques que violam os dispositivos eletrônicos é utilizar um microcontrolador que começará a executaros códigos a partir da memória interna e imutável. 
  - o software que foi armazenado no controlador geralmente é considerado inerentemente confiável, já que é impossível para qualquer atacante para modificá-lo, por estar contido na memória “não gravável” do tipo ROM. 
- além disso, a memória flash armazenada internamente no microcontrolador pode ser usada para armazenamento de software de raiz de confiança, se houver segurança adequada. 
  - você pode ter uma memória flash declarada não modificável uma vez que o software tenha sido escrito a ele, ou um mecanismo de autenticação apropriado foi implementado de forma a garantir que apenas os indivíduos autorizados escrevam o software memória flash.
- se o software inicial for modificado e sem controle, não haverá garantia de confiança.
- quanto ao fornecedor do hardware, a cada dispositivo que tenha sido conectado à rede, deve-se garantir o mínimo necessário para que o respectivo fornecedor esteja autorizado a executar uma atualização para o software de firmware do dispositivo. 
- o fator senha também precisa ser avaliado, pois é importante evitar o uso de senhas padrão.
- no que tange ao termo backdoors, bastante conhecido como uma técnica de ataque utilizada por vírus, dentro do contexto da IoT, alguns dispositivos têm alguns pontos de entrada ocultos ou conhecidos que os atacantes podem aproveitar para prejudicar a aplicação. É sempre bom garantir que os dispositivos conectados não possuam esses pontos de entrada. 
- deve ser avaliado se o fabricante apresenta um suporte via fórum e informações de contato. 

---

## FAST TEST

### 1. Como a oferta de aplicações e plataformas IoT é bem vasta, se não houver alguns indicadores, o processo de escolha fica totalmente aleatório e sua incorporação não conseguirá atender as demandas e necessidades da empresa. Indique corretamente a alternativa que não corresponde a um dos indicadores essenciais para facilitar o processo de aquisição.
> Equipe disponível para implementar customizações das aplicações.

### 2. Segundo o estudo feito pela Gartner, quais são as três funcionalidades essenciais a uma boa plataforma IoT?
> Suporte a aplicações, Consolidação de dados e armazenamento, Gerenciamento de conectividade.

### 3. Assinale a alternativa incorreta sobre o Mirai.
> Mirai é uma técnica de defesa a programas mal-intencionados com foco em atacar dispositivos IoT.

### 4. Sobre a Amazon AWS IoT, o que é incorreto afirmar?
> Todos os dados são armazenados num único Data Center, que está localizado nos EUA.

### 5. Comunicações entre sensores em eletrodomésticos, telefones, carros, notebooks, maquinários de fábrica e muitos outros dispositivos que são capazes de acesso à rede através de protocolos de redes sem fio, como:
> 3G, Wi-Fi, Bluetooth, ZigBee.

--- 

[Voltar ao início!](https://github.com/monicaquintal/smart_cities)