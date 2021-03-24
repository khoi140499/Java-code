package uncasss;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Uncasss {
    public static void main(String[] args) throws SQLException {
        String dt="D:\\Data\\BenXe.accdb";
        String co="jdbc:ucanaccess://"+dt;
        Connection conn=DriverManager.getConnection(co);
        if(conn!=null){
            System.out.println("Thanh cong");
        }
        else{
            System.out.println("That bai");
        }
    }
    
}
