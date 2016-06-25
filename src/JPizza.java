/**
 * Created by Frank Hall on 6/25/2016.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JPizza extends JFrame implements ItemListener //Start JPizza class, extending JFrame and implements an ItemLIstener
{
    FlowLayout flow = new FlowLayout(); // layOut control object
    JComboBox<String> itemMenu = new JComboBox<String>(); // inemMenu combo box
    JLabel items = new JLabel("Item Menu"); //items label
    JComboBox<String> pizzaSize = new JComboBox<String>();//pizza size combo box
    JLabel sizes = new JLabel("Pizza sizes");// sizes label
    JLabel title = new JLabel("Frank's Pizza"); //Title label
    JTextField totalFees = new JTextField(25); // textfields for output
    JTextField totalFees2 = new JTextField(25); // textfields for output
    JTextField totalFees3 = new JTextField(25); // textfields for output
    double[] fees = {0, 7 , 9, 11, 14}; //fees array for the pizzaSize values
    double sizePrice = 0;// size price which will be set .getSelectedIndex()
    double[] fees2 = {0 ,0, 1, 1.5, 1.5, 1, 1, 1, 1};// fees2 array for the item price value.. Mushroom and green olives are a premium topping and is 50 cents more
    double itemPrice = 0; // itemPrice  which will be set .getSelectedIndex()
    double fee = 0 ;// this will be set the the array value
    double fee2 = 0;// this will be set the the array value
    String output; // output variable for out put latter
    String output2; // output variable for out put latter
    String output3; // output variable for out put latter
    String msg = new String("Your cost for your size is: ");// msg that will be set to a specific output variable
    String msg2 = new String("Your item price is: ");// msg that will be set to a specific output variable
    String msg3 = new String("Your total cost is: ");// msg that will be set to a specific output variable
    double totalPrice = 0; // for determining final price.

    public JPizza()// constructor
    {
        super("Frank's Pizza"); //Window title
        setLayout(flow);// layout control
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// close on exit
        itemMenu.addItemListener(this);// Event listener
        pizzaSize.addItemListener(this);// Event listener
        add(title);// adds the title label to the window frame
        add(items);  // adds the items label  to the window frame
        add(itemMenu);  // adds the titem combo box to the window frame
        add(sizes);  // adds the size label to the window frame
        add(pizzaSize); // adds the size combo box
        itemMenu.addItem("none");// populates the items combo box
        itemMenu.addItem("cheese");
        itemMenu.addItem("Pepperoni");
        itemMenu.addItem("Mushroom");
        itemMenu.addItem("Green Olives");
        itemMenu.addItem("Black Olives");
        itemMenu.addItem("Ham");
        itemMenu.addItem("Bacon");
        itemMenu.addItem("Italian Sausage");
        pizzaSize.addItem("none");// populates pizza size combo box
        pizzaSize.addItem("Small");
        pizzaSize.addItem("Medium");
        pizzaSize.addItem("Large");
        pizzaSize.addItem("Extra large");
        add(totalFees);
        add(totalFees2);
        add(totalFees3);
    }

    public static void main(String[] args)// method main
    {
        JFrame aFrame = new JPizza();// creates the window frame
        aFrame.setSize(300, 200);// sizes the frame
        aFrame.setVisible(true);// makes the fram visible
    }

    @Override
    public void itemStateChanged(ItemEvent e)// event handeling method
    {
        int sizePrice = pizzaSize.getSelectedIndex();// gets the selected size in combo box
        int itemPrice = itemMenu.getSelectedIndex();// gets the selected item in combo box
        Object source = e.getSource();// creates a source to know which item is doing the event



        if(source == pizzaSize)// if statement to make  determine if the combo box had an event happen.
        {
            fee = fees[sizePrice]; //double variable is set to the value of the array and is set to recognise its events with the size price variable
            String s1 = java.text.NumberFormat.getCurrencyInstance().format(fee);// currency format
            output = msg+ " " +s1;
            totalFees.setText(output);// output
        }

        if(source == itemMenu)// if statement to make  determine if the combo box had an event happen.
        {
            fee2 = fees2[itemPrice]; //double variable is set to the value of the array and is set to recognise its events with the itemPrice variable

            String s2 = java.text.NumberFormat.getCurrencyInstance().format(fee2);// currency format
            output2 = msg2+ " " +s2;
            totalFees2.setText(output2);
        }

        totalPrice = fee + fee2;
        String s3 = java.text.NumberFormat.getCurrencyInstance().format(totalPrice); // currency format
        output3 = msg3+ " " +s3;
        totalFees3.setText(output3);//output
    }
}
