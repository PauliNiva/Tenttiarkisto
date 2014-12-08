
package tenttiarkisto.domain;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Kommentti extends AbstractPersistable<Long>{
   
    @Temporal(TemporalType.DATE)
    private Date pvm;
    
    private String sisalto;
    
//    @ManyToOne
    private String kirjoittaja;
    
    @ManyToOne
    private Tentti kommentoituTentti;
    
    public Kommentti(){
    }
    
    public Kommentti(String sisalto, String kirjoittaja, Tentti kommentoituTentti){
        this.sisalto = sisalto;
        this.kirjoittaja = kirjoittaja;
        this.kommentoituTentti = kommentoituTentti;
    }

    public Tentti getKommentoituTentti() {
        return kommentoituTentti;
    }

    public void setKommentoituTentti(Tentti kommentoituTentti) {
        this.kommentoituTentti = kommentoituTentti;
    }

    public Date getPvm() {
        return pvm;
    }

    public void setPvm(Date pvm) {
        this.pvm = pvm;
    }

    public String getSisalto() {
        return sisalto;
    }

    public void setSisalto(String sisalto) {
        this.sisalto = sisalto;
    }

    public String getKirjoittaja() {
        return kirjoittaja;
    }

    public void setKirjoittaja(String kirjoittaja) {
        this.kirjoittaja = kirjoittaja;
    }
    
    
}
