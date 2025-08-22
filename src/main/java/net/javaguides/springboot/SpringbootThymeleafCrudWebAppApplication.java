package net.javaguides.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootThymeleafCrudWebAppApplication {

	public static void main(String[] args) {
		// --- INICIO: CÓDIGO DE DEPURACIÓN ---
		System.out.println("----- INICIANDO DEPURACIÓN DE VARIABLES DE ENTORNO -----");
		String dbUrl = System.getenv("JDBC_DATABASE_URL");
		String dbUsername = System.getenv("JDBC_DATABASE_USERNAME");
		String dbPassword = System.getenv("JDBC_DATABASE_PASSWORD");

		System.out.println("Valor de JDBC_DATABASE_URL: " + dbUrl);
		System.out.println("Valor de JDBC_DATABASE_USERNAME: " + dbUsername);
		System.out.println("Valor de JDBC_DATABASE_PASSWORD: " + (dbPassword != null && !dbPassword.isEmpty() ? "[OCULTA POR SEGURIDAD]" : "NO ESTABLECIDA"));
		System.out.println("----- FIN: DEPURACIÓN DE VARIABLES DE ENTORNO -----");
		// --- FIN: CÓDIGO DE DEPURACIÓN ---

		SpringApplication.run(SpringbootThymeleafCrudWebAppApplication.class, args);
	}
}
