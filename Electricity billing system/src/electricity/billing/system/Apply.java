
package electricity.billing.system;


/**
 *
 * @author saltu
 */



import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

    

public class Apply extends JFrame implements ActionListener {
    JTextField tfname,tfadd ,tfstate ,tfcity,tfmail,tfphon;
    JButton next,cancel;
    JLabel lblmeterno,lblmail,lbladd,lblstate,lblcity,lblphase,lblmt,lblbill,lblday,lblth;
    Choice meterlocation,metertype,phasecode,billtype;
    Apply(){
        setSize(1000,800);
        setLocation(300,50);
        
        JPanel p=new JPanel();//panel using for dividing frame into two parts 
        p.setLayout(null);
        p.setBackground(new Color(180,30,200,20));
        add(p);
        
        JLabel heading =new JLabel("New User Application");
        heading.setBounds(180, 10, 300, 50);
        heading.setFont(new Font("Tahoma",Font.BOLD,24));
        p.add(heading);
        
        JLabel lblname = new JLabel("Customer Name");
        lblname.setBounds(100,80,100,20);
        p.add(lblname);
        
        tfname =new JTextField();
        tfname.setBounds(240,80,200,20);
        p.add(tfname);
       
    
         lbladd = new JLabel("Address");
        lbladd.setBounds(100,120,100,20);
        p.add(lbladd);
        
        tfadd =new JTextField();
        tfadd.setBounds(240,120,200,20);
        p.add(tfadd);
        
        lblstate = new JLabel("State");
        lblstate.setBounds(100,160,100,20);
        p.add(lblstate);
        
        tfstate =new JTextField();
        tfstate.setBounds(240,160,200,20);
        p.add(tfstate);
        
        
         
        lblcity = new JLabel("City");
        lblcity.setBounds(100,200,100,20);
        p.add(lblcity);
        
        tfcity =new JTextField();
        tfcity.setBounds(240,200,200,20);
        p.add(tfcity);
        
         
        lblmail = new JLabel("Email");
        lblmail.setBounds(100,240,100,20);
        p.add(lblmail);
        
        tfmail =new JTextField();
        tfmail.setBounds(240,240,200,20);
        p.add(tfmail);
        
        JLabel lblphone = new JLabel("Contact no");
        lblphone.setBounds(100,280,100,20);
        p.add(lblphone);
        
        tfphon =new JTextField();
        tfphon.setBounds(240,280,200,20);
        p.add(tfphon);
        
         JLabel lblmeter = new JLabel("Meter location");
        lblmeter.setBounds(100,320,100,20);
        p.add(lblmeter);
        
        meterlocation=new Choice();
        meterlocation.add("Outside");
        meterlocation.add("Inside");
        meterlocation.setBounds(240,320,100,20);
         p.add(meterlocation);
         
        lblmt = new JLabel("Meter Type");
        lblmt.setBounds(100,360,100,20);
        p.add(lblmt);
        
        metertype=new Choice();
        metertype.add("Electric meter");
        metertype.add("solar meter");
        metertype.add("smart meter");
        metertype.setBounds(240,360,100,20);
         p.add(metertype);
         
         lblphase = new JLabel("Phase code");
       lblphase.setBounds(100,400,100,20);
        p.add(lblphase);
        
        phasecode=new Choice();
         phasecode.add("011");
        phasecode.add("022");
         phasecode.add("033");
          phasecode.add("044");
           phasecode.add("055");
            phasecode.add("066");
             phasecode.add("077");
              phasecode.add("088");
               phasecode.add("099");
                phasecode.add("100");
         phasecode.setBounds(240,400,100,20);
         p.add( phasecode);
         lblbill = new JLabel("BILL Type");
        lblbill.setBounds(100,440,100,20);
        p.add(lblbill);
        
       billtype=new Choice();
      
        billtype.add("Normal");
        billtype.add("Industrial");
        billtype.setBounds(240,440,100,20);
         p.add(billtype);
        
         
        lblday = new JLabel("Days");
        lblday.setBounds(100,480,100,20);
        p.add(lblday);
        
       
        
        lblth = new JLabel("30 Days");
         lblth.setBounds(240,480,100,20);
        p.add( lblth);
        
         JLabel lblmails = new JLabel("Note");
        lblmails.setBounds(100,520,100,20);
        p.add(lblmails);
        JLabel lblphones = new JLabel("auto calulated for 30 days only");
        lblphones.setBounds(240,520,500,20);
        p.add(lblphones);
        
        next =new JButton("Apply");//jbutton use for type button
        next.setForeground(Color.CYAN);
        next .setBackground(Color.WHITE);
        next.setBounds(120,590,100,20);
        next.addActionListener(this);
        p.add(next);
        
        
        cancel =new JButton("Preview");//jbutton use for type button
        cancel.setForeground(Color.CYAN);
        cancel .setBackground(Color.WHITE);
        cancel.setBounds(280,590,100,20);
        cancel.addActionListener(this);
        p.add(cancel);
        
       setLayout(new BorderLayout());
       add(p);
       
        ImageIcon icon1= new ImageIcon(ClassLoader.getSystemResource("icon/hicon1.jpg"));//image kai lia 
       Image i2 = icon1.getImage().getScaledInstance(150, 300, Image.SCALE_DEFAULT);//image ko scale karne kai lia 
       ImageIcon i3=new ImageIcon(i2);
       JLabel image=new JLabel(i3);
       add(image,"West");
       
        
        
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==next){ 
            String name =tfname.getText();
            String meterno =lblmeterno.getText();
            String add=tfadd.getText();
            String city=tfcity.getText();
            String state=tfstate.getText();
            String mail=tfmail.getText();
            String phon =tfphon.getText();
            
            String query1="insert into customer values('"+name+"', '"+meterno+"', '"+add+"','"+city+"', '"+state+"','"+mail+"','"+phon+"')";
            String query2="insert into login values('"+meterno+"','', '"+name+"', '', '')";
            
            try{
                Conn c=new Conn();
                c.s.executeUpdate(query1);
                 c.s.executeUpdate(query2);
                 JOptionPane.showMessageDialog(null,"Customer details Added successfully");
                 setVisible(false);
            new Meterinfo(meterno);
                 
                 
            } catch(Exception e){
                e.printStackTrace();
            }
                    }else {
            setVisible(false);
        }
    }
    
    
    
    
    public static void main(String args[]){
        
        new Apply();
    }
      
    
}

    

