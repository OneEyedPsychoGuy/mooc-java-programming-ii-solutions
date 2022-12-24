import java.util.ArrayList;
import java.util.Random;

public class LotteryRow {
    private ArrayList<Integer> nums;

    public LotteryRow() {
        this.randomizeNumbers();
    }

    public ArrayList<Integer> numbers() {
        return this.nums;
    }

    public void randomizeNumbers() {
        this.nums = new ArrayList<>();
        Random random = new Random();

        while(this.nums.size() < 7) {
            int num = random.nextInt(40) + 1;
            if(!this.containsNumber(num)) {
                this.nums.add(num);
            }
        }
    }

    public boolean containsNumber(int num) {
        return this.nums.contains(num);
    }
}

