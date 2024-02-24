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
- criado o projeto Jetpack Compose no Android Studio chamado [Column Row]().
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










--- 

[Voltar ao início!](https://github.com/monicaquintal/smart_cities)