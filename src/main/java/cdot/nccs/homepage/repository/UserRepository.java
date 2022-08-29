package cdot.nccs.homepage.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import cdot.nccs.homepage.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	public Optional<User> findByName(String name);
	public Optional<User> findByMail(String mail);
	
}
