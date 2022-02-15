import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

public class PizzaViewer extends JFrame {
    JPanel mainPnl;
    JPanel crustPnl;
    JPanel sizePnl;
    JPanel toppingsPnl;
    JPanel receiptPnl;
    JPanel btnPnl;
    JPanel northPnl;

    JRadioButton thinCrustRB;
    JRadioButton regularCrustRB;
    JRadioButton deepDishCrustRB;

    JComboBox pizzaSizeCB;

    JCheckBox pepperoniCB;
    JCheckBox sausageCB;
    JCheckBox olivesCB;
    JCheckBox mushroomsCB;
    JCheckBox monsterGutsCB;
    JCheckBox anchoviesCB;

    JTextArea receiptTA;
    JScrollPane scroller;

    JButton quitBtn;
    JButton orderBtn;
    JButton clearBtn;

    int confirm;
    double totalPrice;
    double toppingPrice;
    double taxDB;

    String crustSize;
    String toppingString;

    public PizzaViewer() {
        mainPnl = new JPanel();
        mainPnl.setLayout(new GridLayout(3,1));

        northPnl = new JPanel();
        northPnl.setLayout(new GridLayout(1,3));

        createCrustPanel();
        northPnl.add(crustPnl);

        createSizePanel();
        northPnl.add(sizePnl);

        createToppingsPanel();
        northPnl.add(toppingsPnl);

        mainPnl.add(northPnl);

        createReceiptPanel();
        mainPnl.add(receiptPnl);

        createButtonPanel();
        mainPnl.add(btnPnl);



        add(mainPnl);
        setSize(600,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    private void createCrustPanel() {
        crustPnl = new JPanel();
        crustPnl.setLayout(new GridLayout(1,3));
        crustPnl.setBorder(new TitledBorder(new EtchedBorder(), "Crust Type"));

        thinCrustRB = new JRadioButton("Thin Crust");
        regularCrustRB = new JRadioButton("Regular Crust");
        deepDishCrustRB = new JRadioButton("Deep-Dish Crust");

        crustPnl.add(thinCrustRB);
        crustPnl.add(regularCrustRB);
        crustPnl.add(deepDishCrustRB);

        regularCrustRB.setSelected(true);

        ButtonGroup group = new ButtonGroup();
        group.add(thinCrustRB);
        group.add(regularCrustRB);
        group.add(deepDishCrustRB);

    }

    private void createSizePanel() {
        sizePnl = new JPanel();
        sizePnl.setBorder(new TitledBorder(new EtchedBorder(), "Pizza Size"));

        pizzaSizeCB = new JComboBox();
        pizzaSizeCB.addItem("Small $8");
        pizzaSizeCB.addItem("Medium $12");
        pizzaSizeCB.addItem("Large $16");
        pizzaSizeCB.addItem("Super $20");

        sizePnl.add(pizzaSizeCB);

    }

    private void createToppingsPanel() {
        toppingsPnl = new JPanel();
        toppingsPnl.setLayout(new GridLayout(2,3));
        toppingsPnl.setBorder(new TitledBorder(new EtchedBorder(),"Pizza Toppings ($1 each)"));

        pepperoniCB = new JCheckBox("Pepperoni");
        sausageCB = new JCheckBox("Sausage");
        olivesCB = new JCheckBox("Olives");
        mushroomsCB = new JCheckBox("Mushrooms");
        monsterGutsCB = new JCheckBox("Monster Guts");
        anchoviesCB = new JCheckBox("Anchovies");

        toppingsPnl.add(pepperoniCB);
        toppingsPnl.add(sausageCB);
        toppingsPnl.add(olivesCB);
        toppingsPnl.add(mushroomsCB);
        toppingsPnl.add(monsterGutsCB);
        toppingsPnl.add(anchoviesCB);

    }

    private void createReceiptPanel() {
        receiptPnl = new JPanel();
        receiptTA = new JTextArea(20,40);
        receiptTA.setEditable(false);
        scroller = new JScrollPane(receiptTA);
        receiptPnl.add(scroller);

    }

    private void createButtonPanel() {
        btnPnl = new JPanel();
        btnPnl.setLayout(new GridLayout(2,3));

        quitBtn = new JButton("Quit");
        quitBtn.addActionListener((ActionEvent ae) -> {
            confirm = JOptionPane.showConfirmDialog(null,"Are you sure you want to quit?", "Quit?", JOptionPane.YES_NO_OPTION);
            if (confirm == 0) {
                System.exit(0);
            }
        });

        clearBtn = new JButton("Clear");
        clearBtn.addActionListener((ActionEvent ae) -> {
            receiptTA.setText("");
            regularCrustRB.setSelected(true);
            pizzaSizeCB.setSelectedIndex(0);
            pepperoniCB.setSelected(false);
            sausageCB.setSelected(false);
            olivesCB.setSelected(false);
            mushroomsCB.setSelected(false);
            monsterGutsCB.setSelected(false);
            anchoviesCB.setSelected(false);

        });

        orderBtn = new JButton("Order");
        orderBtn.addActionListener((ActionEvent ae ) -> {
            receiptTA.append("=========================\n");
            if (thinCrustRB.isSelected()) {
                crustSize = "Thin Crust ";
            }
            else if (regularCrustRB.isSelected()) {
                crustSize = "Regular Crust ";
            }
            else {
                crustSize = "Deep-Dish Crust ";
            }


            if (((String) pizzaSizeCB.getSelectedItem()).equals("Small $8")) {
                totalPrice = totalPrice + 8.00;
                crustSize += " Small";

            }
            else if (((String) pizzaSizeCB.getSelectedItem()).equals("Medium $12")) {
                totalPrice = totalPrice + 12.00;
                crustSize += " Medium";

            }
            else if (((String) pizzaSizeCB.getSelectedItem()).equals("Large $16")) {
                totalPrice = totalPrice + 16.00;
                crustSize += " Large";

            }
            else {
                totalPrice = totalPrice + 20.00;
                crustSize += " Super";

            }
            crustSize += "       ";
            crustSize += totalPrice;
            receiptTA.append(crustSize + "\n");

            toppingString = "\nToppings:\n";

            if (pepperoniCB.isSelected()) {
                toppingPrice = toppingPrice + 1.00;
                toppingString += "Pepperoni\n";

            }
            if (sausageCB.isSelected()) {
                toppingPrice = toppingPrice + 1.00;
                toppingString += "Sausage\n";

            }
            if (olivesCB.isSelected()) {
                toppingPrice = toppingPrice + 1.00;
                toppingString += "Olives\n";

            }
            if (mushroomsCB.isSelected()) {
                toppingPrice = toppingPrice + 1.00;
                toppingString += "Mushrooms\n";

            }
            if (monsterGutsCB.isSelected()) {
                toppingPrice = toppingPrice + 1.00;
                toppingString += "Monster Guts\n";

            }
            if (anchoviesCB.isSelected()) {
                toppingPrice = toppingPrice + 1.00;
                toppingString += "Anchovies";

            }

            totalPrice = totalPrice + toppingPrice;

            toppingString += "                          ";
            toppingString += toppingPrice;
            receiptTA.append(toppingString + "\n");
            receiptTA.append("\n");
            receiptTA.append("Sub-Total:                         " + (totalPrice) + "\n");
            taxDB = totalPrice * .07;
            totalPrice = totalPrice + taxDB;
            receiptTA.append("Tax:                                    " + taxDB);
            receiptTA.append("\n=========================\n");
            receiptTA.append("Total:                                " + totalPrice);
            receiptTA.append("\n=========================\n");
            totalPrice = 0;
            toppingPrice = 0;

        });

        btnPnl.add(new JLabel(""));
        btnPnl.add(new JLabel(""));
        btnPnl.add(new JLabel(""));
        btnPnl.add(orderBtn);
        btnPnl.add(clearBtn);
        btnPnl.add(quitBtn);

    }

}
