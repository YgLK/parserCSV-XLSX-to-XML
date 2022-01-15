package pl.edu.agh.kis.pz1;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.logging.Logger;


/**
 * Class which lets export
 * data to the XML file.
 *
 */
public class ExportXML {
    private static final Logger logger = Logger.getLogger(Thread.currentThread().getName());

    private ExportXML(){}

    public static void exportDataToXML(Invoices invoices, String filenameToSave) {
        //remove the first person object of list. because it holds the column's names
        invoices.getListInvoice().remove(0);

        //marshaling with java
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Invoices.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(invoices, new File(filenameToSave));
            logger.info("File has been exported to XML format successfully.");

        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
}
