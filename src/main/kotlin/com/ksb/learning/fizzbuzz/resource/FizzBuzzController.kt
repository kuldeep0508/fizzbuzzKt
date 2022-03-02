package com.ksb.learning.fizzbuzz.resource

import com.ksb.learning.fizzbuzz.resource.ApiConstants.FIZZ_BUZZ_PATH
import com.ksb.learning.fizzbuzz.service.DelegatorFizzBuzzService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono
import reactor.core.publisher.Mono.just

@RestController
@RequestMapping(FIZZ_BUZZ_PATH)
class FizzBuzzController(private val delegator: DelegatorFizzBuzzService) {

    @GetMapping
    fun processFizzBuzzNumbers(
        @RequestParam input: Int,
        @RequestParam(required = false) type: String?
    ): Mono<List<Any?>> {
        println("Received parameters input = $input & type = $type")
        return just(
            delegator.processByType(type ?: "DEFAULT", input)
                ?: listOf("Currently there is no support for type : $type. Use type=DEFAULT for now.")
        )
    }

}