package readWrite;

import sun.jvm.hotspot.StackTrace;

import java.io.IOException;
import java.text.Normalizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FieldCorrector {
    String correctedWord;
    String[] wordArray;

    public String timeCodeCorrection(String word) {
        if (!word.matches("\\d{2}:\\d{2}:\\d{2}\\.\\d{3}") && word != null) {
            if (word.matches("\\d{2}:\\d{2}:\\d{2}:\\d{2}")) {
                wordArray = word.split(":");
                correctedWord = wordArray[0] + ":" + wordArray[1] + ":" + wordArray[2] + "." + wordArray[3] + "0";
            }
            else if(word.matches("\\d{2}:\\d{2}:\\d{2}:\\d{3}"))
            {
                wordArray = word.split(":");
                correctedWord = wordArray[0] + ":" + wordArray[1] + ":" + wordArray[2] + "." + wordArray[3];
            }
            return correctedWord;
        }
         else if(word == null){
            System.out.println("Timecode of file " + word +" is null or has a wrong format");
            return "Timecode of file " + word +" is null or has a wrong format";
        }
         else{return word;}

    }

    public String progInTimecodeChange(String word)
    {
        String progTc = timeCodeCorrection(word);
        if (progTc != null) {
            return timeCodeCorrection(word).replaceFirst("10:", "00:");
        }
        else{
            return "";
        }
    }

    public String specialCharacterCorrector(String str) throws IOException {
       // System.out.println(str);
        str = str.replaceAll("Ä", "Ae")
                .replaceAll("ä", "ae")
                .replaceAll("Ö", "Oe")
                .replaceAll("ö", "oe")
                .replaceAll("Ü", "Ue")
                .replaceAll("ü", "ue")
                .replaceAll("ß", "ss")
                .replaceAll("&", "and");
       // System.out.println(str);
        return str;
    }

    public String dateConverter(String date) {
        String correctedDate;
        if (!date.matches("\\d{4}-\\d{2}-\\d{2}")) {
            String[] dateDivide = date.split("/");
            correctedDate = dateDivide[2] + "-" + dateDivide[1] + "-" + dateDivide[0];
            return correctedDate;
        } else {
            try {
                throw new Exception();
            } catch (Exception e) {
                System.out.println("Date format is wrong - " + date);
            }
            return date;
        }
    }

    public String masterKey (String masterKey, String tcIn)
    {
        int tcInMs;
        int tcInSec;
        int tcInMin;
        int tcInHours;

        int keyMs;
        int keySec;
        int keyMin;
        int keyHours;

        int addSec = 0;
        int addMin = 0;
        int addHours = 0;

        int fMs;
        int fSec;
        int fMin;
        int fHours;


        String properTcIn = timeCodeCorrection(tcIn);
        if (properTcIn !=null && properTcIn.matches("\\d{2}:\\d{2}:\\d{2}\\.\\d{3}")) {
            String[] tcDigits = properTcIn.split(":");
            String[] sTcDigits = tcDigits[2].split("\\.");
            tcInMs = Integer.parseInt(sTcDigits[1]);
            tcInSec = Integer.parseInt(sTcDigits[0]);
            tcInMin = Integer.parseInt(tcDigits[1]);
            tcInHours = Integer.parseInt(tcDigits[0]);
        }
        else
        {
            return "No TC IN";
        }


        String properMasterKey = timeCodeCorrection(masterKey);
        if(properMasterKey != null && properTcIn.matches("\\d{2}:\\d{2}:\\d{2}\\.\\d{3}")) {
            String[] masterDigits = properMasterKey.split(":");
            String[] sMasterDigits = masterDigits[2].split("\\.");
            keyMs = Integer.parseInt(sMasterDigits[1]);
            keySec = Integer.parseInt(sMasterDigits[0]);
            keyMin = Integer.parseInt(masterDigits[1]);
            keyHours = Integer.parseInt(masterDigits[0]);
        }
        else
        {
            return "No masrter keyFrame";
        }

        fMs = keyMs + tcInMs;
        if(fMs > 999)
        {
            ++addSec;
            fMs = fMs - 1000;
        }

        fSec = keySec + tcInSec + addSec;
        if (fSec > 59)
        {
            ++addMin;
            fSec = fSec - 60;
        }

        fMin = keyMin + tcInMin + addMin;
        if(fMin > 59)
        {
            ++addHours;
            fMin = fMin - 60;
        }

        fHours = keyHours + tcInHours + addHours;
        return fillZero(fHours) + ":" + fillZero(fMin) + ":" + fillZero(fSec) + "." + fillZeroEnd(fMs);
    }

    public String fillZero(int i)
    {
        String str;
        if (String.valueOf(i).length() < 2)
        {
            str = "0" + i;
            return str;
        }
        else
        return String.valueOf(i);
    }

    public String fillZeroEnd(int i)
    {
        String str;
        if (String.valueOf(i).length() < 2)
        {
            str = "00" + i;
            return str;
        }
        else if (String.valueOf(i).length() == 2)
        {
            str = "0" + i;
            return str;
        }
        else
            return String.valueOf(i);
    }
}
