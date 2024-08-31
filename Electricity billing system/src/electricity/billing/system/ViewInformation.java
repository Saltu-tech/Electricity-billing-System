
package electricity.billing.system;

/**
 *
 * @author saltu
 */
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;


public class ViewInformation extends JFrame implements ActionListener{
    JButton cancel;
  
    
    ViewInformation(String meter){
         
        
        setBounds(350,150,850,650);
        setLayout(null);
        JLabel heading =new JLabel("View info");
        heading.setBounds(250,0,500,40);
        heading.setFont(new Font("BOLD",Font.PLAIN,20));
        add(heading);
        
        JLabel lblname =new JLabel("Name");
       lblname.setBounds(70,100,100,20);
       
        add(lblname);
        
        JLabel name =new JLabel("");
       name.setBounds(250,100,100,20);
       
        add(name);
        
         JLabel lblmeterno =new JLabel("meter_no");
       lblmeterno.setBounds(70,140,100,20);
       
        add(lblmeterno);
        
        JLabel meterno =new JLabel("");
       meterno.setBounds(250,140,100,20);
       
        add(meterno);
        
        JLabel lbladd=new JLabel("Address");
       lbladd.setBounds(70,200,100,20);
       
        add(lbladd);
        
        JLabel add =new JLabel("");
       add.setBounds(250,200,100,20);
       
        add(add);
        
         JLabel lblcity=new JLabel("city");
       lblcity.setBounds(70,260,100,20);
       
        add(lblcity);
        
        JLabel city =new JLabel("");
       city.setBounds(250,260,100,20);
       
        add(city);
        
        JLabel lblstate=new JLabel("State");
       lblstate.setBounds(500,80,100,20);
       
        add(lblstate);
        
        JLabel state=new JLabel("");
       state.setBounds(650,80,100,20);
       
        add(state);
        
        
        JLabel lblemail=new JLabel("Email");
       lblemail.setBounds(500,120,100,20);
       
        add(lblemail);
        
        JLabel mail=new JLabel("");
       mail.setBounds(650,120,100,20);
       
        add(mail);
        
        JLabel lblphone=new JLabel("phone");
       lblphone.setBounds(500,160,100,20);
       
        add(lblphone);
        
        JLabel phone=new JLabel("");
       phone.setBounds(650,160,100,20);
       
        add(phone);
        
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from customer where meter_no='"+meter+"'");
            while(rs.next()){
            name.setText(rs.getString("name"));
            add.setText(rs.getString("address"));
            city.setText(rs.getString("city"));
            state.setText(rs.getString("state"));
           
            
            mail.setText(rs.getString("mail"));
            phone.setText(rs.getString("phone"));
            meterno.setText(rs.getString("meter_no"));
            
            }
          
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        
        
        cancel=new JButton("cancel");
        cancel.setBounds(350,340,100,20);
       add(cancel);
       cancel.addActionListener(this);
        
       setVisible(true);
    
    
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
    }
    
    
    public static void main(String args[]){
       
        new ViewInformation("");
    }
    
}
