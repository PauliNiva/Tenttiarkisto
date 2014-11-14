package tenttiarkisto.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tenttiarkisto.domain.Tyyppi;

public interface TyyppiRepo extends JpaRepository<Tyyppi, Long> {
    
}
