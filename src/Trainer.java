import cards.Card;
import cards.Suit;
import cards.Deck;
import player.Player;
import player.Pos;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class Trainer extends JPanel {

	private static final int CARD_X = 20;
	private static final int CARD_Y = 20;
	private static final int CARD_WIDTH = 25;
	private static final int CARD_HEIGHT = 75;

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawRect(CARD_X, CARD_Y, CARD_WIDTH, CARD_HEIGHT);
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

		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				createAndShowGui();
			}
		});

        Deck deck = new Deck();
        deck.shuffle();

        int numPlayers = 6;
        List<Player> players = new ArrayList<Player>();

        for (int i = 0; i < numPlayers; i++) {
            ArrayList<Card> holeCards = new ArrayList<Card>();
            holeCards.add(deck.topCard());
            holeCards.add(deck.topCard());
            Player player = new Player("Player " + (i + 1), holeCards, Pos.values()[i]);
            players.add(player);
        }

        for (Player p : players) {
            System.out.println(p.getName() + " " + p.getHand() + " " + p.getPosition());
        }


//        System.out.println(deck.showCards());
    }

}
