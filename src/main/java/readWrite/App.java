package readWrite;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String in = reader.readLine();
        String out = reader.readLine();
        try {
            ReadFromXlsx.readXLSXFile(in, out);

        } catch (IOException e) {
            System.out.println("parsing error");
            e.printStackTrace();
        }
    }
}
