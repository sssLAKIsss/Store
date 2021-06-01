package ru.tfs.diploma.gatewayService;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

@Configuration
public class GatewayConfiguration {

    @Bean
    RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("coreCurrency_route" ,route -> route.path("/currency/**")
                                .and()
                                .method(HttpMethod.GET)
                                .uri("lb://core"))
                .route("coreCUDoperations_route", route -> route.path(
                        "/shipment/**", "/product/**", "/parameter/**",
                                "/languages/**", "/info/**", "/currency/**",
                                "/client/**", "/cardProduct/**", "/card/**")
                                .and()
                                .method(HttpMethod.PUT, HttpMethod.DELETE, HttpMethod.POST)
                                .uri("lb://core"))
                .route("denormal_route" ,route -> route.path(
                        "/product/**", "/card/**", "/shipment/**",
                                "/product/**", "/parameters/**",
                                "/languages/**", "/info/**",
                                "/client/**", "/cardProduct/**", "/card/**")
                                .and()
                                .method(HttpMethod.GET)
                                .uri("lb://denormal"))
                .route("agregator_route", route -> route.path("/productInfo/**", "/cardInfo/**")
                                .and()
                                .method(HttpMethod.GET)
                                .uri("lb://agregator"))
                .build();
    }
}
