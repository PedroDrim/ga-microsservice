package com.example.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Classe de inicializacao do spring boot
 */
@SpringBootApplication
public class GaBackendApplication {

	/**
	 * Metodo de inicializacao main
	 * @param args Parametros do sistema
	 */
	public static void main(String[] args) {
		SpringApplication.run(GaBackendApplication.class, args);
		System.out.println("\n\n");
		System.out.println("============================");
		System.out.println("Microservice Ready for requests");
		System.out.println("============================");
		System.out.println("\n\n");
	}

}
