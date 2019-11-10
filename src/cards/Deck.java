package cards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Deck {

    private List<Card> cards;

    public Deck() {
        List<String> values = new ArrayList<String>(Arrays.asList("A", "2", "3", "4", "5", "6", "7", "8", "9",
                "10", "J", "Q", "K"));

        this.cards = new ArrayList<Card>();

        for (Suit suit : Suit.values()) {
            for (String value : values) {
                cards.add(new Card(suit, value));
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
}
