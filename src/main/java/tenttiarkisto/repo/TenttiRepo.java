package tenttiarkisto.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tenttiarkisto.domain.Tentti;

public interface TenttiRepo extends JpaRepository<Tentti, Long> {
    
}
