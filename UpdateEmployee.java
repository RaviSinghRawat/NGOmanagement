import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

class Eupdate extends JFrame
{
    JLabel idlabel, namelabel, agelable, emaillable;
    JTextField idtextfield, nametextfield, agetextfield, emailtextfield;
    JButton updatebutton,searchbutton;


Eupdate()
{
    setTitle("Update Employee");
    setVisible(true);
    setSize(800, 600);
    //GridLayout grid = new GridLayout(5,2);
    this.setLayout(null);
    
    idlabel = new JLabel("ID : ");
    idlabel.setBounds(50,50,40,30);

    namelabel = new JLabel("Name : ");
    namelabel.setBounds(50,100,50,30);
    
    agelable = new JLabel("Age : ");
    agelable.setBounds(50,150,40,30);

    emaillable = new JLabel("Email");
    emaillable.setBounds(50,210,40,30);

    idtextfield = new JTextField();
    idtextfield.setBounds(150,50,100,30);

    nametextfield = new JTextField();
    nametextfield.setBounds(150,100,100,30);
    
    agetextfield = new JTextField();
    agetextfield.setBounds(150, 150, 100, 30);
    emailtextfield = new JTextField();
    emailtextfield.setBounds(150, 210, 100, 30);
    
    searchbutton = new JButton(" search ");
    searchbutton.setBounds(120, 270, 80, 30);
    setBackground(Color.BLUE);

    updatebutton = new JButton(" Update ");
    updatebutton.setBounds(200, 270, 80, 30);
    setBackground(Color.BLUE);

    

    this.add(idlabel);
    this.add(idtextfield);

    this.add(namelabel);
    this.add(nametextfield);

    
    this.add(agelable);
    this.add(agetextfield);

    this.add(emaillable);
    this.add(emailtextfield);
    
    this.add(searchbutton);
    this.add(updatebutton);


updatebutton.addActionListener(new ActionListener(){
           @Override
          public void actionPerformed(ActionEvent e) {
            String DB_URL = "jdbc:mysql://localhost:3306/ngomanagement";
            String USER = "root";
            String PASS = "";
            try {
             
    Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement statement = connection.createStatement();
            String query = "UPDATE employee SET Name=?, Age=?, Email=? WHERE ID=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, nametextfield.getText());
            preparedStatement.setString(2, agetextfield.getText());
            preparedStatement.setString(3, emailtextfield.getText());
            preparedStatement.setString(4, idtextfield.getText());
            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                  JOptionPane.showMessageDialog(null,"updated successfully");
             } else {
                  JOptionPane.showMessageDialog(null,"not updated successfully");
             }
                  preparedStatement.close();
            connection.close();
       } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
              //Handle database errors and display an error message
          JOptionPane.showMessageDialog(null, "Error: Unable to update the Pessanger.");
           }
      }
  });
  
  searchbutton.addActionListener(new ActionListener() {
       @Override
      public void actionPerformed(ActionEvent e) {
        String DB_URL = "jdbc:mysql://localhost:3306/ngomanagement";
        String USER = "root";
        String PASS = "";
        try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(DB_URL , USER, PASS);
        String query = "SELECT * FROM employee WHERE ID=?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, idtextfield.getText());
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
          idtextfield.setText(resultSet.getString("ID"));
          nametextfield.setText(resultSet.getString("Name"));
          agetextfield.setText(resultSet.getString("Age"));
          emailtextfield.setText(resultSet.getString("Email"));
     } else {
          JOptionPane.showMessageDialog(null, "children not found.");
     }
    resultSet.close();
    preparedStatement.close();
    connection.close();
   } catch (ClassNotFoundException | SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error: Unable to rearch children");
   }
    }
  });
}
}
     
