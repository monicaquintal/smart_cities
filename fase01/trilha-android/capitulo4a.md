<div align="center">
<a href="https://github.com/monicaquintal" target="_blank"><img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/kotlin/kotlin-original.svg" width="100px" align="left"/></a>
<h1>FASE 1 - APP WORLD</h1>
<h2>Capítulo 4A: Introdução ao Jetpack Compose.</h2>
</div>

<div align="center">
<h2>1. INTRODUÇÃO AO JETPACK COMPOSE</h2>
</div>

- é o kit de ferramentas oficial do Google para desenvolvimento de aplicativos de forma nativa para dispositivos Android. 
- segundo o Google, o Jetpack Compose simplifica e acelera o desenvolvimento de Interface do Usuário (IU) no Android. 
- atualmente grandes empresas já aderiram a esta nova forma de construir aplicativos Android, dentre elas: Google Play, Airbnb, Dropbox, Twitter, Booking, Adidas, Shopee etc.

## 1.1 O que é o Jetpack Compose?

- é um framework para IU declarativa.
- foi apresentado pela primeira vez à comunidade de desenvolvedores Android no Google I/O 2019, um evento utilizado pelo Google para falar sobre os novos recursos, ferramentas, tecnologias e tendências do universo Google, que também engloba o universo Android.
- o Jetpack Compose é um kit de ferramentas (`toolkit`), que entrega todos os recursos necessários para construir aplicativos Android de forma mais rápida, mais eficiente e escrevendo menos código.

## 1.2 Composables

- ao construir uma interface para Android utilizando Jetpack Compose, "quebramos" a interface em pequenos “pedaços” (`Composables`), que depois são combinados e reutilizados para criar interfaces mais complexas.
- é uma função em Kotlin que define a IU de um componente específico da tela.
- é responsável por descrever como um elemento de tela dever ser renderizado e se comportar. 
- um composable pode ser construído através de outros composables.
- quando criamos um composable, declaramos os elementos visuais, como textos, botões, imagens e listas, além de definir a lógica de interação e a aparência do componente.
- uma das grandes ***vantagens*** dos composables é a possibilidade de reutilizar componentes: criamos composables mais genéricos que serão utilizados em diferentes partes da interface da aplicação.
- o Jetpack Compose possui uma vasta gama de composables previamente construídos, que podemos utilizar para criar a interface da aplicação. Praticamente todos os componentes de interface mais comuns em uma aplicação Android já estão disponíveis e prontas para serem utilizadas. 

## 1.3 State

- uma das maiores dificuldades no desenvolvimento Android tradicional era controlar o estado da IU.
- o ***estado representa os dados que podem ser modificados e que afetam a aparência ou o comportamento dos componentes da interface***. 
  - `na abordagem tradicional`: 
    - fazemos a manipulação direta dos componentes de tela.
    - ou seja, se um dado é alterado e este exige que um texto mude a cor, é necessário fazermos essa mudança de forma imperativa, e isso vai ocorrer com cada componente da IU. 
    - quanto mais componentes de IU tivermos, maior será a complexidade em manter a aparência atualizada e, consequentemente, maior será a possibilidade de existência de bugs.
  - `no Jetpack Compose`:
    - o estado é declarativo e reativo.
    - nós definimos o estado inicial dos componentes e qualquer mudança neste estado inicial resultará em uma atualização total da IU de forma automática.

> O conceito de state trouxe uma grande vantagem para o desenvolvedor Android, que agora foca seu trabalho no que é realmente importante, como a lógica da IU e não mais na manipulação direta dos componentes de tela!

## 1.4 O novo e o antigo

- antes do Jetpack Compose, as views (que eram os componentes de tela do aplicativo Android) eram construídas através de XML, era necessário um arquivo separado para "desenhar" a tela.
- para alterar o estado das views era preciso obter, em Kotlin ou Java, a referência de cada view que deveria ser alterada, o que gerava bastante código e aumentava a complexidade. 
- com o Jetpack Compose, tudo fica em um único arquivo, onde descreve, em Kotlin, o que a IU deve conter e o Compose faz o resto. 
- exemplo:

### a) implementação com XML:

~~~kotlin
<?xml version="1.0" encoding="utf-8"?>
  <androidx.constraintlayout.widget.ConstraintLayout 
  xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <com.google.android.material.textfield.TextInputLayout
      android:layout_width="0dp"
      android:layout_height="wrap_content"
      android:layout_marginStart="32dp"
      android:layout_marginTop="32dp"
      android:layout_marginEnd="32dp"
      android:hint="O que você está procurando?"
      app:layout_constraintEnd_toEndOf="parent"
      app:layout_constraintStart_toStartOf="parent"
      app:layout_constraintTop_toTopOf="parent">

    <com.google.android.material.textfield.TextInputEditText
      android:layout_width="match_parent"
      android:layout_height="wrap_content"
      android:drawableEnd="@drawable/baseline_search_24" />
    </com.google.android.material.textfield.TextInputLayout>
  </androidx.constraintlayout.widget.ConstraintLayout>
~~~

### b) implementação com JetPack Compose:

~~~kotlin
@Composable
  fun SearchField() {
    Column() {
      OutlinedTextField(
        value = "",
        onValueChange = {},
        placeholder = { Text("O que você está procurando?") },
        trailingIcon = {
          Icon(
            painter = painterResource(
                id = R.drawable.baseline_search_24
          ),
          contentDescription = ""
        )
      })
    }
  }
~~~

- o Jetpack Compose utiliza uma quantidade de código menor, enquanto com XML precisamos de uma quantidade maior. 

## 1.5 Criação de um projeto Android com Jetpack Compose

~~~kotlin
package br.com.fiap.minhaidade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import br.com.fiap.minhaidade.ui.theme.MinhaIdadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MinhaIdadeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MeuComponente()
                }
            }
        }
    }
}

@Composable
fun MeuComponente() {
    Column() {
        Text(text = "Qual a sua idade?")
        Text(text = "Pressione os botões para informar a sua idade.")
        Row() {
            Button(onClick = { /*TODO*/ }) {
                Text(text = "-")
            }
            Button(onClick = { /*TODO*/ }) {
                Text(text = "+")
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MeuComponentePreview() {
    MeuComponente()
}
~~~

<div align="center">
<h2>2. CRIAÇÃO DE UM PROJETO COM JETPACK COMPOSE</h2>
</div>

- abrir o Android Studio e clicar no botão "New Project".
- na tela "New Project", selecionar o template "Empty Activity".
- preencher os dados do projeto e clicar no botão "Finish".

## 2.1 Estrutura de um projeto Jetpack Compose

- assim que o Android Studio finalizar a configuração do projeto, haverá um arquivo chamado `MainActivity.kt`, que será o ponto de partida para nossa aplicação.
  - é uma subclasse de "ComponentActivity".
  - é necessário para que a MainActivity utilize os métodos e propriedades do Jetpack Compose, como o "setContent", que permitirá a criação de um Composable que será a IU.
- o `método "setContent"` é chamado na função "onCreate" da Activity, que será utilizado para iniciar a aplicação.

~~~kotlin
override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
          MinhaIdadeTheme {
            // A surface container using the 'background' color from the theme
            Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
            ) {
            Greeting("Android")
            }
        }
    }   
}
~~~








--- 

[Voltar ao início!](https://github.com/monicaquintal/smart_cities)