public class Program {
    public static String arrayAsString(int[][] array) {
        StringBuilder builder = new StringBuilder();

        for(int row = 0; row < array.length; row++) {
            for(int col = 0; col < array[row].length; col++) {
                builder.append(array[row][col]);
            }
            builder.append("\n");
        }
        
        return builder.toString();
    }
}