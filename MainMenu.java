import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class MainMenu extends JFrame implements ActionListener{
  /**
   *
   */
  private static final long serialVersionUID = 1L;

  private Font menu, title, text;
  private JButton insertButton = new JButton("Insert Menu");
  private JButton viewButton = new JButton("View menus");
  private JButton updateButton = new JButton("Update menu");
  private JButton deleteButton = new JButton("Delete menu");

  JButton[] buttons = {insertButton, viewButton, updateButton, deleteButton};
  
  public MainMenu() {
    try {
      title = Font.createFont(Font.TRUETYPE_FONT, Main.class.getResourceAsStream("/Fonts/BebasNeue-Bold.ttf")).deriveFont(55f);
      menu = Font.createFont(Font.TRUETYPE_FONT, Main.class.getResourceAsStream("/Fonts/BebasNeue-Bold.ttf")).deriveFont(40f);
      text = Font.createFont(Font.TRUETYPE_FONT, Main.class.getResourceAsStream("/Fonts/BebasNeue-Bold.ttf")).deriveFont(35f);
    } catch(IOException | FontFormatException e) {
      // Do nothing
    }

    ImageIcon icon = new ImageIcon(Main.class.getResource("/Images/boba-icon.jpg"));
    ImageIcon smallImage = new ImageIcon(new ImageIcon(Main.class.getResource("/Images/boba-icon-transparent.png")).getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT));
    setTitle("Boba-Cool Main Menu");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setResizable(false);
    setLayout(new GridLayout(2, 1));
    setSize(500, 750);
    setIconImage(icon.getImage());
    getContentPane().setBackground(ColorPicker.yellow());
    
    JPanel topPanel = new JPanel();
    topPanel.setLayout(new BorderLayout());
    topPanel.setOpaque(false);
    topPanel.setBackground(new Color(255, 0, 0, 20));


    JLabel label = new JLabel("Boba - Cool");
    label.setFont(title);
    label.setForeground(ColorPicker.blueDark());
    label.setIcon(smallImage);
    label.setHorizontalTextPosition(JLabel.CENTER);
    label.setVerticalTextPosition(JLabel.TOP);
    label.setHorizontalAlignment(JLabel.CENTER);    

    JLabel label2 = new JLabel("Menus");
    label2.setFont(menu);
    label2.setForeground(ColorPicker.blueDark());
    label2.setHorizontalTextPosition(JLabel.CENTER);
    label2.setVerticalTextPosition(JLabel.BOTTOM);
    label2.setHorizontalAlignment(JLabel.CENTER);  
    label2.setOpaque(false);

    topPanel.add(label, BorderLayout.NORTH);
    
    JPanel botContainer = new JPanel(new BorderLayout());
    botContainer.setOpaque(false);
    botContainer.setBackground(new Color(255, 0, 0, 20));
    // botContainer.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.black));
    
    JPanel botPanel = new JPanel();
    botPanel.setLayout(new GridLayout(2, 2, 30, 20));
    botPanel.setOpaque(false);
    botPanel.setBackground(new Color(255, 0, 0, 20));
    botPanel.setBorder(BorderFactory.createLineBorder(ColorPicker.yellow(), 30));
    
    insertButton.setBackground(ColorPicker.yellowDarker(0));
    insertButton.setFocusable(false);
    insertButton.setFont(text);
    insertButton.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, ColorPicker.yellowDarker(2)));
    insertButton.addActionListener(this);

    viewButton.setBackground(ColorPicker.yellowDarker(0));
    viewButton.setFocusable(false);
    viewButton.setFont(text);
    viewButton.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, ColorPicker.yellowDarker(2)));
    viewButton.addActionListener(this);

    updateButton.setBackground(ColorPicker.yellowDarker(0));
    updateButton.setFocusable(false);
    updateButton.setFont(text);
    updateButton.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, ColorPicker.yellowDarker(2)));
    updateButton.addActionListener(this);

    deleteButton.setBackground(ColorPicker.yellowDarker(0));
    deleteButton.setFocusable(false);
    deleteButton.setFont(text);
    deleteButton.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, ColorPicker.yellowDarker(2)));
    deleteButton.addActionListener(this);

    botPanel.add(insertButton);
    botPanel.add(viewButton);
    botPanel.add(updateButton);
    botPanel.add(deleteButton);
    botContainer.add(label2, BorderLayout.NORTH);
    botContainer.add(botPanel, BorderLayout.CENTER);

    add(topPanel);
    add(botContainer);
    setLocationRelativeTo(null);
    setVisible(true);
  }
  @Override
  public void actionPerformed(ActionEvent e) {
    if(e.getSource().equals(buttons[0])) {
      dispose();
      new InsertMenu();
    } else if(e.getSource().equals(buttons[1])) {
      dispose();
      new ViewMenu();
    } else if(e.getSource().equals(buttons[2])) {
      dispose();
      new UpdateMenu();
    } else if(e.getSource().equals(buttons[3])) {
      dispose();
      new DeleteMenu();
    }  
  }
}
