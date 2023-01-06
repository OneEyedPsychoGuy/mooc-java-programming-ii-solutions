package application;
 
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
 
public class CyclingStatistics {
    private List<String> rows;
 
    public CyclingStatistics(String file) {
        try {
            rows = Files.lines(Paths.get(file)).collect(Collectors.toCollection(ArrayList::new));
        } catch(IOException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }
 
    public List<String> locations() {
        List<String> locations = Arrays.stream(rows.get(0).split(";")).collect(Collectors.toList());
        return locations.subList(1, locations.size());
    }
 
    public Map<String, Integer> monthlyCyclists(String location) {
        List<String> locations = locations();
        if(locations.indexOf(location) < 0) {
            return new HashMap<>();
        }
 
        Map<String, List<Integer>> monthlyValues = new TreeMap<>();
        rows.stream()
            .map(string -> string.split(";"))
            .filter(array -> array.length > 10)
            .forEach(array -> {
                    String[] dateArray = array[0].split(" ");
                    int index = locations.indexOf(location) + 1;
                    if(dateArray.length < 3) return;
 
                    String month = dateArray[3] + " / " + stringToMonthNumber(dateArray[2]);
                    monthlyValues.putIfAbsent(month, new ArrayList<>());
 
                    int count = 0;
                    if(!array[index].isEmpty()) {
                        count = Integer.valueOf(array[index]);
                    }
                    monthlyValues.get(month).add(count);
            });
 
        Map<String, Integer> cyclistCounts = new TreeMap<>();
        monthlyValues.keySet().stream().forEach(value -> {
            cyclistCounts.put(value, monthlyValues.get(value).stream().mapToInt(num -> num).sum());
        });
        return cyclistCounts;
    }
 
    private String stringToMonthNumber(String month) {
        List<String> months = Arrays.asList("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
        int num = months.indexOf(month) + 1;
        return (num < 10 ? "0" : "") + num;
    }
}