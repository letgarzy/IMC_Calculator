package com.example.imccalculator

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val btnCalcular = findViewById<Button>(R.id.btnCalcular)

        val edtPeso = findViewById<TextInputEditText>(R.id.edtPeso)
        val edtAltura = findViewById<TextInputEditText>(R.id.edtAltura)

        btnCalcular.setOnClickListener {

            val pesoTexto = edtPeso.text.toString()
            val alturaTexto = edtAltura.text.toString()
            if (pesoTexto.isEmpty()) {

                Toast.makeText(this, "Digite seu peso.", Toast.LENGTH_LONG).show()

            } else if (alturaTexto.isEmpty()) {

                Toast.makeText(this, "Digite sua altura.", Toast.LENGTH_LONG).show()

            } else {
                val peso = pesoTexto.toDouble()
                val altura = alturaTexto.toDouble()


                val imc = peso / (altura * altura)


                val intent = Intent(this, ResultadoActivity::class.java)

                intent.putExtra("VALOR_IMC", imc)

                startActivity(intent)

            }
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    override fun onResume() {
        super.onResume()

        findViewById<TextInputEditText>(R.id.edtPeso).text?.clear()
        findViewById<TextInputEditText>(R.id.edtAltura).text?.clear()
    }
}

        
    
                     