package br.com.fiap.buscarvagas

import android.content.Intent
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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.buscarvagas.ui.theme.BuscarVagasTheme
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.ui.text.style.TextAlign

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BuscarVagasTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Main()
                }
            }
        }
    }
}


@Composable
fun Main() {
    val scrollState = rememberScrollState()

    Box {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.verticalScroll(scrollState)
        ) {
            Row(
                verticalAlignment = Alignment.Top,
                modifier = Modifier
                    .background(Color(0xFF152B66))
                    .align(alignment = Alignment.Start)
                    .size(width = 500.dp, height = 60.dp)
            ) {}
            Spacer(modifier = Modifier.height(25.dp))
            Row {
                OutlinedTextField(modifier = Modifier.size(width = 350.dp, height = 60.dp),
                    value = "",
                    onValueChange = {},
                    placeholder = {
                        Text(text = "Pesquise por endereços")
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

            Column {
                Image(
                    painter = painterResource(id = R.drawable.imagemmapa),
                    contentDescription = "imagem de um mapa",
                    modifier = Modifier.size(width = 350.dp, height = 200.dp)
                )

            }

            Row {
                Text(text = "BASEADO EM SUA LOCALIZAÇÃO ATUAL:")
            }

            Spacer(modifier = Modifier.height(20.dp))

            Row {
                Text(
                    text = "VAGAS EM",
                    color = colorResource(id = R.color.laranjaApp),
                    fontSize = 20.sp
                )
            }

            Spacer(modifier = Modifier.height(20.dp))


            Column(
                modifier = Modifier
                    .padding(15.dp)
            ) {
                ParkingPlaceList()
            }

        }
    }

}

@Composable
fun ParkingPlaceList() {
    ParkingPlace(
        "Shopping Taboão",
        "Régis Bittencourt, 2643",
        "shopping do taboão",
        R.drawable.shoppingtaboao,
        "11 vagas disponíveis"
    )


    Spacer(modifier = Modifier.height(10.dp))

    ParkingPlace(
        "Drogasil",
        "Estr. São Francisco, 2131",
        "shopping do taboão",
        R.drawable.drogasil,
        "9 vagas disponíveis"
    )

    Spacer(modifier = Modifier.height(10.dp))

    ParkingPlace(
        "Assaí Atacadista",
        "R. João Batista, 340",
        "mercado assaí",
        R.drawable.assai,
        "10 vagas disponíveis"
    )

    Spacer(modifier = Modifier.height(10.dp))


}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ParkingPlace(
    name: String,
    address: String,
    contentDescription: String,
    image: Int = R.drawable.shoppingtaboao,
    vagas: String
) {
    val mContext = LocalContext.current

    Card(
        modifier = Modifier
            .height(140.dp)
            .fillMaxWidth(),
        onClick = {
            mContext.startActivity(Intent(mContext, ParkingActivity::class.java))
        },
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    )
    {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Column {
                Image(
                    painter = painterResource(id = image),
                    contentDescription = contentDescription
                )
            }


            Column {
                Text(text = "$name -",
                modifier = Modifier.offset(x = 30.dp))
                Text(text = address,
                modifier = Modifier.offset(x = 27.dp))
                Card(
                    modifier = Modifier
                        .width(200.dp)
                        .offset(x = 60.dp, y = 25.dp),
                        colors = CardDefaults.cardColors(containerColor = Color(0xC35EC762))
                ) {
                    Text(text = vagas,
                    modifier = Modifier.offset(x = 10.dp))
                }
            }
        }
    }
}


