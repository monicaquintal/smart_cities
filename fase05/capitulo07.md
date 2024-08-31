<div align="center">
<a href="https://github.com/monicaquintal" target="_blank"><img align="right" height="120px" src="../assets/logo.png" /></a>
<h1>FASE 5 - Data Universe</h1>
<h2>Capítulo 07: Cloud Computing.</h2>
</div>

<div align="center">
<h2>1. CLOUD COMPUTING</h2>
</div>

- significa "computação em nuvem", e surgiu como um novo paradigma para a indústria da informática com relação e intenção de proporcionar disponibilidade e acesso a recursos por meio da Internet. 
- tem transformado a maneira como os consumidores, donos de negócios e empresas da área de Tecnologia da Informação se relacionam, na mesma medida em que tem alterado a forma como plataformas de hardware e software são agrupadas, interagem entre si e como são comercializadas.

## 1.1 Introdução

- embora algumas das tecnologias consideradas como fundamentais para a Cloud Computing estejam disponíveis há algum tempo, como a virtualização, a Cloud Computing ainda está se desenvolvendo e possui uma série de desafios em aberto, como padronização, provisionamento de recursos, entre outros.

## 1.2 Virtualização: uma visão geral

- a virtualização é uma técnica de abstrair recursos físicos, como computação, armazenamento e rede, e fazê-los parecer como se fossem recursos lógicos. 
- a virtualização existe no setor de Tecnologia da Informação (TI) há vários anos e de diferentes formas, exemplos: a memória virtual usada em sistemas de computação e particionamento de discos brutos (raw disks).
- a virtualização propicia o pool de recursos físicos e fornece uma visão agregada desses recursos físicos. 
  - exemplos: 
    - permite que vários dispositivos de armazenamento em pool apareçam como uma única entidade de armazenamento grande. 
    - usando a virtualização de computação, a capacidade da CPU dos servidores físicos em poolpode ser vista como agregação do poder de todas as CPUs (em megahertz). 
- a virtualização também proporciona o gerenciamento centralizado de recursos agrupados: os recursos virtuais podem ser criados e provisionados a partir dos recursos físicos em pool. 
  - exemplo: um disco virtual de uma determinada capacidade pode ser criado a partir de um pool de armazenamento ou um servidor virtual com energia da CPU específica e a memória pode ser configurada a partir de um pool de computação. 
  - esses recursos virtuais compartilham recursos físicos em conjunto, o que melhora a utilização de recursos físicos de TI.
- com base nos requisitos de negócios, a capacidade pode ser adicionada ou removida dos recursos virtuais sem interrupção nos aplicativos ou usuários. 
- com a utilização aprimorada dos ativos de TI, as organizações economizam os custos associados à aquisição e ao gerenciamento de novos recursos físicos. 
- além disso, menos recursos físicos significa menos espaço e energia, o que leva a uma melhor economia e computação verde.

## 1.3 Infraestrutura virtual

- a infraestrutura virtual oferece aos administradores a vantagem de gerenciar recursos agrupados em toda a empresa. 
- permite que os gerentes de TI sejam mais responsivos às necessidades dinâmicas da organização e usem melhor os investimentos em infraestrutura.
- os três principais tipos de virtualização são: `virtualização computacional`, `virtualização de armazenamento` e `virtualização de rede`.
- a virtualização oferece ***vários benefícios*** quando implantada para construir uma infraestrutura em cloud e, ainda, permite a consolidação dos recursos de TI que ajudam os provedores de serviços a otimizar a utilização dos recursos de infraestrutura.
  - melhorar a utilização dos ativos de TI pode ajudar os provedores de serviços a reduzir os custos associados à compra de novo hardware. 
  - também diminui os custos de espaço e energia para a manutenção dos recursos.
  - além disso, é necessária uma quantidade menor de pessoas para administrar esses recursos, o que reduz ainda mais o custo. 
  - os recursos virtuais são criados usando um software que faz com que os provedores de serviços implantem a infraestrutura mais rapidamente, em comparação com a implantação de recursos físicos.
  - a virtualização aumenta a flexibilidade, permitindo criar e recuperar os recursos lógicos com base nos requisitos de negócios.

## 1.4 Virtualização computacional

- a virtualização computacional é uma ***técnica de abstrair o hardware físico de um sistema de computação do sistema operacional (SO) e aplicativos***. 
- a dissociação do hardware físico do SO e dos aplicativos permite que vários sistemas operacionais sejam executados simultaneamente em um sistema de computação físico único ou em cluster. 
- a virtualização de computação propicia a criação de sistemas de computação virtual, chamados `máquinas virtuais` (Virtual Machines - VMs). 
- cada VM executa um SO e aplicativos e é isolada das outras VMs no mesmo sistema computacional. 
- a virtualização de computação é obtida por um `hypervisor`, software de virtualização instalado em um sistema de computação físico. 
  - o hypervisor fornece recursos de hardware virtual, como CPU, memória, armazenamento e recursos de rede para todas as VMs. 
  - dependendo dos recursos de hardware, muitas VMs podem ser criadas em um único sistema de computação físico.

## 1.5 Virtualização de armazenamento

- a virtualização de armazenamento é a ***técnica de abstrair recursos de armazenamento físico para criar recursos de armazenamento virtual***. 
- o software de virtualização de armazenamento tem a capacidade de agrupar e abstrair recursos de armazenamento físico e apresentá-los como um recurso de armazenamento lógico, como volumes virtuais, arquivos de disco virtual e sistemas de armazenamento virtual.
- o software de virtualização de armazenamento é incorporado ao ambiente operacional de um sistema de armazenamento, instalado em um sistema de computação independente ou disponível como recurso do hypervisor.
- no contexto de um sistema de armazenamento, ***existem dois tipos principais de virtualização***:
  - `Virtualização de blocos`:
    - usada neste contexto refere-se à abstração (separação) do armazenamento lógico (partição) do armazenamento físico, para que possa ser acessada sem considerar o armazenamento físico ou a estrutura heterogênea.
    - essa separação permite aos administradores do sistema de armazenamento maior flexibilidade na maneira como gerenciam o armazenamento para usuários finais.
  - `Virtualização de arquivos`:
    - aborda os desafios do NAS (Network-attached storage), eliminando as dependências entre os dados acessados no nível do arquivo e o local em que os arquivos estão fisicamente armazenados.
    - oferece oportunidades para otimizar o uso do armazenamento e a consolidação do servidor e executar migrações de arquivos sem interrupções.

## 1.6 Virtualização de rede 

- a virtualização de rede é a ***técnica de abstrair recursos de rede físicos para criar recursos de rede virtual***. 
- o software de virtualização de rede é incorporado ao ambiente operacional de um dispositivo de rede, instalado em um sistema de comutação independente ou disponível como recurso do hypervisor. 
- o software de virtualização de rede abstrai os recursos físicos da rede, como comutadores e roteadores, para criar recursos virtuais, caso dos comutadores virtuais. 
- ele também divide uma rede física em várias redes virtuais, como Local Area Network (LANs) e Storage Area Network (SANs). 
- a virtualização de rede disponível como recurso de um hypervisor pode emular a conectividade de rede entre VMs em um sistema de comutação físico. 
- essa virtualização de rede permite a criação de comutadores virtuais (virtual switches) que aparecem nas VMs como comutadores físicos (physical switches).
- ***definições sobre diferentes tipos de redes virtuais***:
  - `Virtual LAN (VLAN)`:
    - uma LAN virtual é uma rede virtual que consiste em comutadores virtuais e/ou físicos que dividem uma LAN em segmentos lógicos menores. 
    - uma VLAN agrupa os nós com um conjunto comum de requisitos funcionais, independentemente da localização física dos nós.
  - `Private Virtual LAN (PVLAN)`:
    - uma VLAN privada é uma extensão do padrão da VLAN e segrega ainda mais os nós dentro de uma VLAN em VLANs secundárias. 
    - uma PVLAN é composta de uma VLAN primária e uma ou mais VLANs secundárias ou privadas.
  - `Virtual Extensible LAN (VXLAN)`:
    - uma rede virtual extensível é uma rede de sobreposição OSI na camada 2 construída em uma rede OSI camada 3. 
    - uma rede de sobreposição é uma rede virtual criada sobre a rede existente.

<div align="center">
<h2>2. AGORA, SIM, VAMOS FALAR SOBRE CLOUD COMPUTING</h2>
</div>

- usaremos o conceito do National Institute of Standards and Technology(NIST), que define Cloud Computing como ***um modelo para permitir acesso conveniente e sob demanda à rede a um pool compartilhado de recursos de computação configuráveis, como redes, servidores, armazenamento, aplicativos e serviços; que podem ser rapidamente provisionados e liberados com o mínimo esforço de gerenciamento ou interação do provedor de serviços***.
  - uma infraestrutura em cloud é construída, operada e gerenciada por um provedor de cloudorganização que fornece serviços para os seus consumidores. 
  - o consumidor é um indivíduo ou uma organização tratada como cliente e o provedor pode ser um provedor externo ou interno à organização do consumidor, como o Departamento de Tecnologia da Informação (TI).
  - o provedor mantém pools compartilhados a partir dos quais os recursos de TI são disponibilizados aos consumidores, que os acessam por meio de uma rede, como a Internet ou uma Intranet.
- cloudé uma abstração da infraestrutura de TI na qual os consumidores contratam recursos de TI como serviços, sem os riscos e custos associados à propriedade dos recursos. Os consumidores pagam apenas pelos serviços que usam, com base em uma assinatura ou no consumo desses recursos.
- atualmente, as empresas precisam de menor tempo de colocação no mercado, mais agilidade, maior disponibilidade e gastos reduzidos para atender às mudanças nos requisitos de negócios em um ritmo acelerado de inovação. Muitos dos desafios podem ser suportados por Cloud Computing, o que permite que organizações e indivíduos obtenham e forneçam recursos de TI como um serviço para quem quer se seja e em qualquer lugar.

## 2.1 A tradicional TI versus Cloud Computing

- tradicionalmente, recursos de TI, como hardware e software, são frequentemente adquiridos pela organização para suportar seus aplicativos de negócios. 
- a aquisição e o provisionamento de novos recursos geralmente seguem um procedimento rígido que inclui aprovações das autoridades envolvidas.
- como resultado, eles podem levar uma quantidade considerável de tempo e, por consequência, atrasar as operações e aumentar o tempo de colocação no mercado. 
- além disso, na extensão permitida pelo orçamento, os recursos de TI necessários para um aplicativo são dimensionados com base no uso mais elevado dos recursos. 
- isso resulta em um alto investimento do capital, embora os recursos permaneçam subutilizados na maior parte do tempo.

## 2.2 Alugando recursos

- à medida que as cargas de trabalho continuam a crescer e novas tecnologias surgem, as empresas podem não ter recursos para investimentos; além disso, uma parte significativa do orçamento de TI destina-se a apoiar e manter a infraestrutura de TI existente, deixando um pouco para fornecer soluções inovadoras aos negócios.
- em Cloud Computing, os usuários alugam recursos de TI, como armazenamento, processamento, largura de banda da rede, aplicativo ou uma combinação deles como serviços. 
- a ***Cloud Computing permite provisionamento e escalabilidade de recursos sob demanda***, e esses recursos de TI são provisionados pelos usuários, que utilizam um portal de autoatendimento apoiado por um processo automatizado, e ainda fornecem rápido tempo de colocação no mercado e vantagem potencialmente competitiva.
- o consumo de recursos é medido por um serviço de aferição, que pode ajudar os usuários no faturamento de consumo; os usuários podem deixar de usar os recursos alugados quando não forem mais necessários, reduzindo o investimento na infraestrutura de TI e melhorando a utilização dos recursos. 
- outra consequência é a redução das despesas associadas ao gerenciamento da infraestrutura de TI, espaço, energia e refrigeração. 
- além disso, a diminuição das tarefas de manutenção de TI pode impulsionar novas iniciativas de negócios, descoberta de novos mercados e inovação.

## 2.3 Características essenciais em Cloud Computing

- na maioria dos ambientes competitivos, as organizações estão sob crescente pressão para melhorar a eficiência e transformar seus processos de TI para obter mais com menos: as empresas precisam atualizar a tecnologia de maneira a proporcionar um provisionamento mais rápido dos recursos de TI, e ainda minimizar seus custos.
- com a Cloud Computing, os usuários podem navegar e selecionar serviços em cloud relevantes, como computação, software, armazenamento de informações ou uma combinação desses recursos por meio de um portal. 
- a Cloud Computing automatiza a entrega de serviços em cloud selecionados aos usuários e ainda ajuda organizações e seus indivíduos a implantar recursos de Tecnologia da Informação (TI) a um custo total de propriedade reduzido, com provisionamento mais rápido e aderência à conformidade do projeto.
- uma infraestrutura de computação usada para serviços em cloud deve atender a certos recursos ou características; segundo o NIST (National Institute of Standards and Technology), na publicação SP 800-145, ***a infraestrutura em cloud deve ter cinco características essenciais***:
  - 1. Autoatendimento sob demanda.
  - 2. Amplo acesso à rede.
  - 3. Agrupamento de recursos.
  - 4. Elasticidade rápida.
  - 5. Serviço mensurável.

## 2.4 Autoatendimento sob demanda

- segundo o NIST: "Um consumidor pode provisionar recursos de computação unilateralmente, como máquinas virtuais, redes e armazenamento, conforme necessário automaticamente, sem exigir interação humana com cada provedor de serviços".
- na Cloud Computing, os consumidores têm a capacidade de provisionar os recursos de TI necessários sob demanda de uma cloud, a qualquer momento que desejarem. 
- autoatendimento significa que os próprios consumidores realizam todas as atividades necessárias para provisionar os recursos da cloud.
- para habilitar o provisionamento de autoatendimento sob demanda, um provedor de cloud disponibiliza um portal de autoatendimento simples e fácil de usar, geralmente um site que permite aos consumidores visualizar e solicitar serviços em cloud.
- o provedor de cloud disponibiliza um catálogo de serviços no portal de autoatendimento. 
  - o catálogo de serviços oferece aos clientes um conjunto limitado e padronizado de ofertas de serviços que foram predefinidas com base na experiência do fornecedor, tecnologia, habilidade do pessoal e demanda do mercado. 
  - um consumidor pode visualizá-lopara saber quais serviços em cloudestão disponíveis, seus recursos e preços e valores específicos dos serviços para os consumidores.
- além disso, um catálogo de serviços permite que um consumidor solicite ou realize uma ordem de serviço do catálogo pelo autoatendimento. 
  - a solicitação é processada automaticamente, sem intervenção humana do lado do provedor de cloud; por consequência, isso reduz consideravelmente o tempo necessário para provisionar recursos de TI novos ou adicionais.

## 2.5 Amplo acesso à rede

- "Os recursos estão disponíveis na rede e são acessados por meio de mecanismos-padrão que promovem o uso por plataformas heterogêneas de thin ou thick client, por exemplo, telefones celulares, tablets, laptops e estações de trabalho."
- os consumidores acessam serviços em cloud usando qualquer cliente ou dispositivo de terminal de qualquer lugar da rede, como a Internet ou a rede privada de uma organização. 
- os usuários podem acessar e editar documentos de qualquer dispositivo conectado à Internet, eliminando a necessidade de instalar o aplicativo no dispositivo. 
- os dispositivos clientes podem ter plataformas de hardware e software subjacentes heterogêneas e, com isso, os serviços em cloud geralmente são acessados usando serviços da web. 
- os serviços da Web permitem que um aplicativo cliente solicite dados para um servidor da Web em uma cloud e o servidor da Web retorna as respostas (requisições). 
- o aplicativo cliente pode ser um navegador da Web ou qualquer aplicativo de serviço da Web.
- os serviços da Web fazem com que os clientes se comuniquem com os servidores da Web em uma cloud por intermédio do uso de protocolos da Web padrão, geralmente HTTP (Hypertext Transfer Protocol) ou HTTPS (Hypertext Transfer Protocol Secure).

## 2.6 Agrupamento de recursos

- um pool de recursos é uma abstração lógica de recursos de computação agregados, como poder de processamento, capacidade de memória, armazenamento e largura de banda da rede que são gerenciados centralmente. 
  - os serviços em cloud obtêm recursos de computação de pools de recursos.
  - por consequência, os recursos existentes nos pools de recursos são alocados dinamicamente de acordo com a demanda do consumidor, até um limite definido para cada serviço em cloud. 
  - os recursos alocados são retornados ao pool quando liberados pelos consumidores, disponibilizando-os para realocação. 
- na Cloud Computing, os recursos são agrupados para atender a vários consumidores, isso é conhecido como modelo multi-inquilino. 
  - a multilocação refere-se a uma arquitetura na qual vários consumidores ou inquilinos independentes são atendidos usando um único conjunto de recursos.
- o modelo multilocatário propicia que um provedor ofereça serviços a um custo menor por meio de economia de escala e o ajuda a alcançar altos níveis de utilização de recursos. 
- a virtualização é a principal tecnologia ativadora para pool de recursos e multilocação na cloud. No entanto, é possível construir uma infraestrutura em cloud e oferecer serviços em cloud sem o uso da virtualização.

## 2.7 Elasticidade rápida

- refere-se à capacidade dos consumidores de solicitar, receber e liberar rapidamente quantos recursos forem necessários, até um limite definido para cada serviço em cloud. 
- a característica da elasticidade rápida oferece aos consumidores uma sensação de disponibilidade de recursos ilimitados na cloud que podem ser provisionados a qualquer momento.
  - essa característica permite que os consumidores se adaptem às variações nas cargas de trabalho, expandindo ou reduzindo rapidamente os recursos, e mantenham o nível de desempenho necessário proporcionalmente. 

## 2.8 Serviço mensurável

- uma cloud possui um sistema de medição que afere o consumo de recursos e ajuda a gerar faturas para os consumidores com base nos recursos utilizados por eles.
- sistemas com essas características medem o número de unidades de uso de serviço por consumidor e informam o preço das unidades consumidas. 
- exemplos de uma unidade de serviço são: por GB de armazenamento, por transação e por hora de uso do aplicativo. 
- os relatórios de cobrança são gerados com base no preço por unidade e no número de unidades consumidas de um serviço. 
- ainda, o relatório de cobrança é visível para os consumidores por meio do portal de autoatendimento. 
- o sistema de medição também fornece informações sobre a demanda atual na cloud e ajuda os provedores de cloud com o planejamento de capacidade e serviço. Normalmente, isso é feito com base no pagamento por uso ou na cobrança por uso.

## 2.9 Benefícios da Cloud Computing

- `Agilidade nos negócios`: 
  - Cloud Computing provisiona recursos de TI rapidamente e a qualquer momento, reduzindo consideravelmente o tempo necessário para implantar novos aplicativos e serviços. 
  - essa velocidade faz com que as empresas diminuam o tempo de colocação no mercado e respondam mais rapidamente às mudanças do mercado.
- `Redução nos custos de TI`:
  - Cloud Computing permite que os consumidores aluguem todos os recursos de TI necessários com base de pagamento por uso ou assinatura. 
  - essa alternativa reduz as despesas de TI de um consumidor, pois o investimento é voltado apenas para os recursos necessários para acessar os serviços em cloud. 
  - além disso, as despesas com configuração, gerenciamento, infraestrutura, área útil, energia e refrigeração da infraestrutura de TI são reduzidas.
- `Alta disponibilidade`: 
  - Cloud Computing disponibiliza recursos em vários níveis, dependendo da política do consumidor e da prioridade do aplicativo. 
- `Componentes de infraestrutura redundantes`:
  - (sistemas de computação, caminhos de rede e equipamentos de armazenamento, juntamente com software em cluster) permitem tolerância a falhas para implantações na cloud. 
  - essas técnicas podem abranger vários datacenters localizados em diferentes regiões geográficas, o que evita a indisponibilidade de dados devido a falhas regionais.
- `Escalabilidade`: 
  - na Cloud Computing, os consumidores podem dimensionar de forma unilateral e automática os recursos de TI para atender à demanda de carga de trabalho. 
  - isso é significativamente mais econômico do que comprar novos recursos de TI que são usados apenas por um curto período de tempo ou apenas durante períodos específicos.
- `Continuidade dos negócios`:
  - é possível que os serviços de TI estejam indisponíveis devido a causas, como desastres naturais, erros humanos, falhas técnicas e manutenção planejada. 
  - a indisponibilidade dos serviços de TI pode levar a perdas financeiras significativas para as organizações e também pode afetar sua reputação. 
  - no entanto, ter um site secundário remoto para recuperação de desastres envolve mais despesas de capital e despesas administrativas.
  - com o uso de soluções de continuidade de negócios na cloud, uma organização pode mitigar o impacto do tempo de inatividade e se recuperar de interrupções que afetam adversamente as operações de negócios. 
  - por exemplo, uma organização pode usar backup baseado em cloud para manter cópias adicionais de seus dados, que podem ser recuperadas no caso de uma interrupção. 
  - além disso, uma organização pode economizar nas despesas de capital necessárias para implementar uma solução de backup para sua infraestrutura de TI.
- `Maior colaboração`:
  - a Cloud Computing propicia a colaboração entre grupos diferentes de pessoas e que eles compartilhem recursos e informações e os acessem simultaneamente de qualquer local.
  - por exemplo, funcionários de uma organização podem colocar um documento centralmente na cloud que eles visualizem e trabalhem nele ao mesmo tempo. Isso elimina a necessidade de enviar e receber arquivos por e-mail.
- `Gerenciamento simplificado da infraestrutura`:
  - quando uma organização usa serviços em cloud, suas tarefas de gerenciamento de infraestrutura são reduzidas apenas aos recursos necessários para acessar os serviços em cloud. 
  - a infraestrutura de cloud é gerenciada pelo provedor de cloud e tarefas como atualizações e renovações de software geralmente são administradas pelo provedor.
- `Flexibilidade de acesso`:
  - na Cloud Computing, os aplicativos e os dados residem centralmente e podem ser acessados de qualquer lugar da rede, a partir de qualquer dispositivo, como desktop, celular e thin client. 
  - essa facilidade elimina a dependência de um consumidor em um dispositivo de ponto final específico.

---

## FAST TEST

### 1. A frase: "É uma técnica de abstrair o hardware físico de um sistema de computação do sistema operacional e aplicativos. A dissociação do hardware físico do sistema operacional e dos aplicativos permite que vários sistemas operacionais sejam executados simultaneamente em um sistema de computação físico único ou em cluster.", refere-se a:
> Virtualização computacional.

### 2. A infraestrutura virtual oferece aos administradores a vantagem de gerenciar recursos agrupados em toda a empresa. Quais são os três principais tipos de virtualização existentes?
> Computacional, armazenamento e rede.

### 3. A virtualização de computação é obtida por um hypervisor ou VMM. O que significa VMM?
> Virtual Machine Monitor.

--- 

[Voltar ao início!](https://github.com/monicaquintal/smart_cities)