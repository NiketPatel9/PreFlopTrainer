package util;

import cards.Card;
import cards.Hand;
import cards.Suit;
import player.Player;
import util.CombinationCalc;

import java.util.*;

public class HandComparator {
	public void determineWinner(List<Player> players, Set<Card> combo) {

		for (Player player : players) {
			player.setHand(this.determineHand(player.getHoleCards(), combo));
			break;
		}
	}

	private Hand determineHand(List<Card> twoCards, Set<Card> fiveCards) {

		CombinationCalc<Card> calc = new CombinationCalc<>();

		List<Card> allCards = new ArrayList<Card>();
		allCards.addAll(twoCards);
		allCards.addAll(fiveCards);

		List<Set<Card>> fiveCardCombos = calc.getSubsets(allCards, 5);

		Set<Card> bestHand;
		Hand hand;

		Card c1 = new Card(Suit.HEART, "10");
		Card c2 = new Card(Suit.HEART, "K");
		Card c3 = new Card(Suit.HEART, "Q");
		Card c4 = new Card(Suit.HEART, "J");
		Card c5 = new Card(Suit.HEART, "9");

		Set<Card> testHand = new HashSet<Card>();
		testHand.add(c1);
		testHand.add(c2);
		testHand.add(c3);
		testHand.add(c4);
		testHand.add(c5);

		fiveCardCombos = new ArrayList<Set<Card>>();
		fiveCardCombos.add(testHand);


		for (Set<Card> combo : fiveCardCombos) {

			List<Suit> suits = new ArrayList<>();
			List<String> values = new ArrayList<>();

			for (Card card : combo) {
				values.add(card.getValue());
				suits.add(card.getSuit());
			}

			System.out.println(suits);
			System.out.println(values);

			if (this.checkRoyalFlush(suits, values)) {
				bestHand = combo;
				hand = Hand.ROYAL;
			}
			else if (this.checkStraightFlush(suits, values)) {
				bestHand = combo;
				hand = Hand.STRAIGHTFLUSH;
				System.out.println("Do i get here?");
			}
			else if (this.checkFullHouse(suits, values)) {
				bestHand = combo;
				hand = Hand.BOAT;
			}
			else {
				bestHand = combo;
				hand = Hand.HIGHCARD;
			}

		}
		return null;
	}

	private boolean checkRoyalFlush(List<Suit> suits, List<String> values) {

		return this.checkStraightFlush(suits, values) && values.contains("A") && values.contains("10");

	}

	private boolean checkStraightFlush(List<Suit> suits, List<String> values) {
		return checkStraight(suits, values) && checkFlush(suits, values);
	}

	private boolean checkStraight(List<Suit> suits, List<String> values) {
		return true;
	}

	private boolean checkFlush(List<Suit> suits, List<String> values) {
		return true;
	}

	private boolean checkFullHouse(List<Suit> suits, List<String> values) {
		return true;
	}


}
