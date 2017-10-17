package nl.MensErgerJeNiet.mensergerjeniet.db.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.MensErgerJeNiet.mensergerjeniet.db.model.Statistics;
import nl.MensErgerJeNiet.mensergerjeniet.db.model.repositories.StatisticsRepository;
import nl.MensErgerJeNiet.mensergerjeniet.db.model.repositories.UserRepository;

@Service
public class StatisticsService {

	@Autowired
	StatisticsRepository statisticsRepository;

	@Autowired
	UserRepository userRepository;
	public Statistics getStatisticsByUsername(String name) {
		Statistics s = statisticsRepository.findStatisticsByUsername(name);
		if(s == null) {
			s = new Statistics();
			s.setUser(userRepository.findByUserName(name));
			s = save(s);
		}
		return s;
	}

	public Statistics save(Statistics s) {
		return statisticsRepository.save(s);
	} 
	
	public List<Statistics> findAll() {
		return (List<Statistics>) statisticsRepository.findAll();
	}
}
