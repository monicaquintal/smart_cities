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
- criar um projeto no Android Studio chamado [Basic Components](./projects/BasicComponents/app/src/main/java/br/com/fiap/basiccomponents/MainActivity.kt).
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

- para alinhar o composable Text em relação ao seu componente pai, utilizar o Modifier, nesse caso para centralizar o Text do subtítulo no centro da Column. 

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
            fontFamily = Righteous,
            modifier = Modifier.align(Alignment.CenterHorizontally)
          )
        }
      }
~~~

- no exemplo acima, não foi alinhado o texto no centro, e sim todo o composable Text no centro do composable pai, que é a Column. 

## 2.1 Entrada de dados do usuário

- há diversos composables que podem ser utilizados para que o usuário forneça dados ao aplicativo, sendo os mais utilizados: campos de texto editáveis, caixas de checagem, botões rádio e listas suspensas.

## 2.2 Caixa de texto editável

- um dos componentes mais importantes para a entrada de dados.
- permitem ao usuário alterar o seu conteúdo. 

> Antes de começarmos a incluir os novos componentes, faremos alguns ajustes nas versões do Kotline da biblioteca "material3" do Jetpack Compose. Abrir o arquivo "build.gradle" em nível de projeto, localizado na pasta "Gradle Scripts".

~~~kotlin
// Top-level build file where you can add configuration options common to all sub-projects/modules.
    plugins {
        id 'com.android.application' version '8.0.0' apply false
        id 'com.android.library' version '8.0.0' apply false
        //id 'org.jetbrains.kotlin.android' version '1.7.20' apply false
        id 'org.jetbrains.kotlin.android' version '1.8.0' apply false
    }
~~~

> Em seguida, abrir o arquivo "build.gradle" do módulo, arquivo em que estão todas as informações necessárias para compilação, empacotamento e geração do pacote de instalação final do app. 

- alterar a versão das extensões do compilador Kotlin do Jetpack Compose:
  - localizar o bloco "composeOptions" e alterar a versão do atributo "kotlinCompilerExtensionsVersion" para 1.4.0. 
  - no bloco "dependencies", acrescentar a versão do pacote "material3". 

~~~kotlin
composeOptions {
  //kotlinCompilerExtensionVersion '1.3.2'
  kotlinCompilerExtensionVersion '1.4.0'
  }
  packagingOptions {
    resources {
      excludes += '/META-INF/{AL2.0,LGPL2.1}'
    }
  }

dependencies {

implementation 'androidx.core:core-ktx:1.8.0'
implementation 'androidx.lifecycle:lifecycle-runtime-ktx:2.3.1'
implementation 'androidx.activity:activity-compose:1.5.1'
implementation platform('androidx.compose:compose-bom:2022.10.00')
implementation 'androidx.compose.ui:ui'
implementation 'androidx.compose.ui:ui-graphics'
implementation 'androidx.compose.ui:ui-tooling-preview'
//    implementation 'androidx.compose.material3:material3'
implementation 'androidx.compose.material3:material3:1.1.0'
testImplementation 'junit:junit:4.13.2'
androidTestImplementation 'androidx.test.ext:junit:1.1.5'
androidTestImplementation 'androidx.test.espresso:espresso-core:3.5.1'
androidTestImplementation platform('androidx.compose:compose-bom:2022.10.00')
androidTestImplementation 'androidx.compose.ui:ui-test-junit4'
debugImplementation 'androidx.compose.ui:ui-tooling'
debugImplementation 'androidx.compose.ui:ui-test-manifest'
}
~~~

- clicar em "Sync Now", e aguardar o Android Studio concluir o download de todas as novas bibliotecas.

### 2.2.1 TextField

- o composable que permite ao usuário digitar dados é o TextField".
- inserir este composable, e utilizar o Modifier para que ele ocupe toda a largura da tela.

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
        fontFamily = Righteous,
        modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        TextField(
          value = "", 
          onValueChange = {},
          modifier = Modifier.fillMaxWidth()
        )
        }
    }
~~~

- o TextField possui dois parâmetros obrigatórios:
  - ***value***: valor que será colocado dentro do TextField. 
  - ***onValueChange***: parâmetro que recebe como valor uma função, por isso o valor deste parâmetro é {}. Dentro desse par de chaves podemos colocar uma instrução qualquer e ela será executada quando o value do TextField for alterado.

~~~kotlin
TextField(
        value = "Android",
        onValueChange = {},
        modifier = Modifier.fillMaxWidth()
      )
~~~

## 2.3 Gerenciando o estado do TextField

- o estado em um aplicativo é qualquer valor que pode mudar ao longo do tempo: 
  - quando estamos olhando para uma Interface de Usuário no Android, estamos observando seu estado atual.
  - se um valor mudar, precisamos que a Interface também seja atualizada, ou seja, o estado mudou. 
  - quando digitamos algo no TextField, estamos alterando o seu value, e essa mudança de estado causa a recomposição do TextField.
  - porém, durante essa recomposição os parâmetros são carregados novamente e o value retorna ao seu valor inicial.
  - logo, é necessário armazenarmos esse valor que está sendo digitado para que possamos lembrar dele na próxima recomposição. 

> Para que o Android se "lembre" dos valores entre recomposições, utilizamos a `função mutableStateOf()`. 

- no início da função de composição BasicComponentsScreen(), criar a variável de estado que armazenará o value do TextField.

~~~kotlin
var textFieldValue = remember {
        mutableStateOf("")
      }
~~~

- a variável textFieldValue é uma variável de estado, e o seu valor será lembrado entre as recomposições.
- ajustar os parâmetros value e onValueChange do TextField.

~~~kotlin
TextField(
        value = textFieldValue.value,
        onValueChange = { novoValor ->
          textFieldValue.value = novoValor
        },
        modifier = Modifier.fillMaxWidth()
      )
~~~

- ao ocorrer a composição inicial do TextField, ele receberá o valor vazio, que é o valor de inicialização da variável de estado.
- a cada caractere digitado, o método onValueChange do TextField nos retorna o valor atual que será atribuído à variável textFieldValue, que está armazenado na variável novoValor e que provocará a recomposição do TextField, pois seu estado mudou. Mas agora o valor será lembrado, e o value do TextField terá o comportamento que desejamos!

## 2.4 Tipos de entrada

- quando focamos em um TextField, o Android abre o teclado virtual para que possamos inserir o texto.
- há diversos teclados para a digitação dos mais variados tipos de informação. 
- é indicado que o teclado fornecido pelo Android esteja de acordo com o tipo de informação que vamos digitar.

- no exemplo, acrescentar um novo TextField que será utilizado para digitar um valor numérico, então o ideal é que o teclado apresentado seja o numérico.

~~~kotlin
var quantidade = remember {
        mutableStateOf("")
      }
      TextField(
        value = "${quantidade.value}",
        onValueChange = { novoValor ->
          quantidade.value = novoValor
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
      )
~~~

- a função KeyboardOptions permite que alteremos o teclado exibido para o usuário, e o comportamento enquanto digitamos.
- o parâmetro keyboardType, por exemplo, da função KeyboardOptions diz ao Android que o teclado que será exibido deverá ser o numérico.

- `Possíveis KeyboardType`:
  - ***Number***: apresentará o teclado numérico.
  - ***Text***: apresentará o tecado alfanumérico.
  - ***Decimal***: apresentará o teclado numérico com teclas para ponto decimal.
  - ***Email***: apresentará o teclado com o caractere @.
  - ***NumberPassword***: apresenta o teclado numérico e não vemos os números digitados.
  - ***Password***: apresenta o teclado alfanumérico e não vemos o que estamos digitando.
  - ***Phone***: apresenta o teclado para discagem.
  - ***Uri***: fornece o teclado ideal para digitarmos um endereço de Internet, por exemplo.

- também é possível definir como o texto será inserido. 
- suponhamos que o primeiro TextField seja utilizado para inserirmos o nome completo de uma pessoa, neste caso seria interessante que ao digitarmos o espaço o teclado fique maiúsculo para digitarmos o sobrenome, como no exemplo:

~~~kotlin
TextField(
        value = textFieldValue.value,
        onValueChange = { novoValor ->
          textFieldValue.value = novoValor
        },
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(
          capitalization = KeyboardCapitalization.Words
        )
      )
~~~

- `KeyboardCapitalization`: valores Words, Characters, None e Sentences.

## 2.5 Dicas de entrada

### 2.5.1 Placeholder:
- adicionar um `placeholder` ao segundo TextField.
- o placeholder é um composable, então este parâmetro pode receber como valor o Text que será usado para exibir o texto.
- o texto do placeholder é substituído pelo conteúdo digitado pelo usuário.

~~~kotlin
TextField(
        value = "${quantidade.value}",
        onValueChange = { novoValor ->
          quantidade.value = novoValor
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number), 
        placeholder = {
          Text(text = "Qual a quantidade?")
        }
      )
~~~

### 2.5.2 Label:
- inicialmente parece um placeholder, mas ao clicarmos no TextField o texto será usado como uma etiqueta do TextField. 
- adicionar o parâmetro label ao primeiro TextField.

~~~kotlin
TextField(
        value = textFieldValue.value,
        onValueChange = { novoValor
          textFieldValue.value = novoValor
        },
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(
          capitalization = KeyboardCapitalization.Words
        ),
        label = {
          Text(text = "Nome e sobrenome")
        }
      )
~~~

## 2.6 Inserindo ícone ao TextField

- para chamar atenção do usuário sobre o dado que deve ser inserido, podemos utilizar ícones, seja no início ou no fim do TextField. 
- adicionar um ícone no lado inicial do primeiro TextField.

~~~kotlin
TextField (
        value = textFieldValue.value,
        onValueChange = { novoValor
          textFieldValue.value = novoValor
        },
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(
          capitalization = KeyboardCapitalization.Words
        ),
        label = {
          Text(text = "Nome e sobrenome")
        },
        leadingIcon = {
          Icon(
            imageVector = Icons.Default.Person,
            contentDescription = "",
            tint = Color(237, 20, 91)
          )
        }
      )
~~~

- com o parâmetro `leadingIcon`, colocamos o ícone no início do TextField.
- também podemos utilizar o `trailingIcon`, que posicionará o ícone no fim do TextField.

## 2.7 Alterando a cor do texto de um TextField

- quando o usuário está focado no TextField, a cor pode ser diferente de quando o usuário não está focado no TextField.
- podemos alterar a cor do placeholder, do label, etc.
- alterar algumas configurações de cor no segundo TextField.

~~~kotlin
TextField(
        value = "${quantidade.value}",
        onValueChange = { novoValor ->
          quantidade.value = novoValor
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        placeholder = {
          Text(text = "Qual a quantidade?")
        },
        colors = TextFieldDefaults.colors( // ou TextFieldDefaults.textFieldColors
          focusedTextColor = Color.White,
          unfocusedTextColor = Color.Green,
          unfocusedPlaceholderColor = Color.Magenta
        )
      )
~~~

- o parâmetro:
  - focusedTextColor (focusedIndicatorColor): define a cor do texto para branco enquanto o editamos.
  - unfocusedTextColor (unfocusedIndicatorColor): altera a cor do texto para verde quando saímos do TextField.
  - unfocusedPlaceholderColor (placeholderColor): altera a cor do placeholder para magenta.

> há muitas possibilidades para ajuste de cores no texto do TextField; para obter uma lista de todas as opções possíveis, apontar o mouse para a palavra "colors" da função "TextFieldDefaults".

## 2.8 OutlinedTextField

- é uma vatiação do TextField.
- implementa uma aparência diferente, mas todos os parâmetros vistos até agora também estão disponíveis neste componente.
- criar um OutlinedTextField após o segundo TextField.

~~~kotlin
@Composable
fun BasicComponentsScreen() {

  var textFieldValue = remember {
    mutableStateOf("")
  }

  Column(
    modifier = Modifier
      .fillMaxWidth()
      .background(Color.Black)
  ) {
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
      fontFamily = Righteous,
      modifier = Modifier.align(Alignment.CenterHorizontally)
    )
    TextField(
      value = textFieldValue.value,
      onValueChange = { novoValor ->
        textFieldValue.value = novoValor
      },
      modifier = Modifier.fillMaxWidth(),
      keyboardOptions = KeyboardOptions(
        capitalization = KeyboardCapitalization.Words
      ),
      label = {
        Text(text = "Nome e sobrenome")
      },
      leadingIcon = {
        Icon(
          imageVector = Icons.Default.Person,
          contentDescription = "",
          tint = Color(237, 20, 91)
        )
      }
    )
    var quantidade = remember {
      mutableStateOf("")
    }
    TextField(
      value = "${quantidade.value}",
      onValueChange = { novoValor ->
        quantidade.value = novoValor
      },
      keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
      placeholder = {
        Text(text = "Qual a quantidade?")
      },
      colors = TextFieldDefaults.colors(
        focusedTextColor = Color.White,
        unfocusedTextColor = Color.Green,
        unfocusedPlaceholderColor = Color.Magenta
      )
    )
    Spacer(modifier = Modifier.height(32.dp))
    var cidade = remember {
      mutableStateOf("")
    }
    OutlinedTextField(
      value = cidade.value,
      onValueChange = {
        cidade.value = it
      },
      modifier = Modifier
        .padding(16.dp) 
        .fillMaxWidth(),
      textStyle = TextStyle(color = Color.White)
    )
  }
}
~~~

- neste exemplo, utilizamos:
  - um componente Spacer com o modificador Modifier.height(32.dp), que colocará um espaço de 32.dp antes do OutlinedTextField.
  - no OutlinedTextField”, seu modificador garate a largura total da tela com fillMaxWidth, espaçamento nos quatro lados de 16.dp com padding(16.dp). Além disso, utilizado textStyle para modificar a cor do texto.
  - no parâmetro onValueChange, utilizada a variável `it`, valor que nos é passado quando digitamos algo. Nos exemplos anteriores, utilizamos uma função lambda para isso, onde recebíamos uma variável que chamamos de novoValor. O it é muito utilizado em Kotlin, pois reduz digitação. 
- com textStyle é possível modificar diversos parâmetros listados (ver lista parando com o mouse em cima).

- o OutlinedTextField é renderizado numa forma retangular com uma borda e sem preenchimento, diferentemente do TextField. 
- modificar a forma do OutlinedTextField:

~~~kotlin
OutlinedTextField(
        value = cidade.value,
        onValueChange = {
          cidade.value = it
        },
        modifier = Modifier
          .padding(16.dp)
          .fillMaxWidth(),
        textStyle = TextStyle(color = Color.White),
        shape = RoundedCornerShape(16.dp),
        colors = OutlinedTextFieldDefaults.colors(
          unfocusedBorderColor = Color.Yellow,
          focusedBorderColor = Color.Cyan
        )
      )

// ou

shape = RoundedCornerShape(16.dp),
            colors = TextFieldDefaults.textFieldColors (
                focusedIndicatorColor = Color.Yellow,
                unfocusedIndicatorColor = Color.Cyan
            )
~~~

- no parâmetro shape utilizamos o valor RoundedCornerShape(16.dp), que aplica uma forma com cantos arredondados em 16.dp de raio.
- para mudar a cor das bordas, utilizado o parâmetro colors, que permite a mudança das cores de vários elementos do OutlinedTextField, utilizado o parâmetro unfoucusedBorderColor com o valor amarelo, para a borda sem o foco do usuário. Ao focar será aplicado o parâmetro focusedBorderColor para ciano.

<div align="center">
<h2>3. CAIXAS DE SELEÇÃO</h2>
</div>

- caixa de seleção ou `checkbox` é outro componente bastante utilizado na construção de uma aplicação Android.
- permite que um usuário possa selecionar uma ou mais opções em uma lista.
- adicionar um checkbox no final da aplicação.
  - utilizado Spacer para separar a Checkbox do OutlinedTextField. 
  - obrigatoriamente, o Checkbox deve ter os parâmetros "checked" (valor booleano e representa se a caixa estará marcada (true) ou desmarcada (false)).
  - no exemplo, na primeira composição a caixa estará desmarcada, pois foi passado o valor "false" para "checked".

~~~kotlin
Spacer(modifier = Modifier.height(32.dp))
    Row(modifier = Modifier.fillMaxWidth()) {
      Checkbox(
        checked = false,
        onCheckedChange = {},
        colors = CheckboxDefaults.colors(
          checkedColor = Color.White,
          uncheckedColor = Color(0xffed145b)
        )
      )
      Text(
        text = "Opção 1",
        color = Color.White
      )
    }
~~~

- criada uma Row para posicionar lado a lado a Checkbox e o texto Text, porém ficaram desalinhados.
- ajustar o alinhamento vertical da Row:

~~~kotlin
Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
          .fillMaxWidth()
      ) {
        Checkbox(
          checked = false,
          onCheckedChange = {},
          colors = CheckboxDefaults.colors(
            checkedColor = Color.White,
            uncheckedColor = Color(0xffed145b)
          )
        )
        Text(
          text = "Opção 1",
          color = Color.White
        )
      }
~~~

## 3.1 Gerenciando o estado da caixa de seleção

- inserir mais duas caixas de texto.

~~~kotlin
Spacer(modifier = Modifier.height(32.dp))
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
    ) {
    Checkbox(
        checked = false,
        onCheckedChange = {},
        colors = CheckboxDefaults.colors(
            checkedColor = Color.White,
            uncheckedColor = Color(0xffed145b)
        )
    )
    Text(
        text = "Kotlin",
        color = Color.White
    )
    }
    Row(
    verticalAlignment = Alignment.CenterVertically,
    modifier = Modifier
        .fillMaxWidth()
    ) {
    Checkbox(
        checked = false,
        onCheckedChange = {},
        colors = CheckboxDefaults.colors(
        checkedColor = Color.White,
        uncheckedColor = Color(0xffed145b)
        )
    )
    Text(
        text = "Java",
        color = Color.White
    )
    }
    Row(
    verticalAlignment = Alignment.CenterVertically,
    modifier = Modifier
        .fillMaxWidth()
    ) {
    Checkbox(
        checked = false,
        onCheckedChange = {},
        colors = CheckboxDefaults.colors(
        checkedColor = Color.White,
        uncheckedColor = Color(0xffed145b)
        )
    )
    Text(
        text = "C#",
        color = Color.White
    )
}
~~~

- para que o Ckeckbox exiba a seleção, utilizaremos o state.

~~~kotlin
Spacer(modifier = Modifier.height(32.dp))

    var kotlin = remember {
        mutableStateOf(true)
    }

    var java = remember {
        mutableStateOf(false)
    }

    var cSharp = remember {
        mutableStateOf(false)
    }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
    ) {
    Checkbox(
        checked = kotlin.value,
        onCheckedChange = { kotlin.value = it },
        colors = CheckboxDefaults.colors(
            checkedColor = Color.White,
            uncheckedColor = Color(0xffed145b)
        )
    )
    Text(
        text = "Kotlin",
        color = Color.White
    )
    }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Checkbox(
            checked = java.value,
            onCheckedChange = { java.value = it },
            colors = CheckboxDefaults.colors(
                checkedColor = Color.White,
                uncheckedColor = Color(0xffed145b)
        )
    )
    Text(
        text = "Java",
        color = Color.White
    )
    }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Checkbox(
            checked = cSharp.value,
            onCheckedChange = { cSharp.value = it },
            colors = CheckboxDefaults.colors(
                checkedColor = Color.White,
                uncheckedColor = Color(0xffed145b)
        )
    )
    Text(
        text = "C#",
        color = Color.White
    )
    }
~~~

- criadas três variáveis que representarão o estado de cada Checkbox: para a variável kotlin, atribuído o valor true, e false para java e cSharp. 
- atribuídos a cada parâmetro checked de cada Checkbox a variável correspondente. 
- para o parâmetro onCheckedChange, atribuído o valor it, que neste caso é um valor booleano.

## 3.2 Opções únicas com RadioButton

- enquanto Checkbox permite a seleção múltipla em uma lista, o RadioButton é usado quando queremos que apenas uma opção seja selecionada.
- adicionar três RadioButton após os Checkbox.

~~~kotlin
Spacer(modifier = Modifier.height(16.dp))
Row(modifier = Modifier.fillMaxWidth()) {
  Row(verticalAlignment = Alignment.CenterVertically) {
    RadioButton(
      selected = false,
      onClick = { /*TODO*/ },
      colors = RadioButtonDefaults.colors(
        selectedColor = Color.White,
        unselectedColor = Color(0xffed145b)
      )
    )
    Text(text ="MacOS", color = Color.White)
  }
  Row(verticalAlignment = Alignment.CenterVertically) {
    RadioButton(
      selected = false,
      onClick = { /*TODO*/ },
      colors = RadioButtonDefaults.colors(
        selectedColor = Color.White,
        unselectedColor = Color(0xffed145b)
      )
    )
    Text(text = "GNU/Linux", color = Color.White)
  }
  Row(verticalAlignment = Alignment.CenterVertically) {
    RadioButton(
      selected = false,
      onClick = { /*TODO*/ },
      colors = RadioButtonDefaults.colors(
        selectedColor = Color.White,
        unselectedColor = Color(0xffed145b)
      )
    )
    Text(text = "Windows 11", color = Color.White)
  }
}
~~~

- criada uma Row, pois queremos que os RadioButton fiquem alinhados lado a lado, e criada uma Row em seu interior para colocarmos o RadioButton e um texto. 
- para os RadioButton, utilizado o parâmetro color, cujo valor é a função RadioButtonDefaults.color().
- ao criarmos um RadioButton, obrigatoriamente devemos fornecer o valor para o parâmetro selected, um booleano que define se o RadioButton estará marcado ou não. 
- também temos que fornecer o parâmetro onClick, que executará as instruções para quando o RadioButton for clicado, marcando ou desmarcando a opção.

## 3.3 Gerenciando o estado do RadioButton

- o estado do RadioButton determina se ele está marcado ou desmarcado, basicamente.
- a diferença é que podemos ter apenas uma opção selecionada.

~~~kotlin
Spacer(modifier = Modifier.height(16.dp))

var selecionado = remember {
  mutableStateOf(0)
}

Row(modifier = Modifier.fillMaxWidth()) {
  Row(verticalAlignment = Alignment.CenterVertically) {
    RadioButton(
      selected = selecionado.value == 0,
      onClick = { selecionado.value = 0 },
      colors = RadioButtonDefaults.colors(
        selectedColor = Color.White,
        unselectedColor = Color(0xffed145b)
      )
    )
    Text(text = "MacOS", color = Color.White)
  }
  Row(verticalAlignment = Alignment.CenterVertically) {
    RadioButton(
      selected = selecionado.value == 1,
      onClick = { selecionado.value = 1 },
      colors = RadioButtonDefaults.colors(
        selectedColor = Color.White,
        unselectedColor = Color(0xffed145b)
      )
    )
    Text(text = "GNU/Linux", color = Color.White)
  }
  Row(verticalAlignment = Alignment.CenterVertically) {
    RadioButton(
      selected = selecionado.value == 2,
      onClick = { selecionado.value = 2 },
      colors = RadioButtonDefaults.colors(
        selectedColor = Color.White,
        unselectedColor = Color(0xffed145b)
      )
    )
    Text(text = "Windows 11", color = Color.White)
  }
}
~~~

- neste exemplo, criamos uma variável de estado chamada "selecionado", que recebe inicialmente o valor zero e que será atualizado quando um RadioButton é clicado.
- o valor do parâmetro "selected" será o resultado da operação booleana que compara o valor da variável "selecionado" a um número atribuído ao RadioButton. 
- o que o parâmetro "onClick" faz é atualizar o valor da variável de estado!

## 3.4 Botões

- o composable utilizado para criar botões é o Button.
- acrescentar um botão após a Row que mantém as Checkbox.

~~~kotlin
Button(onClick = { /*TODO*/ }) {
        Text(text = "Clique aqui!")
      }
~~~

- botões possuem o parâmetro onClick, responsável por disparar alguma ação quando o botão for clicado pelo usuário. 
- o texto do botão será adicionado utilizando outro componente, o Text.
- como todo componente no Jetpack Compose, é possível mudar sua aparência, como cor, tamanho, borda, forma etc:

~~~kotlin
Button(
        onClick = { /*TODO*/ },
        modifier = Modifier.size(width = 200.dp, height = 60.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color.Magenta),
        border = BorderStroke(width = 3.dp, color = Color.White)
      ) {
        Text(text = "Clique aqui!")
      }
~~~

- além do Button, que é o botão mais tradicional, também podemos utilizar o OutlinedButton, que renderizará um botão sem preenchimento:

~~~kotlin
Button(
        onClick = { /*TODO*/ },
        modifier = Modifier.size(width = 200.dp, height = 60.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color.Magenta),
        border = BorderStroke(width = 3.dp, color = Color.White)
      ) {
        Text(text = "Clique aqui!")
      }
      OutlinedButton(onClick = { /*TODO*/ }) {
        Text(text = "Outro botão")
      }
~~~

## 3.5 Implementando o clique do botão

- a ação do botão será executada através do parâmetro onClick, e pode ser escrita dentro das chaves do parâmetro ou escrever uma função separada.
- como exemplo, inserir a frase "Unidade Paulista" no OutlinedTextField assim que o Button for pressionado.
  - para isso, lembrar que há uma variável de estado chamada "cidade",responsável por gerenciar o valor exibido na OutlinedTextField.

~~~kotlin
Button(
        onClick = {
          cidade.value = "Unidade Paulista"
        },
        modifier = Modifier.size(width = 200.dp, height = 60.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color.Magenta),
        border = BorderStroke(width = 3.dp, color = Color.White)
      ) {
        Text(text = "Clique aqui!")
      }
      OutlinedButton(onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors()) {
        Text(text = "Outro botão")
      }
~~~

- implementar o clique no OutlinedButton para limpar o OutlinedTextField.

~~~kotlin
Button(
        onClick = {
          cidade.value = "Unidade Paulista"
        },
        modifier = Modifier.size(width = 200.dp, height = 60.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color.Magenta),
        border = BorderStroke(width = 3.dp, color = Color.White)
      ) {
        Text(text = "Clique aqui!")
      }
      OutlinedButton(onClick = {
        cidade.value = ""
      }) {
        Text(text = "Outro botão")
      }
~~~

--- 

[Voltar ao início!](https://github.com/monicaquintal/smart_cities)