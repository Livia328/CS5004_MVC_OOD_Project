package Controller;

import Model.Monkey;
import Model.Sanctuary;
import View.WelcomePage;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


/**

 The WelcomePageController class handles user input and events from the WelcomePage GUI.

 It contains 5 buttons, activateAddMonkeyPageButton, activateMoveMonkeyPageButton, activateVaccinationPageButton
 activateListForEnclosurePageButton, and activateGetAlphaListPageButton.

 It creates instances of other controllers when the corresponding button is clicked, and then guide the client
 to the corresponding page.
 */
public class WelcomePageController {

    private WelcomePage welcomePage;
    private Sanctuary sanctuary;


    /**

     Constructor of the WelcomePageController class.

     It creates a new instance of the WelcomePage, and activate event listener for each button

     @param sanctuary the sanctuary instance used by this controller
     */
    public WelcomePageController(Sanctuary sanctuary) {
        // generate new welcome page
        this.welcomePage = new WelcomePage();
        // set the welcome page to be visible
        welcomePage.setVisible(true);
        this.sanctuary = sanctuary;

        welcomePage.activateAddMonkeyPageButtonListener(new WelcomePageController.activateAddMonkeyPageButtonListener());
        welcomePage.activateMoveMonkeyPageButtonListener(new WelcomePageController.activateMoveMonkeyPageButtonListener());
        welcomePage.activateVaccinationPageButtonListener(new WelcomePageController.activateVaccinationPageButtonListener());
        welcomePage.activateListForEnclosurePageButtonListener(new WelcomePageController.activateListForEnclosurePageButtonListener());
        welcomePage.activateGetAlphaListPageButtonListener(new WelcomePageController.activateGetAlphaListPageButtonListener());
    }

    /**
     ActionListener for the AddMonkeyPageButton
     */
    private class activateAddMonkeyPageButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e)  {
            // activate the add monkey controller here
            AddMonkeyController addMonkeyController = new AddMonkeyController(sanctuary);
        }
    }

    /**
     ActionListener for the VaccinationPageButton
     */
    private class activateVaccinationPageButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e)  {
            // activate the controller here
            VaccinationPageController vaccinationPageController = new VaccinationPageController(sanctuary);
        }
    }

    /**
     ActionListener for the MoveMonkeyPageButton
     */
    private class activateMoveMonkeyPageButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e)  {
            MoveMonkeyPageController moveMonkeyPageController = new MoveMonkeyPageController(sanctuary);
        }
    }

    /**
     ActionListener for the ListForEnclosurePageButton
     */
    private class activateListForEnclosurePageButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e)  {
            ListForEnclosurePageController listForEnclosurePageController = new ListForEnclosurePageController(sanctuary);
        }
    }

    /**
     ActionListener for the GetAlphaListPageButton
     It implements the function of generating a list of all monkeys in the sanctuary via a MessageDialog.
     If success, it will show a list of monkeys, otherwise, it will show error message.
     */
    private class activateGetAlphaListPageButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e)  {
            try {
                List<Monkey> curMonkey = sanctuary.getAllMonkeyList();
                if (curMonkey == null || curMonkey.size() == 0) {
                    throw new IllegalStateException("There is no Monkey in this Sanctuary.");
                }
                String info = "";
                for (int i = 0; i < curMonkey.size(); i++) {
                    info += curMonkey.get(i).toString() + "\n";
                }
                JOptionPane.showMessageDialog(welcomePage, info, "All monkeys in this Sanctuary ", JOptionPane.INFORMATION_MESSAGE);
            } catch (IllegalStateException e1) {
                JOptionPane.showMessageDialog(welcomePage, "Failed to add monkey: " + e1.getMessage());
            }
        }
    }

}
