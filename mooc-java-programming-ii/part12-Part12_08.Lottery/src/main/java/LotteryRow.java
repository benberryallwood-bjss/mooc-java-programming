
import java.util.ArrayList;
import java.util.Random;

public class LotteryRow {

    private ArrayList<Integer> numbers;

    public LotteryRow() {
        randomizeNumbers();
    }

    public ArrayList<Integer> numbers() {
        return numbers;
    }

    public void randomizeNumbers() {
        numbers = new ArrayList<>();
        Random numberSelector = new Random();
        for (int i = 0; i < 7; i++) {
            int number;
            do {
                number = numberSelector.nextInt(40) + 1;
            } while (numbers.contains(number));
            numbers.add(number);
        }
    }

    public boolean containsNumber(int number) {
        return numbers.contains(number);
    }
}

