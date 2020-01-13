package de.htwberlin.prog2;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Mohammed AbuJarour (mohammed.abujarour@htw-berlin.de)
 *
 */
public class MyFrame extends JFrame {

    public MyFrame() {
        super("Swing macht Spaß!");
        this.setSize(800, 600);
        centerWindowOnScreen();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel mainPanel = gridLayout();
        this.getContentPane().add(mainPanel);
    }

    /**
     * @return
     */
    private JPanel gridLayout() {

        this.setTitle(this.getTitle() + " GridLayout");
        JPanel panel = new JPanel();
        for (int i = 1; i < 11; i++)
            panel.add(new JButton("Button " + i));
        
        int rows = 5; //3;
        int cols = 2; //3;
        LayoutManager gridLayout = new GridLayout(rows, cols);
        panel.setLayout(gridLayout );
        return panel;
    }

    private JPanel defaultLayout() {

        this.setTitle(this.getTitle() + " Default Layout");
        JPanel panel = new JPanel();
        for (int i = 1; i < 11; i++)
            panel.add(new JButton("Button " + i));
        return panel;
    }

    private JPanel flowLayout() {

        this.setTitle(this.getTitle() + " Flow Layout");
        JPanel panel = new JPanel();
        for (int i = 1; i < 11; i++)
            panel.add(new JButton("Button " + i));

        int align = FlowLayout.LEFT;
        int hgap = 30;
        int vgap = 30;
        panel.setLayout(new FlowLayout(align, hgap, vgap));
        return panel;
    }

    /**
     * 
     */
    private void centerWindowOnScreen() {
        Dimension screenDimensions = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((screenDimensions.getWidth() - this.getWidth()) / 2);
        int y = (int) ((screenDimensions.getHeight() - this.getHeight()) / 2);

        this.setLocation(x, y);

    }
}
