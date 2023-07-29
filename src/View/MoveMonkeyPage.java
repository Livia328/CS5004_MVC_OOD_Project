package View;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 A class representing a JFrame for moving a monkey to an enclosure.
 */
public class MoveMonkeyPage extends JFrame{
    private JLabel titleLabel, idLabel;
    private JTextField idField;
    private JButton submitButton;

    /**
     Constructs a MoveMonkeyPage JFrame with a title, input field for monkey ID, and a submit button.

     Sets the size, close operation, and panel with the components as the content pane of the JFrame.
     */
    public MoveMonkeyPage() {
        // set the title of the window
        setTitle("Move Monkey To Enclosure");

        // set the size of the window
        setSize(400, 300);

        // set the close operation to exit the program when the window is closed
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        //create labels
        titleLabel = new JLabel("Which monkey you want to move?");
        idLabel = new JLabel("ID:");

        // create name input field
        idField = new JTextField(20);

        // create the submit button
        submitButton = new JButton("Submit");

        // create the panel and add the components to it
        JPanel panel = new JPanel();
        panel.add(titleLabel);
        panel.add(idLabel);
        panel.add(idField);
        panel.add(submitButton);

        // set the panel as the content pane of the JFrame
        setContentPane(panel);

    }

    /**
     Resets the monkey ID input field to an empty string.
     */
    public void resetTextArea() {
        idField.setText("");
    }

    /**
     Returns the ID of the monkey entered in the ID input field.
     Throws NumberFormatException if the ID field is empty.
     @return A string representing the ID of the monkey.
     */
    public String getID() {
        if (idField.getText() == null) {
            throw new NumberFormatException("Id Field is Empty, please check again.");
        }
        return idField.getText();
    }

    /**
     Adds an ActionListener to the submit button.
     @param listener The ActionListener to be added.
     */
    public void addSubmitButtonListener(ActionListener listener) {
        submitButton.addActionListener(listener);
    }
}
