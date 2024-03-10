<div align="center">
<a href="https://github.com/monicaquintal" target="_blank"><img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/kotlin/kotlin-original.svg" width="100px" align="left"/></a>
<h1>FASE 1 - APP WORLD</h1>
<h2>Capítulo 10A: Internacionalização e Validação de entrada de dados.</h2>
</div>

<div align="center">
<h2>1. INTERNACIONALIZAÇÃO E VALIDAÇÃO DE ENTRADA DE DADOS</h2>
</div>

## 1.1 Internacionalização da aplicação

- quando desenvolvemos uma aplicação para Android,temos que ter em mente o seu alcance regional, ou seja, ele pode ter um alcance local para usuários de um único país ou pode ter um alcance mais globalizado, onde pessoas com diferentes idiomas poderão utilizá-lo.

### 1.1.1 Aplicativo de testes
- criar uma aplicação com uma única tela responsável pela autenticação do usuário.
- criar um projeto no Android Studio com o nome [Login](./projects/Login/app/src/main/java/br/com/fiap/login/MainActivity.kt). 
- após a criação do projeto, substituir o conteúdo do arquivo MainActivity.kt por:

~~~kotlin
package br.com.fiap.loginprof

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.loginprof.ui.theme.LoginProfTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      setContent {
        LoginProfTheme {
          Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
          ) {
            Login()
          }
        }
      }
    }
  }
  
  @OptIn(ExperimentalMaterial3Api::class)
  @Composable
  fun Login() {
  
    var email by remember() {
      mutableStateOf("")
    }
  
    var password by remember {
      mutableStateOf("")
    }
  
    Column(modifier = Modifier.padding(16.dp)) {
      Text(
        text = "Login",
        fontSize = 32.sp,
        fontWeight = FontWeight.Bold,
        color = Color.Blue
      )
      Text(text = "Por favor entre com seus dados")
      Spacer(modifier = Modifier.height(48.dp))
      Card(modifier = Modifier
        .fillMaxWidth()) {
          Column(modifier = Modifier
            .fillMaxWidth()
            .padding(32.dp)) {
            OutlinedTextField(
              value = email,
              onValueChange = { email = it },
              modifier = Modifier.fillMaxWidth(),
              label = {
                      Text(text = "Digite o seu e-mail")
              },
              keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email
              ),
            )
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
              value = password,
              onValueChange = { password = it },
              modifier = Modifier.fillMaxWidth(),
              label = {
                      Text(text = "Digite a sua senha")
              },
              keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
              ),
              visualTransformation = PasswordVisualTransformation()
            )
            Spacer(modifier = Modifier.height(32.dp))
            Button(onClick = { /*TODO*/ }) {
              Text(
                text = "ENTRAR",
                modifier = Modifier
                  .padding(8.dp)
                  .fillMaxWidth(),
                textAlign = TextAlign.Center
              )
            }
          }
      }
    }
  }
~~~

### 1.1.2 O arquivo strings.xml
- independentemente se deseja ou não que sua aplicação seja internacional, a verdade é que nunca devemos inserir os textos literais em nossa aplicação. 
- é muito comum que haja a necessidade de alterarmos alguma expressão que está contida em diversas telas e o esquecimento da alteração de uma delas torna nossa aplicação inconsistente e estranha ao usuário.
- é necessária a centralização do conteúdo textual da aplicação em um único lugar, e qualquer alteração efetivada neste local deverá refletir em toda a aplicação. 
  - para essa finalidade, o Android disponibiliza um arquivo chamado strings.xml, encontrado na ***pasta res*** do projeto.
- outra função do arquivo strings.xml é permitir que anossa aplicação seja multi-idioma, ou seja, nosso aplicativo poderá manter arquivos strings.xml para os mais diversos idiomas para os quais desejamos a tradução.
- o ideal é que o arquivo strings.xml default contenha os textos em um idioma padrão, que na maioria das vezes é o inglês.

### 1.1.3 Editando o arquivo strings.xml
- todos os textos em nossa aplicação estão inseridas de forma literal, o que não é uma boa prática.
- vamos editar o arquivo strings.xml default da aplicação adicionando os textos inicialmente em inglês.
- o arquivo strings.xml utiliza a notação XML, onde temos as tags que identificam os valores.

~~~xml
<resources>
  <string name="app_name">Login Prof</string>

  // Strings personalizadas para o inglês
  // que será o idioma padrão da aplicação
  <string name="login">Login</string>
  <string name="subtitle">Please, provide your information</string>
  <string name="email">Enter your e-mail</string>
  <string name="password">Enter your password</string>
  <string name="enter">Enter</string>
</resources>
~~~

### 1.1.4 Utilizando o arquivo strings.xml
- substituir todas as entradas de texto da aplicação para que utilize o arquivo strings.xml. 
- começar pelos textos de título e subtítulo da aplicação. 
- abrir o arquivo MainActivity.kt e fazer os ajustes:

~~~kotlin
Text(
  text = stringResource(id = R.string.login),
  fontSize = 32.sp,
  fontWeight = FontWeight.Bold,
  color = Color.Blue
)
Text(text = stringResource(id = R.string.subtitle))
Spacer(modifier = Modifier.height(48.dp))
~~~

- utilizada a `função stringResource` para fazer referência aos textos que estão inseridos no arquivo strings.xml. 
  - recebe como parâmetro a identificação do recurso de String que queremos utilizar.
  - agora a aplicação está com o idioma em inglês, pois temos apenas o arquivo padrão que tem o texto neste idioma. 
- se quisermos que a aplicação utilize o idioma português, criar outro arquivo strings.xml com o mesmo conteúdo do arquivo padrão, mas com as frases traduzidas. 

### 1.1.5 Traduzindo a aplicação para o idioma português
- para isso, precisamos de outro arquivo strings.xml que deve conter as mesmas tags do arquivo padrão, mas com o valor traduzido. 
- clicar com o botão direito do mouse na pasta res, apontar para New e clicar em Android Resource File.
- na janela New Resource File, digitar o nome do arquivo, que deve ser obrigatoriamente strings.
- em Available qualifiers, selecione Locale e clique no botão &gt;&gt;.
- na janela New Resource File, selecionar o idioma pt: Portuguese e a região BR: Brazil, e clicar em OK. 
- copiar o conteúdo do arquivo strings.xml default, abrir o arquivo strings.xml(pt-rBR) e colar o conteúdo. 

~~~xml
<resources>

    <string name="app_name">Login Prof</string>

    // Strings personalizadas para o inglês
    // que será o idioma padrão da aplicação
    <string name="login">Login</string>
    <string name="subtitle">Por favor, informe os seus dados</string>
    <string name="email">Digeite o seu e-mail</string>
    <string name="password">Digite a sua senha</string>
    <string name="enter">Entrar</string>

</resources>
~~~

- para testar a aplicação, trocar o idioma do dispositivo para português do Brasil.

> caso o dispositivo utilize um idioma para o qual o aplicativo não tenha tradução, será utilizado o arquivo padrão, por isso é importante que o arquivo strings.xml default tenha seu conteúdo traduzido para o inglês, que será o idioma padrão do aplicativo.

<div align="center">
<h2>2. VALIDAÇÃO DE ENTRADA DO USUÁRIO</h2>
</div>

- muitas vezes, é necessário que a entrada de dados obedeça a alguma regra, como uma senha que deve ter no mínimo 8 caracteres. 
- também é comum o desenvolvedor somente habilitar alguma funcionalidade caso todos os campos obrigatórios tenham sido preenchidos.
- como garantir que o usuário insira os dados do modo que a aplicação espera para que não ocorram erros ou funcionamento inesperados?

## 2.1 Limitando o tamanho da senha

- podemos utilizar vários artifícios para garantir que o usuário preencha uma caixa de entrada com os dados corretos. 
- uma forma que deve ser utilizada é abrir o teclado numérico quando o que esperamos do usuário sejam números, por exemplo.
- vamos validar a caixa de texto da senha para que permita a digitação de no máximo 8 caracteres:
  - na função Login do arquivo MainActivity.kt, adicionar uma variável que irá armazenar o tamanho máximo que este campo permitirá.

~~~kotlin
@Composable
fun Login() {

  var email by remember() {
    mutableStateOf("")
  }

  var password by remember {
    mutableStateOf("")
  }

  var tamanhoSenha = 8
// ...
}
~~~

- para limitar a quantidade de texto que poderá ser digitado no campo senha, implementar uma regra no parâmetro onValueChange.

~~~kotlin
OutlinedTextField(
    value = password,
    onValueChange = { if (it.length <= tamanhoSenha) password = it },
    modifier = Modifier.fillMaxWidth(),
    label = {
      Text(text = stringResource(id = R.string.password))
    },
    keyboardOptions = KeyboardOptions(
      keyboardType = KeyboardType.Password
    ),
    visualTransformation = PasswordVisualTransformation()
)
~~~

- a cada tecla digitada em um campo de texto, disparamos a função onValueChange, que retorna o valor desta caixa de texto através da variável it. 
- o que estamos fazendo neste exemplo é testando se o tamanho do texto retornado por it é menor ou igual à variável tamanhoSenha. 
  - se o teste lógico resultar em true, a variável de estado password recebe o valor da variável it, caso contrário, a variável password não é mais atualizada e consequentemente o estado deste componente, ou seja, não conseguimos digitar mais.

## 2.2 Validando o campo e-mail

- verificar se o campo e-mail foi preenchido ao ocorrer o clique no botão Entrar. 
- caso o e-mail não tenha sido preenchido, exibir uma mensagem ao usuário logo abaixo deste campo. 
- o composable OutlinedTextField e suas variações possuem um `atributo isError`, um booleano que quando recebe o valor true modifica a aparência do componente.
- adicionar este parâmetro com o valor true para observar o seu comportamento. 

~~~kotlin
OutlinedTextField(
    value = email,
    onValueChange = { email = it },
    modifier = Modifier.fillMaxWidth(),
    label = {
      Text(text = stringResource(id = R.string.email))
    },
    isError = true,
    keyboardOptions = KeyboardOptions(
      keyboardType = KeyboardType.Email
    ),
)
~~~

- ao executar a aplicação em um emulador, o campo referente ao e-mail estará com as bordas na cor vermelha, indicando um problema.
- para que este comportamento ocorra de uma forma mais adequada, criar uma variável de estado do tipo booleano que manterá o estado de erro para este campo. Ao clicarmos no botão, se o campo estiver vazio, mudamos o valor da variável para “true”. 

~~~kotlin
@OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Login() {
    
      var email by remember() {
        mutableStateOf("")
      }
    
      var password by remember {
        mutableStateOf("")
      }
    
      var emailError by remember {
        mutableStateOf(false)
      }
    
      var tamanhoSenha = 8
    
      Column(modifier = Modifier.padding(16.dp)) {
        Text(
          text = stringResource(id = R.string.login),
          fontSize = 32.sp,
          fontWeight = FontWeight.Bold,
          color = Color.Blue
        )
        Text(text = stringResource(id = R.string.subtitle))
        Spacer(modifier = Modifier.height(48.dp))
        Card(
          modifier = Modifier
            .fillMaxWidth()
        ) {
          Column(
            modifier = Modifier
              .fillMaxWidth()
              .padding(32.dp)
          ) {
            OutlinedTextField(
              value = email,
              onValueChange = { email = it },
              modifier = Modifier.fillMaxWidth(),
              label = {
                Text(text = stringResource(id = R.string.email))
              },
              isError = emailError,
              keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email
              ),
            )
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
              value = password,
              onValueChange = { 
                if (it.length <= tamanhoSenha) password = it 
              },
              modifier = Modifier.fillMaxWidth(),
              label = {
                Text(text = stringResource(id = R.string.password))
              },
              keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
              ),
              visualTransformation = PasswordVisualTransformation()
            )
            Spacer(modifier = Modifier.height(32.dp))
            Button(onClick = {
              if(email.isEmpty()){
                emailError = true
              }
            }) {
              Text(
                text = stringResource(id = R.string.enter),
                modifier = Modifier
                  .padding(8.dp)
                  .fillMaxWidth(),
                textAlign = TextAlign.Center
              )
            }
          }
        }
      }
    }
~~~

- nos trechos acima, ocorreram as implementações
  - criação de uma variável de estado chamada emailError, que é inicializada com o valor false.
  - atribuída a variável emailError ao parâmetro isError do componente responsável pelo e-mail.
  - na função onClick do botão Entrar, verificamos se a variável de estado email está vazia. Se o teste lógico resultar em “true”, alteramos o valor da variável “emailError” para “true”.
  - a caixa de texto responsável pela entrada do e-mail sofrerá a recomposição, tendo agora a borda vermelha.

- para o tratamento de erro ficar ainda mais interessante, incluir uma mensagem de texto logo abaixo da caixa de texto do e-mail, que deverá aparecer somente quando o e-mail estiver vazio. 

~~~kotlin
OutlinedTextField(
  value = email,
  onValueChange = { email = it },
  modifier = Modifier.fillMaxWidth(),
  label = {
    Text(text = stringResource(id = R.string.email))
  },
  isError = emailError,
  keyboardOptions = KeyboardOptions(
    keyboardType = KeyboardType.Email
  ),
)
if(emailError){
  Text(
    text = "E-mail é obrigatório!",
    modifier = Modifier.fillMaxWidth(),
    color = Color.Red,
    textAlign = TextAlign.End
  )
}
Spacer(modifier = Modifier.height(16.dp))
~~~

- no código acima, inserida após o e-mail uma condicional que verifica o valor da variável “emailError”. Se esta variável for “true”, o componente de texto com a mensagem de erro será exibido.
- para que a mensagem desapareça quando o usuário começar a digitar o e-mail:

~~~kotlin
OutlinedTextField(
  value = email,
  onValueChange = {
    email = it
    if (email.length > 0) emailError = false
  },
  modifier = Modifier.fillMaxWidth(),
  label = {
    Text(text = stringResource(id = R.string.email))
  },
  isError = emailError,
  keyboardOptions = KeyboardOptions(
    keyboardType = KeyboardType.Email
  ),
)
~~~

--- 

[Voltar ao início!](https://github.com/monicaquintal/smart_cities)