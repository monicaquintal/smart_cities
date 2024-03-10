package br.com.fiap.calculodejuros.juros

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.calculodejuros.calculos.calcularJuros
import br.com.fiap.calculodejuros.calculos.calcularMontante
import br.com.fiap.calculodejuros.components.CaixaDeEntrada
import br.com.fiap.calculodejuros.components.CardResultado

@Composable
fun JurosScreen(jurosScreenViewModel: JurosScreenViewModel) {

//  var capital by remember { mutableStateOf("") }
    val capital by jurosScreenViewModel
        .capitalState
        .observeAsState(initial = "")

//  var taxa by remember { mutableStateOf("") }
    val taxa by jurosScreenViewModel
        .taxaState
        .observeAsState(initial = "")

//  var tempo by remember { mutableStateOf("") }
    val tempo by jurosScreenViewModel
        .tempoState
        .observeAsState(initial = "")

//  var juros by remember { mutableStateOf(0.0) }
    val juros by jurosScreenViewModel
        .jurosState
        .observeAsState(initial = 0.0)

//  var montante by remember { mutableStateOf(0.0) }
    val montante by jurosScreenViewModel
        .montanteState
        .observeAsState(initial = 0.0)

    Box(
        modifier = Modifier.padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column() {
            Text(
                text = "Cálculo de Juros Simples",
                modifier = Modifier.fillMaxWidth(),
                fontSize = 30.sp,
                color = Color.DarkGray,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(32.dp))
            // Formulário para entrada de dados
            Card(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "Dados do Investimento",
                        fontWeight = FontWeight.Bold
                    )

                    // Caixas de entrada da aplicação
                    /*
                    OutlinedTextField (
                        value = capital,
                        onValueChange = { capital = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp),
                        placeholder = {
                            Text(text = "Quanto deseja investir?")
                        },
                        label = {
                            Text(text = "Valor do investimento")
                        },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Decimal
                        )
                    )

                        OutlinedTextField(
                        value = taxa,
                        onValueChange = { taxa = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp),
                        placeholder = {
                            Text(text = "Qual a taxa de juros mensal?")
                        },
                        label = {
                            Text(text = "Taxa de juros mensal")
                        },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Decimal
                        )
                    )
                    OutlinedTextField (
                        value = tempo,
                        onValueChange = { tempo = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp),
                        placeholder = {
                            Text(text = "Qual o tempo em meses?")
                        },
                        label = {
                            Text(text = "Período em meses")
                        },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Decimal
                        )
                    )
                     */

                    // Caixas de entrada da Aplicação
                    CaixaDeEntrada (
                        value = capital,
                        placeholder = "Quanto deseja investir?",
                        label = "Valor do investimento",
                        modifier = Modifier,
                        keyboardType = KeyboardType.Decimal
                    ) {
                        jurosScreenViewModel.onCapitalChanged(it)
                    }

                    CaixaDeEntrada (
                        value = taxa,
                        placeholder = "Qual a taxa de juros mensal?",
                        label = "Taxa de juros mensal",
                        modifier = Modifier,
                        keyboardType = KeyboardType.Decimal
                    ) {
                        jurosScreenViewModel.onTaxaChanged(it)
                    }

                    CaixaDeEntrada (
                        value = tempo,
                        placeholder = "Qual o período do investimento em meses?",
                        label = "Período em meses",
                        modifier = Modifier,
                        keyboardType = KeyboardType.Decimal
                    ) {
                        jurosScreenViewModel.onTempoChanged(it)
                    }

                    Button(
                        onClick = {
                            jurosScreenViewModel.calcularJurosInvestimento()
                            jurosScreenViewModel.calcularMontanteInvestimento()
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 32.dp)
                    ) {
                        Text(text = "CALCULAR")
                    }
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            /* Resultado da aplicação
            Card(
                modifier = Modifier
                    .fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFF4CAF50)
                )
            ) {
                Column(
                    modifier = Modifier
                        //.fillMaxSize()
                        .padding(16.dp)
                ) {
                    Text(
                        text = "Resultado",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Text(
                            text = "Juros",
                            modifier = Modifier.padding(end = 8.dp),
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = juros.toString(),
                            modifier = Modifier.padding(end = 8.dp),
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Text(
                            text = "Montante",
                            modifier = Modifier.padding(end = 8.dp),
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = montante.toString(),
                            modifier = Modifier.padding(end = 8.dp),
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    */
            // Resultado da aplicação
            CardResultado(juros = juros, montante = montante)
        }
    }
}