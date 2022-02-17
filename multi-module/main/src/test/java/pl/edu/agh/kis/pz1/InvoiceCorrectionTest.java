package pl.edu.agh.kis.pz1;

import org.junit.Assert;
import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;

/**
 * Class used for testing Main
 * methods and functionalities.
 */
public class InvoiceCorrectionTest {


    /**
     * Test for the construction of Main and the 
     * main method being called
     *
     */
    @Test
    public void testSettersAndGetters(){
        InvoiceCorrection invoiceCorrection = new InvoiceCorrection();
        invoiceCorrection.setOkresFaKorygowanej("123");
        invoiceCorrection.setPrzyczynaKorekty("przyczyna");
        invoiceCorrection.setNrFaKorygowanej("789");
        invoiceCorrection.setRodzajFaktury("CORRECT");

        Assert.assertTrue("Object is not equal to the set one.",
                invoiceCorrection.getNrFaKorygowanej().equals("789") &&
                        invoiceCorrection.getOkresFaKorygowanej().equals("123") &&
                        invoiceCorrection.getRodzajFaktury().equals("CORRECT") &&
                        invoiceCorrection.getPrzyczynaKorekty().equals("przyczyna")
                );
    }
}


