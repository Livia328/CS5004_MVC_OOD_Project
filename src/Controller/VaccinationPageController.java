package Controller;

import Model.Monkey;
import Model.Sanctuary;
import View.VaccinationPage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


/**

 The VaccinationPageController class interacts with the VaccinationPage and Sanctuary classes.

 It handles the user input and actions from the vaccination page.

 It allows the user to vaccinate a monkey and set it to a healthy state.
 */
public class VaccinationPageController {
    private VaccinationPage vaccinationPage;
    private Sanctuary sanctuary;

    /**
     Constructor of the VaccinationPageController with the specified Sanctuary.
     It initializes the VaccinationPage and submit button listener.
     @param sanctuary the sanctuary to operate on
     */
    public VaccinationPageController(Sanctuary sanctuary) {
        this.vaccinationPage = new VaccinationPage();
        this.vaccinationPage.setVisible(true);
        this.sanctuary = sanctuary;
        vaccinationPage.addSubmitButtonListener(new SubmitButtonListener());
    }

    /**
     The SubmitButtonListener class handles the action when the user clicks the submit button.
     */
    private class SubmitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            VaccinateMonkey();
        }
    }


    /**
     Vaccinates the monkey with the specified ID and sets it to a healthy state.
     If the specified monkey does not exist, an IllegalStateException is thrown.
     */
    private void VaccinateMonkey() {
        try {
            int id = Integer.parseInt(vaccinationPage.getID());
            Monkey target = findCorrespondingMonkey(id);
            target.setHealthy();
            JOptionPane.showMessageDialog(vaccinationPage, "Monkey has been vaccinated successfully!");
            // reset the input area
            vaccinationPage.resetTextArea();
        } catch (IllegalStateException e) {
            JOptionPane.showMessageDialog(vaccinationPage, "Failed to vaccinated: " + e.getMessage());
        }
    }

    /**
     Helper method that finds the monkey with the given ID from the list of all monkeys in the sanctuary.
     @param id The ID of the monkey to find.
     @return The monkey object with the given ID.
     @throws IllegalStateException if no monkey with the given ID is found in the sanctuary.
     */
    private Monkey findCorrespondingMonkey(int id) {
        List<Monkey> allMonkey = sanctuary.getAllMonkeyList();
        for (int i = 0; i < allMonkey.size(); i++) {
            Monkey cur = allMonkey.get(i);
            if (cur.getId() == id) {
                return cur;
            }
        }
        throw new IllegalStateException("This monkey doesn't exist! Please check again.");
    }
}
