package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**

 A class representing the Vaccination Page for the Monkey Management System.

 This page allows the user to enter the ID of the monkey to be vaccinated.

 The user can submit the ID and the corresponding monkey will be vaccinated.
 */
public class VaccinationPage extends JFrame{
    private JLabel titleLabel, idLabel;
    private JTextField idField;
    private JButton submitButton;

    /**

     Constructs a new VaccinationPage object.

     Initializes the window properties such as title, size and close operation.

     Initializes the UI components such as labels, text fields and buttons.

     Adds the components to a panel and sets it as the content pane of the JFrame.
     */
    public VaccinationPage() {
        // set the title of the window
        setTitle("Vaccinate Monkey");

        // set the size of the window
        setSize(400, 300);

        // set the close operation to exit the program when the window is closed
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        //create labels
        titleLabel = new JLabel("Which monkey you want to vaccinate?");
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
     Resets the text field for entering the monkey ID to an empty state.
     */
    public void resetTextArea() {
        idField.setText("");
    }

    /**
     Returns the ID entered by the user as a String.
     If the ID field is empty, throws a NumberFormatException with an error message.
     @return The ID entered by the user as a String.
     @throws NumberFormatException if the ID field is empty.
     */
    public String getID() {
        if (idField.getText() == null) {
            throw new NumberFormatException("Name Field is Empty, please check again.");
        }
        return idField.getText();
    }

    /**
     Adds an ActionListener to the submit button.
     The ActionListener is notified when the user clicks the submit button.
     @param listener The ActionListener to be added to the submit button.
     */
    public void addSubmitButtonListener(ActionListener listener) {
        submitButton.addActionListener(listener);
    }
}
