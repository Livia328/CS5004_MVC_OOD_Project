package View;

import Controller.AddMonkeyController;
import Model.Sanctuary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The WelcomePage class extends the JFrame class and provides the main page of the application
 * with buttons to access different functionalities.
 *
 * AddmonkeyButton: The user should be able to register new monkeys into the sanctuary
 *
 * VaccinationPageButton: Vaccinate a monkey according to the given ID.
 *
 * MoveMonkeyPageButton: move to the right enclosure monkeys that have received medical attention
 *
 * ListForEnclosurePageButton: produce a list for a certain enclosure of given species
 *
 * GetAlphaListPageButton: produce an alphabetical list.
 */
public class WelcomePage extends JFrame {
//    private Sanctuary model;
    private JButton activateAddMonkeyPageButton,
            activateVaccinationPageButton,
            activateMoveMonkeyPageButton,
            activateListForEnclosurePageButton,
            activateGetAlphaListPageButton;

    /**
     Constructs a WelcomePage object.
     Sets the title and size of the window, sets the close operation to exit the program,
     creates buttons for adding a monkey, vaccinating a monkey, moving a monkey to an enclosure,
     getting a list of monkeys for every enclosure, and getting a list of all monkeys housed in the Sanctuary.
     Adds the buttons to a JPanel and sets the content pane of the JFrame to the button panel.
     */
    public WelcomePage() {
        // activate the model
//        this.model = sanctuary;

        // set the title of the window
        setTitle("Main Page");

        // set the size of the window
        setSize(400, 300);

        // set the close operation to exit the program when the window is closed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // create a JPanel to contain the buttons
        JPanel panel1 = new JPanel();

        // create the add Monkey button
        activateAddMonkeyPageButton = new JButton("Add Monkey");
//        addMonkeyButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                // display the add Monkey page
//                AddMonkeyPage addMonkeyPage = new AddMonkeyPage();
//                AddMonkeyController monkeyController = new AddMonkeyController(addMonkeyPage, model);
//                addMonkeyPage.setVisible(true);
//            }
//        });
        activateVaccinationPageButton = new JButton("Vaccinate Monkey");
        activateMoveMonkeyPageButton = new JButton("Move Monkey to Enclosure");
        activateListForEnclosurePageButton = new JButton("Get list for every enclosure");
        activateGetAlphaListPageButton = new JButton("Get all monkeys housed in the Sanctuary");


        // add buttons to the button panel
        panel1.add(activateAddMonkeyPageButton);
        panel1.add(activateVaccinationPageButton);
        panel1.add(activateMoveMonkeyPageButton);
        panel1.add(activateListForEnclosurePageButton);
        panel1.add(activateGetAlphaListPageButton);


        // add the button panel to the JFrame's content pane
        getContentPane().add(panel1, BorderLayout.CENTER);
    }


    /**
     Activates the add monkey page button listener.
     @param listener an ActionListener object
     */
    public void activateAddMonkeyPageButtonListener(ActionListener listener) {
        activateAddMonkeyPageButton.addActionListener(listener);
    }

    /**
     Activates the move monkey page button listener.
     @param listener an ActionListener object
     */
    public void activateMoveMonkeyPageButtonListener(ActionListener listener) {
        activateMoveMonkeyPageButton.addActionListener(listener);
    }

    /**
     Activates the vaccination page button listener.
     @param listener an ActionListener object
     */
    public void activateVaccinationPageButtonListener(ActionListener listener) {
        activateVaccinationPageButton.addActionListener(listener);
    }

    /**
     Activates the list for every enclosure page button listener.
     @param listener an ActionListener object
     */
    public void activateListForEnclosurePageButtonListener(ActionListener listener) {
        activateListForEnclosurePageButton.addActionListener(listener);
    }

    /**
     Activates the get all monkeys housed in the Sanctuary button listener.
     @param listener an ActionListener object
     */
    public void activateGetAlphaListPageButtonListener(ActionListener listener) {
        activateGetAlphaListPageButton.addActionListener(listener);
    }
}
