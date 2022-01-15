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
        String path = "src/test/java/inv-test.csv";

        ReaderCSV readerCSV = new ReaderCSV(invoices, path);
        // read data from csv test file
        readerCSV.readFromCSVfile();
        // get data from records
        readerCSV.getDataFromRecords();

        Assert.assertEquals("Invoices list should contain 109 invoices.",
                109,
                readerCSV.getInvoices().getListInvoice().size()
        );

    }
}