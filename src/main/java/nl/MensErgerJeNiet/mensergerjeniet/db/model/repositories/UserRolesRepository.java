package nl.MensErgerJeNiet.mensergerjeniet.db.model.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import nl.MensErgerJeNiet.mensergerjeniet.db.model.User;
import nl.MensErgerJeNiet.mensergerjeniet.db.model.UserRole;
@Repository
public interface UserRolesRepository extends CrudRepository<UserRole, Long> {
	@Query("SELECT role FROM UserRole WHERE user_userid = ?")
	List<String> findByUserId(Long userId);
	@Transactional
	void deleteByUser(User user);
	
}