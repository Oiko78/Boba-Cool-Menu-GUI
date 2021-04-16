package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
  public static Connection connection;
  
  public static Connection connect() {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bobacool-db?useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
    } catch(SQLException e) {
      // Do nothing
    } catch (ClassNotFoundException e) {
      // Do nothing
    }
    return connection;
  }
}
