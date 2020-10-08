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

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		Font f = new Font("Card Values", Font.PLAIN, 48);
		g.setFont(f);

		g.drawRect(750, 600, 80, 120);
		g.drawRect(850, 600, 80, 120);
		g.drawString("A", 775, 675);
		g.drawString("A", 875, 675);


		g.drawRect(400, 450, 80, 120);
		g.drawRect(500, 450, 80, 120);
		g.drawString("K", 425, 525);
		g.drawString("K", 525, 525);

		g.drawRect(400, 250, 80, 120);
		g.drawRect(500, 250, 80, 120);
		g.drawString("Q", 425, 325);
		g.drawString("Q", 525, 325);


		g.drawRect(750, 100, 80, 120);
		g.drawRect(850, 100, 80, 120);
		g.drawString("J", 775, 175);
		g.drawString("J", 875, 175);

		g.drawRect(1100, 250, 80, 120);
		g.drawRect(1200, 250, 80, 120);
		g.drawString("10", 1125, 325);
		g.drawString("10", 1225, 325);

		g.drawRect(1100, 450, 80, 120);
		g.drawRect(1200, 450, 80, 120);
		g.drawString("9", 1125, 525);
		g.drawString("9", 1225, 525);

		Font f2 = new Font("Card Suits", Font.PLAIN, 36);
		g.setFont(f2);

		g.drawString("♠", 750, 630);
		g.drawString("♠", 800, 710);
		g.drawString("♣", 850, 630);
		g.drawString("♣", 900, 710);

		g.drawString("♥", 400, 480);
		g.drawString("♥", 450, 560);
		g.drawString("♦", 500, 480);
		g.drawString("♦", 550, 560);

		g.drawString("♠", 400, 280);
		g.drawString("♠", 450, 360);
		g.drawString("♥", 500, 280);
		g.drawString("♥", 550, 360);

		g.drawString("♦", 750, 130);
		g.drawString("♦", 800, 210);
		g.drawString("♣", 850, 130);
		g.drawString("♣", 900, 210);

		g.drawString("♥", 1100, 280);
		g.drawString("♥", 1150, 360);
		g.drawString("♣", 1200, 280);
		g.drawString("♣", 1250, 360);

		g.drawString("♠", 1100, 480);
		g.drawString("♠", 1150, 560);
		g.drawString("♦", 1200, 480);
		g.drawString("♦", 1250, 560);

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

	    SwingUtilities.invokeLater(new Runnable() {
		    @Override
		    public void run() {
			    createAndShowGui();
		    }
	    });

//        System.out.println(deck.showCards());
    }

}
