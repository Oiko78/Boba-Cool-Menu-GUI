import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainMenu extends JFrame implements ActionListener{
  /**
   *
   */
  private static final long serialVersionUID = 1L;

  private JLabel title = new JLabel("Boba - Cool");
  private JLabel subTitle = new JLabel("Menus");
  private JButton insertButton = new JButton("Insert Menu");
  private JButton viewButton = new JButton("View menus");
  private JButton updateButton = new JButton("Update menu");
  private JButton deleteButton = new JButton("Delete menu");
  private JPanel topPanel = new JPanel();
  private JPanel botContainer = new JPanel(new BorderLayout());
  private JPanel botPanel = new JPanel();
  
  private JButton[] buttons = {insertButton, viewButton, updateButton, deleteButton};
  
  public MainMenu() {
    initFrame();
    initComponents();
    initPanels();  
    addComponentToPanel(); 
    
    add(topPanel, BorderLayout.NORTH);
    add(botContainer, BorderLayout.CENTER);
    pack();
    setLocationRelativeTo(null);
    setVisible(true);
  }
  public void initFrame() {
    setTitle("Boba-Cool Main Menu");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setResizable(false);
    setLayout(new BorderLayout());
    setIconImage(Main.icon.getImage());
    getContentPane().setBackground(ColorPicker.yellow());
  }
  public void initComponents() {
    title.setFont(Main.title);
    title.setForeground(ColorPicker.blueDark());
    title.setIcon(Main.smallImage);
    title.setHorizontalTextPosition(JLabel.CENTER);
    title.setVerticalTextPosition(JLabel.TOP);
    title.setHorizontalAlignment(JLabel.CENTER); 
    
    
    subTitle.setFont(Main.menu);
    subTitle.setForeground(ColorPicker.blueDark());
    subTitle.setHorizontalTextPosition(JLabel.CENTER);
    subTitle.setVerticalTextPosition(JLabel.BOTTOM);
    subTitle.setHorizontalAlignment(JLabel.CENTER);  
    subTitle.setOpaque(false);

    
    insertButton.setBackground(ColorPicker.yellowDarker(0));
    insertButton.setFocusable(false);
    insertButton.setFont(Main.text);
    insertButton.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, ColorPicker.yellowDarker(2)));
    insertButton.addActionListener(this);

    viewButton.setBackground(ColorPicker.yellowDarker(0));
    viewButton.setFocusable(false);
    viewButton.setFont(Main.text);
    viewButton.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, ColorPicker.yellowDarker(2)));
    viewButton.addActionListener(this);

    updateButton.setBackground(ColorPicker.yellowDarker(0));
    updateButton.setFocusable(false);
    updateButton.setFont(Main.text);
    updateButton.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, ColorPicker.yellowDarker(2)));
    updateButton.addActionListener(this);

    deleteButton.setBackground(ColorPicker.yellowDarker(0));
    deleteButton.setFocusable(false);
    deleteButton.setFont(Main.text);
    deleteButton.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, ColorPicker.yellowDarker(2)));
    deleteButton.addActionListener(this);
  }
  public void initPanels() {
    topPanel.setLayout(new BorderLayout());
    topPanel.setOpaque(false);
    topPanel.setBackground(new Color(255, 0, 0, 20));
    topPanel.setBorder(BorderFactory.createLineBorder(ColorPicker.yellow(), 15));
    
    botContainer.setOpaque(false);
    botContainer.setPreferredSize(new Dimension(500, 300));
    botContainer.setBackground(new Color(255, 0, 0, 20));
    botContainer.setBorder(BorderFactory.createLineBorder(ColorPicker.yellow(), 15));
    
    botPanel.setLayout(new GridLayout(2, 2, 20, 20));
    botPanel.setOpaque(false);
    botPanel.setBackground(new Color(255, 0, 0, 20));
    botPanel.setBorder(BorderFactory.createLineBorder(ColorPicker.yellow(), 15));
  }
  public void addComponentToPanel() {
    topPanel.add(title, BorderLayout.NORTH);
    botPanel.add(insertButton);
    botPanel.add(viewButton);
    botPanel.add(updateButton);
    botPanel.add(deleteButton);
    botContainer.add(subTitle, BorderLayout.NORTH);
    botContainer.add(botPanel, BorderLayout.CENTER);
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
