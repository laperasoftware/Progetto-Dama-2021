package GUI;

import User.User;
import com.sun.source.tree.NewArrayTree;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import javax.swing.*;


public class VictoryGUI implements ActionListener {

    int checkVittoria = 0;

    private JFrame f = new JFrame();

    ImagePanel b = new ImagePanel((new ImageIcon("IMG/Obama_Victory_Black.jpg")).getImage());
    ImagePanel w = new ImagePanel((new ImageIcon("IMG/Obama_Victory_White.jpg")).getImage());

    private JButton exit = new JButton();
    private JButton reset = new JButton();

    private JLabel lb1 = new JLabel();
    private JLabel lb2 = new JLabel();




    public VictoryGUI() {

        this.checkVittoria = BoardGUI.getCheckVittoria();

        System.out.println("Check vittoria " + this.checkVittoria);
        this.setFrame();

        if (checkVittoria == 1) {

            setSfondoWhite();
        } else {
            setSfondoBlack();
        }

        setButton();
        setLabel();
    }


    private void setFrame() {

        f.setSize(1200, 812);
        f.setLocationRelativeTo((Component) null);
        f.setDefaultCloseOperation(3);
        f.setVisible(true);
        f.setResizable(false);

    }

    private void setButton() {

        exit.setBounds(70, 650, 500, 100);
        exit.addActionListener(this);
        exit.setBackground(new Color(255, 255, 255));
        exit.setText("USCITA");
        exit.setForeground(new Color(0, 0, 0));
        exit.setFont(new Font("Consalas", 1, 30));

        reset.setBounds(570, 650, 500, 100);
        reset.addActionListener(this);
        reset.setBackground(new Color(255, 255, 255));
        reset.setText("RICOMINCIA");
        reset.setForeground(new Color(0, 0, 0));
        reset.setFont(new Font("Consalas", 1, 30));

        if (checkVittoria == 1) {

            w.add(exit);
            w.add(this.reset);

        } else {

            b.add(exit);
            b.add(reset);
        }

    }

    private void setSfondoBlack() {
        this.f.getContentPane().add(b);
    }

    private void setSfondoWhite() {
        f.getContentPane().add(w);
    }

    private void setLabel() {

        lb1.setBounds(80, 350, 1200, 250);
        lb1.setFont(new Font("Stencil", 1, 80));
        lb1.setForeground(Color.YELLOW);


        lb2.setBounds(480, 450, 1200, 250);
        lb2.setFont(new Font("Stencil", 1, 80));
        lb2.setForeground(Color.YELLOW);


        lb1.setText("VITTORIA DEL GIOCATORE");

        if (checkVittoria == 1) {

            lb2.setText("BIANCO");

            w.add(lb1);
            w.add(lb2);


        } else {

            lb2.setText("NERO");
            b.add(lb1);
            b.add(lb2);

        }

    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == exit) {

            f.dispose();

        } else if (e.getSource() == reset) {

            new TitleGUI();
            f.dispose();

        }

    }

}