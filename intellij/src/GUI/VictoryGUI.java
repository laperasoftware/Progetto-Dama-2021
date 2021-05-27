package GUI;

import User.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class VictoryGUI implements ActionListener, WindowListener {

    int checkVittoria = 0;

    private JFrame f = new JFrame();

    ImagePanel b = new ImagePanel(new ImageIcon("IMG/Obama_Victory_Black.jpg").getImage());

    ImagePanel w = new ImagePanel(new ImageIcon("IMG/Obama_Victory_White.jpg").getImage());


    private JButton exit = new JButton();
    private JButton reset = new JButton();
    private JLabel lb1 = new JLabel("YOYO");

    private String temp;

    private User u1 = new User();
    private User u2 = new User();


    public VictoryGUI() {


        checkVittoria = BoardGUI.getCheckVittoria();


        System.out.println("Check vittoria " + checkVittoria);



        setFrame();


        if(checkVittoria == 1){

            setSfondoWhite();

        }

        else{

            setSfondoBlack();


        }

        setButton();

        setLabel();


    }




    private void setFrame(){

        f.setSize(1200, 812);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        f.setResizable(false);


    }


    private void setButton(){

        exit.setBounds(70,650,500,100);
        exit.addActionListener(this);
        exit.setBackground(new Color(255,255,255));

        exit.setText("USCITA");

        exit.setForeground(new Color(0,0,0));
        exit.setFont(new Font("Consalas", Font.BOLD, 30));

        reset.setBounds(570,650,500,100);
        reset.addActionListener(this);
        reset.setBackground(new Color(255,255,255));

        reset.setText("RICOMINCIA");

        reset.setForeground(new Color(0,0,0));
        reset.setFont(new Font("Consalas", Font.BOLD, 30));



        if(checkVittoria == 1) {

            w.add(exit);
            w.add(reset);

        }

        else{

            b.add(exit);
            b.add(reset);

        }


    }



    private void setSfondoBlack(){

        f.getContentPane().add(b);

    }


    private void setSfondoWhite(){

        f.getContentPane().add(w);

    }

    private void setLabel() {



        lb1.setBounds(110,350,800,250);
        lb1.setFont(new Font("Stencil", Font.BOLD, 96));

        if(checkVittoria == 1) {

            lb1.setText(u1.getNome().toUpperCase());


            w.add(lb1);


        }

        else{

            lb1.setText(u2.getNome().toUpperCase());
            b.add(lb1);


        }



    }

    @Override
    public void actionPerformed(ActionEvent e) {



        if(e.getSource() == exit){

            f.dispose();

        }

        else if(e.getSource() == reset){

            TitleGUI gui = new TitleGUI();
            f.dispose();



        }


    }


    @Override
    public void windowOpened(WindowEvent e) {


        boolean g1 = true;
        BufferedReader inputStream=null;

        try {
            inputStream = new BufferedReader(new FileReader("FILE/Data.txt"));
        }

        catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }

        try {
            temp = inputStream.readLine();
            while(temp != null){
                if(g1 == true) {
                    System.out.println(temp);
                    u1.setNome(temp);
                    g1 = false;
                }

                else{
                    System.out.println(temp);
                    u2.setNome(temp);
                    g1 = true;
                }

                temp = inputStream.readLine();
            }
        }
        catch (Exception fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }

        System.out.println(u1.getNome());
        System.out.println(u2.getNome());




    }

    @Override
    public void windowClosing(WindowEvent e) {

    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
