<div align="center">
<a href="https://github.com/monicaquintal" target="_blank"><img align="right" height="120px" src="../assets/logo.png" /></a>
<h1>FASE 6 - DevOps</h1>
<h2>Capítulo 08: Quality Assurance.</h2>
</div>

<div align="center">
<h2>1. QUALITY ASSURANCE</h2>
</div>

## 1.1 Papel do QA antes das metodologias ágeis (Cascata)

- `papel de QA`:
  - crucial no desenvolvimento de software, sendo responsável por garantir que um produto atenda aos padrões de qualidade e às expectativas dos usuários. 
  - o profissional de QA atua para assegurar que o software seja desenvolvido conforme os requisitos estabelecidos, funcione corretamente e esteja livre de defeitos. 
  - seu trabalho envolve definir e implementar práticas de qualidade, realizar testes sistemáticos e identificar e corrigir problemas ao longo do ciclo de vida do desenvolvimento. 
  - em essência, a função do profissional de QA é garantir que o produto final não apenas funcione de maneira eficaz, mas também ofereça uma experiência positiva ao usuário.

- `metodologias de desenvolvimento de software`:
  - as técnicas de criação de software são métodos sistemáticos empregados para planejar, estruturar e supervisionar a criação de sistemas de software. 
  - elas fornecem um conjunto de práticas, processos e regras que orientam as equipes de desenvolvimento para entregar produtos de qualidade de forma eficiente.
  - existem diversas técnicas de criação de software, cada uma com suas particularidades e abordagens próprias. 
  - dentre as metodologias mais populares, temos a metodologia em cascata e as metodologias ágeis. 
  - a metodologia em cascata, também chamada de waterfall, é uma abordagem linear e sequencial, onde cada etapa do desenvolvimento deve ser concluída antes que a próxima comece.
  - nesse contexto, o trabalho de Quality Assurance (QA) seguia uma abordagem estruturada, com o foco principal na garantia da qualidade nas fases finais do projeto. 
  - as atividades de verificação eram concentradas na fase de testes, onde rigorosos procedimentos eram realizados para assegurar que o sistema atendesse aos requisitos especificados. 
  - devido à natureza bem definida e sequencial das etapas do processo, o esforço era direcionado para a identificação e correção de defeitos apenas após a conclusão do desenvolvimento. 
  - essa abordagem, embora meticulosa, limitava a capacidade de adaptação a mudanças ou novos requisitos ao longo do projeto.

- `modelo cascata`:
  - composto por seis fases: requisitos, análise, design, codificação, testes e operações.
  - resumo das fases:
    - ***fase de requisitos***: todas as necessidades do sistema são coletadas e documentadas, abrangendo tanto requisitos funcionais quanto não funcionais. O objetivo é garantir que as expectativas do cliente sejam compreendidas e registradas de forma clara.
    - ***fase de análise***: esses requisitos são detalhados e avaliados quanto à sua viabilidade, transformando-os em especificações que orientarão a fase de design. Essa análise visa assegurar que os requisitos sejam tecnicamente e economicamente viáveis.
    - ***fase de design***: cria a arquitetura do sistema e detalha seus componentes, incluindo hardware, software, estrutura de dados e interfaces. O objetivo é planejar a implementação do sistema para que todos os requisitos sejam atendidos.
    - ***fase de codificação***: o código-fonte é desenvolvido com base no design, com programadores escrevendo e integrando o código, além de realizar testes unitários para garantir que tudo funcione corretamente.
    - ***fase de testes***: incluindo testes funcionais, de integração, de sistema e de aceitação pelo usuário. O objetivo é identificar e corrigir defeitos, garantindo que o sistema esteja pronto para entrega.
    - ***fase de operações***: o sistema é colocado em uso e são feitas correções e melhorias conforme necessárias. O objetivo é manter o sistema funcionando adequadamente e atender às necessidades dos usuários ao longo do tempo.

### 1.1.1 Como o QA assegura a qualidade no modelo cascata
- no contexto de QA, essas características do modelo cascata das fases serem sequenciais influenciam diretamente a forma como a qualidade do software é assegurada. 
- a natureza linear do modelo cascata significa que a fase de testes ocorre apenas após o desenvolvimento completo, utilizando frequentemente a ***abordagem black box***. 
  - nessa abordagem, as funcionalidades do programa são testadas de acordo com as especificações sem a necessidade de compreender a estrutura interna do software. 
  - isso permite que a equipe de QA avalie se o software atende às expectativas do usuário final.
- o QA também desempenha um papel vital no ***registro e relato de problemas***, onde defeitos identificados são documentados e comunicados à equipe de desenvolvimento para correção. 
- as ***inspeções e revisões*** entre as fases funcionam como pontos de controle críticos, garantindo que os critérios de qualidade sejam cumpridos antes de avançar para a próxima etapa.
- outro aspecto importante é a ***prevenção de defeitos***, que envolve a verificação cuidadosa da documentação técnica, especificações e design para evitar a introdução de erros desde o início. 
- já a ***contenção de defeitos*** se concentra em analisar onde e quando os problemas surgiram, avaliando a eficácia dos processos de QA e contribuindo para a melhoria contínua da qualidade do software.
- apesar da estrutura organizada e previsível do modelo cascata, os desafios no QA são evidentes:
  - a rigidez do processo dificulta a adaptação a mudanças e a detecção de problemas em fases avançada pode resultar em custos elevados e complicações. 
  - esses desafios sublinham as limitações do modelo cascata na garantia da qualidade, especialmente em ambientes de desenvolvimento dinâmicos e sujeitos a mudanças frequentes.

### 1.1.2 Desafios do QA no modelo cascata
- o modelo cascata apresenta desafios significativos para o QA devido à sua natureza linear e sequencial.
- nesse modelo, cada fase do desenvolvimento de software deve ser concluída antes que a próxima comece, o que pode criar problemas substanciais na garantia da qualidade. 
- a estrutura linear e a falta de flexibilidade do modelo cascata impactam diretamente a eficácia das atividades de QA, dificultando a detecção e correção de defeitos e limitando a capacidade de adaptação às mudanças.
- uma das principais desvantagens do modelo cascata é que os testes são realizados apenas no final do projeto, após a conclusão das fases de design e codificação. 
- essa abordagem limita a capacidade de retornar e modificar os requisitos, o que pode se tornar problemático se problemas significativos forem identificados durante os testes. 
- a ausência de uma etapa de testes contínuos impede a correção precoce de defeitos e pode levar a retrabalho considerável.
- além disso, uma vez que a fase de design é concluída, não é possível voltar e alterar os requisitos ou o design sem implementar mudanças significativas.
- essa falta de flexibilidade pode resultar em dificuldades para adaptar o software a novas necessidades ou correções inesperadas, especialmente em projetos maiores e mais complexos. 
- a rigidez do modelo cascata torna desafiador ajustar o projeto com base em feedback ou mudanças de escopo, limitando a capacidade de resposta a novos requisitos ou problemas emergentes.
- a dificuldade em estimar o tempo e o custo para cada fase também é exacerbada pela falta de flexibilidade do modelo cascata. 
- a necessidade de realizar modificações durante as fases posteriores pode levar a desafios na gestão de projetos e na entrega dentro dos prazos e orçamentos previstos. 
- com a natureza sequencial e inflexível do modelo, prever e controlar os custos e o cronograma se torna mais complexo, impactando a eficiência e o sucesso do projeto.
- portanto, a combinação da linearidade rígida, a limitação nos testes e a dificuldade em ajustar requisitos contribui para a complexidade do QA no modelo cascata, tornando o processo de garantir a qualidade mais desafiador e menos adaptável.
- dessa forma, o modelo cascata, com sua abordagem linear e sequencial, pode ser eficiente em projetos em que os requisitos são bem compreendidos e estáveis. 
- apesar das limitações, o modelo cascata foi amplamente usado e atendeu às necessidades de muitos projetos; contudo, com o surgimento das metodologias ágeis, um dos principais avanços foi a melhoria da abordagem de qualidade.
  - as metodologias ágeis introduziram práticas que permitiram uma maior flexibilidade e adaptação constante, abordando algumas das deficiências do modelo cascata. 
  - diferente do cascata, o modelo ágil adota uma metodologia mais flexível e iterativa, permitindo que as atividades de QA sejam integradas continuamente ao longo do ciclo de desenvolvimento.

## 1.2 Papel do QA na metodologia ágil (Scrum)

- `Scrum` é um framework de gerenciamento de projetos que auxilia as equipes a administrarem projetos complexos de forma organizada, aplicando um conjunto de valores, princípios e práticas. 
  - isso torna possível realizar entregas de alto valor em curtos períodos chamados sprints. 
  - Scrum destaca o desenvolvimento e a melhoria contínuos, o trabalho em conjunto de equipes multifuncionais e a avaliação e adaptação frequentes para atingir os melhores resultados.
- nesse contexto, QA atua de forma integrada ao processo, participando desde o planejamento inicial até a entrega final. 
  - diferente do modelo em cascata, onde o QA se concentrava nas fases finais, no scrum, o QA está envolvido em todas as etapas, colaborando com a equipe de desenvolvimento para identificar e prevenir defeitos precocemente.
  - o QA trabalha junto com os desenvolvedores durante cada sprint, garantindo que a qualidade seja incorporada ao produto de forma contínua, através de testes frequentes, revisões e feedback constante, o que permite uma resposta ágil a mudanças e melhorias incrementais no software.

- `resumo do modelo Scrum`:
  - no modelo Scrum, as cerimônias têm o objetivo de organizar o trabalho da equipe e garantir a entrega contínua de valor ao longo do projeto; essas etapas promovem colaboração, adaptação e melhoria contínua. 
  - no ***planejamento da sprint***, é definido o que será entregue e como o trabalho será realizado, estabelecendo o objetivo da sprint e o backlog que guiarão a equipe. 
  - diariamente, na reunião diária (***daily***), a equipe alinha o progresso, identifica impedimentos e ajusta o plano de ação para o dia, mantendo todos na mesma direção em relação ao objetivo da sprint. 
  - após a conclusão da sprint, ocorre a revisão (***review***), onde o incremento do produto é inspecionado, e o backlog é adaptado conforme necessário, incorporando feedback valioso dos stakeholders. 
  - em seguida, na retrospectiva (***retro***), a equipe reflete sobre o processo anterior, identifica melhorias e define ações concretas para otimizar o trabalho nas próximas sprints. 
  - por fim, durante a sprint, a equipe se dedica a completar o backlog e entregar um incremento de valor.
  - essas cerimônias, organizadas de forma cíclica e iterativa, garantem evolução contínua, flexibilidade e valor no desenvolvimento de software.
  - as fases do Scrum, organizadas de maneira cíclica e iterativa, garantem que o projeto esteja sempre em evolução, com entregas contínuas e melhorias constantes.

- `papel do QA`:
  - diferente do modelo cascata, onde os testes são realizados após o desenvolvimento, o scrum integra os testes de forma contínua e iterativa ao longo de todo o ciclo de vida do projeto, o que permite que a qualidade seja assegurada em cada etapa do desenvolvimento.
  - no ***planejamento da sprint (Planning)***, o QA colabora com o Product Owner e a equipe de desenvolvimento para entender os requisitos e definir os critérios de aceitação para os itens do backlog; essa colaboração inicial é crucial para garantir que os objetivos de qualidade sejam claros e alinhados desde o começo.
  - nas ***reuniões diárias (Daily)***, o QA se mantém atualizado sobre o progresso dos testes e comunica rapidamente qualquer problema encontrado, ajudando a resolver impedimentos que possam impactar a qualidade do produto; essa comunicação contínua assegura que o trabalho da equipe esteja em sintonia com os padrões de qualidade estabelecidos.
  - durante a ***revisão da sprint (Review)***, o QA valida o incremento do produto para garantir que ele atenda aos requisitos e critérios de aceitação estabelecidos. Isso inclui verificar se as funcionalidades desenvolvidas foram testadas adequadamente e se estão prontas para entrega.
  - na ***retro (Retrospectiva)***, o QA oferece feedback sobre o processo de testes e sugere melhorias para aumentar a eficiência e a eficácia dos testes nas próximas sprints. Esse momento de reflexão é vital para ajustar práticas e assegurar que a qualidade continue a melhorar a cada ciclo.
  - além dessas cerimônias, a ***automação de testes*** é um aspecto crítico do papel do QA no Scrum: ela aumenta a cobertura dos testes e a eficiência do processo, garantindo que os testes sejam executados de maneira rápida e consistente em um ambiente de desenvolvimento ágil; algumas ferramentas amplamente utilizadas para criar e executar scripts de teste automatizados:
    - ferramentas e frameworks como Selenium, para automação de testes de interface; 
    - JUnit e TestNG, para testes unitários em Java; 
    - e PyTest, para testes em Python
  - ***testes de regressão automatizados*** são essenciais para assegurar que novas mudanças no código não introduzam defeitos em funcionalidades existentes. 
    - frameworks como JMeter são utilizados para testes de performance, garantindo que o sistema opere de forma eficiente sob diferentes condições de carga. 
    - Cypress e Appium são populares para a automação de testes de interface, assegurando que a experiência do usuário seja satisfatória em diversas plataformas e dispositivos.
  - no modelo Scrum, o QA é integrado a cada etapa do ciclo de desenvolvimento, colaborando continuamente com a equipe para garantir que a qualidade seja uma prioridade desde o planejamento até a entrega final. 
    - essa abordagem iterativa e colaborativa permite identificação e correção ágil de problemas, promovendo a melhoria contínua e contribuindo significativamente para o sucesso do projeto. 
  - no final de cada sprint, o QA fornece feedback rápido e iterativo sobre a qualidade do incremento, permitindo ajustes e melhorias antes que os problemas se tornem mais complexos e caros. 
  - além disso, mantém uma documentação detalhada dos testes, garantindo que as práticas e resultados possam ser repetidos e analisados em sprints futuras, contribuindo para a continuidade e aprimoramento do processo de QA. 

### 1.2.2 Desafios do QA no modelo ágil Scrum
- apesar dos diversos benefícios que o Scrum oferece para o desenvolvimento ágil de software, ele também apresenta desafios específicos para a função de QA. 
- a natureza iterativa e incremental do Scrum pode impactar significativamente as atividades do QA, trazendo tanto oportunidades quanto dificuldades.
- no Scrum, os testes são realizados de forma contínua ao longo de cada sprint, com o objetivo de validar os incrementos regulares do produto. 
  - a equipe de QA precisa adaptar suas práticas para se alinhar a essa abordagem iterativa. 
  - essa necessidade de realizar testes contínuos pode ser desafiadora, especialmente quando as mudanças no produto ocorrem rapidamente. 
  - a adaptação constante dos testes pode resultar em um aumento da complexidade e do esforço necessário para manter a qualidade.
- outra dificuldade é o gerenciamento de mudanças de requisitos.
  - o Scrum permite que os requisitos evoluam com base no feedback contínuo dos stakeholders e nas revisões de sprint, o que pode levar a alterações frequentes e imprevisíveis durante o desenvolvimento.
  - alterações frequentes podem complicar a criação e manutenção de testes abrangentes, exigindo que o QA atualize constantemente os testes para refletir as mudanças nos requisitos.
- além disso, os desafios com testes automatizados são notáveis. 
  - embora a automação de testes seja uma prática comum no Scrum para lidar com a frequência e a repetitividade dos testes, a configuração e manutenção desses testes exigem um esforço significativo. 
  - a complexidade do produto e a necessidade de testes contínuos podem aumentar a carga de trabalho relacionada à automação. 
  - a equipe de QA deve garantir que os testes automatizados permaneçam alinhados com as mudanças frequentes do produto, o que pode exigir ajustes constantes e investimentos adicionais em ferramentas e infraestrutura.

- apesar desses desafios, o Scrum oferece `vantagens significativas` para o QA. 
  - a integração contínua de testes permite identificar e corrigir problemas de forma ágil, o que contribui para a melhoria contínua e a entrega de um produto de maior qualidade.
  - a colaboração constante entre QA e equipe de desenvolvimento garante que todos estejam alinhados quanto aos requisitos e à qualidade, enquanto a automação de testes, apesar de seu custo inicial, aumenta a eficiência e a cobertura dos testes, permitindo uma validação rápida e consistente das funcionalidades. 
  - essas vantagens ajudam a garantir que o produto final não apenas atenda, mas frequentemente supere as expectativas dos clientes. 

### 1.2.3 Ferramentas de QA em Modelos Ágeis
- ferramentas de teste de software fornecem recursos necessários para realizar verificações rigorosas e automatizadas em diversos aspectos do software. 
- essas ferramentas facilitam a execução eficiente dos testes, além de assegurar que o produto final atenda aos padrões de qualidade esperados. 
- algumas ferramentas de mercado que ajudam o QA a alcançar esses objetivos:
  - `ferramentas de gestão de testes`: são indispensáveis para organizar e gerenciar o processo de testes em ambientes ágeis. 
    - ***TestRail***, utilizado por empresas como Cisco, permite uma organização e rastreamento eficaz dos ciclos de teste, aumentando a transparência e eficiência em ambientes complexos.
    - ***qTest***, adotado por organizações como Samsung, se integra com ferramentas como JIRA, melhorando significativamente a comunicação e visibilidade entre as equipes de desenvolvimento e QA.
  - `automação de testes`: 
    - ***Selenium***, escolhido por gigantes como Google e IBM, é ideal para testes de regressão dado seu suporte a múltiplos navegadores e sistemas operacionais. 
    - ***Cypress***, utilizado por empresas como Slack e GitHub, destaca-se por sua capacidade de realizar testes rápidos e eficazes diretamente no navegador, facilitando a avaliação de aplicações web modernas.
  - `integração contínua`:
    - ***Jenkins***, amplamente utilizado por organizações como NASA, é conhecido por sua extensibilidade e integração com uma vasta gama de ferramentas de desenvolvimento.
    - ***CircleCI***, empregado por empresas como Spotify, oferece uma solução robusta e escalável na nuvem, facilitando builds e deploys automatizados de forma eficiente.
  - `performance e a escalabilidade`: 
    - ***JMeter***, uma opção open-source utilizada por empresas como AOL, é adequado para testes de carga em aplicações web. 
    - ***LoadRunner***, escolhido pela Adobe, proporciona um ambiente controlado para testes de stress extensivos, assegurando que os produtos operem com alta qualidade e estabilidade sob diversas condições de uso.
  - `teste de segurança`:
    - ***OWASP ZAP***, uma ferramenta open-source usada por empresas como ThoughtWorks, é crucial para identificar vulnerabilidades em fases iniciais de desenvolvimento. 
    - ***Burp Suite***, empregado por Symantec, realiza testes de penetração profundos, garantindo a robustez e a segurança das soluções.

## 1.3 Inovação e futuro do QA

- a inteligência artificial (IA) possui um potencial transformador significativo para o Quality Assurance (QA), oferecendo métodos mais avançados e eficazes para assegurar a qualidade do software.
  - entre as aplicações da IA no QA, destaca-se a priorização de testes, que se beneficia profundamente dos algoritmos de aprendizado de máquina (ML), os quais têm a capacidade de analisar históricos de falhas e padrões de código para identificar quais cenários apresentam maior probabilidade de conter defeitos.
- além disso, a IA está promovendo avanços na automação da criação de casos de teste; ela ajusta os testes automaticamente conforme o código evolui.
- outro aspecto relevante é a geração de cenários de carga e estresse, essencial para avaliar a capacidade do aplicativo de lidar com grandes volumes de usuários ou dados. 
  - a IA pode automatizar a criação desses cenários, testando como o sistema responde sob condições de alta demanda.
- essas inovações proporcionam um ciclo de feedback mais ágil e eficiente, alinhando-se perfeitamente com os princípios ágeis de adaptação contínua e entrega rápida. 
- a integração de IA e ML não só melhora a precisão e a eficácia dos testes, mas também contribui para a evolução contínua das práticas de QA no desenvolvimento de software.

### 1.3.1 Como testar sistemas de inteligência artificial e aprendizado de máquina 
- os produtos e sistemas que utilizam inteligência artificial (IA) e aprendizado de máquina (ML) são, por natureza, mais complexos do que os tradicionais, devido à sua capacidade de aprender e se adaptar com base em dados. 
- o QA precisará de novas estratégias para testar esses sistemas dinâmicos e garantir que eles funcionem conforme o esperado em diferentes cenários e condições.
- isso vai incluir a validação de que o modelo está aprendendo corretamente com os dados, não introduzindo viés e fornecendo resultados consistentes e precisos não deixando passar falsos positivos ou falsos negativos.
  - ***falso positivo*** ocorre quando o sistema identifica incorretamente uma condição como verdadeira quando, na realidade, é falsa. Por exemplo, em um sistema de detecção de fraudes em transações financeiras, um falso positivo ocorreria se o sistema marcasse uma transação legítima como suspeita de fraude. 
  - ***falso negativo*** acontece quando o sistema falha em identificar corretamente uma condição que é verdadeira. No contexto do mesmo sistema de detecção de fraudes, um falso negativo ocorreria se o sistema não identificasse uma transação realmente fraudulenta como suspeita. 

- exemplo: sistema de reconhecimento facial que utiliza IA e ML para identificar e autenticar usuários com base em selfies tiradas por meio de um aplicativo.
  - o objetivo é garantir que o sistema seja preciso e confiável na identificação das pessoas em diferentes cenários. 
  - para alcançar esse objetivo, é essencial realizar diversos tipos de testes que avaliem o desempenho do sistema em situações variadas.
  - vamos pensar primeiramente em um ***cenário de comparação entre selfies de diferentes pessoas***, sendo seu objetivo validar a capacidade do sistema de reconhecimento facial em distinguir corretamente entre diferentes indivíduos. Para isso, o cenário de teste consiste em tirar uma selfie da pessoa A e outra da pessoa B. O que se espera é que o sistema identifique corretamente que as imagens pertencem a pessoas diferentes e evite qualquer correspondência incorreta.
    - os tipos de casos de teste a serem realizados incluem a verificação da similaridade visual entre as imagens, o que envolve checar se o sistema consegue identificar a diferença entre as duas imagens, levando em consideração variações na iluminação, no ângulo e na expressão facial. 
    - é fundamental que o sistema mantenha a precisão na distinção entre indivíduos, mesmo quando as imagens apresentam condições de captura variadas.
    - além disso, é necessário avaliar a eficácia dos algoritmos de distância facial utilizados pelo sistema. O objetivo é garantir que esses algoritmos não confundam indivíduos diferentes e, portanto, não gerem falsos positivos.
  - outro ótimo exemplo de cenário seria ***testar a comparação entre selfie e foto de um objeto inanimado***.
    - para realizar o teste, uma selfie da pessoa A deve ser tirada, assim como uma foto separada de um objeto inanimado, como um livro, cadeira ou uma bola de futebol.
    - o que se espera é que o sistema reconheça que a imagem do objeto inanimado não corresponde a uma pessoa e, portanto, não tente fazer uma correspondência.
    - além disso, deve-se avaliar a robustez do sistema ao lidar com entradas que não se enquadram nos tipos de imagens que ele deve reconhecer. 
  - outro cenário de teste seria o ***teste de variabilidade de características***, cujo objetivo é verificar se o sistema de reconhecimento facial pode identificar corretamente a mesma pessoa, mesmo quando ela está usando diferentes acessórios ou apresenta variações visuais. 
    - para avaliar o sistema, é essencial realizar testes de reconhecimento sob condições variadas.
    - além disso, é importante testar a robustez do sistema em condições de aparência para garantir que ele mantenha a precisão na identificação, mesmo com mudanças na aparência, como alterações no estilo de cabelo, uso de maquiagem ou outros acessórios que possam modificar a aparência facial.

---

## FAST TEST

### 1. Qual o papel do profissional de Quality Assurance no desenvolvimento de software?
> Garantir que um produto atenda aos padrões de qualidade e às expectativas dos usuários.

### 2. Assinale a afirmativa verdadeira:
> No modelo Scrum, o Quality Assurance (QA) é integrado a cada etapa do ciclo de desenvolvimento, colaborando continuamente com a equipe para garantir que a qualidade seja uma prioridade desde o planejamento até a entrega final.

--- 

[Voltar ao início!](https://github.com/monicaquintal/smart_cities)