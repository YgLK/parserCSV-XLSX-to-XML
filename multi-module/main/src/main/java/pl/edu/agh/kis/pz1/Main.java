package pl.edu.agh.kis.pz1;

import java.util.logging.Logger;

/**
 * Main class in which the
 * ParserXML is run.
 *
 * @author  Jakub Szpunar
 * @version 1.0
 * @since   2022-01-02
 */
public class Main {
    private static final Logger logger = Logger.getLogger(Thread.currentThread().getName());

    // TODO: opisać metody w poszczególnych klasach, żeby były do javadoca - później wygenerować javadoc i sonar-cube

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

        // read csv file
        if(filenameToOpen.contains(".csv")){
            ReaderCSV readercsv = new ReaderCSV(invoices, filenameToOpen.trim());
            readercsv.readFromCSVfile();
            readercsv.getDataFromRecords();
            ExportXML.exportDataToXML(invoices, filenameToSave.trim());
        // read xlsx file
        } else if(filenameToOpen.contains(".xlsx")){
            ReaderXLSX readerXLSX = new ReaderXLSX(invoices, filenameToOpen.trim());
            readerXLSX.readFromXLSXfile();
            ExportXML.exportDataToXML(invoices, filenameToSave.trim());
        } else {
            logger.info("ERROR: Inappropriate filename has been entered.\n" +
                    "Only .csv or .xlsx extensions are supported.");
        }
    }
}
