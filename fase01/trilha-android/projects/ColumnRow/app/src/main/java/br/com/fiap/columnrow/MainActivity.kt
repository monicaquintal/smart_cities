package br.com.fiap.columnrow

import android.graphics.Paint.Align
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.fiap.columnrow.ui.theme.ColumnRowTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ColumnRowTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ColumnRowScreen()
                }
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)

@Composable
fun ColumnRowScreen() {
    // Column principal
    Column(
        modifier = Modifier
            .background(Color.Cyan)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .background(Color.Magenta)
                .fillMaxWidth()
                .height(300.dp)) {
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Botão 01")
            }
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Botão 01")
            }
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Botão 01")
            }
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Botão 01")
            }
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .background(Color.Green)
        ) {
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Botão 02")
            }
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Botão 02")
            }
        }
        Row(modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .background(Color.Yellow)) {
            Column(modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(8.dp)
                .background(Color.Red)
                .weight(0.3f)) {
                // Aqui vai o conteúdo
            }
            Column(modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(8.dp)
                .background(Color.Blue)
                .weight(0.7f)) {
                // Aqui vai o conteúdo
            }
        }
    }
}
