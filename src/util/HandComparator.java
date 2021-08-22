package util;

import cards.Card;
import cards.Hand;
import cards.Suit;
import player.Player;
import util.CombinationCalc;
import java.util.Collections;

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

		Card c1 = new Card(Suit.HEART, "K");
		Card c2 = new Card(Suit.DIAMOND, "Q");
		Card c3 = new Card(Suit.HEART, "J");
		Card c4 = new Card(Suit.DIAMOND, "A");
		Card c5 = new Card(Suit.HEART, "3");

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

			if (this.checkRoyalFlush(suits, values)) {
				bestHand = combo;
				hand = Hand.ROYAL;
				System.out.println("This is a royal flush.");
			}
			else if (this.checkStraightFlush(suits, values)) {
				bestHand = combo;
				hand = Hand.STRAIGHTFLUSH;
				System.out.println("This is a straight flush.");
			}
			else if (this.checkFourOfAKind(suits, values)) {
				bestHand = combo;
				hand = Hand.QUADS;
				System.out.println("This is a four of a kind.");
			}
			else if (this.checkFullHouse(suits, values)) {
				bestHand = combo;
				hand = Hand.BOAT;
				System.out.println("This is a full house.");
			}
			else if (this.checkFlush(suits, values)) {
				bestHand = combo;
				hand = Hand.FLUSH;
				System.out.println("This is a flush.");
			}
			else if (this.checkStraight(suits, values)) {
				bestHand = combo;
				hand = Hand.STRAIGHT;
				System.out.println("This is a straight.");
			}
			else if (this.checkSet(suits, values)) {
				bestHand = combo;
				hand = Hand.SET;
				System.out.println("This is a three of a kind.");
			}
			else if (this.checkTwoPair(suits, values)) {
				bestHand = combo;
				hand = Hand.TWOPAIR;
				System.out.println("This is a two pair.");
			}
			else if (this.checkPair(suits, values)) {
				bestHand = combo;
				hand = Hand.TWOPAIR;
				System.out.println("This is a pair.");
			}
			else {
				bestHand = combo;
				hand = Hand.HIGHCARD;
				System.out.println("This is a high card.");
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

	private boolean checkFourOfAKind(List<Suit> suits, List<String> values) {

		Set<String> uniqueValues = new HashSet<String>(values);

		final Counter<String> counts = new Counter<>();

		for (String value : values) {
			counts.add(value);
		}

		for (String value : uniqueValues) {
			if (counts.count(value) == 4) {
				return true;
			}
		}

		return false;
	}

	private boolean checkFullHouse(List<Suit> suits, List<String> values) {

		Set<String> uniqueValues = new HashSet<String>(values);

		return uniqueValues.size() == 2;
	}

	private boolean checkFlush(List<Suit> suits, List<String> values) {
		Set<Suit> uniqueSuits = new HashSet<Suit>(suits);
		return uniqueSuits.size() == 1;
	}

	private boolean checkStraight(List<Suit> suits, List<String> values) {

		Collections.sort(values);

		List<List<String>> allStraights = Arrays.asList(Arrays.asList("A", "2", "3", "4", "5"),
				Arrays.asList("2", "3", "4", "5", "6"),
				Arrays.asList("3", "4", "5", "6", "7"),
				Arrays.asList("4", "5", "6", "7", "8"),
				Arrays.asList("5", "6", "7", "8", "9"),
				Arrays.asList("6", "7", "8", "9", "10"),
				Arrays.asList("7", "8", "9", "10", "J"),
				Arrays.asList("8", "9", "10", "J", "Q"),
				Arrays.asList("9", "10", "J", "Q", "K"),
				Arrays.asList("10", "J", "Q", "K", "A"));


		for (List<String> unsortedStraight : allStraights) {
			Collections.sort(unsortedStraight);
			if (values.equals(unsortedStraight)) {
				return true;
			}
		}

		return false;
	}

	private boolean checkSet(List<Suit> suits, List<String> values) {
		Set<String> uniqueValues = new HashSet<>(values);

		final Counter<String> counts = new Counter<>();

		for (String value : values) {
			counts.add(value);
		}

		for (String value : uniqueValues) {
			if (counts.count(value) == 3) {
				return true;
			}
		}

		return false;
	}

	private boolean checkTwoPair(List<Suit> suits, List<String> values) {
		Set<String> uniqueValues = new HashSet<>(values);

		final Counter<String> counts = new Counter<>();

		for (String value : values) {
			counts.add(value);
		}

		List<Integer> rawCounts = new ArrayList<>();

		for (String value : uniqueValues) {
			rawCounts.add(counts.count(value));
		}

		Collections.sort(rawCounts);


		return rawCounts.equals(new ArrayList<>(Arrays.asList(1, 2, 2)));
	}

	private boolean checkPair(List<Suit> suits, List<String> values) {
		Set<String> uniqueValues = new HashSet<>(values);

		final Counter<String> counts = new Counter<>();

		for (String value : values) {
			counts.add(value);
		}

		List<Integer> rawCounts = new ArrayList<>();

		for (String value : uniqueValues) {
			rawCounts.add(counts.count(value));
		}

		Collections.sort(rawCounts);

		return rawCounts.equals(new ArrayList<>(Arrays.asList(1, 1, 1, 2)));
	}

}
