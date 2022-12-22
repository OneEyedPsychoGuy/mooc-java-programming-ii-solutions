public class Program {
    public static void main(String[] args) {
        int[][] matrix = {
            {3, 2, 7, 6},
            {2, 4, 1, 0},
            {3, 2, 1, 0}
        };
        System.out.println(arrayAsString(matrix));
    }

    public static String arrayAsString(int[][] array) {
        StringBuilder string = new StringBuilder();

        for(int row = 0; row < array.length; row++) {
            for(int col = 0; col < array[row].length; col++) {
                string.append(array[row][col]);
            }
            string.append("\n");
        }

        return string.toString();
    }
}