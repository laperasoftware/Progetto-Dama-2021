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
    private JPanel score = new JPanel(new BorderLayout());
    private JLabel lb = new JLabel("");
    boolean primo = false;
    boolean secondo = false;
    private int aux1;
    private int aux2;
    private Container c;


    public void boardDisplay() {

        c = frame.getContentPane();
        c.setLayout(new BorderLayout());

        setScoreBoard();
        setBoard();

        boardUpdate();

        setLabel();

    }

    private void setBoard() {

        frame.setSize(800, 800);
        frame.setLocationRelativeTo(null);
        frame.setBackground(Color.lightGray);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        scacchiera.setLayout(new GridLayout(8, 8, 5, 5));


        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {

                pulsanti[i][j] = new JButton();

                pulsanti[i][j].addActionListener(this);

                posizioni[i][j] = '-';

            }

        }


        for (int i = 0; i < 8; i++) {
            int j;

            if (i % 2 == 0) {
                for (j = 0; j < 8; j++) {

                    if (j % 2 == 0) {

                        pulsanti[i][j].setBackground(Color.BLACK);

                    } else {
                        pulsanti[i][j].setBackground(Color.WHITE);
                        pulsanti[i][j].setEnabled(false);
                    }
                }

            } else {
                for (j = 0; j < 8; j++) {

                    if (j % 2 == 0) {

                        pulsanti[i][j].setBackground(Color.WHITE);
                        pulsanti[i][j].setEnabled(false);
                    } else {
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

        scacchiera.setPreferredSize(new Dimension(600,600));
        c.add(scacchiera, BorderLayout.CENTER);

////////////////////////////////////////////////////////////////////////////////////////////////

        for (int i = 0; i < 3; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < 8; j++) {
                    if (j % 2 == 0) {
                        posizioni[i][j] = 'b';
                    }

                }
            } else {
                for (int j = 0; j < 8; j++) {
                    if (j % 2 != 0) {
                        posizioni[i][j] = 'b';
                    }
                }
            }

        }

//////////////////////////////////////////////////////////////////////////////////////

        for (int i = 5; i < 8; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < 8; j++) {
                    if (j % 2 == 0) {
                        posizioni[i][j] = 'w';

                    }

                }
            } else {
                for (int j = 0; j < 8; j++) {
                    if (j % 2 != 0) {
                        posizioni[i][j] = 'w';
                    }
                }
            }
        }
    }


    private void setLabel(){

        lb.setText("TURNO G1");
        lb.setForeground(new Color(0,0,0));
        lb.setFont(new Font("Consalas", Font.BOLD, 30));






    }



    public void setScoreBoard(){

        lb.setHorizontalAlignment(JLabel.CENTER);

        score.add(lb);

        score.setPreferredSize(new Dimension(100,100));
        c.add(score,BorderLayout.SOUTH);


    }

    private void boardUpdate() {
        for (int i = 0; i < 8; i++) {

            for (int j = 0; j < 8; j++) {

                if (posizioni[i][j] == 'b') {
                    pulsanti[i][j].setIcon(new ImageIcon("IMG/ckW.png"));
                }

                else if (posizioni[i][j] == 'w') {
                    pulsanti[i][j].setIcon(new ImageIcon("IMG/ckB.png"));

                }
                System.out.print(posizioni[i][j] + " ");
            }

            System.out.println();

        }
    }

    private boolean turnoGB(ActionEvent e){

        boolean comp = false;

        JButton source = (JButton) e.getSource();

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {

                if(source == pulsanti[i][j]){
                    if(primo == false && secondo == false){


                        if(posizioni[i][j] != 'b'){

                           JOptionPane.showMessageDialog(null, "La casella selezionata non presenta delle pedine", "MOSSA NON VALIDA", JOptionPane.INFORMATION_MESSAGE);
                           primo = false;

                        }

                        else if(posizioni[i][j] == 'b'){

                            posizioni[i][j] = '-';
                            pulsanti[i][j].setIcon(null);
                            primo = true;
                            aux1 = i;
                            aux2 = j;
                            boardUpdate();


                        }
                    }


                    else if(primo == true){

                        if (posizioni[i][j] == 'b') {

                            JOptionPane.showMessageDialog(null, "La casella selezionata è occupata", "MOSSA NON VALIDA", JOptionPane.INFORMATION_MESSAGE);
                            posizioni[aux1][aux2] = 'b';
                            primo = false;
                            boardUpdate();

                        }

                        else if(posizioni[i][j] == '-' && secondo == false){

                           if (((i == aux1 + 1) && (j == aux2 + 1)) || ((i == aux1 + 1) && (j == aux2 - 1))) {

                               posizioni[i][j] = 'b';
                               pulsanti[i][j].setIcon(new ImageIcon("IMG/ckW.png"));
                               secondo = true;
                               boardUpdate();
                               resetBool();
                               comp = true;
                           }
                        }
                    }
                }
            }
        }
        return (comp);
}

    private boolean turnoGW(ActionEvent e){

        boolean comp = false;

        JButton source = (JButton) e.getSource();

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {

                if(source == pulsanti[i][j]){
                    if(primo == false && secondo == false){


                        if(posizioni[i][j] != 'w'){

                            JOptionPane.showMessageDialog(null, "La casella selezionata non presenta delle pedine", "MOSSA NON VALIDA", JOptionPane.INFORMATION_MESSAGE);
                            primo = false;

                        }

                        else if(posizioni[i][j] == 'w'){

                            posizioni[i][j] = '-';
                            pulsanti[i][j].setIcon(null);
                            primo = true;
                            aux1 = i;
                            aux2 = j;
                            boardUpdate();


                        }
                    }


                    else if(primo == true){

                        if (posizioni[i][j] == 'w') {

                            JOptionPane.showMessageDialog(null, "La casella selezionata è occupata", "MOSSA NON VALIDA", JOptionPane.INFORMATION_MESSAGE);
                            posizioni[aux1][aux2] = 'w';
                            primo = false;
                            boardUpdate();

                        }

                        else if(posizioni[i][j] == '-' && secondo == false){

                            if (((i == aux1 - 1) && (j == aux2 + 1)) || ((i == aux1 - 1) && (j == aux2 - 1))) {

                                posizioni[i][j] = 'w';
                                pulsanti[i][j].setIcon(new ImageIcon("IMG/ckB.png"));
                                secondo = true;
                                boardUpdate();
                                resetBool();
                                comp = true;
                            }
                        }
                    }
                }
            }
        }
        return (comp);
    }






    private void resetBool(){
        primo = false;
        secondo = false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(turnoGB(e) == true){
            lb.setText("Giocatore 2");
        }
        else{
            turnoGW(e);
        }


    }
}