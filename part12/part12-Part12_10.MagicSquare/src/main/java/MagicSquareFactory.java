public class MagicSquareFactory {
    public MagicSquare createMagicSquare(int size) {
        MagicSquare square = new MagicSquare(size);
        int filled = 0;
        int row = 0;
        int col = size / 2;

        while(filled < size*size) {
            if(row < 0) {
                row = size - 1;
            }
            if(col >= size) {
                col = 0;
            }

            square.placeValue(col, row, ++filled);

            if(filled % size == 0) {
                row++;
                continue;
            } 

            row--;
            col++;
        }

        return square;
    }
}