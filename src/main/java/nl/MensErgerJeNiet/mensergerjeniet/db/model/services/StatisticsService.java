package nl.MensErgerJeNiet.mensergerjeniet.db.model.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.MensErgerJeNiet.mensergerjeniet.db.model.repositories.StatisticsRepository;

@Service
public class StatisticsService {

	@Autowired
	StatisticsRepository statisticsRepository;
}
