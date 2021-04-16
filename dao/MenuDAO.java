package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import Database.DBConnect;

public class MenuDAO {
  public Connection connection;
  public MenuDAO() {
    try {
      initDB();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void initDB() throws SQLException {
    connection = DBConnect.connect();
    if(connection == null)
      throw new SQLException("connection");
  }
  public Vector<Boba> getData() {
    Vector<Boba> bobas = new Vector<>();
    try {
      Statement statement = connection.createStatement();
      String sql = "select * from menus";
      ResultSet result = statement.executeQuery(sql);
      while(result.next()) {
        bobas.add(new Boba(result.getString(1), result.getString(2), Integer.parseInt(result.getString(3)), Integer.parseInt(result.getString(4))));
      }
    } catch (SQLException e) {
      // Do nothing
    }
    return bobas;
  }
  public void insertData(String code, String name, int price, int stock) {
    try {
      Statement statement = connection.createStatement();
      String sql = "insert into menus values ('"+code+"', '"+name+"', "+price+", "+stock+")";
      statement.executeUpdate(sql);
      System.out.println("Input data successfull");
    } catch (SQLException e) {
      // Do nothing
    }
  }
  public void updateData(String code, String name, int price, int stock) {
    try {
      Statement statement = connection.createStatement();
      String sql = "update menus set name='"+name+"',price="+price+",stock="+stock;
      statement.executeUpdate(sql);
      System.out.println("Update data successfull");
    } catch (SQLException e) {
      // Do nothing
    }
  }
  public void deleteData(String code) {
    try {
      Statement statement = connection.createStatement();
      String sql = "delete from menus where code='"+code+"'";
      statement.executeUpdate(sql);
      System.out.println("Delete data successfull");
    } catch (SQLException e) {
      // Do nothing
    }
  }
}
