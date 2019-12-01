import cards.Card;
import cards.Suit;
import cards.Deck;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

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

        System.out.println(deck.showCards());
    }
}
