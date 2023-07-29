package Controller;

import Model.Monkey;
import Model.Sanctuary;
import View.MoveMonkeyPage;
import View.VaccinationPage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**

 The MoveMonkeyPageController class is responsible for controlling the MoveMonkeyPage and handling user inputs.

 It interacts with the Sanctuary class to move a monkey from isolation to an enclosure.
 */

public class MoveMonkeyPageController {

    private MoveMonkeyPage moveMonkeyPage;
    private Sanctuary sanctuary;


    /**
     Constructor for the MoveMonkeyPageController class.
     Initializes the MoveMonkeyPage Page and sets up the submit button listener.
     @param sanctuary The sanctuary object to interact with.
     */
    public MoveMonkeyPageController(Sanctuary sanctuary) {
        this.moveMonkeyPage = new MoveMonkeyPage();
        this.moveMonkeyPage.setVisible(true);
        this.sanctuary = sanctuary;
        moveMonkeyPage.addSubmitButtonListener(new SubmitButtonListener());
    }


    /**
     Private inner class that implements ActionListener interface to handle the submit button click event.
     */
    private class SubmitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            MoveMonkey();
        }
    }

    /**

     Method moves the monkey from isolation to an enclosure.
     It gets the monkey's ID from the MoveMonkeyPage and finds the corresponding monkey in the sanctuary.
     Then it moves the monkey to an enclosure in the sanctuary.
     Shows a success message to the user if the move is successful, otherwise shows an error message.
     */

    private void MoveMonkey() {
        try {
            int id = Integer.parseInt(moveMonkeyPage.getID());
            Monkey target = findCorrespondingMonkey(id);
            sanctuary.moveMonkeyFromIsolationToEnclosure(target);
            JOptionPane.showMessageDialog(moveMonkeyPage, "Monkey has been moved successfully!");
        } catch (Exception e1) {
            JOptionPane.showMessageDialog(moveMonkeyPage, "Failed to move: " + e1.getMessage());
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
