package se.kth.id1212.gui.swing;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * This panel collects data from a user that registers.
 */
public class RegisterPanel extends JPanel {
    private JTextField nameField = new JTextField(10);
    private JTextField phoneField = new JTextField(10);;
    public RegisterPanel() {
        setLayout(new FlowLayout());
        constructComponents();
    }

    private void constructComponents() {
        add(new JLabel("Name:"));
        add(nameField);
        add(new JLabel("Phone:"));
        add(phoneField);
        JButton okButton = new JButton("OK");
        add(okButton);
        okButton.addActionListener((ActionEvent e) -> {
            System.out.println("name: " + nameField.getText() + ", phone: " + phoneField.getText());
        });
    }
}
