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
- criar um projeto no Android Studio chamado [Listas Lazy](./projects/ListasLazy/app/src/main/java/br/com/fiap/listaslazy/) e apagar as funções Greeting e GreetingPreview.
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

- a implementação da LazyRow é tão simples quanto a LazyColumn.
- a única diferença é que a lista será apresentada na horizontal.

### 1.2.1 Implementação da LazyRow
- construir uma lista horizontal com os estúdios da lista de games.
- criar uma função chamada StudioCard no arquivo MainActivity.kt.

~~~kotlin
@Composable
fun StudioCard(game: Game) {
  Card(modifier = Modifier.size(100.dp).padding(end = 4.dp)) {
    Column(
      verticalArrangement = Arrangement.Center,
      horizontalAlignment = Alignment.CenterHorizontally,
      modifier = Modifier.fillMaxSize()
    ) {
      Text(text = game.studio)
    }
  }
}
~~~

- a lista de estúdios ficará acima da lista de games; ajustar a função GamesScreen.

~~~kotlin
Spacer(modifier = Modifier.height(16.dp))
LazyRow(){
  items(gamesListState){
    StudioCard(game = it)
  }
}
Spacer(modifier = Modifier.height(16.dp))
LazyColumn() {
  items(gamesListState) {
    GameCard(game = it)
  }
}
~~~

<div align="center">
<h2>2. CONSUMINDO API EXTERNA</h2>
</div>

## 2.1 API REST

- uma API REST funciona seguindo o modelo cliente-servidor, ou seja, temos um cliente que faz uma requisição solicitando algum recurso e o servidor atende essa requisição fornecendo o recurso requisitado. 
- os recursos podem ser imagens, arquivos HTML ou simplesmente texto. 
- geralmente os recursos envolvidos tanto na requisição quanto na resposta em um webservice HTTP usando o padrão REST são textos em formato JSON ou XML.

## 2.2 A biblioteca Retrofit

- é uma das bibliotecas mais populares para consumo de APIs REST no Android, fornecendo uma forma rápida, eficiente e segura de executar requisições HTTP e fácil gerenciamento das respostas.
- essa biblioteca nos permite trabalhar com os formatos de dados mais utilizados como o JSON e XML, sendo o JSON o formato dominante.
- a conversão de objetos para JSON e vice e versa é feito de maneira transparente ao desenvolvedor através da utilização de diversos conversores disponíveis, como Gson, Jackson, Moshi etc.

## 2.3 Projeto Consulta CEP

- o projeto realizará a consulta em uma API pública responsável por devolver os dados de um endereço a partir de um CEP ou através de uma parte do endereço conhecido, como nome da rua, cidade, estado etc.U
- utilizaremos a [API do ViaCep](https://viacep.com.br/).
- criar um projeto com o nome [Consulta CEP](./projects/ConsultaCEP/app/src/main/java/br/com/fiap/consultacep/) e apagar os métodos Greeting e GreetingPreview. 

~~~kotlin
package br.com.fiap.consultacep

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.consultacep.ui.theme.ConsultaCEPTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      ConsultaCEPTheme {
        Surface(
          modifier = Modifier.fillMaxSize(),
          color = MaterialTheme.colorScheme.background
        ) {
          CepScreen()
        }
      }
    }
  }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CepScreen() {

  var cepState by remember { mutableStateOf("") }
  var ufState by remember { mutableStateOf("") }
  var cidadeState by remember { mutableStateOf("") }
  var ruaState by remember { mutableStateOf("") }

  Column(
    modifier = Modifier
      .fillMaxWidth()
      .padding(16.dp)
  ) {
    Card(modifier = Modifier.fillMaxWidth()) {
      Column(
        modifier = Modifier
          .fillMaxWidth()
          .padding(16.dp)
      ) {
        Text(text = "CONSULTA CEP", fontSize = 24.sp)
        Text(
          text = "Encontre o seu endereço",
          fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(32.dp))
        OutlinedTextField(
          value = cepState,
          onValueChange = {
            cepState = it
          },
          modifier = Modifier.fillMaxWidth(),
          label = {
            Text(text = "Qual o CEP procurado?")
          },
          trailingIcon = {
            IconButton(onClick = { /*TODO*/ }) {
              Icon(
                imageVector = Icons.Default.Search,
                contentDescription = ""
              )
            }
          },
          keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number
          )
        )
        Spacer(modifier = Modifier.height(32.dp))
        Text(
          text = "Não sabe o CEP?",
          fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row() {
          OutlinedTextField(
            value = ufState,
            onValueChange = {
              ufState = it
            },
            modifier = Modifier
              .weight(1f)
              .padding(end = 4.dp),
            label = {
              Text(text = "UF?")
            },
            keyboardOptions = KeyboardOptions(
              capitalization = KeyboardCapitalization.Characters,
              keyboardType = KeyboardType.Text
            )
          )
          Spacer(modifier = Modifier.height(8.dp))
          OutlinedTextField(
            value = cidadeState,
            onValueChange = {
              cidadeState = it
            },
            modifier = Modifier.weight(2f),
            label = {
              Text(text = "Qual a cidade?")
            },
            keyboardOptions = KeyboardOptions(
              keyboardType = KeyboardType.Text,
              capitalization = KeyboardCapitalization.Words
            )
          )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
          OutlinedTextField(
            value = ruaState,
            onValueChange = {
              ruaState = it
            },
            modifier = Modifier.weight(2f),
            label = {
              Text(text = "O que lembra do nome da rua?")
            },
            keyboardOptions = KeyboardOptions(
              keyboardType = KeyboardType.Text,
              capitalization = KeyboardCapitalization.Words
            )
          )
          IconButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Default.Search, contentDescription = "")
          }
        }
      }
    }
    Spacer(modifier = Modifier.height(8.dp))
    LazyColumn() {
      items(120) {
        CardEndereco()
      }
    }
  }
}

@Composable
fun CardEndereco() {
  Card(modifier = Modifier
    .fillMaxWidth()
    .padding(bottom = 4.dp)) {
    Column(modifier = Modifier
      .fillMaxWidth()
      .padding(8.dp)
    ) {
      Text(text = "CEP:")
      Text(text = "Rua:")
      Text(text = "Cidade:")
      Text(text = "Bairro:")
      Text(text = "UF:")
    }
  }
}
~~~

- criar os pacotes model e service no pacote principal do projeto. 
- no pacote model, criar uma classe de dados chamada Cep.

~~~kotlin
package br.com.fiap.consultacep.model

data class Endereco(
  val cep: String = "",
  val rua: String = "",
  val cidade: String = "",
  val bairro: String = "",
  val uf: String = ""
)
~~~

### 2.3.1 Dependências do Retrofit

- acrescentar na sessão dependencies do arquivo build.gradle (Module: app) as dependências do Retrofit para o projeto. 

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
      
      // Dependências do Retrofit
      implementation 'com.squareup.retrofit2:retrofit:2.9.0'
      implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
      
  }
~~~

- a URL para consulta de um CEP no webservice da ViaCep retorna o seguinte JSON:

~~~json
{
    "cep": "01001-000",
    "logradouro": "Praça da Sé",
    "complemento": "lado ímpar",
    "bairro": "Sé",
    "localidade": "São Paulo",
    "uf": "SP",
    "ibge": "3550308",
    "gia": "1004",
    "ddd": "11",
    "siafi": "7107"
}
~~~

- porém, não utilizaremos todos os atributos da resposta, e alguns nomes que utilizamos na classe Endereco é diferente do nome do atributo que recebemos do ViaCep. 
  - é importante que o nome dos atributos na classe seja igual aos nomes dos atributos do JSON da resposta que recebemos!
- agora que temos a biblioteca Retrofit disponível no projeto, fazer alguns ajustes na classe de dados “Endereco” para que tudo funcione corretamente.

~~~kotlin
package br.com.fiap.consultacep.model

import com.google.gson.annotations.SerializedName

data class Endereco(
  val cep: String = "",
  @SerializedName("logradouro") val rua: String = "",
  @SerializedName("localidade") val cidade: String = "",
  val bairro: String = "",
  val uf: String = ""
)
~~~

- a `anotação @SerializedName` é necessária quando queremos utilizar o nome do atributo da nossa classe diferente do nome do atributo devolvido pela API. 
  - nesse caso a API devolve o atributo "logradouro", mas queremos utilizar "rua". 
  - essa anotação permite que o conversor de JSON para objeto consiga localizar os atributos relacionados.
- criar no pacote "service" uma inteface chamada CepService.

~~~kotlin
package br.com.fiap.consultacep.service

import br.com.fiap.consultacep.model.Endereco
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface CepService {

  //https://viacep.com.br/ws/01001000/json/
  @GET("{cep}/json/")
  fun getEndereco(@Path("cep") cep: String): Call<Endereco>

  //https://viacep.com.br/ws/RS/Porto%20Alegre/Domingos/json/
  @GET("{uf}/{cidade}/{rua}/json/")
  fun getEnderecos(
    @Path("uf") uf: String,
    @Path("cidade") cidade: String,
    @Path("rua") rua: String
  ): List<Call<Endereco>>
  
}
~~~

- a interface CepService possui dois métodos de requisição GET, por conta da `anotação @GET`, que recebe como argumento a parte da URL que é específica para cada requisição. 
- ambos os métodos retornam um objeto do tipo Call, que contém a resposta do servidor REST da ViaCep.
- a `anotação @Path` indica que a chave que se encontra na URL deverá ser substituída pelo valor do argumento passado na chamada do método.
- criar uma classe chamada RetrofitFactory no pacote service, que fará o papel de cliente HTTP (ela que fará as requisições para o servidor da ViaCep).

~~~kotlin
package br.com.fiap.consultacep.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactory {

  private val URL = "https://viacep.com.br/ws/"

  private val retrofitFactory = Retrofit
    .Builder()
    .baseUrl(URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

  fun getCepService(): CepService {
    return retrofitFactory.create(CepService::class.java)
  }

}
~~~

- a variável URL armazena a URL base (parte que é fixa para qualquer requisição ao webservice), e o restante da URL será fornecido pela anotação @GET da interface que possui os métodos de requisição que serão utilizados.

### 2.3.2 Executando as chamadas para a API
- executar a chamada para o endpoint da ViaCep responsável por nos entregar uma lista de endereços quando fornecemos o estado, a cidade e parte do nome da rua. 
- o método que vamos utilizar será o getEnderecos(), que nos devolve uma lista de endereços com base no estado, cidade e rua fornecidos pelo usuário.
- criar uma variável de estado que guardará a lista de endereços devolvidos pela API.

~~~kotlin
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CepScreen() {

  var cepState by remember { mutableStateOf("") }
  var ufState by remember { mutableStateOf("") }
  var cidadeState by remember { mutableStateOf("") }
  var ruaState by remember { mutableStateOf("") }

  var listaEnderecoState by remember { mutableStateOf(listOf<Endereco>()) }
}
~~~

- implementar a chamada (Call) para o servidor da ViaCep. Faremos a chamada no clique do segundo botão “buscar”. 

~~~kotlin
Row(verticalAlignment = Alignment.CenterVertically) {
      OutlinedTextField(
        value = ruaState,
        onValueChange = {
          ruaState = it
        },
        modifier = Modifier.weight(2f),
        label = {
          Text(text = "O que lembra do nome da rua?")
        },
        keyboardOptions = KeyboardOptions(
          keyboardType = KeyboardType.Text,
          capitalization = KeyboardCapitalization.Words
        )
      )
      IconButton(onClick = {
        val call = RetrofitFactory().getCepService().getEnderecos(ufState, cidadeState, ruaState)
        call.enqueue(object : Callback<List<Endereco>>{
          override fun onResponse(
            call: Call<List<Endereco>>,
            response: Response<List<Endereco>>
          ) {
            listaEnderecoState = response.body()!!
          }
    
          override fun onFailure(call: Call<List<Endereco>>, t: Throwable) {
            TODO("Not yet implemented")
          }
    
        })
      }) {
        Icon(imageVector = Icons.Default.Search, contentDescription = "")
      }
    }
~~~

- no código acima, criamos um objeto Call para o método getEnderecos da interface CepService, onde passamos o estado, cidade e rua, através das variáveis de estado. 
- quando efetuamos a chamada, o servidor devolverá uma resposta que será armazenada no argumento response do método onResponse da chamada.
- neste momento, atribuímos à variável de estado listaEnderecoState o valor retornado pela função body() do objeto response, que é a lista de endereço devolvida pelo endpoint da ViaCep.
- implementar algumas alterações na função “CardEndereco” para que possamos carregar cada item da LazyColumn com os endereços da listaEnderecoState.

~~~kotlin
@Composable
fun CardEndereco(endereco: Endereco) {
  Card(modifier = Modifier
    .fillMaxWidth()
    .padding(bottom = 4.dp)) {
    Column(modifier = Modifier
      .fillMaxWidth()
      .padding(8.dp)
    ) {
      Text(text = "CEP: endereco.cep")
      Text(text = "Rua: endereco.rua")
      Text(text = "Cidade: endereco.cidade")
      Text(text = "Bairro: endereco.bairro")
      Text(text = "UF: endereco.uf")
    }
  }
}
~~~

- para finalizar,

~~~kotlin
Spacer(modifier = Modifier.height(8.dp))
LazyColumn() {
  items(listaEnderecoState) {
    CardEndereco(it)
  }
}
~~~

- antes de executar a aplicação, permitir que o app tenha acesso a rede, a partir do arquivo “AndroidManifest.xml”:

~~~kotlin
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools">

    <uses-permission android:name="android.permission.INTERNET"/>

    <application
        android:allowBackup="true"
        android:dataExtractionRules="@xml/data_extraction_rules"
~~~

--- 

[Voltar ao início!](https://github.com/monicaquintal/smart_cities)