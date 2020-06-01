package readWrite;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.impl.xb.xsdschema.BlockSet;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//public QvvItem(String key, String title, String recordDate, String startOfMaterial, String keyPlayer, String copyright,
//        String productionTitle, String classification, String description, String interviewId, String bRollInt, String salesEditorial,
//        String salesCreative, String programIn, String color, String productCat, String category, String keywordEng, String keywordDe,
//        String credits, String productionId, String producer, String cameraType, String progTcIn, String progTcOut, String location,
//        String region, String country, String keyFrame, String clipTcIn, String clipTcOut)

//        String productCut = cellsList.get(2);
//        String category = corrector.specialCharacterCorrector(cellsList.get(3));
//        String copyright = cellsList.get(5);
//        String credits = cellsList.get(6);
//        String productionId = cellsList.get(7);
//        String keyPlayer = corrector.specialCharacterCorrector(cellsList.get(8));
//        String prodTitle = corrector.specialCharacterCorrector(cellsList.get(9));
//        String classification = cellsList.get(10);
//        String description = corrector.specialCharacterCorrector(cellsList.get(11));
//        String cameraType = cellsList.get(12);
//        String recordDate = corrector.dateConverter(cellsList.get(13));
//        String interviewId = cellsList.get(15);
//        String bRoll = cellsList.get(16);
//        String salesEditorial = cellsList.get(17);
//        String salesCreative = cellsList.get(18);
//        String programIn = cellsList.get(19);
//        String masterKeyFrame = corrector.timeCodeCorrection(cellsList.get(20));
//        String color = cellsList.get(21);
//        String clipTcIn = corrector.timeCodeCorrection(cellsList.get(22));
//        String clipTcOut = corrector.timeCodeCorrection(cellsList.get(23));
//        String progTcIn = corrector.timeCodeCorrection(cellsList.get(24));
//        String progTcOut = corrector.timeCodeCorrection(cellsList.get(25));
//        String location = corrector.specialCharacterCorrector(cellsList.get(27));
//        String region = corrector.specialCharacterCorrector(cellsList.get(28));
//        String country = corrector.specialCharacterCorrector(cellsList.get(29));
//        String keywordsEn = corrector.specialCharacterCorrector(cellsList.get(30));
//        String keywordsDe = corrector.specialCharacterCorrector(cellsList.get(31));
//        String interviewKeyword = corrector.specialCharacterCorrector(cellsList.get(32));

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
               // System.out.println(qvvItem.toString());
        }
        FileOutputStream outputStream = new FileOutputStream("/Users/keycreative/Desktop/JavaBooks.xlsx");
        workbook.write(outputStream);
        outputStream.close();
        workbook.close();
    }

}

