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
 * Class which helps to read data
 * from XLSX files.
 *
 */
public class ReaderXLSX {
    /** list of the invoices */
    private Invoices invoices;
    /** name of the XLSX file */
    private String filename;

    /**
     * ReaderXLSX constructor. ReaderXLSX
     * is responsible for reading data from the XLSX file
     * and making a list of the created invoices in the invoices
     * field.
     *
     * @param invoices Class in which Invoice instances
     *                 are stored
     * @param filenameToOpen Name of the file from which Invoices data
     *                       is read
     */
    ReaderXLSX(Invoices invoices, String filenameToOpen){
        this.invoices = invoices;
        this.filename = filenameToOpen;
    }

    /**
     * The method is used for
     * reading records from the XLSX file.
     *
     */
    public void readFromXLSXfile(){
        // create input stream to read from the file
        FileInputStream file = null;
        try {
            // get data from the file
            file = new FileInputStream(filename);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // declare record iterator and sheet
        XSSFSheet sheet;
        Iterator<Row> rowIterator = null;
        // create workbook in which data is stored
        try (XSSFWorkbook workbook = new XSSFWorkbook(file)){
            // get the first sheet from the XLSX file
            sheet = workbook.getSheetAt(0);
            // get records iterator
            rowIterator = sheet.iterator();
        } catch (IOException e) {
            e.printStackTrace();
        }


        // iterate through each row
        while (Objects.requireNonNull(rowIterator).hasNext()) {
            // get next row
            Row nextRow = rowIterator.next();
            // through each cell iterator
            Iterator<Cell> cellIterator = nextRow.cellIterator();
            // row data in the string
            StringBuilder rowStr = new StringBuilder();
            // iterate through each cell in the row
            while(cellIterator.hasNext()) {
                // get next cell
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
