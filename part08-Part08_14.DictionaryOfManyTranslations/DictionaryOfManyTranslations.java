import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class DictionaryOfManyTranslations {
    private Map<String, List<String>> translations;

    public DictionaryOfManyTranslations() {
        this.translations = new HashMap<>();
    }

    public ArrayList<String> translate(String word) {
        return (ArrayList<String>) this.translations.getOrDefault(word, new ArrayList<>());
    }

    public void add(String word, String translation) {
        this.translations.putIfAbsent(word, new ArrayList<>());
        this.translations.get(word).add(translation);
    }

    public void remove(String word) {
        this.translations.remove(word);
    }
}