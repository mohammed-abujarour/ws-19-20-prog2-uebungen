package de.htwberlin.prog2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author Mohammed AbuJarour (mohammed.abujarour@htw-berlin.de)
 *
 */
public class MyFrame extends JFrame {

    private Font font = new Font("Serif", Font.BOLD, 60);

    public MyFrame() {
        super("Swing macht Spaß!");
        this.setSize(800, 600);
        centerWindowOnScreen();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel mainPanel = nullLayout();
        this.getContentPane().add(mainPanel);
    }

    /**
     * @return
     */
    private JPanel nullLayout() {

        this.setTitle(this.getTitle() + " Null Layout");
        JPanel panel = new JPanel();
        panel.setLayout(null);
        for (int i = 1; i < 11; i++) {
            Component component = new JButton("Button " + i);
//            component.setLocation(i*35, i*35);
//            component.setSize(100, 30);
            component.setBounds(new Rectangle(i*35, i*35, 100, 30));
            panel.add(component);
        }
        return panel;
    }

    /**
     * @return
     */
    private JPanel borderLayout() {

        this.setTitle(this.getTitle() + " BorderLayout");
        JPanel panel = new JPanel(new BorderLayout());

        JPanel topPanel = createTopPanel();
        panel.add(topPanel, BorderLayout.NORTH);

        JPanel leftPanel = createLeftPanel();
        panel.add(leftPanel, BorderLayout.WEST);

        JPanel mainPanel = createMiddlePanel();
        panel.add(mainPanel, BorderLayout.CENTER);

        JPanel rightPanel = createRightPanel();
        panel.add(rightPanel, BorderLayout.EAST);

        JPanel bottomPanel = createBottomPanel();
        panel.add(bottomPanel, BorderLayout.SOUTH);

        return panel;
    }

    /**
     * @return
     */
    private JPanel createBottomPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 251, 121));
        JLabel label = new JLabel("Bottom ");
        label.setFont(font);
        panel.add(label);

        return panel;
    }

    /**
     * @return
     */
    private JPanel createRightPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(118, 214, 255));
        JLabel label = new JLabel("Right ");
        label.setFont(font);
        panel.add(label);

        return panel;
    }

    /**
     * @return
     */
    private JPanel createMiddlePanel() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 212, 121));
        JLabel label = new JLabel("Center ");
        label.setFont(font);
        panel.add(label);

        return panel;
    }

    /**
     * @return
     */
    private JPanel createLeftPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(0.8f, 0.4f, 0.6f, 0.8f));
        JLabel label = new JLabel("West ");
        label.setFont(font);
        panel.add(label);

        return panel;
    }

    /**
     * @return
     */
    private JPanel createTopPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(111999));
        JLabel label = new JLabel("North ");
        label.setFont(font);
        panel.add(label);

        return panel;
    }

    /**
     * @return
     */
    private JPanel gridLayout() {

        this.setTitle(this.getTitle() + " GridLayout");
        JPanel panel = new JPanel();
        for (int i = 1; i < 11; i++)
            panel.add(new JButton("Button " + i));

        int rows = 5; // 3;
        int cols = 2; // 3;
        int hgap = 20;
        int vgap = 10;
        LayoutManager gridLayout = new GridLayout(rows, cols, hgap, vgap);
        panel.setLayout(gridLayout);
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
