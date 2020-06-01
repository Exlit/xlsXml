package readWrite;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FieldsChecker {
    FileWriter fileWriter;
    Map<String, ArrayList<String>> logList = new HashMap<String, ArrayList<String>>();

    public void wrongCharacter(String key, String str) throws IOException {
        Pattern pattern = Pattern.compile( "[^a-zA-Z0-9_\\-\\s:,.?()…]" );
        Matcher matcher = pattern.matcher( str );

        if (matcher.find()) {
            if (logList.containsKey( key )) {
                addIssuestoExisted(key, matcher.group());
            }
            else
            {
                addNewLog(key, matcher.group());
            }
            //logCreator();
            System.out.println( key + " " + matcher.group() );
        }
    }

    public void wrongTcFormat(String key, String tc) throws IOException {
//        Pattern pattern = Pattern.compile( "\\d{2}:\\d{2}:\\d{2}\\.\\d{3}" );
//        Matcher matcher = pattern.matcher( tc );

        if (!tc.matches("\\d{2}:\\d{2}:\\d{2}\\.\\d{3}")) {
            if (logList.containsKey( key )) {
                addIssuestoExisted(key, tc);
            }
            else
            {
                addNewLog(key, tc);
            }
            logCreator();
            System.out.println( key + " " + tc );
        }
    }

    public void logCreator() throws IOException {
        for (Map.Entry<String, ArrayList<String>> log : this.logList.entrySet()) {
            fileWriter = new FileWriter( "/Users/ng/Desktop/QVV error log/" + log.getKey() + ".txt" );
            fileWriter.write( "file" + log.getKey() + " has such problem: \n" );
            for (String value : log.getValue()) {
                fileWriter.write( value + "\n" );
            }
        }
        fileWriter.flush();
        fileWriter.close();
    }

    public void addIssuestoExisted(String key, String issue) {
        ArrayList<String> issues;
        issues = this.logList.get( key );
        if (issue != null) {
            issues.add( issue );
            this.logList.put( key, issues );
        }
    }

    public void addNewLog(String key, String issue){
        ArrayList<String> issues = new ArrayList<String>();
        if (issue != null) {
            issues.add( issue );
            this.logList.put(key, issues);
        }
    }
}
