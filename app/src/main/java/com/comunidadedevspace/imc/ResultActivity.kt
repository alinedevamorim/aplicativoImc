package com.comunidadedevspace.imc

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
const val KEY_RESULT_IMC = "ResultActivity.KEY_IMC"

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)

        val result = intent.getFloatExtra(KEY_RESULT_IMC, 0f)
        val tvResult = findViewById<TextView>(R.id.tv_result)
        val tvClassificacao = findViewById<TextView>(R.id.tv_classificacao)
        tvResult.text = result.toString()


        val classificacao: Any = if (result <= 18.5f) {
            "MAGREZA"
        } else if (result > 18.5f && result <= 24.9f) {
            "NORMAL"
        } else if (result > 25f && result <=29.9f) {
            "SOBREPESO"
        } else if (result > 30f && result <=39.9f) {
            "OBESIDADE"
        } else {
            "OBESIDADE GRAVE"
        }

        val color = when {
            result <= 18.5f -> R.color.red
            result > 18.5f && result <= 24.9f -> R.color.green
            result > 25f && result <= 29.9f -> R.color.yellow
            result > 30f && result <= 39.9f -> R.color.orange
            else -> R.color.red
        }

// Configura o texto e a cor
        tvClassificacao.text = classificacao as CharSequence?
        tvClassificacao.setTextColor(ContextCompat.getColor(this, color))





    }
}