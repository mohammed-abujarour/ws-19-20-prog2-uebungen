package de.htwberlin.prog2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author Mohammed AbuJarour (mohammed.abujarour@htw-berlin.de)
 *
 */
public class CalculatorFrame extends JFrame {

    public CalculatorFrame() {
        super();
        this.setSize(150, 250);
        this.setLocation(200, 150);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel topPanel = initTopPanel();
        JPanel mainPanel = initMainPanel();

        this.getContentPane().add(topPanel, BorderLayout.NORTH);
        this.getContentPane().add(mainPanel, BorderLayout.CENTER);
    }

    private JPanel initMainPanel() {

        JPanel panel = new JPanel();

        panel.setLayout(new GridLayout(5, 4));
        String labels[] = { "\u2190", "C", "%", "+", "7", "8", "9", "-", "4", "5", "6", "*", "1", "2", "3", "/", "0",
                ".", "±", "=" };
        for (String label : labels)
            panel.add(new JButton(label));
        
        return panel;
    }

    private JPanel initTopPanel() {
        JPanel panel = new JPanel();

        JTextField txtNumber = new JTextField(10);
        txtNumber.setHorizontalAlignment(JTextField.RIGHT);
        txtNumber.setEditable(false);
        panel.add(txtNumber);

        return panel;
    }
}
