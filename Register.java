package assignment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class Register extends JFrame implements ActionListener {
    JLabel nameLabel,usernameLabel,passwordLabel,typeLabel,emailLabel,idLabel,deptLabel;
    JTextField nameField,usernameField,passwordField,typeField,emailField,idField,deptField;  
    JButton regButton;
     
    public Register() {
        // Set the frame
        setTitle("Library Zone");
        setSize(600, 300);
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
        navbar.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10)); // Spacing between elements
        JLabel ULLabel = new JLabel("Register");
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

        nameLabel = new JLabel("NAME:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 2;
        login.add(nameLabel, gbc);

        nameField = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridheight = 1;
        gbc.gridy = 0;
        login.add(nameField, gbc);

        usernameLabel = new JLabel("USERNAME:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridheight = 2;
        login.add(usernameLabel, gbc);

        usernameField = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridheight = 1;
        gbc.gridy = 2;
        login.add(usernameField, gbc);

        passwordLabel = new JLabel("PASSWORD:");
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridheight = 2;
        login.add(passwordLabel, gbc);

        passwordField = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridheight = 1;
        gbc.gridy = 4;
        login.add(passwordField, gbc);

        typeLabel = new JLabel("TYPE:");
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridheight = 2;
        login.add(typeLabel, gbc);
        
        typeField = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridheight = 1;
        gbc.gridy = 6;
        login.add(typeField, gbc);

        emailLabel = new JLabel("Email ID:");
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridheight = 2;
        login.add(emailLabel, gbc);

        emailField = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridheight = 1;
        gbc.gridy = 8;
        login.add(emailField, gbc);

        idLabel = new JLabel("ID NUMBER:");
        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.gridheight = 2;
        login.add(idLabel, gbc);

        idField = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridheight = 1;
        gbc.gridy = 10;
        login.add(idField, gbc);

        deptLabel = new JLabel("DEPARTMENT:");
        gbc.gridx = 0;
        gbc.gridy = 12;
        gbc.gridheight = 2;
        login.add(deptLabel, gbc);

        deptField = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridheight = 1;
        gbc.gridy = 12;
        login.add(deptField, gbc);

        regButton = new JButton("Register");
        gbc.gridx = 0;
        gbc.gridy = 14;
        gbc.gridwidth = 2;
        gbc.gridheight = 2;
        login.add(regButton, gbc);
        gbc.anchor = GridBagConstraints.CENTER;

        login.setBackground(new Color(206, 231, 242));  
        regButton.addActionListener(this);
        // Add the login form to the frame
        add(login, BorderLayout.CENTER);

        // Make the frame visible
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        Connection con;
        Statement st;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost/nitinpro","root","");
            st=con.createStatement();
            String name="",uname="",pass="",type="",email="",id="",dept="";
            name = nameField.getText();
            uname = usernameField.getText();
            pass = passwordField.getText();
            type = typeField.getText();
            email = emailField.getText();
            id = idField.getText();
            dept = deptField.getText();
  
            if(ae.getSource ()==regButton){
                 if (name.isEmpty() || uname.isEmpty() || pass.isEmpty() || email.isEmpty() || 
                id.isEmpty() || dept.isEmpty() || type.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill all fields!");
                return;
            }
            else{
                 JOptionPane.showMessageDialog(this, "Registration Complete!");
                 }
                st.executeUpdate("insert into userdetails values('"+name+"','"+uname+"','"+pass+"','"+type+"','"+email+"','"+id+"','"+dept+"')");
                System.out.println("Record Inserted");
            nameField.setText("");
            usernameField.setText("");
            passwordField.setText("");
            typeField.setText("");
            emailField.setText("");
            idField.setText("");
            deptField.setText("");
            }
        }
        catch(Exception e){
            System.out.println(e);
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Register();
    }
}
