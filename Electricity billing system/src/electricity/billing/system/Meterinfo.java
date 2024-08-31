
package electricity.billing.system;

/**
 *
 * @author saltu
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Meterinfo extends JFrame implements ActionListener {
    JTextField tfname,tfadd ,tfstate ,tfcity,tfmail,tfphon;
    JButton next,cancel;
    JLabel lblmeterno;
    Choice meterlocation,metertype,phasecode,billtype;
   String meternumber;
    Meterinfo(String meternumber){
        this.meternumber=meternumber;
        
        setSize(700,500);
        setLocation(400,200);
        
        JPanel p=new JPanel();//panel using for dividing frame into two parts 
        p.setLayout(null);
        p.setBackground(new Color(180,30,200,20));
        add(p);
        
        JLabel heading =new JLabel("Meter info");
        heading.setBounds(180, 10, 200, 25);
        heading.setFont(new Font("Tahoma",Font.BOLD,24));
        p.add(heading);
        
        JLabel lblname = new JLabel("Meter no");
        lblname.setBounds(100,80,100,20);
        p.add(lblname);
        
        JLabel lblmeternumber = new JLabel(meternumber);
        lblmeternumber.setBounds(240,80,100,20);
        p.add(lblmeternumber);
        
        JLabel lblmeter = new JLabel("Meter location");
        lblmeter.setBounds(100,120,100,20);
        p.add(lblmeter);
        
        meterlocation=new Choice();
        meterlocation.add("Outside");
        meterlocation.add("Inside");
        meterlocation.setBounds(240,120,100,20);
         p.add(meterlocation);
        
        
       
        
         JLabel lbladd = new JLabel("Meter Type");
        lbladd.setBounds(100,160,100,20);
        p.add(lbladd);
        
        metertype=new Choice();
        metertype.add("Electric meter");
        metertype.add("solar meter");
        metertype.add("smart meter");
        metertype.setBounds(240,160,100,20);
         p.add(metertype);
        
        
        
        JLabel lblstate = new JLabel("Phase code");
        lblstate.setBounds(100,200,100,20);
        p.add(lblstate);
        
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
         phasecode.setBounds(240,200,100,20);
         p.add( phasecode);
        
         
        JLabel lblcity = new JLabel("BILL Type");
        lblcity.setBounds(100,240,100,20);
        p.add(lblcity);
        
       billtype=new Choice();
      
        billtype.add("Normal");
        billtype.add("Industrial");
        billtype.setBounds(240,240,100,20);
         p.add(billtype);
        
         
        JLabel lblmail = new JLabel("Days");
        lblmail.setBounds(100,280,100,20);
        p.add(lblmail);
        
       
        
        JLabel lblphone = new JLabel("30 Days");
        lblphone.setBounds(240,280,100,20);
        p.add(lblphone);
        
         JLabel lblmails = new JLabel("Note");
        lblmails.setBounds(100,320,100,20);
        p.add(lblmails);
        JLabel lblphones = new JLabel("auto calulated for 30 days only");
        lblphones.setBounds(240,320,500,20);
        p.add(lblphones);
        
        next =new JButton("Submit");//jbutton use for type button
        next.setForeground(Color.CYAN);
        next .setBackground(Color.WHITE);
        next.setBounds(220,390,100,20);
        next.addActionListener(this);
        p.add(next);
        
        
        
        
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
            String meter =meternumber;
            String location =meterlocation.getSelectedItem();
            String type=metertype.getSelectedItem();
            String code=phasecode.getSelectedItem();
            String typebill=billtype.getSelectedItem();
            String days ="30";
           
            
            String query = "insert into meter_info values('"+meter+"','"+location+"', '"+type+"','"+code+"', '"+typebill+"','"+days+"')";
            
            
            try{
                Conn c=new Conn();
                c.s.executeUpdate(query);
                 
                 JOptionPane.showMessageDialog(null,"meter info Added successfully");
                 setVisible(false);
            
            } catch(Exception e){
                e.printStackTrace();
            }
                    }else {
            setVisible(false);
        }
    }
    
    
    
    
    public static void main(String args[]){
        
        new Meterinfo("");
    }
      
    
}
