package br.com.fiap.calculodejuros.calculos

fun calcularJuros(capital: Double, taxa: Double, tempo: Double): Double {
    return capital * taxa / 100 * tempo
}

fun calcularMontante(capital: Double, juros: Double): Double {
    return capital + juros
}