package com.awesomeui.hotel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.List;
import java.util.Locale;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import de.htwberlin.prog2.ws1920.Backend;
import de.htwberlin.prog2.ws1920.Guest;
import de.htwberlin.prog2.ws1920.GuestComparator;

/**
 * @author Mohammed AbuJarour (mohammed.abujarour@htw-berlin.de)
 *
 */
public class MainFrame extends JFrame implements ActionListener {

    private static final long serialVersionUID = 6317418651917320011L;
    private static final int FRAME_WIDTH = 500;
    private static final int FRAME_HEIGHT = 400;
    private JPanel mainPanel;
    private JButton btnSortGuests;
    private JButton btnChangeDisplayName;

    private JList<GuestWrapper> guestList;
    private JRadioButton firstNameLastName;
    private JRadioButton lastNameFirstName;

    public MainFrame(String title) {
        super(title);
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setLocation(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = initMainPanel();
        getContentPane().add(mainPanel);
    }

 
    private JPanel initMainPanel() {

        mainPanel = new JPanel();

        initDisplayOptions();

        initDisplayOptionsButton();

        initGuestList();

        initSortButton();

        initGuestDetailsButton();

        return mainPanel;
    }


    private void initGuestDetailsButton() {
        JButton guestDetails = new JButton("Gastdetails zeigen");
        guestDetails.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                GuestWrapper selectedGuest = guestList.getSelectedValue();
                String guestString = "Bitte einen Gast auswälen";
                if (selectedGuest != null)
                    guestString = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.GERMANY)
                            .format(selectedGuest.getBirthDate()) + "\n" + selectedGuest.getPrivateAdresse();
                JOptionPane.showMessageDialog(mainPanel, guestString);
            }
        });
        mainPanel.add(guestDetails);
    }

 
    private void initSortButton() {
        btnSortGuests = new JButton("Gästeliste sortieren");
        btnSortGuests.addActionListener(this);
        mainPanel.add(btnSortGuests);
    }

 
    private void initGuestList() {
        GuestWrapper guests[] = Utils.buildGuestWrappers(Backend.getHotel().getGuests());//Backend.getHotel().getGuests().toArray(new Guest[] {});
        guestList = new JList<>(guests);
        guestList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        mainPanel.add(new JScrollPane(guestList));
    }

   
    private void initDisplayOptionsButton() {
        btnChangeDisplayName = new JButton("Liste aktualisieren");
        btnChangeDisplayName.addActionListener(this);
        mainPanel.add(btnChangeDisplayName);
    }

  
    private void initDisplayOptions() {
        firstNameLastName = new JRadioButton("Vorname Nachname", true);
        lastNameFirstName = new JRadioButton("Nachname, Vorname");

        ButtonGroup group = new ButtonGroup();
        group.add(firstNameLastName);
        group.add(lastNameFirstName);
        mainPanel.add(firstNameLastName);
        mainPanel.add(lastNameFirstName);
    }

    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();

        if (!(source instanceof JButton))
            return;
        JButton sourceButton = (JButton) source;
        if (sourceButton == btnSortGuests) {
            guestList.removeAll();
            List<Guest> guests = Backend.getHotel().getGuests();
            guests.sort(new GuestComparator());
            guestList.setListData(Utils.buildGuestWrappers(guests));

        } else if (sourceButton == btnChangeDisplayName) {
            System.out.println(firstNameLastName.isSelected());
            System.out.println(lastNameFirstName.isSelected());
        }

    }

}
