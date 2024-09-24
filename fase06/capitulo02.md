<div align="center">
<a href="https://github.com/monicaquintal" target="_blank"><img align="right" height="120px" src="../assets/logo.png" /></a>
<h1>FASE 6 - DevOps</h1>
<h2>Capítulo 02: DevOps e sua Importância.</h2>
</div>

<div align="center">
<h2>1. DEVOPS E SUA IMPORTÂNCIA</h2>
</div>

- no mercado de trabalho atual, a quantidade de profissionais que atuam com desenvolvimento back-end, front-end e testes é muito maior que a quantidade de administradores de sistemas (sysadmin), analistas de redes, implantadores de infraestrutura, entre outros.
- observamos nas empresas que times de desenvolvimento e operações não trabalham em conjunto, possuindo metas e objetivos distintos. Para solucionar a situação e promover mudanças com estabilidade, vamos aprender sobre DevOps!

## 1.1 O que é DevOps?

- DevOps é uma cultura que utiliza práticas e ferramentas para aumentar a capacidade de uma organização de desenvolver e entregar softwares, serviços, aplicativos e demais produtos de tecnologia com alta velocidade, porém, sem pôr em risco a estabilidade. 
- quando a organização adota a cultura DevOps, o ritmo de entrega dos produtos é mais rápido do que o das empresas que usam processos tradicionais de desenvolvimento de software e gerenciamento de infraestrutura.

## 1.2 Funcionamento do DevOps

- com a adoção da cultura DevOps, equipes de desenvolvimento e de operações não são mais tratadas de forma separada: são combinadas em uma só, para que ambas possam compartilhar os conhecimentos e entenderem melhor o dia a dia tanto do desenvolvimento quanto da operação. 
- os sysadmins são envolvidos desde o início do desenvolvimento do software e os desenvolvedores acompanham o software até o fim, principalmente na parte das entregas e funcionamento do ambiente de produção.
- como desenvolvedor, não é necessário conhecer de forma profunda todas as habilidades do sysadmin, mas deve-se saber o essencial para acompanhar e contribuir com a implantação/operação do software. Por sua vez, o sysadmin deve conhecer o essencial para acompanhar e contribuir com o desenvolvimento do software.
- esse movimento acaba, de forma indireta, estimulando um ambiente multidisciplinar, no qual desenvolvedores e sysadmins compartilham conhecimentos, experiências e dores de cada área e, juntos, usam práticas para automatizar processos, empregando tecnologias e ferramentas que os ajudam a desenvolver e operar aplicativos de modo rápido, estável e seguro. 
  - com o aumento de conhecimento operacional por parte dos desenvolvedores, a autonomia aumenta e tarefas simples, que normalmente exigiriam a ajuda de um sysadmin ou demais equipes de infraestrutura,começam a ser realizadas de forma independente.
  - o sysadmin passa a conhecer mais do software para conseguir atuar de forma melhor com ele, diminuindo a dependência do desenvolvedor para entender certos fluxos ou comportamentos que antes só a equipe de desenvolvimento conheceria.

### 1.3 Benefícios do DevOps

### 1.3.1 Aumento da velocidade de entrega
- o DevOps proporciona, por meio de ferramentas, a automação de processos manuais e lentos, contribuindo para o aumento da frequência e do número de entregas do seu produto. 
- quanto mais rápido conseguir entregar, mais rápido identificará possíveis problemas e poderá corrigir os erros com maior agilidade.
- além de identificar necessidades do mercado e conseguir entregar de forma mais rápida, você poderá criar uma vantagem competitiva.

### 1.3.2 Escalabilidade
- com a automatização da infraestrutura, DevOps proporciona a possibilidade de gerenciar sua infraestrutura como código, diminuindo a interferência manual e, consequentemente, o risco. 
- você passa a escalar seu código de infraestrutura em diversos ambientes, pois aquilo que é igual para todos é replicado e implantando de forma individual e automática o que é específico. 
- com processos automáticos, é possível identificar a necessidade de escalar sua infraestrutura de acordo com a demanda.

### 1.3.3 Velocidade
- equipes que possuem cultura DevOps têm maior independência, assumindo a responsabilidade ponta a ponta dos produtos e serviços para, então,realizar as entregas e melhorias de forma mais rápida, contribuindo assim para o atingimento de resultados. 
- com as equipes juntas, ambas estão olhando para o mesmo objetivo, não sendo necessário demandar algo de infraestrutura para fora do time, o que poderia levar mais tempo ou espera por priorização.

### 1.3.4 Colaboração contínua
- a junção das equipes as torna mais eficientes, promovendo a cultura da responsabilidade ponta a ponta e do sentimento de "dono" do que é feito. 
- as equipes de desenvolvimento e sysadmin trabalham juntas, compartilham muitas responsabilidades e acordam seus fluxos de trabalho. Como consequência, acontece a redução de processos ineficazes e a economia de tempo.

### 1.3.5 Confiabilidade
- o DevOps promove a garantia da qualidade das atualizações de software e alterações de infraestrutura por meio de processos automatizados de testes em diversos níveis, para aumentar a confiança das entregas e contribuir com a sua velocidade. 
- os testes são parte fundamental do processo e são programados para serem executados no decorrer de todo o ciclo.

### 1.3.6 Segurança
- a adoção da cultura DevOps aumenta a segurança por meio de políticas de segurança automáticas, como controles de acesso entre aplicações, permissionamento, autorização e técnicas de gerenciamento de configuração.

<div align="center">
<h2>2. PRÁTICAS DEVOPS</h2>
</div>

- para promover a cultura DevOps, existem algumas práticas principais que ajudam as organizações a inovarem mais rapidamente por meio da automação e da simplificação dos processos de desenvolvimento de software e gerenciamento de infraestrutura. A maioria dessas práticas é realizada por meio de certas ferramentas.

> Uma prática DevOps essencial é a execução de atualizações muito frequentes, porém pequenas, o que está muito ligado à metodologia de desenvolvimento ágil, por exemplo, SCRUM ou KANBAN.

- outra prática, essa relacionada à arquitetura, é a ***adoção de microsserviços*** para tornar seus aplicativos mais flexíveis e permitir mudanças de forma mais rápida. 
- a arquitetura de microsserviços desacopla sistemas grandes e complexos e os transforma em sistemas menores e independentes: os sistemas são divididos em vários serviços individuais e cada um abrange uma parte ou função única do negócio, além de ser operado independentemente dos serviços de mesmo nível e do sistema como um todo.
- a arquitetura de microsserviços reduz a sobrecarga gerada pela coordenação da atualização de grandes sistemas e, quando cada serviço é combinado com equipes pequenas e ágeis que assumem a responsabilidade de ponta a ponta sobre cada serviço, as empresas conseguem trabalhar mais rapidamente.
- com a combinação de arquitetura de microsserviços e uma maior frequência de entregas, consequentemente, teremos um número significativamente maior de implantações, que podem apresentar desafios e, com as práticas de DevOps, como a integração e entrega contínua entre desenvolvimento e operação, sempre executando os testes necessários, os problemas são minimizados. 
- as práticas de automação de infraestrutura, como a infraestrutura como código e o gerenciamento de configuração, contribuem para que os recursos de infraestrutura trabalhem de forma elástica e disponível para alterações constantemente. 
- práticas de monitoração e indexação de log contribuem para a identificação e prevenção de problemas, além de auxiliar no acompanhamento do desempenho de softwares e da infraestrutura, para que possam reagir rapidamente quando ocorrer problemas.

> A seguir, serão listadas as melhores práticas da cultura DevOps!

## 2.1 Infraestrutura como código

- é uma prática que utiliza técnicas de desenvolvimento de código, e que permite controle de versão e integração contínua da infraestrutura, por meio de API, para que os desenvolvedores e sysadmins trabalhem com a infraestrutura de modo programático, em vez de instalar e configurar manualmente a infraestrutura. 
- isso permite que as equipes dentro de uma empresa operem em uma velocidade maior, uma vez que o código da infraestrutura pode ser reaproveitado e, quando atualizado, replicado para todos os ambientes que utilizam esse trecho de código de infraestrutura.

## 2.2 Arquitetura de microsserviços

- representa um conjunto de pequenos serviços que se interligam para construir um sistema. 
- cada serviço possui um contexto único de negócio, é executado de forma individual e independente e se comunica com outros serviços por meio de uma interface leve, na maioria dos casos baseada em HTTP. 
- é possível usar diferentes linguagens de programação para construir os microsserviços e implantá-los independentemente, desde que consigam se expor e se comunicar na interface definida entre eles.

## 2.3 Integração contínua

- é uma prática de desenvolvimento que permite execução dos testes sempre que as alterações de código são enviadas para o repositório central. 
- os principais objetivos da integração contínua são encontrar e apontar os erros mais rapidamente a cada alteração, consequentemente, melhorar a qualidade do software e reduzir o tempo necessário para validação.

## 2.4 Entrega contínua

- é uma prática que permite ao desenvolvedor, ao realizar as alterações de códigos, utilizar a integração contínua para realização dos testes necessários e preparar automaticamente as modificações para uma entrega em produção. 
- quando a integração contínua é implementada adequadamente, os times terão um pacote de entrega confiável pronto para ser implantado a cada alteração ou conjunto de alterações enviadas para o repositório central.

## 2.5 Monitoração, alarme, log e indexação

- realizar logs de informações das aplicações e infraestrutura é essencial para realizar o monitoramento e gerar alarmes.
- ao capturar, indexar e analisar os logs gerados pelos aplicativos e pela infraestrutura, é possível entender como as alterações ou atualizações estão afetando o ambiente e seus usuários, o que proporciona mais facilidade na rastreabilidade, fornecendo maior esclarecimento sobre as causas raiz dos problemas. 
- com os logs indexados, é possível criar dashboards de acompanhamento realtime e programar alarmes de acordo com determinada situação do ambiente.

## 2.6 Comunicação e colaboração

- o aumento da comunicação, colaboração e compartilhamento de experiência é um dos principais aspectos culturais do DevOps. 
- o uso das práticas e ferramentas contribui para as equipes definirem normas culturais sólidas com relação ao compartilhamento de informações e processos de trabalho. 
- com a unificação das equipes, todos passam a trabalhar juntos, seguindo um objetivo comum.

<div align="center">
<h2>3. ESTÁGIOS E FERRAMENTAS DEVOPS</h2>
</div>

- serão apresentados a seguis os estágios de um processo de DevOps e as ferramentas utilizadas em cada um deles.

## 3.1 Planejamento (Plan)

- na fase de planejamento, quando desenvolvedores e sysadmins estão interagindo para estimar e fatiar as atividades necessárias para a entrega, é fundamental a utilização das práticas de agilidade para melhor organização e fluxo das atividades.

## 3.2 Desenvolvimento ou Codificação (Code)

- na etapa de desenvolvimento, com as atividades definidas, os times começam a codificação do software e a codificação da infraestrutura como código. 
- nessa fase, utilizamos o `Git`, sistema de controle de versões distribuído, capaz de registrar o histórico de edições de qualquer tipo de arquivo, facilitando que um time trabalhe no mesmo arquivo de código ao mesmo tempo. 
- para documentar nosso sistema de forma colaborativa, temos o `Confluence`, e utilizamos o `Jira` para organizar e acompanhar as atividades do time, garantindo o gerenciamento de todo o ciclo de desenvolvimento em um único lugar, permitindo o link entre atividades, repositório Git e documentação do Confluence.

## 3.3 Construção (Build)

- com o código desenvolvido, é necessário realizar o processo de construção (build), no qual o código e demais dependências do software e da infraestrutura são baixados do repositório central, compilados e fechados em uma versão, que será disponibilizada para os testes. 
- também é comum, nessa fase, alguns testes básicos já serem realizados e, se não forem aprovados, o processo de build é cancelado.
- para essa fase, podemos utilizar ferramentas como `Apache Maven`, que realiza a automação da compilação do código e gerenciamento das dependências por meio de XML, ou o `Gradle`, que se baseia nos conceitos do Apache Maven, porém introduz uma linguagem de domínio específico,baseada em Groovy em vez de XML, permitindo maiores funções programaticamente.

## 3.4 Teste (Test)

- com a aplicação do DevOps na fase de testes, além dos testes no software, que vão desde testes unitário, a testes de fumaça (smoketest) e integração, regressão e ponta a ponta, também são realizados os testes de infraestrutura. 
- para o software, é muito comum a utilização do `JUnit` para testes unitários de código, e o `Selenium` para testes que envolvam telas ou fluxos ponta a ponta. Para infraestrutura, temos o `TestInfra` para realizar a validação.

## 3.5 Lançamento / Entrega (Release)

- após o desenvolvimento, testes e empacotamento, é o momento de fazer o lançamento da versão.
- com a cultura DevOps, esse processo é automatizado por meio de ferramentas de pipeline de entrega, que suportam integração e entrega contínua, como `Jenkins` e `CodeShip`. 
- no pipeline de entrega, é possível configurar diversas etapas da entrega, que podem ir desde testes simples até entregas em diversos níveis de ambientes (homologação, produção, pós-produção), além de permitir um passo de aprovação para seguir com a entrega.

## 3.6 Implantação (Deploy)

- está muito ligada à fase do lançamento (Release). 
- na maioria das vezes, a implantação é acionada pelo pipeline de entrega e, nesse momento, existe a instalação de forma automatizada do software e infraestrutura.
- diferentemente da instalação manual, com DevOps o processo é automatizado, por meio de ferramentas como `Docker`, que fornece uma camada adicional de abstração e automação de virtualização em nível de sistema operacional, ele encapsula o seu software em um contêiner com tudo o que é necessário para ser executado.
- qual a diferença do Docker comparado a uma máquina virtual (VM)?
  - basicamente, o Docker não necessita de um Sistema Operacional (OS) dentro da sua virtualização para funcionar, ele utiliza o sistema operacional do próprio host para trabalhar. 
- para controlar a distribuição desses contêineres em sistemas na nuvem (cloud), podemos utilizar os serviços da `Amazon Web Service (AWS)` e,para contribuir com a implantação independente da infraestrutura (cloudou on-premisse), utilizamos `Kubernetes` ou `Apache Mesos`.

## 3.7 Operação (Operate)

- depois de implantado o sistema, podemos operá-lo para modificar comportamentos, escalar ou realizar manutenções e, para contribuir tanto na parte de implantação como na operação do ambiente, temos o `Kubernetes` e o `Apache Mesos`, sistemas de orquestração de contêineres open source que automatizam implantação, dimensionamento e gestão de aplicações, além de criarem uma camada de abstração em cima da infraestrutura, ou seja, você pode trabalhar com diversos tipos de configuração de hosts na sua infraestrutura que o Kubernetes ou Apache Mesos irá identificar os recursos e disponibilizar a infraestrutura como um único cluster. 
- ambas as ferramentas também possuem funcionalidades de balanceamento de carga (load balance) para distribuir a carga de trabalho uniformemente entre os contêineres, o descobrimento de serviços (service discovery) para sua detecção automática, a autorrecuperação (self healing) para recuperar contêineres que tiveram problemas ou que não estão respondendo, por meio de uma verificação de saúde no serviço, entre outros.
- também temos o `Ansible`, ferramenta de automatização para gerenciar múltiplas máquinas de uma vez, que possui uma linguagem bastante simples, sendo possível começar a criar serviços de automação de forma fácil e rápida, além de utilizar SSH para se conectar com os servidores e executar as atividades. 
  - o Ansiblenão utiliza agentes (agentles) nas máquinas que operacionaliza, tornando o processo de automação mais eficiente e leve.

- um assunto muito comum na operação é o ***escalonamento da infraestrutura***, que diz respeito à estratégia da sua expansão em que temos dois modelos: o escalonamento vertical e o horizontal. 
  - o `escalonamento vertical` tem como objetivo aumentar os recursos host, aumentando a capacidade de memória, processamento, disco, entre outros. 
  - já o `escalonamento horizontal` tem como objetivo aumentar a quantidade de hosts e dividir o trabalho entre eles.
- na arquitetura de microsserviços e contêineres, ***o escalonamento horizontal é a prática mais adequada*** e os orquestradores já estão preparados para isso. 
- quando utilizamos o escalonamento vertical, aumentar os recursos acaba se tornando uma estratégia mais cara e pode se tornar limitada, visto que os recursos de infraestrutura maiores custam mais e são limitados até certo ponto. 

## 3.8 Monitoração (Monitor)

- embora seja uma fase muito importante no ciclo DevOps, a fase de monitoração, por vezes, é esquecida. 
- com as monitorações, é possível acompanhar o ambiente em tempo real para análise de performance, comportamentos da aplicação e usuário, troubleshooting (análise de problemas), entre outros. 
- ferramentas como `Splunk`, `Datadog` e `Nagios` permitem a indexação de informações geradas pelas aplicações, para realizarmos pesquisa, monitoramento e análise de grandes volumes de dados gerados, por meio de uma interface Web, possibilitando a criação de dashboards iterativos para consolidar e expor as informações.

<div align="center">
<h2>4. DEVOPS COM SEGURANÇA</h2>
</div>

## 4.1 Devsecops

- algo que não podemos deixar de citar quando falamos sobre DevOps é a segurança. 
- muitas vezes, a abordagem sobre segurança só é colocada para discussão após o software chegar à produção, ou depois que ocorre algum problema relacionado à segurança, como vazamento de informações, ataques e demais brechas.
- para evitar que o assunto da segurança só seja abordado no final de todo o ciclo, existe um movimento no mercado, conhecido como `Shifting Security Left` (movendo a segurança para a esquerda, se considerarmos que o ciclo de desenvolvimento começa na esquerda e termina na direita).
- para que o assunto “segurança” seja abordado no início de todo o ciclo, temos os ***DevSecOps***. 
- principais vantagens ao se trabalhar comDevSecOps: 
  - segurança distribuída dentro da organização.
  - prevenção e endereçamento de vulnerabilidades encontradas antes da entrega.
  - disseminação da consciência de segurança dentro dos times.
  - softwares mais seguros e com maior qualidade.
  - redução de custo para identificar e resolver um problema de segurança.

---

## FAST TEST

### 1. É uma prática para promover a cultura DevOps:
> Execução de atualizações muito frequentes e pequenas.

### 2. Sobre arquitetura de microsserviços, qual é a alternativa correta?
> A arquitetura de microsserviços representa um conjunto de pequenos serviços que se interligam para construir um sistema. Cada serviço possui um contexto único de negócio, é executado de forma individual e independente e se comunica com outros serviços por meio de uma interface leve.

### 3. Qual das alternativas a seguir não descreve um benefício da cultura DevOps?
> Redução na escalabilidade.

### 4. Sobre DevOps, qual dessas afirmações é verdadeira?
> Quando uma organização adota a cultura DevOps, o ritmo de entrega dos produtos é maior do que o das empresas que utilizam processos tradicionais de desenvolvimento de software.

--- 

[Voltar ao início!](https://github.com/monicaquintal/smart_cities)