<div align="center">
<a href="https://github.com/monicaquintal" target="_blank"><img align="right" height="120px" src="../assets/logo.png" /></a>
<h1>FASE 5 - Data Universe</h1>
<h2>Capítulo 08: Arquitetura e Aplicações Cloud.</h2>
</div>

<div align="center">
<h2>1. ARQUITETURA E APLICAÇÕES CLOUD</h2>
</div>

## 1.1 Introdução

- a cloud computing é um dos principais facilitadores da transformação digital, proporcionando efetivamente: recursos de TI ilimitados e dinâmicos, redução de custos e rápidas mudanças nos negócios. 
- a estratégia tecnológica de qualquer empresa pode estar incompleta sem os serviços em cloud, visto o fato de inegável mudança de paradigma.

<div align="center">
<h2>2. UM RITMO ACELERADO DE INOVAÇÃO</h2>
</div>

## 2.1 Desafios em um mundo globalizado

- em um ambiente competitivo, as organizações desejam melhorar a eficiência e transformar seus processos de TI para obter mais com menos. 
- as organizações precisam de menor tempo de colocação no mercado, melhor agilidade, maior disponibilidade e gastos reduzidos para atender às mudanças nos requisitos de negócios a um ritmo acelerado de inovação. 
- os requisitos de negócios estão colocando vários desafios para as equipes de TI, e um dos principais está em atender clientes onde quer que estejam localizados, atualizando a tecnologia e provisionando mais rapidamente os recursos de TI, tudo a custos reduzidos.

## 2.2 Implantação em cloud e modelos de serviços

- de acordo com o National Institute of Standards and Technology (NIST),a Cloud Computing é classificada em ***quatro modelos de implantação***: `público`, `privado`, `comunidade` e `híbrido`, que fornecem a base de como as infraestruturas de cloud são construídas e consumidas. 
- o NIST ainda define ***três modelos de serviços em cloud***: `Infrastructure as a Service`, `Platform as a Service` e `Software as a Service`.
  - há ainda o `Everything as a Service`, que não está mencionado na lista do NIST, mas que compreende qualquer tipo de serviço

## 2.3 Modelos de serviços em cloud

- Um modelo de serviço em cloud especifica os serviços e os recursos fornecidos aos consumidores. 
- cada modelo de implantação em cloud pode ser usado para qualquer um dos modelos de serviço em cloud.

## 2.4 Infrastructure as a Service

- definido como: a capacidade fornecida ao consumidor de processamento, armazenamento, redes e outros recursos computacionais fundamentais onde ele é capaz de implantar e executar software arbitrário, que pode incluir sistemas operacionais e aplicativos. 
  - o consumidor não gerencia ou controla a infraestrutura de cloud subjacente, mas tem controle sobre sistemas operacionais, armazenamento e aplicativos implantados; e possivelmente controle limitado de componentes de rede selecionados.
- no modelo IaaS, os consumidores contratam recursos de TI, como sistemas de computação, capacidade de armazenamento e largura de banda da rede de um provedor de serviços em cloud.
- a infraestrutura de cloud subjacente é implantada e gerenciada pelo provedor de serviços em cloud e os consumidores podem implantar e configurar software como um sistema operacional (SO), banco de dados e aplicativos nos recursos da cloud.
- o IaaS pode até ser implementado internamente por uma organização com TI que gerencia os recursos e serviços. 
- o preço para se adquirir ou usar IaaS pode ser baseado em assinatura ou no uso de recursos. 
- mantendo-se alinhado às características da cloud, o provedor agrupa os recursos de TI subjacentes que são compartilhados por vários consumidores por meio de um modelo de vários locatários. 
- exemplos de provedores de IaaS: Amazon Elastic Compute Cloud(Amazon EC2) e Simple Storage Service (S3).

## 2.5 Platform as a Service

- definido como: capacidade fornecida ao consumidor de implantar na infraestrutura de cloud aplicativos criados ou adquiridos pelo consumidor, usando linguagens de programação, bibliotecas, serviços e ferramentas suportados pelo provedor.
  - o consumidor não gerencia ou controla a infraestrutura de cloud subjacente, incluindo rede, servidores, sistemas operacionais ou armazenamento, mas tem controle sobre os aplicativos implantados e, possivelmente, as definições de configuração do ambiente de hospedagem de aplicativos.
- no modelo PaaS, um serviço em cloud abrange recursos de computação, armazenamento e rede, junto com o software da plataforma. 
  - o software da plataforma inclui software como SO, banco de dados, estruturas de programação, middleware e ferramentas para desenvolver, testar, implantar e gerenciar aplicativos.
- a maioria das ofertas de PaaS suporta múltiplos sistemas operacionais e estruturas de programação para desenvolvimento e implantação de aplicativos.
- as taxas de uso de PaaS geralmente são calculadas com base em fatores como o número de consumidores, os tipos de consumidores (desenvolvedor, testador etc.), o tempo em que a plataforma está em uso e os recursos de computação, armazenamento ou rede consumidos pela plataforma. 
- exemplos de provedores de PaaS: Elastic Beanstalkda AWS, GoogleApp Engine e Microsoft Azure.

## 2.6 Software as a Service

- definido como: capacidade fornecida ao consumidor de usar os aplicativos do provedor em execução em uma infraestrutura de cloud. 
  - os aplicativos são acessíveis a partir de vários dispositivos clientes por meio de uma interface thin-client, como um navegador da web, e-mail baseado na web ou uma interface de programa. 
  - o consumidor não gerencia ou controla a infraestrutura de cloud subjacente, incluindo rede, servidores, sistemas operacionais, armazenamento ou até mesmo recursos de aplicativos individuais, com a possível exceção de definições limitadas de configuração de aplicativos específicos do usuário.
- no modelo SaaS, um provedor oferece um aplicativo hospedado na cloud para vários consumidores como um serviço. 
- os consumidores não possuem acesso ao gerenciamento de nenhum aspecto da infraestrutura de cloud. 
- no SaaS, uma versão específica de um aplicativo, com uma configuração específica (hardware e software), normalmente recebe vários serviços, particiona e executa sessões e dados individuais. 
- os aplicativos SaaS são executados na cloud e geralmente não precisam ser instalados nos dispositivos do terminal.
- isso permite que um consumidor acesse o aplicativo sob demanda de qualquer local e use-o por meio de um navegador da Web em uma variedade de dispositivos terminal. 
- alguns aplicativos SaaS podem exigir que uma interface do cliente esteja localizada localmente em um dispositivo de terminal, como CRM (Customer Relationship Management), e-mail, Enterprise Resource Planning (ERP) e pacotes de escritório (office), são exemplos de aplicativos entregues por SaaS.
- exemplos fornecedores de SaaS: Salesforce.com, Google Apps (G Suite) e Microsoft Office 365.

## 2.7 Everything as a Service (XaaS)

- o 'X' em XaaS refere-se a 'qualquer coisa' ou 'tudo' como um serviço.
- é um termo de Cloud Computing que é uma variedade enorme de ofertas baseadas em utilitários que emergem para que os usuários acessem sob demanda pela Internet, em vez de serem utilizados localmente.
- XaaS tem sido frequentemente usado como um termo genérico para abranger SaaS, PaaS e IaaS. 
- à medida que o XaaS evolui, temos a oportunidade de redefinir permanentemente o setor de computação e criar um universo crescente de serviços que enriquecem nossa vida cotidiana e melhoram a eficiência de nossos negócios.
- Tudo como serviço se originou como software como serviço e, a partir de então, expandiu-se para incluir serviços como infraestrutura como serviço, plataforma como serviço, armazenamento como serviço, área de trabalho como serviço e recuperação de desastre como serviço.
- este modelo XaaS não se limita apenas aos serviços on-line, porque os negócios tradicionais também estão sendo transformados por meio da conectividade digital. 
- o transporte como serviço está sendo realizado por empresas como Uber e Lyft; mercearia como serviço está sendo oferecida por redes como Safeway e "Amazon's Whole Foods"; e, ainda, acomodação como serviço é um serviço de aluguel de acomodações fornecido pela Airbnb.

<div align="center">
<h2>3. MODELOS DE IMPLANTAÇÃO EM CLOUD</h2>
</div>

- há diferentes maneiras de implantar recursos em cloud.
- as opções para implantação incluem cloud pública, privada e híbrida. 
- todos os três cenários oferecem benefícios semelhantes, incluindo relação custo-benefício, desempenho, confiabilidade e escala, mas o método de implantação escolhido depende das necessidades de seus negócios.

## 3.1 Cloud pública

- é uma infraestrutura implantada por um provedor para oferecer serviços em cloud ao público em geral e/ou organizações pela Internet. 
- no modelo de cloud pública, pode haver vários inquilinos que compartilham recursos comuns na cloud. 
- um provedor normalmente possui níveis de serviço-padrão para todos os consumidores da cloud pública e pode migrar a carga de trabalho de um consumidor a qualquer momento para qualquer local. 
- alguns fornecedores opcionalmente fornecem recursos que permitem ao consumidor configurar sua conta com restrições específicas de localização.
- os serviços de cloud pública podem ser gratuitos, baseados em assinatura ou fornecidos em um modelo de pagamento por uso. 
  - dessa forma, a cloud pública oferece os benefícios de baixos custos iniciais com recursos de TI e enorme escalabilidade. 
- no entanto, algumas preocupações para os consumidores incluem disponibilidade de rede, riscos associados à multialocação, visibilidade e controle limitados ou inexistentes sobre os recursos e dados da cloude níveis de serviço-padrão restritivos.

## 3.2 Cloud privada

- é uma infraestrutura configurada para o uso exclusivo de uma organização específica.
- os serviços implementados na cloud privada são dedicados aos consumidores, como departamentos e unidades de negócios da organização. 
- muitas organizações podem não querer adotar cloud públicas, pois são acessadas pela Internet aberta e usadas pelo público em geral. 
  - com uma cloud pública, uma organização pode ter preocupações relacionadas à privacidade, ameaças externas e falta de controle sobre os recursos e dados de TI. 
  - quando comparada a uma cloud pública, uma cloud privada oferece às organizações maior privacidade e controle sobre a infraestrutura, aplicativos e dados disponíveis. 
- o modelo de cloud privada geralmente é adotado por organizações de tamanho maior que têm os recursos para implantar e operar seus próprios serviços.
- há duas variantes de cloud privada: `no local` e `hospedada externamente`.
  - a ***cloud privada local*** é implantada por uma organização em seu data center, utilizando suas próprias instalações.
  - no modelo de cloud privada ***hospedada externamente*** ou cloud privada ***fora do local***, uma organização terceiriza a implementação da cloud privada para um provedor de serviços em cloud externo. 
- a infraestrutura da cloud está hospedada nas instalações do provedor e pode ser compartilhada por vários inquilinos. No entanto, os recursos de cloud privada da organização são separados com segurança de outros inquilinos na cloud por políticas de acesso implementadas pelo provedor.

## 3.3 Cloud híbrida

- composta por duas ou mais clouds individuais, em que cada uma pode ser privada ou pública. 
- pode haver várias composições possíveis de uma cloud híbrida, pois cada cloud constituinte pode ter variantes.
- como resultado, cada cloud híbrida possui propriedades diferentes em termos de parâmetros, como desempenho, custo, segurança e assim por diante, além de poderem mudar ao longo do tempo, quando as clouds componentes se juntam ou se separam. 
- em um ambiente de cloud híbrida, as cloud componentes são combinadas pelo uso de tecnologia aberta ou proprietária, como padrões interoperáveis, arquiteturas, protocolos, formatos de dados, APIs (interfaces de programação de aplicativos) e assim por diante. 
- além disso, o uso dessa tecnologia permite a portabilidade de dados e aplicativos.

## 3.4 Multicloud 

- muitas organizações começaram a adotar uma abordagem de várias clouds, mais comumente conhecidas como multicloud, com o objetivo de atender às demandas de negócios, uma vez que nenhum modelo de cloud pode atender aos diversos requisitos e cargas de trabalho nas organizações. 
- a multicloud é uma abordagem composta por mais de um serviço e de um fornecedor de cloud pública ou privada. 
- ***qual a diferença entre multicloud e cloud híbrida***?
  - a **multicloud** se relaciona à presença de mais de uma implantação de cloud do mesmo tipo (pública ou privada), originada de diferentes fornecedores. 
  - a **cloud híbrida** se refere à presença de vários tipos de implantação (pública ou privada) com alguma forma de integração ou orquestração entre elas.
  - uma abordagem de multicloud pode envolver dois ambientes de cloud pública ou privada. Uma abordagem de cloud híbrida pode abranger um ambiente de cloud pública e outro de cloud privada com infraestrutura (auxiliada por interfaces de programação de aplicativos, middleware ou contêineres) que facilita a portabilidade da carga de trabalho.
  - essas abordagens de cloud são mutuamente exclusivas: não é possível ter ambas simultaneamente porque as nuvens estarão interconectadas (cloud híbrida) ou não (multicloud). 
- como as empresas buscam aprimorar a segurança e o desempenho por meio de um portfólio ampliado de ambientes, ter diversas implantações de cloud tem se tornado cada vez mais comum.
- algumas cargas de trabalho de aplicativos são executadas melhor em uma plataforma em cloud, enquanto outras alcançam maior desempenho e menor custo em outra plataforma. Ao adotar uma estratégia de várias clouds, as organizações podem escolher serviços de diferentes provedores de serviços em cloud para criar a melhor solução possível para seus negócios. 
- a maneira de evitar o aprisionamento de fornecedores também é um fator de adoção de várias clouds. 
- além disso, algumas organizações adotam estratégias de várias nuvens por motivos de controle de dados. Certas políticas de conformidade, regulamentos e governança exigem que os dados das organizações residam em locais específicos. 
- devido ao crescente número de cargas de trabalho na cloud e ao desenvolvimento de estratégias híbridas e com multicloud, as empresas ainda enfrentam sérios desafios em relação à segurança, gerenciando os gastos e a governança da cloud. 

<div align="center">
<h2>4. DIFERENTES SERVIÇOS DE CLOUD</h2>
</div>

## 4.1 Estratégia de multicloud

- uma estratégia de multicloud permite que as empresas selecionem diferentes serviços de cloud de variados fornecedores, porque alguns são melhores para determinadas tarefas do que outros. 
- estratégias em que as empresas devem se concentrar no que importa para o seu negócio: modernização de aplicativos, agilidade e transformação de negócios para atender às necessidades dos clientes. 
- alguns dos principais problemas que sua organização deve considerar para planejar implantações híbridas e multicloud de sucesso:
  - `Planejar com antecedência`: escolha componentes nativos e independentes da cloud, para que seus aplicativos não sejam bloqueados em um único provedor de serviços em cloud.
  - `Prepare-se para a complexidade`: as implantações híbridas e de multicloud adicionam complexidades consideráveis de gerenciamento de dados porque podem envolver a transferência de dados entre clouds, preocupações com latência e garantias de consistência.
  - `Não considere apenas o custo`: leve em conta desempenho, segurança, regulamentos e os recursos dos ambientes nos quais você está implantando.
  - `Automatize o máximo possível`: microsserviços, contêineres e Kubernetes tornam a interoperabilidade muito mais simples, mas adotam uma cultura DevOpspara que você possa automatizar seus processos e acelerar seu tempo de comercialização. 

## 4.2 Benefícios do multicloud

- uma plataforma multicloud combina os melhores serviços que cada plataforma oferece e isso permite que as empresas personalizem uma infraestrutura específica para seus objetivos de negócios. 
- uma arquitetura multicloud também oferece menor risco, visto que se um host de serviço falhar, uma empresa poderá continuar operando com outras plataformas.
- exemplos de provedores de cloud:
  - AWS (Amazon Web Services).
  - Google Cloud Platform.
  - IBM Cloud.
  - Microsoft Azure.
  - Openstack.
  - Rackspace.
  - VMware Cloud.
  
- multicloud envolve gerenciar carga de trabalho ou aplicativo na computação em clouds diferentes, à medida que as informações são movidas de uma plataforma em cloud para outra. Isso exige que uma organização possua experiência em vários provedores de cloud e gerenciamento complexo.

---

## FAST TEST

### 1. O NIST (National Institute of Standards and Technology) define três modelos de serviços em cloud:
> Infrastructure as a Service (IaaS), Platform as a Service (PaaS) e Software as a Service (SaaS).

### 2. A frase: "Esse modelo de nuvem é composto de uma infraestrutura de nuvem implantada por um provedor para oferecer serviços em nuvem ao público em geral e/ou a organizações pela Internet. Nesse modelo, pode haver vários inquilinos que compartilham recursos comuns de nuvem", refere-se a qual modelo de implantação em cloud?
> Nuvem pública.

### 3. De acordo com o National Institute of Standards and Technology (NIST), a cloud computing é classificada em quatro modelos de implantação, que fornecem a base de como as infraestruturas de cloud são construídas e consumidas. Quais são estes modelos?
> Público, privado, comunidade e híbrido.

--- 

[Voltar ao início!](https://github.com/monicaquintal/smart_cities)