package de.htwberlin.prog2;

import java.awt.Dimension;
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
        JPanel mainPanel = defaultLayout();
        this.getContentPane().add(mainPanel);
    }


    private JPanel defaultLayout() {

        JPanel panel = new JPanel();
        for(int i=1; i< 11; i++)
            panel.add(new JButton("Button " + i));
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
