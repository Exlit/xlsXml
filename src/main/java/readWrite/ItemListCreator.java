package readWrite;

import java.io.IOException;
import java.util.*;

public class ItemListCreator {
    public QvvItem qvvItem;
    public ArrayList<QvvItem> itemsList = new ArrayList<QvvItem>();
    public FieldCorrector corrector = new FieldCorrector();

    public ArrayList<QvvItem> createList(List<String> cellsList) throws IOException {
        String key = cellsList.get(14).replace(".mxf", "");
        String productCut = cellsList.get(2);
        String category = corrector.specialCharacterCorrector(cellsList.get(3));
        String copyright = cellsList.get(5);
        String credits = cellsList.get(6);
        String productionId = cellsList.get(7);
        String keyPlayer = corrector.specialCharacterCorrector(cellsList.get(8));
        String prodTitle = corrector.specialCharacterCorrector(cellsList.get(9));
        String classification = cellsList.get(10);
        String description = corrector.specialCharacterCorrector(cellsList.get(11));
        String cameraType = cellsList.get(12);
        String recordDate = corrector.dateConverter(cellsList.get(13));
        String interviewId = cellsList.get(15);
        String bRoll = cellsList.get(16);
        String salesEditorial = cellsList.get(17);
        String salesCreative = cellsList.get(18);
        String programIn = cellsList.get(19);
        String masterKeyFrame = corrector.masterKey(cellsList.get(20), cellsList.get(22));
        String color = cellsList.get(21);
        String clipTcIn = corrector.timeCodeCorrection(cellsList.get(22));
        String clipTcOut = corrector.timeCodeCorrection(cellsList.get(23));
        String progTcIn = corrector.progInTimecodeChange(cellsList.get(24));
        String progTcOut = corrector.progInTimecodeChange(cellsList.get(25));
        String location = corrector.specialCharacterCorrector(cellsList.get(27));
        String region = corrector.specialCharacterCorrector(cellsList.get(28));
        String country = corrector.specialCharacterCorrector(cellsList.get(29));
        String keywordsEn = corrector.specialCharacterCorrector(cellsList.get(30));
        String keywordsDe = corrector.specialCharacterCorrector(cellsList.get(31));
        String interviewKeyword = corrector.specialCharacterCorrector(cellsList.get(32));


        qvvItem = new QvvItem(key, interviewKeyword, recordDate, recordDate,
                keyPlayer, copyright, prodTitle, classification, description,
                interviewId, bRoll, salesEditorial, salesCreative, programIn, color,
                productCut, category, keywordsEn, keywordsDe,
                credits, productionId, keyPlayer, cameraType, progTcIn, progTcOut, location,
                region, country, masterKeyFrame, clipTcIn, clipTcOut);

        itemsList.add(qvvItem);
        System.out.println(qvvItem.toString());

        return itemsList;
    }

    public LinkedHashMap<String, String> getDividedInterviewBlocks(String str) {
        LinkedHashMap<String, String> transcriptMap = new LinkedHashMap<String, String>();
        String[] transcriptWithTime = str.split("#");
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

    public LinkedHashMap<String, String> dividedInterviewBlocks(String str) {
        LinkedHashMap<String, String> transcriptMap = new LinkedHashMap<String, String>();
        String[] transcriptWithTime = str.split("#");
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

    public LinkedHashMap<LinkedList<String>, String> interviewBlockElements(String str) throws IOException {
        LinkedHashMap<String, String> transcriptMap = dividedInterviewBlocks(str);
        LinkedList<String> tcList = new LinkedList<String>();
        LinkedHashMap<LinkedList<String>, String> interviewMap = new LinkedHashMap<LinkedList<String>, String>();
        Iterator iterator = transcriptMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry pair = (Map.Entry) iterator.next();
            String tc = (String) pair.getKey();
            String[] tcArr = tc.split("\\*");
            if (tcArr.length > 1) {
                String in = tcArr[0];
                String out = tcArr[1];
                tcList.add(tcArr[0]);
                tcList.add(tcArr[1]);
            } else {
                String in = tc;
                tcList.add(tc);
            }
            interviewMap.put(tcList, pair.getValue().toString());
            tcList.clear();
        }
        return interviewMap;
    }
}

