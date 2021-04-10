import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.io.IOException;
import java.util.Vector;

import javax.swing.ImageIcon;

public class Main {
  public static Font menu, title, text, inputText, table, tableTitle;
  public static ImageIcon icon = new ImageIcon(Main.class.getResource("/Images/boba-icon.jpg"));
  public static ImageIcon smallImage = new ImageIcon(new ImageIcon(Main.class.getResource("/Images/boba-icon-transparent.png")).getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT));
  public static Vector<Boba> bobas = new Vector<>();
  public static void main(String[] args) {
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
   bobas.add(new Boba("BC-123", "BOBA BOBA BOBA", 123, 2));
   bobas.add(new Boba("BC-123", "BOBA BOBA BOBA", 200000, 2));
   bobas.add(new Boba("BC-123", "BOBA BOBA BOBA", 123, 2));
   bobas.add(new Boba("BC-123", "BOBA BOBA BOBA", 123, 2));
    new MainMenu();
    // new InsertMenu();
    // new ViewMenu();
    // new UpdateMenu();
  }
}
