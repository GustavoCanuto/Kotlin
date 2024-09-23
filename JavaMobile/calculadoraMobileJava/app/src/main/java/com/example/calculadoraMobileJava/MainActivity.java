package com.example.calculadoraMobileJava;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Chama as views pelo ID
        EditText editTextNumero1 = findViewById(R.id.numero1);
        EditText editTextNumero2 = findViewById(R.id.numero2);
        TextView textViewResultado = findViewById(R.id.tv_resultado);

        Button btnSomar = findViewById(R.id.btn_somar);
        Button btnSubtrair = findViewById(R.id.btn_subtrair);
        Button btnMultiplicar = findViewById(R.id.btn_multiplicar);
        Button btnDividir = findViewById(R.id.btn_dividir);

        // Adiciona as funcionalidades para os botões
        btnSomar.setOnClickListener(v -> {
            double numero1 = Double.parseDouble(editTextNumero1.getText().toString());
            double numero2 = Double.parseDouble(editTextNumero2.getText().toString());
            double resultado = numero1 + numero2;
            textViewResultado.setText(String.format("Resultado: %.2f", resultado));
        });

        btnSubtrair.setOnClickListener(v -> {
            double numero1 = Double.parseDouble(editTextNumero1.getText().toString());
            double numero2 = Double.parseDouble(editTextNumero2.getText().toString());
            double resultado = numero1 - numero2;
            textViewResultado.setText(String.format("Resultado: %.2f", resultado));
        });

        btnMultiplicar.setOnClickListener(v -> {
            double numero1 = Double.parseDouble(editTextNumero1.getText().toString());
            double numero2 = Double.parseDouble(editTextNumero2.getText().toString());
            double resultado = numero1 * numero2;
            textViewResultado.setText(String.format("Resultado: %.2f", resultado));
        });

        btnDividir.setOnClickListener(v -> {
            double numero1 = Double.parseDouble(editTextNumero1.getText().toString());
            double numero2 = Double.parseDouble(editTextNumero2.getText().toString());
            if (numero2 != 0) {
                double resultado = numero1 / numero2;
                textViewResultado.setText(String.format("Resultado: %.2f", resultado));
            } else {
                textViewResultado.setText("Erro: Divisão por zero!");
            }
        });
    }
}
