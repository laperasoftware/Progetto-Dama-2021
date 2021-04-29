package GUI;


import User.User;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class BoardGUI extends JPanel implements ActionListener {


    private JPanel scacchiera = new JPanel();
    private JButton pulsanti[] = new JButton[64];
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

        for (int i = 0; i < 64 ; i++) {
            pulsanti[i] = new JButton();
            pulsanti[i].addActionListener(this);
        }


        for (int i = 0; i < 64 ; i++) {
            int j;

                if(i%2 == 0){
                    for (j = 0; j < 64; j++) {

                        if(j%2 == 0){

                            pulsanti[j].setBackground(Color.BLACK);
                        }
                        else{
                            pulsanti[j].setBackground(Color.WHITE);

                        }
                    }

                }

                else {
                    for (j = 0; j < 64; j++) {

                        if(j%2 == 0){

                            pulsanti[j].setBackground(Color.WHITE);
                        }
                        else{
                            pulsanti[j].setBackground(Color.BLACK);

                        }
                    }
                }




            scacchiera.add(pulsanti[i]);

            }

        

        scacchiera.setBounds(100, 100, 100, 100);

        frame.add(scacchiera, BorderLayout.CENTER);

        frame.add(scacchiera);

    }




    @Override
    public void actionPerformed(ActionEvent e) {



    }
}
