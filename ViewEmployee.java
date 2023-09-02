import java.awt.*;
import java.awt.event.*;
//import java.awt.ActionListener.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

 class Eview extends JFrame  {
    JButton view;

    Eview() {
        view = new JButton("View");
        view.setBounds(100, 50, 300, 30);
        this.add(view);
        setSize(900, 900);
        setVisible(true);
        setTitle("View Employee");
        setLocation(300, 30);
   
            String url = "jdbc:mysql://localhost:3306/ngomanagement";
            String username = "root";
            String password = "";

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection connection = DriverManager.getConnection(url, username, password);
                String query = "SELECT * FROM employee";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                ResultSet resultSet = preparedStatement.executeQuery();
                DefaultTableModel tableModel = new DefaultTableModel();
                tableModel.addColumn("ID");
                tableModel.addColumn("Name");
                tableModel.addColumn("Age");
                tableModel.addColumn("Email");
                

                while (resultSet.next()) {
                    String ID = resultSet.getString("ID");
                    String Name = resultSet.getString("Name");
                    String Age = resultSet.getString("Age");
                    String Email = resultSet.getString("Email");
                
                    tableModel.addRow(new Object[]{ID, Name, Age, Email});
                }

                JTable bookTable = new JTable(tableModel);
                JScrollPane scrollPane = new JScrollPane(bookTable);
                getContentPane().removeAll();
                getContentPane().add(scrollPane);
                revalidate();
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (Exception obj) {
                obj.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error: Unable to retrieve book information.");
            }
        }
    }

 

