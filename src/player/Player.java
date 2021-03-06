package player;

import cards.Card;
import cards.Hand;

import java.util.*;
import java.awt.Point;

public class Player {

	private String name;
	private List<Card> holeCards;
	private Pos position;
	private int boardsWon;
	private Hand hand;
	private List<Card> combo;


	public Player(String name, ArrayList<Card> holeCards, Pos position) {
		this.name = name;
		this.holeCards = holeCards;
		this.position = position;
		this.boardsWon = 0;
		this.hand = Hand.HIGHCARD;
		this.combo = new ArrayList<Card>();
	}

	public String getName() { return this.name; }
	public List<Card> getHoleCards() { return this.holeCards; }
	public Pos getPosition() { return this.position; }
	public int getBoardsWon() { return this.boardsWon; }
	public Hand getHand() { return  this.hand; }
	public List<Card> getCombo() { return this.combo; }

	public Map<String, Point> getRelevantCoordinates() {
		ArrayList<String> relevantCoords = new ArrayList<String>(Arrays.asList("CardOneTopLeft", "CardTwoTopLeft",
				"CardOneValue", "CardTwoValue", "CardOneTopSuit", "CardOneBottomSuit",
				"CardTwoTopSuit", "CardTwoBottomSuit"));

		ArrayList<Point> adjustments = new ArrayList<Point>(Arrays.asList(
				new Point(0, 0),
				new Point(100, 0),
				new Point(25, 75),
				new Point(125, 75),
				new Point(0, 30),
				new Point(50, 110),
				new Point(100, 30),
				new Point(150, 110)
		));

		Map<String, Point> nameToCoordinate = new HashMap<String, Point>();
		Point basePoint;
		switch (this.position) {
			case BTN:
				basePoint = new Point(750, 600);
				break;
			case SB:
				basePoint = new Point(400, 450);
				break;
			case BB:
				basePoint = new Point(400, 250);
				break;
			case UTG:
				basePoint = new Point(750, 100);
				break;
			case HJ:
				basePoint = new Point(1100, 250);
				break;
			case CO:
				basePoint = new Point(1100, 450);
				break;
			default:
				basePoint = new Point(0, 0);
				break;
		}

		for(int i = 0; i < relevantCoords.size(); i++) {
			int adjustedX = basePoint.x + adjustments.get(i).x;
			int adjustedY = basePoint.y + adjustments.get(i).y;
			nameToCoordinate.put(relevantCoords.get(i), new Point(adjustedX, adjustedY));
		}
		return nameToCoordinate;
	}

	public void boardWon() {
		this.boardsWon++;
	}

	public void setHand(Hand h) {
		this.hand = h;
	}
}
