package nl.MensErgerJeNiet.mensergerjeniet.db.model.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import nl.MensErgerJeNiet.mensergerjeniet.db.model.User;
import nl.MensErgerJeNiet.mensergerjeniet.db.model.UserEnabler;
@Repository
public interface UserEnablerRepository extends CrudRepository<UserEnabler, Long> {
    public UserEnabler findBySecret(String key);

	public void deleteByUser(User user);
}