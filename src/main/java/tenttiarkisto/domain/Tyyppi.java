package tenttiarkisto.domain;

import javax.persistence.Entity;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Tyyppi extends AbstractPersistable<Long> {

    private String tyyppi;
    private String lyhenne;

    public String getTyyppi() {
        return tyyppi;
    }

    public void setTyyppi(String tyyppi) {
        this.tyyppi = tyyppi;
    }

    public String getLyhenne() {
        return lyhenne;
    }

    public void setLyhenne(String lyhenne) {
        this.lyhenne = lyhenne;
    }

    @Override
    public String toString() {
        return tyyppi;
    }
}
