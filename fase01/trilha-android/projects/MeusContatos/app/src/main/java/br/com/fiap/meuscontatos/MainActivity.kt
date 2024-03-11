package br.com.fiap.meuscontatos

import android.content.Context
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.meuscontatos.database.repository.ContatoRepository
import br.com.fiap.meuscontatos.model.Contato
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
            onAmigoChange ={
                amigoState.value = it
            },
            atualizar = {
                listaContatosState.value = contatoRepository.listarContatos()
            }
        )
        ContatoList(listaContatosState.value) {
            listaContatosState.value = contatoRepository.listarContatos()
        }
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
    onAmigoChange: (Boolean) -> Unit,
    atualizar: () -> Unit
) {
    // obter instância do repositório
    val context = LocalContext.current
    val contatoRepository = ContatoRepository(context)
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
    }
}

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
            Column(modifier = Modifier
                .padding(8.dp)
                .weight(2f)) {
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
                    text = if(contato.amigo) "Amigo" else "Contato",
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