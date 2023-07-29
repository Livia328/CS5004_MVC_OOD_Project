package Controller;


import Model.Sanctuary;
import View.ListForEnclosurePage;
import View.VaccinationPage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**

 The ListForEnclosurePageController class is responsible for controlling the ListForEnclosurePage view,

 which allows the user to select a monkey species and generate a list of monkeys in a corresponding enclosure.

 This class retrieves information from the user interface, interacts with the Sanctuary model class

 to generate the list of monkeys, and displays the result to the user via a message dialog box.
 */

public class ListForEnclosurePageController {
    private ListForEnclosurePage listForEnclosurePage;
    private Sanctuary sanctuary;

    /**
     Constructs a ListForEnclosurePageController object with the given Sanctuary model.
     @param sanctuary the model object that interacts with the controller
     */
    public ListForEnclosurePageController(Sanctuary sanctuary) {
        this.listForEnclosurePage = new ListForEnclosurePage();
        this.listForEnclosurePage.setVisible(true);
        this.sanctuary = sanctuary;
        listForEnclosurePage.addSubmitButtonListener(new ListForEnclosurePageController.SubmitButtonListener());
    }

    /**
     An ActionListener that listens for a click on the "submit" button in the ListForEnclosurePage view.
     When the button is clicked, this method calls the showList() method to generate and display the list of monkeys.
     */
    private class SubmitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
           showList();
        }
    }

    /**
     Generates and displays a list of monkeys in the selected species enclosure.
     This method retrieves the monkey species information from the ListForEnclosurePage view,
     interacts with the Sanctuary model to generate the list of monkeys,
     and displays the result to the user via a message dialog box.
     */
    private void showList() {
        try {
            enums.MonkeySpecies species = listForEnclosurePage.getSpecies();
            List<String> list = sanctuary.generateListForEnclosure(species);
            if (list == null || list.size() == 0) {
                throw new IllegalStateException("This Enclosure is empty.");
            }
            String info = String.join("\n", list);
            JOptionPane.showMessageDialog(listForEnclosurePage, info);
        } catch (IllegalStateException e1) {
            JOptionPane.showMessageDialog(listForEnclosurePage, "Failed to show: " + e1.getMessage());
        } catch (Exception e1) {
            JOptionPane.showMessageDialog(listForEnclosurePage, "Failed to show: " + e1.getMessage());
        }
    }
}
