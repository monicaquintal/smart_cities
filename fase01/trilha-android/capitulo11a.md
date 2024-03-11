<div align="center">
<a href="https://github.com/monicaquintal" target="_blank"><img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/kotlin/kotlin-original.svg" width="100px" align="left"/></a>
<h1>FASE 1 - APP WORLD</h1>
<h2>Capítulo 11A: Persistência de dados locais.</h2>
</div>

<div align="center">
<h2>1. PERSISTÊNCIA DE DADOS LOCAIS</h2>
</div>

## 1.1 Biblioteca Room

- durante o desenvolvimento de aplicações Android, há situações em que devemos armazenar dados localmente, seja porque não precisamos persisti-lo em um servidor remoto, seja porque precisamos que o usuário utilize a aplicação mesmo sem conexão de rede.
- permitir o uso da aplicação offline é uma habilidade que o desenvolvedor Mobile deve possuir.
- biblioteca Room: oferece uma camada de abstração sobre o SQLite, livrando o desenvolvedor da construção de códigos extensos.

### 1.1.1 Implementação do Room no projeto Android
- criar um projeto no Android Studio com o nome [Meus Contatos](./projects/MeusContatos/app/src/main/java/br/com/fiap/meuscontatos/). 
- adicionar as dependências da biblioteca Room no projeto: abrir o arquivo build.gradle(Module: app) e adicionar às dependencies:

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

  // Room DEPENDENCIES
  implementation 'androidx.room:room-runtime:2.5.2'
  annotationProcessor 'androidx.room:room-compiler:2.5.2'
  kapt 'androidx.room:room-compiler:2.5.2'
}
~~~

- antes de sincronizar as dependências, é necessário adicionar o plugin do processador de anotações do Kotlin (Kapt), então, no início do arquivo build.gradle (Module: app), adicionar a seguinte linha na sessão plugins:

~~~kotlin
plugins {
  id 'com.android.application'
  id 'org.jetbrains.kotlin.android'
  id 'kotlin-kapt'
}
~~~

- esse plugin é necessário para que possamos utilizar as anotações do Room.
- com as alterações efetuadas, sincronizar o Gradle para que os downloads sejam feitos.
- em seguida, ajustar o arquivo MainActivity.kt:

~~~kotlin
package br.com.fiap.meuscontatos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.meuscontatos.ui.theme.MeusContatosTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      MeusContatosTheme {
        Surface(
          modifier = Modifier.fillMaxSize(),
          color = MaterialTheme.colorScheme.background
        ) {
          Column {
            ContatosScreen()
          }
        }
      }
    }
  }
}

@Composable
fun ContatosScreen() {

  var nomeState = remember {
    mutableStateOf("")
  }

  var telefoneState = remember {
    mutableStateOf("")
  }

  var amigoState = remember {
    mutableStateOf(false)
  }

  Column {
    ContatoForm(
      nome = nomeState.value,
      telefone = telefoneState.value,
      amigo = amigoState.value,
      onNomeChange = {
        nomeState.value = it
      },
      onTelefoneChange = {
        telefoneState.value = it
      },
      onAmigoChange ={
        amigoState.value = it
      }
    )
    ContatoList()
  }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContatoForm(
  nome: String,
  telefone: String,
  amigo: Boolean,
  onNomeChange: (String) -> Unit,
  onTelefoneChange: (String) -> Unit,
  onAmigoChange: (Boolean) -> Unit
) {
  Column(
    modifier = Modifier.padding(16.dp)
  ) {
    Text(
      text = "Cadastro de contatos",
      fontSize = 24.sp,
      fontWeight = FontWeight.Bold,
      color = Color(
        0xFFE91E63
      )
    )
    Spacer(modifier = Modifier.height(8.dp))
    OutlinedTextField(
      value = nome,
      onValueChange = { onNomeChange(it) },
      modifier = Modifier.fillMaxWidth(),
      label = {
        Text(text = "Nome do contato")
      },
      keyboardOptions = KeyboardOptions(
        keyboardType = KeyboardType.Text,
        capitalization = KeyboardCapitalization.Words
      )
    )
    Spacer(modifier = Modifier.height(8.dp))
    OutlinedTextField(
      value = telefone,
      onValueChange = { onTelefoneChange(it) },
      modifier = Modifier.fillMaxWidth(),
      label = {
        Text(text = "Telefone do contato")
      },
      keyboardOptions = KeyboardOptions(
        keyboardType = KeyboardType.Phone
      )
    )
    Spacer(modifier = Modifier.height(8.dp))
    Row(
      verticalAlignment = Alignment.CenterVertically,
      modifier = Modifier.fillMaxWidth()
    ) {
      Checkbox(checked = amigo, onCheckedChange = {
        onAmigoChange(it)
      })
      Text(text = "Amigo")
    }
    Spacer(modifier = Modifier.height(16.dp))
    Button(
      onClick = { /*TODO*/ },
      modifier = Modifier.fillMaxWidth()
    ) {
     Text(
       text = "CADASTAR",
       modifier = Modifier.padding(8.dp)
     )
    }
  }
}

@Composable
fun ContatoList() {
  Column(modifier = Modifier
    .fillMaxSize()
    .padding(16.dp)
    .verticalScroll(rememberScrollState())
  ) {
    for (i in 0..10){
      ContatoCard()
      Spacer(modifier = Modifier.height(4.dp))
    }
  }
}

@Composable
fun ContatoCard() {
  Card(
    modifier = Modifier.fillMaxWidth(),
    colors = CardDefaults.cardColors(
      containerColor = Color.LightGray
    )
  ) {
    Row(
      verticalAlignment = Alignment.CenterVertically
    ) {
      Column(modifier = Modifier
        .padding(8.dp)
        .weight(2f)) {
        Text(
          text = "Nome do Contato",
          fontSize = 24.sp,
          fontWeight = FontWeight.Bold
        )
        Text(
          text = "8888-9999",
          fontSize = 16.sp,
          fontWeight = FontWeight.Bold
        )
        Text(
          text = "Amigo",
          fontSize = 16.sp,
          fontWeight = FontWeight.Bold
        )
      }
      IconButton(onClick = { /*TODO*/ }) {
        Icon(
          imageVector = Icons.Default.Delete,
          contentDescription = ""
        )
      }
    }
  }
}
~~~

- nesse caso, o que há de diferente é o uso do `atributo verticalScroll` do composable Column, que permitirá que o conteúdo da coluna seja rolável caso a matéria seja maior do que a coluna.
- além disso, utilizaso o `composable IconButton`, que é um botão que exibe apenas um ícone.

### 1.1.2 Estrutura do projeto
- para que o projeto fique organizado, criar os seguintes pacotes:
  - model: para armazenar nossas classes de objeto.
  - database: para armazenar as classes relacionados com o banco de dados.; e no pacote database, criar mais dois pacotes:
    - dao: para guardar as interfaces que representam as instruções que vamos executar no banco de dados SQLite.
    - repository: para guardar as classes utilizadas como fonte de dados da aplicação.


### 1.1.3 Criação do modelo Contato
- no pacote model, criar uma classe chamada Contato, que representará cada um dos contatos.

~~~kotlin
package br.com.fiap.meuscontatos.model

data class Contato(
  val id: Long = 0,
  val nome: String = "",
  val telefone: String = "",
  val amigo: Boolean = false
)
~~~

- a classe Contato é uma classe de dados, ou seja, possui apenas atributos que representa os dados de um objeto. 
- anotar essa classe de modo que o Room saiba que deve gerenciar esta classe e criar uma entidade relacionada no SQLite. 

~~~kotlin
package br.com.fiap.meuscontatos.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_contato")
data class Contato(
  @PrimaryKey(autoGenerate = true) val id: Long = 0,
  val nome: String = "",
  val telefone: String = "",
  @ColumnInfo(name = "is_amigo") val amigo: Boolean = false
)
~~~

- alterações realizadas:
  - @Entitiy: essa anotação indica ao Room que uma entidade para a classe Contato deverá ser criada no SQLite. A propriedade table_name indica que o nome da tabela no SQLite deverá ser "tbl_contato". Se table_name for omitido, será criada uma tabela com o mesmo nome da classe.
  - @PrimaryKey: indica que o atributo id da classe Contato será a chave-primária da tabela. O atributo autoGenerate indica que o identificador deverá ser gerado automaticamente, ou seja, não há a necessidade de cria-lo no momento de instanciação da classe Contato.
  - @ColumnInfo: essa anotação do atributo amigo permite a alteração de como o campo será criado na tabela no SQLite, neste caso estamos indicando que o campo deverá se chamar is_amigo. Se esta anotação for omitida, o campo terá o mesmo nome do atributo da classe.

### 1.1.4 Criação da interface dao (Data Access Object)
- Interface que abstrairá os métodos CRUD da aplicação para uma entidade. 
- criar a Interface ContatoDao no pacote dao. 
- adicionar os métodos que indicarão ao Room quais operações de CRUD deverão ser implementadas.

~~~kotlin
package br.com.fiap.meuscontatos.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import br.com.fiap.meuscontatos.model.Contato

@Dao
interface ContatoDao {

  @Insert
  fun salvar(contato: Contato): Long

  @Update
  fun atualizar(contato: Contato): Int

  @Delete
  fun excluir(contato: Contato): Int

  @Query("SELECT * FROM tbl_contato WHERE id = :id")
  fun buscarContatoPeloId(id: Int): Contato

  @Query("SELECT * FROM tbl_contato ORDER BY nome ASC")
  fun listarContatos(): List<Contato>
}
~~~

- anotações:
  - @Dao: indica que essa interface deve ser utilizada pelo Room.
  - @Insert: essa anotação indica ao Room que deve ser criado um método de inclusão de contato no banco de dados. O retorno da função "salvar" será o novo id gerado na tabela tbl_contato no banco de dados, por isso o retorno do tipo Long. A instrução INSERT do banco de dados será implementada pelo Room.
  - @Update: indica ao Room que deverá ser implementado um método para a atualização do contato no bando de dados. Essa função retorna a quantidade de registros que foram atualizados, por isso o retorno do tipo Int. A instrução UPDATE no banco de dados será implementada pelo Room.
  - @Query: indica ao Room que um método de consulta deverá ser implementado. Essa anotação permite a execução de qualquer estrutura da instrução SQL SELECT. Nesta anotação é necessário escrevermos a instrução SELECT que será executada no banco de dados. No código há duas funções com essa anotação: "buscarContatoPeloId", que deve resultar em apenas um contato, e a função "listarContatos", que terá como retorno uma lista de contatos, o que resultará no retorno de um objeto do tipo List de contatos.

### 1.1.5 Criação da classe que representa o banco de dados
- essa classe deverá retornar a instância do banco de dados para que os métodos CRUD possam ser executados.
- criar uma classe com o nome "ContatoDb" no pacote dao do projeto. 

~~~kotlin
package br.com.fiap.meuscontatos.database.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.fiap.meuscontatos.model.Contato

@Database(entities = [Contato::class], version = 1)
abstract class ContatoDb : RoomDatabase() {

  abstract fun contatoDao(): ContatoDao

  companion object {

    private lateinit var instance: ContatoDb

    fun getDatabase(context: Context): ContatoDb {
      if (!::instance.isInitialized) {
        instance = Room
          .databaseBuilder(
            context,
            ContatoDb::class.java,
            "contato_db"
          )
          .allowMainThreadQueries()
          .fallbackToDestructiveMigration()
          .build()
      }
      return instance
    }
  }
}
~~~

- a classe ContatoDb herda a classe RoomDatabase, que é abstrata, então a classe ContataoDb dever ser abstrata também.
- ainda nesta classe, temos uma função abstrata chamada contatoDao que é do tipo ContatoDao. Essa função é necessária para termos acesso aos métodos CRUD nela descritos.
- a função getDatabase() e o atributo instance se encontram dentro de um bloco companion object, que as tornam estáticas. Fazemos isso para aplicar o conceito de “Singleton” no retorno da função “getDatabase”, para garantir que sempre entregaremos aos consumidores desta classe uma única instância do banco de dados, o que garante consistência e economia de recursos do dispositivo do usuário. Observe que antes de retornarmos a instância, verificamos se ela já está iniciada ou não.
- para a criação da instância do banco de dados, utilizamos a função databaseBuilder, onde fornecemos os seguintes parâmetros:
  - context: representa a nossa aplicação.
  - ContatoDb::class.java: é a instância da classe que representa o banco de dados.
  - contato_db: é uma String com o nome do banco de dados. 
- além disso, adicionamos as funções:
  - allowMainThreadQueries: permitir que a persistência de dados ocorra no mesmo processo que gerencia a IU.
  - fallbackToDestructiveMigration: destrói o banco de dados e o recria a cada nova implementação.
  - build: cria a instancia do banco de dados.

### 1.1.6 Criaçãodo repositório de contatos
- o repositório desempenha um papel muito importante na estrutura do projeto, já que ele será responsável por acessar os métodos CRUD da aplicação. 
- criar no pacote repository uma classe com o nome ContatoRepository.

~~~kotlin
package br.com.fiap.meuscontatos.database.repository

import android.content.Context
import br.com.fiap.meuscontatos.database.dao.ContatoDb
import br.com.fiap.meuscontatos.model.Contato

class ContatoRepository(context: Context) {

  private val db = ContatoDb.getDatabase(context).contatoDao()

  fun salvar(contato: Contato): Long {
    return db.salvar(contato)
  }

  fun atualizar(contato: Contato): Int {
    return db.atualizar(contato)
  }

  fun excluir(contato: Contato): Int {
    return db.excluir(contato)
  }

  fun listarContatos(): List<Contato> {
    return db.listarContatos()
  }

  fun buscarContatoPeloId(id: Int): Contato {
    return db.buscarContatoPeloId(id)
  }
}
~~~

- a classe ContatoRepository recebe o parâmetro context da aplicação, o que será necessário para quando formos obter uma instância do banco de dados.
- também injetamos o banco de dados, através do atributo db, que receberá a instância do nosso banco de dados.
- os métodos da classe ContatoRepository utilizam a instância do banco de dados para efetuar o CRUD no BD, que foram declarados na Interface ContatoDao. Agora é só consumirmos tudo isso!!!

### 1.1.7 Gravando nosso primeiro contato
- abrir o arquivo MainActivity.kt e, na função ContatoForm, acrescentear as instruções necessárias para obtermos uma instância do repositório.

~~~kotlin
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContatoForm(
  nome: String,
  telefone: String,
  amigo: Boolean,
  onNomeChange: (String) -> Unit,
  onTelefoneChange: (String) -> Unit,
  onAmigoChange: (Boolean) -> Unit
) {
  // obter instância do repositório
  val context = LocalContext.current
  val contatoRepository = ContatoRepository(context)
  Column(
    modifier = Modifier.padding(16.dp)
  ) {
    Text(
    //...
)}}
~~~

- para criarmos uma instância do objeto ContatoRepository”, precisamos do contexto da aplicação, que está sendo obtido através da instrução LocalContext.current.
- implementar o clique do botão.

~~~kotlin
Button(
  onClick = {
    val contato = Contato(
      nome = nome,
      telefone = telefone,
      amigo = amigo
    )
    contatoRepository.salvar(contato = contato)
  },
  modifier = Modifier.fillMaxWidth()
) {
  Text(
    text = "CADASTAR",
    modifier = Modifier.padding(8.dp)
  )
}
~~~

- o que fizemos nesta implementação foi criar um objeto Contato referenciado pela variável contato, com os dados que estão preenchidos no formulário. 
- em seguida, chamamos a função salvar do objeto contatoRepository passando o objeto "contato" como argumento.

> O banco de dados "contato_db" será criado durante a primeira tentativa de interação com o banco. Após a primeira interação, a aplicação passará a utilizar o banco que foi criado.

- para verificar o local onde o banco de dados fica gravado no dispositivo Android:
   - com o emulador rodando, clique na aba "Device File Explorer".
   - navegue no sistema de arquivos do dispositivo até a pasta de dados do aplicativo (data -> data -> br.com.fiap.meuscontatos -> databases).

- executar a aplicação no emulador, preencher o formulário com os dados de um amigo e pressionar o botão “CADASTRAR”. Aparentemente nada aconteceu, mas se não receber uma mensagem de erro, o registro foi armazenado no banco de dados.
- em "Device File Explorer", clicar com o botão direito do mouse na pasta "br.com.fiap.meuscontatos" e clicar na opção "Synchronize".
- também é possível explorar o banco de dados que foi criado no dispositivo clicando na aba "App Inspection" na parte inferior do Android Studio.
- em seguida, dar um duplo clique no nome da tabela. À direita vemos os dados do amigo que acabamos de cadastrar. Marcar a opção Live updates, para acompanhar os registros sendo atualizados na tabela.

### 1.1.8 Listando os contatos
- a aplicação já permite o cadastro de novos contatos, agora precisamos exibir os contatos à medida que vão sendo cadastrados.
- criar uma variável de estado que será responsável por atualizar a lista de contatos da aplicação, além de criar uma instância da classe ContatoRepository. 

~~~kotlin
@Composable
fun ContatosScreen() {

  val context = LocalContext.current
  val contatoRepository = ContatoRepository(context)

  var nomeState = remember {
    mutableStateOf("")
  }

  var telefoneState = remember {
    mutableStateOf("")
  }

  var amigoState = remember {
    mutableStateOf(false)
  }

  var listaContatosState = remember {
    mutableStateOf(contatoRepository.listarContatos())
  }
  //...
}
~~~

- em seguida, passar a "listaContatosState" para a função ContatoList:

~~~kotlin
@Composable
fun ContatoList(contatos: List<Contato>) {
  Column(
    modifier = Modifier
      .fillMaxSize()
      .padding(16.dp)
      .verticalScroll(rememberScrollState())
  ) {
    for (contato in contatos) {
      ContatoCard(contato)
      Spacer(modifier = Modifier.height(4.dp))
    }
  }
}
~~~

- ajustar a chamada para ContatoList na função ContatosScreen, para que a lista seja passada como argumento:

~~~kotlin
Column {
  ContatoForm(
    nome = nomeState.value,
    telefone = telefoneState.value,
    amigo = amigoState.value,
    onNomeChange = {
      nomeState.value = it
    },
    onTelefoneChange = {
      telefoneState.value = it
    },
    onAmigoChange = {
      amigoState.value = it
    }
  )
  ContatoList(listaContatosState.value)
}
~~~

- a função ContatoList recebe a lista de contatos como argumento. A lista é iterada pelo laço de repetição for que passa o contato para a função ContatoCard. 
- ajustar a função ContatoCard:

~~~kotlin
@Composable
fun ContatoCard(contato: Contato) {
  Card(
    modifier = Modifier.fillMaxWidth(),
    colors = CardDefaults.cardColors(
      containerColor = Color.LightGray
    )
  ) {
    Row(
      verticalAlignment = Alignment.CenterVertically
    ) {
      Column(
        modifier = Modifier
          .padding(8.dp)
          .weight(2f)
      ) {
        Text(
          text = contato.nome,
          fontSize = 24.sp,
          fontWeight = FontWeight.Bold
        )
        Text(
          text = contato.telefone,
          fontSize = 16.sp,
          fontWeight = FontWeight.Bold
        )
        Text(
          text = if (contato.amigo) "Amigo" else "Contato",
          fontSize = 16.sp,
          fontWeight = FontWeight.Bold
        )
      }
      IconButton(onClick = { /*TODO*/ }) {
        Icon(
          imageVector = Icons.Default.Delete,
          contentDescription = ""
        )
      }
    }
  }
}
~~~

- executar a aplicação no emulador e verificar se os contatos já cadastrados são listados, mas ao cadastrar um novo contato ele não irá aparecer na lista, pois não estamos atualizando a variável listaContatosState que está sendo observada.
- refatorar a função ContatoForm para atualizar a variável listaContatosState durante a inclusão de um novo contato.

~~~kotlin
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContatoForm(
  nome: String,
  telefone: String,
  amigo: Boolean,
  onNomeChange: (String) -> Unit,
  onTelefoneChange: (String) -> Unit,
  onAmigoChange: (Boolean) -> Unit,
  atualizar: () -> Unit
) {
  // obter instância do repositório
  val context = LocalContext.current
  val contatoRepository = ContatoRepository(context)
//...
}
~~~

- acrescentamos uma função lambda como parâmetro para a função ContatoForm, de modo que, ao chamarmos o formulário, possamos passar uma função para atualização da lista de contatos. 
- a implementação do clique do botão deve ser alterada:

~~~kotlin
. . . trecho de código omitido
Button(
  onClick = {
    val contato = Contato(
      nome = nome,
      telefone = telefone,
      amigo = amigo
    )
    contatoRepository.salvar(contato = contato)
    atualizar()
  },
  modifier = Modifier.fillMaxWidth()
) {
  Text(
    text = "CADASTAR",
    modifier = Modifier.padding(8.dp)
  )
}
~~~

- para finalizar, precisamos passar a função de atualização durante a chamada da função de composição ContatoForm:

~~~kotlin
. . . trecho de código omitido
Column {
  ContatoForm(
    nome = nomeState.value,
    telefone = telefoneState.value,
    amigo = amigoState.value,
    onNomeChange = {
      nomeState.value = it
    },
    onTelefoneChange = {
      telefoneState.value = it
    },
    onAmigoChange = {
      amigoState.value = it
    },
    atualizar = {
      listaContatosState.value = contatoRepository.listarContatos()
    }
  )
  ContatoList(listaContatosState.value)
}
~~~

### 1.1.9 Exclusão de contatos
- na lista de contatos há um botão para excluir o contato; implementar esta funcionalidade. 
- o código da função ContatoCard deverá se parecer com:

~~~kotlin
@Composable
fun ContatoCard(
  contato: Contato,
  context: Context,
  atualizar: () -> Unit
) {
  Card(
    modifier = Modifier.fillMaxWidth(),
    colors = CardDefaults.cardColors(
      containerColor = Color.LightGray
    )
  ) {
    Row(
      verticalAlignment = Alignment.CenterVertically
    ) {
      Column(
        modifier = Modifier
          .padding(8.dp)
          .weight(2f)
      ) {
        Text(
          text = contato.nome,
          fontSize = 24.sp,
          fontWeight = FontWeight.Bold
        )
        Text(
          text = contato.telefone,
          fontSize = 16.sp,
          fontWeight = FontWeight.Bold
        )
        Text(
          text = if (contato.amigo) "Amigo" else "Contato",
          fontSize = 16.sp,
          fontWeight = FontWeight.Bold
        )
      }
      IconButton(onClick = {
        val contatoRepository = ContatoRepository(context)
        contatoRepository.excluir(contato)
        atualizar()
      }) {
        Icon(
          imageVector = Icons.Default.Delete,
          contentDescription = ""
        )
      }
    }
  }
}
~~~

- a função ContatoList também deverá ser ajustada para passar os argumentos da função ContatoCard:

~~~kotlin
@Composable
fun ContatoList(contatos: List<Contato>, atualizar: () -> Unit) {
  Column(
    modifier = Modifier
      .fillMaxSize()
      .padding(16.dp)
      .verticalScroll(rememberScrollState())
  ) {
    for (contato in contatos) {
      ContatoCard(contato, context = LocalContext.current, atualizar)
      Spacer(modifier = Modifier.height(4.dp))
    }
  }
}
~~~

- deste modo, a função ContatosScreen que chama a função ContatoList deverá fornecer a função atualizar. 
- código completo da função ContatosScreen:

~~~kotlin
@Composable
fun ContatosScreen() {

  val context = LocalContext.current
  val contatoRepository = ContatoRepository(context)

  var nomeState = remember {
    mutableStateOf("")
  }

  var telefoneState = remember {
    mutableStateOf("")
  }

  var amigoState = remember {
    mutableStateOf(false)
  }

  var listaContatosState = remember {
    mutableStateOf(contatoRepository.listarContatos())
  }

  Column {
    ContatoForm(
      nome = nomeState.value,
      telefone = telefoneState.value,
      amigo = amigoState.value,
      onNomeChange = {
        nomeState.value = it
      },
      onTelefoneChange = {
        telefoneState.value = it
      },
      onAmigoChange = {
        amigoState.value = it
      },
      atualizar = {
        listaContatosState.value = contatoRepository.listarContatos()
      }
    )
    ContatoList(listaContatosState.value){
      listaContatosState.value = contatoRepository.listarContatos()
    }
  }
}
~~~

--- 

[Voltar ao início!](https://github.com/monicaquintal/smart_cities)