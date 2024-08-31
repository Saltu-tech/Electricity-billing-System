
package electricity.billing.system;

/**
 *
 * @author saltu
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Generate extends JFrame implements ActionListener {
    String meter;
    JTable table;
    JButton  bill;
    Choice cmonth;
     JTextArea area;
    Generate(String meter){
         this.meter=meter;
        
        setSize(500,800);
        setLocation(550,30);
       
        setLayout(new BorderLayout());
        JPanel panel =new JPanel();
        JLabel head = new JLabel("Generate your bill");
        
        JLabel meterno = new JLabel(meter);
        cmonth = new Choice();
        
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
         
       
       
       
         area = new JTextArea(50,15);
        area.setText("\n\t click on the \n\t Generate bill to get the bill of the selected month");
        
        JScrollPane pane = new JScrollPane(area);
        
        
        bill = new JButton("Generate bill");
        bill.addActionListener(this);
        
       panel.add(head);
       panel.add(meterno);
       panel.add(cmonth);
       add(panel,"North");
       
       add(pane,"Center");
       add(bill,"South");
        
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        
        try{
            Conn c=new Conn();
            String month=cmonth.getSelectedItem();
            area.setText("\tSBPDL\tElectricity bill generated for the month of "+month+",2023\n\n");
            
          ResultSet rs = c.s.executeQuery("select * from customer where meter_no = '"+meter+"'");
           if(rs.next()){
               area.append("\n Customer name :"+rs.getString("name"));
               area.append("\n meterno :"+rs.getString("meter_no"));
               area.append("\n add :"+rs.getString("address"));
               area.append("\n city :"+rs.getString("city"));
               area.append("\n state :"+rs.getString("state"));
               area.append("\n mail :"+rs.getString("mail"));
               area.append("\n phone :"+rs.getString("phone"));
                area.append("\n---------------------------------------------"); 
               area.append("\n");
           }
             rs = c.s.executeQuery("select * from meter_info where meter_no = '"+meter+"'");
           if(rs.next()){
               area.append("\n meter location :"+rs.getString("meter_location"));
               area.append("\n meter type :"+rs.getString("meter_type"));
               area.append("\n phase code :"+rs.getString("phase_code"));
               area.append("\n Bill type :"+rs.getString("bill_type"));
               area.append("\n Days :"+rs.getString("days"));
                area.append("\n---------------------------------------------");
               area.append("\n");
           }
           rs = c.s.executeQuery("select * from tax ");
           if(rs.next()){
              
               area.append("\n");
               area.append("\n Cost per Unit :"+rs.getString("cost_per_unit"));
               area.append("\n meter Rent :"+rs.getString("meter_rent"));
               area.append("\n Service Charge :"+rs.getString("service_charge"));
               area.append("\n Service Tax :"+rs.getString("service_tax"));
               area.append("\n Swacch Bharat Cess :"+rs.getString("swacch_bharat_cess"));
               area.append("\n Fixed Tax :"+rs.getString("fixed_tax"));
               area.append("\n---------------------------------------------");
               area.append("\n");
           }
           rs = c.s.executeQuery("select * from bill where meter_no ='"+meter+"' and month ='"+month+"' ");
           if(rs.next()){
              
               area.append("\n");
               area.append("\n Current month :"+rs.getString("month"));
               area.append("\n Units Consumed  :"+rs.getString("units"));
               area.append("\n Total charges :"+rs.getString("totalbill"));
               area.append("\n---------------------------------------------");
               area.append("\n total :"+rs.getString("totalbill"));
               
           }
              
        }catch(Exception e){
        e.printStackTrace();
        }
        
        
    }
    
public static void main(String args[]){
    new Generate(" ");
}


}


