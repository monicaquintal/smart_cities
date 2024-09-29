<div align="center">
<a href="https://github.com/monicaquintal" target="_blank"><img align="right" height="120px" src="../assets/logo.png" /></a>
<h1>FASE 6 - DevOps</h1>
<h2>Capítulo 04: Azure DevOps e Ferramentas.</h2>
</div>

<div align="center">
<h2>1. AZURE DEVOPS E FERRAMENTAS</h2>
</div>

- Azure DevOps é Plataforma de DevOps da Microsoft que oferece uma série de ferramentas integradas projetadas para suportar desenvolvimento, teste, implantação e monitoração de aplicações em qualquer ambiente, seja na nuvem ou em sistemas locais.
- o Azure DevOps dá suporte a uma cultura colaborativa e um conjunto de processos que reúnem desenvolvedores, gerentes de projetos e colaboradores para desenvolver softwares. 
- permite que as organizações criem e melhorem produtos em ritmos mais acelerados do que o fariam com abordagens tradicionais de desenvolvimento de software.
- com Azure DevOps, as organizações podem acelerar seus ciclos de desenvolvimento, aproveitando recursos de automação e integração contínua, o que permite uma entrega de produtos mais rápida e com maior qualidade do que as metodologias de desenvolvimento de software tradicionais. 
- além disso, a plataforma oferece flexibilidade, permitindo que as equipes escolham as ferramentas e serviços que melhor se adaptam às suas necessidades para complementar e melhorar seus fluxos de trabalho existentes.
- o Azure DevOps fornece recursos integrados que você pode acessar por meio do navegador web ou do cliente de IDE.
- você pode usar todos os serviços incluídos no Azure DevOps ou escolher apenas o que precisa para complementar seus fluxos de trabalho existentes. 
- alguns dos serviços do Azure DevOps:

<div align="center">

Serviço | Descrição
--------|-------------
Azure Boards | Entrega um conjunto de ferramentas Agile para dar apoio ao trabalho de planejamento e acompanhamento, aos defeitos de código e aos problemas de uso dos métodos Kanban e Scrum.
Azure Repos | Fornece repositórios Git ou Team Foundation Version Control(TFVC) para controle da fonte do seu código.
Azure Pipelines | Fornece serviços de compilação e lançamento para dar suporte à integração contínua e à distribuição de seus aplicativos.
Azure Test Plans | Fornece várias ferramentas para testar seus aplicativos, incluindo testes manuais/exploratórios e testes contínuos.
Azure Artifacts | Permite que as equipes compartilhem pacotes como o Maven, npm, NuGet e muitos outros de fontes públicas e privadas e integrem o compartilhamento de pacotes aos seus pipelines.

</div>

- a abordagem ágil no desenvolvimento de software, fundamentada no Manifesto Ágil, destaca a importância da colaboração, resposta a mudanças e entrega funcional. 
- o Azure DevOps encarna esses princípios através de suas ferramentas integradas, oferecendo um ambiente que promove práticas ágeis entre as  equipes de desenvolvimento.

> Dica: Para explorar mais sobre os princípios que moldam métodos ágeis e eficazes no desenvolvimento de software, visite o [Manifesto para Desenvolvimento Ágil de Software](https://agilemanifesto.org/iso/ptbr/m/manifesto.html).

## 1.1 Ambiente Azure DevOps

- a preparação do ambiente é um passo crucial para garantir que tenha acesso às ferramentas e recursos necessários para desenvolver, testar e implantar aplicações eficientemente. 
- segue guia detalhado para configurar a conta Azure e garantir que esteja pronto para seguir com o material.

### 1.1.1 Preparação do ambienteA
- pré-requisitos essenciais:
  - ***Conta GitHub***: usaremos o GitHub para gerenciar o código-fonte.
  - ***Acesso ao e-mail institucional***: e-mail @fiap.com.br para procedimentos relacionados ao curso.
  - ***Conta Azure***: conta no Azure configurada com seu e-mail @fiap.com.br para acessar os recursos oferecidos na nuvem.

## 1.2 Configuração da conta Azure

### a) Acesso ao [Portal Azure](https://portal.azure.com/#home): 
- o portal Azure é o seu centro de comando. 
- aqui você gerenciará serviços, visualizará recursos e configurará aspectos essenciais de seus projetos de DevOps. 
- inicie seu acesso ao portal Azure e familiarize-se com a interface, pois ela será sua aliada constante no desenvolvimento e na gestão de aplicações.

### b) Login: 
- utilize seu e-mail @fiap.com.br ou sua conta Microsoft para fazer o login.
- tela de boas-vindas do Azure: painel intuitivo que lhe dá um panorama de suas atividades e recursos disponíveis.

## 1.3 Benefícios do aluno

- para acessar os benefícios de aluno no Azure:
  - ***Explorar Recursos***: Após realizar login, localize e clique no botão "Explorar" na tela inicial.
  - ***Inscrição no Programa para Estudantes***: botão "Inscreva-se agora mesmo". Ao clicar neste botão, você iniciará o processo para ativar seu perfil de estudante, que inclui um crédito de US$ 100 para usar na plataforma. 
  - ***Experimentação Gratuita***: após a inscrição no programa de estudantes, prossiga clicando no botão "Experimente Gratuitamente". Você será guiado através de um processo de autenticação usando seu e-mail @fiap.com.br. 
    - após a conclusão destes passos, será redirecionado para a tela de "Visão Geral".

## 1.4 Ferramental do Azure Devops

### 1.4.1 Azure Boards: Maximizando a gestão de projetos
- Azure Boards é uma ferramenta projetada para melhorar o gerenciamento e o planejamento de projetos de software. 
- funcionando como um quadro ágil interativo, o Azure Boards facilita a colaboração entre as equipes de desenvolvimento, permitindo que visualizem progressos, planejem sprints, registrem bugs e gerenciem tarefas de forma eficiente e intuitiva.
- Azure Boards é versátil, suportando diversos modelos de processos que se adaptam às necessidades de diferentes metodologias de gerenciamento de projetos. 
- cada ***modelo*** é projetado para se adequar a diferentes estilos de trabalho e objetivos de equipe:
  - `Basic`: Ideal para pequenas equipes ou projetos com requisitos simples, focando em tarefas básicas e gerenciamento de bugs.
  - `Scrum` :Perfeito para equipes que seguem metodologias Scrum, facilitando a gestão de sprints, planejamento de produto e revisões de sprint.
  - `Ágil`: Adequado para equipes que implementam práticas ágeis, mas com maior flexibilidade do que o estrito Scrum, permitindo uma abordagem mais fluida ao planejamento iterativo.•
  - `CMMI` (Capability Maturity Model Integration): Recomendado para organizações que necessitam de processos rigorosos de gerenciamento de projetos equalidade, suportando gerenciamento detalhado de requisitos e controle de mudanças.
- algumas ***funcionalidades chave***:
  - `User Stories`: Facilita a captura de requisitos e expectativas dos clientes de uma maneira compreensível para todos os membros da equipe.
  - `Tasks`: Permite a criação de tarefas detalhadas que podem ser atribuídas e rastreadas, garantindo que todos os aspectos do projeto estejam cobertos.
  - `Bugs`: Oferece uma maneira eficiente de registrar, rastrear e corrigir bugs, integrando-se perfeitamente com o ciclo de vida de desenvolvimento do software.

> Azure Boards não apenas ajuda a organizar e monitorar o progresso das atividades, mas também promove uma comunicação melhor e mais clara entre os membros da equipe. A integração com outras ferramentas do Azure DevOps, como Azure Repos e Azure Pipelines, amplia ainda mais sua eficácia, criando um ambiente de desenvolvimento contínuo e integrado.

## 1.5 Azure Repos: Controle e colaboração no gerenciamento de código

- Azure Repos é uma solução robusta de controle de versão, parte integrante do Azure DevOps, que oferece aos desenvolvedores uma plataforma segura e eficiente para gerenciar alterações no código-fonte. 
- independentemente do tamanho do projeto, a implementação de um sistema de controle de versão é crucial para manter a integridade do código, facilitar a colaboração entre membros da equipe e rastrear o histórico de modificações de maneira eficaz.
- Azure Repos suporta ***dois principais tipos de controle de versão***, permitindo que equipes escolham a tecnologia que melhor se adapta às suas necessidades:
  - `Git`: sistema de controle de versão distribuído que permite que cada desenvolvedor tenha uma cópia completa do repositório, incluindo seu histórico completo. Isso facilita a colaboração em escala, pois as alterações podem ser mescladas de um repositório local para o servidor central. O Git é amplamente reconhecido por sua flexibilidade e é o sistema de controle de versão mais utilizado no desenvolvimento moderno de software.
  - `TFVC` (Team Foundation Version Control): sistema de controle de versão centralizado que mantém um único repositório no servidor. TFVC é ideal para projetos que necessitam de uma política centralizada de acesso e controle sobre as operações de check-in.
- ***Benefícios do Azure Repos***:
  - **Colaboração aprimorada**: facilita a colaboração entre equipes distribuídas, permitindo que desenvolvedores trabalhem independentemente e depois sincronizem suas alterações com o repositório central.
  - **Histórico de revisões**: mantém um histórico detalhado de todas as alterações, essencial para a análise de problemas e a recuperação de versões anteriores do software.
  - **Integração contínua**: integra-se perfeitamente com Azure Pipelines para automação de builds e deployment, proporcionando um ciclo de vida de desenvolvimento contínuo e eficiente.
  - **Segurança e controle**: oferece configurações avançadas de segurança e controle de acesso para proteger o código e gerenciar quem pode modificar o quê.

> Ao integrar o Azure Repos em seus projetos, garante não apenas a segurança e a organização do código, mas também um ambiente colaborativo que suporta o crescimento e a eficiência da equipe de desenvolvimento.

## 1.6 Azure Pipelines: Automatizando o ciclo de vida do desenvolvimento de software

- Azure Pipelines é uma ferramenta desenhada para automatizar não apenas o processo de build e teste, mas também a implantação de aplicações em qualquer ambiente, seja na nuvem, híbrido ou on-premises.
- através da integração contínua (CI) e da entrega contínua (CD), o Azure Pipelines facilita a implementação de práticas DevOps, permitindo que equipes de desenvolvimento entreguem software de forma mais rápida, confiável e com maior qualidade.
- ***principais características*** do Azure Pipeline:
  - **Suporte a múltiplos idiomas e plataformas**: projetado para ser extremamente flexível, suporta uma ampla gama de linguagens de programação como Python, Java, JavaScript, C#, Ruby, e muitas outras.
  - **Integração contínua**: automatiza a compilação e o teste do código sempre que uma mudança é feita, proporcionando feedback imediato sobre a saúde do código. Essa prática reduz a complexidade na integração das alterações e melhora a qualidade do software entregue.
  - **Entrega contínua**: permite que as mudanças de código aprovadas sejam automaticamente enviadas para produção; facilita a atualização rápida de aplicações, garantindo que novas características e correções cheguem aos usuários finais de forma mais rápida e segura.
  - **Configuração flexível**: através de pipelines definidos como código (YAML), o Azure Pipelines permite que você configure detalhadamente cada etapa do processo de build e release, desde a execução de testes automatizados até a implantação em diferentes ambientes. Isso proporciona controle total sobre como e quando o software é construído, testado e lançado.
- com sua capacidade de integração contínua, o Azure Pipelines facilita a rápida detecção e correção de bugs ao identificar problemas logo no início do ciclo de desenvolvimento. Isso não apenas minimiza os impactos negativos, mas também acelera o processo de correção. Além disso, as atualizações regulares e a transparência sobre o status do build e do release permitem que as equipes colaborem mais efetivamente. 
- esta visibilidade aprimorada melhora a comunicação e a coordenação em projetos complexos, tornando o processo de desenvolvimento mais coeso e integrado. Outro benefício significativo do Azure Pipelines é a redução do tempo de lançamento no mercado.
- a automação do processo de release permite acelerar o lançamento de novas funcionalidades e melhorias, conferindo uma vantagem competitiva crucial no ambiente de mercado atual. 

> Ao adotar o Azure Pipelines, as organizações não apenas garantem um desenvolvimento de software mais ágil e eficiente, mas também promovem uma cultura de inovação contínua e melhoria constante dos processos dentro de suas equipes.

## 1.7 Azure Test Plans: Aprimorando a qualidade do software com testes colaborativos

- o Azure Test Plans é uma ferramenta projetada para aprimorar a qualidade do software e facilitar a colaboração eficaz durante o processo de desenvolvimento. 
- esta solução baseada em navegador é notavelmente fácil de usar e acessível a todos os membros da equipe, permitindo que tanto desenvolvedores quanto testadores contribuam ativamente para o ciclo de vida do desenvolvimento de software.
- oferece um conjunto robusto de funcionalidades para gestão de testes que abrange desde testes manuais planejados até testes de aceitação do usuário, passando por testes exploratórios e até a coleta de feedback de stakeholders. 
- essas ferramentas não apenas ajudam a garantir que os produtos atendam aos mais altos padrões de qualidade, mas também que sejam alinhados com as necessidades e expectativas dos usuários finais.
- ***algumas características*** do produto:
  - `Testes manuais planejados`: organize e execute conjuntos de testes detalhados que garantem a cobertura completa de todos os aspectos do sistema.
  - `Testes de aceitação do usuário`: facilite a participação dos usuários finais no processo de teste para garantir que o software atenda às suas necessidades práticas.
  - `Testes exploratórios`: permita que os testadores explorem o software sem um conjunto fixo de instruções, incentivando a descoberta de problemas que os testes tradicionais podem não encontrar.
  - `Coleta de feedback`: integre facilmente os stakeholders no processo de testes, permitindo que forneçam insights valiosos que podem direcionar melhorias no produto.

> Implementar Azure Test Plans no processo de desenvolvimento de software é uma estratégia que promove não apenas qualidade, mas também a agilidade. Os feedbacks coletados através dessa ferramenta são integrados deforma contínua, permitindo ajustes rápidos que mantêm os projetos alinhados com as metas estabelecidas e as necessidades dos usuários.

## 1.8 Azure Artifacts: Facilitando a Gestão de Pacotes e Integrações em DevOps

- proporciona uma solução poderosa e flexível para gestão de pacotes e dependências em projetos de desenvolvimento de software. 
- com Azure Artifacts, desenvolvedores podem publicar, consumir e gerenciar pacotes de uma variedade de fontes e formatos, incluindo feeds públicos conhecidos como PyPI, Maven Central e NuGet.org. 
- esta funcionalidade permite integração de componentes de software, garantindo que as equipes possam compartilhar e reutilizar código dentro e fora de suas organizações.
- desempenha um papel crucial na simplificação do processo de publicação e consumo de pacotes, permitindo que desenvolvedores armazenem e gerenciem suas dependências em um local centralizado, o que facilita a governança e o controle de versões, essenciais para manter a qualidade e a integridade do software ao longo de seu ciclo de desenvolvimento. 
- além disso, o Azure Artifacts oferece suporte para uma vasta gama de formatos de pacotes, como NuGet para .NET, npm para JavaScript, Maven para Java, entre outros
- a integração do Azure Artifacts com Azure Pipelines é outro recurso significativo, que permite automatizar a criação, teste e implantação de pacotes no decorrer de um pipeline de CI/CD; assegura que os artefatos de software sejam consistentemente construídos e distribuídos através de ambientes de desenvolvimento, teste e produção, contribuindo para um fluxo de trabalho de desenvolvimento mais eficiente e controlado. Essa melhora a eficiência e a colaboração entre as equipes de desenvolvimento, e assegura a entrega contínua de produtos de alta qualidade.
- ***alguns benefícios do Azure Artifacts***:
  - **Centralização de dependências**: mantenha todas as dependências em um repositório centralizado, facilitando o acesso e a gestão por parte de toda a equipe.
  - **Controle de versão**: gerencie versões de pacotes de forma eficaz, evitando conflitos e problemas de compatibilidade ao longo do ciclo de vida do desenvolvimento.
  - **Segurança e conformidade**: assegure que todos os pacotes usados nos seus projetos estejam em conformidade com as políticas de segurança e licenciamento da sua organização.

> Integrando Azure Artifacts ao ambiente de desenvolvimento, melhora não apenas a gestão de dependências e pacotes, mas também a colaboração e a eficiência das operações de DevOps. Isso leva a um processo de desenvolvimento mais ágil e bem controlado.

<div align="center">
<h2>2. VISÃO GERAL DO AZURE DEVOPS</h2>
</div>

## 2.1 Gerenciando projetos e equipes com eficiência no Azure Board

- o Azure DevOps é estruturado em três segmentos principais:
  - a) `Organização`: 
    - é um mecanismo para organizar e conectar grupos de projetos relacionados, como divisões de negócios, regionais ou outras estruturas empresariais. 
    - é possível criar uma organização para toda a empresa, para uso individual ou para unidades de negócios específicas, o que facilita o gerenciamento de permissões, políticas e a visibilidade dos processos em diferentes níveis da empresa, promovendo uma governança de TI eficiente e centralizada.
  - b) `Projeto`: 
    - um projeto no Azure DevOps contém diversos recursos, incluindo quadros e backlogs para planejamento ágil, pipelines para integração e implantação contínuas, repositórios para controle de versão e gerenciamento de código-fonte, além de integração contínua de testes em todo o ciclo de vida do projeto.
    - um projeto permite a configuração detalhada de segurança e controle de acesso, garantindo que somente usuários autorizados possam fazer alterações ou visualizar informações sensíveis. 
    - cada organização pode conter um ou mais projetos.
  - c) `Equipe`: 
    - uma equipe é uma unidade dentro do Azure DevOpsque suporta diversas ferramentas configuráveis pela própria equipe. 
    - essas ferramentas auxiliam no planejamento e gerenciamento do trabalho, facilitando a colaboração. 
    - cada equipe possui seu próprio backlog e pode configurar suas próprias sprints, estabelecer metas específicas e utilizar dashboards customizados para monitorar progressos e métricas chave.

## 2.2 Explorando e navegando nas organizações

- `Organizações` são estruturas que permitem agrupar e conectar projetos relacionados dentro do Azure DevOps, como divisões de negócios ou unidades regionais. 
- elas ajudam a gerenciar permissões, políticas e a visibilidade dos processos, promovendo uma governança centralizada e eficiente.
- passos para acessá-la no Azure DevOps:
  - a. Digite "Azure DevOps" na barra de pesquisa e, em seguida, clique na opção Azure DevOps Organizations.
  - b. Na janela do Azure DevOps, clique no link My Azure DevOps Organizations; inserir suas credenciais da conta @fiap.com.br, e será redirecionado para a página principal das suas Organizações no Azure DevOps.
  - c. Na janela seguinte, atualize o nome conforme necessário e clique em Continue para avançar para a próxima etapa.
  - d. Em seguida, clique no botão Create New Organization para iniciar o processo de criação de uma nova organização.
  - e. Clique em Continue para prosseguir com a criação da nova organização.
  - f. Na janela que aparece, informe o nome da organização (utilizando, por exemplo, o alias do e-mail). Em seguida, clique em Continue para avançar.
    - DICA: Para melhores práticas, considere utilizar o nome da empresa ao criar uma organização.
- Após criar a organização, você será levado para a tela de criação de um projeto. 
  - não se esqueça de verificar o canto superior esquerdo, onde o nome da nova organização estará visível.

> iMPORTANTE: Para acessar a URL da organização diretamente pelo navegador, use o padrão https://dev.azure.com/{Nome da Organização}. 

## 2.3 Criando e configurando um novo projeto












--- 

[Voltar ao início!](https://github.com/monicaquintal/smart_cities)