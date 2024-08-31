
package electricity.billing.system;

/**
 *
 * @author saltu
 */

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import net.proteanit.sql.DbUtils;//this package is used for inser the value in the table
public class Customerdetails extends JFrame implements ActionListener{
   
    Choice meternumber,cmonth;
    JTable table;
    JButton search,print;
    Customerdetails(){
        
        super("Customer details");//title of page
        
        setSize(1250,700);
        setLocation(200,100);
        
         
       
        
         
        table = new JTable();
        
        try{
            
            Conn c=new Conn();
            ResultSet rs =c.s.executeQuery("select * from customer");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        JScrollPane sp = new JScrollPane(table);
        add(sp);
        
        
        
        
        print= new JButton("print");
        print.addActionListener(this);
        add(print,"South");
        
        
        
        
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
         
            try{
                table.print();//print command
                
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        
    
    
    
    public static void main(String args[]){
        new Customerdetails();
    }

}
