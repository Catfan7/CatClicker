import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Interface extends JFrame implements ActionListener {
    public static void main(String[] args) {
        new Interface();
        new Updater().start();
    }
    public static int speed = 0;

    static JButton click;
    static JLabel amount;
    static JButton addClicker;
    static JButton addGrandma;
    static JButton addFarm;
    static JButton addMine;
    static JLabel speedl;


    public Interface() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(250,300);
        setTitle("CatClicker");
        setLayout(null);
        setResizable(false);
        setVisible(true);
        getRootPane().setDefaultButton(click);

        click = new JButton("Click");
        click.setBounds(15,15,200,50);
        click.addActionListener(this);
        add(click);

        addClicker = new JButton("1/s |25");
        addClicker.setBounds(0,210,60,50);
        addClicker.addActionListener(this);
        addClicker.setMargin(new Insets(0,0,0,0));
        addClicker.setFocusPainted(false);
        add(addClicker);

        addGrandma = new JButton("5/s |100");
        addGrandma.setBounds(60,210,60,50);
        addGrandma.addActionListener(this);
        addGrandma.setMargin(new Insets(0,0,0,0));
        addGrandma.setFocusable(false);
        add(addGrandma);

        addFarm = new JButton("25/s|500");
        addFarm.setBounds(120,210,60,50);
        addFarm.addActionListener(this);
        addFarm.setMargin(new Insets(0,0,0,0));
        addFarm.setFocusable(false);
        add(addFarm);

        addMine = new JButton("100/s|2k");
        addMine.setBounds(180,210,60,50);
        addMine.addActionListener(this);
        addMine.setMargin(new Insets(0,0,0,0));
        addMine.setFocusable(false);
        add(addMine);

        amount = new JLabel("0000000");
        amount.setBounds(15,75,200,50);
        amount.setFont(new Font("Arial", Font.BOLD, 51));
        add(amount);

        speedl = new JLabel(speed + " pnts/s");
        speedl.setBounds(50,150,150,25);
        speedl.setFont(new Font("Arial", Font.BOLD, 24));
        add(speedl);


        click.requestFocus();
    }
    public static String formatNumber(int num) {
        if (num < 10) {
            return "000000" + num;
        } else if (num < 100) {
            return "00000" + num;
        } else if (num < 1000) {
            return "0000" + num;
        } else if (num < 10000) {
            return "000" + num;
        } else if (num < 100000) {
            return "00" + num;
        } else if (num < 1000000) {
            return "0" + num;
        }
        return String.valueOf(num);
    }
    public static void addCookies(int cookies) {
        amount.setText(formatNumber(Integer.parseInt(amount.getText()) + cookies));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == click) {
            addCookies(1);
        }
        if ((e.getSource() == addClicker) && (Integer.parseInt(amount.getText()) > 24)) {
            addCookies(-25);
            AutoClicker object = new AutoClicker();
            object.speed = 1000;
            speed = speed + 1;
            object.start();
        }
        if ((e.getSource() == addGrandma) && (Integer.parseInt(amount.getText()) > 99)) {
            addCookies(-100);
            AutoClicker object = new AutoClicker();
            object.speed = 200;
            speed = speed + 5;
            object.start();
        }
        if ((e.getSource() == addFarm) && (Integer.parseInt(amount.getText()) > 499)) {
            addCookies(-500);
            AutoClicker object = new AutoClicker();
            object.speed = 40;
            speed = speed + 25;
            object.start();
        }
        if ((e.getSource() == addMine) && (Integer.parseInt(amount.getText()) > 1999)) {
            addCookies(-2000);
            AutoClicker object = new AutoClicker();
            object.speed = 10;
            speed = speed + 100;
            object.start();
        }
    }
}
