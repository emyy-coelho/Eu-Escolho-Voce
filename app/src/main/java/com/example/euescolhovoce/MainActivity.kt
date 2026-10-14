package com.example.euescolhovoce

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.euescolhovoce.ui.theme.EuEscolhoVoceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EuEscolhoVoceTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    SorteioApp()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SorteioApp() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Desenhos da Infância")
        Spacer(modifier = Modifier.height(12.dp))
        ImagensPersonagens()
    }
}

@Composable
fun ImagensPersonagens(
    modifier: Modifier = Modifier) {
    var result by remember { mutableStateOf(1) }
    val imageResource = when(result){
        1 -> R.drawable.wonder_pets
        2 -> R.drawable.x_man
        3 -> R.drawable.sid_cientista
        4 -> R.drawable.phineas_ferb
        5 -> R.drawable.pantera_cor_rosa
        6 -> R.drawable.padrinhos_magicos
        7 -> R.drawable.os_simpsons
        8 -> R.drawable.o_mascara
        9 -> R.drawable.meninas_superpoderosas
        10 -> R.drawable.loony_toones
        11 -> R.drawable.kick
        12 -> R.drawable.jimmy_neutron
        13 -> R.drawable.coragem_o_cao_covarde
        14 -> R.drawable.beckardigans
        15 -> R.drawable.george
        16 -> R.drawable.caillou
        17 -> R.drawable.billy_mandy
        else -> R.drawable.arthur
    }
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(imageResource),
            contentDescription = result.toString()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {result = (1..18).random()}) {
            Text(stringResource(R.string.roll))
        }
    }
}