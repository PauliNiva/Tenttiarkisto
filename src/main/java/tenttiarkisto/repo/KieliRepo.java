
package tenttiarkisto.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tenttiarkisto.domain.Kieli;


public interface KieliRepo extends JpaRepository<Kieli, Long>{
    
}
