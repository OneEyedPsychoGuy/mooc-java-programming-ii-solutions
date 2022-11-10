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
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class CyclingStatistics {
    private List<String> rows;

    public CyclingStatistics(String file) {
        try {
            rows = Files.lines(Paths.get(file)).collect(Collectors.toCollection(new Supplier<ArrayList<String>>() {
                @Override
                public ArrayList<String> get() {
                    return new ArrayList<String>();
                }
            }));
        } catch (IOException ex) {
            throw new RuntimeException("Failed to read the file " + file + ". Error message: " + ex.getMessage());
        }
    }

    public List<String> locations() {
        List<String> locations = Arrays.stream(rows.get(0).split(";")).collect(Collectors.toCollection(new Supplier<ArrayList<String>>() {             
                @Override
                public ArrayList<String> get() {
                    return new ArrayList<String>();
                }
            }));
        return locations.subList(1, locations.size());
    }

    public Map<String, Integer> monthlyCyclists(String location) {
        List<String> locations = locations();
        if (locations.indexOf(location) < 0) {
            return new HashMap<String, Integer>();
        }

        final Map<String, List<Integer>> monthlyValues = new TreeMap<String, List<Integer>>();

        final int index = locations.indexOf(location) + 1;
        rows.stream().map(new Function<String, String[]>() {
                    @Override
                    public String[] apply(String string) {
                        return string.split(";");
                    }
                })
                .filter(new Predicate<String[]>() {
                    @Override
                    public boolean test(String[] array) {
                        return array.length > 10;
                    }
                })
                .forEach(new Consumer<String[]>() {
                    @Override
                    public void accept(String[] array) {
                        String[] dateArray = array[0].split(" ");
                        if (dateArray.length < 3) {
                            return;
                        }

                        String month = dateArray[3] + " / " + stringToMonthNumber(dateArray[2]);

                        monthlyValues.putIfAbsent(month, new ArrayList<Integer>());

                        int count = 0;
                        if (!array[index].isEmpty()) {
                            count = Integer.parseInt(array[index]);
                        }

                        monthlyValues.get(month).add(count);
                    }
                });

        final Map<String, Integer> cyclistCounts = new TreeMap<String, Integer>();
        monthlyValues.keySet().stream().forEach(new Consumer<String>() {
            @Override
            public void accept(String value) {
                cyclistCounts.put(value, monthlyValues.get(value).stream().mapToInt(new ToIntFunction<Integer>() {
                    @Override
                    public int applyAsInt(Integer value) {
                        return value;
                    }
                }).sum());
            }
        });

        return cyclistCounts;
    }

    private String stringToMonthNumber(String month) {
        List<String> months = Arrays.asList("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
        int number = months.indexOf(month) + 1;

        if (number < 10) {
            return "0" + number;
        }

        return "" + number;
    }
}