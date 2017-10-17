package nl.MensErgerJeNiet.mensergerjeniet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HighScores {
	
	@GetMapping("/highscores")
	public String getHighScorePage() {
		return "highscores";
	}
}
