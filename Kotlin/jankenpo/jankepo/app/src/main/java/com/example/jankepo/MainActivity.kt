package com.example.jankepo

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    // Variáveis dos objetos em tela
    lateinit var tvResultado: TextView
    lateinit var tvPontos: TextView
    lateinit var btnPedra: Button
    lateinit var btnPapel: Button
    lateinit var btnTesoura: Button
    lateinit var btnReiniciar: Button
    var pontos = 0

    // Lista de opções do jogo
    val opcoes = listOf("Pedra", "Papel", "Tesoura")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Capturar os objetos de Tela
        tvResultado = findViewById(R.id.tvResultado)
        tvPontos = findViewById(R.id.tvPontos)
        btnPedra = findViewById(R.id.btnPedra)
        btnPapel = findViewById(R.id.btnPapel)
        btnTesoura = findViewById(R.id.btnTesoura)
        btnReiniciar = findViewById(R.id.btnReiniciar)

        // Ações dos botões
        btnPedra.setOnClickListener {
            jogar("Pedra")
        }

        btnPapel.setOnClickListener {
            jogar("Papel")
        }

        btnTesoura.setOnClickListener {
            jogar("Tesoura")
        }

        btnReiniciar.setOnClickListener {
            reiniciarJogo()
        }
    }

    // Função para sortear a jogada do computador
    fun sorteiaJogadaComputador(): String {
        return opcoes.random()
    }

    // Função que executa a jogada e exibe o resultado
    fun jogar(escolhaJogador: String) {
        val escolhaComputador = sorteiaJogadaComputador()

        // Exibe a escolha da máquina antes de mostrar o resultado do jogo
        tvResultado.text = "A máquina escolheu $escolhaComputador. "

        when {
            escolhaJogador == escolhaComputador -> {
                tvResultado.append("Empate! Ambos escolheram $escolhaJogador")
            }
            escolhaJogador == "Pedra" && escolhaComputador == "Tesoura" -> {
                resultadoVitoria(escolhaJogador, escolhaComputador)
            }
            escolhaJogador == "Papel" && escolhaComputador == "Pedra" -> {
                resultadoVitoria(escolhaJogador, escolhaComputador)
            }
            escolhaJogador == "Tesoura" && escolhaComputador == "Papel" -> {
                resultadoVitoria(escolhaJogador, escolhaComputador)
            }
            else -> {
                resultadoDerrota(escolhaJogador, escolhaComputador)
            }
        }
    }

    // Função que exibe resultado de vitória e aumenta os pontos
    fun resultadoVitoria(jogador: String, computador: String) {
        tvResultado.append("Você ganhou! $jogador vence $computador")
        pontos += 10
        atualizarPontos()
        tvResultado.setBackgroundColor(Color.GREEN)
        tvResultado.setTextColor(Color.BLACK)
    }

    // Função que exibe resultado de derrota e diminui os pontos
    fun resultadoDerrota(jogador: String, computador: String) {
        tvResultado.append("Você perdeu! $computador vence $jogador")
        pontos -= 10
        atualizarPontos()
        tvResultado.setBackgroundColor(Color.RED)
        tvResultado.setTextColor(Color.WHITE)
    }

    // Função para atualizar os pontos
    fun atualizarPontos() {
        tvPontos.text = "Pontos: $pontos"
    }

    // Função para reiniciar o jogo
    fun reiniciarJogo() {
        pontos = 0
        atualizarPontos()
        tvResultado.text = "Escolha sua jogada!"
        tvResultado.setBackgroundColor(Color.TRANSPARENT)
    }
}
