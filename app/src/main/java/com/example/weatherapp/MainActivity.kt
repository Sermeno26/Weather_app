package com.example.weatherapp

import android.R
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Place
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }
    }
}
@Preview
@Composable
fun App() {
    var pantalla by remember { mutableStateOf(2) }

    if (pantalla == 1) {
        Pantalla1 { pantalla = 2 }
    } else {
        Pantalla2 { pantalla = 1 }
    }
}


@Composable
fun Pantalla1(onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(
                        Color(0xFF72EAFF),
                        Color(0xFF72C2FF),
                        Color(0xFF003888)
                    )
                )
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {


            Text("El Salvador", color = Color.White)
            Text("25°C", color = Color.White, fontSize = 40.sp)

            Spacer(modifier = Modifier.height(16.dp))

            Icon(
                imageVector = Icons.Default.Place,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(80.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = Color.White.copy(alpha = 0.2f)
                ),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Text("HUM\n65%", color = Color.White)
                    Text("VIENTO\n12 km/h", color = Color.White)
                    Text("LLUVIA\n10%", color = Color.White)
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = { },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White
                )
            ) {
                Box(
                    modifier = Modifier
                        .padding(horizontal = 12.dp, vertical = 6.dp)
                ) {
                    Text(
                        "ACTUALIZAR",
                        color = Color(0xFF1E4DB7)
                    )
                }
            }
        }
    }
}

//Pantalla 2
@Composable
fun Pantalla2(onBack: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(
                        Color(0xFFA0B5EB),
                        Color(0xFFEA52F8),
                        Color(0xFF0066FF)
                    )
                )
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {

            // HEADER
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = Color.Transparent
                ),
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("El Salvador", color = Color.White)
                    Text("25°C", color = Color.White, fontSize = 36.sp)
                    Text("Soleado", color = Color.White)
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // HORAS
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = Color.Transparent // 👈 SIN fondo
                ),
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("Pronostico por horas", color = Color.White)

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text("Ahora\n25°", color = Color.White)
                        Text("14:00\n26°", color = Color.White)
                        Text("16:00\n24°", color = Color.White)
                        Text("18:00\n22°", color = Color.White)
                        Text("20:00\n20°", color = Color.White)
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Card(
                colors = CardDefaults.cardColors(
                    containerColor = Color.White.copy(alpha = 0.2f)
                ),
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("Detalles", color = Color.White)

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text("Humedad\n65%", color = Color.White)
                        Text("Viento\n12 km/h", color = Color.White)
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text("Presión\n1012 hPa", color = Color.White)
                        Text("UV\n5", color = Color.White)
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Card(
                colors = CardDefaults.cardColors(
                    containerColor = Color.White.copy(alpha = 0.2f)
                ),
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("Pronóstico semanal", color = Color.White)

                    Text("Lun   28° / 22°", color = Color.White)
                    Text("Mar   27° / 21°", color = Color.White)
                    Text("Mié   26° / 20°", color = Color.White)
                    Text("Jue   25° / 19°", color = Color.White)
                    Text("Vie   24° / 18°", color = Color.White)
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

        }
    }
}