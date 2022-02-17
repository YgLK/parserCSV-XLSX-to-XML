package pl.edu.agh.kis.pz1;

import java.util.logging.Logger;

/**
 * Main class in which the
 * ParserXML is run.
 *
 * @author  Jakub Szpunar
 * @version 1.0
 * @since   2022-01-15
 */
public class Main {
    private static final Logger logger = Logger.getLogger(Thread.currentThread().getName());


    public static void main( String[] args ){
        // get filename to be converted to the xml format and name of the saved file
        String filenameToOpen = args[0];
        String filenameToSave = args[1];

        // check if filename to save is valid
        if(!filenameToSave.contains(".xml")){
            throw new IllegalArgumentException("Save filename must contain '.xml'");
        }

        // create list of invoices
        Invoices invoices = new Invoices();

        // create sum
        Summary sum = new Summary();

        // create correction invoice
        InvoiceCorrection invoiceCorrection = new InvoiceCorrection();

        // read csv file
        if(filenameToOpen.contains(".csv")){
            ReaderCSV readercsv = new ReaderCSV(invoices, sum, invoiceCorrection, filenameToOpen.trim());
            readercsv.readFromCSVfile();
            readercsv.getDataFromRecords();
            ExportXML.exportDataToXML(invoices, filenameToSave.trim());
        // read xlsx file
        } else if(filenameToOpen.contains(".xlsx")){
            ReaderXLSX readerXLSX = new ReaderXLSX(invoices, invoiceCorrection, filenameToOpen.trim());
            readerXLSX.readFromXLSXfile();
            ExportXML.exportDataToXML(invoices, filenameToSave.trim());
        } else {
            logger.info("ERROR: Inappropriate filename has been entered.\n" +
                    "Only .csv or .xlsx extensions are supported.");
        }
    }
}
