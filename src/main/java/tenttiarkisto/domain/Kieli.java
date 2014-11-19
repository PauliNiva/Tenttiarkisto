
package tenttiarkisto.domain;

import javax.persistence.Entity;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Kieli extends AbstractPersistable<Long>{
    
    private String nimi;

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String kieli) {
        this.nimi = kieli;
    }
    
    @Override
    public String toString() {
        return nimi;
    }
}
