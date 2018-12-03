package br.com.corsan.gustavo.calculaflex.extensions

fun Double.format(digits:Int) = String.format("%.${digits}f", this)