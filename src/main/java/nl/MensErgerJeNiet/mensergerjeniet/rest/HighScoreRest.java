package nl.MensErgerJeNiet.mensergerjeniet.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import nl.MensErgerJeNiet.mensergerjeniet.db.model.services.StatisticsService;
import nl.MensErgerJeNiet.mensergerjeniet.db.model.services.exportobjects.StatisticsInterface;

@RestController
public class HighScoreRest {
	@Autowired
	StatisticsService statisticsService;
	
	@DeleteMapping("/del/{id}")
	public void del(@PathVariable int id) {
		System.out.println(id);
	}
	
	@GetMapping("/highscoresdata")
	public List<StatisticsInterface> getHighscores() {
		return statisticsService.findAllOrdered();
	}
}
