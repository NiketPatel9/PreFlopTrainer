package util;

import cards.Card;
import cards.Hand;
import cards.Suit;
import player.Player;
import util.CombinationCalc;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

		for (Set<Card> combo : fiveCardCombos) {
			if (this.checkRoyalFlush(combo)) {
				bestHand = combo;
				hand = Hand.ROYAL;
				break;
			}
			else {
				bestHand = combo;
				hand = Hand.HIGHCARD;
			}

		}
		return null;
	}

	private boolean checkRoyalFlush(Set<Card> cards) {

		List<String> values = new ArrayList<>();
		List<Suit> suits = new ArrayList<>();

		for (Card card : cards) {
			values.add(card.getValue());
			suits.add(card.getSuit());
		}

		return this.checkStraightFlush(values, suits) && values.contains("A") && values.contains("10");

	}

	private boolean checkStraightFlush(List<String> values, List<Suit> suits) {
		return checkStraight(values, suits) && checkFlush(values, suits);
	}

	private boolean checkStraight(List<String> values, List<Suit> suits) {
		return true;
	}

	private boolean checkFlush(List<String> values, List<Suit> suits) {
		return true;
	}


}
