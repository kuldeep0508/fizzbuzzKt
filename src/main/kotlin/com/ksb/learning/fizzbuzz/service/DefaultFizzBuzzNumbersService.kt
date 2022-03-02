package com.ksb.learning.fizzbuzz.service

/**
 * Default implementation of service having solution [this variation](https://en.wikipedia.org/wiki/Fizz_buzz) of problem.
 * @param supportedType set as "DEFAULT".
 */
class DefaultFizzBuzzNumbersService(override val supportedType: String = DEFAULT_VALUE) : FizzBuzzNumbersService {
    companion object {
        const val DEFAULT_VALUE = "DEFAULT"
    }

    override fun process(input: Int) =
        (1..input).map { i -> mapOf(0 to i, i % 3 to "Fizz", i % 5 to "Buzz", i % 15 to "FizzBuzz")[0] }
            .also { println(it) }
}