public class Card implements Comparable<Card> {
    private int value;
    private Suit suit;

    public Card(int value, Suit suit) {
        if(value < 2 || value > 14) {
            throw new IllegalArgumentException("Card value must be in range 2...14.");
        }

        this.value = value;
        this.suit = suit;
    }

    public int getValue() {
        return this.value;
    }

    public Suit getSuit() {
        return this.suit;
    }

    @Override
    public int compareTo(Card card) {
        if(this.value == card.value) {
            return this.suit.ordinal() - card.suit.ordinal();
        }
        return this.value - card.value;
    }

    @Override
    public String toString() {
        String card = "" + this.value;
        
        switch(this.value) {
            case 11:
                card = "J";
                break;
            case 12:
                card = "Q";
                break;
            case 13:
                card = "K";
                break;
            case 14:
                card = "A";
                break;
        }
        
        return this.suit + " " + card;
    }
}