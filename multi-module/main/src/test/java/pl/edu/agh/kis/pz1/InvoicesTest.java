package pl.edu.agh.kis.pz1;

import org.junit.Assert;
import org.junit.Test;

/**
 * Class used for testing Invoices
 * methods and functionalities.
 */
public class InvoicesTest {

    @Test
    public void testInvoicesSizeAfterAdding(){
        Invoices invoices = new Invoices();

        // add 5 invoices to the list
        for(int i=0; i<5; i++){
            invoices.getListInvoice().add(new Invoice().setData(
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
                    "15"
            ));
        }

        Assert.assertEquals("Invoices should have size 5.", 5, invoices.getListInvoice().size());
    }

}