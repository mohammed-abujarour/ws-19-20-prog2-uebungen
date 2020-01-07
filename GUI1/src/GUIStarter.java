
/**
 * @author Mohammed AbuJarour (mohammed.abujarour@htw-berlin.de)
 *
 */
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

class GrundgeruestSwing extends JFrame implements ActionListener, MouseListener {

    private JButton klickMichbutton = new JButton("Klick mich"); // Button erzeugen
    private JButton endeButton = new JButton("Ende"); // Button erzeugen
    private JPanel hauptPanel = null;
    private Color farben[] = { Color.BLUE, Color.CYAN, Color.DARK_GRAY, Color.GRAY, Color.GREEN, Color.LIGHT_GRAY,
            Color.MAGENTA, Color.RED, Color.WHITE };
    private JLabel label1;
    private JMenuItem openFile = new JMenuItem("Open ... ");
    private JMenuItem saveFile = new JMenuItem("Save");

    public GrundgeruestSwing() {
        super(); // Konstruktor von JFrame
        setTitle("Titel Swing-Fenster"); // Titel des Fensters
        getContentPane().setBackground(Color.WHITE); // Hintergrundfarbe
//        getContentPane().add(new JLabel("Prog 2"));
        hauptPanel = init(); // eigene Methode init()
        this.getContentPane().add(hauptPanel);// Hauptpanel dem Fenster hinzufügen

        createMenu();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Klick auf x

        this.addMouseListener(this);
    }

    /**
     * 
     */
    private void createMenu() {

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");

        fileMenu.add(openFile);
        fileMenu.add(saveFile);

        openFile.addActionListener(this);
        saveFile.addActionListener(this);

        fileMenu.addSeparator();

        fileMenu.add("Exit");
        menuBar.add(fileMenu);
        this.setJMenuBar(menuBar);

    }

    private JPanel init() {
        JPanel panel = new JPanel();
        label1 = new JLabel("Hallo 2020!"); // Label erzeugen

        klickMichbutton.addActionListener(this);
        endeButton.addActionListener(this);

        panel.add(label1); // Label ans Panel
        panel.add(klickMichbutton); // Button ans Panel
        panel.add(endeButton);
        return panel;
    }

    public void actionPerformed(ActionEvent event) {

        Object quelle = event.getSource();

        if (quelle == klickMichbutton) {
            // change color
            changeColor();
        } else if (quelle == endeButton) {
            // exit program
            System.exit(0);
        } else if (quelle == openFile) {
            openFile();
        } else if (quelle == saveFile) {
            saveFile();
        }

    }

    private void saveFile() {

        File datei = null;
        JFileChooser fc = new JFileChooser();

        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);

        int returnVal = fc.showSaveDialog(this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            datei = fc.getSelectedFile();
        }

        if (datei != null) {
            String message = new String("Datei " + datei + " wird gespeichrt");
            JOptionPane.showMessageDialog(this, message);
        }

    }

    /**
     * 
     */
    private void openFile() {

        File datei = null;
        JFileChooser fc = new JFileChooser();

        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);

        int returnVal = fc.showOpenDialog(this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            datei = fc.getSelectedFile();
        }

        if (datei != null) {
            String message = new String("Datei " + datei + " wird geladen");
            JOptionPane.showMessageDialog(this, message);
        }

    }

    /**
     * 
     */
    private void changeColor() {
        String message = new String("Soll die Farbe wirklich geändert werden?");
        int antwort = JOptionPane.showConfirmDialog(this, message);

        if (antwort == JOptionPane.YES_OPTION) {
            // Farbe ändern
            int farbIndex = new Random().nextInt(farben.length);
            hauptPanel.setBackground(farben[farbIndex]);
            label1.setText(farben[farbIndex].toString());
            message = new String("Farbe wurden auf " + farben[farbIndex].toString() + " geändert");
            JOptionPane.showMessageDialog(this, message);
        } else if (antwort == JOptionPane.NO_OPTION) {
            message = new String("Farbe wird nicht geändert");
            JOptionPane.showMessageDialog(this, message);
        } else if (antwort == JOptionPane.CANCEL_OPTION) {
            message = new String("Aktion abgebrochen");
            JOptionPane.showMessageDialog(this, message);
        }

    }

    public void mouseClicked(MouseEvent e) {

        String message = "Button: " + e.getButton() + "\n" + "X,Y: (" + e.getX() + ", " + e.getY() + ")\n"
                + "X,Y on screen: (" + e.getXOnScreen() + ", " + e.getYOnScreen() + ")\n";
        JOptionPane.showMessageDialog(this, message);

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

public class GUIStarter {
    public static void main(String args[]) {
        GrundgeruestSwing hauptfenster = new GrundgeruestSwing();
        hauptfenster.setSize(400, 300); // wie groß?
        hauptfenster.setLocation(200, 300); // wo ?
        hauptfenster.setVisible(true); // sichtbar
    }
}