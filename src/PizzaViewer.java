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

    public PizzaViewer() {
        mainPnl = new JPanel();
        mainPnl.setLayout(new GridLayout(5,1));

        createCrustPanel();
        mainPnl.add(crustPnl);

        createSizePanel();
        mainPnl.add(sizePnl);

        createToppingsPanel();
        mainPnl.add(toppingsPnl);

        //createReceiptPanel();
        //mainPnl.add(receiptPnl);

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
        pizzaSizeCB.addItem("Small");
        pizzaSizeCB.addItem("Medium");
        pizzaSizeCB.addItem("Large");
        pizzaSizeCB.addItem("Super");

        sizePnl.add(pizzaSizeCB);

    }

    private void createToppingsPanel() {
        toppingsPnl = new JPanel();
        toppingsPnl.setLayout(new GridLayout(2,3));
        toppingsPnl.setBorder(new TitledBorder(new EtchedBorder(),"Pizza Toppings"));

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

    }

    private void createButtonPanel() {
        btnPnl = new JPanel();
        btnPnl.setLayout(new GridLayout(1,3));

        quitBtn = new JButton("Quit");
        quitBtn.addActionListener((ActionEvent ae) -> {
            confirm = JOptionPane.showConfirmDialog(null,"Are you sure you want to quit?", "Quit?", JOptionPane.YES_NO_OPTION);
            if (confirm == 0) {
                System.exit(0);
            }
        });

        clearBtn = new JButton("Clear");

        orderBtn = new JButton("Order");

        btnPnl.add(orderBtn);
        btnPnl.add(clearBtn);
        btnPnl.add(quitBtn);

    }

}
