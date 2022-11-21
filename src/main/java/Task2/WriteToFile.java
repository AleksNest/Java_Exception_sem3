package Task2;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class WriteToFile {


    public void writeToFile(ArrayList<String> dataPerson) {
        String heading ="имя отчество фамилия пол  д/рождения телефон";
        Path path = Paths.get("src/main/resources/" + dataPerson.get(2) + ".txt");
        if (!Files.exists(path)) {

            try (FileWriter writer = new FileWriter(path.toFile())) {
                writer.write(heading + "\n" + String.join(" ", dataPerson));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

        } else {
            try {
                Files.write(path, ("\n" + String.join(" ", dataPerson)).getBytes(), StandardOpenOption.APPEND);
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }
}

