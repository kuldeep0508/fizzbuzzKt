package com.ksb.learning.fizzbuzz

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["com.ksb.learning.fizzbuzz"], proxyBeanMethods = false)
@ConfigurationPropertiesScan
class FizzbuzzApplication

fun main(args: Array<String>) {
    runApplication<FizzbuzzApplication>(*args)
}
