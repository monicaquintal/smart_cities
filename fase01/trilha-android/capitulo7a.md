<div align="center">
<a href="https://github.com/monicaquintal" target="_blank"><img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/kotlin/kotlin-original.svg" width="100px" align="left"/></a>
<h1>FASE 1 - APP WORLD</h1>
<h2>Capítulo 7A: Uso de Cards e Imagens.</h2>
</div>

<div align="center">
<h2>1. USO DE CARDS E IMAGENS </h2>
</div>

## 1.1 Apresentação do projeto

- aplicação para cálculo de IMC.

<div align="center">
<img src="../images/calc-imc-layout.png" width="30%"><br>
<em>Layout da Aplicação.</em><br>
</div>


<div align="center">
<img src="../images/calc-imc-estrutura.png" width="30%"><br>
<em>Estrutura do projeto.</em><br>
</div>

- Surface: envolverá toda a Activity.
- Box: ocupará todo o tamanho da Activity; escolhida para facilitar o posicionamento do Card com o resultado na parte inferior.
- Column1: organizará verticalmente a Column2, que será o cabeçalho, e a Column3, que será ocupado pelo formulário.
- Column2: cabeçalho da Activity.
- Column3: Formulário.
- Card Formulário: componente Card, usado para estilizar o formulário.
- Card Resultado: resultado do cálculo de IMC.

> Criado projeto [IMC App]() no Android Studio.

- estrutura inicial:

~~~kotlin
class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      IMCAppTheme { 
        Surface(
          modifier = Modifier.fillMaxSize(),
          color = MaterialTheme.colorScheme.background
        ) {
          IMCScreen()
        }
      }
    }
  }
}

@Composable
fun IMCScreen() {
  Box(
    modifier = Modifier.fillMaxSize()
  ) {
    Column(
      modifier = Modifier
        .fillMaxWidth()
    ) {
      // ---- header ---------
      Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
          .fillMaxWidth()
          .height(160.dp)
      ) {

      }
      // --- formulário
      Column(
        modifier = Modifier
          .fillMaxWidth()
          .padding(horizontal = 32.dp)
      ) {

      }
    }
    // -- Card Resultado
  }
}
~~~

## 1.2 Inserindo imagens no aplicativo

- as imagens utilizadas nos aplicativos Android podem estar disponíveis no pacote da aplicação na forma de recursos, ou obtê-las através de um repositório na Internet.
- no projeto:
  - trabalhar com as imagens como recursos da aplicação, ou seja, armazenar as imagens que utilizaremos na pasta "drawable" do projeto. Esta pasta se encontra na pasta "res". 
  - o layout do projeto sugere [esta imagem](https://www.flaticon.com/free-icon/bmi_10476452?term=bmi&page=1&position=6&origin=search&related_id=10476452), encontrada no site [Flaticon](https://www.flaticon.com/).
- requisitos para o nome da imagem:
  - grafado somente com letras minúsculas.
  - sem caracteres especiais.
  - sem espaço em branco.
  - não iniciar com números ou caracteres especiais.
- a inclusão de imagens em um projeto Jetpack Compose no Android é feita com o `composable Image`.

~~~kotlin
// ---- header ---------
Column(
  horizontalAlignment = Alignment.CenterHorizontally,
  modifier = Modifier
    .fillMaxWidth()
    .height(160.dp)
) {
  Image(
    painter = painterResource(id = R.drawable.bmi_256),
    contentDescription = "logo"
  )
}
~~~

- na função de composição Image, é necessário fornecer dois parâmetros:
  - painter: especifica qual imagem será usada pelo Image, através do painterResource, que indica a imagem local que será usada.
  - contentDescription: utilizada para descrever a imagem. O uso deste parâmetro torna a aplicação mais acessível para pessoas que não podem ver a imagem.

- ajustar a posição e tamanho da imagem, para que não fique colada ao topo da Activity.

~~~kotlin
// ---- header ---------
Column(
  horizontalAlignment = Alignment.CenterHorizontally,
  modifier = Modifier
    .fillMaxWidth()
    .height(160.dp)
) {
  Image(
    painter = painterResource(id = R.drawable.bmi_256),
    contentDescription = "logo",
    modifier = Modifier
      .size(60.dp)
      .padding(top = 16.dp)
  )
}
~~~

## 1.3 Configurando o arquivo colors.xml

- no layout, será utilizada a cor vermelha (código hexadecimal ED145B). 
- cadastrar essa cor no arquivo "colors" do projeto (values > colors.xml).
  - recurso utilizado para definir e gerenciar todas as cores utilizadas no projeto. 
  - através dele podemos criar toda a identidade de cores do aplicativo, tornando fácil e rápido a troca das cores em caso de mudança.
  - no arquivo colors.xml definimos as cores utilizando o padrão XML, onde temos uma tag que identifica a cor e o valor desta tag que é o código hexadecimal da cor.

~~~kotlin
<?xml version="1.0" encoding="utf-8"?>
<resources>
    <color name="purple_200">#FFBB86FC</color>
    <color name="purple_500">#FF6200EE</color>
    <color name="purple_700">#FF3700B3</color>
    <color name="teal_200">#FF03DAC5</color>
    <color name="teal_700">#FF018786</color>
    <color name="black">#FF000000</color>
    <color name="white">#FFFFFFFF</color>
    <color name="vermelho_fiap">#FFED145B</color>
</resources>
~~~

- trocar a cor de background da Column que contém a imagem para "vermelho_fiap" e acrescentar o título do aplicativo.

~~~kotlin
// ---- header ---------
Column(
  horizontalAlignment = Alignment.CenterHorizontally,
  modifier = Modifier
    .fillMaxWidth()
    .height(160.dp)
    .background(colorResource(id = R.color.vermelho_fiap))
) {
  Image(
    painter = painterResource(id = R.drawable.bmi_256),
    contentDescription = "logo",
    modifier = Modifier
      .size(60.dp)
      .padding(top = 16.dp)
  )
  Text(
    text = "Calculadora IMC",
    fontSize = 24.sp,
    color = Color.White,
    fontWeight = FontWeight.Bold,
    modifier = Modifier.padding(top = 12.dp, bottom = 24.dp)
  )
}
~~~

## 1.4 Trabalhando com Cards

- o composable Card permite a criação de uma superfície elevada que conterá o conteúdo.
- frequentemente utilizamos o Card para agrupar conteúdo que estão relacionados e fornecer uma aparência mais organizada.
- criar um Card que organizará os componentes do formulário.

~~~kotlin

~~~












--- 

[Voltar ao início!](https://github.com/monicaquintal/smart_cities)