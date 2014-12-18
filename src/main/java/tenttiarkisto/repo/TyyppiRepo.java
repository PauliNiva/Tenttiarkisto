package tenttiarkisto.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import tenttiarkisto.domain.Tyyppi;

public interface TyyppiRepo extends JpaRepository<Tyyppi, Long> {
    List<Tyyppi> findByTyyppiIgnoreCase(String nimi);
    Tyyppi findByLyhenneIgnoreCase(String nimi);
}
