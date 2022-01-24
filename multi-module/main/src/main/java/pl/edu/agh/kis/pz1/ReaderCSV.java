package pl.edu.agh.kis.pz1;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Objects;


/**
 * Class which helps to read data
 * from CSV files.
 *
 */
public class ReaderCSV {
    /** records extracted from the CSV file */
    private List<CSVRecord> recordsFromCSV;
    /** list of the invoices */
    private Invoices invoices;
    /** name of the CSV file */
    private String filename;
    /** summary of the data */
    private Summary sum;
    /** correction invoice */
    private InvoiceCorrection invoiceCorrection;


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
    ReaderCSV(Invoices invoices, Summary summary, InvoiceCorrection invoiceCorr, String filenameToOpen){
        this.invoices = invoices;
        this.filename = filenameToOpen;
        this.sum = summary;
        this.invoiceCorrection = invoiceCorr;
    }

    /**
     * The method is used for
     * reading records from the CSV file.
     *
    */
     public void readFromCSVfile(){
         File plik = new File(filename);
         CSVFormat.Builder builder = CSVFormat.Builder.create();
         CSVFormat format = builder.setDelimiter('\t').build();
         CSVParser csv = null;
         try {
             csv = CSVParser.parse(plik, StandardCharsets.UTF_8,format);
         } catch (IOException e) {
             e.printStackTrace();
         }

         // assign records to the class field
         try {
             recordsFromCSV = Objects.requireNonNull(csv).getRecords();
         } catch (IOException e) {
             e.printStackTrace();
         }
    }

    /**
     * The method is used to prepare list
     * of the invoices.
     *
     * For each record an invoice is created.
     *
     */
    public void getDataFromRecords(){
        // initialize sum of invoices values
        Float summary = (float) 0;

        // go through each record
        for(CSVRecord cr : recordsFromCSV){
            // add new invoice to the list
            if(cr.get(6).contains("Faktura korygująca")){
                invoiceCorrection.setPrzyczynaKorekty(cr.get(6));
                invoiceCorrection.setNrFaKorygowanej("Od " + cr.get(3) + " do " + cr.get(4));
                String interval =  cr.get(6).replaceAll("[^(0-9)/-]", "");
                invoiceCorrection.setOkresFaKorygowanej(interval.substring(0, interval.length() - 2));
                continue;
            }
            invoices.getListInvoice().add(
                    (new Invoice()).setData(
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
                    )
            );
            this.getInvoices().getSummary().setLiczbaFaktur(
                    this.getInvoices().getSummary().getLiczbaFaktur() + 1);

            String digit = cr.get(14).replaceAll("[\\D]", "");

            if(digit.length() > 0) {
                summary += Float.parseFloat(digit);
            }
        }

        this.getInvoices().getSummary().setWartoscFaktur(
                String.valueOf(summary * 0.01) + " zł"
        );

        this.getInvoices().setInvoiceCorrection(this.getInvoiceCorrection());
    }

    public Iterable<CSVRecord> getRecordsFromCSV() {
        return recordsFromCSV;
    }

    public void setRecordsFromCSV(List<CSVRecord> recordsFromCSV) {
        this.recordsFromCSV = recordsFromCSV;
    }

    public InvoiceCorrection getInvoiceCorrection() {
        return invoiceCorrection;
    }

    public void setInvoiceCorrection(InvoiceCorrection invoiceCorrection) {
        this.invoiceCorrection = invoiceCorrection;
    }

    public Invoices getInvoices() {
        return invoices;
    }

    public void setInvoices(Invoices invoices) {
        this.invoices = invoices;
    }

    public Summary getSum() {
        return sum;
    }
}
