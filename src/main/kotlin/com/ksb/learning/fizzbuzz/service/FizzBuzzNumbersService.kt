package com.ksb.learning.fizzbuzz.service

/**
 * Service to process and input and return fizz & buzz.
 */
@FunctionalInterface
interface FizzBuzzNumbersService {

    val supportedType: String
    fun process(input: Int): List<Any?>
}