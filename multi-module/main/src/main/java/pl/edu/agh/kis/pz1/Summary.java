package pl.edu.agh.kis.pz1;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * Class representing summary
 * of the data in the
 * CSV/XLSX file.
 *
 *
 * There are:
 *  - value of all invoices
 *  - count of all invoices
 *
 */
@XmlRootElement(name="FakturaWierszCtrl")
@XmlAccessorType(XmlAccessType.FIELD)
public class Summary {
    public int LiczbaWierszyFaktur = 0;
    public String WartoscWierszyFaktur = "";


    public int getLiczbaFaktur() {
        return LiczbaWierszyFaktur;
    }

    public void setLiczbaFaktur(int liczbaFaktur) {
        LiczbaWierszyFaktur = liczbaFaktur;
    }

    public String getWartoscFaktur() {
        return WartoscWierszyFaktur;
    }

    public void setWartoscFaktur(String wartoscFaktur) {
        WartoscWierszyFaktur = wartoscFaktur;
    }
}
