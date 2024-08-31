
package electricity.billing.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;//Action listener iske under ata hai 
import java.sql.*;
/**
 *
 * @author saltu
 */
// Actionlistner kisi bhi button ko clicl karne kai bad kuch ho
public class Login extends JFrame implements ActionListener{ 
    
    JButton login,cancel,signup;//globally declared for use in multiple function
    JTextField username;
    JPasswordField pass;
    Choice logginin;
    Login(){
        super("login here");//this is a first statement/heading thats why use super here
       
        getContentPane().setBackground(Color.LIGHT_GRAY);//for page background colour 
        setLayout(null);//apna layout banane kai lia system ka layout null karna pada
        JLabel lblusername =new JLabel("Username");//jlabel mainly use for what you print on page. 
        lblusername.setBounds(300, 20,100, 20);//set location of username wrt frame page
        add(lblusername);
         username = new JTextField();//for text input 
        username.setBounds(400,20,150,20);
        add(username);
        
        JLabel lblpass =new JLabel("password");
         lblpass.setBounds(300, 60,100, 20);//set location of username wrt frame page
        
        add(lblpass);
        pass= new JPasswordField();//for text input 
        pass.setEchoChar('*');
        pass.setBounds(400,60,150,20);
        add(pass);
        
        JLabel lblloggininas =new JLabel("login as");
         lblloggininas.setBounds(300, 100,100, 20);//set location of username wrt frame page
        add(lblloggininas);
         add(lblloggininas);
         logginin = new Choice();//for taking option like user or admin
         logginin.add("Admin");
         logginin.add("user");
        logginin.setBounds(400, 100, 150, 20);
        add(logginin);
      
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));//button par image lene kai lia
        Image i2 = i1.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);//image ko resize karne kai lia 
         login =new JButton("Login", new ImageIcon(i2));//jbutton use for type button
        login.setBounds(330,160,100,20);
        login.addActionListener(this);
        add(login);
        
        
        ImageIcon i3=new ImageIcon(ClassLoader.getSystemResource("icon/cancel.jpg"));//button par image lene kai lia
        Image i4 = i3.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);//image ko resize karne kai lia 
         cancel =new JButton("cancel",new ImageIcon(i4));
        cancel.setBounds(450,160,100,20);
        cancel.addActionListener(this);
        add(cancel);
        
        
        ImageIcon i5=new ImageIcon(ClassLoader.getSystemResource("icon/signup.png"));//button par image lene kai lia
        Image i6 = i5.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);//image ko resize karne kai lia 
         signup =new JButton("signup", new ImageIcon(i6));
        signup.setBounds(390,190,100,20);
        signup.addActionListener(this);// funtion for action on that button
        add(signup);
        
        
        ImageIcon i7=new ImageIcon(ClassLoader.getSystemResource("icon/second.jpg"));//button par image lene kai lia
        Image i8 = i7.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);//image ko resize karne kai lia 
        ImageIcon i9 = new ImageIcon(i8);
        JLabel image= new JLabel(i9);
        image.setBounds(0,0,250,250);
        add(image);
        
        setSize(600, 250); 
        setLocation(400,200);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent sk){
        //action performed yaha se hoga
        //button ko click karne par kya hoga wo is functio se hoga
    if(sk.getSource()==login){
        String susername =username.getText();
         String spass =pass.getText();
          String user =logginin.getSelectedItem();
        try{
            Conn c = new Conn();//sara data rs mai store ho chuka hai 
            String query="select * from login where username='"+susername+"'and pass = '"+spass+"' and user ='"+user+"'"; 
           ResultSet rs= c.s.executeQuery(query);//yaha hum database se data nikal rhe hai to yaha update kai jagah pe execute ka istemal kar rahe hai 
        if(rs.next()){ //agar data hoga to if mai jayega nahi hoga to else mai jayega
          
            String meter =rs.getString("meter_no");
            
          new Saltu2(user,meter);
          setVisible(false);
            
        } else{
            JOptionPane.showMessageDialog(null, "INVALID CREDENTIALS");
        username.setText("");
         pass.setText("");//agar invalid login ho to apne app khali ho jana chahiye bharne wala field 
        
        }
        
        
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
    else if(sk.getSource()==cancel){
        setVisible(false);
    }
    else if(sk.getSource()==signup) {
    setVisible(false);
    new Signup();
    }
    }        
    
    public static void main(String args[]) {
        new Login();

}
}




