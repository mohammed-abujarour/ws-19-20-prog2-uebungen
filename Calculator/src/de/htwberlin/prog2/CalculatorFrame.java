package de.htwberlin.prog2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author Mohammed AbuJarour (mohammed.abujarour@htw-berlin.de)
 *
 */
public class CalculatorFrame extends JFrame implements ActionListener {

    private JTextField txtNumber;
    
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
        for (String label : labels) {
            JButton button = new JButton(label);
            button.addActionListener(this);
            panel.add(button);
        }

        return panel;
    }

    private JPanel initTopPanel() {
        JPanel panel = new JPanel();

        txtNumber = new JTextField(10);
        txtNumber.setHorizontalAlignment(JTextField.RIGHT);
        txtNumber.setEditable(false);
        panel.add(txtNumber);

        return panel;
    }

    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();
        if (!(source instanceof JButton))
            return;
        JButton sourceButton = (JButton) source;
        String label = sourceButton.getText();
        if (isNumber(label))
            txtNumber.setText(txtNumber.getText()+label);


    }

    private boolean isNumber(String label) {

        try {
            Double.parseDouble(label);
        } catch (Exception exc) {
            return false;
        }
        return true;
    }
}
