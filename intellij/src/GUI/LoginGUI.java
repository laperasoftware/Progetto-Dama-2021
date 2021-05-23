package GUI;


import java.io.*;
import java.util.*;
import java.awt.Toolkit.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LoginGUI extends JFrame implements ActionListener {

    private JFrame frame = new JFrame();
    private JButton b1 = new JButton();
    private JPanel p = new JPanel();

    private JLabel lb1 = new JLabel("DAMA");
    private JLabel lb2 = new JLabel("Alessandro Orlando");
    private JLabel lb3 = new JLabel("Massimiliano Lisi");

    private Icon icon = new ImageIcon("entra.png");

    private JButton enter = new JButton();



    public LoginGUI(){

        super("LogIn");

        setFrame();
        setPanel();
        setLabel();
        setButton();


    }



    private void setFrame(){

        frame.setSize(1650,1080);
        frame.setLocationRelativeTo(null);

        frame.setBackground(Color.WHITE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setResizable(false);

    }

    private void setPanel(){

        frame.add(p);

        p.setLayout(null);


    }


    private void setLabel(){

        lb1.setBounds(560,90,800,250);
        lb1.setFont(new Font("Stencil", Font.BOLD, 96));


        lb2.setBounds(1010, 421, 842,262);
        lb2.setFont(new Font("Stencil", Font.BOLD, 26));


        lb3.setBounds(1010, 461, 842,262);
        lb3.setFont(new Font("Stencil", Font.BOLD, 26));


        p.add(lb1);
        p.add(lb2);
        p.add(lb3);


    }

    private void setButton(){

        enter.setBounds(545,290,300,300);
        enter.addActionListener(this);
        enter.setBackground(new Color(255,255,255));

        enter.setIcon(new ImageIcon("IMG/entra.png"));

        p.add(enter);
    }



    @Override
    public void actionPerformed(ActionEvent e) {


        frame.setVisible(false);
        frame.dispose();
        BoardGUI b = new BoardGUI();
        b.boardDisplay();


    }
}
