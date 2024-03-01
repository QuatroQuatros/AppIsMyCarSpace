package br.com.fiap.buscarvagas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.buscarvagas.ui.theme.BuscarVagasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BuscarVagasTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Teste()
                }
            }
        }
    }
}


@Composable
fun Teste() {
    Box() {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                verticalAlignment = Alignment.Top,
                modifier = Modifier
                    .background(Color(0xFF152B66))
                    .align(alignment = Alignment.Start)
                    .size(width = 500.dp, height = 60.dp)
            ) {}
            Spacer(modifier = Modifier.height(25.dp))
            Row () {
                OutlinedTextField(modifier = Modifier.size(width = 350.dp, height = 60.dp),
                    value = "",
                    onValueChange = {},
                    placeholder = {
                        Text(text = "Régis Bittencourt, 2643")
                    }
//                trailingIcon = {
//                    Icon(
//                        painter = painterResource(id = R.drawable.baseline_search_24),
//                        contentDescription = "botão de busca"
//                    )
//                }
                )
            }
            Spacer(modifier = Modifier.height(25.dp))
            Column() {
                Image(
                    painter = painterResource(id = R.drawable.imagemmapa),
                    contentDescription = "imagem de um mapa",
                    modifier = Modifier.size(width = 350.dp, height = 200.dp))

            }
            Row() {
                Text(text = "BASEADO EM SUA LOCALIZAÇÃO ATUAL:")
            }
            Spacer(modifier = Modifier.height(20.dp))

            Row() {
                Text(text = "VAGAS EM",
                    color = colorResource(id = R.color.laranjaApp),
                    fontSize = 20.sp
                )
            }
            Spacer(modifier = Modifier.height(20.dp))

            Column(modifier = Modifier.padding(15.dp)) {
//                Card(modifier = Modifier
//                    .height(140.dp)
//                    .fillMaxWidth(),
//                    colors = CardDefaults.cardColors(containerColor = Color(0xFFDADADA))) {
//
//                }
                Card(modifier = Modifier
                    .height(140.dp)
                    .fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp))
                {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Column {
                            Image(painter = painterResource(id = R.drawable.shoppingtaboao), contentDescription = "imagem de um shopping")
                        }

                        Column {
                            Text(text = "Shopping Taboão -")
                            Text(text = "Régis Bittencourt, 2643")
                        }
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                Card(modifier = Modifier
                    .height(140.dp)
                    .fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp))
                {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Column {
                            Image(painter = painterResource(id = R.drawable.shoppingtaboao), contentDescription = "imagem de um shopping")
                        }

                        Column {
                            Text(text = "Shopping Taboão -")
                            Text(text = "Régis Bittencourt, 2643")
                        }
                    }
                }
            }

        }
    }

}


