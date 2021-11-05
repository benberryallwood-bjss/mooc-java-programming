
public class Program {

    public static void main(String[] args) {
        // Test your method here
    }

    public static String arrayAsString(int[][] array) {
        StringBuilder output = new StringBuilder();
        for (int[] row : array) {
            for (int i : row) {
                output.append(i);
            }
            output.append("\n");
        }
        return output.toString();
    }

}
