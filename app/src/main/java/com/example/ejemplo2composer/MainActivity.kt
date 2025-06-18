package com.example.ejemplo2composer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SumaDosNumeros()
//            val navController = rememberNavController()
//            NavHost(navController = navController, startDestination = "inicio") {
//                composable("inicio") { PantallaInicio(navController) }
//                composable("detalle/{nombre}") { backStackEntry ->
//                    val nombre = backStackEntry.arguments?.getString("nombre") ?: "Invitado"
//                    PantallaDetalle(navController, nombre)
//                }
//            }
        }
    }
}

@Composable
fun PantallaInicio(navController: NavHostController) {
    var nombre by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Pantalla de inicio")
        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Ingrese su nombre") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            navController.navigate("detalle/$nombre")
        }) {
            Text("Ir a detalle con nombre")
        }
    }
}

@Composable
fun PantallaDetalle(navController: NavController, nombre: String) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Hola $nombre")
        Button(onClick = {
            navController.navigate("inicio")
        }) {
            Text("Volver")
        }
    }
}