package assignment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
JLabel ULLabel,nameLabel,passLabel;
JTextField nameField,passField;
JButton loginButton;
    public Login() {
        // Set up the frame
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
        ULLabel = new JLabel("User Login");
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
        login.setSize(100, 100);
        login.setLayout(new GridBagLayout());
        
        GridBagConstraints gbc = new GridBagConstraints();
      
     
        gbc.insets = new Insets(10, 10, 10, 10); // Add padding
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        
        nameLabel = new JLabel("UserName:");
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 2;//2
        login.add(nameLabel, gbc);

   // Username field
        nameField = new JTextField(15);
        nameField.setFont(new Font("Arial", Font.PLAIN, 18)); 
        nameField.setPreferredSize(new Dimension(250, 40)); 
        gbc.gridx = 1;
        gbc.gridheight = 1; 
        gbc.gridy = 0;
        login.add(nameField, gbc);

        // Password label
        passLabel = new JLabel("Password:");
        passLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridheight = 2; 
        login.add(passLabel, gbc);

        // Password field
        passField = new JTextField(15);//JPasswordField(15)
        passField.setFont(new Font("Arial", Font.PLAIN, 18)); 
        passField.setPreferredSize(new Dimension(250, 40));
        gbc.gridx = 1;
        gbc.gridheight = 1; 
        gbc.gridy = 2;
        login.add(passField, gbc);

        // Login button
        loginButton = new JButton("Login");
        loginButton.setFont(new Font("Arial", Font.PLAIN, 18)); 
        loginButton.setPreferredSize(new Dimension(250, 50)); 
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.gridheight = 12; 
        loginButton.addActionListener(this);
        login.add(loginButton, gbc);
        gbc.anchor = GridBagConstraints.CENTER;
      

        login.setBackground(new Color(206, 231, 242));  

        // Add the login form to the frame
        add(login, BorderLayout.CENTER);

        // Make the frame visible
        setVisible(true);
    }
    
    
public void actionPerformed(ActionEvent ae){
Connection con;
Statement st;
ResultSet rs;
try{
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost/nitinpro","root","");
st=con.createStatement();
String username,password;
username=nameField.getText();
password=passField.getText();
if (ae.getSource() == loginButton) {
            rs = st.executeQuery("SELECT * FROM userdetails");

            boolean loginSuccess = false; 

            while (rs.next()) {
                if (username.equalsIgnoreCase(rs.getString("uname")) && password.equals(rs.getString("pass"))) {
                    loginSuccess = true;
                    break;
                }
            }

            if (loginSuccess) {
                JOptionPane.showMessageDialog(this, "Login Successful!");
                new User(); // Open the User portal
                dispose();  // Close the login frame
            } else {
                JOptionPane.showMessageDialog(this, "Incorrect username or password. Please try again.");
            }
        }

    } catch(Exception e){
        System.out.println(e);
        e.printStackTrace();
        }

}

    public static void main(String[] args) {
        new Login();
    }
}
