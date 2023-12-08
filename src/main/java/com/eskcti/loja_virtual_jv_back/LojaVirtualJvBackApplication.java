package com.eskcti.loja_virtual_jv_back;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableAsync
@EnableScheduling
@EntityScan(basePackages = "com.eskcti.loja_virtual_jv_back.models")
@ComponentScan(basePackages = {"com.eskcti.loja_virtual_jv_back.*"})
@EnableJpaRepositories(basePackages = {"com.eskcti.loja_virtual_jv_back.repositories"})
@EnableTransactionManagement
@EnableWebMvc
public class LojaVirtualJvBackApplication {

	public static void main(String[] args) {
		System.out.println(new BCryptPasswordEncoder().encode("123456"));
		SpringApplication.run(LojaVirtualJvBackApplication.class, args);
	}

}
