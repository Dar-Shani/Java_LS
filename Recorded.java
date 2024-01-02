package Java_Core_LS_1;

import java.io.FileWriter;
import java.io.IOException;

public class Recorded {
    NoteMethods nMethods = new NoteMethods();

    public void writterText(String text) {
        try (FileWriter fw = new FileWriter("note.txt", true)) {
            fw.write(text + ' ' + nMethods.dataTime() + '\n');
        } catch (IOException e) {

        }
    }

}
