package GUI;


import User.User;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class BoardGUI extends JPanel implements ActionListener {


    private JPanel scacchiera = new JPanel();
    private JButton pulsanti[][] = new JButton[8][8];
    private JFrame frame = new JFrame();



    public void boardDisplay(){

        JFrame frame = new JFrame();


        frame.setSize(600,600);
        frame.getContentPane().add(new BoardGUI());
        frame.setLocationRelativeTo(null);
        frame.setBackground(Color.lightGray);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);


        scacchiera.setLayout(new GridLayout(8, 8, 5, 5));

        for (int i = 0; i < 8 ; i++) {
            for (int j = 0; j < 8; j++) {
                pulsanti[i][j] = new JButton();
                pulsanti[i][j].addActionListener(this);
                frame.getContentPane().add(pulsanti[i][j]);

            }

        }


        for (int i = 0; i < 8 ; i++) {
            int j;

                if(i%2 == 0){
                    for (j = 0; j < 8; j++) {

                        if(j%2 == 0){

                            pulsanti[i][j].setBackground(Color.BLACK);
                        }
                        else{
                            pulsanti[i][j].setBackground(Color.WHITE);

                        }
                    }

                }

                else {
                    for (j = 0; j < 8; j++) {

                        if(j%2 == 0){

                            pulsanti[i][j].setBackground(Color.WHITE);
                        }
                        else{
                            pulsanti[i][j].setBackground(Color.BLACK);

                        }
                    }
                }
            }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                scacchiera.add(pulsanti[i][j]);
            }
        }
////////////////////////////////////////////////////////////////////////////////////////////////
        for (int i = 0; i < 3; i++) {
            if(i%2 == 0){
                for (int j = 0; j < 8; j++) {
                    if(j%2 == 0){

                        pulsanti[i][j].setIcon(new ImageIcon("IMG/ckW.png"));
                    }

                }
            }

            else{
                for (int j = 0; j < 8; j++) {
                    if(j%2 != 0){

                        pulsanti[i][j].setIcon(new ImageIcon("IMG/ckW.png"));
                    }
                }
            }
        }
//////////////////////////////////////////////////////////////////////////////////////

        for (int i = 5; i < 8; i++) {
            if(i%2 == 0){
                for (int j = 0; j < 8; j++) {
                    if(j%2 == 0){

                        pulsanti[i][j].setIcon(new ImageIcon("IMG/ckB.png"));
                    }

                }
            }

            else{
                for (int j = 0; j < 8; j++) {
                    if(j%2 != 0){

                        pulsanti[i][j].setIcon(new ImageIcon("IMG/ckB.png"));
                    }
                }
            }
        }
        

        scacchiera.setBounds(100, 100, 100, 100);

        frame.add(scacchiera, BorderLayout.CENTER);

        frame.add(scacchiera);

    }




    @Override
    public void actionPerformed(ActionEvent e) {



    }
}
