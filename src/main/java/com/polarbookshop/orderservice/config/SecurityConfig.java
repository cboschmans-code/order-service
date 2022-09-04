package com.polarbookshop.orderservice.config;

import org.springframework.boot.actuate.autoconfigure.security.reactive.EndpointRequest;
import org.springframework.boot.actuate.health.HealthEndpoint;
import org.springframework.boot.actuate.info.InfoEndpoint;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.savedrequest.NoOpServerRequestCache;

@EnableWebFluxSecurity
public class SecurityConfig {


    EndpointRequest.EndpointServerWebExchangeMatcher HEALTH_ENDPOINTS = EndpointRequest.to(HealthEndpoint.class, InfoEndpoint.class);

    @Bean
    SecurityWebFilterChain filterChain(ServerHttpSecurity httpSecurity){
    return httpSecurity.authorizeExchange(exchange -> exchange
                    .pathMatchers("/actuator/**").permitAll()
                    .anyExchange().authenticated()
            )
            .oauth2ResourceServer(ServerHttpSecurity.OAuth2ResourceServerSpec::jwt)
            .requestCache(requestCacheSpec-> requestCacheSpec.requestCache(NoOpServerRequestCache.getInstance()))
            .csrf(ServerHttpSecurity.CsrfSpec::disable)
            .build();

    }
}
