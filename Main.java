import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.ImageIcon;

import Database.DBConnect;
import dao.MenuDAO;

public class Main {
  public static Font menu, title, text, inputText, table, tableTitle;
  public static ImageIcon icon = new ImageIcon(Main.class.getResource("/Images/boba-icon.jpg"));
  public static ImageIcon smallImage = new ImageIcon(new ImageIcon(Main.class.getResource("/Images/boba-icon-transparent.png")).getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT));
  public static MenuDAO menuDAO = new MenuDAO();
  public static Vector<dao.Boba> bobas = menuDAO.getData();
  public static void main(String[] args) throws SQLException {
    initFonts();
    new MainMenu();
  }
  public static void initFonts() {
    try {
      title = Font.createFont(Font.TRUETYPE_FONT, Main.class.getResourceAsStream("/Fonts/BebasNeue-Bold.ttf")).deriveFont(55f);
      menu = Font.createFont(Font.TRUETYPE_FONT, Main.class.getResourceAsStream("/Fonts/BebasNeue-Bold.ttf")).deriveFont(40f);
      text = Font.createFont(Font.TRUETYPE_FONT, Main.class.getResourceAsStream("/Fonts/BebasNeue-Bold.ttf")).deriveFont(35f);
      inputText = Font.createFont(Font.TRUETYPE_FONT, Main.class.getResourceAsStream("/Fonts/BebasNeue-Regular.ttf")).deriveFont(25f);
      table = Font.createFont(Font.TRUETYPE_FONT, Main.class.getResourceAsStream("/Fonts/BebasNeue-Regular.ttf")).deriveFont(25f);
      tableTitle = Font.createFont(Font.TRUETYPE_FONT, Main.class.getResourceAsStream("/Fonts/BebasNeue-Bold.ttf")).deriveFont(30f);
    } catch(IOException | FontFormatException e) {
      // Do nothing
    }
  }
}
