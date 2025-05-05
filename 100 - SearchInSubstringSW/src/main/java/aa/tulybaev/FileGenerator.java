package aa.tulybaev;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class FileGenerator {
    public static void generateFile(String fileName, String str, String substr) {
        try(OutputStream os = new FileOutputStream("src/main/java/aa/tulybaev/files/" + fileName + ".txt");){
            os.write((str + " ").getBytes());
            os.write(substr.getBytes());

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
