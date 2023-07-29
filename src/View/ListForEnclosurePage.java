package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 A JFrame class that displays a form to get the monkey species to be checked for a single enclosure.
 */
public class ListForEnclosurePage extends JFrame{
    private JLabel titleLabel, speciesLabel;
    private JComboBox<enums.MonkeySpecies> speciesComboBox;
    private JButton submitButton;

    /**
     Constructor of ListForEnclosurePage.
     Sets the title, size and close operation of the JFrame window.
     Initializes titleLabel, speciesComboBox, speciesLabel and submitButton.
     Constructs a panel with a vertical BoxLayout and adds the labels, combobox and submit button to the panel.
     Sets the panel as the content pane of the JFrame.
     */
    public ListForEnclosurePage() {
        // set the title of the window
        setTitle("Get Monkeys hosted in One Enclosure");

        // set the size of the window
        setSize(400, 300);

        // set the close operation to exit the program when the window is closed
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        // create the labels
        titleLabel = new JLabel("Which Species do you want to check?");

        speciesComboBox = new JComboBox<>(enums.MonkeySpecies.values());
        speciesComboBox.setSelectedIndex(0);

        // create the submit button
        submitButton = new JButton("Submit");

        JPanel panel = new JPanel();
        BoxLayout layout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.add(titleLabel);
        panel.add(speciesComboBox);
        panel.add(submitButton);

        // set the panel as the content pane of the JFrame
        setContentPane(panel);

    }

    /**
     Returns the selected monkey species from the speciesComboBox.
     Throws a NumberFormatException if the selected item in the speciesComboBox is null.
     @return the selected monkey species.
     @throws NumberFormatException if the selected item in the speciesComboBox is null.
     */
    public enums.MonkeySpecies getSpecies() {
        if (speciesComboBox.getSelectedItem() == null) {
            throw new NumberFormatException("Species Field is Empty, please check again.");
        }
        return (enums.MonkeySpecies) speciesComboBox.getSelectedItem();
    }

    /**
     Adds an ActionListener to the submitButton.
     @param listener the ActionListener to be added to the submitButton.
     */
    public void addSubmitButtonListener(ActionListener listener) {
        submitButton.addActionListener(listener);
    }
}
