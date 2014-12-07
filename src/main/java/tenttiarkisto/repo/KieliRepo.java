package tenttiarkisto.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import tenttiarkisto.domain.Kieli;

public interface KieliRepo extends JpaRepository<Kieli, Long> {

    List<Kieli> findByLyhenneIgnoreCase(String nimi);
}
