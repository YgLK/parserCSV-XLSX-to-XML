package pl.edu.agh.kis.pz1;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

public class ExportXML {
    public static void exportDataToXML(Invoices invoices, String filenameToSave) {
        invoices.getListInvoice().remove(0);   //remove the first person object of list. because it holds the column's names

        //marshaling with java
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Invoices.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, true);
//            jaxbMarshaller.marshal(invoices, new File("output.xml"));
            jaxbMarshaller.marshal(invoices, new File(filenameToSave));
            jaxbMarshaller.marshal(invoices, System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
}
