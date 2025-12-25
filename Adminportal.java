package assignment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Adminportal extends JFrame {

    public Adminportal() {
        // Set up the frame
        setTitle("Library Zone");
        setSize(600, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(206, 231, 242));

        // Top title bar ---Library Zone---
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel titleLabel = new JLabel("LIBRARY ZONE");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titleLabel.setForeground(Color.WHITE);
        titlePanel.setBackground(new Color(150, 44, 42));
        titlePanel.add(titleLabel);

        // Navbar
        JPanel navbar = new JPanel();
        navbar.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10)); // Spacing between the elements

        //  buttons
        JButton bookButton = new JButton("Books");
        JButton manageButton = new JButton("ManageBooks");
        JButton issuedButton = new JButton("IssuedDetails");
        JButton issueButton = new JButton("IssueBooks");
        

        // font and size for buttons
        Font navbarFont = new Font("Arial", Font.PLAIN, 14);
        bookButton.setFont(navbarFont);
        manageButton.setFont(navbarFont);
        issuedButton.setFont(navbarFont);
        issueButton.setFont(navbarFont);
        
        //colours for buttons 
        bookButton.setBackground(new Color(128, 61, 54));
        bookButton.setForeground(Color.WHITE);
        manageButton.setBackground(new Color(128, 61, 54));
        manageButton.setForeground(Color.WHITE);
        issueButton.setBackground(new Color(128, 61, 54));
        issueButton.setForeground(Color.WHITE);
        issuedButton.setBackground(new Color(128, 61, 54));
        issuedButton.setForeground(Color.WHITE);
        
           //ActionListener to adminLoginButton
        manageButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Open the Login frame
                new AdminaddB();
            }
        });
              //ActionListener to bookButton
        bookButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Open the Login frame
                new Bookdata();
            }
        });
        
                  //ActionListener to issueButton
        issueButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Open the Login frame
                new Issuebook();
            }
        });
        
                   //ActionListener to issuedButton
        issuedButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Open the Login frame
                new Issuedata();
            }
        });

        // Adding buttons to the navbar
        navbar.add(bookButton);
        navbar.add(manageButton);
        navbar.add(issuedButton);
        navbar.add(issueButton);
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
                new Adminportal();
}
}
