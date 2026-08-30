package com.example.dividea

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DivideAi_tela_2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.divide_ai_tela2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val resultadoValorConta = findViewById<TextView>(R.id.txtResultadoValorConta)
        val resultadoGorjeta = findViewById<TextView>(R.id.txtResultadoGorjeta)
        val resultadoTotal = findViewById<TextView>(R.id.txtResultadoTotal)
        val resultadoCadaPessoa = findViewById<TextView>(R.id.txtResultadoCadaPessoa)
        val labelGorjeta = findViewById<TextView>(R.id.txtLabelGorjeta)
        val btnNovoCalculo = findViewById<Button>(R.id.btnNovoCalculo)

        val valorConta = intent.getDoubleExtra("VALOR_CONTA", 0.0)
        val numeroPessoas = intent.getIntExtra("NUMERO_PESSOAS", 0)
        val gorjeta = intent.getDoubleExtra("GORJETA", 0.0)
        val porcentagem = intent.getIntExtra("PORCENTAGEM", 0)
        val totalConta = intent.getDoubleExtra("TOTAL_CONTA", 0.0)
        val valorPorPessoa = intent.getDoubleExtra("VALOR_POR_PESSOA", 0.0)

        resultadoValorConta.text = "R$ %.2f".format(valorConta)
        resultadoGorjeta.text = "R$ %.2f".format(gorjeta)
        resultadoTotal.text = "R$ %.2f".format(totalConta)
        resultadoCadaPessoa.text = "R$ %.2f".format(valorPorPessoa)
        labelGorjeta.text = "Gorjeta ($porcentagem%)"

        btnNovoCalculo.setOnClickListener {
            finish()
        }
    }

}