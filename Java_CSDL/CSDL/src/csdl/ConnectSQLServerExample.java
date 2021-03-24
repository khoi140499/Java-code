package csdl;
import java.sql.Connection;
import java.sql.DriverManager;
import static java.sql.DriverManager.getConnection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectSQLServerExample {
    private static String DB_URL = "jdbc:sqlserver://localhost:1433;"
    + "databaseName=testdb;"
    + "integratedSecurity=true";
    private static String USER_NAME = "sa";
    private static String PASSWORD = "dangkhoi";
    public static void main(String args[]) {
     try {
         Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
         Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from student");
        while (rs.next()) {
        System.out.println(rs.getInt(1) + " " + rs.getString(2)
        + " " + rs.getString(3));
       } 
        conn.close();
        } catch (Exception ex) {
        ex.printStackTrace();
            }
        }
    public static Connection getConnection(String dbURL, String userName,
         String password) {
         Connection conn = null;
    try {
         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
         conn = DriverManager.getConnection(dbURL, userName, password);
         System.out.println("connect successfully!");
    } catch (Exception ex) {
         System.out.println("connect failure!");
         ex.printStackTrace();
    }
        return conn;
    }
}