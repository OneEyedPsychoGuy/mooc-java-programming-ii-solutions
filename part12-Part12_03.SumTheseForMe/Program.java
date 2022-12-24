public class Program {
    public static int sum(int[] array, int start, int end, int smallest, int largest) {
        if(start < 0) {
            start = 0;
        }
        if(end > array.length) {
            end = array.length;
        }

        int sum = 0;
        for(int i = start; i < end; i++) {
            int num = array[i];
            if(num >= smallest && num <= largest) {
                sum += num;
            }
        }

        return sum;
    }
}