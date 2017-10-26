package nl.MensErgerJeNiet.mensergerjeniet.db.model.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import nl.MensErgerJeNiet.mensergerjeniet.db.model.Game;
import nl.MensErgerJeNiet.mensergerjeniet.db.model.User;

@Transactional
@Repository
public interface GameRepository extends CrudRepository<Game, Long> {

	void deleteByWinner(User user);
    
}