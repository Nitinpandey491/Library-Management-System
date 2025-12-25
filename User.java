package assignment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class User extends JFrame {

    public User() {
        // Set up the frame
        setTitle("Library Zone");
        setSize(600, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(206, 231, 242));

        // title---Library Zone---
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel titleLabel = new JLabel("LIBRARY ZONE");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titleLabel.setForeground(Color.WHITE);
        titlePanel.setBackground(new Color(150, 44, 42));
        titlePanel.add(titleLabel);

        // Navbar
        JPanel navbar = new JPanel();
        navbar.setLayout(new FlowLayout(FlowLayout.CENTER,  600, 10)); 

        // buttons
        JButton BookButton = new JButton("Books");
        JButton LogOutButton = new JButton("Log Out");

        // font and size for buttons
        Font navbarFont = new Font("Arial", Font.PLAIN, 14);
        BookButton.setFont(navbarFont);
        LogOutButton.setFont(navbarFont);
        
        //colours for buttons 
        BookButton.setBackground(new Color(128, 61, 54));
        BookButton.setForeground(Color.WHITE);
        LogOutButton.setBackground(new Color(128, 61, 54));
        LogOutButton.setForeground(Color.WHITE);
        
                //ActionListener to bookButton
        BookButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Open the Login frame
                new Bookdata();
            }
        });
        LogOutButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        // close the current frame
        dispose();
        
    }
        });
        
        // Add buttons to the navbar
        navbar.add(BookButton);
        navbar.add(LogOutButton);
        navbar.setBackground(new Color(227, 134, 125));

        // Main panel combining title and navbar
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(titlePanel, BorderLayout.NORTH);
        mainPanel.add(navbar, BorderLayout.CENTER);

        // Add to frame
        add(mainPanel, BorderLayout.NORTH);

        // Make the frame visible
        setVisible(true);
    }

    public static void main(String[] args) {
                new User();
}
}
