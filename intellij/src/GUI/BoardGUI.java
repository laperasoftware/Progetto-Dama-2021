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

        for (int i = 0; i < pulsanti.length ; i++) {

            System.out.println("i:" + i);

            pulsanti[i] = new JButton();
            pulsanti[i].addActionListener(this);

            if(i%2 == 0){

                pulsanti[i].setBackground(Color.BLACK);


            }

            else{
                pulsanti[i].setBackground(Color.WHITE);

            }


            scacchiera.add(pulsanti[i]);

            }

        

        scacchiera.setBounds(100, 100, 100, 100);

        frame.add(scacchiera, BorderLayout.CENTER);

        frame.add(scacchiera);

    }

    /*public void paint(Graphics g) {

        g.fillRect(100, 100, 400, 400);

        for (int i = 100; i <= 400; i += 100) {
            for (int j = 100; j <= 400; j+=100){

                g.clearRect(i, j, 50, 50);
            }
        }


        for (int i = 150; i <= 450; i += 100) {

            for(int j = 150; j <= 450; j+=100){

                g.clearRect(i, j, 50, 50);

            }

        }
    }










*/


    @Override
    public void actionPerformed(ActionEvent e) {



    }
}
