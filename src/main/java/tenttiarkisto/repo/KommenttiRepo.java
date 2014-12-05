
package tenttiarkisto.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tenttiarkisto.domain.Kommentti;

public interface KommenttiRepo extends JpaRepository<Kommentti, Long>{
    
}
