package electricity.billing.system;

/**
 *
 * @author saltu
 */
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class BillINFO extends JFrame {

    BillINFO(String meter) {
        setSize(700, 650);
        setLocation(400, 150);

        
        JTable table =new JTable();
        try{
            Conn c=new Conn();
            String query="select * from bill where meter_no='"+meter+"'";
            ResultSet rs=c.s.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
            
        }catch(Exception e){
         e.printStackTrace();
        }
        
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(0,0,750,650);
        add(sp);
        
        
        
        setVisible(true);

    }

    public static void main(String args[]) {

        new BillINFO("");
    


    }
    
    
}
