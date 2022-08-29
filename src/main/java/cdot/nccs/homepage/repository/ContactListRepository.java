package cdot.nccs.homepage.repository;
import cdot.nccs.homepage.model.ContactList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactListRepository extends JpaRepository<ContactList,Long> {
}
