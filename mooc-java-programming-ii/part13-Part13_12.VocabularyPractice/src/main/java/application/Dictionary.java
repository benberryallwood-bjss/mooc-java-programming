package application;

import java.util.*;

public class Dictionary {
    private List<String> words;
    private Map<String, String> translations;

    public Dictionary() {
        words = new ArrayList<>();
        translations = new HashMap<>();
        add("hello", "hei");
    }

    public void add(String word, String translation) {
        if (!words.contains(word)) {
            words.add(word);
        }

        translations.put(word, translation);
    }

    public String getRandomWord() {
        Random random = new Random();
        int randomIndex = random.nextInt(words.size());
        return words.get(randomIndex);
    }

    public String translate(String word) {
        return translations.get(word);
    }
}
