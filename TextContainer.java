package ua.home.javapro;
import java.lang.annotation.Retention;
import java.io.FileWriter;
import java.io.IOException;

import java.lang.annotation.RetentionPolicy;


@Retention(value = RetentionPolicy.RUNTIME)
@interface SaveToFile {
    String pathToFile();
}

@Retention(value = RetentionPolicy.RUNTIME)
@interface Saver {
}

@SaveToFile(pathToFile = "D:\\Projects\\JavaPro\\HomeWork3_2\\HomeWork3_2\\resources\\file.txt")
public class TextContainer {
    private static final String TEXT = "This is my Second Home Work";
    @Saver
    public static void save(String path) {
        try (FileWriter writer = new FileWriter(path)) {
            writer.write(TEXT);
        } catch (IOException ex) {
            System.out.println("FError in save: " + ex.getMessage());
        }
    }
}
