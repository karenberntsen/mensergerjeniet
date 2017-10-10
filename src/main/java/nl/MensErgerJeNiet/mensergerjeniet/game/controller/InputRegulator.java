package nl.MensErgerJeNiet.mensergerjeniet.game.controller;

import java.util.Scanner;
import java.util.Arrays;
/**
 * Deze klasse stelt een vraag via de command line en accepteert alleen een antwoord da overeenkomt met een van de gegeven opties.
 */
public class InputRegulator {

	public static String askPerson(String question) {
		return askPerson(question,null);
	}

	public static String askPerson(String question, String[] options) {
		System.out.println(question);
		Scanner scanner = new Scanner(System.in);
		String answer="";
		while (answer.length()==0) {
			if (options!=null) {
				System.out.println("Opties: "+Arrays.toString(options));
				answer = scanner.next();
				boolean isOption = false;
				for (String option : options) {
					if (option.equalsIgnoreCase(answer)) {
						isOption = true;
						break;
					}
				}
				if (!isOption && answer.length() != 0) {
					System.out.println("Ik begrijp je niet. Kies een van deze opties:" + Arrays.toString(options));
					answer = "";
				}
			} else {
				answer = scanner.next();
			}
		}
		return answer;
	}	
}
