package nl.MensErgerJeNiet.mensergerjeniet.db.model.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import nl.MensErgerJeNiet.mensergerjeniet.db.model.Statistics;
import nl.MensErgerJeNiet.mensergerjeniet.db.model.services.StatisticsInterface;
@Repository
public interface StatisticsRepository extends CrudRepository<Statistics, Long> {
    
	@Query("SELECT s FROM Statistics s WHERE s.user = (SELECT u FROM User u where u.userName = ?)")
	public Statistics findStatisticsByUsername(String username);
	
	@Query("SELECT new  nl.MensErgerJeNiet.mensergerjeniet.db.model.services.StatisticsInterface(s.id, s.user.userName, s.win, s.loss ) FROM Statistics s ORDER BY (s.win / (s.win+s.loss)) DESC")
	public List<StatisticsInterface> findAllOrdered();

}