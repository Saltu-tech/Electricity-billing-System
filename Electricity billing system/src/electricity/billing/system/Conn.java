
package electricity.billing.system;
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.*;

public class Conn {
     Statement s;
     Connection c;
    
    Conn(){
     
    
    
        try{
           Class.forName("com.mysql.cj.jdbc.Driver");
        c= DriverManager.getConnection("jdbc:mysql://localhost:3306/data","root","Saltu@993940");
        s=c.createStatement();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public static void main(String args[]){
   new Conn();
    }
}
        

   

