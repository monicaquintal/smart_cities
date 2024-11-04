<div align="center">
<a href="https://github.com/monicaquintal" target="_blank"><img align="right" height="120px" src="../assets/logo.png" /></a>
<h1>FASE 7 - Emerging Technologies</h1>
<h2>Capítulo 04: A arquitetura das... Coisas!</h2>
</div>

<div align="center">
<h2>1. A ARQUITETURA DAS... COISAS!!</h2>
</div>

- a `IoT` é a mola propulsora do ecossistema da Internet de Todas as Coisas (IoE), a qual integra pessoas, dados, processos e coisas. 
- a Figura a seguir representa de uma forma mais estruturada todos os blocos e as interligações que compõem a IoT.

<div align="center">
<img src="./assets/cap04-mapa-mental-iot.png" witdh="80%"><br>
<em>Mapa Mental da IoT.</em><br>
</div>

- um dos principais desafios é o fator de interoperabilidade, haja vista a infinidade de dispositivos interconectados, tanto em termos de hardware quanto em termos de software, protocolos (muitos deles proprietários) e formatos de dados.
- o termo padronização faz uma diferença significativa para escalonar e dimensionar todo esse crescimento exponencial de geração de dados nesse arcabouço tecnológico.

## 1.1 Arquitetura dos dispositivos inteligente

- de uma forma minimalista, os dispositivos inteligentes (smart things) são compostos de: processamento/memória, comunicação, energia e sensores/atuadores.

<div align="center">
<img src="./assets/cap04-arquitetura-dispositivo-inteligente.png" witdh="40%"><br>
<em>Arquitetura de um dispositivo inteligente.</em><br>
</div>

- sendo: 
  - ***Unidade de processamento/memória***: composta de uma memória interna para armazenamento de dados e programas, um microcontrolador (arduino, por exemplo) e um conversor analógico-digital para receber sinais dos sensores. Geralmente não apresenta alto poder computacional, sendo bastante desejável que haja baixo consumo de energia e ocupe o menor espaço possível.
  - ***Rádio***: consiste em pelo menos uma tecnologia de comunicação com ou sem fio (normalmente rádio de baixo custo e potência).
  - ***Fonte de energia***: responsável por fornecer energia aos componentes do dispositivo inteligente (bateria, conversor AC/DC ou painel fotovoltaico).
  - ***Sensor/Atuador***: responsável pelo monitoramento do ambiente no qual o dispositivo se encontra. Os sensores capturam valores de grandezas físicas,como temperatura, umidade, pressão e presença. Já os atuadores produzem alguma ação, atendendo a comandos que podem ser manuais, elétricos ou mecânicos. 

## 1.2 Tecnologias de comunicação

- para um objeto inteligente existir na Internet, é necessário que a ele seja atribuído um endereçamento IP (Internet Protocol), o que é possível graças aos meios pelos quais as mensagens trafegam (por exemplo, ar, cobre, luz) e utilizando-se um conjunto de regras conhecidas como protocolos.
- independente dos protocolos, é preciso justificar qual(is) meio(s) seria(m) mais adequado(s) para as transmissões de dados vindos dos objetos inteligentes.
- embora a combinação entre tecnologia sem fio e IPv6 (Internet Protocol versão 6) seja uma solução para vários dos objetos inteligentes, não é aplicável para todos os casos.
  - as conexões no padrão WiFi(padrões 802.11b/g/n), comuns em smartphones e smart TVs, são custosas do ponto de vista energético. 
- a aplicação prática do conceito de IoT no mundo real é possível por meio do uso e da integração de várias tecnologias essencialmente sem fio. 
- dentre as existentes, temos: RFID (Radio-Frequency Identification),Near Field Communication (NFC), Bluetooth e iBeacons.

### 1.2.1 RFID: identificação por radiofrequência
- apesar do surgimento de tecnologias inovadoras como o Bluetooth, a resposta para o problema de interoperabilidade das coisas em longa distância e com baixo consumo de energia se encontra em uma tecnologia inventada no fim do século XIX: o rádio.
- a comunicação por radiofrequência emprega radiação eletromagnética para transmissão de informação, sendo essa radiação uma consequência da oscilação do campo eletromagnético. 
  - a própria luz visível é uma radiação eletromagnética, assim como as ondas de rádio emitidas pelas emissoras de rádio e TV ou as ondas que um aparelho de micro-ondas usa para aquecer um alimento. 
  - a diferença entre elas está em suas frequências, ou seja, a rapidez com que as ondas “vibram”.
- para o uso específico de transmissão de informações a sensores de IoT,existe a tecnologia RFID (Radio-Frequency Identification, ou identificação por radiofrequência).
- a identificação por radiofrequência surgiu durante a Segunda Guerra Mundial, quando aviões britânicos foram equipados para devolver um sinal específico que osidentificava como aeronaves aliadas, diferenciando-os dos aviões alemães, em um sistemaque ficou conhecido como IFF (Identification Friend-or-Foe).
- o RFID moderno funciona de acordo como mesmo princípio: um transceptor emite um sinal eletromagnético para um transponder (ou também para a conhecida etiqueta RFID), que recebe o sinal, processa, eventualmente grava alguma informação e o retorna para o mesmo transceptor (ou leitora), equipado com uma antena.
- existem três tipos de etiqueta RFID: as passivas, as semipassivas e as ativas.
9












--- 

[Voltar ao início!](https://github.com/monicaquintal/smart_cities)