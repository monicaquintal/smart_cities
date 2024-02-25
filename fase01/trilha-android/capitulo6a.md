<div align="center">
<a href="https://github.com/monicaquintal" target="_blank"><img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/kotlin/kotlin-original.svg" width="100px" align="left"/></a>
<h1>FASE 1 - APP WORLD</h1>
<h2>Capítulo 6A: Componentes básicos com Jetpack Composes.</h2>
</div>

<div align="center">
<h2>1. COMPONENTES BÁSICOS COM JETPACK </h2>
</div>

## 1.1 Exibindo texto para o usuário

- componente "Text":
  - é o mais básico.
  - permite exibir informações para o usuário.
- criar um projeto no Android Studio chamado [Basic Components]().
- criar uma função de composição chamada "BasicComponentsScreen", e inserir dois composables do tipo Text.

~~~kotlin
class MainActivity : ComponentActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
          super.onCreate(savedInstanceState)
          setContent {
            BasicComponentsTheme {
              // A surface container using the 'background' color from the theme
              Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
              ) {
                BasicComponentsScreen()
              }
            }
          }
        }
      }
      
      @Composable
      fun BasicComponentsScreen() {
        Column(modifier = Modifier.fillMaxWidth()) {
          Text(text = "FIAP")
          Text(text = "Desenvolvendo aplicações Android")
        }
      }
~~~

- os componentes "Text" ficam empilhados na vertical pois estão inseridos em uma Column. 

## 1.2 Formatação básica do texto

- o composable "Text" implementa vários parâmetros que são responsáveis pela formatação da aparência do texto inserido no "Text". 
- o "Modifier" permite modificar a aparência do componente. 
- aplicar as modificações:

~~~kotlin
@Composable
    fun BasicComponentsScreen() {
        Column(modifier = Modifier.fillMaxWidth()) {
          Text(
            text = "FIAP",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFED145B)
          )
          Text(text = "Desenvolvendo aplicações Android")
        }
      }
~~~

- o que mudamos no texto:?
  - `fontSize`: parâmetro definido para "32.sp":
    - 32 representa o tamanho que queremos.
    - "sp" significa "scaled pixels", uma unidade utilizada para definir o tamanho do texto com base nas configurações de tamanho de fonte do dispositivo. 
    - considerando que o usuário pode alterar o tamanho das fontes utilizadas pelo dispositivo, utilizar "sp" garante que a aplicação obedecerá a configuração.
  - `fontWeight`: neste parâmetro configura-se a intensidade ou peso da fonte. 
    - ***FontWeight.Thin***: fonte com peso fino.
    - ***FontWeight.ExtraLight***: fonte com peso extra leve.
    - ***FontWeight.Light***: fonte com peso leve.
    - ***FontWeight.Normal***: fonte com peso normal.
    - ***FontWeight.Medium***: fonte com peso médio.
    - ***FontWeight.Bold***: estilo negrito. 
    - ***FontWeight.SemiBold***: fonte com peso semi-negrito.
    - ***FontWeight.ExtraBold***: fonte com peso extra negrito.
    - ***FontWeight.Black***: fonte com peso preto.
  - `color`: configura a cor do texto. No exemplo, utilizamos o código hexadecimal de uma cor vermelha (ED145B).
    - ***0x***: sempre que vamos fornecer um valor hexadecimal para uma cor no Jetpack Compose devemos começar com esse prefixo.
    - ***FF***: chhamado "canal alpha", representa a transparência de uma cor, onde FF significa totalmente opaco e 00 totalmente transparente.

> Além do uso de hexadecimal para definição da cor, também podemos utilizar RGB, que é a mistura de vermelho, verde e azul. Para o exemplo, poderíamos ter utilizado Color(237, 20, 91).

- modificar o background da IU, lembrando que a Column está ocupando toda a tela e ela é o contêiner principal.

~~~kotlin
@Composable
    fun BasicComponentsScreen() {
        Column(modifier = Modifier
          .fillMaxWidth()
          .background(Color.Black)) {
          Text(
            text = "FIAP",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color(237, 20, 91)
          )
          Text(text = "Desenvolvendo aplicações Android")
        }
      }
~~~

- para alterar a cor de fundo da Column, utilizamos "Modifier.background(Color.Black)".
- então, além de usar RGB e hexadecimal para as cores, também é possível utilizar cores pré-configuradas, como Red, White, Green.
- alterar as confugurações do segundo Text:

~~~kotlin
@Composable
    fun BasicComponentsScreen() {
        Column(modifier = Modifier
          .fillMaxWidth()
          .background(Color.Black)) {
          Text(
            text = "FIAP",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color(237, 20, 91)
          )
          Text(
            text = "Desenvolvendo aplicações Android",
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.White
          )
        }
      }
~~~

## 1.3 Adicionando fontes ao projeto

- fonte genéricas que o Android Studio possui por padrão
  - Monospace.
  - Serif.
  - SansSerif.
  - Cursive.
  - Default.

~~~kotlin
@Composable
    fun BasicComponentsScreen() {
        Column(modifier = Modifier
          .fillMaxWidth()
          .background(Color.Black)) {
          Text(
            text = "FIAP",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color(237, 20, 91),
            fontFamily = FontFamily.Serif
          )
          Text(
            text = "Desenvolvendo aplicações Android",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
          )
        }
      }
~~~

- podemos utilizar qualquer outra fonte que desejarmos, sendo necessário adicionar essas fontes ao projeto.

### a) acessar o site do `Google Fonts` e baixar uma fonte chamada "Righteous". 
- acessar [Google Fonts](https://fonts.google.com/).
- no campo de busca de fontes, digitar o nome da fonte desejada (Righteous). 
- clicar na fonte resultante da pesquisa, e será direcionado para outra página com as opções da fonte selecionada.
- clicar no botão "Download Family", do lado superior direito da página.
- salvar o arquivo .zip em uma pasta do computador.
- descompactar o arquivo .zip.

### b) configurar o Android Studio para utilizar essa nova fonte:
- do lado esquerdo do Android Studio temos o painel de projeto, conhecido como "Project", e nesta estrutura temos a `pasta res` (resources, recursos), utilizada para colocar os recursos que serão utilizados no projeto, como imagens que ficam na pasta drawable e mipmap.
- clicar como o botão direito do mouse na pasta res, selecionar a opção New > "Android Resource Directory".
- na janela "New Resource Directory", em "Resource Type", abrir a lista e selecionar a opção "Font" e pressionar o botão OK.
- localizar a pasta de fontes usada para descompactar a fonte baixada do Google Fonts, copiar o arquivo de fonte "Righteous-Regular.ttf" para a pasta "font".
- renomear o arquivo da fonte, trocando o nome para "righteous_regular.ttf" (botão direito do mouse no arquivo > Refactor > Rename).
- a fonte já estará disponível para ser utilizada. 

### c) adicionar configurações ao arquivo `Type.kt` (arquivo de código fonte responsável pela padronização de fontes do app):
- permite centralizar toda a identidade tipográfica da aplicação, facilitando rápida troca de fontes e personalização.
- localizar o arquivo no pacote "ui.theme".
- abrir o arquivo "Type.kt" e adicione as seguintes linhas de código:

~~~kotlin
package br.com.fiap.basiccomponents.ui.theme

    import androidx.compose.material3.Typography
    import androidx.compose.ui.text.TextStyle
    import androidx.compose.ui.text.font.Font
    import androidx.compose.ui.text.font.FontFamily
    import androidx.compose.ui.text.font.FontWeight
    import androidx.compose.ui.unit.sp
    import br.com.fiap.basiccomponents.R

    val Righteous = FontFamily(
        Font(R.font.righteous_regular)
      )
        
    // Set of Material typography styles to start with
    val Typography = Typography(
      bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
    )
~~~

- o que fizemos foi criar uma variável global chamada "Righteous", que guarda a nova fonte, e a partir de agora já podemos utilizá-la.

### d) retornar ao arquivo "MainActivity.kt" para trocar a fonte:

~~~kotlin
@Composable
    fun BasicComponentsScreen() {
        Column(modifier = Modifier
          .fillMaxWidth()
          .background(Color.Black)) {
          Text(
            text = "FIAP",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color(237, 20, 91),
            fontFamily = FontFamily.Serif
          )
          Text(
            text = "Desenvolvendo aplicações Android",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            fontFamily = Righteous
          )
        }
      }
~~~

<div align="center">
<h2>2. ALINHANDO O TEXTO</h2>
</div>

- utilizar o "Modifier.background", para trocar a cor de fundo do primeiro Text, que era transparente, para amarelo.

> `importante:` o Text tem exatamente o tamanho do texto que ele contém.

- se alinharmos o texto, não vamos perceber nenhuma alteração; portanto, mudar este comportamento com o "Modifier.fillMaxWidth", que fará com que o Text tenha a largura total da tela. 

~~~kotlin
@Composable
    fun BasicComponentsScreen() {
        Column(modifier = Modifier
          .fillMaxWidth()
          .background(Color.Black)) {
          Text(
            text = "FIAP",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color(237, 20, 91),
            fontFamily = FontFamily.Serif,
            modifier = Modifier
              .background(Color.Yellow)
              .fillMaxWidth(),
            textAlign = TextAlign.End
          )
          Text(
            text = "Desenvolvendo aplicações Android",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            fontFamily = Righteous
          )
        }
      }
~~~

- `textAlign`: 
  - é um parâmetro do composable Text que alinha o texto no seu interior. 
  - valores: End, Start, Justify e Center. 

- para alinhar o composable Text em relação ao seu componente pai, precisamos utilizar o “Modifier”. Vamos centralizar oTextdo subtítulono centro da Column. 







--- 

[Voltar ao início!](https://github.com/monicaquintal/smart_cities)