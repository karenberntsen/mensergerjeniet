package nl.MensErgerJeNiet.mensergerjeniet.db.model.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import nl.MensErgerJeNiet.mensergerjeniet.db.model.User;
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    public User findByUserName(String username);
}