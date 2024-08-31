
package electricity.billing.system;

/**
 *
 * @author saltu
 */
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class UpdateInformation extends JFrame implements ActionListener {
    JTextField tfadd,tfcity,tfstate,tfphone,tfmail;
    JButton cancel,update;
    String meter;
    JLabel name;
    
    UpdateInformation(String meter){
        this.meter=meter;
        setBounds(300,150,1050,450);
        setLayout(null);
        setVisible(true);
        
        
         JLabel heading =new JLabel("Update info");
        heading.setBounds(110,0,400,30);
        heading.setFont(new Font("BOLD",Font.PLAIN,20));
        add(heading);
        
        
         JLabel lblname =new JLabel("Name");
       lblname.setBounds(30,70,100,20);
       
        add(lblname);
        
         name =new JLabel("");
       name.setBounds(230,70,200,20);
       
        add(name);
        
         JLabel lblmeterno =new JLabel("meter_no");
       lblmeterno.setBounds(30,110,100,20);
       
        add(lblmeterno);
        
        JLabel meterno =new JLabel("");
       meterno.setBounds(230,110,200,20);
       
        add(meterno);
        
        JLabel lbladd=new JLabel("Address");
       lbladd.setBounds(30,150,100,20);
       add(lbladd);
        
         tfadd =new JTextField();
       tfadd.setBounds(230,150,200,20);
        add(tfadd);
        
         JLabel lblcity=new JLabel("city");
       lblcity.setBounds(30,190,100,20);
        add(lblcity);
        
        tfcity =new JTextField();
       tfcity.setBounds(230,190,200,20);
        add(tfcity);
        
        JLabel lblstate=new JLabel("State");
       lblstate.setBounds(30,230,100,20);
        add(lblstate);
        
        tfstate=new JTextField();
       tfstate.setBounds(230,230,200,20);
        add(tfstate);
        
        
        JLabel lblemail=new JLabel("Email");
       lblemail.setBounds(30,270,100,20);
       add(lblemail);
        
        tfmail=new JTextField();
       tfmail.setBounds(230,270,200,20);
        add(tfmail);
        
        JLabel lblphone=new JLabel("phone");
       lblphone.setBounds(30,310,100,20);
        add(lblphone);
        
         tfphone=new JTextField();
       tfphone.setBounds(230,310,200,20);
        add(tfphone);
        
      
        
         try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from customer where meter_no='"+meter+"'");
            while(rs.next()){
            name.setText(rs.getString("name"));
            tfadd.setText(rs.getString("address"));
            tfcity.setText(rs.getString("city"));
            tfstate.setText(rs.getString("state"));
           
            
            tfmail.setText(rs.getString("mail"));
            tfphone.setText(rs.getString("phone"));
            meterno.setText(rs.getString("meter_no"));
            
            }
          
        }catch(Exception e){
            e.printStackTrace();
        }
        
         
         
        update=new JButton("Update");
         update.setBounds(70,360,100,25);
       add( update);
       update.addActionListener(this);
        
        
        
        
        cancel=new JButton("cancel");
        cancel.setBounds(230,360,100,25);
       add(cancel);
       cancel.addActionListener(this);
        
       
       setVisible(true);
       
       
    
    
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==update){
            String add =tfadd.getText();
            String city =tfcity.getText();
            String state =tfstate.getText();
            String mail =tfmail.getText();
            String phone =tfphone.getText();
            
           try{
               Conn c=new Conn();
               c.s.executeUpdate("update customer set address='"+add+"',city='"+city+"',state='"+state+"',mail='"+mail+"',phone='"+phone+"'where meter_no='"+meter+"'");
               JOptionPane.showMessageDialog(null,"updated successfuly");
           }catch(Exception e){
           e.printStackTrace();
           }
            
        }else{
            setVisible(false);
        }
    
    }
    
    public static void main(String args[]){
        new UpdateInformation("");
    }
    
}
