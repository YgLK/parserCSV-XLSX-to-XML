package pl.edu.agh.kis.pz1;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;


/**
 * Class which helps read data
 * from XLSX files.
 *
 */
public class ReaderXLSX {
    private Invoices invoices;
    private String filename;


    ReaderXLSX(Invoices invoices, String filenameToOpen){
        this.invoices = invoices;
        this.filename = filenameToOpen;
    }


    public void readFromXLSXfile(){
        FileInputStream file = null;
        try {
            file = new FileInputStream(filename);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        XSSFSheet sheet;
        Iterator<Row> rowIterator = null;
        try (XSSFWorkbook workbook = new XSSFWorkbook(file)){
            //Pobierz pierwszy arkusz w pliku XLSX
            sheet = workbook.getSheetAt(0);
            //Wczytaj wiersze
            rowIterator = sheet.iterator();
        } catch (IOException e) {
            e.printStackTrace();
        }


        // iterate through each row
        while (Objects.requireNonNull(rowIterator).hasNext()) {
            Row nextRow = rowIterator.next();
            Iterator<Cell> cellIterator = nextRow.cellIterator();
            StringBuilder rowStr = new StringBuilder();
            // iterate through each cell in the row
            while(cellIterator.hasNext()) {
                Cell nextCell = cellIterator.next();
                // get string value of the cell
                DataFormatter formatter = new DataFormatter();
                String strValue = formatter.formatCellValue(nextCell);
                // sum the text in the rowStr representing text in the whole Row
                rowStr.append(strValue);
            }
            // split whole row to get value of each column
            ArrayList<String> cr = new ArrayList<>(Arrays.asList(rowStr.toString().split("\t")));

            // --- put the data into the list of invoices ---
            // if row not fulfilled completely add blank text in the empty column values
            while(cr.size() < 15) {
                cr.add(" ");
            }
            // add new invoice to the list
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
    }

    public Invoices getInvoices() {
        return invoices;
    }
}
