import java.util.Comparator;

public class BySuitInValueOrder implements Comparator<Card> {
    @Override
    public int compare(Card firstCard, Card secondCard) {
        if (firstCard.getSuit() == secondCard.getSuit()) {
            return firstCard.getValue() - secondCard.getValue();
        }
        return firstCard.getSuit().ordinal() - secondCard.getSuit().ordinal();
    }
}
