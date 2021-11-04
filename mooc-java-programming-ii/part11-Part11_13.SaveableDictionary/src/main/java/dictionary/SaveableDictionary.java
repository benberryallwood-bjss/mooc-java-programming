package dictionary;

import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class SaveableDictionary {
    private Map<String, String> translations;
    private String fileName;

    public SaveableDictionary() {
        translations = new HashMap<>();
    }

    public SaveableDictionary(String file) {
        this();
        fileName = file;
    }

    public boolean load() {
        try (Scanner dictionaryFile = new Scanner(Paths.get(fileName))) {
            while (dictionaryFile.hasNextLine()) {
                String[] parts = dictionaryFile.nextLine().split(":");
                translations.putIfAbsent(parts[0], parts[1]);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void add(String word, String translation) {
        translations.putIfAbsent(word, translation);
    }

    public void delete(String word) {
        translations.keySet()
                .removeIf(key -> key.equals(word) || translations.get(key).equals(word));
    }

    public String translate(String word) {
        for (String key : translations.keySet()) {
            if (translations.get(key).equals(word)) return key;
        }
        return translations.get(word);
    }

    public boolean save() {
        try (PrintWriter printWriter = new PrintWriter(fileName)) {
            translations.forEach((word, translation) -> printWriter.println(word + ":" + translation));
            printWriter.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
