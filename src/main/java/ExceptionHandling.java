import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ExceptionHandling {
    public static void main(String[] args) {
        String filename = "testing.csv";
        testFile2(filename);

        /**
         * LBYL - Look Before You Leap
         */
        File file = new File(filename);
        if (!file.exists()) {
            System.out.println("I can't run unless this file exists.");
            System.out.println("Quitting Application, go figure it out.");
            return;
        }
        System.out.println("I'm good to go.");

    }

    /**
     * EAFP - Easier to Ask Forgiveness than Permission.
     */
    private static void testFile(String filename) {
        Path path = Paths.get(filename);
        FileReader reader = null;
        try {
//            List<String> lines = Files.readAllLines(path);
            reader = new FileReader(filename);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("Maybe I'd log something either way ...");
        }
        System.out.println("File exists and able to use as a resource.");
    }

    private static void testFile2(String filename) {
        try (FileReader reader = new FileReader(filename)) {
        } catch (FileNotFoundException e) {
            System.out.println("File '" + filename + "' does not exist");
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            System.out.println("Something unrelated and unexpected happened");
        } finally {
            System.out.println("Maybe I'd log something either way ...");
        }
        System.out.println("File exists and able to use as a resource.");
    }
}
