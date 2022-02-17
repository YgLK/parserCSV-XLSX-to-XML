package pl.edu.agh.kis.pz1;


import org.junit.Assert;
import org.junit.Test;

/**
 * Class used for testing XLSX reader
 * methods and functionalities.
 */
public class ReaderXLSXTest {

    @Test
    public void testIfAllInvoicesAreReadFromFile(){
        Invoices invoices = new Invoices();
        Summary sum = new Summary();
        InvoiceCorrection invoiceCorrection = new InvoiceCorrection();
        String path = "src/test/java/inv-test.xlsx";

        ReaderXLSX readerXLSX = new ReaderXLSX(invoices, invoiceCorrection, path);
        // read data from csv test file and get data from records
        readerXLSX.readFromXLSXfile();

        // this XLSX file isn't converted properly from CSV so some data from
        // CSV format is lost - that's why only 58 invoices is left in here
        // (I couldn't find more efficient csv to xlsx converter)
        Assert.assertEquals("Invoices list should contain 109 invoices.",
                58,
                readerXLSX.getInvoices().getListInvoice().size()
        );
    }
}