import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Hand {
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
}