package readWrite;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.*;


public class ReadFromXlsx {
    public static void readXLSXFile(String pathIn, String pathOut) throws IOException {
        InputStream excelFileToRead = new FileInputStream(pathIn);
        XSSFWorkbook wb = new XSSFWorkbook(excelFileToRead);
        XSSFSheet sheet = wb.getSheetAt(0);
        ArrayList<String> cellsList = new ArrayList<String>();
        WriteToExcelForCheck writeToExcelForCheck = new WriteToExcelForCheck();
        ItemListCreator itemListCreator = new ItemListCreator();
        WriteToXml writeToXml = new WriteToXml();

        // Get iterator to all the rows in current sheet
        Iterator<Row> rowIterator = sheet.iterator();

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            // Get iterator to all cells of current row
            Iterator<Cell> cellIterator = row.cellIterator();

            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                // new FieldsChecker().wrongCharacter(cell.toString(), cell.toString());
                cellsList.add(cell.toString());
               // System.out.print(cell.toString());
              //  System.out.print(" | ");

                //  Change to getCellType() if using POI 4.x
                // CellType cellType = cell.getCellTypeEnum();

//                switch (cellType) {
//                    case _NONE:
//                    case BLANK:
//                        System.out.print("");
//                        System.out.print(" | ");
//                        cellsList.add(cell.getStringCellValue());
//                        break;
//                    case NUMERIC:
//                        System.out.print(cell.getNumericCellValue());
//                        System.out.print(" | ");
//                        cellsList.add(Double.toString(cell.getNumericCellValue()));
//                        break;
//
//                    case STRING:
//                        System.out.print(cell.getStringCellValue());
//                        System.out.print(" | ");
//                        cellsList.add(cell.getStringCellValue());
//                        break;
//                    case ERROR:
//                        System.out.print("!");
//                        System.out.print(" | ");
//                        cellsList.add(cell.getStringCellValue());
//                        break;
//                }
            }
          //  System.out.println();



            if (cellsList.size() > 31 && !cellsList.get(14).equals("") && cellsList.get(14).length() < 22 && cellsList.get(14).length() > 8 && cellsList.get(0).length() == 0) {
                writeToXml.createXmlFile(new ItemListCreator().createList(cellsList), pathOut);
                // new WriteToXmlOld().createFile(cellsList, pathOut);
            }
            cellsList.clear();
        }
        new WriteToExcelForCheck().writeToExcel();
    }


}
