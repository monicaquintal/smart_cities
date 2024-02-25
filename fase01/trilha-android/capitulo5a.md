<div align="center">
<a href="https://github.com/monicaquintal" target="_blank"><img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/kotlin/kotlin-original.svg" width="100px" align="left"/></a>
<h1>FASE 1 - APP WORLD</h1>
<h2>Capítulo 5A: Layouts e componentes básicos no Jetpack Compose.</h2>
</div>

<div align="center">
<h2>1. LAYOUTS E COMPONENTES BÁSICOS NO JETPACK</h2>
</div>

- o Jetpack Compose fornece vários elementos de layout para criar IUs interessantes e intuitivas para o usuário. 
- quando estamos construindo uma IU, é necessário inserirmos vários componentes como textos, botões, caixas de seleção, etc. Se não fornecemos as instruções de como esses componentes dever ser organizados, o resultado não será como desejamos.

## 1.1 Box

- utilizado para agrupar outros composables, como textos e botões, dentro de uma área retangular. 
- podemos comparar o Box a uma DIV no HTML, ou seja, é um container de composables, mas que sabe como posicioná-los de acordo com as orientações do programador.
- para praticar o uso do composable "Box", criado o projeto Composable no Android Studio chamado [BoxApp](./projects/BoxApp/app/src/main/java/br/com/fiap/boxapp/MainActivity.kt), com a estrutura inicial:

~~~kotlin
class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      BoxAppTheme {
        // A surface container using the 'background' color from the theme
        Surface(
          modifier = Modifier.fillMaxSize(),
          color = MaterialTheme.colors.background
        ) {

        }
      }
    }
  }
}
~~~

- criar uma função de composição chamada "BoxScreen", e inserir o nome "FIAP" na IU.

~~~kotlin
@Composable
fun BoxScreen() {
  Box {
    Text(text = "FIAP")
  }
}
~~~

- no método "onCreate", chamar a função composable na função "setContent".

~~~kotlin
class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      BoxAppTheme {
        // A surface container using the 'background' color from the theme
        Surface(
          modifier = Modifier.fillMaxSize(),
          color = MaterialTheme.colorScheme.background
        ) {
            BoxScreen()
        }
      }
    }
  }
}

@Composable
fun BoxScreen() {
  Box {
    Text(text = "FIAP")
  }
}
~~~

### a) parâmetro "contentAlignment":
- permite alinhar o conteúdo em qualquer lado do "Box". 
- passá-lo dentro dos parênteses da função.
- valores:
  - `TopStart`: ("no topo ao início"), ***é o padrão***, posiciona o texto no canto superior esquerdo.
  - `Alignment.Center`: constante da Classe 'Alignment', que faz o alinhamento central dos componentes.

~~~kotlin
@Composable
fun BoxScreen() {
  Box(contentAlignment = Alignment.Center) {
    Text(text = "FIAP")
  }
}
~~~

  - `Alignment.TopEnd`: o texto estará alinhado ao topo e do lado direito da Box.

~~~kotlin
@Composable
fun BoxScreen() {
  Box(contentAlignment = Alignment.TopEnd) {
    Text(text = "FIAP")
  }
}
~~~

> Caso adicione outros elementos nesta Box, como um botão, esses componentes serão empilhados no interior da Box, então o primeiro componente ficará na primeira "Camada", o segundo na segunda camada, e assim por diante. 

## 1.2 Alinhando vários componentes na Box

- os composables dentro de uma Box estão sobre o escopo da Box, então, obedecem a este escopo.
- porém, os composables possuem um parâmetro chamado "modifier", que permite alterar características do componente, inclusive sua posição dentro da Box. 
  - quando alteramos, no composable, um parâmetro herdado do composable pai, este tem prioridade, permitindo alinhar cada composable dentro de uma Box individualmente utilizando seu modificador.
- exemplo:

~~~kotlin
@Composable
fun BoxScreen() {
  Box(contentAlignment = Alignment.TopEnd) {
    Button(
      onClick = { /*TODO*/ },
      modifier = Modifier.align(Alignment.BottomEnd)
    ) {
      Text(text = "Clique aqui")
    }
    Text(
      text = "FIAP",
      modifier = Modifier.align(Alignment.TopStart)
    )
  }
}
~~~

> No Jetpack Compose, o "modifier" é um dos principais recursos para alterar a aparência e o comportamento de um composable. Os modificadores permitem adicionar efeitos visuais, como tamanho, cor, espaçamento, dentre outros.

## 1.3 Controle de posicionamento utilizando "offset"

- também é possível movimentar os componentes dentro da Box utilizando coordenadas x e y.
- não é a melhor e mais eficiente forma de posicionar componentes, mas, às vezes é necessário para fazer algum efeito visual. 
- exemplo: botão posicionado em x=150.dp e y=120.dp.

~~~kotlin
@Composable
fun BoxScreen() {
    Box(contentAlignment = Alignment.TopEnd) {
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier.align(Alignment.BottomEnd)
        ) {
            Text(text = "Clique aqui")
        }
        Text(
            text = "FIAP",
            modifier = Modifier.align(Alignment.TopStart)
        )
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 150.dp, y=120.dp)
        ) {
            Text(text = "Outro botão")
        }
    }
}
~~~

> é importante ressaltar que a posição x = 0 e y = 0 sempre levará em conta a posição inicial de composição do componente. Portanto, se estiver utilizando "BottomEnd", a movimentação ocorrerá a partir deste ponto.

## 1.4 Column e Row

- são os composables de layout mais utilizados.
- permitem que posicionemos os componentes de nossa IU lado a lado, na horizontal ou na vertical, na ordem em que são inseridos no código.
- criado o projeto Jetpack Compose no Android Studio chamado [Column Row](./projects/ColumnRow/app/src/main/java/br/com/fiap/columnrow/MainActivity.kt).
- criar a função de composição chamada "ColomnRowScreen".
  - em relação ao "Surface", o primeiro componente estrutural, não precisamos inseri-lo agora, pois já faz parte da IU de forma padrão, e ocupa todo o tamanho da tela do dispositivo devido ao parâmetro modificador "modifier = Modifier.fillMaxSize()". 
- iniciar pelos composables mais externos:

~~~kotlin
@Composable
fun ColumnRowScreen() {
  // Column principal
  Column(modifier = Modifier.fillMaxSize()) { // 
    Column(modifier = Modifier.fillMaxWidth()) {

    }
    Row(modifier = Modifier.fillMaxWidth()) {

    }
    Row(modifier = Modifier.fillMaxWidth()) {
      
    }
  }
}
~~~

- observações: 
  - a primeira Column ocupará todo o tamanho da tela, por isso o seu modificador recebe o valor "fillMaxSize".
  - dentro da primeira Column haverá uma Column que ocupará toda a largura do componente pai, que é a primeira Column. Sua altura será dinâmica, ou seja, vai expandir de acordo com o conteúdo.
  - em seguida, inserimos duas "Rows", que ficarão uma abaixo da outra.
  - no interior da última "Row", inserir duas "Columns", que ficarão lado a lado, já que o seu componente pai é uma "Row".

~~~kotlin 
@Composable
fun ColumnRowScreen() {
    // Column principal
    Column(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxWidth()) {
            // Conteúdo
        }
        Row(modifier = Modifier.fillMaxWidth()) {
            // Conteúdo
        }
        Row(modifier = Modifier.fillMaxWidth()) {
            Column() {
                // Conteúdo
            }
            Column() {
                // Conteúdo
            }
        }
    }
}
~~~

## 1.5 Modifier

- é uma classe que permite modificar os estilos de um composable, como tamanho, cor, posicionamento, espaçamento, dentre outros. 
- permite encadear vários modificadores para alterar a aparência de um composable, além do seu comportamento. 
- as modificações são aplicadas na ordem em que você as declara.
- modificadores mais utilizados:
  - padding(): adiciona um espaçamento interno ao redor do composable.
  - size(): define o tamanho do composable.
  - offset(): define a posição do composable dentro do seu contêiner pai.
  - clickable(): torna o composable clicável e permite adicionar uma ação ao ser clicado.
  - background(): define a cor de fundo do composable.
  - fillMaxWidth(), fillMaxHeight(): faz com que o composable ocupe todo o espaço disponível no eixo horizontal ou vertical, respectivamente.
  - fillMaxSize(): faz com que o composable ocupe todo o espaço disponível na tela.
  - align(): alinha o composable dentro do seu contêiner pai.
  - weight(): controla a distribuição do espaço disponível entre vários composables dentro de um contêiner.

### 1.5.1 Exemplo de aplicação - Modifier

- na primeira Column, colocar uma cor de fundo (background) na cor ciano.
- o Surface declara um modificador com o valor "Modifier.fillMaxSize()", que faz com que ele ocupe todo o tamanho da tela do dispositivo. Por padrão, os componentes filhos de um Surface herdam o seu tamanho, por isso a Column está ocupando todo o tamanho da tela.
- podemos alterar o tamanho do Surface, como nos exemplos:

~~~kotlin
Surface(
  modifier = Modifier.fillMaxSize(),
  // ocupa toda a tela
  color = MaterialTheme.colorScheme.background
) 
~~~

~~~kotlin
Surface (
  modifier = Modifier.size(150.dp),
  // gera um quadrado de 150x150, do lado superior esquerdo da tela. 
  // esse quadrado é o Surface com a Column no seu interior.
  color = MaterialTheme.colorScheme.background
) 
~~~

~~~kotlin
@Composable
fun ColumnRowScreen() {
  // Column principal
  Column(
    modifier = Modifier
      .background(Color.Cyan)
  ) {
    Column(modifier = Modifier
      .background(Color.Magenta)
      .size(100.dp)
      // permite que o quadrado magenta fique acima!
      ) {
      // Aqui vai o conteúdo
    }
    Row() {
      // Aqui vai o conteúdo
    }
    Row() {
      Column() {
        // Aqui vai o conteúdo
      }
      Column() {
        // Aqui vai o conteúdo
      }
    }
  }
}
~~~

- para colorir e redimensionar todos os composables da IU:

~~~kotlin
@Composable
fun ColumnRowScreen() {
  // Column principal
  Column(
    modifier = Modifier
      .background(Color.Cyan)
      // contêiner principal.
      // posiciona os componentes internos de forma empilhada na vertical.
  ) {
    Column(modifier = Modifier
      .background(Color.Magenta)
      .fillMaxWidth().height(150.dp)
      ) {
      // Aqui vai o conteúdo
    }
    Row(modifier = Modifier
      .fillMaxWidth()
      .height(150.dp)
      .background(Color.Green)) {
      // Aqui vai o conteúdo
    }
    Row(modifier = Modifier
    // row com duas coluns no interior
      .fillMaxWidth()
      .height(150.dp)
      .background(Color.Yellow)) {
      Column(modifier = Modifier
        .fillMaxWidth()
        .height(100.dp)
        .padding(8.dp)
        .background(Color.Red)
        .weight(0.3f)) {
        // Aqui vai o conteúdo
      }
      Column(modifier = Modifier
        .fillMaxWidth()
        .height(100.dp)
        .padding(8.dp)
        .background(Color.Blue)
        .weight(0.7f)) {
        // Aqui vai o conteúdo
      }
    }
  }
}
~~~

## 1.6 Alinhamento e arranjo de Colunas

- o posicionamento pode ser feito utilizando o Alinhamento e o Arranjo. 
- no exemplo anterior, na Column magenta, adicionar 4 botões:

~~~kotlin
Column(modifier = Modifier
  .background(Color.Magenta)
  .fillMaxWidth()
  .height(150.dp)) {
  Button(onClick = { /*TODO*/ }) {
    Text(text = "Botão 01")
  }
  Button(onClick = { /*TODO*/ }) {
    Text(text = "Botão 01")
  }
  Button(onClick = { /*TODO*/ }) {
    Text(text = "Botão 01")
  }
  Button(onClick = { /*TODO*/ }) {
    Text(text = "Botão 01")
  }
}
~~~

> Os composables podem utilizar outros composables para serem criados. O botão é um exemplo: utilizamos o Text para incluir o texto no botão. Em tese, é possível compor um composable com qualquer outro composable. 

- na situação acima, a Column magenta possui a largura da tela do dispositivo (fillMaxWidth()), e altura de 150dp (height(150.dp)).
- com isso, o quarto botão não está sendo visível, ou apenas parte dele é, já que a altura está fixada e não irá se adaptar ao seu conteúdo.
- para resolver esse problema, excluir a função height do modificador, assim, a altura ficará dinâmica e se ajustará ao conteúdo da Column.

~~~kotlin
Column(
  modifier = Modifier
    .background(Color.Magenta)
    .fillMaxWidth()
) {
  Button(onClick = { /*TODO*/ }) {
    Text(text = "Botão 01")
  }
  Button(onClick = { /*TODO*/ }) {
    Text(text = "Botão 01")
  }
  Button(onClick = { /*TODO*/ }) {
    Text(text = "Botão 01")
  }
  Button(onClick = { /*TODO*/ }) {
    Text(text = "Botão 01")
  }
}
~~~

### 1.6.1 horizontalAlignment
- no exemplo acima, os botões estão alinhados no lado inicial da Column.
- para alterar o alinhamento horizontal, usamos o parâmetro “horizontalAlignment” da Column.
- valores:
  - CenterHorizontally: alinha o conteúdo no centro horizontal da Column.
  - End: alinha o conteúdo do lado final/direito da Column.
  - Start: alinha o conteúdo do lado inicial/esquerdo da Column (padrão).

~~~kotlin
Column(
  horizontalAlignment = Alignment.CenterHorizontally,
  modifier = Modifier
    .background(Color.Magenta)
    .fillMaxWidth()
) {
  Button(onClick = { /*TODO*/ }) {
    Text(text = "Botão 01")
  }
  Button(onClick = { /*TODO*/ }) {
    Text(text = "Botão 01")
  }
  Button(onClick = { /*TODO*/ }) {
    Text(text = "Botão 01")
  }
  Button(onClick = { /*TODO*/ }) {
    Text(text = "Botão 01")
  }
}
~~~

### 1.6.2 verticalArrangement
- parâmetro que permite alterar o arranjo vertical do conteúdo de uma Column.
- valores:
  - Top: alinha o conteúdo na parte superior da Column.
  - Bottom: alinha todo o conteúdo na parte inferior da Column.
  - Center: alinha todo o conteúdo no centro vertical da Column.
  - SpaceAround: espalha verticalmente todo o conteúdo da Column, com espaço uniforme entre eles e mantendo um espaço uniforme no início e no final da coluna. 
  - SpaceBetween: espalha verticalmente todo o conteúdo da Column, com espaço uniforme entre eles, mas não mantém espaço extra no início e no final da coluna.
  - SpaceEvenly: espalha verticalmente todo o conteúdo da Column, com espaço uniforme entre eles. O mesmo espaço será colocado no início e no fim da coluna.
- continuando, no exemplo iremos posicionar todos os botões na parte inferior da Column (todo o conteúdo da Column alinhado horizontalmente ao lado final/direito da Column e posicionado na parte inferior):

~~~kotlin
Column(
  horizontalAlignment = Alignment.End,
  verticalArrangement = Arrangement.Bottom,
  modifier = Modifier
    .background(Color.Magenta)
    .fillMaxWidth().height(300.dp)
) {
  Button(onClick = { /*TODO*/ }) {
    Text(text = "Botão 01")
  }
  Button(onClick = { /*TODO*/ }) {
    Text(text = "Botão 01")
  }
  Button(onClick = { /*TODO*/ }) {
    Text(text = "Botão 01")
  }
  Button(onClick = { /*TODO*/ }) {
    Text(text = "Botão 01")
  }
}
~~~

- posicionar todos os botões ao centro da Column e com arranjo vertical uniforme (distribui os botões de forma uniforme na coluna, mantendo o mesmo espaçamento entre os botões e ao início e fim da coluna):

~~~kotlin
Column(
  horizontalAlignment = Alignment.CenterHorizontally,
  verticalArrangement = Arrangement.SpaceEvenly,
  modifier = Modifier
    .background(Color.Magenta)
    .fillMaxWidth().height(300.dp)
) {
  Button(onClick = { /*TODO*/ }) {
    Text(text = "Botão 01")
  }
  Button(onClick = { /*TODO*/ }) {
    Text(text = "Botão 01")
  }
  Button(onClick = { /*TODO*/ }) {
    Text(text = "Botão 01")
  }
  Button(onClick = { /*TODO*/ }) {
    Text(text = "Botão 01")
  }
}
~~~

## 1.8 Alinhamento e Arranjo em Linhas

- bastante similar às Columns; a diferença é que enquanto nas colunas fazemos alinhamento horizontal, nas linhas fazemos alinhamento vertical. - o mesmo ocorre com o arranjo, nas colunas fazemos arranjo vertical enquanto nas linhas fazemos arranjo horizontal. 
- acrescentar dois botões na Row verde:

~~~kotlin
Row(
  modifier = Modifier
    .fillMaxWidth()
    .height(150.dp)
    .background(Color.Green)
) {
  Button(onClick = { /*TODO*/ }) {
    Text(text = "Botão 02")
  }
  Button(onClick = { /*TODO*/ }) {
    Text(text = "Botão 02")
  }
}
~~~

- o posicionamento padrão no interior de uma Row é no lado inicial/esquerdo e parte superior da linha.
- acrescentar o parâmetro "verticalAlignment" com o valor “CenterVertically”, o parâmetro "horizontalArrangement" com o valor "SpaceBetween".

~~~kotlin
Row(
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.SpaceAround,
    modifier = Modifier
        .fillMaxWidth()
        .height(150.dp)
        .background(Color.Green)
) {
    Button(onClick = { /*TODO*/ }) {
        Text(text = "Botão 02")
    }
    Button(onClick = { /*TODO*/ }) {
        Text(text = "Botão 02")
    }
}
~~~

--- 

[Voltar ao início!](https://github.com/monicaquintal/smart_cities)