
package electricity.billing.system;

/**
 *
 * @author saltu
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Payment extends JFrame implements ActionListener {
    String meter;
    JButton back;
    Payment(String meter){
     this.meter=meter;
    JEditorPane j= new JEditorPane();//page uthane bala funct
    j.setEditable(false);
    try{
        
        j.setPage("https://paytm.com/online-payments");
        
    }catch(Exception e){
     
        j.setContentType("text/html");
        j.setText("<html>could not found<html>");//agar usko page nahi milega too
       
    }
    
    JScrollPane pane=new JScrollPane(j);
    add(pane);
    
    back= new JButton("Back");
    back.setBounds(640,20,80,30);
    back.addActionListener(this);
    j.add(back);//page kai upar add kar diye 
    
    
    
    setSize(800,600);
    setLocation(400,150);//frame ka dimension
    setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
       setVisible(false);
       new PAY(meter);
        
    }
    
    
    public static void main(String arg[]){
       
        new Payment("");
        
    }
    
}
