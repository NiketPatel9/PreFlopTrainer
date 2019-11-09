enum Suit {
    HEART, DIAMOND, CLUB, SPADE;
}

public class Card {

    Suit suit;
    String value;

    public Card(Suit suit, String value) {
        this.suit = suit;
        this.value = value;
    }
}
