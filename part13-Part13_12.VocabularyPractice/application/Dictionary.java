package application;

import java.util.Map;
import java.util.HashMap;
import java.util.Random;

public class Dictionary {
    private Map<String, String> translations;

    public Dictionary() {
        this.translations = new HashMap<>();
        this.add("sana", "word");
    }

    public String get(String word) {
        return this.translations.get(word);
    }

    public String getRandomWord() {
        return (String) this.translations.keySet().toArray()[new Random().nextInt(this.translations.size())];
    }

    public void add(String word, String translation) {
        this.translations.put(word, translation);
    }
}