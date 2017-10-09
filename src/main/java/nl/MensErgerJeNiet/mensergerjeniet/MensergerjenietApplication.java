package nl.MensErgerJeNiet.mensergerjeniet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import nl.MensErgerJeNiet.mensergerjeniet.game.controller.StartMensErgerJeNiet;

@SpringBootApplication
public class MensergerjenietApplication {

	public static void main(String[] args) {
	System.out.println("test");	SpringApplication.run(MensergerjenietApplication.class, args);
	StartMensErgerJeNiet.main(null);
	}
}
