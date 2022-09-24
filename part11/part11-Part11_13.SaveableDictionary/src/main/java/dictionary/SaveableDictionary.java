package dictionary;

import java.util.Map;
import java.util.HashMap;

public class SaveableDictionary {
    private Map<String, String> translations;

    public SaveableDictionary() {
        this.translations = new HashMap<>();
    }

    public void add(String word, String translation) {
        this.translations.putIfAbsent(word, translation);
        this.translations.putIfAbsent(translation, word);
    }

    public String translate(String word) {
        return this.translations.get(word);
    }
}