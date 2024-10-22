package hospital.management.system;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;

public class conn {
    Connection connection;
    Statement statement;
    public conn(){
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hsm","root","admin");
            statement = connection.createStatement();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
