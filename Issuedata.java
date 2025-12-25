package assignment;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class Issuedata extends JFrame {

    public Issuedata() {
        // Set the frame
        setTitle("Library Zone");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
      
        // panel for the table
        JPanel dataPanel = new JPanel();
        dataPanel.setLayout(new BorderLayout());

        // Fetch and display data in a Table
        JTable table = fetchIssueData();
        if (table != null) {
            JScrollPane sp = new JScrollPane(table);
            dataPanel.add(sp, BorderLayout.CENTER);
        } else {
            JLabel errorLabel = new JLabel("Failed to fetch data from database.");
            errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
            dataPanel.add(errorLabel, BorderLayout.CENTER);
        }

        add(dataPanel, BorderLayout.CENTER);
        setVisible(true);
    }

     JTable fetchIssueData() {
        // Database connection 
        String url = "jdbc:mysql://localhost:3306/nitinpro";
        String user = "root";
        String password = "";

        try (Connection con = DriverManager.getConnection(url, user, password);
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM issue")) {

           // Get metadata about the result set
           ResultSetMetaData metaData = rs.getMetaData();
           int columnCount = metaData.getColumnCount(); // Number of columns

           // Get column names
           String[] columnNames = new String[columnCount];
           for (int i = 1; i <= columnCount; i++) {
            columnNames[i - 1] = metaData.getColumnName(i); // Store column names
           }

           // Get the total number of rows
           rs.last(); // Move to the last row
           int rowCount = rs.getRow(); // Get the total row count
            rs.beforeFirst(); // Move back to the start

            // Prepare a 2D array to hold data
            String[][] data = new String[rowCount][columnCount];
            int rowIndex = 0; // Row index for the data array

            // Loop through each row in the result set
            while (rs.next()) {
            for (int i = 1; i <= columnCount; i++) {
            data[rowIndex][i - 1] = rs.getString(i); // Get each column value
            }
                rowIndex++; // Move to the next row
            }

            // Create and return a Table with the data and column names
            return new JTable(data, columnNames);


        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        new Issuedata();
    }
}

