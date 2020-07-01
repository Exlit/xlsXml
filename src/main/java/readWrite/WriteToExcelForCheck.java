package readWrite;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class WriteToExcelForCheck {

    public static ArrayList<QvvItem> qvvItems = new ArrayList<QvvItem>();

    public void writeToExcel() throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Submissionsheet");
        int rowCount = 1;
        Row row;

        row = sheet.createRow(0);
        row.createCell(0)
                .setCellValue("file name");
        row.createCell(1)
                .setCellValue("Title");
        row.createCell(2)
                .setCellValue("record date");
        row.createCell(3)
                .setCellValue("key player");
        row.createCell(4)
                .setCellValue("production title");
        row.createCell(5)
                .setCellValue("category");
        row.createCell(6)
                .setCellValue("description");
        row.createCell(7)
                .setCellValue("master keyframe");
        row.createCell(8)
                .setCellValue("Clip TC In");
        row.createCell(9)
                .setCellValue("Clip TC Out");
        row.createCell(10)
                .setCellValue("IN (Yes/No)");
        row.createCell(11)
                .setCellValue("IN Program TC In");
        row.createCell(12)
                .setCellValue("IN Program TC Out");
        row.createCell(13)
                .setCellValue("Location");
        row.createCell(14)
                .setCellValue("Region");
        row.createCell(15)
                .setCellValue("Country");
        row.createCell(16)
                .setCellValue("Keyword EN");
        row.createCell(17)
                .setCellValue("Keyword DE");

        for (QvvItem qvvItem : qvvItems) {
            row = sheet.createRow(rowCount++);
            row.createCell(0)
                    .setCellValue(qvvItem.getKey());
            row.createCell(1)
                    .setCellValue(qvvItem.getTitle());
            row.createCell(2)
                    .setCellValue(qvvItem.getRecordDate());
            row.createCell(3)
                    .setCellValue(qvvItem.getKeyPlayer());
            row.createCell(4)
                    .setCellValue(qvvItem.getProductionTitle());
            row.createCell(5)
                    .setCellValue(qvvItem.getCategory());
            row.createCell(6)
                    .setCellValue(qvvItem.getDescription());
            row.createCell(7)
                    .setCellValue(qvvItem.getKeyFrame());
            row.createCell(8)
                    .setCellValue(qvvItem.getClipTcIn());
            row.createCell(9)
                    .setCellValue(qvvItem.getClipTcOut());
            row.createCell(10)
                    .setCellValue(qvvItem.getProgramIn());
            row.createCell(11)
                    .setCellValue(qvvItem.getProgTcIn());
            row.createCell(12)
                    .setCellValue(qvvItem.getProgTcOut());
            row.createCell(13)
                    .setCellValue(qvvItem.getLocation());
            row.createCell(14)
                    .setCellValue(qvvItem.getRegion());
            row.createCell(15)
                    .setCellValue(qvvItem.getCountry());
            row.createCell(16)
                    .setCellValue(qvvItem.getKeywordEng());
            row.createCell(17)
                    .setCellValue(qvvItem.getKeywordDe());
        }
        FileOutputStream outputStream = new FileOutputStream("JavaBooks.xlsx");
        workbook.write(outputStream);
        outputStream.close();
        workbook.close();
    }

}

