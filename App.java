//  import java.awt.Frame;
// import java.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
public class App{

  
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setVisible(true);
         frame.setSize(800,600);
          JMenuBar mb = new JMenuBar();
           JMenu menu = new JMenu("Children");
         JMenuItem addchildren = new JMenuItem("Add children");
         JMenuItem updatechildren = new JMenuItem("Update children");
         JMenuItem deletechildren = new JMenuItem("Delete children");
         JMenuItem viewchildren = new JMenuItem("View Children");
         menu.add(addchildren);
         menu.add(updatechildren);
         menu.add(deletechildren);
         menu.add(viewchildren);
         mb.add(menu);

         frame.setJMenuBar(mb); 
                
             JMenu menu2 = new JMenu("Employee");
         JMenuItem addemployee = new JMenuItem("Add Employee");
         JMenuItem updateemployee = new JMenuItem("Update Employee");
         JMenuItem deleteemployee = new JMenuItem("Delete Employee");
         JMenuItem viewemployee = new JMenuItem("View Employee");

         menu2.add(addemployee);
         menu2.add(updateemployee);
         menu2.add(deleteemployee);
         menu2.add(viewemployee);
         mb.add(menu2);
         frame.setJMenuBar(mb); 

         addchildren.addActionListener(new ActionListener() {
          
            public void actionPerformed(ActionEvent e)
            {
                new Add();
            }
         });
         updatechildren.addActionListener(new ActionListener() {
          
            public void actionPerformed(ActionEvent e)
            {
                new update();
            }
         });
         deletechildren.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                new Delete();
            }
         });
         viewchildren.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                new View();
            }
         });




 addemployee.addActionListener(new ActionListener() {
          
            public void actionPerformed(ActionEvent e)
            {
                new Eadd();
            }
         });

         updateemployee.addActionListener(new ActionListener() {
          
            public void actionPerformed(ActionEvent e)
            {
                new Eupdate();
            }
         });
         deleteemployee.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                new Edelete();
            }
         });
         viewemployee.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                new Eview();
            }
         });

}
}


