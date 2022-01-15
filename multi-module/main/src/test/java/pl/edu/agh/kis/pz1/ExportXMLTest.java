package pl.edu.agh.kis.pz1;

import com.google.common.io.Files;
import org.apache.commons.io.Charsets;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * Class used for testing
 * XML file export.
 */
public class ExportXMLTest{

    @Test
    public void shouldCreateMainObject() throws IOException {
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

        String path = "testExportXML.xml";

        ExportXML.exportDataToXML(invoices, path);

        // take a reference to the file
        File file = new File(path);
        // get content from file
        String content = Files.toString(file, Charsets.UTF_8);

        // I assert that the file is not empty
        Assert.assertTrue(file.length() > 0 &&
                        content.contains("<faktury>") &&
                        content.contains("<faktura>") &&
                        content.contains("</faktura>") &&
                        content.contains("</faktury>")
                );
        System.out.println(content);
    }
}