
package electricity.billing.system;

/**
 *
 * @author saltu
 */
import java.awt.*;
import javax.swing.*;


import java.awt.event.*;
public class Saltu2 extends JFrame implements ActionListener {
    String atype,meter;
   Saltu2(String atype,String meter){
      this.atype=atype;
      this.meter=meter;
       setExtendedState(JFrame.MAXIMIZED_BOTH);//funtion for frame get into full screen.
       
       ImageIcon i3=new ImageIcon(ClassLoader.getSystemResource("icon/elect1.jpg"));//button par image lene kai lia
        Image i4 = i3.getImage().getScaledInstance(1550, 850, Image.SCALE_DEFAULT);//image ko resize karne kai lia 
       ImageIcon i5 =new ImageIcon(i4);
       JLabel image =new JLabel(i5);
       add(image);
       
       JMenuBar sk=new JMenuBar();//function for making menu bar;
       setJMenuBar(sk);//frame ki upar palce karne ka ia menu bar ko 
        setLayout(new FlowLayout());//menubar aa jayega
       JMenu menu =new JMenu("MAIN MENU");
        menu.setForeground(Color.BLUE);
      
       
       JMenuItem newcustomer =new JMenuItem("NEW USER");
       newcustomer.setBackground(Color.WHITE);
       newcustomer.setForeground(Color.BLUE);
       ImageIcon icon1= new ImageIcon(ClassLoader.getSystemResource("icon/icon1.png"));//image kai lia 
       Image image1 = icon1.getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT);//image ko scale karne kai lia 
       newcustomer.setIcon(new ImageIcon(image1));
       newcustomer.setMnemonic('D');
       
       newcustomer.addActionListener(this);
       newcustomer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,ActionEvent.CTRL_MASK));//button ka shortcut karne kai lia ye event package kai ander ata hai
        menu.add(newcustomer);//menu kai andar hai yee
        
        JMenuItem customerdetails =new JMenuItem("USER Details");
      customerdetails.setBackground(Color.WHITE);
       customerdetails.setForeground(Color.BLUE);
       ImageIcon icon2= new ImageIcon(ClassLoader.getSystemResource("icon/icon2.png"));//image kai lia 
       Image image2 = icon2.getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT);//image ko scale karne kai lia 
       customerdetails.setIcon(new ImageIcon(image2));
       customerdetails.setMnemonic('X');
      
        customerdetails.addActionListener(this);
       
       customerdetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,ActionEvent.CTRL_MASK));//button ka shortcut karne kai lia ye event package kai ander ata hai
        menu.add(customerdetails);//menu kai andar hai yee
        
        JMenuItem depositdetails =new JMenuItem("deposite Details");
      depositdetails.setBackground(Color.WHITE);
       depositdetails.setForeground(Color.BLUE);
       ImageIcon icon3= new ImageIcon(ClassLoader.getSystemResource("icon/icon3.png"));//image kai lia 
       Image image3 = icon3.getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT);//image ko scale karne kai lia 
       depositdetails.setIcon(new ImageIcon(image3));
       depositdetails.setMnemonic('G');
     depositdetails.addActionListener(this);
       depositdetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G,ActionEvent.CTRL_MASK));//button ka shortcut karne kai lia ye event package kai ander ata hai
        menu.add(depositdetails);//menu kai andar hai yee
        
        JMenuItem calcultebill =new JMenuItem("Calculte bills");
      calcultebill.setBackground(Color.WHITE);
       calcultebill.setForeground(Color.BLUE);
       ImageIcon icon4= new ImageIcon(ClassLoader.getSystemResource("icon/icon4.png"));//image kai lia 
       Image image4 = icon4.getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT);//image ko scale karne kai lia 
       calcultebill.setIcon(new ImageIcon(image4));
       calcultebill.setMnemonic('L');
   calcultebill.addActionListener(this);
       calcultebill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L,ActionEvent.CTRL_MASK));//button ka shortcut karne kai lia ye event package kai ander ata hai
        menu.add(calcultebill);//menu kai andar hai yee
        
        
        
       JMenu info =new JMenu("INFO");
       info.setForeground(Color.red);
       
       
       
       
       JMenuItem updateinfo =new JMenuItem("UPDATE INFO");
      updateinfo.setBackground(Color.WHITE);
      updateinfo.setForeground(Color.BLUE);
       ImageIcon icon5= new ImageIcon(ClassLoader.getSystemResource("icon/icon5.png"));//image kai lia 
       Image image5 = icon5.getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT);//image ko scale karne kai lia 
       updateinfo.setIcon(new ImageIcon(image5));
       updateinfo.setMnemonic('K');
    updateinfo.addActionListener(this);
       updateinfo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K,ActionEvent.CTRL_MASK));//button ka shortcut karne kai lia ye event package kai ander ata hai
        info.add(updateinfo);//menu kai andar hai yee
        
       JMenuItem viewinfo =new JMenuItem("VIEW INFO");
      viewinfo.setBackground(Color.WHITE);
     viewinfo.setForeground(Color.BLUE);
       ImageIcon icon6= new ImageIcon(ClassLoader.getSystemResource("icon/icon6.png"));//image kai lia 
       Image image6 = icon6.getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT);//image ko scale karne kai lia 
       viewinfo.setIcon(new ImageIcon(image6));
       viewinfo.setMnemonic('M');
        viewinfo.addActionListener(this);
       viewinfo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,ActionEvent.CTRL_MASK));//button ka shortcut karne kai lia ye event package kai ander ata hai
        info.add(viewinfo);//menu kai andar hai yee
        
        JMenu user =new JMenu("USER");
      user.setForeground(Color.BLUE);
       
       
       
       JMenuItem pay =new JMenuItem("PAY BILLS");
      pay.setBackground(Color.WHITE);
      pay.setForeground(Color.BLUE);
       ImageIcon icon7= new ImageIcon(ClassLoader.getSystemResource("icon/icon7.png"));//image kai lia 
       Image image7 = icon7.getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT);//image ko scale karne kai lia 
       pay.setIcon(new ImageIcon(image7));
       pay.setMnemonic('U');
        pay.addActionListener(this);
   pay.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U,ActionEvent.CTRL_MASK));//button ka shortcut karne kai lia ye event package kai ander ata hai
        user.add(pay);//menu kai andar hai yee
        
       JMenuItem billdetails =new JMenuItem("BILL DETAILS");
      billdetails.setBackground(Color.WHITE);
     billdetails.setForeground(Color.BLUE);
       ImageIcon icon8= new ImageIcon(ClassLoader.getSystemResource("icon/icon8.png"));//image kai lia 
       Image image8 = icon8.getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT);//image ko scale karne kai lia 
      billdetails.setIcon(new ImageIcon(image8));
       billdetails.setMnemonic('N');
  billdetails.addActionListener(this);
       billdetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));//button ka shortcut karne kai lia ye event package kai ander ata hai
        user.add(billdetails);//menu kai andar hai yee
        
        JMenu report =new JMenu("Report");
       report.setForeground(Color.red);
       
       
       
       
       JMenuItem generatebill =new JMenuItem("Generate bill");
      generatebill.setBackground(Color.WHITE);
      generatebill.setForeground(Color.BLUE);
       ImageIcon icon9= new ImageIcon(ClassLoader.getSystemResource("icon/icon6.png"));//image kai lia 
       Image image9 = icon9.getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT);//image ko scale karne kai lia 
       generatebill.setIcon(new ImageIcon(image9));
      generatebill.setMnemonic('F');
    generatebill.addActionListener(this);
      generatebill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F,ActionEvent.CTRL_MASK));//button ka shortcut karne kai lia ye event package kai ander ata hai
        report.add(generatebill);//menu kai andar hai yee
        
        JMenu utility =new JMenu("Utility");
       utility.setForeground(Color.red);
      
       
       
       
       JMenuItem notepad =new JMenuItem("NOTEPAD");
      notepad.setBackground(Color.WHITE);
      notepad.setForeground(Color.BLUE);
       ImageIcon icon10= new ImageIcon(ClassLoader.getSystemResource("icon/icon12.png"));//image kai lia 
       Image image10 = icon10.getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT);//image ko scale karne kai lia 
       notepad.setIcon(new ImageIcon(image10));
      notepad.setMnemonic('N');
  notepad.addActionListener(this);
      notepad.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.SHIFT_MASK));//button ka shortcut karne kai lia ye event package kai ander ata hai
        utility.add(notepad);//menu kai andar hai yee
        
        JMenuItem calc =new JMenuItem("CALCULATOR");
      calc.setBackground(Color.WHITE);
      calc.setForeground(Color.BLUE);
       ImageIcon icon11= new ImageIcon(ClassLoader.getSystemResource("icon/icon9.png"));//image kai lia 
       Image image11 = icon11.getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT);//image ko scale karne kai lia 
       calc.setIcon(new ImageIcon(image11));
      calc.setMnemonic('Y');
  calc.addActionListener(this);
      calc.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y,ActionEvent.SHIFT_MASK));//button ka shortcut karne kai lia ye event package kai ander ata hai
        utility.add(calc);//menu kai andar hai yee
        
        
        
        JMenu nexit =new JMenu("LOGOUT HERE");
       nexit .setForeground(Color.red);
       
       
       
       
       JMenuItem exit =new JMenuItem("LOGOUT");
      exit.setBackground(Color.WHITE);
     exit.setForeground(Color.BLUE);
       ImageIcon icon12= new ImageIcon(ClassLoader.getSystemResource("icon/icon11.png"));//image kai lia 
       Image image12 = icon12.getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT);//image ko scale karne kai lia 
       exit.setIcon(new ImageIcon(image12));
      exit.setMnemonic('E');
 exit.addActionListener(this);
      exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,ActionEvent.SHIFT_MASK));//button ka shortcut karne kai lia ye event package kai ander ata hai
        nexit.add(exit);//menu kai andar hai yee
        
        
        if(atype.equals("Admin")){
       sk.add(menu);
   }else{
        
        
        sk.add(info);
         sk.add(user);
        sk.add(report);
         
         
        }
        sk.add(utility);
        sk.add(nexit);
        
        setVisible(true);//isko hata dene par page nhi dikhega
       
       
   }
   
   public void actionPerformed(ActionEvent ae){
       String msg = ae.getActionCommand();
       if (msg.equals("NEW USER")){
       
           new NewUser(); 
   }   else if (msg.equals("USER Details"))
   {
       new Customerdetails();
   }   else  if (msg.equals("deposite Details")){
       new Depositedetails();
       
   } else  if (msg.equals("Calculte bills")){
       new Calculatebill();
   }
   else if(msg.equals("VIEW INFO")) {
       new ViewInformation(meter);
   } else if(msg.equals("UPDATE INFO")) {
       new UpdateInformation(meter);
   }else if (msg.equals("BILL DETAILS")){
    
       
       new  BillINFO(meter);
   }else if(msg.equals("NOTEPAD")){
       try {
             Runtime.getRuntime().exec("notepad.exe");
       }catch(Exception e){
        e.printStackTrace();
       }
   }else if(msg.equals("CALCULATOR")){
       try {
             Runtime.getRuntime().exec("calc.exe");
       }catch(Exception e){
        e.printStackTrace();
       }
       
       
   }else if (msg.equals("LOGOUT")){
       setVisible(false);
       new Login();
   }else if(msg.equals("PAY BILLS")){
       new PAY(meter);
   }else if(msg.equals("Generate bill")){
       new Generate(meter);
   }
   }
    
   public static void main(String args[]){
       new Saltu2("", "");
   }
}
