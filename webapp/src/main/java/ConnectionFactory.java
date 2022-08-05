import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public Connection getConnection() throws ClassNotFoundException{
        String url = "jdbc:mysql://localhost/empresa";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(url, "root", "<SENHA DO BANCO>");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
}
