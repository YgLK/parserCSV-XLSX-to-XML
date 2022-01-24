package pl.edu.agh.kis.pz1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * Class which helps to
 * correct the invoice data.
 *
 */
@XmlRootElement(name="faktura")
@XmlAccessorType(XmlAccessType.FIELD)
public class InvoiceCorrection {
    /** invoice type */
    private String RodzajFaktury = "KOREKTA";
    /** invoice cauase */
    private String PrzyczynaKorekty = "";
    /** no. of corrected invoice */
    private String NrFaKorygowanej = "";
    /** time interval of the corrected invoice */
    private String OkresFaKorygowanej = "";

    public String getRodzajFaktury() {
        return RodzajFaktury;
    }

    public void setRodzajFaktury(String rodzajFaktury) {
        RodzajFaktury = rodzajFaktury;
    }

    public String getPrzyczynaKorekty() {
        return PrzyczynaKorekty;
    }

    public void setPrzyczynaKorekty(String przyczynaKorekty) {
        PrzyczynaKorekty = przyczynaKorekty;
    }

    public String getNrFaKorygowanej() {
        return NrFaKorygowanej;
    }

    public void setNrFaKorygowanej(String nrFaKorygowanej) {
        NrFaKorygowanej = nrFaKorygowanej;
    }

    public String getOkresFaKorygowanej() {
        return OkresFaKorygowanej;
    }

    public void setOkresFaKorygowanej(String okresFaKorygowanej) {
        OkresFaKorygowanej = okresFaKorygowanej;
    }
}
