package nl.MensErgerJeNiet.mensergerjeniet.db.model.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.MensErgerJeNiet.mensergerjeniet.db.model.Game;
import nl.MensErgerJeNiet.mensergerjeniet.db.model.repositories.GameRepository;

@Service
public class GameService {

	@Autowired
	GameRepository gameRepository;
	
	public void save(Game game) {
		gameRepository.save(game);
	}
}
