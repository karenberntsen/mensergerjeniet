package nl.MensErgerJeNiet.mensergerjeniet.db.model.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import nl.MensErgerJeNiet.mensergerjeniet.db.model.Statistics;
@Repository
public interface StatisticsRepository extends CrudRepository<Statistics, Long> {
    
}