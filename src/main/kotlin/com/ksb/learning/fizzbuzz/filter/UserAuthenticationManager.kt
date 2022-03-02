package com.ksb.learning.fizzbuzz.filter

import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.ReactiveAuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono
import reactor.core.publisher.Mono.defer
import reactor.core.publisher.Mono.error
import reactor.core.publisher.toMono

/**
 * [ReactiveAuthenticationManager] validating [UsernamePasswordAuthenticationToken] corresponds to a valid user
 */
//@Component
//TODO: Not used right now, but for better security management we can utlize this class.
class UserAuthenticationManager : ReactiveAuthenticationManager {

    override fun authenticate(authentication: Authentication): Mono<Authentication> {
        return Mono.just(authentication)
            .filter { it is UsernamePasswordAuthenticationToken }
            .map { it as UsernamePasswordAuthenticationToken }
            .map { it.extractUsernameSecret() }
            .flatMap { (userId, secret) -> validateCredentials(userId, secret) }
            .switchIfEmpty(defer { error(BadCredentialsException("Invalid Credentials")) })
    }

    //TODO: this functionality can be extended via user validation service which can interact with dB or dB. For the demo credentials have been hardcoded here.
    private fun validateCredentials(userId: String, secret: String): Mono<Authentication> {
        return userId.toMono()
            .filter { it == "admin" }
            .filter { secret == "admin" }
            .map { UsernamePasswordAuthenticationToken(it, null, null) }
    }

    private fun UsernamePasswordAuthenticationToken.extractUsernameSecret() =
        principal.asString() to credentials.asString()

    private fun Any?.asString() = this as? String ?: throw invalidCredentialsException()

    private fun invalidCredentialsException() = BadCredentialsException("Invalid Credentials")
}