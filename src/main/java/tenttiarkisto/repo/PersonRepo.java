package tenttiarkisto.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tenttiarkisto.domain.Person;

public interface PersonRepo extends JpaRepository<Person, Long> {

    Person findByUsername(String username);
}
