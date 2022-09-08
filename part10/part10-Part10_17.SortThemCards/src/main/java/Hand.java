import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Hand implements Comparable<Hand> {
    private List<Card> cards;

    public Hand() {
        this.cards = new ArrayList<>();
    }

    public void add(Card card) {
        this.cards.add(card);
    }

    public void print() {
        this.cards.forEach(System.out::println);
    }

    public void sort() {
        Collections.sort(this.cards);
    }

    @Override
    public int compareTo(Hand hand) {
        int thisHandValue = this.cards.stream().mapToInt(card -> card.getValue()).reduce(0, (sum, value) -> sum + value);
        int comparedHandValue = hand.cards.stream().mapToInt(card -> card.getValue()).reduce(0, (sum, value) -> sum + value);
        return thisHandValue - comparedHandValue;
    }
}