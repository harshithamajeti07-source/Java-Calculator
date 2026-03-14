import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SmartCalculator extends JFrame implements ActionListener {

    JTextField display;

    JButton[] numbers = new JButton[10];
    JButton add, sub, mul, div, equal, clear, decimal;

    double num1 = 0, num2 = 0, result = 0;
    char operator;

    SmartCalculator() {

        setTitle("Smart Calculator");
        setSize(320, 420);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        display = new JTextField();
        display.setBounds(20, 20, 260, 50);
        display.setFont(new Font("Arial", Font.BOLD, 22));
        display.setHorizontalAlignment(JTextField.RIGHT);
        add(display);

        JPanel panel = new JPanel();
        panel.setBounds(20, 90, 260, 260);
        panel.setLayout(new GridLayout(5,4,5,5));

        for(int i=0;i<10;i++){
            numbers[i] = new JButton(String.valueOf(i));
            numbers[i].setFont(new Font("Arial", Font.BOLD,16));
            numbers[i].addActionListener(this);
        }

        add = new JButton("+");
        sub = new JButton("-");
        mul = new JButton("*");
        div = new JButton("/");
        equal = new JButton("=");
        clear = new JButton("C");
        decimal = new JButton(".");

        JButton[] operations = {add,sub,mul,div,equal,clear,decimal};

        for(JButton b : operations){
            b.setFont(new Font("Arial", Font.BOLD,16));
            b.setBackground(Color.LIGHT_GRAY);
            b.addActionListener(this);
        }

        panel.add(numbers[7]);
        panel.add(numbers[8]);
        panel.add(numbers[9]);
        panel.add(div);

        panel.add(numbers[4]);
        panel.add(numbers[5]);
        panel.add(numbers[6]);
        panel.add(mul);

        panel.add(numbers[1]);
        panel.add(numbers[2]);
        panel.add(numbers[3]);
        panel.add(sub);

        panel.add(decimal);
        panel.add(numbers[0]);
        panel.add(equal);
        panel.add(add);

        panel.add(clear);

        add(panel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        for(int i=0;i<10;i++){
            if(e.getSource()==numbers[i]){
                display.setText(display.getText()+i);
            }
        }

        if(e.getSource()==decimal){
            display.setText(display.getText()+".");
        }

        if(e.getSource()==add){
            num1 = Double.parseDouble(display.getText());
            operator = '+';
            display.setText("");
        }

        if(e.getSource()==sub){
            num1 = Double.parseDouble(display.getText());
            operator = '-';
            display.setText("");
        }

        if(e.getSource()==mul){
            num1 = Double.parseDouble(display.getText());
            operator = '*';
            display.setText("");
        }

        if(e.getSource()==div){
            num1 = Double.parseDouble(display.getText());
            operator = '/';
            display.setText("");
        }

        if(e.getSource()==equal){

            num2 = Double.parseDouble(display.getText());

            switch(operator){

                case '+':
                    result = num1 + num2;
                    break;

                case '-':
                    result = num1 - num2;
                    break;

                case '*':
                    result = num1 * num2;
                    break;

                case '/':
                    result = num1 / num2;
                    break;
            }

            display.setText(String.valueOf(result));
        }

        if(e.getSource()==clear){
            display.setText("");
        }
    }

    public static void main(String[] args) {
        new SmartCalculator();
    }
}