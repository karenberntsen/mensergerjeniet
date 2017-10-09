package nl.MensErgerJeNiet.mensergerjeniet.db.model.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import nl.MensErgerJeNiet.mensergerjeniet.db.model.Game;
@Repository
public interface GameRepository extends CrudRepository<Game, Long> {
    
}