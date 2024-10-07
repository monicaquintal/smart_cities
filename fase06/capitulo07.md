<div align="center">
<a href="https://github.com/monicaquintal" target="_blank"><img align="right" height="120px" src="../assets/logo.png" /></a>
<h1>FASE 6 - DevOps</h1>
<h2>Capítulo 07: Hora do Compliance.</h2>
</div>

<div align="center">
<h2>1. HORA DO COMPLIANCE</h2>
</div>

## 1.1 O que é qualidade de software?

- qualidade de software é essencial para garantir que um produto atenda às necessidades e expectativas dos usuários, proporcionando uma experiência satisfatória e confiável. 
- softwares de alta qualidade oferecem uma série de benefícios, como a redução de bugs, que causam frustração e diminuem a confiança no produto. 
  - um software bem projetado e testado minimiza esses problemas, oferecendo uma experiência de uso mais fluida e agradável.
- além disso, a qualidade de software ajuda a minimizar os custos de manutenção. 
  - quando um software for desenvolvido com boas práticas de engenharia e exaustivamente testado antes do lançamento, os problemas são detectados e corrigidos precocemente, reduzindo a necessidade de constantes atualizações e correções de bugs após o lançamento, economizando tempo e recursos.
- o último ponto, embora não menos relevante, é o aumento da confiança do usuário. 
  - usuários que percebem que um software é confiável e funciona conforme esperado tendem a usá-lo com mais frequência e a recomendá-lo a outros, o que impacta diretamente o sucesso comercial de um produto. 
  - usuários satisfeitos são mais propensos a continuar usando o software, adquirir atualizações ou serviços adicionais e falar positivamente sobre o produto.

### 1.1.1 Exemplos práticos de impacto da qualidade de software

- a qualidade de software deve ser uma preocupação constante, garantindo uma experiência satisfatória e confiável para todos os usuários, independentemente da finalidade do software.

### 1.1.2 Entendendo bugs

- trata-se de um erro ou defeito no código ou na lógica do software que causa um comportamento indesejado ou inesperado. 
- outro ponto importante é o processo de depuração, ou "debugging": quando
estamos debugando um código, estamos nos referindo ao processo de localizar e corrigir erros ou bugs no código-fonte de um software. 
- quando o software não funciona conforme o esperado, os desenvolvedores analisam o código em modo debug para determinar as causas dos erros. 
- debug é uma prática essencial na programação, pois permite identificar, corrigir e prevenir bugs em códigos das mais diferentes naturezas.
- os bugs de software podem ser classificados de algumas maneiras, dependendo de seu impacto, origem ou natureza, sendo alguns dos tipos mais comuns:
  - A. `Bugs funcionais`: relacionados a funcionalidades específicas do software que não funcionam conforme o esperado. Um exemplo clássico seria um botão que deveria salvar dados, mas não realiza essa operação.
  - B. `Bugs de desempenho`: afetam diretamente a velocidade e a eficiência do software. Por exemplo, um aplicativo que demora muito tempo para carregar ou processar dados é um caso típico desse tipo de bug, onde o desempenho inadequado pode comprometer a experiência do usuário e a funcionalidade geral do sistema.
  - C. `Bugs de interface do usuário (UI)`: envolvem problemas na interface gráfica que afetam a usabilidade. Por exemplo, elementos da interface que estão fora de lugar ou botões que não respondem ao clique.
  - D. `Bugs de segurança`: referem-se a vulnerabilidades no software que podem ser exploradas para comprometer sua segurança. Um exemplo clássico desse tipo de bug é uma falha que permite o acesso não autorizado a dados sensíveis, colocando em risco a integridade e a confidencialidade das informações armazenadas no sistema.
  - E. `Bugs de compatibilidade`: ocorrem quando o software não funciona corretamente em diferentes ambientes ou dispositivos. Um exemplo seria um aplicativo que opera bem no iOS, mas apresenta problemas no Android.
  - F. `Bugs de conectividade`: são problemas que surgem na comunicação entre o software e outras aplicações ou redes. Um exemplo comum é a falha na conexão com um servidor ou a dificuldade de integrar corretamente com APIs de terceiros, o que pode interromper o fluxo de dados e impactar a funcionalidade do software.
  - G. `Bugs de dados`: dizem respeito a problemas na manipulação e armazenamento de dados, como quando dados são corrompidos durante a gravação ou informações são lidas incorretamente do banco de dados.
  - H. `Bugs de lógica`: ocorrem quando há falhas na lógica de programação, resultando em resultados incorretos. Um exemplo típico é um cálculo matemático que retorna um resultado errado devido a um erro na fórmula implementada, o que pode levar a comportamentos inesperados e comprometer a funcionalidade do software.
  - I. `Bugs de usabilidade`: afetam a facilidade com que os usuários interagem com o software. Um exemplo é um fluxo de navegação confuso ou difícil de entender, que pode dificultar a experiência do usuário e tornar o software menos intuitivo e acessível.
  - J. `Bugs de instalação`: são problemas que afetam a instalação ou atualização do software. Um exemplo é uma falha durante o processo de instalação que impede que o software seja instalado corretamente, o que pode impedir o usuário de utilizar o produto.
  - K. `Bugs de integração`: surgem quando diferentes módulos ou sistemas são combinados e enfrentam problemas. Um exemplo é quando módulos funcionam bem de forma independente, mas falham ao serem integrados, o que pode comprometer a funcionalidade geral do sistema.

- entender os tipos de bugs e como podem ocorrer em um produto são aspectos cruciais para a qualidade e a eficácia de qualquer software. 
- diferentes tipos de bugs afetam várias dimensões do produto, desde funcionalidades e desempenho até a usabilidade e segurança. 
- a compreensão desses diversos problemas permite uma abordagem mais estruturada na identificação e correção, garantindo que o software atenda aos padrões esperados e ofereça uma experiência satisfatória ao usuário.

### 1.1.3 Entendendo os tipos de testes

- testes de software são essenciais para garantir que um produto atenda aos requisitos de qualidade e funcione conforme esperado. 
- cada tipo de teste desempenha um papel específico no ciclo de desenvolvimento, e entender suas características ajuda a assegurar um software robusto e confiável.

- 1. `testes de unidade`:
  - realizados no nível do código-fonte e focados em métodos e funções individuais.
  -  são conhecidos por sua automação eficiente, rápida execução e facilidade de diagnóstico.
  - exemplo: um teste de unidade pode verificar se uma função que soma dois números retorna o resultado correto, garantindo que a função retorne 8 ao somar 3 e 5.
- 2. `testes de integração`:
  - complementam os testes de unidade ao avaliar como diferentes módulos ou serviços interagem quando combinados. 
  - esses testes identificam problemas nas interfaces entre módulos, como incompatibilidades de dados ou falhas de comunicação. 
  - exemplo: em um aplicativo de lista de tarefas, um teste de integração verificaria se uma nova tarefa adicionada aparece corretamente na lista, garantindo que os módulos de adicionar e exibir tarefas funcionem bem juntos.
- 3. `testes funcionais`:
  - focam nos requisitos de negócios da aplicação. 
  - eles avaliam se a aplicação atende às especificações fornecidas, concentrando-se na saída resultante de uma ação específica, sem considerar os estados intermediários do sistema. 
  - por exemplo, em um aplicativo de reservas de restaurantes, um teste funcional pode verificar se a funcionalidade de reserva de mesa está operando corretamente, garantindo que a confirmação seja enviada ao usuário com as informações corretas.






              
--- 

[Voltar ao início!](https://github.com/monicaquintal/smart_cities)
