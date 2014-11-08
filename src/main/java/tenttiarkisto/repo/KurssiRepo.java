package tenttiarkisto.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tenttiarkisto.domain.Kurssi;

public interface KurssiRepo extends JpaRepository<Kurssi, Long> {
    
}
