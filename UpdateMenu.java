import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;

public class UpdateMenu extends JFrame implements ActionListener, MouseListener {

  /**
   *
   */
  private static final long serialVersionUID = 1L;
  
  private MatteBorder outBorder = BorderFactory.createMatteBorder(2, 2, 2, 2, ColorPicker.blueDark());
  private Border inBorder = BorderFactory.createEmptyBorder(0, 10, 0, 10);

  private Vector<Integer> numbers = new Vector<>();

  private JLabel title = new JLabel("Update Menu");
  private JLabel nameLabel = new JLabel("Menu Name");
  private JLabel priceLabel = new JLabel("Menu Price");
  private JLabel stockLabel = new JLabel("Menu Stock");

  private JTable table;

  private JComboBox<Integer> stockBox;
  private JTextField stockField = new JTextField();
  private JTextField nameField = new JTextField();
  private JTextField priceField = new JTextField();

  private JButton changeTypeButton = new JButton("❌"); // ✔ ❌
  private JButton updateButton = new JButton("update");
  private JButton backButton = new JButton("back");

  private JPanel topPanel = new JPanel(new BorderLayout());
  private JPanel formPanel = new JPanel(new FlowLayout(FlowLayout.LEADING, 15, 10));
  private JPanel botPanel = new JPanel(new BorderLayout());
  private JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 5));
  private JScrollPane scrollPane;

  public UpdateMenu() {
    initFrame();
    initComponents();
    initPanels();
    addComponentToPanel();
    add(topPanel, BorderLayout.NORTH);
    add(scrollPane, BorderLayout.CENTER);
    add(botPanel, BorderLayout.SOUTH);
    pack();
    setInputFieldDisabled();
    setLocationRelativeTo(null);
    setVisible(true);
  }
  public void initFrame() {
    setTitle("Boba-Cool Update Menu");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setResizable(false);
    setLayout(new BorderLayout());
    setIconImage(Main.icon.getImage());
    getContentPane().setBackground(ColorPicker.blueLight());
  }
  public void initComponents() {
    title.setFont(Main.title);
    title.setHorizontalAlignment(JLabel.CENTER);
    title.setVerticalAlignment(JLabel.CENTER);

    String[] colName = {"Code", "Name", "Price", "Stock"};
    Object[][] data = new Object[Main.bobas.size()][4];
    for(int i = 0; i < Main.bobas.size(); i++) {
      dao.Boba boba = Main.bobas.get(i);
      data[i][0] = boba.getCode();
      data[i][1] = boba.getName();
      data[i][2] = boba.getPrice();
      data[i][3] = boba.getStock();
    }
    table = new JTable(data, colName) {
      public boolean isCellEditable(int row, int column) {
				return false;
			};
    };
    DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
    DefaultTableCellRenderer rendererTable = new DefaultTableCellRenderer();
    renderer.setHorizontalAlignment(JLabel.CENTER);
    renderer.setVerticalAlignment(JLabel.CENTER);
    rendererTable.setVerticalAlignment(JLabel.CENTER);
    rendererTable.setHorizontalAlignment(JLabel.CENTER);
    rendererTable.setBackground(ColorPicker.blueDark());
    rendererTable.setForeground(Color.white);
    rendererTable.setFont(Main.tableTitle);
    for(int i = 0; i < table.getColumnCount(); i++) {
      table.setDefaultRenderer(table.getColumnClass(i), renderer);  
    }
    table.getTableHeader().setFont(Main.tableTitle);
    table.getTableHeader().setBackground(ColorPicker.blueDark());
    table.getTableHeader().setForeground(Color.white);
    table.getColumnModel().getColumn(0).setMaxWidth(100);
    table.getColumnModel().getColumn(1).setMaxWidth(320);
    table.getColumnModel().getColumn(2).setMaxWidth(100);
    table.getColumnModel().getColumn(3).setMaxWidth(80);
    table.setRowHeight(45);
    table.setBackground(ColorPicker.blueLight());
    table.setFont(Main.table);
    table.setShowHorizontalLines(false);
    table.setShowVerticalLines(false);
    table.setFillsViewportHeight(true);
    table.setPreferredScrollableViewportSize(new Dimension(600, 200));
    table.setDragEnabled(false);
    table.setFocusable(false);
    table.addMouseListener(this);

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

    updateButton.setFont(Main.menu);
    updateButton.setBackground(new Color(0xE0F8FD));
    updateButton.setBorder(BorderFactory.createCompoundBorder(outBorder, inBorder));
    updateButton.setPreferredSize(new Dimension(230, 70));
    updateButton.setFocusable(false);
    updateButton.addActionListener(this);

    backButton.setFont(Main.menu);
    backButton.setBackground(new Color(0xE0F8FD));
    backButton.setBorder(BorderFactory.createCompoundBorder(outBorder, inBorder));
    backButton.setPreferredSize(new Dimension(230, 70));
    backButton.setFocusable(false);
    backButton.addActionListener(this);
  }
  public void initPanels() {
    topPanel.setPreferredSize(new Dimension(600, 90));
    topPanel.setOpaque(false);

    scrollPane = new JScrollPane(table);
    scrollPane.setOpaque(false);
    scrollPane.setBorder(BorderFactory.createEmptyBorder());

    formPanel.setOpaque(false);
    formPanel.setBorder(BorderFactory.createEmptyBorder(0, 40, 0, 30));
    formPanel.setPreferredSize(new Dimension(500, 150));
    // formPanel.setBackground(Color.black);
    
    buttonPanel.setPreferredSize(new Dimension(600, 100));
    buttonPanel.setOpaque(false);
    buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0));

    botPanel.setPreferredSize(new Dimension(600, 330));
    botPanel.setBorder(BorderFactory.createEmptyBorder(15, 30, 15, 30));
    botPanel.setOpaque(false);
  }
  public void addComponentToPanel() {
    topPanel.add(title, BorderLayout.CENTER);

    formPanel.add(nameLabel);
    formPanel.add(nameField);
    formPanel.add(priceLabel);
    formPanel.add(priceField);
    formPanel.add(stockLabel);
    formPanel.add(changeTypeButton);
    formPanel.add(stockBox);
    formPanel.add(stockField);

    buttonPanel.add(updateButton);
    buttonPanel.add(backButton);

    botPanel.add(formPanel, BorderLayout.CENTER);
    botPanel.add(buttonPanel, BorderLayout.SOUTH);
  }
  
  public boolean valid() {
    if(nameField.getText().isBlank() ||
       priceField.getText().isBlank() ||
       (changeTypeButton.getText() == "✔" && stockField.getText().isBlank())) {
          JOptionPane.showMessageDialog(null, "Please input valid data!", "Invalid data", JOptionPane.INFORMATION_MESSAGE);
          return false;
         }
    return true;
  }
  public void updateDatabase(int idx, String name, int price, int stock) {
    Main.bobas.get(idx).update(name, price, stock);
  }
  public void updateTableData(int idx, String name, int price, int stock) {
    table.setValueAt(name, idx, 1);
    table.setValueAt(price, idx, 2);
    table.setValueAt(stock, idx, 3);
  }
  public void setInputFieldDisabled() {
    nameField.setEditable(false);
    priceField.setEditable(false);
    stockField.setEditable(false);
    stockBox.setEnabled(false);
  }
  public void setInputFieldEditable() {
    nameField.setEditable(true);
    priceField.setEditable(true);
    stockField.setEditable(true);
    stockBox.setEnabled(true);
  }
  public void changeFieldText(dao.Boba boba) {
    nameField.setText(boba.getName());
    priceField.setText(Integer.toString(boba.getPrice()));
    if(boba.getStock() <= 9) {
      stockBox.setSelectedIndex(boba.getStock());
      stockBox.setVisible(true);
      stockField.setText("");
      stockField.setVisible(false);
      changeTypeButton.setText("❌");
    } else {
      stockField.setText(Integer.toString(boba.getStock()));
      stockField.setVisible(true);
      stockBox.setSelectedIndex(0);
      stockBox.setVisible(false);
      changeTypeButton.setText("✔");
    }
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
    } 
    if(e.getSource() == backButton) {
      dispose();
      new MainMenu();
    }
    if(e.getSource() == updateButton) {
      int idx = table.getSelectedRow();
      if(valid()) {
        String name = nameField.getText();
        int price = Integer.parseInt(priceField.getText());
        int stock = -1;
        if(changeTypeButton.getText().compareTo("❌") == 0) {
          stock = (int) stockBox.getSelectedItem();
        } else {
          stock = Integer.parseInt(stockField.getText());
        }
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
          return;
        updateTableData(idx, name, price, stock);
        updateDatabase(idx, name, price, stock);
        setInputFieldDisabled();
      } 
    }
  }
  @Override
  public void mouseClicked(MouseEvent e) {
    if(e.getComponent().equals(table)) {
      int idx = table.getSelectedRow();
      if(idx != -1) {
        setInputFieldEditable();
        changeFieldText(Main.bobas.get(idx));
      }
    }
  }
  @Override
  public void mousePressed(MouseEvent e) {
    // TODO Auto-generated method stub
    
  }
  @Override
  public void mouseReleased(MouseEvent e) {
    // TODO Auto-generated method stub
    
  }
  @Override
  public void mouseEntered(MouseEvent e) {
    // TODO Auto-generated method stub
    
  }
  @Override
  public void mouseExited(MouseEvent e) {
    // TODO Auto-generated method stub
    
  }
  
}
