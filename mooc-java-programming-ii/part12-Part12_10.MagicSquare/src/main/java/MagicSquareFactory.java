
public class MagicSquareFactory {

    private MagicSquare square;
    private int x;
    private int y;
    private int size;

    public MagicSquare createMagicSquare(int size) {

        square = new MagicSquare(size);

        // implement the creation of a magic square with the Siamese method algorithm here
        this.size = size;
        x = size / 2;
        y = 0;
        int numberOfValues = 0;

        while (numberOfValues < size * size) {
            square.placeValue(x, y, numberOfValues + 1);
            numberOfValues++;
            shift();
        }

        return square;
    }

    private void shift() {
        x = (x + 1) % size;
        y = (y - 1 + size) % size;

        if (square.readValue(x, y) > 0) {
            x = (x - 1 + size) % size;
            y = (y + 2) % size;
        }
    }

}
