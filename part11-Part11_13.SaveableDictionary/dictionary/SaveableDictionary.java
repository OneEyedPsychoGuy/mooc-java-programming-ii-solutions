package dictionary;

import java.util.Map;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SaveableDictionary {
    private Map<String, String> translations;
    private String file;

    public SaveableDictionary(String file) {
        this.translations = new HashMap<>();
        this.file = file;
    }

    public SaveableDictionary() {
        this("");
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
        try(Scanner fileReader = new Scanner(new File(this.file))) {
            while(fileReader.hasNextLine()) {
                String[] parts = fileReader.nextLine().split(":");
                this.add(parts[0], parts[1]);
            }
            
            return true;
        } catch(FileNotFoundException e) {
            return false;
        }
    }

    public boolean save() {
        try(PrintWriter fileWriter = new PrintWriter(this.file)) {
            List<String> words = new ArrayList<>();

            for(String word : this.translations.keySet()) {
                if(!words.contains(word)) {
                    String translation = this.translations.get(word);

                    words.add(word);
                    words.add(translation);
                    fileWriter.println(word + ":" + translation);
                }
            }

            return true;
        } catch(FileNotFoundException e) {
            return false;
        }
    }
}