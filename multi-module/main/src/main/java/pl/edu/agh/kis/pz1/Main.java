package pl.edu.agh.kis.pz1;

import com.sun.xml.bind.v2.TODO;

import java.io.Reader;

/**
 * Przykładowy kod do zajęć laboratoryjnych 2, 3, 4 z przedmiotu: Programowanie zaawansowane 1
 * @author Paweł Skrzyński
 */
public class Main {
    public static void main( String[] args ) throws Exception {


        //TODO: zrobić testy do tego projektu w wolnym czasie/nocy żeby nie marnować na to dnia


        // get filename to be converted to the xml format and
        // name of the saved file
        String filenameToOpen = args[0];
        String filenameToSave = args[1];

        if(!filenameToSave.contains(".xml")){
            throw new Exception("Filename to save should contain '.xml'");
        }
//        System.out.println(fileNameToOpen);
//        System.out.println(nameOfSavedFile);


        // create list of invoices
        Invoices invoices = new Invoices();

        // CSV - działa ok
        if(filenameToOpen.contains(".csv")){
            ReaderCSV readercsv = new ReaderCSV(invoices, filenameToOpen.trim());
            readercsv.readFromCSVfile();
            readercsv.getDataFromRecords();
            ExportXML.exportDataToXML(invoices, filenameToSave.trim());
        } else if(filenameToOpen.contains(".xlsx")){
            // XLSX - działa ok, jedynie co poprawic nizej jest napisane
            ReaderXLSX readerXLSX = new ReaderXLSX(invoices, filenameToOpen.trim());
            readerXLSX.readFromXLSXfile();
            ExportXML.exportDataToXML(invoices, filenameToSave.trim());
        } else {
            System.out.println("ERROR: Inappropriate filename has been entered.\n" +
                    "Only .csv or .xlsx extensions are supported.");
        }

        // test
//        ReaderCSV readercsv = new ReaderCSV(invoices, "faktury-sprzedazowe-test.csv");
//        readercsv.readFromCSVfile();
//        readercsv.getDataFromRecords();
//        ExportXML.exportDataToXML(invoices, "output.xml");

        //TODO
        // trzeba znaleźć jakiś dobry konwerter csv do xlsx albo znalezc w necie te faktury, bo trace dane poprzez
        // konwersje w Excelu po prostu i konwersja XLSX do XML ma dwa razy mniejsza dlugosc
        // i wtedy sprawdzic czy z XLSX zajmie tyle samo linii
        // UPDATE:
            // według mnie excel po prostu gubi dane jak zapisuje z csv na xlsx - w xlsx duzo danych w 59 linii sie znajduje dziwnym trafem
            // w csv też jakoś się tam kumuluje
    }
}
