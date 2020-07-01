package readWrite;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class WriteToXml {
    FileWriter xml;
    LinkedHashMap transcriptDivided;
    FieldCorrector fieldCorrector = new FieldCorrector();

    public static int yesNo(String yn) {
        if (yn.equalsIgnoreCase("Yes")) {
            return 1;
        } else {
            return 0;
        }
    }

    public static LinkedHashMap interviewTimeCodeAndTextDivide(String interviewFraze) {
        LinkedHashMap<String, String> transcriptMap = new LinkedHashMap<String, String>();
        String[] transcriptWithTime = interviewFraze.split("#");
        for (String transcript : transcriptWithTime) {
            String[] transcripts = transcript.split("@");
            if (transcripts[1] == null) {
                transcriptMap.put(transcripts[0], "null");
            } else {
                transcriptMap.put(transcripts[0], transcripts[1]);
            }

        }
        return transcriptMap;
    }

    public void createXmlFile(List<QvvItem> itemsList, String pathOut) throws IOException {
        for (QvvItem qvvItem : itemsList) {
            WriteToExcelForCheck.qvvItems.add(qvvItem);
            xml = new FileWriter(pathOut + qvvItem.getKey() + ".xml");
            xml.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                    "<Titles>\n" +
                    "    <Title>\n");
            xml.write("        <key1>" + qvvItem.getKey() + "</key1>\n");
            xml.write("        <itemCode>" + qvvItem.getKey() + "</itemCode>\n");
            xml.write("        <title>" + qvvItem.getTitle() + "</title>\n");
            xml.write("        <category>CATEGORIES/From EasyResource</category>\n");
            xml.write("        <titletype>video</titletype>\n");
            xml.write("        <record_date>" + qvvItem.getRecordDate() + " 00:00:00</record_date>\n");
            xml.write("        <StartOfMaterial>" + qvvItem.getRecordDate() + "T" + qvvItem.getClipTcIn() + "</StartOfMaterial>\n");
            xml.write("        <QVV_Keyplayer>" + qvvItem.getKeyPlayer() + "</QVV_Keyplayer>\n");
            xml.write("        <QVV_Copyright>" + qvvItem.getCopyright() + "</QVV_Copyright>\n");
            xml.write("        <QVV_Production_Title>" + qvvItem.getProductionTitle() + "</QVV_Production_Title>\n");
            xml.write("        <QVV_Classification>" + yesNo(qvvItem.getClassification()) + "</QVV_Classification>\n");
            xml.write("        <QVV_Description>" + qvvItem.getDescription() + "</QVV_Description>\n");
            if (qvvItem.getKey().substring(0, 3).equalsIgnoreCase("cam")) {
                xml.write("        <QVV_Interview_ID>" + qvvItem.getInterviewId() + "</QVV_Interview_ID>\n");
                xml.write("        <QVV_BRoll_Int>" + qvvItem.getbRollInt() + "</QVV_BRoll_Int>\n");
            } else {
                xml.write("        <QVV_Sales_Editorial>" + yesNo(qvvItem.getSalesEditorial()) + "</QVV_Sales_Editorial>\n");
                xml.write("        <QVV_Sales_Creative>" + yesNo(qvvItem.getSalesCreative()) + "</QVV_Sales_Creative>\n");
                xml.write("        <QVV_Programm_IN>" + yesNo(qvvItem.getProgramIn()) + "</QVV_Programm_IN>\n");
            }
            xml.write("        <QVV_Color>" + qvvItem.getColor() + "</QVV_Color>\n");
            xml.write("        <QVV_Product_Cat>\n");
            String[] productCuts = qvvItem.getProductCat().split(",");
            for (int k = 0; k < productCuts.length; k++) {
                xml.write("            <s>" + productCuts[k] + "</s>\n");
            }
            xml.write("        </QVV_Product_Cat>\n");
            //3
            xml.write("        <QVV_Category>\n");
            String[] categories = qvvItem.getCategory().split(",");
            for (int k = 0; k < categories.length; k++) {
                xml.write("            <s>" + categories[k] + "</s>\n");
            }
            xml.write("        </QVV_Category>\n");
            if (qvvItem.getKey().substring(0, 2).equalsIgnoreCase("er")) {
                xml.write("        <QVV_Keywords>\n");
                String[] keywordListEng = qvvItem.getKeywordEng().split(",");
                for (int k = 0; k < keywordListEng.length; k++) {
                    xml.write("            <s>" + keywordListEng[k].trim() + "</s>\n");
                }
                String[] keywordListDe = qvvItem.getKeywordDe().split(",");
                for (int k = 0; k < keywordListDe.length; k++) {
                    xml.write("            <s>" + keywordListDe[k].trim() + "</s>\n");
                }
                xml.write("        </QVV_Keywords>\n");
            }
            xml.write("        <QVV_Credits>\n");
            String[] creditsList = qvvItem.getCredits().split(", ");
            for (int k = 0; k < creditsList.length; k++) {
                xml.write("            <s>" + creditsList[k] + "</s>\n");
            }
            xml.write("        </QVV_Credits>\n");
            xml.write("        <QVV_Production_ID>" + qvvItem.getProductionId() + "</QVV_Production_ID>\n");
            xml.write("        <QVV_Producer>\n");
            String[] producerList = qvvItem.getProducer().split(", ");
            for (int k = 0; k < producerList.length; k++) {
                xml.write("            <s>" + producerList[k] + "</s>\n");
            }
            xml.write("        </QVV_Producer>\n");
            xml.write("        <QVV_Camera_Type>\n");
            String[] camerasList = qvvItem.getCameraType().split(", ");
            for (int k = 0; k < camerasList.length; k++) {
                xml.write("            <s>" + camerasList[k] + "</s>\n");
            }
            xml.write("        </QVV_Camera_Type>\n");

            if (qvvItem.getKey().replace(".mov", "").contains("_in")) {
                xml.write("        <QVV_Prog_TC_IN>\n");
                xml.write("            <s>" + qvvItem.getProgTcIn() + "</s>\n");
                xml.write("        </QVV_Prog_TC_IN>\n");
                xml.write("        <QVV_Prog_TC_OUT>\n");
                xml.write("            <s>" + qvvItem.getProgTcOut() + "</s>\n");
                xml.write("        </QVV_Prog_TC_OUT>\n");
            }
            xml.write("        <QVV_Location>\n");
            String[] locationList = qvvItem.getLocation().split(", ");
            for (int k = 0; k < locationList.length; k++) {
                xml.write("            <s>" + locationList[k] + "</s>\n");
            }
            xml.write("        </QVV_Location>\n");
            xml.write("        <QVV_Region>\n");
            String[] regionList = qvvItem.getRegion().split(", ");
            for (int k = 0; k < regionList.length; k++) {
                xml.write("            <s>" + regionList[k] + "</s>\n");
            }
            xml.write("        </QVV_Region>\n");
            xml.write("        <QVV_Country>\n");
            String[] countryList = qvvItem.getCountry().split(", ");
            for (int k = 0; k < countryList.length; k++) {
                xml.write("            <s>" + countryList[k] + "</s>\n");
            }
            xml.write("        </QVV_Country>\n");
            xml.write("        <Locators>\n");
            xml.write("            <Locator TcIn=\"" + qvvItem.getRecordDate() + "T" + qvvItem.getKeyFrame() + " PAL\" LocatorType=\"POSTER-FRAME\"></Locator>\n");
            if (yesNo(qvvItem.getProgramIn()) == 1) {
                xml.write("        <Locator TcIn=\"" + qvvItem.getRecordDate() + "T" + qvvItem.getProgTcIn() + " PAL\" TcOut=\"" + qvvItem.getRecordDate() + "T" + qvvItem.getProgTcOut() + " PAL\" Comment=\"Program location in the Clip\" LocatorType=\"QVV_Prog_In_Clip\"></Locator>\n");
            }

            //HERE IS INTERVIEW BLOCK
            if (qvvItem.getKey().substring(0, 3).equalsIgnoreCase("cam")) {
                transcriptDivided = interviewTimeCodeAndTextDivide(qvvItem.getKeywordDe());
                Iterator iterator = transcriptDivided.entrySet().iterator();
                while (iterator.hasNext()) {
                    Map.Entry pair = (Map.Entry) iterator.next();
                    // String[] keyArr = pair.getKey().toString().split("$");
                    String key2 = (String) pair.getKey();
                    //  String value = (String) pair.getValue();
                    String[] keyArr = key2.split("\\*"); // Symbol rrr should be replaced with some else that is not regular expression in java
                    if (keyArr.length > 1) {
                        String in = fieldCorrector.timeCodeCorrection(keyArr[0]);
                        String out = fieldCorrector.timeCodeCorrection(keyArr[1]);
                        xml.write("            <Locator TcIn=\"" + qvvItem.getRecordDate() + "T" + in + " PAL\" TcOut=\"" + qvvItem.getRecordDate() + "T" + out + " PAL\" Comment=\"" + pair.getValue().toString().trim() + "\" LocatorType=\"QVV_Transcription_DE\">\n");
                        xml.write("                <LocatorFields><LocatorField FieldName=\"QVV_Locators_Keywords\"><Value>Comment 1</Value></LocatorField></LocatorFields></Locator>\n");
                    } else {
                        String in = qvvItem.getKey();
                        xml.write("            <Locator TcIn=\"" + qvvItem.getRecordDate() + "T" + in + " PAL\" Comment=\"" + pair.getValue() + "\" LocatorType=\"QVV_Transcription_DE\">\n");
                        xml.write("                <LocatorFields><LocatorField FieldName=\"QVV_Locators_Keywords\"><Value>Comment 1</Value></LocatorField></LocatorFields></Locator>\n");
                    }
                }
            }
        }
        xml.write("        </Locators>\n");
        xml.write("    </Title>\n");
        xml.write("</Titles>");
        // System.out.println(qvvItem.toString());
        xml.flush();
        xml.close();
    }
}
