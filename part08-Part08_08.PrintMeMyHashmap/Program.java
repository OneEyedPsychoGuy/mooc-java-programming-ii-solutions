import java.util.HashMap;

public class Program {
    public static void printKeys(HashMap<String, String> map) {
        for(String key : map.keySet()) {
            System.out.println(key);
        }
    }

    public static void printKeysWhere(HashMap<String, String> map, String text) {
        for(String key : map.keySet()) {
            if(key.contains(text)) {
                System.out.println(key);
            }
        }
    }

    public static void printValuesOfKeysWhere(HashMap<String, String> map, String text) {
        for(String key : map.keySet()) {
            if(key.contains(text)) {
                System.out.println(map.get(key));
            }
        }
    }
}