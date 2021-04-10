import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;

public class InsertMenu extends JFrame implements ActionListener {

  /**
   *
   */
  private static final long serialVersionUID = 1L;

  private MatteBorder outBorder = BorderFactory.createMatteBorder(2, 2, 2, 2, ColorPicker.blueDark());
  private Border inBorder = BorderFactory.createEmptyBorder(0, 10, 0, 10);

  private Vector<Integer> numbers = new Vector<>();

  private JLabel title = new JLabel("Insert New Menu");

  private JLabel codeLabel = new JLabel("Menu code");
  private JLabel nameLabel = new JLabel("Menu Name");
  private JLabel priceLabel = new JLabel("Menu Price");
  private JLabel stockLabel = new JLabel("Menu Stock");
  
  private JLabel code = new JLabel("BC-000");
  private JComboBox<Integer> stockBox;
  private JTextField stockField = new JTextField();
  private JTextField nameField = new JTextField();
  private JTextField priceField = new JTextField();
  
  private JButton changeTypeButton = new JButton("❌"); // ✔ ❌
  private JButton confirmButton = new JButton("confirm");
  private JButton resetButton = new JButton("reset");
  private JButton backButton = new JButton("back");

  private JPanel titlePanel = new JPanel(new BorderLayout());
  private JPanel formPanel = new JPanel(new FlowLayout(FlowLayout.LEADING, 15, 10));
  private JPanel contentPanel = new JPanel(new BorderLayout());
  private JPanel botPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 0));
  
  public InsertMenu() {
    initFrame();
    initComponents();
    initPanels();
    addComponentToPanel();
    add(titlePanel, BorderLayout.NORTH);
    add(contentPanel, BorderLayout.CENTER);
    add(botPanel, BorderLayout.SOUTH);
    pack();
    setLocationRelativeTo(null);
    setVisible(true);
  }
  public void initFrame() {
    setTitle("Boba-Cool Insert Menu");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setResizable(false);
    setLayout(new BorderLayout());
    setIconImage(Main.icon.getImage());
    getContentPane().setBackground(ColorPicker.blueLight());
  }
  public void initComponents() {
    title.setFont(Main.title);
    title.setHorizontalAlignment(JLabel.CENTER);
    
    codeLabel.setFont(Main.text);
    codeLabel.setHorizontalAlignment(JLabel.LEFT);
    codeLabel.setPreferredSize(new Dimension(150, 50));
    
    Random rand = new Random();
    char[] chars = new char[6];
    boolean valid = true;
    chars[0] = 'B';
    chars[1] = 'C';
    chars[2] = '-';
    do {
      valid = true;
      for(int i = 3; i < 6; i++) {
        chars[i] = (char) (rand.nextInt(10) + '0');
      }
      for(Boba boba : Main.bobas) {
        if(boba.getName().compareTo(String.valueOf(chars)) == 0) {
          valid = false;
          break;
        }
      }
    } while(!valid);

    code.setText(String.valueOf(chars));
    code.setFont(Main.menu);
    code.setHorizontalAlignment(JLabel.LEFT);
    code.setPreferredSize(new Dimension(250, 50));
    
    nameLabel.setFont(Main.text);
    nameLabel.setHorizontalAlignment(JLabel.LEFT);
    nameLabel.setPreferredSize(new Dimension(150, 50));
    
    priceLabel.setFont(Main.text);
    priceLabel.setHorizontalAlignment(JLabel.LEFT);
    priceLabel.setPreferredSize(new Dimension(150, 50));
    
    stockLabel.setFont(Main.text);
    stockLabel.setHorizontalAlignment(JLabel.LEFT);
    stockLabel.setPreferredSize(new Dimension(150, 50));
    
    
    nameField.setPreferredSize(new Dimension(250, 50));
    nameField.setFont(Main.inputText);
    nameField.setBorder(BorderFactory.createCompoundBorder(outBorder, inBorder));
    
    priceField.setPreferredSize(new Dimension(250, 50));
    priceField.setFont(Main.inputText);
    priceField.setBorder(BorderFactory.createCompoundBorder(outBorder, inBorder));
    priceField.addKeyListener(new KeyAdapter(){
      public void keyTyped(KeyEvent e) {
        char input = e.getKeyChar();
        if(!(input >= '0' && input <= '9') && input != '\b') e.consume();
      }
    });
    
    changeTypeButton.setFont(new Font(null, Font.PLAIN, 30));
    changeTypeButton.setFocusable(false);
    changeTypeButton.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, ColorPicker.blueDark()));
    changeTypeButton.addActionListener(this);
    changeTypeButton.setBackground(new Color(0xE0F8FD));
    changeTypeButton.setPreferredSize(new Dimension(35, 35));
    
    numbers.add(-1);
    for(int i = 0; i < 10; i++) numbers.add(i);
    
    stockBox = new JComboBox<Integer>(numbers);
    stockBox.setFont(Main.inputText);
    stockBox.setBorder(outBorder);
    stockBox.setPreferredSize(new Dimension(50, 50));
    ((JLabel)stockBox.getRenderer()).setHorizontalAlignment(JLabel.CENTER);
    stockBox.setVisible(true);
    
    stockField.setPreferredSize(new Dimension(200, 50));
    stockField.setFont(Main.inputText);
    stockField.setBorder(BorderFactory.createCompoundBorder(outBorder, inBorder));
    stockField.setVisible(false);
    stockField.addKeyListener(new KeyAdapter(){
      public void keyTyped(KeyEvent e) {
        char input = e.getKeyChar();
        if(!(input >= '0' && input <= '9') && input != '\b') e.consume();
      }
    });
    
    confirmButton.setFont(Main.menu);
    confirmButton.setBackground(new Color(0xE0F8FD));
    confirmButton.setBorder(BorderFactory.createCompoundBorder(outBorder, inBorder));
    confirmButton.setPreferredSize(new Dimension(150, 60));
    confirmButton.setFocusable(false);
    confirmButton.addActionListener(this);
    
    resetButton.setFont(Main.menu);
    resetButton.setBackground(new Color(0xE0F8FD));
    resetButton.setBorder(BorderFactory.createCompoundBorder(outBorder, inBorder));
    resetButton.setPreferredSize(new Dimension(150, 60));
    resetButton.setFocusable(false);
    resetButton.addActionListener(this);
    
    backButton.setFont(Main.menu);
    backButton.setBackground(new Color(0xE0F8FD));
    backButton.setBorder(BorderFactory.createCompoundBorder(outBorder, inBorder));
    backButton.setPreferredSize(new Dimension(150, 60));
    backButton.setFocusable(false);
    backButton.addActionListener(this);
  }
  public void initPanels() {
    titlePanel.setPreferredSize(new Dimension(500, 75));
    // titlePanel.setBackground(new Color(0xC2F1FB));
    titlePanel.setOpaque(false);
    titlePanel.add(title, BorderLayout.SOUTH);
    
    contentPanel.setPreferredSize(new Dimension(500, 275));
    contentPanel.setBorder(BorderFactory.createEmptyBorder(15, 30, 15, 30));
    contentPanel.setOpaque(false);
    
    botPanel.setPreferredSize(new Dimension(500, 75));
    // botPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
    botPanel.setOpaque(false);
    
    formPanel.setOpaque(false);
   }
  public void addComponentToPanel() {
    formPanel.add(codeLabel);
    formPanel.add(code);
    formPanel.add(nameLabel);
    formPanel.add(nameField);
    formPanel.add(priceLabel);
    formPanel.add(priceField);
    formPanel.add(stockLabel);
    formPanel.add(changeTypeButton);
    formPanel.add(stockBox);
    formPanel.add(stockField);
    // contentPanel.add(code, BorderLayout.NORTH);
    contentPanel.add(formPanel, BorderLayout.CENTER);
    botPanel.add(resetButton);
    botPanel.add(confirmButton);
    botPanel.add(backButton);
  }
  public void reset() {
    dispose();
    new InsertMenu();
  }
  public boolean submit() {
    String name = "", kode = "";
    int price = -1, stock = -1;
    name = nameField.getText();
    kode = code.getText();
    if(changeTypeButton.getText().compareTo("❌") == 0) stock = (int) stockBox.getSelectedItem();
    else {
      stock = Integer.parseInt(stockField.getText());
    }
    if(name == "" || kode == "" || priceField.getText() == "" || stock == -1) {
        JOptionPane.showMessageDialog(null, "Please input valid data!", "Invalid data", JOptionPane.INFORMATION_MESSAGE);
        return false;
    }
    price = Integer.parseInt(priceField.getText());

    
    String str = "Name\t: " + name + "\nPrice\t: " + price + "\nStock\t: " + stock;
    int choose = JOptionPane.showOptionDialog(
      null, 
      str,
      "Confirm",
      JOptionPane.YES_NO_OPTION, 
      JOptionPane.WARNING_MESSAGE, 
      null, 
      null, 
      0);
    
    if(choose == 1)
      return false;
    System.out.println(kode);
    System.out.println(name);
    System.out.println(price);
    System.out.println(stock);
    Main.bobas.add(new Boba(kode, name, price, stock));
    return true;
  }
  @Override
  public void actionPerformed(ActionEvent e) {
    if(e.getSource() == changeTypeButton) {
      if(changeTypeButton.getText().compareTo("❌") == 0) {
        stockBox.setSelectedIndex(0);
        stockField.setVisible(true);
        stockBox.setVisible(false);
        changeTypeButton.setText("✔");
      } else {
        stockField.setText("");
        stockField.setVisible(false);
        stockBox.setVisible(true);
        changeTypeButton.setText("❌");
      }
    } else if(e.getSource() == backButton) {
      dispose();
      new MainMenu();
    } else if(e.getSource() == resetButton) {
      reset();
    } else if(e.getSource() == confirmButton) {
      if(submit()) reset();
    }
    
  }
}
