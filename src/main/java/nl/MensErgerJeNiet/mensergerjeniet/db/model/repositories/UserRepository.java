package nl.MensErgerJeNiet.mensergerjeniet.db.model.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import nl.MensErgerJeNiet.mensergerjeniet.db.model.Enabled;
import nl.MensErgerJeNiet.mensergerjeniet.db.model.User;
import nl.MensErgerJeNiet.mensergerjeniet.db.model.services.UserInterface;
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    public User findByUserName(String username);
    @Query("SELECT new  nl.MensErgerJeNiet.mensergerjeniet.db.model.services.UserInterface(u.id, u.userName, u.enabled) FROM User u ORDER BY u.userName")
    public List<UserInterface> findAll2();
    
    @Query("SELECT new  nl.MensErgerJeNiet.mensergerjeniet.db.model.services.UserInterface(u.id, u.userName, u.enabled) FROM User u WHERE u.enabled = ? ORDER BY u.userName")
    public List<UserInterface> findByEnabledOrderByUserName(Enabled enabled);
    
	public User findByUserNameAndEnabled(String username, Enabled enabled);
}