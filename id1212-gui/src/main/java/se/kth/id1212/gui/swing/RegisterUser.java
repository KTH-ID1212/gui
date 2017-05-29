package se.kth.id1212.gui.swing;

import javax.swing.JFrame;

/**
 * This class contains the main method that starts the application. This very simple
 * application creates a gui where some user data can be entered.
 */
public class RegisterUser {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Enter User Data");
        frame.setContentPane(new RegisterPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
