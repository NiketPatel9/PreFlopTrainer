package cards;

import util.CombinationCalc;
import java.util.*;

public class Deck {

    private Stack<Card> cards;

    public Deck() {
        List<String> values = new ArrayList<String>(Arrays.asList("A", "2", "3", "4", "5", "6", "7", "8", "9",
                "10", "J", "Q", "K"));

        this.cards = new Stack<Card>();

        for (Suit suit : Suit.values()) {
            for (String value : values) {
                cards.push(new Card(suit, value));
            }
        }
    }

    public String showCards() {
        String deck = "";

        for (Card c : this.cards) {
            deck = deck + c.toString() + "\n";
        }

        // System.out.println(deck);
        return deck;
    }

    public void shuffle() {
        Collections.shuffle(this.cards);
    }

    public Card topCard() {
        return cards.pop();
    }

    public List<Set<Card>> cardCombos() {

	    CombinationCalc<Card> calc = new CombinationCalc<>();

	    List<Card> cardList = new ArrayList<Card>(this.cards);

	    return calc.getSubsets(cardList, 5);
    }
}
