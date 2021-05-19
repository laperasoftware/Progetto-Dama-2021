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
    boolean primo = false;
    boolean secondo = false;


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

private void  resetBool(){
        primo = false;
        secondo = false;
}

private void secondMoveBlack(int a, int b){

       // pulsanti[a][b].setIcon(new ImageIcon( "IMG/ckW.png"));
    pulsanti[a][b].setIcon(null);
        pulsanti[a][b].setBackground(Color.GREEN);


}

    private void secondMoveWhite(int a, int b){

        pulsanti[a][b].setIcon(new ImageIcon( "IMG/ckB.png"));



    }

    @Override
    public void actionPerformed(ActionEvent e) {
        

        int aux1 = 0;
        int aux2 = 0;

       // for (int i = 0; i < 8; i++) {
           // for (int j = 0; j < 8; j++) {
                JButton source = (JButton) e.getSource();

                ///////////////////////////////////
                if(source == pulsanti[0][0]){
                    if(primo == false && secondo == false) {
                        aux1 = 0;
                        aux2 = 0;
                        primo = true;
                    }

                    else if(primo == true){
                        secondMoveBlack(0,0);
                        secondo = true;
                    }

                }
                else if(source == pulsanti[0][2]){
                    if(primo == false && secondo == false) {
                        aux1 = 0;
                        aux2 = 2;

                        primo = true;

                    }
                    else if(primo == true){
                        secondMoveBlack(0,2);
                        secondo = true;
                    }
                }
                else if(source == pulsanti[0][4]){
                    if(primo == false && secondo == false) {
                        aux1 = 0;
                        aux2 = 4;
                        primo = true;
                    }

                    else if(primo == true){
                        secondMoveBlack(0,4);
                        secondo = true;
                    }
                }
                else if(source == pulsanti[0][6]){
                    if(primo == false && secondo == false) {
                        aux1 = 0;
                        aux2 = 6;
                        primo = true;
                    }

                    else if(primo == true){
                        secondMoveBlack(0,6);
                        secondo = true;
                    }                }

                ////////////////////////////////////
                else if(source == pulsanti[1][1]){
                    if(primo == false && secondo == false) {
                        aux1 = 1;
                        aux2 = 1;
                        primo = true;
                    }

                    else if(primo == true){
                        secondMoveBlack(1,1);
                        secondo = true;
                    }
                }
                else if(source == pulsanti[1][3]){
                    if(primo == false && secondo == false) {
                        aux1 = 1;
                        aux2 = 3;
                        primo = true;
                    }

                    else if(primo == true){
                        secondMoveBlack(1,3);
                        secondo = true;
                    }
                }
                else if(source == pulsanti[1][5]){
                    if(primo == false && secondo == false) {
                        aux1 = 1;
                        aux2 = 5;
                        primo = true;
                    }

                    else if(primo == true){
                        secondMoveBlack(1,5);
                        secondo = true;
                    }
                }
                else if(source == pulsanti[1][7]){
                    if(primo == false && secondo == false) {
                        aux1 = 1;
                        aux2 = 7;
                        primo = true;
                    }

                    else if(primo == true){
                        secondMoveBlack(1,7);
                        secondo = true;
                    }
                }
                ////////////////////////////////////
                else if(source == pulsanti[2][0]){
                    if(primo == false && secondo == false) {
                        aux1 = 2;
                        aux2 = 0;
                        primo = true;
                    }

                    else if(primo == true){
                        secondMoveBlack(2,0);
                        secondo = true;
                    }
                }
                else if(source == pulsanti[2][2]){
                    if(primo == false && secondo == false) {
                        aux1 = 2;
                        aux2 = 2;
                        primo = true;
                    }

                    else if(primo == true){
                        secondMoveBlack(2,2);
                        secondo = true;
                    }
                }
                else if(source == pulsanti[2][4]){
                    if(primo == false && secondo == false) {
                        aux1 = 2;
                        aux2 = 4;
                        primo = true;
                    }

                    else if(primo == true){
                        secondMoveBlack(2,4);
                        secondo = true;
                    }
                }
                else if(source == pulsanti[2][6]){
                    if(primo == false && secondo == false) {
                        aux1 = 2;
                        aux2 = 6;
                        primo = true;
                    }

                    else if(primo == true){
                        secondMoveBlack(2,6);
                        secondo = true;
                    }
                }

                ////////////////////////////////////
                else if(source == pulsanti[3][1]){
                    if(primo == false && secondo == false) {
                        aux1 = 3;
                        aux2 = 1;
                        primo = true;
                    }

                    else if(primo == true){
                        secondMoveBlack(3,1);
                        secondo = true;
                    }
                }
                else if(source == pulsanti[3][3]){
                    if(primo == false && secondo == false) {
                        aux1 = 3;
                        aux2 = 3;
                        primo = true;
                    }

                    else if(primo == true){
                        secondMoveBlack(3,3);
                        secondo = true;
                    }
                }
                else if(source == pulsanti[3][5]){
                    if(primo == false && secondo == false) {
                        aux1 = 3;
                        aux2 = 5;
                        primo = true;
                    }

                    else if(primo == true){
                        secondMoveBlack(3,5);
                        secondo = true;
                    }
                }
                else if(source == pulsanti[3][7]){
                    if(primo == false && secondo == false) {
                        aux1 = 3;
                        aux2 = 7;
                        primo = true;
                    }

                    else if(primo == true){
                        secondMoveBlack(3,7);
                        secondo = true;
                    }
                }
                ////////////////////////////////////
                else if(source == pulsanti[4][0]){
                    if(primo == false && secondo == false) {
                        aux1 = 4;
                        aux2 = 0;
                        primo = true;
                    }

                    else if(primo == true){
                        secondMoveBlack(4,0);
                        secondo = true;
                    }
                }
                else if(source == pulsanti[4][2]){
                    if(primo == false && secondo == false) {
                        aux1 = 4;
                        aux2 = 2;
                        primo = true;
                    }

                    else if(primo == true){
                        secondMoveBlack(4,2);
                        secondo = true;
                    }
                }
                else if(source == pulsanti[4][4]){
                    if(primo == false && secondo == false) {
                        aux1 = 4;
                        aux2 = 4;
                        primo = true;
                    }

                    else if(primo == true){
                        secondMoveBlack(4,4);
                        secondo = true;
                    }
                }
                else if(source == pulsanti[4][6]){
                    if(primo == false && secondo == false) {
                        aux1 = 4;
                        aux2 = 6;
                        primo = true;
                    }

                    else if(primo == true){
                        secondMoveBlack(4,6);
                        secondo = true;
                    }
                }

                ////////////////////////////////////
                else if(source == pulsanti[5][1]){
                    if(primo == false && secondo == false) {
                        aux1 = 5;
                        aux2 = 1;
                        primo = true;
                    }

                    else if(primo == true){
                        secondMoveBlack(5,1);
                        secondo = true;
                    }
                }
                else if(source == pulsanti[5][3]){
                    if(primo == false && secondo == false) {
                        aux1 = 5;
                        aux2 = 3;
                        primo = true;
                    }

                    else if(primo == true){
                        secondMoveBlack(5,3);
                        secondo = true;
                    }
                }
                else if(source == pulsanti[5][5]){
                    if(primo == false && secondo == false) {
                        aux1 = 5;
                        aux2 = 5;
                        primo = true;
                    }

                    else if(primo == true){
                        secondMoveBlack(5,5);
                        secondo = true;
                    }
                }
                else if(source == pulsanti[5][7]){
                    if(primo == false && secondo == false) {
                        aux1 = 5;
                        aux2 = 7;
                        primo = true;
                    }

                    else if(primo == true){
                        secondMoveBlack(5,7);
                        secondo = true;
                    }
                }
                ////////////////////////////////////
                else if(source == pulsanti[6][0]){
                    if(primo == false && secondo == false) {
                        aux1 = 6;
                        aux2 = 0;
                        primo = true;
                    }

                    else if(primo == true){
                        secondMoveBlack(6,0);
                        secondo = true;
                    }
                }
                else if(source == pulsanti[6][2]){
                    if(primo == false && secondo == false) {
                        aux1 = 6;
                        aux2 = 2;
                        primo = true;
                    }

                    else if(primo == true){
                        secondMoveBlack(6,2);
                        secondo = true;
                    }
                }
                else if(source == pulsanti[6][4]){
                    if(primo == false && secondo == false) {
                        aux1 = 6;
                        aux2 = 4;
                        primo = true;
                    }

                    else if(primo == true){
                        secondMoveBlack(6,4);
                        secondo = true;
                    }
                }
                else if(source == pulsanti[6][6]){
                    if(primo == false && secondo == false) {
                        aux1 = 6;
                        aux2 = 6;
                        primo = true;
                    }

                    else if(primo == true){
                        secondMoveBlack(6,6);
                        secondo = true;
                    }
                }

                ////////////////////////////////////
                else if(source == pulsanti[7][1]){
                    if(primo == false && secondo == false) {
                        aux1 = 7;
                        aux2 = 1;
                        primo = true;
                    }

                    else if(primo == true){
                        secondMoveBlack(7,1);
                        secondo = true;
                    }
                }
                else if(source == pulsanti[7][3]){
                    if(primo == false && secondo == false) {
                        aux1 = 7;
                        aux2 = 3;
                        primo = true;
                    }

                    else if(primo == true){
                        secondMoveBlack(7,3);
                        secondo = true;
                    }
                }
                else if(source == pulsanti[7][5]){
                    if(primo == false && secondo == false) {
                        aux1 = 7;
                        aux2 = 5;
                        primo = true;
                    }

                    else if(primo == true){
                        secondMoveBlack(7,5);
                        secondo = true;
                    }
                }
                else if(source == pulsanti[7][7]){
                    if(primo == false && secondo == false) {
                        aux1 = 7;
                        aux2 = 7;
                        primo = true;
                    }

                    else if(primo == true){
                        secondMoveBlack(7,7);
                        secondo = true;
                    }
                }

                if(primo == true && secondo == true){
                    resetBool();
                }

                /*if(e.getSource() == pulsanti[i][j] && primo == false && secondo == false){

                    aux1 = i;
                    aux2 = j;
                    primo = true;
                    pulsanti[i][j].setEnabled(false);
                }

                else if( secondo == false && primo == true){
                    secondMove(aux1,aux2, i,j-1);
                    System.out.println("negro");
                    pulsanti[aux1][aux2].setEnabled(true);
                    secondo = true;
                }*/
       //     }
      //  }

    }
}
