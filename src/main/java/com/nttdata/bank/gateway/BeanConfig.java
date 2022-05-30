package com.nttdata.bank.gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
	
	@Bean
	public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("service-customer", 
						r -> r.path("/api/customer/**")
						.filters(f -> f.stripPrefix(2))
						.uri("lb://service-customer"))
				.route("service-account", 
						r -> r.path("/api/account/**")
						.filters(f -> f.stripPrefix(2))
						.uri("lb://service-account"))
				.route("service-person", 
						r -> r.path("/api/person/**")
						.filters(f -> f.stripPrefix(2))
						.uri("lb://service-person"))
				.route("service-movement", 
						r -> r.path("/api/movement/**")
						.filters(f -> f.stripPrefix(2))
						.uri("lb://service-movement"))
				.route("service-product", 
						r -> r.path("/api/product/**")
						.filters(f -> f.stripPrefix(2))
						.uri("lb://service-product"))
				.route("service-card", 
						r -> r.path("/api/card/**")
						.filters(f -> f.stripPrefix(2))
						.uri("lb://service-card"))
				.build();
	}

}