<div align="center">
<a href="https://github.com/monicaquintal" target="_blank"><img align="right" height="120px" src="../assets/logo.png" /></a>
<h1>FASE 6 - DevOps</h1>
<h2>Capítulo 05: Continuous Integration e Continuous Delivery.</h2>
</div>

<div align="center">
<h2>1. CONTINUOUS INTEGRATION E CONTINUOUS DELIVERY</h2>
</div>

## 1.1 Continuous Integration

- ***na ausência de CI***:
  - sem integração contínua, os desenvolvedores precisam coordenar e comunicar à mão quando estão contribuindo com código para o produto final.
  - esta coordenação vai além das equipes de desenvolvimento até operações, bem como o restante da organização. 
  - equipes de produto devem coordenar quando funções e correções vão ser lançadas em sequência e quais membros da equipe vão ser os responsáveis.
  - a comunicação excessiva em um ambiente sem integração contínua pode se tornar uma tarefa de sincronização complexa e intricada, que acrescenta custos burocráticos desnecessários ao projeto. 
  - as versões de códigos ficam mais lentas e com maiores taxas de falha, pois requer que os desenvolvedores sejam sensíveis e cuidadosos com relação às integrações. 
  - os riscos crescem muito conforme o tamanho da equipe de engenharia e da base de código aumenta.
  - sem um pipeline de integração contínua robusto, pode haver uma desconexão entre a equipe de engenharia e o restante da organização.
  - a comunicação entre o produto e a engenharia pode ser complicada. , dificultando estimar o tempo de entrega das solicitações, pois o tempo para integrar as novas alterações acaba sendo um risco desconhecido.
- a `integração contínua (Continuous Integration/CI)`:
  - é uma prática de software que requer a confirmação frequente de código em um repositório compartilhado, o que detecta erros mais cedo e reduz a quantidade de código que um desenvolvedor precisa depurar ao encontrar a origem de um erro. 
  - atualizações frequentes de código também facilitam a mesclagem de alterações de diferentes membros de uma equipe de desenvolvimento de software. 
  - desenvolvedores podem gastar mais tempo escrevendo código e menos tempo depurando erros ou resolvendo conflitos de mesclagem. 
  - ao comitar o código em seu repositório, você pode compilar e testar continuamente o código para garantir que o commit não introduza erros. 
  - seus testes podem incluir linters de código (que verificam a formatação de estilo), verificações de segurança, cobertura de código, testes funcionais e outras verificações personalizadas. 
  - construir e testar seu código requer um servidor; você pode criar e testar atualizações localmente antes de enviar o código para um repositório ou pode usar um servidor de CI que verifica novos commits de código em um repositório.

## 1.2 Continuous Delivery (CD)

- a Entrega contínua (CD) é um conjunto de práticas recomendadas ágeis e organizacionais anteriores bem-sucedidas. 
- a CD direciona uma empresa na criação de um processo simplificado e automatizado de lançamento de software.
- no centro desse processo há um ciclo de feedback iterativo, que gira em torno da entrega de software para o usuário final o mais rápido possível, aprendendo com sua experiência prática e, em seguida, incorporando esse feedback na próxima versão.
- a CD é uma abordagem na qual as equipes lançam produtos de qualidade com frequência e previsão do repositório do código fonte para produção de maneira automatizada. 

## 1.3 Aplicação

- você foi designado para implementar uma API desenvolvida em Java com Spring Boot, responsável pela gestão do cadastro de produtos.
- o código-fonte está hospedado no [GitHub](https://github.com/acnaweb/simple-api-java); é necessário que faça um Fork deste repositório. 
- a aplicação utiliza configurações definidas no arquivo application.properties para gerenciar a conexão com o banco de dados; dados de conexão ao servidor de bd, como usuário e senha, devem ser fornecidos por meio de variáveis de ambiente, o que aumenta a segurança e permite que a aplicação seja configurada de forma flexível em diferentes ambientes sem necessidade de alterações no código.

~~~
server.port=8080
spring.datasource.url=${DATABASE_URL}
spring.datasource.username=${DATABASE_USER}
spring.datasource.password=${DATABASE_PWD}
spring.jpa.show-sql=false
spring.jpa.open-in-view=true
~~~

- ao implementar CI/CD, garantirá que qualquer atualização no código seja automaticamente testada e, se bem-sucedida, entregue de forma contínua ao ambiente de produção. 
- isso agiliza o processo de desenvolvimento, além de reduzir o risco de erros na aplicação ao vivo.
















--- 

[Voltar ao início!](https://github.com/monicaquintal/smart_cities)