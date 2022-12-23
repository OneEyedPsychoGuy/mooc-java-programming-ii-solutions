import java.util.ArrayList;
import java.util.stream.Collectors;

public class Divisible {
    public static ArrayList<Integer> divisible(ArrayList<Integer> nums) {
        return nums.stream()
            .filter(num -> num % 2 == 0 || num % 3 == 0 || num % 5 == 0)
            .collect(Collectors.toCollection(ArrayList::new));
    }
}