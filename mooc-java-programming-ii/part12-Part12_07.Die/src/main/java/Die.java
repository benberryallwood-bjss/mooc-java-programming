
import java.util.Random;

public class Die {

    private Random random;
    private int numberOfFaces;

    public Die(int numberOfFaces) {
        this.numberOfFaces = numberOfFaces;
        random = new Random();
    }

    public int throwDie() {
        return random.nextInt(numberOfFaces) + 1;
    }
}
