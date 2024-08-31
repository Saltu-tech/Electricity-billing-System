package electricity.billing.system;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

/**
 *
 * @author saltu
 */
public class Signup extends JFrame implements ActionListener{

 JButton Create,Back;
 JLabel heading8;
  JTextField phone,username,name,meternn,pass,mn;
    Choice Accounttype;
Signup(){
  
      setBounds(450,150,900, 600);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setLayout(null);
        
        JPanel panel = new JPanel();//for signup panel use kiye hain frame ki jagah pe kai lia
        panel.setBounds(30,30,900,600);
        panel.setBorder(new TitledBorder(new LineBorder(new Color(173,216,230),2),"Create Account",TitledBorder.LEADING,TitledBorder.TOP,null,new Color(172,216,230)));
        panel.setLayout(null);//panel like frame uska layout null kare nahi to by default kuch bhi le sakta hai
        add(panel);
        
        
        JLabel heading =new JLabel("Create Account As ");
         heading.setBounds(100, 50,140, 20);//set location of username wrt frame page
        panel.add(heading);//kyuki humko ye panel pe chahiye


        Accounttype = new Choice();//for taking option like user or admin
         Accounttype.add("Admin");
         Accounttype.add("user");
        Accounttype.setBounds(260, 50, 150, 20);
        panel.add(Accounttype);
        
        JLabel lblmeter =new JLabel("meter no");
         lblmeter.setBounds(100, 90,140, 20);//set location of username wrt frame page
        lblmeter.setVisible(false);//jab humk kuch nahi dikhana hota hai
        
         
         panel.add(lblmeter);//kyuki humko ye panel pe chahiye
       
        
        phone = new JTextField();//for text input 
        phone.setBounds(260,90,150,20);
       phone.setVisible(false);//jab admin selected rahega to ye bala humko nhi dekhe ga
        panel.add(phone);
        
        JLabel heading1 =new JLabel("Username");
         heading1.setBounds(100, 130,140, 20);//set location of username wrt frame page
        panel.add(heading1);//kyuki humko ye panel pe chahiye
        
         username = new JTextField();//for text input 
        username.setBounds(260,130,150,20);
        panel.add(username);
        
        JLabel heading2 =new JLabel("Name");
         heading2.setBounds(100, 170,140, 20);//set location of username wrt frame page
        panel.add(heading2);//kyuki humko ye panel pe chahiye
        
        
         name = new JTextField();//for text input 
        name.setBounds(260,170,150,20);
        panel.add(name);
        
         heading8 =new JLabel("phone");
         heading8.setBounds(100, 250,140, 20);//set location of username wrt frame page
        panel.add(heading8);//kyuki humko ye panel pe chahiye
        
        mn = new JTextField();//for text input 
        mn.setBounds(260,250,150,20);
        panel.add(mn);
         mn.addFocusListener(new FocusListener(){
            @Override
            public void focusGained(FocusEvent fe){
                
            }
             @Override
            public void focusLost(FocusEvent fe){
                try{
                    Conn c =new Conn();
                    ResultSet rs =c.s.executeQuery("select * from customer where phone='"+mn.getText()+"'");
                    while(rs.next()){
                        name.setText(rs.getString("name"));
                        phone.setText(rs.getString("meter_no"));
                    }
                    
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
        
        
        JLabel heading3 =new JLabel("Password");
         heading3.setBounds(100, 210,140, 20);//set location of username wrt frame page
        panel.add(heading3);//kyuki humko ye panel pe chahiye
        
         Accounttype.addItemListener(new ItemListener(){
    public void itemStateChanged(ItemEvent ae){
        String user =Accounttype.getSelectedItem();
        if(user.equals("user")){
           
            lblmeter.setVisible(true);
             phone.setVisible(true);
            
            phone.setEditable(false);
            name.setEditable(false);
             
            mn.setEditable(true);
        }
        
        
        else {
            lblmeter.setVisible(false);
            phone.setVisible(false);
            name.setEditable(true);
           
            heading8.setVisible(true);
             mn.setVisible(true);
    }
    }
    
});
        
        
        pass = new JTextField();//for text input 
        pass.setBounds(260,210,150,20);
        panel.add(pass);
        
        
         Create =new JButton("Create");
        Create.setBackground(Color.BLACK);
        Create.setForeground(Color.WHITE);
        Create.setBounds(140, 360,120, 25);
        Create.addActionListener(this);
        panel.add(Create);
        
        Back =new JButton("Back");
        Back.setBounds(300, 360,120, 25);
        Back.setForeground(Color.WHITE);//button ka text color kai lia
         Back.setBackground(Color.BLACK);//botton ka background color kai lia
        Back.addActionListener(this);
         panel.add(Back);
        
        ImageIcon i7=new ImageIcon(ClassLoader.getSystemResource("icon/signupImage.png"));//button par image lene kai lia
        Image i8 = i7.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);//image ko resize karne kai lia 
        ImageIcon i9 = new ImageIcon(i8);
        JLabel image= new JLabel(i9);
        image.setBounds(420,30,250,250);
        panel.add(image);


        
        setVisible(true);
    
}
 public void actionPerformed(ActionEvent sk){
     if(sk.getSource()==Create){
         String smeter=phone.getText();
     String atype =Accounttype.getSelectedItem();
     String susername =username.getText();
     String sname =name.getText();//kyuki humko isko print karana hai database mai
      String spass=pass.getText();
       String lmeter=mn.getText();
 
     try{
         Conn c= new Conn();//connection establish karne kai lia
         String query=null;
         if(atype.equals("Admin")){
         
         query="insert into login values('"+smeter+"','"+susername+"','"+sname+"','"+spass+"','"+atype+"','"+lmeter+"')";
         }
         else{
             query="update login set username='"+susername+"',pass='"+spass+"',user='"+atype+"',phone='"+lmeter+"'where meter_no='"+smeter+"'";
         }
         c.s.executeUpdate(query);
         JOptionPane.showMessageDialog(null, "ACCOUNT CREATED SUCESSFULLY");
          
           setVisible(false);
           new Login();
     }catch (Exception e){
         e.printStackTrace();
     }
     }
 
 else if(sk.getSource()==Back){
   setVisible(false);
   new Login();
 }
 }

public static void main(String args[]){
    
    new Signup();
}

}


