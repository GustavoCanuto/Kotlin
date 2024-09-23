package com.example.calculadoramobilekotlin

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Chama as views pelo ID
        val editTextNumero1 = findViewById<EditText>(R.id.numero1)
        val editTextNumero2 = findViewById<EditText>(R.id.numero2)
        val textViewResultado = findViewById<TextView>(R.id.tv_resultado)

        val btnSomar = findViewById<Button>(R.id.btn_somar)
        val btnSubtrair = findViewById<Button>(R.id.btn_subtrair)
        val btnMultiplicar = findViewById<Button>(R.id.btn_multiplicar)
        val btnDividir = findViewById<Button>(R.id.btn_dividir)

        // Adiciona as funcionalidades para os botões
        btnSomar.setOnClickListener {
            val numero1 = editTextNumero1.text.toString().toDoubleOrNull()
            val numero2 = editTextNumero2.text.toString().toDoubleOrNull()
            if (numero1 != null && numero2 != null) {
                val resultado = numero1 + numero2
                textViewResultado.text = "Resultado: %.2f".format(resultado)
            } else {
                textViewResultado.text = "Por favor, insira valores válidos"
            }
        }

        btnSubtrair.setOnClickListener {
            val numero1 = editTextNumero1.text.toString().toDoubleOrNull()
            val numero2 = editTextNumero2.text.toString().toDoubleOrNull()
            if (numero1 != null && numero2 != null) {
                val resultado = numero1 - numero2
                textViewResultado.text = "Resultado: %.2f".format(resultado)
            } else {
                textViewResultado.text = "Por favor, insira valores válidos"
            }
        }

        btnMultiplicar.setOnClickListener {
            val numero1 = editTextNumero1.text.toString().toDoubleOrNull()
            val numero2 = editTextNumero2.text.toString().toDoubleOrNull()
            if (numero1 != null && numero2 != null) {
                val resultado = numero1 * numero2
                textViewResultado.text = "Resultado: %.2f".format(resultado)
            } else {
                textViewResultado.text = "Por favor, insira valores válidos"
            }
        }

        btnDividir.setOnClickListener {
            val numero1 = editTextNumero1.text.toString().toDoubleOrNull()
            val numero2 = editTextNumero2.text.toString().toDoubleOrNull()
            if (numero1 != null && numero2 != null) {
                if (numero2 != 0.0) {
                    val resultado = numero1 / numero2
                    textViewResultado.text = "Resultado: %.2f".format(resultado)
                } else {
                    textViewResultado.text = "Erro: Divisão por zero!"
                }
            } else {
                textViewResultado.text = "Por favor, insira valores válidos"
            }
        }
    }
}
