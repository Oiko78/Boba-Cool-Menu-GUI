import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class DeleteMenu extends JFrame implements ActionListener{
  /**
   *
   */
  private static final long serialVersionUID = 1L;
  
  private MatteBorder outBorder = BorderFactory.createMatteBorder(2, 2, 2, 2, ColorPicker.blueDark());
  private Border inBorder = BorderFactory.createEmptyBorder(0, 10, 0, 10);

  private Vector<Integer> numbers = new Vector<>();

  private JLabel title = new JLabel("Delete Menu");

  private JTable table;

  private JComboBox<Integer> stockBox;

  private JButton deleteButton = new JButton("delete");
  private JButton backButton = new JButton("back");

  private JPanel topPanel = new JPanel(new BorderLayout());
  private JPanel botPanel = new JPanel(new BorderLayout());
  private JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 5));
  private JScrollPane scrollPane;

  private DefaultTableModel model;

  public DeleteMenu() {
    initFrame();
    initComponents();
    initPanels();
    addComponentToPanel();
    add(topPanel, BorderLayout.NORTH);
    add(scrollPane, BorderLayout.CENTER);
    add(botPanel, BorderLayout.SOUTH);
    pack();
    setLocationRelativeTo(null);
    setVisible(true);
  }
  public void initFrame() {
    setTitle("Boba-Cool delete Menu");
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
    model = new DefaultTableModel(data, colName);
    table = new JTable(model) {
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
    table.setDragEnabled(false);
    table.setFocusable(false);

    for(int i = 0; i < 10; i++) numbers.add(i);
    
    stockBox = new JComboBox<Integer>(numbers);
    stockBox.setFont(Main.inputText);
    stockBox.setBorder(outBorder);
    stockBox.setPreferredSize(new Dimension(50, 50));
    ((JLabel)stockBox.getRenderer()).setHorizontalAlignment(JLabel.CENTER);
    stockBox.setVisible(true);

    deleteButton.setFont(Main.menu);
    deleteButton.setBackground(new Color(0xE0F8FD));
    deleteButton.setBorder(BorderFactory.createCompoundBorder(outBorder, inBorder));
    deleteButton.setPreferredSize(new Dimension(230, 70));
    deleteButton.setFocusable(false);
    deleteButton.addActionListener(this);

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
    
    buttonPanel.setPreferredSize(new Dimension(600, 100));
    buttonPanel.setOpaque(false);
    buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0));

    botPanel.setPreferredSize(new Dimension(600, 130));
    botPanel.setBorder(BorderFactory.createEmptyBorder(15, 30, 15, 30));
    botPanel.setOpaque(false);
  }
  public void addComponentToPanel() {
    topPanel.add(title, BorderLayout.CENTER);

    buttonPanel.add(deleteButton);
    buttonPanel.add(backButton);

    botPanel.add(buttonPanel, BorderLayout.CENTER);
  }
  
  public void updateDatabase(int idx) {
    Main.bobas.remove(idx);;
  }
  public void updateTableData(int idx) {
    model.removeRow(idx);
  }
  
  @Override
  public void actionPerformed(ActionEvent e) {
    if(e.getSource() == backButton) {
      dispose();
      new MainMenu();
    }
    if(e.getSource() == deleteButton) {
      int idx = table.getSelectedRow();
      System.out.println(idx);
      if(idx != -1) {
        updateTableData(idx);
        updateDatabase(idx);
      }
    } 
  }
}
