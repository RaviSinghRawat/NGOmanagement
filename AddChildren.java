import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.*;
//import java.awt.event.*;

class Add extends JFrame
{
    JLabel namelabel, agelable, emaillable;
    JTextField nametextfield, agetextfield, emailtextfield;
    JButton submitbutton;


Add()
{
    JFrame frame =new JFrame("Add Children");
    frame.setVisible(true);
    frame.setSize(800, 600);
    //GridLayout grid = new GridLayout(5,2);
    frame.setLayout(null);
    
  
    namelabel = new JLabel("Name : ");
    namelabel.setBounds(50,100,50,30);
    agelable = new JLabel("Age : ");
    agelable.setBounds(50,150,40,30);
    emaillable = new JLabel("Email");
    emaillable.setBounds(50,210,40,30);


    nametextfield = new JTextField();
    nametextfield.setBounds(150,100,100,30);
    agetextfield = new JTextField();
    agetextfield.setBounds(150, 150, 100, 30);
    emailtextfield = new JTextField();
    emailtextfield.setBounds(150, 210, 100, 30);

    submitbutton = new JButton(" Done ");
    submitbutton.setBounds(200, 270, 80, 30);
    setBackground(Color.BLUE);


    frame.add(namelabel);
    frame.add(nametextfield);

    frame.add(agelable);
    frame.add(agetextfield);

    frame.add(emaillable);
    frame.add(emailtextfield);
    
    frame.add(submitbutton);

    submitbutton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e)
        {

            String url = "jdbc:mysql://localhost:3306/ngomanagement";
            String username = "root";
            String password = "";

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection connection = DriverManager.getConnection(url, username, password);

           java.sql.Statement statement =  connection.createStatement();

                String query1 = "insert into `ngomanagement`.`children`"
                 + "(`Name`, `Age`, `Email`)"
                 + "values('" + nametextfield.getText() + "','"
                 + agetextfield.getText() + "','"+ emailtextfield.getText()+"')";
     
       int i =  statement.executeUpdate(query1);
       if (i > 0) {
        System.out.println("ROW INSERTED");
        JOptionPane.showMessageDialog(frame, "Childern Added Successfully......");
        frame.dispose();
       } else {
        System.out.println("ROW NOT INSERTED");
       }
       connection.close();
      } catch (ClassNotFoundException c) {
       System.out.println(c);
      } catch (SQLException SQLException) {
       System.out.println(SQLException.getMessage());
      }
     }
    });
    }
}
