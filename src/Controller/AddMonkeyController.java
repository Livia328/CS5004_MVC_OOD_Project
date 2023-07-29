package Controller;

import Model.Monkey;
import Model.Sanctuary;
import View.AddMonkeyPage;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**

 The AddMonkeyController class interacts with the AddMonkeyPage and Sanctuary classes to achieve this functionality.

 it responsible for handling user input and adding a new monkey to the sanctuary.

 */
public class AddMonkeyController {
    private AddMonkeyPage addMonkeyPage;
    private Sanctuary sanctuary;

    /**
     Constructor of AddMonkeyController object.

     with a reference to the sanctuary and initializes the
     AddMonkeyPage object, making it visible to the user.

     @param sanctuary a Sanctuary object representing the monkey sanctuary, the data model of this project.
     */
    public AddMonkeyController(Sanctuary sanctuary) {
        // initializes the AddMonkeyPage object
        addMonkeyPage = new AddMonkeyPage();
        // making the AddMonkeyPage visible to the user
        addMonkeyPage.setVisible(true);
        this.sanctuary = sanctuary;
        addMonkeyPage.addSubmitButtonListener(new SubmitButtonListener());
    }

    /**
     Inner class SubmitButtonListener is a private class that implements ActionListener interface.
     It is responsible for handling the submit button click event and calling the createMonkey() method.
     */
    private class SubmitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Handle submit button click event
            // when the button is clicked, creat the monkey using the input data
            createMonkey();
        }
    }

    /**

     The createMonkey() method gets the user input from the AddMonkeyPage and creates a new Monkey object
     based on that input. It then adds the monkey to the sanctuary and displays a success message to the user.
     If any errors occur, it displays an appropriate error message to the user.
     */
    private void createMonkey() {
        try {
            int id = Integer.parseInt(addMonkeyPage.getId());
            String name = addMonkeyPage.getName();
            enums.MonkeySpecies species = addMonkeyPage.getSpecies();
            enums.Sex sex = addMonkeyPage.getSex();
            double size = Double.parseDouble(addMonkeyPage.getMonkeySize());
            double weight = Double.parseDouble(addMonkeyPage.getWeight());
            int age = Integer.parseInt(addMonkeyPage.getAge());
            enums.FavouriteFood favouriteFood = addMonkeyPage.getFavouriteFood();
            Monkey monkey = new Monkey(id, name, species, sex, size, weight, age, favouriteFood);
            // Show success message to user
            sanctuary.addMonkeyToIsolation(monkey);
            JOptionPane.showMessageDialog(addMonkeyPage, "Monkey added successfully!");
            // reset the input area
            addMonkeyPage.resetTextArea();
            // show error massage to user
        } catch (IllegalStateException e) {
            JOptionPane.showMessageDialog(addMonkeyPage, "Failed to add monkey: " + e.getMessage());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(addMonkeyPage, "Failed to add monkey: " + e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(addMonkeyPage, "An error occurred while adding the monkey: " + e.getMessage());
        }
    }

}
