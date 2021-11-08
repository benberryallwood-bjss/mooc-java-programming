
public class Program {

    public static void main(String[] args) {
        // Test the MagicSquare class here
        
        MagicSquareFactory msFactory = new MagicSquareFactory();

        MagicSquare fiveSquare = msFactory.createMagicSquare(5);
        System.out.println(fiveSquare);

        System.out.println(fiveSquare.sumsOfDiagonals());
        System.out.println(fiveSquare.sumsOfColumns());
        System.out.println(fiveSquare.sumsOfRows());
    }
}
