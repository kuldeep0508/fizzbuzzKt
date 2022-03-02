package com.ksb.learning.fizzbuzz.config

import com.ksb.learning.fizzbuzz.service.DefaultFizzBuzzNumbersService
import com.ksb.learning.fizzbuzz.service.DelegatorFizzBuzzService
import com.ksb.learning.fizzbuzz.service.FizzBuzzNumbersService
import org.springframework.beans.factory.ObjectProvider
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration(proxyBeanMethods = false)
class FizzbuzzConfig {

    @Bean
    fun defaultFizzBuzzService() = DefaultFizzBuzzNumbersService()

    @Bean
    fun delegatorFizzBuzzService(fizzBuzzServices: ObjectProvider<FizzBuzzNumbersService>) =
        DelegatorFizzBuzzService(fizzBuzzServices.toList())
}