package LLD.objectPoolDesignPattern;

import java.sql.Connection;

public class DBConnection {
    Connection mysqlConnection;

    DBConnection DBConnection(){
        try{
            //return dummy connection for now
            return new DBConnection();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
