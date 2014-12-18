package tenttiarkisto.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Kieli extends AbstractPersistable<Long> {

    @NotNull
    @NotEmpty
    @Column(unique = true)
    private String nimi;
    
    private String lyhenne;

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String kieli) {
        this.nimi = kieli;
    }

    public String getLyhenne() {
        return lyhenne;
    }

    public void setLyhenne(String lyhenne) {
        this.lyhenne = lyhenne;
    }

    @Override
    public String toString() {
        return nimi;
    }
}
