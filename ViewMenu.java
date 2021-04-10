import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;

public class ViewMenu extends JFrame implements ActionListener{

  /**
   *
   */
  private static final long serialVersionUID = 1L;

  private MatteBorder outBorder = BorderFactory.createMatteBorder(2, 2, 2, 2, ColorPicker.blueDark());
  private Border inBorder = BorderFactory.createEmptyBorder(0, 10, 0, 10);

  private JLabel title = new JLabel("Menu List");
  private JTable table;
  private JButton backButton = new JButton("Back");

  private JPanel titlePanel = new JPanel(new BorderLayout());
  private JPanel buttonPanel = new JPanel(new BorderLayout());
  private JScrollPane scrollPanel;

  public ViewMenu() {
    initFrame();
    initComponents();
    initPanels();
    addComponentToPanel();
    add(titlePanel, BorderLayout.NORTH);
    add(scrollPanel, BorderLayout.CENTER);
    add(buttonPanel, BorderLayout.SOUTH);
    pack();
    setLocationRelativeTo(null);
    setVisible(true);
    
  }
  public void initFrame() {
    setTitle("Boba-Cool Menu List");
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
    // Main.bobas.add(new Boba("BC-123", "BOBA BOBA BOBA", 123, 2));
    // Main.bobas.add(new Boba("BC-123", "BOBA BOBA BOBA", 200000, 2));
    // Main.bobas.add(new Boba("BC-123", "BOBA BOBA BOBA", 123, 2));
    // Main.bobas.add(new Boba("BC-123", "BOBA BOBA BOBA", 123, 2));
    // Main.bobas.add(new Boba("BC-123", "BOBA BOBA BOBA", 123, 2));
    // Main.bobas.add(new Boba("BC-123", "BOBA BOBA BOBA", 123, 2));
    // Main.bobas.add(new Boba("BC-123", "BOBA BOBA BOBA", 123, 2));
    // Main.bobas.add(new Boba("BC-123", "BOBA BOBA BOBA", 123, 2));
    // Main.bobas.add(new Boba("BC-123", "BOBA BOBA BOBA", 123, 2));
    // Main.bobas.add(new Boba("BC-123", "BOBA BOBA BOBA", 123, 2));
    // Main.bobas.add(new Boba("BC-123", "BOBA BOBA BOBA", 123, 2));
    // Main.bobas.add(new Boba("BC-123", "BOBA BOBA BOBA", 123, 2));
    // Main.bobas.add(new Boba("BC-123", "BOBA BOBA BOBA", 123, 2));
    

    Object[][] data = new Object[Main.bobas.size()][4];
    for(int i = 0; i < Main.bobas.size(); i++) {
      Boba boba = Main.bobas.get(i);
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
    table.setPreferredScrollableViewportSize(new Dimension(600, 300));
    // table.setCellSelectionEnabled(false);
    // table.setRowSelectionAllowed(false);
    // table.setColumnSelectionAllowed(false);

    backButton.setFont(Main.menu);
    backButton.setBackground(new Color(0xE0F8FD));
    backButton.setBorder(BorderFactory.createCompoundBorder(outBorder, inBorder));
    backButton.setPreferredSize(new Dimension(150, 60));
    backButton.setFocusable(false);
    backButton.addActionListener(this);
    
  }
  public void initPanels() {
    titlePanel.setPreferredSize(new Dimension(600, 90));
    titlePanel.setOpaque(false);

    scrollPanel = new JScrollPane(table);
    scrollPanel.setOpaque(false);
    scrollPanel.setBorder(BorderFactory.createEmptyBorder());
    
    buttonPanel.setPreferredSize(new Dimension(600, 100));
    buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 80, 20, 80));
    // buttonPanel.setBorder(BorderFactory.createMatteBorder(10, 20, 10, 20, Color.white));
    // buttonPanel.setBackground(Color.black);
    buttonPanel.setOpaque(false); 
  }
  public void addComponentToPanel() {
    titlePanel.add(title, BorderLayout.CENTER);
    buttonPanel.add(backButton, BorderLayout.CENTER);
  }
  @Override
  public void actionPerformed(ActionEvent e) {
    if(e.getSource() == backButton) {
      dispose();
      new MainMenu();
    }
    
  }
}
