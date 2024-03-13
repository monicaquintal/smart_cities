<div align="center">
<a href="https://github.com/monicaquintal" target="_blank"><img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/kotlin/kotlin-original.svg" width="100px" align="left"/></a>
<h1>FASE 1 - APP WORLD</h1>
<h2>Capítulo 12A: Listas e Consumo de API externa.</h2>
</div>

<div align="center">
<h2>1. LISTAS E CONSUMO DE API EXTERNA</h2>
</div>

## 1.1 Lazy Column

- uma das tarefas mais comuns quando desenvolvemos aplicações Android é exibir informações na forma de lista, como uma lista de produtos, de contatos, de mensagens etc.
- anteriormente ao Jetpack Compose utilizávamos um componente chamado `RecyclerView`, bastante trabalhoso. 
- hoje, a construção desses componentes se tornou simples com a utilização dos `composables LazyColumn e LazyRow`.
- exploraremos a utilização do LazyColumn.
- criar um projeto no Android Studio chamado [Listas Lazy]() e apagar as funções Greeting e GreetingPreview.
  - criar 2 pacotes: model e repository.
    - no pacote model, criar uma classe de dados chamada "Game".

~~~kotlin
package br.com.fiap.listaslazy.model

data class Game(
  val id: Long = 0,
  val title: String = "",
  val studio: String = "",
  val releaseYear: Int = 0
)
~~~

- no pacote repository, criar um arquivo "GamesList.kt".

~~~kotlin
package br.com.fiap.listaslazy.repository

import br.com.fiap.listaslazy.model.Game

fun getAllGames(): List<Game> {
  return listOf(
    Game(id = 1, title = "Double Dragon", studio = "Technos", releaseYear = 1987),
    Game(id = 2, title = "Batletoads", studio = "Tradewest", releaseYear = 1991),
    Game(id = 3, title = "Enduro", studio = "Activision", releaseYear = 1983),
    Game(id = 4, title = "Ikari Warriors", studio = "SNK", releaseYear = 1986),
    Game(id = 5, title = "Captain Commando", studio = "Capcom", releaseYear = 1991),
    Game(id = 6, title = "Mario Bros", studio = "Nintendo", releaseYear = 1983),
    Game(id = 7, title = "Tiger Heli", studio = "Taito", releaseYear = 1985),
    Game(id = 8, title = "Mega Man", studio = "Capcom", releaseYear = 1987),
    Game(id = 9, title = "Gradius", studio = "Konami", releaseYear = 1985),
    Game(id = 10, title = "Gun Fight", studio = "Taito", releaseYear = 1975)
  )
}

fun getGamesByStudio(studio: String): List<Game>{
  return getAllGames().filter {
    it.studio.startsWith(prefix = studio, ignoreCase = true)
  }
}
~~~

- o arquivo GamesList.kt implementa a função getAllGames(), que retorna uma lista com dez games e a função getGamesByStudio(), que retorna uma lista de games cujo nome do estúdio começa com o valor do argumento studio, ignorando maiúsculas e minúsculas.
- criar a interface do usuário (arquivo MainActivity.kt):

~~~kotlin
package br.com.fiap.listaslazy

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.listaslazy.repository.getGamesByStudio
import br.com.fiap.listaslazy.ui.theme.ListasLazyTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    Log.i("aaa", getGamesByStudio("Capcom").toString())
    setContent {
      ListasLazyTheme {
        Surface(
          modifier = Modifier.fillMaxSize(),
          color = MaterialTheme.colorScheme.background
        ) {
          GamesScreen()
        }
      }
    }
  }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GamesScreen() {
  Column(modifier = Modifier.padding(16.dp)) {
    Text(
      text = "Meus jogos favoritos",
      fontSize = 24.sp,
      fontWeight = FontWeight.Bold
    )
    Spacer(modifier = Modifier.height(16.dp))
    OutlinedTextField(
      value = "",
      onValueChange = {},
      modifier = Modifier.fillMaxWidth(),
      label = {
        Text(text = "Nome do estúdio")
      },
      trailingIcon = {
        IconButton(onClick = { /*TODO*/ }) {
          Icon(
            imageVector = Icons.Default.Search,
            contentDescription = ""
          )
        }
      }
    )
    Spacer(modifier = Modifier.height(16.dp))
  }
}
~~~

### 1.1.1 Implementando a LazyColumn

- podemos criar listas utilizando Column em conjunto com algum laço de repetição, mas isso deve ser feito para exibir listas pequenas, para evitar problemas de performance.
- quando trabalhamos com listas muito grandes, a melhor opção é a utilização da LazyColumn, que posiciona na lista apenas os itens visíveis, e o restante da lista vai sendo inserido de acordo com a rolagem da lista, garantindo uma performance superior.
- implementar a função GamesScreen no arquivo MainActivity.kt:

~~~kotlin
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GamesScreen() {
  Column(modifier = Modifier.padding(16.dp)) {
    Text(
      text = "Meus jogos favoritos",
      fontSize = 24.sp,
      fontWeight = FontWeight.Bold
    )
    Spacer(modifier = Modifier.height(16.dp))
    OutlinedTextField(
      value = "",
      onValueChange = {},
      modifier = Modifier.fillMaxWidth(),
      label = {
        Text(text = "Nome do estúdio")
      },
      trailingIcon = {
        IconButton(onClick = { /*TODO*/ }) {
          Icon(
            imageVector = Icons.Default.Search,
            contentDescription = ""
          )
        }
      }
    )
    Spacer(modifier = Modifier.height(16.dp))
    LazyColumn(){
      items(getAllGames()){
        Column() {
          Text(text = it.title)
        }
      }
    }
  }
}
~~~

- melhorar a exibição dos games utilizando um Card e adicionando as outras informações.
- criar uma função chamada GameCard no MainActivity.kt, que será responsável por renderizar cada item da lista.

~~~kotlin
@Composable
fun GameCard(game: Game) {
  Card(modifier = Modifier.padding(bottom = 8.dp)) {
    Row(
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = Arrangement.SpaceBetween,
      modifier = Modifier
      .fillMaxWidth()
    ) {
      Column(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp).weight(3f)) {
        Text(
          text = game.title,
          fontSize = 20.sp,
          fontWeight = FontWeight.Bold
        )
        Text(
          text = game.studio,
          fontSize = 14.sp,
          fontWeight = FontWeight.Normal
        )
      }
      Text(
        text = game.releaseYear.toString(),
        modifier = Modifier.weight(1f).fillMaxWidth(),
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        color = Color.Blue
      )
    }
  }
}
~~~ 

- ajustar a função GamesScreen para que utilize a função GameCard:

~~~kotlin
Spacer(modifier = Modifier.height(16.dp))
LazyColumn(){
  items(getAllGames()){
    GameCard(game = it)
  }
}
~~~

### 1.1.2 Implementação da funcionalidade de busca

- para implementar a funcionalidade de busca, é necessário controlar o estado da aplicação, tanto para a digitação no campo de busca quanto para a lista de games.
- criar as variáveis de estado no início da função GameScreen.

~~~kotlin
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GamesScreen() {

  var searchTextState by remember {
    mutableStateOf("")
  }

  var gamesListState by remember {
    mutableStateOf(getAllGames())
  }
}
~~~

- outro ajuste que deve ser feito é passar o estado para a função "items" da LazyColumn:

~~~kotlin
Spacer(modifier = Modifier.height(16.dp))
LazyColumn(){
  items(gamesListState){
    GameCard(game = it)
  }
}
~~~

- configurar o campo de busca para capturar a digitação do usuário:

~~~kotlin
OutlinedTextField(
  value = searchTextState,
  onValueChange = {
    searchTextState = it
  },
  modifier = Modifier.fillMaxWidth(),
  trailingIcon = {
    IconButton(onClick = {}) {
      Icon(
        imageVector = Icons.Default.Search,
        contentDescription = ""
      )
    }
  }
)
~~~

- implementar a função onClick no IconButton:

~~~kotlin
OutlinedTextField(
  value = searchTextState,
  onValueChange = {
    searchTextState = it
  },
  modifier = Modifier.fillMaxWidth(),
  trailingIcon = {
    IconButton(onClick = {
      gamesListState = getGamesByStudio(searchTextState)
    }) {
      Icon(
        imageVector = Icons.Default.Search,
        contentDescription = ""
      )
    }
  }
)
~~~

- colocar na função onValueChange do campo de busca a instrução para buscar o game pelo estúdio, e agora a busca ocorrerá enquanto o usuário digita!

## 1.2 LazyRow









--- 

[Voltar ao início!](https://github.com/monicaquintal/smart_cities)