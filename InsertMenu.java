import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InsertMenu extends JFrame {

  /**
   *
   */
  private static final long serialVersionUID = 1L;
  
  public InsertMenu() {
    setTitle("Boba-Cool Insert Menu");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setResizable(false);
    setLayout(new BorderLayout());
    setIconImage(Main.icon.getImage());
    getContentPane().setBackground(ColorPicker.blueLight());
    

    JLabel title = new JLabel("Insert New Menu");
    title.setFont(Main.title);
    title.setHorizontalAlignment(JLabel.CENTER);

    JPanel titlePanel = new JPanel(new BorderLayout());
    titlePanel.setPreferredSize(new Dimension(500, 100));
    titlePanel.setBackground(new Color(0xC2F1FB));
    // titlePanel.setOpaque(false);
    titlePanel.add(title, BorderLayout.CENTER);

    JLabel code = new JLabel("BC - 201");
    code.setFont(Main.menu);
    code.setHorizontalAlignment(JLabel.CENTER);
    code.setBackground(Color.yellow);
    code.setOpaque(true);

    JPanel formPanel = new JPanel(new GridLayout(3, 2, 10, 10));
    formPanel.setOpaque(false);
    formPanel.add(new JButton("a"));
    formPanel.add(new JButton("a"));
    formPanel.add(new JButton("a"));
    formPanel.add(new JButton("a"));
    formPanel.add(new JButton("a"));
    formPanel.add(new JButton("a"));
    
    
    
    JPanel contentPanel = new JPanel(new BorderLayout());
    contentPanel.setPreferredSize(new Dimension(500, 400));
    contentPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
    contentPanel.setOpaque(false);
    contentPanel.add(code, BorderLayout.NORTH);
    contentPanel.add(formPanel, BorderLayout.CENTER);


    add(titlePanel, BorderLayout.NORTH);
    add(contentPanel, BorderLayout.CENTER);
    pack();
    setLocationRelativeTo(null);
    setVisible(true);
  }
}
