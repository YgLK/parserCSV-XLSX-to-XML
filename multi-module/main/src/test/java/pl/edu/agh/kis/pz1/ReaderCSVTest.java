package pl.edu.agh.kis.pz1;

import org.junit.Assert;
import org.junit.Test;


/**
 * Class used for testing CSV reader
 * methods and functionalities.
 */
public class ReaderCSVTest{


    @Test
    public void testIfAllInvoicesAreReadFromFile(){
        Invoices invoices = new Invoices();
        Summary sum = new Summary();
        InvoiceCorrection invoiceCorrection = new InvoiceCorrection();
        String path = "src/test/java/inv-test.csv";

        ReaderCSV readerCSV = new ReaderCSV(invoices, sum, invoiceCorrection, path);
        // read data from csv test file
        readerCSV.readFromCSVfile();
        // get data from records
        readerCSV.getDataFromRecords();

        Assert.assertEquals("Invoices list should contain 9 invoices.",
                9,
                readerCSV.getInvoices().getListInvoice().size()
        );

    }
}