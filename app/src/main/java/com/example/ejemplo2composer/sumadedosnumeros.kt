package com.example.ejemplo2composer

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun SumaDosNumeros() {
    var num1 by remember { mutableStateOf("") }
    var num2 by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("") }
    var selectedOperation by remember { mutableStateOf("Sum") } // Default operation

    val operations = listOf(
        "Sumar" to "Sum",
        "Restar" to "Subtract",
        "Multiplicar" to "Multiply",
        "Dividir" to "Divide"
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        TextField(
            value = num1,
            onValueChange = { num1 = it },
            label = { Text("Numero 1") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        TextField(
            value = num2,
            onValueChange = { num2 = it },
            label = { Text("Numero 2") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Radio buttons for operations
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            operations.forEach { (labelText, operationKey) ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.wrapContentWidth()
                ) {
                    RadioButton(
                        selected = selectedOperation == operationKey,
                        onClick = { selectedOperation = operationKey }
                    )
                    Text(text = labelText)
                }
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = {
            val n1 = num1.toDoubleOrNull()
            val n2 = num2.toDoubleOrNull()

            resultado = if (n1 != null && n2 != null) {
                when (selectedOperation) {
                    "Sum" -> "Resultado: ${n1 + n2}"
                    "Subtract" -> "Resultado: ${n1 - n2}"
                    "Multiply" -> "Resultado: ${n1 * n2}"
                    "Divide" -> {
                        if (n2 != 0.0) {
                            "Resultado: ${n1 / n2}"
                        } else {
                            "No se puede dividir por cero"
                        }
                    }
                    else -> "Seleccione una operación"
                }
            } else {
                "Ingrese numeros validos"
            }
        }) {
            Text("Calcular")
        }
        Text(text = resultado)
    }
}