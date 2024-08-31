
package electricity.billing.system;

/**
 *
 * @author saltu
 */
import javax.swing.*;
import java.awt.*;

import java.awt.event.*;
import java.sql.*;
public class Calculatebill extends JFrame implements ActionListener {
    JTextField tfname,tfadd ,tfunits ,tfcity;
    JButton next,cancel;
    JLabel lblname,labeladd;
    Choice meternumber,cmonth;
    Calculatebill(){
        setSize(700,500);
        setLocation(400,200);
        
        JPanel p=new JPanel();//panel using for dividing frame into two parts 
        p.setLayout(null);
        p.setBackground(new Color(180,30,200,20));
        add(p);
        
        JLabel heading =new JLabel("Calculate bill");
        heading.setBounds(100, 10, 400, 25);
        heading.setFont(new Font("Tahoma",Font.BOLD,24));
        p.add(heading);
        
        JLabel lblmeternumber = new JLabel("Meter no");
        lblmeternumber.setBounds(100,80,100,20);
        p.add(lblmeternumber);
        
        meternumber=new Choice();
      try{
          Conn c= new Conn();
           ResultSet rs = c.s.executeQuery("select * from customer");
          
           while(rs.next()){
           meternumber.add(rs.getString("meter_no"));
           }
      }   catch(Exception e){     
          e.printStackTrace();
      }
        
         meternumber.setBounds(240,80,200,20);
        p.add( meternumber);
        
        JLabel lblmeter = new JLabel("Name");
        lblmeter.setBounds(100,120,100,20);
        p.add(lblmeter);
        
        lblname = new JLabel("");
        lblname.setBounds(240,120,100,20);
        p.add(lblname);
        
       
        
         JLabel lbladd = new JLabel("Address");
        lbladd.setBounds(100,160,100,20);
        p.add(lbladd);
        
        labeladd =new JLabel();
        labeladd.setBounds(240,160,200,20);
        p.add(labeladd);
        try{
            Conn c=new Conn();
            ResultSet rs =c.s.executeQuery("select * from customer where meter_no ='"+meternumber.getSelectedItem()+"'");
        while(rs.next()){
            lblname.setText(rs.getString("name"));
            labeladd.setText(rs.getString("address"));
        }
        }catch(Exception e){
            e.getStackTrace();
        }
        meternumber.addItemListener(new ItemListener(){
        public void itemStateChanged(ItemEvent ie){
             try{
            Conn c=new Conn();
            ResultSet rs =c.s.executeQuery("select * from customer where meter_no ='"+meternumber.getSelectedItem()+"'");
        while(rs.next()){
            lblname.setText(rs.getString("name"));
            labeladd.setText(rs.getString("address"));
        }
        }catch(Exception e){
            e.getStackTrace();
        }
    }
        });
        
        
        JLabel lblstate = new JLabel("Unit Consumed");
        lblstate.setBounds(100,200,100,20);
        p.add(lblstate);
        
        tfunits =new JTextField();
        tfunits.setBounds(240,200,200,20);
        p.add( tfunits);
        
        
         
        JLabel lblcity = new JLabel("Month");
        lblcity.setBounds(100,240,100,20);
        p.add(lblcity);
        
       cmonth = new Choice();
       cmonth.setBounds(240,240,200,20);
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
      
       p.add(cmonth);
        
         
        
        
        next =new JButton("Submit");//jbutton use for type button
        next.setForeground(Color.CYAN);
        next .setBackground(Color.WHITE);
        next.setBounds(120,350,100,20);
        next.addActionListener(this);
        p.add(next);
        
        
        cancel =new JButton("Cancel");//jbutton use for type button
        cancel.setForeground(Color.CYAN);
        cancel .setBackground(Color.WHITE);
        cancel.setBounds(280,350,100,20);
        cancel.addActionListener(this);
        p.add(cancel);
        
       setLayout(new BorderLayout());
       add(p);
       
        ImageIcon icon1= new ImageIcon(ClassLoader.getSystemResource("icon/hicon2.jpg"));//image kai lia 
       Image i2 = icon1.getImage().getScaledInstance(150, 300, Image.SCALE_DEFAULT);//image ko scale karne kai lia 
       ImageIcon i3=new ImageIcon(i2);
       JLabel image=new JLabel(i3);
       add(image,"West");
       
        
        
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==next){ 
            String meter =meternumber.getSelectedItem();
            String units =tfunits.getText();
            String month=cmonth.getSelectedItem();
            
            int totalbill=0;
            int unit_consumed =Integer.parseInt(units);
            
            
            
            
            String query="select * from tax";
            
            try{
                Conn c=new Conn();
                ResultSet rs = c.s.executeQuery(query);
                 
                while(rs.next()){
                    totalbill+=unit_consumed * Integer.parseInt( rs.getString("cost_per_unit"));
                
                 totalbill+=Integer.parseInt(rs.getString("meter_rent"));
                totalbill+=Integer.parseInt(rs.getString("service_charge"));
                totalbill+=Integer.parseInt(rs.getString("service_tax"));
                
                totalbill+=Integer.parseInt(rs.getString("swacch_bharat_cess"));
                totalbill+=Integer.parseInt(rs.getString("fixed_tax"));
                
                }
                 } catch(Exception e){
                e.printStackTrace();
            }
             String query3= "insert into bill values('"+meter+"','"+month+"','"+units+"','"+totalbill+"','not paid')";       
        try{
            Conn c =new Conn();
            c.s.executeUpdate(query3);
            JOptionPane.showMessageDialog(null,"customer bill updated");
        setVisible(false);
        }catch (Exception e){
         e.printStackTrace();
            
        }
        
        }else {
            setVisible(false);
        }
    }
    
    
    
    
    public static void main(String args[]){
        
        new Calculatebill();
    }
      
    
}
