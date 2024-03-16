<div align="center">
<a href="https://github.com/monicaquintal" target="_blank"><img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/kotlin/kotlin-original.svg" width="100px" align="left"/></a>
<h1>FASE 1 - APP WORLD</h1>
<h2>Capítulo 13A: Animação e Multimídia.</h2>
</div>

<div align="center">
<h2>1. ANIMAÇÃO</h2>
</div>

## 1.1 Aplicando efeitos de animação

- a biblioteca de animações do Jetpack Compose permite aplicar movimento e transições mais fluídas entre os diferentes componentes da tela.
- há 4 grupos de animação:
  - `Fade`: que aplica um efeito de esmaecimento na entrada e saída do componente.
  - `Slide`: aplica efeito de deslizamento na entrada e saída do componente. O deslizamento pode ser aplicado vertical ou horizontalmente.
  - `Scale`: aplica uma alteração do tamanho do componente no momento de entrada ou saída da tela.
  - `Expand`: aplica um efeito de expansão no tamanho do componente.
- todos esses efeitos podem ser configurados para diferentes comportamentos, inclusive é possível juntar um ou mais efeitos para criarmos um efeito personalizado.
- para testar os tipos de animação que podemos incluir, criae um projeto no Android Studio com o nome [Animacao](./projects/Animacao/app/src/main/java/br/com/fiap/animacao/MainActivity.kt). 

~~~kotlin
package br.com.fiap.animacao

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import br.com.fiap.animacao.ui.theme.AnimacaoTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      AnimacaoTheme {
        Surface(
          modifier = Modifier.fillMaxSize(),
          color = MaterialTheme.colorScheme.background
        ) {
          AnimacaoScreen()
        }
      }
    }
  }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AnimacaoScreen() {
  var visible = remember {
    mutableStateOf(false)
  }
  var enter = remember {
    mutableStateOf(fadeIn())
  }
  var exit = remember {
    mutableStateOf(fadeOut())
  }

  Column(
    horizontalAlignment = Alignment.CenterHorizontally,
    modifier = Modifier
      .fillMaxWidth()
      .padding(16.dp)
  ) {
    Row(
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = Arrangement.SpaceBetween,
      modifier = Modifier.fillMaxWidth()
    ) {
      Button(onClick = {
      }) {
        Text(text = "Fade")
      }
      Button(onClick = {
      }) {
        Text(text = "Slide")
      }
      Button(onClick = {
      }) {
        Text(text = "Scale")
      }
      Button(onClick = {
      }) {
        Text(text = "Expand")
      }
    }
    Spacer(modifier = Modifier.height(64.dp))
    BoxComponent(
      visible = visible.value,
      enter = enter.value,
      exit = exit.value
    )
  }
}

@Composable
fun BoxComponent(
  visible: Boolean,
  enter: EnterTransition,
  exit: ExitTransition
) {
  AnimatedVisibility(
    visible = visible,
    enter = enter,
    exit = exit
  ) {
    Box(modifier = Modifier
      .size(200.dp)
      .background(color = Color.Red))
  }
}
~~~

- a função BoxScreen é responsável por renderizar a tela enquanto a função BoxComponent é responsável por renderizar a Box que utilizaremos para testar os efeitos de animação. 
- a função“BoxComponent recebe três argumentos:
  - visible: do tipo booleano, responsável por controlar a visibilidade do componente na tela.
  - enter: argumento do tipo EnterTransition, responsável pelo efeito aplicado durante a entrada do componente Box na tela.
  - exit: do tipo ExitTransition, responsável pelo efeito aplicado durante a saída do componente Box da tela.
- a função AnimacaoScreen declara e inicia três variáveis de estado que são responsáveis por armazenar o estado de exibição e animação de entrada ou saída do componente. Essa função implementa 4 botões que são responsáveis por aplicar os diferentes tipos de animação que vamos testar.

### 1.1.1 Implementando o efeito de FadeIn/FadeOut
- efeito de esmaecimento do componente. 
- aplicar o efeito de esmaecimento do componente Box durante a entrada e saída.

~~~kotlin
Button(onClick = {
    visible.value = !visible.value
    enter.value = fadeIn()
    exit.value = fadeOut()
  }) {
    Text(text = "Fade")
  }
~~~

- alterar o tempo em que as animações ocorrem:

~~~kotlin
Button(onClick = {
    visible.value = !visible.value
    enter.value = fadeIn(animationSpec = tween(5000))
    exit.value = fadeOut(animationSpec = tween(5000))
  }) {
    Text(text = "Fade")
  }
~~~

### 1.1.2 Aplicando efeito de deslizamento
- a função slide possui as variações: slideInHorizontally, slideOutHorizontally, slideInVertically e slideOutVertically.

~~~kotlin
Button(onClick = {
    visible.value = !visible.value
    enter.value = slideInHorizontally()
    exit.value = slideOutHorizontally()
  }) {
    Text(text = "Slide")
  }
~~~

- é possível juntar efeitos: colocar um efeito de fadeOut junto com o efeito de slideOutVertically.

~~~kotlin
Button(onClick = {
    visible.value = !visible.value
    enter.value = slideInHorizontally()
    exit.value = slideOutVertically() + fadeOut(animationSpec = tween(2000))
  }) {
    Text(text = "Slide")
  }
~~~

### 1.1.3 Aplicando efeito de escala
- aplica um efeito de alteração de tamanho do componente durante a entrada ou saída da tela. 

~~~kotlin
Button(onClick = {
    visible.value = !visible.value
    enter.value = scaleIn()
    exit.value = scaleOut()
  }) {
    Text(text = "Scale")
  }
~~~

### 1.1.4 Aplicando efeito de expansão
- ocorre no tamanho da imagem, mas começando pelas laterais, horizontal ou verticalmente.

~~~kotlin
Button(onClick = {
    visible.value = !visible.value
    enter.value = expandHorizontally()
    exit.value = shrinkHorizontally()
  }) {
    Text(text = "Expand")
  }
~~~

- também é possível alterar o efeito para vertical.

~~~kotlin
Button(onClick = {
    visible.value = !visible.value
    enter.value = expandVertically()
    exit.value = shrinkVertically()
  }) {
    Text(text = "Expand")
  }
~~~

<div align="center">
<h2>2. MULTIMIDIA</h2>
</div>

## 2.1 Reproduzindo áudio

- criar um projeto no Android Studio com o nome [Audio Player](./projects/AudioPlayer/app/src/main/java/br/com/fiap/audioplayer/MainActivity.kt). 
- para aprender a reproduzir áudio em aplicativos Android, será necessário disponibilizar um áudio como recurso para a aplicação; portanto, criar uma nova pasta de recursos na pasta res do projeto:
  - botão direito do mouse na pasta "res" > New > Android Resource Directory > opção "raw" no campo Resource Type > OK.
  - guardar o arquivo de áudio na pasta raw.
- na MainActivity.kt:

~~~kotlin
@Composable
fun AudioPlayer(context: Context) {
  
  var player = remember {
    mutableStateOf(MediaPlayer.create(context, R.raw.music))
  }

  Box(contentAlignment = Alignment.Center) {
    Row() {

      IconButton(onClick = { }) {
        Icon(
          painter = painterResource(id = R.drawable.play),
          contentDescription = ""
        )
      }

      IconButton(onClick = { }) {
        Icon(
          painter = painterResource(id = R.drawable.pause),
          contentDescription = ""
        )
      }

      IconButton(onClick = { }) {
        Icon(
          painter = painterResource(id = R.drawable.stop),
          contentDescription = ""
        )
      }
      
    }
  }
}
~~~

- os arquivos de imagem utilizados como botões do tocador de música deverão ser colocados na pasta “res/drawable”.
- modificar o método onCreate da classe MainActivity para chamar a função AudioPlayer.

~~~kotlin
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      setContent {
        AudioPlayerTheme {
          Surface(modifier = Modifier.fillMaxSize(), 
              color = MaterialTheme.colorScheme.background) {
            AudioPlayer(this)
          }
        }
      }
    }
  }
~~~

- para a reprodução do áudio, utilizar a classe MediaPlayer, que fornece todos os métodos necessários para tocar, pausar, parar etc. 
- no início da função AudioPlayer, criar uma variável de estado para guardar a referência para o objeto MediaPlayer. 

~~~kotlin
@Composable
fun AudioPlayer(context: Context) {

  var player = remember {
    mutableStateOf(MediaPlayer.create(context, R.raw.music))
  }
}
~~~

- implementação do botão Play:

~~~kotlin
IconButton(onClick = {
    if (player.value == null){
      player.value = MediaPlayer.create(context, R.raw.music)
    }
    player.value.start()
  }) {
    Icon(
      painter = painterResource(id = R.drawable.play),
      contentDescription = ""
    )
  }
~~~

- implementação do botão Pause:

~~~kotlin
IconButton(onClick = {
    player.value.pause()
  }) {
    Icon(
      painter = painterResource(id = R.drawable.pause),
      contentDescription = ""
    )
  }
~~~

- implementação do botão Stop:

~~~kotlin
IconButton(onClick = {
    player.value.stop()
    player.value.reset()
    player.value.release()
    player.value = null
  }) {
    Icon(
      painter = painterResource(id = R.drawable.stop),
      contentDescription = ""
    )
  }
~~~

- quando pressionamos o botão stop, precisamos garantir que a variável player ficará totalmente limpa, por isso utilizamos os métodos reset() e release(), além de atualizarmos o valor para null.

## 2.2 Reproduzindo vídeos

- criar um projeto no Android Studio com o nome [Video Player](./projects/VideoPlayer/app/src/main/java/br/com/fiap/videoplayer/MainActivity.kt). 
- adicionar uma biblioteca externa chamada Exoplayer; no arquivo build.gradle(Module: app), adicionar às dependencies:

~~~kotlin
dependencies {

    implementation 'androidx.core:core-ktx:1.8.0'
    implementation platform('org.jetbrains.kotlin:kotlin-bom:1.8.0')
    implementation 'androidx.lifecycle:lifecycle-runtime-ktx:2.3.1'
    implementation 'androidx.activity:activity-compose:1.5.1'
    implementation platform('androidx.compose:compose-bom:2022.10.00')
    implementation 'androidx.compose.ui:ui'
    implementation 'androidx.compose.ui:ui-graphics'
    implementation 'androidx.compose.ui:ui-tooling-preview'
    implementation 'androidx.compose.material3:material3'
    testImplementation 'junit:junit:4.13.2'
    androidTestImplementation 'androidx.test.ext:junit:1.1.5'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.5.1'
    androidTestImplementation platform('androidx.compose:compose-bom:2022.10.00')
    androidTestImplementation 'androidx.compose.ui:ui-test-junit4'
    debugImplementation 'androidx.compose.ui:ui-tooling'
    debugImplementation 'androidx.compose.ui:ui-test-manifest'

    // Exoplayer
    implementation "com.google.android.exoplayer:exoplayer:2.19.0"
}
~~~

- na MainActivity.kt:

~~~kotlin
@Composable
fun VideoPlayer() {
  val videoUrl =
    "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"
  val context = LocalContext.current
  val player = ExoPlayer.Builder(context).build()
  val playerView = PlayerView(context)
  val mediaItem = MediaItem.fromUri(videoUrl)

  val playWhenReay by remember {
    mutableStateOf(true)
  }

  player.setMediaItem(mediaItem)
  playerView.player = player

  LaunchedEffect(player) {
    player.prepare()
    player.playWhenReady = playWhenReay
  }

  AndroidView(factory = {
    playerView
  })

}
~~~

<div align="center">
<h2>3. PUBLICANDO A APLICAÇÃO NO GOOGLE PLAY</h2>
</div>

## 3.1 Criação de conta no Google Play Console

- para publicar aplicações, criar uma conta de desenvolvedor, e efetuar o pagamento de US$25 dólares.
- o cadastro de uma conta de desenvolvedor deve ser feito no [console do Google Play](https://play.google.com/console/about/), e clicar no link "Go to Play Console" no canto superior direito da tela; se não tiver uma conta de desenvolvedor, será convidado a cria-la. 

## 3.2 Preparação do aplicativo para publicação

- gerar um pacote do tipo "aab" (Android App Bundle), um formato de publicação que inclui todos os recursos e código compilados do app.
- esse formato aab é o novo padrão de empacotamento de aplicativos para publicação utilizados pelo Google. 
- para criar um pacote aab, abrir o projeto que deseja publicar > clicar no menu Build > clicar na opção "Generate Signed Bundle / APK ..." > manter a opção "Android App Bundle" selecionada e pressionar Next > na próxima janela, clicat no botão "Create new..." > na janela "New Key Store", clicar no ícone de pasta no campo "Key store path" e selecionar o local e nome da chave > preencher seus dados no formulário para geração do certificado digital e clicar em OK > ao retornar para a janela "Generate Signed Bundle or APK", clicar em Next > na janela seguinte, selecionar release e pressionar o botão Create.

## 3.3 Criando o App no Google Play

- acessar o Google Play Console com a conta de desenvolvedor e clicar no botão "Criar App", no canto superior direito da tela.
- na janela "Detalhes do App", preencher os dados do seu App. 
- rolar a página para baixo e marcar o aceite dos termos de uso e clicar no botão "Criar app" no canto inferior direito da página.
- aguardar a aplicação ser criada.

--- 

[Voltar ao início!](https://github.com/monicaquintal/smart_cities)