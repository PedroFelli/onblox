package com.br.onblox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;


import com.br.onblox.Util.JpaConfiguration;

@Import(JpaConfiguration.class)
@SpringBootApplication(scanBasePackages= {"com.br.onblox"})
public class OnbloxApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnbloxApplication.class, args);
	}
}
