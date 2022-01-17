package pl.edu.agh.kis.pz1;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;


/**
 * Class which helps to read data
 * from CSV files.
 *
 */
public class ReaderCSV {
    /** records extracted from the CSV file */
    private Iterable<CSVRecord> recordsFromCSV;
    /** list of the invoices */
    private Invoices invoices;
    /** name of the CSV file */
    private String filename;

    /**
     * ReaderCSV constructor. ReaderCSV
     * is responsible for reading data from the CSV file
     * and making a list of the created invoices in the invoices
     * field.
     *
     * @param invoices Class in which Invoice instances
     *                 are stored
     * @param filenameToOpen Name of the file from which Invoices data
     *                       is read
     */
    ReaderCSV(Invoices invoices, String filenameToOpen){
        this.invoices = invoices;
        this.filename = filenameToOpen;
    }

    /**
     * The method is used for
     * reading records from the CSV file.
     *
    */
     public void readFromCSVfile(){
        // create reader to read from the file
        Reader in;
        // initialize records
        Iterable<CSVRecord> records = null;
        {
            try {
                // create new FileReader associated with CSV file
                in = new FileReader(filename);
                // split data into the records
                records = CSVFormat.EXCEL.withDelimiter('\t').parse(in);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // assign records to the class field
        recordsFromCSV = records;
    }

    /**
     * The method is used to prepare list
     * of the invoices.
     *
     * For each record an invoice is created.
     *
     */
    public void getDataFromRecords(){
        // go through each record
        for(CSVRecord cr : recordsFromCSV){
            // add new invoice to the list
            invoices.getListInvoice().add((new Invoice()).setData(
                    // extract columns' values from the record
                    cr.get(0),
                    cr.get(1),
                    cr.get(2),
                    cr.get(3),
                    cr.get(4),
                    cr.get(5),
                    cr.get(6),
                    cr.get(7),
                    cr.get(8),
                    cr.get(9),
                    cr.get(10),
                    cr.get(11),
                    cr.get(12),
                    cr.get(13),
                    cr.get(14)
            ));
        }
     }

    public Iterable<CSVRecord> getRecordsFromCSV() {
        return recordsFromCSV;
    }

    public void setRecordsFromCSV(Iterable<CSVRecord> recordsFromCSV) {
        this.recordsFromCSV = recordsFromCSV;
    }

    public Invoices getInvoices() {
        return invoices;
    }

    public void setInvoices(Invoices invoices) {
        this.invoices = invoices;
    }
}
