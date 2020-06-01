package readWrite;

import java.io.IOException;

public class App {
    public static void main(String[] args) {
        String in = "/Users/keycreative/Desktop/Gentechnik Archive Submissionsheet 29/05/2020.xlsx";
        String out = "/Users/keycreative/Desktop/Gentechnik XMLs/";
        try {
            ReadFromXlsx.readXLSXFile(in, out);

        } catch (IOException e) {
            System.out.println("parsing error");
            e.printStackTrace();
        }
    }
}
