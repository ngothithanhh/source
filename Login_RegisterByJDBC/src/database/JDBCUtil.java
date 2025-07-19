package database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {
    public static Connection getConnection(){
        Connection con = null;
        String url = "jdbc:sqlserver://localhost:1433;databaseName=login_app;encrypt=true;trustServerCertificate=true;";
        String user = "sa";
        String password = "123456";
        try{
            con = DriverManager.getConnection(url,user,password);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return con;
    }

    public static void closeConnection(Connection c){
        try {
            if(c!=null){
                c.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printInfo(Connection c){
        try {
            DatabaseMetaData mtdt = c.getMetaData();
            System.out.println(mtdt.getDatabaseProductName());
            System.out.println(mtdt.getDatabaseProductVersion());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
