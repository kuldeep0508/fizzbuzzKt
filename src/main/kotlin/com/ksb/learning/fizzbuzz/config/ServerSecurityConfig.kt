package com.ksb.learning.fizzbuzz.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity
import org.springframework.security.config.web.server.ServerHttpSecurity
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService
import org.springframework.security.core.userdetails.User
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.server.SecurityWebFilterChain
import org.springframework.security.web.server.ServerAuthenticationEntryPoint


/**
 * Configures spring security for the server
 */
@Configuration(proxyBeanMethods = false)
@EnableWebFluxSecurity
class ServerSecurityConfig {

    @Bean
    @Override
    fun springSecurityFilterChain(
        http: ServerHttpSecurity,
        serverAuthenticationEntryPoint: ServerAuthenticationEntryPoint?
    ): SecurityWebFilterChain {
        return http.csrf()
            .disable()
            .authorizeExchange()
            .anyExchange()
            .authenticated()
            .and()
            .httpBasic()
            .and()
            /*.addFilterAt(AuthenticationWebFilter(UserAuthenticationManager()), HTTP_BASIC)*/
            .build()
    }

    @Bean
    fun userDetailsService(): MapReactiveUserDetailsService? {
        val user = User
            .withUsername("user")
            .password(passwordEncoder().encode("password"))
            .roles("USER")
            .build()
        return MapReactiveUserDetailsService(user)
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }

}