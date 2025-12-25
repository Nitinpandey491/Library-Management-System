package assignment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Assignment extends JFrame {

    public Assignment() {
        // Setting the frame
        setTitle("Library Zone");
        setSize(600, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(206, 231, 242));

        //title---Library Zone---
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel titleLabel = new JLabel("LIBRARY ZONE");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titleLabel.setForeground(Color.WHITE);
        titlePanel.setBackground(new Color(150, 44, 42));
        titlePanel.add(titleLabel);

        //Navbar
        JPanel navbar = new JPanel();
        navbar.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10)); // Spacing between elements

        //buttons
        JButton registerButton = new JButton("Register");
        JButton loginButton = new JButton("Login");
        JButton adminLoginButton = new JButton("Admin Login");

        //font and size for buttons
        Font navbarFont = new Font("Arial", Font.PLAIN, 14);
        registerButton.setFont(navbarFont);
        loginButton.setFont(navbarFont);
        adminLoginButton.setFont(navbarFont);
        
        //colours for buttons 
        registerButton.setBackground(new Color(128, 61, 54));
        registerButton.setForeground(Color.WHITE);
        loginButton.setBackground(new Color(128, 61, 54));
        loginButton.setForeground(Color.WHITE);
        adminLoginButton.setBackground(new Color(128, 61, 54));
        adminLoginButton.setForeground(Color.WHITE);
        
        //ActionListener to loginButton
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Open the Login frame
                new Login();
            }
        });
        
           //ActionListener to adminLoginButton
        adminLoginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Open the Login frame
                new Admin();
            }
        });
        
             //ActionListener to adminLoginButton
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Open the Register frame
                new Register();
            }
        });

        // Adding buttons to the navbar
        navbar.add(registerButton);
        navbar.add(loginButton);
        navbar.add(adminLoginButton);
        navbar.setBackground(new Color(227, 134, 125));

        // Main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(titlePanel, BorderLayout.NORTH);
        mainPanel.add(navbar, BorderLayout.CENTER);

        // Add to frame
        add(mainPanel, BorderLayout.NORTH);

        // Making the frame visible
        setVisible(true);
    }

    public static void main(String[] args) {
                new Assignment();
}
}
