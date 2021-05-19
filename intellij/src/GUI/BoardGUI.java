package GUI;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoardGUI extends JPanel implements ActionListener {


    private JPanel scacchiera = new JPanel();
    private JButton pulsanti[][] = new JButton[8][8];
    private char posizioni[][] = new char[8][8];
    private JFrame frame = new JFrame();


    public void boardDisplay(){

        setBoard();
        boardUpdate();
    }

private void setBoard(){

    frame.setSize(600,600);
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

            posizioni[i][j] = '-';

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
                    pulsanti[i][j].setEnabled(false);
                }
            }

        }

        else {
            for (j = 0; j < 8; j++) {

                if(j%2 == 0){

                    pulsanti[i][j].setBackground(Color.WHITE);
                    pulsanti[i][j].setEnabled(false);
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
                    posizioni [i][j] = 'b';
                }

            }
        }

        else{
            for (int j = 0; j < 8; j++) {
                if(j%2 != 0){
                    posizioni [i][j] = 'b';
                }
            }
        }
    }
//////////////////////////////////////////////////////////////////////////////////////

    for (int i = 5; i < 8; i++) {
        if(i%2 == 0){
            for (int j = 0; j < 8; j++) {
                if(j%2 == 0){
                    posizioni [i][j] = 'w';

                }

            }
        }

        else{
            for (int j = 0; j < 8; j++) {
                if(j%2 != 0){
                    posizioni [i][j] = 'w';
                }
            }
        }
    }


    scacchiera.setBounds(100, 100, 100, 100);

    frame.add(scacchiera, BorderLayout.CENTER);

    frame.add(scacchiera);


}

private void boardUpdate(){
    for (int i = 0; i < 8; i++) {

        for (int j = 0; j < 8; j++) {
            if(posizioni[i][j] == 'b'){
                pulsanti[i][j].setIcon(new ImageIcon("IMG/ckW.png"));
            }

            else if(posizioni[i][j] == 'w'){
                pulsanti[i][j].setIcon(new ImageIcon("IMG/ckB.png"));

            }
            System.out.print(posizioni[i][j] + " ");
        }

        System.out.println();

    }
}

private void firstMove(){

}

private void secondMove(int a, int b,int c, int d){

        pulsanti[a][b].setBackground(Color.BLACK);

            //pulsanti[c][d].setIcon(new ImageIcon("IMG/ckB.png"));

}

    @Override
    public void actionPerformed(ActionEvent e) {
        
        boolean primo = false;
        boolean secondo = false;
        int aux1 = 0;
        int aux2 = 0;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(e.getSource() == pulsanti[i][j] && primo == false && secondo == false){

                    aux1 = i;
                    aux2 = j;
                    primo = true;
                    pulsanti[i][j].setEnabled(false);
                }

                else if(e.getSource() != pulsanti[aux1][aux2] && secondo == false && primo == true){
                    secondMove(aux1,aux2, i,j-1);
                    System.out.println("negro");
                    pulsanti[aux1][aux2].setEnabled(true);
                    secondo = true;
                }
            }
        }

    }
}
