package nl.MensErgerJeNiet.mensergerjeniet.db.model.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import nl.MensErgerJeNiet.mensergerjeniet.db.model.Statistics;
@Repository
public interface StatisticsRepository extends CrudRepository<Statistics, Long> {
    
	@Query("SELECT s FROM Statistics s WHERE s.user = (SELECT u FROM User u where u.userName = ?)")
	public Statistics findStatisticsByUsername(String username);

}