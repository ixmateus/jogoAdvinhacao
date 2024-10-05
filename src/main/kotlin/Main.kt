package org.example

import kotlin.random.Random

fun main() {

    val palavras = listOf("kotlin", "programcao", "computador", "desenvolvimento")
    val palavraSecreta = palavras[Random.nextInt(palavras.size)]
    val letrasAdvinhadas = mutableSetOf<Char>()
    var tentativas = 7

    println("Bem vindo ao Jogo de Advinhação de Palavras!")

    while (tentativas > 0 && letrasAdvinhadas.size < palavraSecreta.length) {
        print("A palavra tem ${palavraSecreta.length} letras.")
        print("Letras já advinhadas: ${letrasAdvinhadas.joinToString()}")
        print("Tentativas restantes: $tentativas\n")

        print("Digite uma letra: ")
        val letraDigitada = readLine()?.singleOrNull()?.toLowerCase() ?: continue

        if (letraDigitada in palavraSecreta) {
            letrasAdvinhadas += letraDigitada
            println("Letra(s) ${letraDigitada.toUpperCase()}(s) encontrada(s)!")
        } else {
            println("Letra ${letraDigitada.toUpperCase()} não encontrada!")
            tentativas--
        }
    }

    // Verifica se o jogador ganhou
    if (letrasAdvinhadas.size == palavraSecreta.length) {
        println("\nParabéns, você acertou a palavra secreta!")
        println("A palavra era: ${palavraSecreta.toUpperCase()}")
    }
    // Verifica se o jogador perdeu
    else {
        println("\nVocê perdeu! A palavra era: ${palavraSecreta.toUpperCase()}")
    }
    fun exibirPalavra(palavra: String, letrasAdivinhadas: Set<Char>): String {
        return palavra.map { if (letrasAdivinhadas.contains(it)) it else '_' }.joinToString(" ")
    }

}
