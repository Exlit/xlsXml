package readWrite;

import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;

import static org.junit.Assert.*;

public class ItemListCreatorTest {
    private ItemListCreator itemListCreator = new ItemListCreator();

    @Test
    public void testInterviewBlockElements() throws IOException {
        String string = "12:51:38.160*12:52:07.100@Sie.#12:52:07.100*12:52:09.210@Was?#12:52:09.210*12:52:19.170@Wir.";
        LinkedHashMap<ArrayList<String>, String> result = new LinkedHashMap<ArrayList<String>, String>();
        ArrayList<String> tc = new ArrayList<String>();
        tc.add("12:51:38.160");
        tc.add("12:52:07.100");
        result.put(tc, "Sie.");
        tc.clear();
        tc.add("12:52:07.100");
        tc.add("12:52:09.210");
        result.put(tc, "Was?");
        tc.clear();
        tc.add("12:52:09.210");
        tc.add("12:52:19.170");
        result.put(tc, "Wir.");
        assertEquals(result, itemListCreator.interviewBlockElements(string));
    }



}