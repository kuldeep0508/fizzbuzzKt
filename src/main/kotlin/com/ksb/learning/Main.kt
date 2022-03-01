package com.ksb.learning

fun main(args: Array<String>) {
    println("Received input from argument : ${args.joinToString().run { ifBlank { "NOTHING" } }}")
    val input = if (args.isNotEmpty()) args[0].toInt() else 100
    println("Output of $input FizzBuzz numbers.")
    println(fizzBuzzWhen(input))

}

private fun fizzBuzzWhen(n: Int) =
    (1..n).map { i -> mapOf(0 to i, i % 3 to "Fizz", i % 5 to "Buzz", i % 15 to "FizzBuzz")[0] }