import cards.Card;
import cards.Suit;
import cards.Deck;
import player.Player;
import player.Pos;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Trainer extends JPanel {

    private Point lastPoint;

    public Trainer() {
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                lastPoint = new Point(e.getX(), e.getY());
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                Graphics g = getGraphics();
                g.drawLine(lastPoint.x, lastPoint.y, e.getX(), e.getY());
                g.dispose();
            }
        });
    }

    public static void main(String args[]) {

        JFrame frame = new JFrame("Preflop Trainer");
        frame.getContentPane().add(new Trainer(), BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,300);
        frame.setVisible(true);

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
