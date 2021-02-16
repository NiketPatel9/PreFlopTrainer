package cards;

import java.awt.*;
import java.util.Objects;

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

    public Color getColor() {
    	if (this.suit == Suit.HEART) {
    		return Color.RED;
	    }
    	else if (this.suit == Suit.DIAMOND) {
    		return Color.BLUE;
	    }
    	else if (this.suit == Suit.CLUB) {
    		return Color.GREEN;
	    }
    	else {
    		return Color.BLACK;
	    }
    }

    public String toString() {
        return this.getValue() + " " + this.getSuit();
    }

    public String printSuit() {

    	if (this.suit == Suit.SPADE) {
    		return "♠";
	    }
	    else if (this.suit == Suit.HEART) {
		    return "♥";
	    }
	    else if (this.suit == Suit.DIAMOND) {
	    	return "♦";
	    }
	    else {
		    return "♣";
	    }
    }

	@Override
	public boolean equals(Object o) {
		// self check
		if (this == o)
			return true;
		// null check
		if (o == null)
			return false;
		// type check and cast
		if (getClass() != o.getClass())
			return false;
		Card card = (Card) o;
		// field comparison
		return Objects.equals(this.suit, card.getSuit())
				&& Objects.equals(this.value, card.getValue());
	}

}
