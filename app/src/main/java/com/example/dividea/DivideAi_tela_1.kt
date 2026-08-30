    package com.example.dividea

    import android.content.Intent
    import android.os.Bundle
    import android.widget.Button
    import android.widget.EditText
    import androidx.activity.enableEdgeToEdge
    import androidx.appcompat.app.AppCompatActivity
    import androidx.core.view.ViewCompat
    import androidx.core.view.WindowInsetsCompat

    class DivideAi_tela_1 : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            enableEdgeToEdge()
            setContentView(R.layout.divide_ai_tela_1)
            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }

            val edtValorConta = findViewById<EditText>(R.id.edtValorConta)
            val edtNumeroPessoas = findViewById<EditText>(R.id.edtNumeroPessoas)
            val btnGorjeta0 = findViewById<Button>(R.id.btnGorjeta0)
            val btnGorjeta10 = findViewById<Button>(R.id.btnGorjeta10)
            val btnGorjeta15 = findViewById<Button>(R.id.btnGorjeta15)
            val btnGorjeta20 = findViewById<Button>(R.id.btnGorjeta20)
            val btnCalcular = findViewById<Button>(R.id.btnCalcular)

            var gorjetaSelecionada = 10

            btnGorjeta0.setOnClickListener {
                gorjetaSelecionada = 0
            }
            btnGorjeta10.setOnClickListener {
                gorjetaSelecionada = 10
            }
            btnGorjeta15.setOnClickListener {
                gorjetaSelecionada = 15
            }
            btnGorjeta20.setOnClickListener {
                gorjetaSelecionada = 20
            }
            btnCalcular.setOnClickListener {
                val valorConta = edtValorConta.text.toString()
                val numeroPessoas = edtNumeroPessoas.text.toString()
                if (valorConta.isEmpty()){
                    edtValorConta.error = "Digite o valor da conta"
                }
                if (numeroPessoas.isEmpty()){
                    edtNumeroPessoas.error = "Digite o número de pessoas"
                }
                if (valorConta.isNotEmpty() && numeroPessoas.isNotEmpty()){
                    val valorContaDouble = valorConta.toDouble()
                    val numeroPessoasInt = numeroPessoas.toInt()
                    if(numeroPessoasInt == 0){
                        edtNumeroPessoas.error = "Digite o número de pessoas"
                        return@setOnClickListener
                    }
                    val valorGorjeta = (valorContaDouble * gorjetaSelecionada) / 100
                    val totalConta = valorContaDouble + valorGorjeta
                    val valorPorPessoa = totalConta / numeroPessoasInt

                    val intent = Intent(this, DivideAi_tela_2::class.java)
                    intent.putExtra("VALOR_CONTA", valorContaDouble )
                    intent.putExtra("NUMERO_PESSOAS", numeroPessoasInt)
                    intent.putExtra("GORJETA", valorGorjeta)
                    intent.putExtra("PORCENTAGEM", gorjetaSelecionada)
                    intent.putExtra("TOTAL_CONTA", totalConta)
                    intent.putExtra("VALOR_POR_PESSOA", valorPorPessoa)
                    startActivity(intent)
                }



            }

        }
    }