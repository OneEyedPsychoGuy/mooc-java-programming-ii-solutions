import java.util.List;
import java.util.stream.Collectors;

public class PositiveNumbers {
    public static List<Integer> positive(List<Integer> nums) {
        return nums.stream()
            .filter(num -> num > 0)
            .collect(Collectors.toList());
    }
}