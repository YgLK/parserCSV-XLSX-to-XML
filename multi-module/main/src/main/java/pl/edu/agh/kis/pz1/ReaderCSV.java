package pl.edu.agh.kis.pz1;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;


/**
 * Class which helps read data
 * from CSV files.
 *
 */
public class ReaderCSV {
    private Iterable<CSVRecord> recordsFromCSV;
    private Invoices invoices;
    private String filename;


    ReaderCSV(Invoices invoices, String filenameToOpen){
        this.invoices = invoices;
        this.filename = filenameToOpen;
    }

    public void readFromCSVfile(){
        Reader in;
        Iterable<CSVRecord> records = null;
        {
            try {
                in = new FileReader(filename);
                records = CSVFormat.EXCEL.withDelimiter('\t').parse(in);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        recordsFromCSV = records;
    }

    public void getDataFromRecords(){
        for(CSVRecord cr : recordsFromCSV){
            invoices.getListInvoice().add((new Invoice()).setData(
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
        // to wykonuje 2 razy więcej iteracji niż powinno (109 iteracji przy ok. 58 rekordow w csv),
        // UPDATE: wykonuje dobrze (wklejalem do notatnika i jest ok 109 tych faktur),to właśnie xlsx jakoś ucina dane, które z csv przekonwertowałem na xlsx w excelu
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
