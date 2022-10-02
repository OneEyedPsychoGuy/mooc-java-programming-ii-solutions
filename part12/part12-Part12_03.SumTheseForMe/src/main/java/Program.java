public class Program {
    public static void main(String[] args) {
        int[] numbers = {3, -1, 8, 4};

        System.out.println(sum(numbers, 0, 0, 0, 0));
        System.out.println(sum(numbers, 0, 0, 0, 10));
        System.out.println(sum(numbers, 0, 1, 0, 10));
        System.out.println(sum(numbers, 0, 1, -10, 10));
        System.out.println(sum(numbers, -1, 999, -10, 10));
    }

    public static int sum(int[] array, int begin, int end, int smallest, int largest) {
        if(begin > end) {
            throw new IllegalArgumentException("Index begin is larger than index end!");
        } else if(smallest > largest) {
            throw new IllegalArgumentException("Smallest number is larger than largest number!");
        }

        if(begin < 0) {
            begin = 0;
        }
        if(end > array.length) {
            end = array.length;
        }

        int sum = 0;
        for(int i = begin; i < end; i++) {
            int num = array[i];
            if(num >= smallest && num <= largest) {
                sum += num;
            }
        }

        return sum;
    }
}