import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hand implements Comparable<Hand> {
    private List<Card> hand;

    public Hand() {
        hand = new ArrayList<>();
    }

    public void add(Card card) {
        hand.add(card);
    }

    public void print() {
        hand.forEach(System.out::println);
    }

    public void sort() {
        hand.sort(Card::compareTo);
    }

    @Override
    public int compareTo(Hand o) {
        int firstHandSum = hand.stream()
                .map(Card::getValue)
                .reduce(0, Integer::sum);
        int secondHandSum = o.hand.stream()
                .map(Card::getValue)
                .reduce(0, Integer::sum);
        return firstHandSum - secondHandSum;
    }

    public void sortBySuit() {
        Collections.sort(hand, new BySuitInValueOrder());
    }
}
