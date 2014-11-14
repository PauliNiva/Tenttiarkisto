package tenttiarkisto.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import tenttiarkisto.domain.Kurssi;

public interface KurssiRepo extends JpaRepository<Kurssi, Long> {
    List<Kurssi> findByNimi(String nimi);
}
