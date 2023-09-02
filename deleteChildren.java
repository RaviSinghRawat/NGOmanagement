import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;


class Delete extends JFrame 
{
    JLabel idlabel;
    JTextField idtextfield;
    JButton deletebutton, cancelButton; // Renamed canclebutton to cancelButton

    Delete()
    {
        setTitle("Delete Children");
        setVisible(true);
        setSize(800, 600);

        setLayout(null); // Removed redundant 'this'

        idlabel = new JLabel("ID : ");
        idlabel.setBounds(50, 50, 40, 30);
       
        idtextfield = new JTextField();
        idtextfield.setBounds(150, 50, 100, 30);
        
        deletebutton = new JButton("Delete");
        deletebutton.setBounds(200, 200, 80, 30);
        cancelButton = new JButton("Cancel"); // Renamed canclebutton to cancelButton
        cancelButton.setBounds(100, 200, 80, 30);

        add(idlabel);
        add(idtextfield);

        add(cancelButton); // Added cancelButton to the frame
        add(deletebutton);
        
        deletebutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
            String url = "jdbc:mysql://localhost:3306/ngomanagement";
            String username = "root";
            String password = "";
            String ID =String.valueOf(idtextfield.getText());
                try {
                Connection connection = DriverManager.getConnection(url, username, password);
                    String sql = "DELETE FROM children WHERE ID = ?";
                    PreparedStatement preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.setString(1,ID);
                    int rowsDeleted = preparedStatement.executeUpdate();
                    
                    if (rowsDeleted > 0) {
                        JOptionPane.showMessageDialog(null, "Record deleted successfully.");
                    } else {
                        JOptionPane.showMessageDialog(null, "No record deleted.");
                    }
                    
                    connection.close();
                } catch (SQLException s) { // Catch SQLException for database-related exceptions
                    s.printStackTrace();
                        JOptionPane.showMessageDialog(null, ID);
                    System.out.println("Deletion unsuccessful");
                }
            }
        });
        
        cancelButton.addActionListener(event -> {
            dispose();
        });
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Delete();
        });
    }
}
