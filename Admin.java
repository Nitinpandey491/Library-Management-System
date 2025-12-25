package assignment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Admin extends JFrame implements ActionListener {
    JLabel nameLabel, passLabel;
    JTextField nameField, passField;
    JButton loginButton;

    public Admin() {
        // Set up the frame
        setTitle("Library Zone");
        setSize(600, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
        navbar.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        JLabel ALLabel = new JLabel("Admin Login");
        Font navbarFont = new Font("Arial", Font.BOLD, 16);
        ALLabel.setFont(navbarFont);
        ALLabel.setForeground(Color.WHITE);
        navbar.setBackground(new Color(227, 134, 125));
        navbar.add(ALLabel);

        // Main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(titlePanel, BorderLayout.NORTH);
        mainPanel.add(navbar, BorderLayout.CENTER);

        // Add to frame
        add(mainPanel, BorderLayout.NORTH);

        // Login Form Panel
        JPanel login = new JPanel();
        login.setSize(100, 100);
        login.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        nameLabel = new JLabel("Admin:");
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        gbc.gridx = 0;
        gbc.gridy = 0;
        login.add(nameLabel, gbc);

        nameField = new JTextField(15);
        nameField.setFont(new Font("Arial", Font.PLAIN, 18));
        nameField.setPreferredSize(new Dimension(250, 40));
        gbc.gridx = 1;
        gbc.gridy = 0;
        login.add(nameField, gbc);

        passLabel = new JLabel("Password:");
        passLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        gbc.gridx = 0;
        gbc.gridy = 1;
        login.add(passLabel, gbc);

        passField = new JTextField(15);
        passField.setFont(new Font("Arial", Font.PLAIN, 18));
        passField.setPreferredSize(new Dimension(250, 40));
        gbc.gridx = 1;
        gbc.gridy = 1;
        login.add(passField, gbc);

        loginButton = new JButton("Login");
        loginButton.setFont(new Font("Arial", Font.PLAIN, 18));
        loginButton.setPreferredSize(new Dimension(250, 50));
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        login.add(loginButton, gbc);

        login.setBackground(new Color(206, 231, 242));
        add(login, BorderLayout.CENTER);

        // Add ActionListener to the loginButton
        loginButton.addActionListener(this);

        // Making the frame visible
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == loginButton) {
            Connection con;
            Statement st;
            try {
                // Load the database driver
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost/nitinpro", "root", "");
                st = con.createStatement();

                String username = nameField.getText();
                String password = passField.getText();

                ResultSet rs = st.executeQuery("SELECT * FROM admin");

                boolean loginSuccess = false;

                while (rs.next()) {
                    if (username.equals(rs.getString("adminname")) && password.equals(rs.getString("pass"))) {
                        loginSuccess = true;
                        break;
                    }
                }

                if (loginSuccess) {
                    JOptionPane.showMessageDialog(this, "Login Successful!");
                    new Adminportal(); // Open Admin Portal
                    dispose(); 
                } else {
                    JOptionPane.showMessageDialog(this, "Incorrect username or password. Please try again.");
                }
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error connecting to database. Please check your configuration.");
            }
        }
    }

    public static void main(String[] args) {
        new Admin();
    }
}
