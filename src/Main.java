/*
* Author: Atharv Kulkarni
* Date: 29-03-2023
* Name: Java Base64 Password Generator
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;

public class Main extends JFrame implements ActionListener {

    private JTextField inputField;
    private JButton submitButton;
    private JTextField outputField;
    private JComboBox<String> comboBox;

    public Main() {
        // Set up the JFrame
        setTitle("Base64 Password Generator");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set up the input field
        inputField = new JTextField(20);

        // Set up the submit button
        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);

        // Set up the combo box
        JLabel comboLabel = new JLabel("Include special characters?");
        comboBox = new JComboBox<>(new String[] {"YES", "NO"});

//        JPanel panel = new JPanel();
//        panel.add(comboLabel);
//        panel.add(comboBox);

        // Set up the output field
        outputField = new JTextField(20);
        outputField.setEditable(false);

        // Add components to the JFrame
        setLayout(new FlowLayout());
        add(inputField);
        add(submitButton);
        add(comboLabel);
        add(comboBox);
        add(outputField);

        // Display the JFrame
        setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            // Get the input from the text field
            String inputString = inputField.getText();

            // Parse the input as an integer
            int inputInt = Integer.parseInt(inputString);

            // Get the selected item from the combo box
            String selectedItem = (String) comboBox.getSelectedItem();

            // Process the input and generate output
            String output;
            try {
                output = Pass.generatePassword(inputInt, selectedItem.equals("YES"));
            } catch (NoSuchAlgorithmException ex) {
                throw new RuntimeException(ex);
            }

            // Set the output field to display the result
            outputField.setText(output);
        }
    }
}
