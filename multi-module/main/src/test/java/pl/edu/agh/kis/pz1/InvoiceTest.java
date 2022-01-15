package pl.edu.agh.kis.pz1;

import org.junit.Assert;
import org.junit.Test;

/**
 * Class used for testing Invoices
 * methods and functionalities.
 */
public class InvoiceTest {

    @Test
    public void testIfFIeldsAreSetProperly(){
        Invoice invoice = new Invoice().setData(
                "1",
                "2",
                "3",
                "4",
                "5",
                "6",
                "7",
                "8",
                "9",
                "10",
                "11",
                "12",
                "13",
                "14",
                "15");

        invoice.setCenaBruttoFakturyLacznie("123");

        // check some fields after setting data
        Assert.assertTrue("Fields aren't set properly.",
            invoice.getNazwaOdbiorcy().equals("1") &&
                    invoice.getNIPodbiorcy().equals("3") &&
                    invoice.getCenaBruttoFakturyLacznie().equals("123") &&
                    invoice.getKwotaPodatku().equals("11")
        );
    }
}