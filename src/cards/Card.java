package cards;

public class Card {

    private Suit suit;
    private String value;

    public Card(Suit suit, String value) {
        this.suit = suit;
        this.value = value;
    }

    public Suit getSuit() {
        return this.suit;
    }

    public String getValue() {
        return this.value;
    }

    public String toString() {
        return this.getValue() + " " + this.getSuit();
    }
}
