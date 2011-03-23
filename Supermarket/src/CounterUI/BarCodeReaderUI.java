
package CounterUI;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;

@SuppressWarnings("serial")
public class BarCodeReaderUI extends JFrame {
  private GridBagLayout gridBagLayout1 = new GridBagLayout();
  private JButton btProduct1 = new JButton();
  
  private static final String IMAGE_FOLDER ="barcodes" + File.separator;

  private ImageIcon iconProduct1 = new ImageIcon(IMAGE_FOLDER+"Product1.jpg");
  private ImageIcon iconProduct2 = new ImageIcon(IMAGE_FOLDER+"Product2.jpg");
  private ImageIcon iconProduct3 = new ImageIcon(IMAGE_FOLDER+"Product3.jpg");
  private ImageIcon iconCustomer1 = new ImageIcon(IMAGE_FOLDER+"Customer1.jpg");
  private ImageIcon iconCustomer2 = new ImageIcon(IMAGE_FOLDER+"Customer2.jpg");
  private JButton btProduct2 = new JButton();
  private JButton btProduct3 = new JButton();
  private JButton btCustomer1 = new JButton();
  private JButton btCustomer2 = new JButton();

  public BarCodeReaderUI() {
    try {
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
    this.setSize(250,400);
  }
  private void jbInit() throws Exception {
    btProduct1.setMaximumSize(new Dimension(235, 61));
    btProduct1.setMinimumSize(new Dimension(235, 61));
    btProduct1.setPreferredSize(new Dimension(235, 61));
    btProduct1.setActionCommand("Product1");
    btProduct1.setIcon(iconProduct1);
    btProduct1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        readCode_actionPerformed(e);
      }
    });
    btProduct2.setActionCommand("Product2");
    btProduct2.setIcon(iconProduct2);
    btProduct2.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        readCode_actionPerformed(e);
      }
    });
    btProduct3.setMaximumSize(new Dimension(235, 61));
    btProduct3.setMinimumSize(new Dimension(235, 61));
    btProduct3.setPreferredSize(new Dimension(235, 61));
    btProduct3.setActionCommand("Product3");
    btProduct3.setIcon(iconProduct3);
    btProduct3.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        readCode_actionPerformed(e);
      }
    });
    btCustomer1.setActionCommand("Customer1");
    btCustomer1.setIcon(iconCustomer1);
    btCustomer1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        readCode_actionPerformed(e);
      }
    });
    btCustomer2.setActionCommand("Customer2");
    btCustomer2.setIcon(iconCustomer2);
    btCustomer2.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        readCode_actionPerformed(e);
      }
    });
    this.getContentPane().setLayout(gridBagLayout1);
    this.setTitle("Bar Code Reader");
    this.getContentPane().add(btProduct1,  new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    this.getContentPane().add(btProduct2,   new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    this.getContentPane().add(btProduct3,   new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    this.getContentPane().add(btCustomer1,  new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    this.getContentPane().add(btCustomer2,  new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
  }

  private BarCodeListener listener;
  public void setListener(BarCodeListener newListener){
    listener = newListener;
  }

  void readCode_actionPerformed(ActionEvent e) {
    if(listener!=null){
      listener.readValue(new BarCodeReaderEvent(e.getActionCommand()));
    }
  }

}