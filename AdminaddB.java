package assignment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AdminaddB extends JFrame implements ActionListener {
    JLabel titleLabel, authorLabel, categoryLabel, isbnLabel;
    JTextField titleField, authorField, categoryField, isbnField;
    JButton addButton, deleteButton;

    public AdminaddB() {
        // Set the frame
        setTitle("Library Zone");
        setSize(600, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(206, 231, 242));

        // Top title bar ---Library Zone---
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        titleLabel = new JLabel("LIBRARY ZONE");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titleLabel.setForeground(Color.WHITE);
        titlePanel.setBackground(new Color(150, 44, 42));
        titlePanel.add(titleLabel);

        // Navbar
        JPanel navbar = new JPanel();
        navbar.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10)); // Spacing between elements
        JLabel ULLabel = new JLabel("Add Books");
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

        titleLabel = new JLabel("BOOK TITLE:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        login.add(titleLabel, gbc);

        titleField = new JTextField(15);
        gbc.gridx = 1;
        login.add(titleField, gbc);

        authorLabel = new JLabel("BOOK AUTHOR:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        login.add(authorLabel, gbc);

        authorField = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 1;
        login.add(authorField, gbc);

        categoryLabel = new JLabel("CATEGORY:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        login.add(categoryLabel, gbc);

        categoryField = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 2;
        login.add(categoryField, gbc);

        isbnLabel = new JLabel("BOOK ISBN:");
        gbc.gridx = 0;
        gbc.gridy = 3;
        login.add(isbnLabel, gbc);

        isbnField = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 3;
        login.add(isbnField, gbc);

        addButton = new JButton("Add");
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        login.add(addButton, gbc);

        deleteButton = new JButton("Delete");
        gbc.gridx = 1;
        login.add(deleteButton, gbc);

        login.setBackground(new Color(206, 231, 242)); 
        addButton.addActionListener(this);
        deleteButton.addActionListener(this);
        // Add the login form to the frame
        add(login, BorderLayout.CENTER);

        // Making the frame visible
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        Connection con;
        Statement st;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/nitinpro", "root", "");
            st = con.createStatement();
            String title = "", author = "", category = "", isbn = "";
            title = titleField.getText();
            author = authorField.getText();
            category = categoryField.getText();
            isbn = isbnField.getText();

            if (ae.getSource() == addButton) {
                if (title.isEmpty() || author.isEmpty() || category.isEmpty() || isbn.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please fill all fields!");
                    return;
                }
                st.executeUpdate("INSERT INTO books VALUES('" + title + "','" + author + "','" + category + "','" + isbn + "')");
                System.out.println("Record Inserted");
                titleField.setText("");
                authorField.setText("");
                categoryField.setText("");
                isbnField.setText("");
            } else if (ae.getSource() == deleteButton) {
                // Delete functionality
                if (title.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please provide the BOOK TITLE to delete!");
                    return;
                }
                int rowsDeleted = st.executeUpdate("DELETE FROM books WHERE title='" + title + "'");
                if (rowsDeleted > 0) {
                    System.out.println("Record Deleted");
                    JOptionPane.showMessageDialog(this, "Record Deleted Successfully");
                } else {
                    JOptionPane.showMessageDialog(this, "No record found with the given BOOK TITLE");
                }
                titleField.setText("");
                authorField.setText("");
                categoryField.setText("");
                isbnField.setText("");
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new AdminaddB();
    }
}
