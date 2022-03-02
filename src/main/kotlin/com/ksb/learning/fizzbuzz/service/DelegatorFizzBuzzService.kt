package com.ksb.learning.fizzbuzz.service

/**
 * Delegate to respective fizz buzz service implementation based on the type of its respective implementation [FizzBuzzNumbersService].
 * @param services service used to process fizz buzz annotations
 */
class DelegatorFizzBuzzService(private val services: List<FizzBuzzNumbersService>) {

    init {
        if (services.isEmpty()) println("No fizzBuzz services registered. Fizzbuzz numbers processing will not be possible")
        else println("Registered fizzBuzz services: ${services.joinToString(",") { it.javaClass.simpleName }}")
    }

    /**
     * Delegates fizz buzz service based on type and process the numbers access.
     * @param type solution type
     * @param input number which wants to process and convert to fizz & buzz
     * @return List<Any> based on impl.
     */
    internal fun processByType(
        type: String, input: Int
    ) = services.firstOrNull { it.supportedType == type }?.also { println("Processing input $input with type $type.") }?.process(input)


}