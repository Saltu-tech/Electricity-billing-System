
package electricity.billing.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

/**
 *
 * @author saltu
 */
public class PAY extends JFrame implements ActionListener{
    
    Choice cmonth;
    JButton pay_here,back;
    String meter;
    PAY(String meter){
        this.meter=meter;
        
        setLayout(null);
        setBounds(300,150,900,600);
        
        JLabel head =new JLabel("Your Bill");
        head.setFont(new Font("PLAIN",Font.BOLD,24));
        head.setBounds(120,5,400,30);
        add(head);
        
        
        JLabel lblmeter =new JLabel("meter_no");
         lblmeter.setBounds(35,80,200,20);
          add(lblmeter);
          
           
        JLabel meterno =new JLabel("");
         meterno.setBounds(300,80,200,20);
          add(meterno);
          
          JLabel lblname =new JLabel("name");
         lblname.setBounds(35,120,200,20);
          add(lblname);
          
           
        JLabel name =new JLabel("");
         name.setBounds(300,120,200,20);
          add(name);
          
          JLabel lblmonth =new JLabel("month");
         lblmonth.setBounds(35,160,200,20);
          add(lblmonth);
          
            cmonth=new Choice();
       cmonth.setBounds(300,160,200,20);
       
      
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
        
        
            
        
          JLabel lblunits =new JLabel("Units");
         lblunits.setBounds(35,200,200,20);
          add(lblunits);
          
        JLabel units =new JLabel("");
         units.setBounds(300,200,200,20);
          add(units);
          
          
          JLabel lbltotal =new JLabel("total bill");
         lbltotal.setBounds(35,240,200,20);
          add(lbltotal);
          
        JLabel total =new JLabel("");
         total.setBounds(300,240,200,20);
          add(total);
          
          JLabel lblstatus =new JLabel(" Status");
         lblstatus.setBounds(35,280,200,20);
          add(lblstatus);
          
        JLabel status =new JLabel("");
         status.setBounds(300,280,200,20);
          add(status);
          
          try{
              Conn c=new Conn();
              ResultSet rs=c.s.executeQuery("select * from customer where meter_no='"+meter+"'");
              while(rs.next()){
                 meterno.setText(meter) ;
                 lblname.setText(rs.getString("name"));
                  
              }
              
              
               rs=c.s.executeQuery("select * from bill where meter_no='"+meter+"' AND month='january'");
              while(rs.next()){
                 units.setText(rs.getString("units")) ;
                 total.setText(rs.getString("totalbill")) ;
                 status.setText(rs.getString("status"));
          
              }
          }catch(Exception e){
              e.printStackTrace();
          }
          
          cmonth.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ae){
                
                try{
              
                  
              
                Conn c=new Conn();
              
              ResultSet rs= c.s.executeQuery("select * from bill where meter_no='"+meter+"' AND month='january'");
              while(rs.next()){
                 units.setText(rs.getString("units")) ;
                 total.setText(rs.getString("totalbill")) ;
                 status.setText(rs.getString("status"));
          
              }
          }catch(Exception e){
              e.printStackTrace();
          }
                
                
            }
              
          });
          
          pay_here=new JButton("Pay here");
          pay_here.setBounds(100,460,100,25);
          pay_here.addActionListener(this);
          add(pay_here);
          
        back=new JButton("Back");
          back.setBounds(300,460,100,25);
          back.addActionListener(this);
          add(back);
          
          
          
          
          
        setVisible(true);
    
    }

public void actionPerformed(ActionEvent ae){
    if(ae.getSource()==pay_here){
        try{
            Conn c= new Conn();
            c.s.executeUpdate("update bill set status = 'paid' where meter_no='"+meter+"' And month='"+cmonth.getSelectedItem()+"'");
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        setVisible(false);
        new Payment(meter);
        
    }else{
        setVisible(false);
    }
}


public static void main(String args[]){
    new PAY("");
}

}
