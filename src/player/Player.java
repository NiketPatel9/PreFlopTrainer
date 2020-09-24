package player;

import cards.Card;

import java.util.ArrayList;
import java.util.List;

public class Player {

	private String name;
	private List<Card> hand;
	private Pos position;

	public Player(String name, ArrayList<Card> holeCards, Pos position) {
		this.name = name;
		this.hand = holeCards;
		this.position = position;
	}

	public String getName() { return this.name; }
	public List<Card> getHand() { return this.hand; }
	public Pos getPosition() { return this.position; }
}
