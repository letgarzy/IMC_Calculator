package com.example.imccalculator

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class ResultadoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_resultado)

        val btnCalcularNovamente = findViewById<Button>(R.id.btnCalcularNovamente)

        btnCalcularNovamente.setOnClickListener {
            finish()
        }

        val txtValorImc = findViewById<TextView>(R.id.txtValorImc)

        val imcRecebido = intent.getDoubleExtra("VALOR_IMC", 0.0)

        txtValorImc.text = String.format("%.2f", imcRecebido)

        val classificacao = when {
            imcRecebido < 18.5 -> "Abaixo do peso"
            imcRecebido < 25 -> "Peso normal"
            imcRecebido < 30 -> "Sobrepeso"
            imcRecebido < 35 -> "Obesidade grau I"
            imcRecebido < 40 -> "Obesidade grau II"
            else -> "Obesidade grau III"
        }

        val txtClassificacao = findViewById<TextView>(R.id.txtClassificacao)
        txtClassificacao.text = classificacao


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }

    }
}