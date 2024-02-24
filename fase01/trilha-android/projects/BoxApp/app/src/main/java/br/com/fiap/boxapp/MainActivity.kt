package br.com.fiap.boxapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.fiap.boxapp.ui.theme.BoxAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BoxAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BoxScreen()
                }
            }
        }
    }
}

@Composable
fun BoxScreen() {
    Box(contentAlignment = Alignment.TopEnd) {
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier.align(Alignment.BottomEnd)
        ) {
            Text(text = "Clique aqui")
        }
        Text(
            text = "FIAP",
            modifier = Modifier.align(Alignment.TopStart)
        )
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 150.dp, y=120.dp)
        ) {
            Text(text = "Outro botão")
        }
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .offset(x = 20.dp, y = 10.dp)
        ) {
            Text(text = "Mais um botão")
        }
    }
}