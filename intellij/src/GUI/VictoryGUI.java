package GUI;

import User.User;
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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class VictoryGUI implements ActionListener, WindowListener {
    int checkVittoria = 0;
    private JFrame f = new JFrame();
    ImagePanel b = new ImagePanel((new ImageIcon("IMG/Obama_Victory_Black.jpg")).getImage());
    ImagePanel w = new ImagePanel((new ImageIcon("IMG/Obama_Victory_White.jpg")).getImage());
    private JButton exit = new JButton();
    private JButton reset = new JButton();
    private JLabel lb1 = new JLabel("YOYO");
    private String temp;
    private User u1 = new User();
    private User u2 = new User();

    public VictoryGUI() {
        this.checkVittoria = BoardGUI.getCheckVittoria();
        System.out.println("Check vittoria " + this.checkVittoria);
        this.setFrame();
        if (this.checkVittoria == 1) {
            this.setSfondoWhite();
        } else {
            this.setSfondoBlack();
        }

        this.setButton();
        this.setLabel();
    }

    private void setFrame() {
        this.f.setSize(1200, 812);
        this.f.setLocationRelativeTo((Component)null);
        this.f.setDefaultCloseOperation(3);
        this.f.setVisible(true);
        this.f.setResizable(false);
    }

    private void setButton() {
        this.exit.setBounds(70, 650, 500, 100);
        this.exit.addActionListener(this);
        this.exit.setBackground(new Color(255, 255, 255));
        this.exit.setText("USCITA");
        this.exit.setForeground(new Color(0, 0, 0));
        this.exit.setFont(new Font("Consalas", 1, 30));
        this.reset.setBounds(570, 650, 500, 100);
        this.reset.addActionListener(this);
        this.reset.setBackground(new Color(255, 255, 255));
        this.reset.setText("RICOMINCIA");
        this.reset.setForeground(new Color(0, 0, 0));
        this.reset.setFont(new Font("Consalas", 1, 30));
        if (this.checkVittoria == 1) {
            this.w.add(this.exit);
            this.w.add(this.reset);
        } else {
            this.b.add(this.exit);
            this.b.add(this.reset);
        }

    }

    private void setSfondoBlack() {
        this.f.getContentPane().add(this.b);
    }

    private void setSfondoWhite() {
        this.f.getContentPane().add(this.w);
    }

    private void setLabel() {
        this.lb1.setBounds(110, 350, 800, 250);
        this.lb1.setFont(new Font("Stencil", 1, 96));
        if (this.checkVittoria == 1) {
            this.lb1.setText(this.u1.getNome().toUpperCase());
            this.w.add(this.lb1);
        } else {
            this.lb1.setText(this.u2.getNome().toUpperCase());
            this.b.add(this.lb1);
        }

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.exit) {
            this.f.dispose();
        } else if (e.getSource() == this.reset) {
            new TitleGUI();
            this.f.dispose();
        }

    }

    public void windowOpened(WindowEvent e) {
        boolean g1 = true;
        BufferedReader inputStream = null;

        try {
            inputStream = new BufferedReader(new FileReader("FILE/Data.txt"));
        } catch (FileNotFoundException var5) {
            var5.printStackTrace();
        }

        try {
            for(this.temp = inputStream.readLine(); this.temp != null; this.temp = inputStream.readLine()) {
                if (g1) {
                    System.out.println(this.temp);
                    this.u1.setNome(this.temp);
                    g1 = false;
                } else {
                    System.out.println(this.temp);
                    this.u2.setNome(this.temp);
                    g1 = true;
                }
            }
        } catch (Exception var6) {
            var6.printStackTrace();
        }

        System.out.println(this.u1.getNome());
        System.out.println(this.u2.getNome());
    }

    public void windowClosing(WindowEvent e) {
    }

    public void windowClosed(WindowEvent e) {
    }

    public void windowIconified(WindowEvent e) {
    }

    public void windowDeiconified(WindowEvent e) {
    }

    public void windowActivated(WindowEvent e) {
    }

    public void windowDeactivated(WindowEvent e) {
    }
}
