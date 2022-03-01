fun main(args: Array<String>) {
    println("Hello World!")

    // Try adding program arguments at Run/Debug configuration
    println("Program arguments: ${args.joinToString()}")
    val input = if (args.isNotEmpty()) args[0].toInt() else 100
    println(fizzBuzzWhen(input))

}

fun fizzBuzzWhen(n: Int) = (1..n).map { i -> mapOf(0 to i, i % 3 to "Fizz", i % 5 to "Buzz", i % 15 to "FizzBuzz")[0] }