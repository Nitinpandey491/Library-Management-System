package assignment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Issuebook extends JFrame implements ActionListener {
    JLabel booknameLabel, utypeLabel, idnumLabel, fromLabel, toLabel;
    JTextField booknameField, utypeField, idnumField, fromField, toField;
    JButton issueButton, returnButton;

    public Issuebook() {
        // Set the frame
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
        navbar.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10)); // Spacing between elements
        JLabel ULLabel = new JLabel("Issue Books");
        Font navbarFont = new Font("Arial", Font.BOLD, 16);
        ULLabel.setFont(navbarFont);
        ULLabel.setForeground(Color.WHITE);
        navbar.setBackground(new Color(227, 134, 125));
        navbar.add(ULLabel);

        // Main panel combining title and navbar
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(titlePanel, BorderLayout.NORTH);
        mainPanel.add(navbar, BorderLayout.CENTER);

        // Add to frame
        add(mainPanel, BorderLayout.NORTH);

        // Login Form Panel
        JPanel login = new JPanel();
        login.setSize(500, 600);
        login.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Add padding
        gbc.fill = GridBagConstraints.HORIZONTAL;

        booknameLabel = new JLabel("BOOK NAME:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        login.add(booknameLabel, gbc);

        booknameField = new JTextField(15);
        gbc.gridx = 1;
        login.add(booknameField, gbc);

        utypeLabel = new JLabel("USER TYPE:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        login.add(utypeLabel, gbc);

        utypeField = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 1;
        login.add(utypeField, gbc);

        idnumLabel = new JLabel("ID NUMBER:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        login.add(idnumLabel, gbc);

        idnumField = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 2;
        login.add(idnumField, gbc);

        fromLabel = new JLabel("FROM:");
        gbc.gridx = 0;
        gbc.gridy = 3;
        login.add(fromLabel, gbc);

        fromField = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 3;
        login.add(fromField, gbc);
        
        toLabel = new JLabel("TO:");
        gbc.gridx = 0;
        gbc.gridy = 4;
        login.add(toLabel, gbc);

        toField = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 4;
        login.add(toField, gbc);

        issueButton = new JButton("ISSUE");
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        login.add(issueButton, gbc);

        returnButton = new JButton("RETURNED");
        gbc.gridx = 1;
        login.add(returnButton, gbc);

        login.setBackground(new Color(206, 231, 242)); 
        issueButton.addActionListener(this);
        returnButton.addActionListener(this);
        // Add the login form to the frame
        add(login, BorderLayout.CENTER);

        // Make the frame visible
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        Connection con;
        Statement st;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/nitinpro", "root", "");
            st = con.createStatement();
            String name = "", type = "", id = "", from="", to="";
            name = booknameField.getText();
            type = utypeField.getText();
            id = idnumField.getText();
            from = fromField.getText();
            to = toField.getText();

            if (ae.getSource() == issueButton) {
                if (name.isEmpty() || type.isEmpty() || id.isEmpty() || from.isEmpty() || to.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please fill all fields!");
                    return;
                }
                st.executeUpdate("INSERT INTO issue VALUES('" + name + "','" + type + "','" + id + "','" + from + "','" + to + "')");
                System.out.println("Record Inserted");
                booknameField.setText("");
                utypeField.setText("");
                idnumField.setText("");
                fromField.setText("");
                toField.setText("");
            } else if (ae.getSource() == returnButton) {
                // Delete functionality
                if (id.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please provide the ID NUMBER to return!");
                    return;
                }
                int rowsDeleted = st.executeUpdate("DELETE FROM issue WHERE id='" + id + "'");
                if (rowsDeleted > 0) {
                    System.out.println("Record Deleted");
                    JOptionPane.showMessageDialog(this, "Book Returned");
                } else {
                    JOptionPane.showMessageDialog(this, "No record found with the given ID NUMBER");
                }
                booknameField.setText("");
                utypeField.setText("");
                idnumField.setText("");
                fromField.setText("");
                toField.setText("");
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Issuebook();
    }
}
