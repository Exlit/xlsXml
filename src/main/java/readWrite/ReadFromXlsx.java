package readWrite;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;


public class ReadFromXlsx {
    public static void readXLSXFile(String pathIn, String pathOut) throws IOException {
        InputStream excelFileToRead = new FileInputStream(pathIn);
        XSSFWorkbook wb = new XSSFWorkbook(excelFileToRead);
        XSSFSheet sheet = wb.getSheetAt(0);
        ArrayList<String> cellsList = new ArrayList<String>();
       // WriteToExcelForCheck writeToExcelForCheck = new WriteToExcelForCheck();
       // ItemListCreator itemListCreator = new ItemListCreator();
        WriteToXml writeToXml = new WriteToXml();
        Iterator<Row> rowIterator = sheet.iterator();

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();

            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                cellsList.add(cell.toString());
            }

            if (cellsList.size() > 31 && !cellsList.get(14).equals("") && cellsList.get(14).length() < 22 && cellsList.get(14).length() > 8 && cellsList.get(0).length() == 0) {
                writeToXml.createXmlFile(new ItemListCreator().createList(cellsList), pathOut);
            }
            cellsList.clear();
        }
        new WriteToExcelForCheck().writeToExcel();
    }


}
