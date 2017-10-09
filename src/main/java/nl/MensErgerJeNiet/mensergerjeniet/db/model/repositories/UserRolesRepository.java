package nl.MensErgerJeNiet.mensergerjeniet.db.model.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import nl.MensErgerJeNiet.mensergerjeniet.db.model.UserRole;
@Repository
public interface UserRolesRepository extends CrudRepository<UserRole, Long> {
	
	
}