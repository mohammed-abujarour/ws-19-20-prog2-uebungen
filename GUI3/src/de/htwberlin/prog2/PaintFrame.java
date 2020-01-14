package de.htwberlin.prog2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Mohammed AbuJarour (mohammed.abujarour@htw-berlin.de)
 *
 */
public class PaintFrame extends JFrame implements MouseListener {

    private List<Point> points = new ArrayList<>();

    public PaintFrame() {
        super();

        this.setSize(400, 300);
        this.setLocation(300, 200);
        init();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void init() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.white);
        panel.addMouseListener(this);
        getContentPane().add(panel);

    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        Dimension dimension = new Dimension(3, 3);
        Random rand = new Random();
        for (Point point : points) {
            g2.setColor(new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));
            Rectangle rectangle = new Rectangle(point, dimension);
            g2.draw(rectangle);
        }
    }

    public void mouseClicked(MouseEvent e) {

        Point p = new Point(e.getX(), e.getY() + 20);
        points.add(p);
        this.repaint();
    }

    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }

}
