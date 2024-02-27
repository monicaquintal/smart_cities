package br.com.fiap.basiccomponents

import android.os.Bundle
import android.view.Surface
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Person
// import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.basiccomponents.ui.theme.BasicComponentsTheme
import br.com.fiap.basiccomponents.ui.theme.Righteous
import java.time.format.TextStyle

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicComponentsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BasicComponentsScreen()
                }
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)

@Composable
fun BasicComponentsScreen() {

    var textFieldValue = remember {
        mutableStateOf("")
    }

    var quantidade = remember {
        mutableStateOf("")
    }

    Column(modifier = Modifier
        .fillMaxWidth()
        .background(Color.LightGray)
    ) {
        Text(
            text = "Hello,",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color(237,20,91),
            fontFamily = FontFamily.Serif,
            modifier = Modifier
                .background(Color.Yellow)
                .fillMaxWidth(),
            textAlign = TextAlign.End
        )
        Text(
            text = "Testando Componentes Básicos!",
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.White,
            fontFamily = Righteous,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        TextField(
            value = textFieldValue.value,
            onValueChange = { novoValor -> textFieldValue.value = novoValor},
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Words),
            label = {
                Text(text = "Insira nome e sobrenome.")
            },
            leadingIcon = {
                Icon (
                    imageVector = Icons.Default.Person,
                    contentDescription = "",
                    tint = Color(237,20,91)
                )
            }
        )
        TextField(
            value = "${quantidade.value}",
            onValueChange = { novoValor ->
                quantidade.value = novoValor
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            placeholder = {
                Text(text = "Qual a quantidade?")
            },
            colors = TextFieldDefaults.textFieldColors (
                focusedIndicatorColor = Color.White,
                unfocusedIndicatorColor = Color.Green,
                placeholderColor = Color.Magenta
            ),
            trailingIcon = {
                Icon (
                    imageVector = Icons.Default.Add,
                    contentDescription = "",
                    tint = Color(237,20,91)
                )
            }
        )
        Spacer(modifier = Modifier.height(32.dp))

        var cidade = remember {
            mutableStateOf("")
        }

        OutlinedTextField(
            value = cidade.value,
            onValueChange = {
                cidade.value = it },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            textStyle = androidx.compose.ui.text.TextStyle(color = Color.White),
            shape = RoundedCornerShape(16.dp),
            colors = TextFieldDefaults.textFieldColors (
                focusedIndicatorColor = Color.Yellow,
                unfocusedIndicatorColor = Color.Cyan
            )
        )
        Spacer(modifier = Modifier.height(32.dp))

        var opcao1 = remember {
            mutableStateOf(true)
        }

        var opcao2 = remember {
            mutableStateOf(false)
        }

        var opcao3 = remember {
            mutableStateOf(false)
        }

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = opcao1.value,
                onCheckedChange = { opcao1.value = it },
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
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = opcao2.value,
                onCheckedChange = { opcao2.value = it },
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.White,
                    uncheckedColor = Color(0xffed145b)
                )
            )
            Text(
                text = "Opção 2",
                color = Color.White
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = opcao3.value,
                onCheckedChange = { opcao3.value = it },
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.White,
                    uncheckedColor = Color(0xffed145b)
                )
            )
            Text(
                text = "Opção 3",
                color = Color.White
            )
        }
        Spacer(modifier = Modifier.height(32.dp))

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
                Text (
                    text = "MacOS",
                    color = Color.White)
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
                Text(
                    text = "GNU/Linux",
                    color = Color.White)
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
                Text(
                    text = "Windows 11",
                    color = Color.White)
            }
        }
        Button(
            onClick = { cidade.value = "Unidade Paulista" },
            modifier = Modifier.size(width = 200.dp, height = 60.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Magenta),
            border = BorderStroke(width = 3.dp, color = Color.White),
            shape = RoundedCornerShape(32.dp)
        ) {
            Text(text = "Clique aqui!")
        }
        OutlinedButton(
            onClick = { cidade.value = "Outra Unidade" }
        ) {
            Text(text = "Outro botão :)")
        }
        OutlinedButton(
            onClick = { cidade.value = ""}
        ) {
            Text(text = "Limpar")
        }
    }
}