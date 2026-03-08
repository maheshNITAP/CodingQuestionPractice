package LLD.objectPoolDesignPattern;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    Connection mysqlConnection;

    DBConnection(){
        try{
            //return dummy connection for now
            this.mysqlConnection = DriverManager.getConnection("url", "username", "password");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
