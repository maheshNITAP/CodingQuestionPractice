package LLD.objectPoolDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class DBConnectionPoolManager {
    private List<DBConnection> freeConnectionInPool = new ArrayList<>();
    private List<DBConnection> connectionsCurrentlyInUse = new ArrayList<>();

    private static final int  INITIAL_POOL_SIZE = 3;
    private static final int MAX_POOL_SIZE = 6;

    private static DBConnectionPoolManager dbConnectionPoolManager = null;

    private DBConnectionPoolManager(){
        for(int i=0; i<INITIAL_POOL_SIZE; i++){
            freeConnectionInPool.add(new DBConnection());
        }
    }

    //double locking for thread safety and performance
    public static DBConnectionPoolManager getInstance(){
        if(dbConnectionPoolManager==null){
            synchronized (DBConnectionPoolManager.class){
                if(dbConnectionPoolManager==null)
                    dbConnectionPoolManager= new DBConnectionPoolManager();
            }
        }
        return dbConnectionPoolManager;
    }

    public synchronized DBConnection getDBConnection(){
        if(freeConnectionInPool.isEmpty() && connectionsCurrentlyInUse.size()<MAX_POOL_SIZE)
            freeConnectionInPool.add(new DBConnection());
        else if(freeConnectionInPool.isEmpty() && connectionsCurrentlyInUse.size()>=MAX_POOL_SIZE){
            System.out.println("Max pool size reached. Please wait for a connection to be released.");
            return null;
        }
        DBConnection dbConnection = freeConnectionInPool.remove(freeConnectionInPool.size()-1);
        connectionsCurrentlyInUse.add(dbConnection);
        return dbConnection;
    }

    public synchronized void releaseDBConnection(DBConnection dbConnection){
        if(dbConnection!=null){
            connectionsCurrentlyInUse.remove(dbConnection);
            freeConnectionInPool.add(dbConnection);
        }
    }

}
