package tenttiarkisto.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tenttiarkisto.domain.Mallivastaus;

public interface MallivastausRepo extends JpaRepository<Mallivastaus, Long> {
    
}
