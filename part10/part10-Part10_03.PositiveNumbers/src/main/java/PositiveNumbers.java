import java.util.List;
import java.util.stream.Collectors;

public class PositiveNumbers {
    public static void main(String[] args) {
    
    }

    public static List<Integer> positive(List<Integer> numbers) {
        return numbers.stream().filter(num -> num > 0).collect(Collectors.toList());
    }
}