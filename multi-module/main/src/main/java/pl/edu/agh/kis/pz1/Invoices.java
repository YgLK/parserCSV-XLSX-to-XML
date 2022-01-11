package pl.edu.agh.kis.pz1;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name="faktury")
@XmlAccessorType(XmlAccessType.FIELD)
public class Invoices {
    @XmlElement(name="faktura")
    private List<Invoice> listInvoice;

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
