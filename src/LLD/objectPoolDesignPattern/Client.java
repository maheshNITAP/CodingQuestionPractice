package LLD.objectPoolDesignPattern;

public class Client {
    public static void main(String[] args) {
        DBConnectionPoolManager pool = DBConnectionPoolManager.getInstance();
        DBConnection connection1 = pool.getDBConnection();
        DBConnection connection2 = pool.getDBConnection();
        DBConnection connection3 = pool.getDBConnection();

        pool.releaseDBConnection(connection1);
        DBConnection connection4 = pool.getDBConnection();
    }
}
