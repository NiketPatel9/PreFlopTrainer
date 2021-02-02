package util;

import cards.Card;
import cards.Hand;
import player.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class HandComparator {
	public void determineWinner(List<Player> players, Set<Card> combo) {

		for (Player player : players) {
			player.setHand(this.determineHand(player.getHoleCards(), combo));
		}
	}

	private Hand determineHand(List<Card> twoCards, Set<Card> fiveCards) {
		List<Card> allCards = new ArrayList<Card>();
		allCards.addAll(twoCards);
		allCards.addAll(fiveCards);

		if (this.checkRoyalFlush(allCards)) {
			return  Hand.ROYAL;
		}
		return Hand.HIGHCARD;
	}

	private boolean checkRoyalFlush(List<Card> cards) {
		return true;
		// check if royal flush next time
	}



}
