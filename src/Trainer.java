import cards.Card;
import cards.Suit;
import cards.Deck;
import player.Player;
import player.Pos;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class Trainer extends JPanel {

	private static final int CARD_X = 20;
	private static final int CARD_Y = 20;
	private static final int CARD_WIDTH = 25;
	private static final int CARD_HEIGHT = 75;
	private static List<Player> players = new ArrayList<Player>();


	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		Font f = new Font("Card Values", Font.PLAIN, 48);
		Font f2 = new Font("Card Suits", Font.PLAIN, 36);

		for (Player p : players) {
			System.out.println(p.getName() + " " + p.getHand() + " " + p.getPosition() + p.getRelevantCoordinates());

			g.setFont(f);
			g.drawRect(p.getRelevantCoordinates().get("CardOneTopLeft").x,
					p.getRelevantCoordinates().get("CardOneTopLeft").y,
					80, 120);
			g.drawRect(p.getRelevantCoordinates().get("CardTwoTopLeft").x,
					p.getRelevantCoordinates().get("CardTwoTopLeft").y,
					80, 120);
			g.drawString("A", p.getRelevantCoordinates().get("CardOneValue").x,
					p.getRelevantCoordinates().get("CardOneValue").y);
			g.drawString("A", p.getRelevantCoordinates().get("CardTwoValue").x,
					p.getRelevantCoordinates().get("CardTwoValue").y);

			g.setFont(f2);
			g.drawString("♠", p.getRelevantCoordinates().get("CardOneTopSuit").x,
					p.getRelevantCoordinates().get("CardOneTopSuit").y);
			g.drawString("♠", p.getRelevantCoordinates().get("CardOneBottomSuit").x,
					p.getRelevantCoordinates().get("CardOneBottomSuit").y);
			g.drawString("♠", p.getRelevantCoordinates().get("CardTwoTopSuit").x,
					p.getRelevantCoordinates().get("CardTwoTopSuit").y);
			g.drawString("♠", p.getRelevantCoordinates().get("CardTwoBottomSuit").x,
					p.getRelevantCoordinates().get("CardTwoBottomSuit").y);
		}
	}


	@Override
	public Dimension getPreferredSize() {
		return new Dimension(1700, 1000);
	}

	private static void createAndShowGui() {
		Trainer mainPanel = new Trainer();
		JFrame frame = new JFrame("Preflop Trainer");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(mainPanel);
		frame.pack();
		frame.setLocationByPlatform(true);
		frame.setVisible(true);

	}

    public static void main(String args[]) {

        Deck deck = new Deck();
        deck.shuffle();

        int numPlayers = 6;

        for (int i = 0; i < numPlayers; i++) {
            ArrayList<Card> holeCards = new ArrayList<Card>();
            holeCards.add(deck.topCard());
            holeCards.add(deck.topCard());
            Player player = new Player("Player " + (i + 1), holeCards, Pos.values()[i]);
            players.add(player);
        }

	    SwingUtilities.invokeLater(new Runnable() {
		    @Override
		    public void run() {
			    createAndShowGui();
		    }
	    });

    }

}
