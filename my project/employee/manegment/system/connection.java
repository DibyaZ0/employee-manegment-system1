package employee.manegment.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class connection {
    

    Connection connection;

    Statement statement;

    public connection(){
        try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lucky","root","Lucky@1234#%");
           statement = connection.createStatement();
        }catch(Exception e){
            e.printStackTrace();
        }
    }


}
