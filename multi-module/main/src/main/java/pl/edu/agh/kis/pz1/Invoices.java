package pl.edu.agh.kis.pz1;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;


/**
 * Class representing list of
 * invoices read from the
 * CSV/XLSX file.
 *
 */
@XmlRootElement(name="faktury")
@XmlAccessorType(XmlAccessType.FIELD)
public class Invoices {
    /** list of the invoices  */
    @XmlElement(name="faktura")
    private List<Invoice> listInvoice;

    /**
     * Invoices constructor which initializes
     * Invoices list.
     *
     */
    Invoices(){
        listInvoice = new ArrayList<>();
    }

    public List<Invoice> getListInvoice() {
        return listInvoice;
    }

    public void setListInvoices(List<Invoice> listInvoice) {
        this.listInvoice = listInvoice;
    }
}
