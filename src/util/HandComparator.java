package util;

import cards.Card;
import cards.Hand;
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
		System.out.println(fiveCardCombos.size());
		if (this.checkRoyalFlush(allCards)) {
			return  Hand.ROYAL;
		}
		return Hand.HIGHCARD;
	}

	private boolean checkRoyalFlush(List<Card> cards) {
		//if (this.checkStraightFlush() && cards.contains(new Card()))
		return true;
		// check if royal flush next time
	}



}
