package nl.MensErgerJeNiet.mensergerjeniet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import it.ozimov.springboot.mail.configuration.EnableEmailTools;
@SpringBootApplication
@EnableEmailTools
public class MensergerjenietApplication {

	public static void main(String[] args) {
		SpringApplication.run(MensergerjenietApplication.class, args);
	}
}
