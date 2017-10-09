package nl.MensErgerJeNiet.mensergerjeniet.db.model.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import nl.MensErgerJeNiet.mensergerjeniet.db.model.User;
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    public User findByUserName(String username);
    
}