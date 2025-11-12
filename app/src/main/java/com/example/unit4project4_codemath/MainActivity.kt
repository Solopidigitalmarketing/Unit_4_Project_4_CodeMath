package com.example.unit4project4_codemath

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.text.style.TextAlign
import com.example.unit4project4_codemath.ui.theme.Unit4Project4CodeMathTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Unit4Project4CodeMathTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TipCalculator()
                }
            }
        }
    }
}

@Composable
fun TipCalculator() {
    var billInput by remember { mutableStateOf("") }
    var tipPercent by remember { mutableStateOf(21f) }

    val bill = billInput.toDoubleOrNull() ?: 0.0
    val tipAmount = bill * tipPercent / 100
    val total = bill + tipAmount

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {

        Text("Tip Calculator", fontSize = 26.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(bottom = 16.dp))

        // Bill input
        Text("Base", fontSize = 18.sp, modifier = Modifier.fillMaxWidth())
        OutlinedTextField(
            value = billInput,
            onValueChange = { billInput = it },
            label = { Text("Bill Amount") },
            placeholder = { Text("Enter bill amount") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )

        // Tip slider
        Text("Tip: ${tipPercent.toInt()}%", fontSize = 18.sp, modifier = Modifier.fillMaxWidth())
        Slider(
            value = tipPercent,
            onValueChange = { tipPercent = it },
            valueRange = 0f..50f,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Tip Amount
        Text("Tip", fontSize = 18.sp, modifier = Modifier.fillMaxWidth())
        Text(
            text = "$${"%.2f".format(tipAmount)}",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Start,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Total
        Text("Total", fontSize = 18.sp, modifier = Modifier.fillMaxWidth())
        Text(
            text = "$${"%.2f".format(total)}",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Start,
            modifier = Modifier.fillMaxWidth()
        )
    }
}
