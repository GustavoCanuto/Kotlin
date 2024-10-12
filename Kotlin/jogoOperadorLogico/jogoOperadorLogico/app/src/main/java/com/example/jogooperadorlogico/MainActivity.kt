package com.example.jogooperadorlogico

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.graphics.Color
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    // Variáveis dos objetos em tela
    lateinit var sentenca1: TextView
    lateinit var sentenca2: TextView
    lateinit var operadorLogico: TextView
    lateinit var tvPontos: TextView
    lateinit var botaoVerdadeiro: RadioButton
    lateinit var botaoFalso: RadioButton
    lateinit var botaoContinuar: Button
    lateinit var botaoSair: Button
    var pontos = 0
    var resultadoFinal: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Capturar os objetos de Tela
        sentenca1 = findViewById(R.id.tvSentenca1)
        sentenca2 = findViewById(R.id.tvSentenca2)
        operadorLogico = findViewById(R.id.tvLogico)
        tvPontos = findViewById(R.id.tvPontos)
        botaoVerdadeiro = findViewById(R.id.rbVerdadeiro)
        botaoFalso = findViewById(R.id.rbFalso)
        botaoContinuar = findViewById(R.id.btnContinuar)
        botaoSair = findViewById(R.id.btnSair)

        // Listener para o botão Continuar (somente ao clicar em continuar a validação será feita)
        botaoContinuar.setOnClickListener {
            // Verificar se o jogador escolheu verdadeiro ou falso
            if (botaoVerdadeiro.isChecked || botaoFalso.isChecked) {
                // Desativar os botões após seleção
                botaoVerdadeiro.isEnabled = false
                botaoFalso.isEnabled = false

                // Validar resposta
                val jogadorAcertou = (botaoVerdadeiro.isChecked && resultadoFinal) ||
                        (botaoFalso.isChecked && !resultadoFinal)

                if (jogadorAcertou) {
                    pontos += 10
                    tvPontos.setBackgroundColor(Color.GREEN)
                    tvPontos.setTextColor(Color.BLACK) // Texto preto com fundo verde
                } else {
                    pontos -= 10
                    tvPontos.setBackgroundColor(Color.RED)
                    tvPontos.setTextColor(Color.WHITE) // Texto branco com fundo vermelho
                }

                // Atualizar os pontos na tela
                tvPontos.text = "Pontos: $pontos"
            }

            // Gerar nova sentença para a próxima rodada
            val n1 = sortearNumero()
            val n2 = sortearNumero()
            val n3 = sortearNumero()
            val n4 = sortearNumero()

            val opRel1 = sortearOperadorRelacional()
            val opRel2 = sortearOperadorRelacional()

            val resultadoSentenca1 = resultadoSentencaRelacional(n1, opRel1, n2)
            val resultadoSentenca2 = resultadoSentencaRelacional(n3, opRel2, n4)

            sentenca1.text = "$n1 $opRel1 $n2"
            sentenca2.text = "$n3 $opRel2 $n4"

            val opLogico = sortearOperadorLogico()
            operadorLogico.text = opLogico

            resultadoFinal = resultadoSentencaLogica(resultadoSentenca1, opLogico, resultadoSentenca2)

            // Reativar os botões para a próxima rodada
            botaoVerdadeiro.isEnabled = true
            botaoFalso.isEnabled = true
            botaoVerdadeiro.isChecked = false
            botaoFalso.isChecked = false
        }

        // Listener para o botão Sair
        botaoSair.setOnClickListener {
            finish()
        }
    }

    // Funções auxiliares
    fun sortearNumero(): Int {
        return Random.nextInt(0, 100)
    }

    fun sortearOperadorLogico(): String {
        val operadoresLogicos = listOf("||", "&&")
        return operadoresLogicos.random()
    }

    fun sortearOperadorRelacional(): String {
        val operadoresRelacionais = listOf(">", "<", "==", "!=", ">=", "<=")
        return operadoresRelacionais.random()
    }

    fun resultadoSentencaRelacional(a: Int, opRel: String, b: Int): Boolean {
        return when (opRel) {
            ">" -> a > b
            "<" -> a < b
            ">=" -> a >= b
            "<=" -> a <= b
            "==" -> a == b
            "!=" -> a != b
            else -> false
        }
    }

    fun resultadoSentencaLogica(s1: Boolean, opLog: String, s2: Boolean): Boolean {
        return when (opLog) {
            "&&" -> s1 && s2
            "||" -> s1 || s2
            else -> false
        }
    }
}
