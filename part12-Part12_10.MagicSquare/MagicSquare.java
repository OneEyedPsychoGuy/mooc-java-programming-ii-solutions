import java.util.ArrayList;
import java.util.Collections;

public class MagicSquare {
    private int[][] square;

    public MagicSquare(int size) {
        if (size < 2) {
            size = 2;
        }
        this.square = new int[size][size];
    }

    public ArrayList<Integer> sumsOfRows() {
        ArrayList<Integer> sums = new ArrayList<>();

        for(int row = 0; row < this.square.length; row++) {
            int sum = 0;
            for(int col = 0; col < this.square[row].length; col++) {
                sum += this.square[row][col];
            }
            sums.add(sum);
        }

        return sums;
    }

    public ArrayList<Integer> sumsOfColumns() {
        ArrayList<Integer> sums = new ArrayList<>();

        for(int col = 0; col < this.square.length; col++) {
            int sum = 0;
            for(int row = 0; row < this.square[col].length; row++) {
                sum += this.square[row][col];
            }
            sums.add(sum);
        }

        return sums;
    }

    public ArrayList<Integer> sumsOfDiagonals() {
        ArrayList<Integer> sums = new ArrayList<>();

        int sum = 0;
        for(int i = 0; i < this.square.length; i++) {
            sum += this.square[i][i];
        }
        sums.add(sum);

        sum = 0;
        for(int i = 0; i < this.square.length; i++) {
            sum += this.square[i][this.square.length - 1 - i];
        }
        sums.add(sum);

        return sums;
    }

    public boolean isMagicSquare() {
        return this.sumsAreSame() && this.allNumbersDifferent();
    }

    public ArrayList<Integer> giveAllNumbers() {
        ArrayList<Integer> nums = new ArrayList<>();
        
        for(int row = 0; row < square.length; row++) {
            for(int col = 0; col < square[row].length; col++) {
                nums.add(square[row][col]);
            }
        }

        return nums;
    }

    public boolean allNumbersDifferent() {
        ArrayList<Integer> nums = giveAllNumbers();

        Collections.sort(nums);
        for(int i = 1; i < nums.size(); i++) {
            if(nums.get(i - 1) == nums.get(i)) {
                return false;
            }
        }

        return true;
    }

    public boolean sumsAreSame() {
        ArrayList<Integer> sums = new ArrayList<>();
        sums.addAll(sumsOfRows());
        sums.addAll(sumsOfColumns());
        sums.addAll(sumsOfDiagonals());

        if(sums.size() < 3) {
            return false;
        }

        for(int i = 1; i < sums.size(); i++) {
            if (sums.get(i - 1) != sums.get(i)) {
                return false;
            }
        }

        return true;
    }

    public int readValue(int x, int y) {
        if (x < 0 || y < 0 || x >= getWidth() || y >= getHeight()) {
            return - 1;
        }

        return this.square[y][x];
    }

    public void placeValue(int x, int y, int value) {
        if (x < 0 || y < 0 || x >= getWidth() || y >= getHeight()) {
            return;
        }

        this.square[y][x] = value;
    }

    public int getWidth() {
        return this.square.length;
    }

    public int getHeight() {
        return this.square.length;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        for(int row = 0; row < square.length; row++) {
            for(int col = 0; col < square[row].length; col++) {
                result.append(square[row][col]).append("\t");
            }
            result.append("\n");
        }

        return result.toString();
    }
}
