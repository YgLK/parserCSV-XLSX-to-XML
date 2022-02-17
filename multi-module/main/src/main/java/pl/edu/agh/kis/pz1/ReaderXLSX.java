package pl.edu.agh.kis.pz1;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
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
    /** correction invoice */
    private InvoiceCorrection invoiceCorrection;



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
    ReaderXLSX(Invoices invoices, InvoiceCorrection invoiceCorrection,  String filenameToOpen){
        this.invoices = invoices;
        this.filename = filenameToOpen;
        this.invoiceCorrection = invoiceCorrection;
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


        // initialize sum of invoices values
        Float sumVal = (float) 0;

        ArrayList<ArrayList<String>> columnValues = new ArrayList<>();
        for(int i = 0; i < 15; i++){
            columnValues.add(new ArrayList<>());
        }
        // iterate through each row
        while (Objects.requireNonNull(rowIterator).hasNext()) {
            // get next row
            Row nextRow = rowIterator.next();
            // through each cell iterator
            Iterator<Cell> cellIterator = nextRow.cellIterator();
            // row data in the string
            // iterate through each cell in the row
            String col0 = ""; String col1 = ""; String col2 = ""; String col3 = "";
            String col4 = ""; String col5 = ""; String col6 = ""; String col7 = "";
            String col8 = ""; String col9 = ""; String col10 = ""; String col11 = "";
            String col12 = ""; String col13 = ""; String col14 = "";
            while(cellIterator.hasNext()) {
                StringBuilder rowStr = new StringBuilder();
                // get next cell
                Cell nextCell = cellIterator.next();
                // get string value of the cell
                DataFormatter formatter = new DataFormatter();
                String strValue = formatter.formatCellValue(nextCell);
                // get value of each column in the current row
                if(nextCell.getColumnIndex() == 0){
                    col0 = strValue;
                } else if(nextCell.getColumnIndex() == 1) {
                    col1 = strValue;
                }else if(nextCell.getColumnIndex() == 2){
                    col2 = strValue;
                }else if(nextCell.getColumnIndex() == 3){
                    col3 = strValue;
                }else if(nextCell.getColumnIndex() == 4){
                    col4 = strValue;
                }else if(nextCell.getColumnIndex() == 5){
                    col5 = strValue;
                }else if(nextCell.getColumnIndex() == 6){
                    if(strValue.contains("Faktura korygująca")){
                        invoiceCorrection.setPrzyczynaKorekty(strValue);
                        invoiceCorrection.setNrFaKorygowanej("Od " + col3 + " do " + col4);
                        String interval =  strValue.replaceAll("[^(0-9)/-]", "");
                        invoiceCorrection.setOkresFaKorygowanej(interval.substring(0, interval.length() - 2));
                        continue;
                    }
                    col6 = strValue;
                }else if(nextCell.getColumnIndex() == 7){
                    col7 = strValue;
                }else if(nextCell.getColumnIndex() == 8){
                    col8 = strValue;
                }else if(nextCell.getColumnIndex() == 9){
                    col9 = strValue;
                }else if(nextCell.getColumnIndex() == 10){
                    col10 = strValue;
                }else if(nextCell.getColumnIndex() == 11){
                    col11 = strValue;
                }else if(nextCell.getColumnIndex() == 12){
                    col12 = strValue;
                }else if(nextCell.getColumnIndex() == 13){
                    col13 = strValue;
                }else if(nextCell.getColumnIndex() == 14) {
                    col14 = strValue;
                }
            }

            invoices.getListInvoice().add((new Invoice()).setData(
                    col0,
                    col1,
                    col2,
                    col3,
                    col4,
                    col5,
                    col6,
                    col7,
                    col8,
                    col9,
                    col10,
                    col11,
                    col12,
                    col13,
                    col14
            ));
            this.getInvoices().getSummary().setLiczbaFaktur(this.getInvoices().getListInvoice().size());

            String digit = col14.replaceAll("[\\D]", "");

            if(digit.length() > 0) {
                sumVal += Float.parseFloat(digit);
            }
        }

        this.getInvoices().getSummary().setWartoscFaktur(
                String.valueOf(sumVal * 0.01) + " zł"
        );

        this.getInvoices().setInvoiceCorrection(this.getInvoiceCorrection());
    }

    public Invoices getInvoices() {
        return invoices;
    }

    public InvoiceCorrection getInvoiceCorrection() {
        return invoiceCorrection;
    }

    public void setInvoiceCorrection(InvoiceCorrection invoiceCorrection) {
        this.invoiceCorrection = invoiceCorrection;
    }
}
