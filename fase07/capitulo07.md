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














--- 

[Voltar ao início!](https://github.com/monicaquintal/smart_cities)