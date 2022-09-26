package dictionary;

import java.util.Map;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class SaveableDictionary {
    private Map<String, String> translations;
    private String file;

    public SaveableDictionary(String file) {
        this.translations = new HashMap<>();
        this.file = file;
    }

    public void add(String word, String translation) {
        this.translations.putIfAbsent(word, translation);
        this.translations.putIfAbsent(translation, word);
    }

    public String translate(String word) {
        return this.translations.get(word);
    }

    public void delete(String word) {
        if(!this.translations.containsKey(word)) {
            return;
        }

        String translation = this.translations.get(word);
        this.translations.remove(word);
        this.translations.remove(translation);
    }

    public boolean load() {
        try(Scanner fileReader = new Scanner(new File(this.file))) {;
            while(fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                String[] data = line.split(":");
                this.add(data[0], data[1]);
            }
            return true;
        } catch(IOException e) {
            return false;
        }
    }
}