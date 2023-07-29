package View;

import Model.Sanctuary;
import com.sun.javafx.logging.JFRInputEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**

 AddMonkeyPage is a JFrame class that displays a form to add monkey information.

 The form includes labels and fields for monkey id, name, species, sex, size, weight, age, and favourite food.

 The class provides methods to retrieve the values of each field, reset the text area, and add a submit button listener.

 */
public class AddMonkeyPage extends JFrame{
    private JLabel idLabel, nameLabel, speciesLabel, sexLabel, sizeLabel, weightLabel, ageLabel, foodLabel;
    private JTextField idField, nameField, sizeField, weightField, ageField;
    private JComboBox<enums.MonkeySpecies> speciesComboBox;
    private JComboBox<enums.Sex> sexComboBox;
    private JComboBox<enums.FavouriteFood> favouriteFoodComboBox;
    private JButton submitButton;

    /**

     Constructs an AddMonkeyPage object that creates the form to add monkey information.

     The form includes labels and fields for monkey id, name, species, sex, size, weight, age, and favourite food.

     Also, it creates a submit button and a panel to add components to it.

     Finally, the panel is set as the content pane of the JFrame.
     */
    public AddMonkeyPage() {
        // set the title of the window
        setTitle("Add Monkey Form");

        // set the size of the window
        setSize(400, 300);

        // set the close operation to exit the program when the window is closed
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        // create the labels
        idLabel = new JLabel("ID:");
        nameLabel = new JLabel("Name:");
        speciesLabel = new JLabel("Species:");
        sexLabel = new JLabel("Sex:");
        sizeLabel = new JLabel("Size:");
        weightLabel = new JLabel("Weight:");
        ageLabel = new JLabel("Age:");
        foodLabel = new JLabel("Favourite Food:");

        // create the text fields
        idField = new JTextField(20);
        nameField = new JTextField(20);
        sizeField = new JTextField(10);
        weightField = new JTextField(10);
        ageField = new JTextField(10);

        // create the combo box for species selection
        speciesComboBox = new JComboBox<>(enums.MonkeySpecies.values());
        speciesComboBox.setSelectedIndex(0);

        // create the combo box for sex selection
        sexComboBox = new JComboBox<>(enums.Sex.values());
        sexComboBox.setSelectedIndex(0);

        // create the combo box for favourite food selection
        favouriteFoodComboBox = new JComboBox<>(enums.FavouriteFood.values());
        favouriteFoodComboBox.setSelectedIndex(0);

        // create the submit button
        submitButton = new JButton("Submit");

        // create the panel and add the components to it
        JPanel panel = new JPanel(new GridLayout(0, 2));
        panel.add(idLabel);
        panel.add(idField);
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(speciesLabel);
        panel.add(speciesComboBox);
        panel.add(sexLabel);
        panel.add(sexComboBox);
        panel.add(sizeLabel);
        panel.add(sizeField);
        panel.add(weightLabel);
        panel.add(weightField);
        panel.add(ageLabel);
        panel.add(ageField);
        panel.add(foodLabel);
        panel.add(favouriteFoodComboBox);
        panel.add(submitButton);

        // set the panel as the content pane of the JFrame
        setContentPane(panel);
    }

    /**
     Resets the text area by setting all the fields to empty.
     */
    public void resetTextArea() {
        idField.setText("");
        nameField.setText("");
        speciesComboBox.setSelectedIndex(0);
        sexComboBox.setSelectedIndex(0);
        sizeField.setText("");
        weightField.setText("");
        ageField.setText("");
        favouriteFoodComboBox.setSelectedIndex(0);
    }

    /**
     Retrieves the text from the ID field.
     @return the ID entered in the ID field
     */
    public String getId() {
        return idField.getText();
    }


    /**
     Retrieves the text from the Name field.
     Throws a NumberFormatException if the field is empty.
     @return the name entered in the Name field
     @throws NumberFormatException if the Name field is empty
     */
    public String getName() {
        if (nameField.getText() == null) {
            throw new NumberFormatException("Name Field is Empty, please check again.");
        }
        return nameField.getText();
    }


    /**
     Retrieves the selected species from the Species combo box.
     Throws a NumberFormatException if no species is selected.
     @return the selected species from the Species combo box
     @throws NumberFormatException if no species is selected
     */
    public enums.MonkeySpecies getSpecies() {
        if (speciesComboBox.getSelectedItem() == null) {
            throw new NumberFormatException("Species Field is Empty, please check again.");
        }
        return (enums.MonkeySpecies) speciesComboBox.getSelectedItem();
    }

    /**
     Retrieves the selected sex from the Sex combo box.
     Throws a NumberFormatException if no sex is selected.
     @return the selected sex from the Sex combo box
     @throws NumberFormatException if no sex is selected
     */
    public enums.Sex getSex() {
        if (sexComboBox.getSelectedItem() == null) {
            throw new NumberFormatException("Sex Field is Empty, please check again.");
        }
        return (enums.Sex) sexComboBox.getSelectedItem();
    }

    /**
     Retrieves the text from the Size field.
     Throws a NumberFormatException if the field is empty.
     @return the size entered in the Size field
     @throws NumberFormatException if the Size field is empty
     */
    public String getMonkeySize() {
        if (sizeField.getText() == null) {
            throw new NumberFormatException("Size Field is Empty, please check again.");
        }
        return sizeField.getText();
    }

    /**
     Retrieves the text from the Weight field.
     Throws a NumberFormatException if the field is empty.
     @return the weight entered in the Weight field
     @throws NumberFormatException if the Weight field is empty
     */
    public String getWeight() {
        if (weightField.getText() == null) {
            throw new NumberFormatException("Weight Field is Empty, please check again.");
        }
        return weightField.getText();
    }

    /**
     Retrieves the text from the Age field.
     Throws a NumberFormatException if the field is empty.
     @return the age entered in the Age field
     @throws NumberFormatException if the Age field is empty
     */
    public String getAge() {
        if (ageField.getText() == null) {
            throw new NumberFormatException("Age Field is Empty, please check again.");
        }
        return ageField.getText();
    }

    /**
     Retrieves the selected favourite food from the Favourite Food combo box.
     Throws a NumberFormatException if no favourite food is selected.
     @return the selected favourite food from the Favourite Food combo box
     @throws NumberFormatException if no favourite food is selected
     */
    public enums.FavouriteFood getFavouriteFood() {
        if (favouriteFoodComboBox.getSelectedItem() == null) {
            throw new NumberFormatException("Favourite Food Field is Empty, please check again.");
        }
        return (enums.FavouriteFood) favouriteFoodComboBox.getSelectedItem();
    }

    /**
     * set the evet listener for the submite button
     * @param listener
     */
    public void addSubmitButtonListener(ActionListener listener) {
        submitButton.addActionListener(listener);
    }
}
