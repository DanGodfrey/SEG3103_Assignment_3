
package CounterUI;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import Counter.MarketProxy;

@SuppressWarnings("serial")
public class CounterFrame
    extends JFrame
    implements BarCodeListener {
  private GridBagLayout gridBagLayout1 = new GridBagLayout();
  private JToggleButton ConnectButton = new JToggleButton();

  private JTextField messageLine = new JTextField();
  private JPanel panelKeyboard = new JPanel();
  private GridLayout gridLayout1 = new GridLayout();
  private JButton bt1 = new JButton();
  private JButton bt2 = new JButton();
  private JButton bt3 = new JButton();
  private JButton bt4 = new JButton();
  private JButton bt5 = new JButton();
  private JButton bt6 = new JButton();
  private JButton bt7 = new JButton();
  private JButton bt8 = new JButton();
  private JButton bt9 = new JButton();
  private JButton btDot = new JButton();
  private JButton bt0 = new JButton();
  private JButton btCanc = new JButton();
  private JTextField lastInputField = null;
  private JPanel panelMain = new JPanel();
  private GridBagLayout gridBagLayout2 = new GridBagLayout();
  private JLabel jLabel1 = new JLabel();
  private JTextField customerCode = new JTextField();
  private JTextField ItemQuantity = new JTextField();
  private JButton EndButton = new JButton();
  private JButton getPrice = new JButton();
  private JTextField Total = new JTextField();
  private JTextField itemPrice = new JTextField();
  private JTextField customerName = new JTextField();
  private JButton SubmitButton = new JButton();
  private JButton btCustomer = new JButton();
  private JTextField itemName = new JTextField();
  private JLabel jLabel6 = new JLabel();
  private JLabel jLabel5 = new JLabel();
  private JLabel jLabel4 = new JLabel();
  private JTextField ItemCode = new JTextField();
  private JLabel jLabel3 = new JLabel();
  private JLabel jLabel2 = new JLabel();
  private JPanel panelLogin = new JPanel();
  private JLabel jLabel7 = new JLabel();
  private JTextField employeeName = new JTextField();
  private JLabel jLabel8 = new JLabel();
  private JPasswordField employeePassword = new JPasswordField();
  private GridBagLayout gridBagLayout3 = new GridBagLayout();
  private JScrollPane jScrollPane1 = new JScrollPane();
  private JTextArea textCheck = new JTextArea();

  private MarketProxy proxy;

  public CounterFrame(MarketProxy proxy) {
    try {
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
    setSize(500,400);
    panelMain.setVisible(false);
    this.proxy = proxy;
  }

  private void jbInit() throws Exception {
    ConnectButton.setText("Connect");
    ConnectButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        ConnectButton_actionPerformed(e);
      }
    });
    this.getContentPane().setLayout(gridBagLayout1);
    messageLine.setEditable(false);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setTitle("Counter");
    panelKeyboard.setLayout(gridLayout1);
    bt1.setToolTipText("");
    bt1.setText("1");
    bt1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        keypad_actionPerformed(e);
      }
    });
    bt2.setToolTipText("");
    bt2.setText("2");
    bt2.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        keypad_actionPerformed(e);
      }
    });
    bt3.setText("3");
    bt3.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        keypad_actionPerformed(e);
      }
    });
    bt4.setText("4");
    bt4.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        keypad_actionPerformed(e);
      }
    });
    gridLayout1.setColumns(3);
    gridLayout1.setRows(4);
    bt5.setText("5");
    bt5.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        keypad_actionPerformed(e);
      }
    });
    bt6.setToolTipText("");
    bt6.setText("6");
    bt6.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        keypad_actionPerformed(e);
      }
    });
    bt7.setText("7");
    bt7.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        keypad_actionPerformed(e);
      }
    });
    bt8.setText("8");
    bt8.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        keypad_actionPerformed(e);
      }
    });
    bt9.setText("9");
    bt9.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        keypad_actionPerformed(e);
      }
    });
    btDot.setText(".");
    btDot.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        keypad_actionPerformed(e);
      }
    });
    bt0.setText("0");
    bt0.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        keypad_actionPerformed(e);
      }
    });
    btCanc.setText("C");
    btCanc.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        keypad_actionPerformed(e);
      }
    });
    panelMain.setLayout(gridBagLayout2);
    jLabel1.setText("Item code");
    customerCode.setPreferredSize(new Dimension(70, 21));
    customerCode.setToolTipText("");
    customerCode.setText("1");
    customerCode.addFocusListener(new java.awt.event.FocusAdapter() {
      public void focusGained(FocusEvent e) {
        input_focusGained(e);
      }
    });
    ItemQuantity.setMinimumSize(new Dimension(54, 21));
    ItemQuantity.setPreferredSize(new Dimension(100, 21));
    ItemQuantity.setText("1");
    ItemQuantity.addFocusListener(new java.awt.event.FocusAdapter() {
      public void focusGained(FocusEvent e) {
        input_focusGained(e);
      }
    });
    EndButton.setText("End");
    EndButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        EndButton_actionPerformed(e);
      }
    });
    getPrice.setText("Get Price");
    getPrice.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        getPrice_actionPerformed(e);
      }
    });
    Total.setMinimumSize(new Dimension(54, 21));
    Total.setPreferredSize(new Dimension(100, 21));
    Total.setEditable(false);
    Total.setText("0");
    itemPrice.setEnabled(false);
    itemPrice.setMinimumSize(new Dimension(70, 21));
    itemPrice.setPreferredSize(new Dimension(70, 21));
    itemPrice.setEditable(false);
    itemPrice.setText("0");
    customerName.setEnabled(false);
    customerName.setMinimumSize(new Dimension(100, 21));
    customerName.setPreferredSize(new Dimension(100, 21));
    customerName.setEditable(false);
    SubmitButton.setText("Submit");
    SubmitButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        SubmitButton_actionPerformed(e);
      }
    });
    btCustomer.setMaximumSize(new Dimension(10, 27));
    btCustomer.setMinimumSize(new Dimension(110, 27));
    btCustomer.setText("Set Customer");
    btCustomer.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btCustomer_actionPerformed(e);
      }
    });
    itemName.setEnabled(false);
    itemName.setMinimumSize(new Dimension(50, 21));
    itemName.setPreferredSize(new Dimension(100, 21));
    itemName.setEditable(false);
    jLabel6.setToolTipText("");
    jLabel6.setText("Customer code");
    jLabel5.setText("Name");
    jLabel4.setText("Price");
    ItemCode.setText("1");
    ItemCode.addFocusListener(new java.awt.event.FocusAdapter() {
      public void focusGained(FocusEvent e) {
        input_focusGained(e);
      }
    });
    jLabel3.setText("Total");
    jLabel2.setText("Quantity");
    panelKeyboard.setMinimumSize(new Dimension(100, 100));
    panelKeyboard.setPreferredSize(new Dimension(200, 200));
    panelLogin.setLayout(gridBagLayout3);
    jLabel7.setToolTipText("");
    jLabel7.setHorizontalAlignment(SwingConstants.RIGHT);
    jLabel7.setHorizontalTextPosition(SwingConstants.RIGHT);
    jLabel7.setText("code");
    employeeName.setMinimumSize(new Dimension(50, 21));
    employeeName.setPreferredSize(new Dimension(100, 21));
    employeeName.setText("1");
    employeeName.addFocusListener(new java.awt.event.FocusAdapter() {
      public void focusGained(FocusEvent e) {
        input_focusGained(e);
      }
    });
    jLabel8.setHorizontalAlignment(SwingConstants.RIGHT);
    jLabel8.setText("password");
    employeePassword.setMinimumSize(new Dimension(50, 21));
    employeePassword.addFocusListener(new java.awt.event.FocusAdapter() {
      public void focusGained(FocusEvent e) {
        input_focusGained(e);
      }
    });
    this.getContentPane().add(ConnectButton,                                                                   new GridBagConstraints(0, 3, 2, 1, 1.0, 0.0
            ,GridBagConstraints.NORTH, GridBagConstraints.NONE, new Insets(10, 0, 10, 0), 0, 0));
    this.getContentPane().add(messageLine,                                                   new GridBagConstraints(0, 4, 2, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
    this.getContentPane().add(panelKeyboard,                                        new GridBagConstraints(1, 0, 1, 1, 1.0, 0.5
            ,GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
    panelKeyboard.add(bt1, null);
    panelKeyboard.add(bt2, null);
    panelKeyboard.add(bt3, null);
    panelKeyboard.add(bt4, null);
    panelKeyboard.add(bt5, null);
    panelKeyboard.add(bt6, null);
    panelKeyboard.add(bt7, null);
    panelKeyboard.add(bt8, null);
    panelKeyboard.add(bt9, null);
    panelKeyboard.add(btDot, null);
    panelKeyboard.add(bt0, null);
    panelKeyboard.add(btCanc, null);
    this.getContentPane().add(panelMain,                   new GridBagConstraints(0, 0, 1, 2, 1.0, 1.0
            ,GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
    panelMain.add(customerName,                               new GridBagConstraints(1, 1, 1, 1, 1.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
    panelMain.add(jLabel6,                 new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    panelMain.add(customerCode,                 new GridBagConstraints(1, 0, 1, 1, 1.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
    panelMain.add(btCustomer,                     new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    panelMain.add(ItemCode,                new GridBagConstraints(1, 2, 1, 1, 1.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
    panelMain.add(itemPrice,       new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
    panelMain.add(getPrice,      new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    panelMain.add(jLabel4,       new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0
            ,GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    panelMain.add(jLabel5,       new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0
            ,GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    panelMain.add(itemName,       new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
    panelMain.add(ItemQuantity,     new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 4, 0));
    panelMain.add(jLabel2,    new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0
            ,GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    panelMain.add(SubmitButton,    new GridBagConstraints(1, 6, 1, 1, 0.0, 0.0
            ,GridBagConstraints.NORTH, GridBagConstraints.NONE, new Insets(5, 0, 5, 0), 0, 0));
    panelMain.add(Total,     new GridBagConstraints(1, 8, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
    panelMain.add(EndButton,    new GridBagConstraints(2, 8, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    panelMain.add(jLabel1,    new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0
            ,GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    panelMain.add(jLabel3,    new GridBagConstraints(0, 8, 1, 1, 0.0, 0.0
            ,GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    panelMain.add(jScrollPane1,   new GridBagConstraints(0, 7, 3, 1, 1.0, 1.0
            ,GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
    jScrollPane1.getViewport().add(textCheck, null);
    this.getContentPane().add(panelLogin,                 new GridBagConstraints(0, 2, 2, 1, 0.0, 0.0
            ,GridBagConstraints.SOUTH, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    panelLogin.add(jLabel7,     new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 37, 4));
    panelLogin.add(employeeName,      new GridBagConstraints(1, 0, 1, 1, 1.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 1), 0, 0));
    panelLogin.add(employeePassword,      new GridBagConstraints(1, 1, 1, 1, 1.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 1), 0, 0));
    panelLogin.add(jLabel8,   new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 9, 4));
  }

  void SubmitButton_actionPerformed(ActionEvent e) {
    long code = 0;
    long quantity = 0;
    try{
      code = Long.parseLong(ItemCode.getText());
      quantity = Long.parseLong(ItemQuantity.getText());
    }catch(java.lang.NumberFormatException ex){
      // empty fields or invalid numbers
      JOptionPane.showMessageDialog(this,"Wrong item code","Error",JOptionPane.ERROR_MESSAGE);
      return;
    }
    try{
      getPrice_actionPerformed(null);
      double price = Double.parseDouble(itemPrice.getText());
      proxy.buy(code,quantity);
      double total = Double.parseDouble(Total.getText());
      total +=price*quantity;
      Total.setText(Double.toString(total));
      if(quantity>1){
        textCheck.append(itemName.getText().substring(0,8) + ": " + price + "\n");
        textCheck.append(" * " + quantity + "\t\t" + (price*quantity) + "\n");
      }else{
        textCheck.append(itemName.getText() + "\t" + price + "\n");
      }
      itemName.setText("");
      ItemCode.setText("");
      itemPrice.setText("");
    }catch(Exception ex){
      messageLine.setText("Submit failed: " + ex.getMessage());
    }
  }

  void ConnectButton_actionPerformed(ActionEvent e) {
    try{
    if(e.getActionCommand().equals("Connect")){
       long code = Long.parseLong(employeeName.getText());
       String password = new String(employeePassword.getPassword());
      String employee = proxy.connect(code,password);
      if(employee==null){
        messageLine.setText("Wrong code or password.");
      }else{
        messageLine.setText("Connection successfull, welcome " + employee);
        panelMain.setVisible(true);
        panelLogin.setVisible(false);
        employeeName.setText("");
        employeePassword.setText("");
        ConnectButton.setText("Disconnect");
        ConnectButton.setName("Disconnect");
      }
    }else{
      proxy.disconnect();
      messageLine.setText("Disconnection successfull");
      ConnectButton.setText("Connect");
      ConnectButton.setName("Connect");
      panelMain.setVisible(false);
      panelLogin.setVisible(true);
    }
    }catch(Exception ex){
      messageLine.setText(e.getActionCommand() + " failed: " + ex.getMessage());
    }
  }

  void EndButton_actionPerformed(ActionEvent e) {
    try{
      if(ItemCode.getText().length()>0){
        SubmitButton_actionPerformed(null);
      }
      proxy.endTransaction();
      textCheck.append("\nTOTAL\t" + Total.getText());
      textCheck.append("\n-----------\n\n");
      messageLine.setText("Transaction completed");
      Total.setText("0.0");
    }catch(Exception ex){
      messageLine.setText("End transaction failed: " + ex.getMessage());
    }
  }

  void getPrice_actionPerformed(ActionEvent e) {
    try{
      long code = Long.parseLong(ItemCode.getText());
      double price = proxy.getPrice(code);
      String name = proxy.getName(code);
      itemPrice.setText(Double.toString(price));
      itemName.setText(name);
    }catch(Exception ex){
      messageLine.setText("Could not get item information: " + ex.getMessage());
    }
  }

  void btCustomer_actionPerformed(ActionEvent e) {
    try{
      String name = proxy.getCustomer(Long.parseLong(customerCode.getText()));
      customerName.setText(name);
    }catch(Exception ex){
      messageLine.setText("Could not get item information: " + ex.getMessage());
    }
  }

  void input_focusGained(FocusEvent e) {
    lastInputField = (JTextField)e.getComponent();
    System.out.println(e.getComponent().getName() + " got focus");
  }

  void keypad_actionPerformed(ActionEvent e) {
    String cmd=e.getActionCommand();
    System.out.println(e.getActionCommand() + " action performed");
    if(lastInputField!=null){
      String text = lastInputField.getText();
      if(cmd.equals("C")){
        if(text.length()>0){
          lastInputField.setText(text.substring(0,text.length()-1));
        }
      }else{
        lastInputField.setText(text+cmd);
      }
      lastInputField.requestFocus();
    }
  }

  private boolean isCustomerCode(String barCode){
    return barCode.charAt(0)=='C';
  }
  public void readValue(BarCodeReaderEvent event){
    if(isCustomerCode(event.getCode())){
      customerCode.setText(event.getCode().substring(8));
      btCustomer_actionPerformed(null);
    }else{ // bar code of a product
      if(ItemCode.getText().length()>0){
        SubmitButton_actionPerformed(null);
      }
      ItemCode.setText(event.getCode().substring(7));
      getPrice_actionPerformed(null);
      ItemQuantity.setText("1");
    }
  }

}