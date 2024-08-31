
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
public class Depositedetails extends JFrame implements ActionListener{
   
    Choice meternumber,cmonth;
    JTable table;
    JButton search,print;
    Depositedetails(){
        
        super("Depeosite details");//title of page
         setSize(700,500);
        setLocation(400,200);
         setLayout(null);
         
        JLabel lblmeternumber =new JLabel("Serach by M_no");
        lblmeternumber.setBounds(20,20,150,20);
        add(lblmeternumber);
        
        meternumber=new Choice();
        meternumber.setBounds(180,20,150,20);
        add(meternumber);
        try{
            
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from customer");
            while(rs.next()){
                meternumber.add(rs.getString("meter_no"));
            }
            
            
        }catch(Exception e){
        e.printStackTrace();
        
        }
        
       JLabel lblmonth =new JLabel("Search by Month");
        lblmonth.setBounds(400,20,150,20);
        add(lblmonth);
        
        cmonth=new Choice();
       cmonth.setBounds(600,20,150,20);
       
      
       cmonth.add("january");
       cmonth.add("february");
       cmonth.add("march");
       cmonth.add("april");
       cmonth.add("may");
       cmonth.add("june");
       cmonth.add("july");
       cmonth.add("august");
       cmonth.add("september");
       cmonth.add("october");
       cmonth.add("november");
       cmonth.add("december");
        add(cmonth); 
        
         
        table = new JTable();
        
        try{
            
            Conn c=new Conn();
            ResultSet rs =c.s.executeQuery("select * from bill");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(0, 100, 700, 600);
        add(sp);
        
        
        search = new JButton("search");
        search.setBounds(120, 70,80,20);
        search.addActionListener(this);
        add(search);
        
        print= new JButton("print");
        print.addActionListener(this);
        print.setBounds(220, 70,80,20);
        add(print);
        
        
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==search){
            String query="select * from bill where meter_no= '"+meternumber.getSelectedItem()+"' and month = '"+cmonth.getSelectedItem()+"'";
        try{
            Conn c=new Conn();
            ResultSet rs =c.s.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        }
        
        }else {
            try{
                table.print();//print command
                
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        
    }
    
    
    public static void main(String args[]){
        new Depositedetails();
    }
}
