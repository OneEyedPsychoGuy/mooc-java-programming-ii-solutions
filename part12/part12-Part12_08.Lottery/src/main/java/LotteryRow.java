import java.util.ArrayList;
import java.util.Random;

public class LotteryRow {
    private ArrayList<Integer> numbers;

    public LotteryRow() {
        this.randomizeNumbers();
    }

    public ArrayList<Integer> numbers() {
        return this.numbers;
    }

    public void randomizeNumbers() {
        this.numbers = new ArrayList<>();
        Random random = new Random();
        int quantity = 7;

        while(quantity > 0) {
            int lotteryNumber = random.nextInt(40) + 1;
            if(!this.containsNumber(lotteryNumber)) {
                this.numbers.add(lotteryNumber);
                quantity--;
            }
        }
    }

    public boolean containsNumber(int number) {
        return this.numbers.contains(number);
    }
}

