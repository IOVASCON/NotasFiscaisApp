package com.izairton.notasfiscaisapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Classe principal da aplicação Spring Boot.
 * <p>
 * Esta classe é responsável por iniciar a aplicação Spring Boot.
 * </p>
 */
@SpringBootApplication
public class Application {

    /**
     * Método principal que inicia a aplicação Spring Boot.
     *
     * @param args argumentos da linha de comando
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
