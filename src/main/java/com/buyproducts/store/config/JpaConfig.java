package com.buyproducts.store.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("com.buyproducts.store.repository.postgre")
public class JpaConfig {
	
}
