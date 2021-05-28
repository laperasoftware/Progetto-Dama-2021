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

public class BoardGUI extends JPanel implements ActionListener, WindowListener {

    private User u1 = new User();
    private User u2 = new User();


    private String temp;

    private JPanel scacchiera = new JPanel();


    //private JPanel score = new JPanel(new BorderLayout());


    ImagePanel sinistra = new ImagePanel(new ImageIcon("IMG/Sfondo_Log_In_Sinistra.jpg").getImage());
    ImagePanel nord = new ImagePanel(new ImageIcon("IMG/Sfondo_Log_In.jpg").getImage());
    ImagePanel destra = new ImagePanel(new ImageIcon("IMG/Sfondo_Log_In_Destra.jpg").getImage());

    ImagePanel score = new ImagePanel(new ImageIcon("IMG/Sfondo_Log_In_Sud.jpg").getImage());



    private JButton pulsanti[][] = new JButton[8][8];

    private char posizioni[][] = new char[8][8];

    private JFrame frame = new JFrame();

    private JLabel lb = new JLabel("");





    private boolean primo = false;
    private boolean secondo = false;
    private boolean comp = false;
    boolean doppiaBlack = false;
    boolean doppiaWhite = false;

    private int aux1;
    private int aux2;
    private int cont = 0;


    private Container c;

    private static int checkVittoria = 0;

    public static int getCheckVittoria() {

        return checkVittoria;
    }

    public void boardDisplay() {

        frame.addWindowListener(this);
        c = frame.getContentPane();
        c.setLayout(new BorderLayout());


        setScoreBoard();
        setBoard();

        boardUpdate();

        setLabel();



    }


    private void setBoard() {

        frame.setSize(1650,1080);
        frame.setLocationRelativeTo(null);

        frame.setBackground(Color.WHITE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setResizable(false);


        scacchiera.setLayout(new GridLayout(8, 8, 5, 5));

        setPannelloNord();

        setPannelloDestra();

        setPannelloSinistra();


        score.setBackground(new Color(182, 143, 66));



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

        scacchiera.setPreferredSize(new Dimension(600, 600));
        scacchiera.setBackground(new Color(160, 144, 54));


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




    private void setLabel() {

        lb.setText("INIZIA IL BIANCO");
        lb.setForeground(Color.BLACK);

        lb.setFont(new Font("Stencil", Font.BOLD, 30));

        lb.setBounds(1500,12, 300,300);

        lb.setHorizontalAlignment(JLabel.CENTER);



    }




    public void setScoreBoard() {

        frame.add(lb);

        score.setPreferredSize(new Dimension(100, 100));
        c.add(score, BorderLayout.SOUTH);


    }

    public void setPannelloNord() {


        nord.setPreferredSize(new Dimension(100, 100));
        c.add(nord, BorderLayout.NORTH);


    }

    public void setPannelloDestra() {


        destra.setPreferredSize(new Dimension(500, 500));
        c.add(destra, BorderLayout.EAST);


    }

    public void setPannelloSinistra() {


        sinistra.setPreferredSize(new Dimension(500, 500));
        c.add(sinistra, BorderLayout.WEST);


    }




    public boolean canDoubleBlack(int i, int j) {
        boolean doppia = false;

        if (i == 7) {
            posizioni[i][j] = 'B';
            doppia = true;
        }

        return (doppia);
    }


    public boolean canDoubleWhite(int i, int j) {
        boolean doppia = false;

        if (i == 0) {
            posizioni[i][j] = 'W';
            doppia = true;
        }

        return (doppia);
    }


    private void boardUpdate() {
        for (int i = 0; i < 8; i++) {

            for (int j = 0; j < 8; j++) {

                if (posizioni[i][j] == 'b') {
                    pulsanti[i][j].setIcon(new ImageIcon("IMG/ckW.png"));
                } else if (posizioni[i][j] == 'B') {
                    pulsanti[i][j].setIcon(new ImageIcon("IMG/ckW_Dama.png"));
                }

                if (posizioni[i][j] == 'w') {
                    pulsanti[i][j].setIcon(new ImageIcon("IMG/ckB.png"));

                } else if (posizioni[i][j] == 'W') {
                    pulsanti[i][j].setIcon(new ImageIcon("IMG/ckB_Dama.png"));
                }

                System.out.print(posizioni[i][j] + " ");
            }

            System.out.println();

        }
    }


    private boolean turnBlack(ActionEvent e) {

        boolean disp = false;

        JButton source = (JButton) e.getSource();

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {

                if (source == pulsanti[i][j]) {
                    if (primo == false && secondo == false) {

                        if (posizioni[i][j] != 'b' && posizioni[i][j] != 'B') {

                            JOptionPane.showMessageDialog(null, "La casella selezionata non presenta delle pedine nere", "MOSSA NON VALIDA", JOptionPane.INFORMATION_MESSAGE);
                            primo = false;

                            disp = false;
                        } else if (posizioni[i][j] == 'b' || posizioni[i][j] == 'B') {

                            if (posizioni[i][j] == 'b') {
                                doppiaBlack = false;
                            } else if (posizioni[i][j] == 'B') {
                                doppiaBlack = true;
                            }

                            posizioni[i][j] = '-';
                            pulsanti[i][j].setIcon(null);
                            primo = true;
                            aux1 = i;
                            aux2 = j;
                            boardUpdate();

                            disp = true;
                        }
                    }

                    else if (primo == true) {

                        if (posizioni[i][j] == 'w' || posizioni[i][j] == 'W') {

                            if (doppiaBlack == false) {
                                posizioni[aux1][aux2] = 'b';
                            } else {
                                posizioni[aux1][aux2] = 'B';
                            }

                            JOptionPane.showMessageDialog(null, "La casella selezionata è occupata", "MOSSA NON VALIDA", JOptionPane.INFORMATION_MESSAGE);
                            primo = false;
                            boardUpdate();
                            disp = false;

                        }

                        else if (i == aux1 && j == aux2) {

                            if (doppiaBlack == false) {
                                posizioni[aux1][aux2] = 'b';
                            } else {
                                posizioni[aux1][aux2] = 'B';
                            }
                            JOptionPane.showMessageDialog(null, "Pedina riposizionata alla posizione iniziale", "MOSSA", JOptionPane.INFORMATION_MESSAGE);
                            primo = false;
                            secondo = false;
                            boardUpdate();
                            disp = false;
                        }

                        else if ((i == aux1 - 1 && j == aux2 - 1) || (i == aux1 - 1 && j == aux2 + 1)) {

                            if (doppiaBlack == false) {
                                JOptionPane.showMessageDialog(null, "Tornare indietro non è permesso", "MOSSA NON VALIDA", JOptionPane.INFORMATION_MESSAGE);
                                posizioni[aux1][aux2] = 'b';
                                primo = false;
                                boardUpdate();
                                disp = false;
                            }

                            else {
                                if (posizioni[i][j] == 'w' || posizioni[i][j] == 'W') {
                                    JOptionPane.showMessageDialog(null, "Casella occupata", "MOSSA NON VALIDA", JOptionPane.INFORMATION_MESSAGE);
                                    posizioni[aux1][aux2] = 'B';
                                    secondo = false;
                                    disp = false;
                                    boardUpdate();

                                } else if (posizioni[i][j] == '-') {
                                    pulsanti[i][j].setIcon(new ImageIcon("IMG/ckW_Dama.png"));
                                    posizioni[i][j] = 'B';
                                    posizioni[aux1][aux2] = '-';
                                    secondo = true;
                                    boardUpdate();
                                    resetBool();
                                    disp = true;

                                }
                            }
                        }

                        else if ((posizioni[i][j] == '-' && secondo == false)) {

                            if (((i == aux1 + 1) && (j == aux2 + 1)) || ((i == aux1 + 1) && (j == aux2 - 1))) {

                                if (canDoubleBlack(i, j) == true || doppiaBlack == true) {
                                    posizioni[i][j] = 'B';
                                    pulsanti[i][j].setIcon(new ImageIcon("IMG/ckW_Dama.png"));
                                    doppiaBlack = true;
                                    disp = true;
                                } else {
                                    posizioni[i][j] = 'b';
                                    pulsanti[i][j].setIcon(new ImageIcon("IMG/ckW.png"));
                                    disp = true;
                                }

                                secondo = true;
                                boardUpdate();
                                resetBool();

                            }

                            else if ((i == aux1 + 2) && (j == aux2 + 2)) {

                                if (posizioni[aux1 + 1][aux2 + 1] == 'w') {

                                    if (doppiaBlack == false) {
                                        posizioni[aux1 + 2][aux2 + 2] = 'b';
                                        if (canDoubleBlack(i, j) == true) {
                                            posizioni[aux1 + 2][aux2 + 2] = 'B';
                                            doppiaBlack = true;
                                        }
                                    } else {
                                        posizioni[aux1 + 2][aux2 + 2] = 'B';
                                    }

                                    posizioni[aux1 + 1][aux2 + 1] = '-';
                                    pulsanti[aux1 + 1][aux2 + 1].setIcon(null);
                                    boardUpdate();
                                    resetBool();
                                    disp = true;

                                }
                            }

                            else if ((i == aux1 + 2) && (j == aux2 - 2)) {

                                if (posizioni[aux1 + 1][aux2 - 1] == 'w') {

                                    if (doppiaBlack == false) {
                                        posizioni[aux1 + 2][aux2 - 2] = 'b';
                                        if (canDoubleBlack(i, j) == true) {
                                            posizioni[aux1 + 2][aux2 - 2] = 'B';
                                        }
                                    }

                                    else {
                                        posizioni[aux1 + 2][aux2 - 2] = 'B';
                                    }

                                    posizioni[aux1 + 1][aux2 - 1] = '-';
                                    pulsanti[aux1 + 1][aux2 - 1].setIcon(null);
                                    boardUpdate();
                                    resetBool();
                                    disp = true;

                                }
                            }

                            else if (((i == aux1 - 2) && (j == aux2 - 2)) && doppiaBlack == true) {

                                if (posizioni[aux1 - 1][aux2 - 1] == 'w') {

                                    posizioni[i][j] = 'B';

                                    posizioni[aux1 - 1][aux2 - 1] = '-';
                                    pulsanti[aux1 - 1][aux2 - 1].setIcon(null);
                                    boardUpdate();
                                    resetBool();
                                    disp = true;

                                }

                            }

                            else if (((i == aux1 - 2) && (j == aux2 + 2)) && doppiaBlack == true) {


                                if (posizioni[aux1 - 1][aux2 + 1] == 'w') {

                                    if (doppiaBlack == false) {
                                        posizioni[aux1 - 2][aux2 + 2] = 'b';
                                        if (canDoubleBlack(i, j) == true) {
                                            posizioni[aux1 - 2][aux2 + 2] = 'B';
                                        }
                                    } else {
                                        posizioni[aux1 - 2][aux2 + 2] = 'B';
                                    }
                                    posizioni[aux1 - 1][aux2 + 1] = '-';
                                    pulsanti[aux1 - 1][aux2 + 1].setIcon(null);
                                    boardUpdate();
                                    resetBool();
                                    disp = true;

                                }
                            }

                        }
                    }
                    else if (posizioni[i][j] == 'w') {
                        JOptionPane.showMessageDialog(null, "Casella già occupata", "MOSSA NON VALIDA", JOptionPane.INFORMATION_MESSAGE);

                        if (doppiaBlack == true) {
                            posizioni[aux1][aux2] = 'B';
                        } else {
                            posizioni[aux1][aux2] = 'b';
                        }

                        primo = false;
                        boardUpdate();
                        disp = false;
                    }
                }
            }
        }
        return (disp);
    }



    private boolean turnWhite(ActionEvent e) {
        boolean disp = false;

        JButton source = (JButton) e.getSource();

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {

                if (source == pulsanti[i][j]) {

                    if (primo == false && secondo == false) {


                        if (posizioni[i][j] != 'w' && posizioni[i][j] != 'W') {

                            JOptionPane.showMessageDialog(null, "La casella selezionata non presenta delle pedine bianche", "MOSSA NON VALIDA", JOptionPane.INFORMATION_MESSAGE);
                            primo = false;
                            disp = false;


                        } else if (posizioni[i][j] == 'w' || posizioni[i][j] == 'W') {

                            if (posizioni[i][j] == 'w') {
                                doppiaWhite = false;
                            } else if (posizioni[i][j] == 'W') {
                                doppiaWhite = true;
                            }

                            posizioni[i][j] = '-';
                            pulsanti[i][j].setIcon(null);
                            primo = true;
                            aux1 = i;
                            aux2 = j;


                            boardUpdate();
                            disp = true;

                        }
                    }

                    else if (primo == true) {

                        if (posizioni[i][j] == 'b' || posizioni[i][j] == 'B') {

                            if (doppiaWhite == false) {
                                posizioni[aux1][aux2] = 'w';
                            } else {
                                posizioni[aux1][aux2] = 'W';
                            }

                            JOptionPane.showMessageDialog(null, "La casella selezionata è occupata", "MOSSA NON VALIDA", JOptionPane.INFORMATION_MESSAGE);
                            primo = false;
                            boardUpdate();
                            disp = false;


                        } else if (i == aux1 && j == aux2) {

                            if (doppiaWhite == false) {
                                posizioni[aux1][aux2] = 'w';
                            } else {
                                posizioni[aux1][aux2] = 'W';
                            }

                            JOptionPane.showMessageDialog(null, "Pedina riposizionata alla posizione iniziale", "MOSSA", JOptionPane.INFORMATION_MESSAGE);
                            primo = false;
                            secondo = false;
                            boardUpdate();
                            disp = false;
                        } else if (((i == aux1 + 1) && (j == aux2 + 1)) || ((i == aux1 + 1) && (j == aux2 - 1))) {

                            if (doppiaWhite == false) {
                                JOptionPane.showMessageDialog(null, "Tornare indietro non è permesso", "MOSSA NON VALIDA", JOptionPane.INFORMATION_MESSAGE);
                                posizioni[aux1][aux2] = 'w';
                                primo = false;
                                boardUpdate();
                                disp = false;
                            } else {

                                if (posizioni[i][j] == 'b' || posizioni[i][j] == 'B') {
                                    JOptionPane.showMessageDialog(null, "Casella occupata", "MOSSA NON VALIDA", JOptionPane.INFORMATION_MESSAGE);
                                    posizioni[aux1][aux2] = 'W';
                                    secondo = false;
                                    disp = false;
                                    boardUpdate();

                                } else if (posizioni[i][j] == '-') {
                                    pulsanti[i][j].setIcon(new ImageIcon("IMG/ckB_Dama.png"));
                                    posizioni[i][j] = 'W';
                                    posizioni[aux1][aux2] = '-';
                                    secondo = true;
                                    boardUpdate();
                                    resetBool();
                                    disp = true;
                                }
                            }

                        } else if ((posizioni[i][j] == '-' && secondo == false)) {

                            if (((i == aux1 - 1) && (j == aux2 + 1)) || ((i == aux1 - 1) && (j == aux2 - 1))) {

                                if (canDoubleWhite(i, j) == true || doppiaWhite == true) {
                                    posizioni[i][j] = 'W';
                                    pulsanti[i][j].setIcon(new ImageIcon("IMG/ckB_Dama.png"));
                                    doppiaWhite = true;
                                    disp = true;
                                } else {
                                    posizioni[i][j] = 'w';
                                    pulsanti[i][j].setIcon(new ImageIcon("IMG/ckB.png"));
                                    disp = true;
                                }
                                secondo = true;
                                boardUpdate();
                                resetBool();

                            }

                            if ((i == aux1 - 2) && (j == aux2 + 2)) {

                                if (posizioni[aux1 - 1][aux2 + 1] == 'b') {

                                    if (doppiaWhite == false) {
                                        posizioni[aux1 - 2][aux2 + 2] = 'w';
                                        if (canDoubleWhite(i, j) == true) {
                                            posizioni[aux1 - 2][aux2 + 2] = 'W';
                                            doppiaWhite = true;
                                        }
                                    } else {
                                        posizioni[aux1 - 2][aux2 + 2] = 'W';
                                    }

                                    posizioni[aux1 - 1][aux2 + 1] = '-';
                                    pulsanti[aux1 - 1][aux2 + 1].setIcon(null);
                                    boardUpdate();
                                    resetBool();
                                    disp = true;

                                }
                            }

                            if (((i == aux1 + 2) && (j == aux2 + 2)) && doppiaWhite == true) {


                                if (posizioni[aux1 + 1][aux2 + 1] == 'b') {


                                    posizioni[aux1 + 2][aux2 + 2] = 'W';


                                    posizioni[aux1 + 1][aux2 + 1] = '-';
                                    pulsanti[aux1 + 1][aux2 + 1].setIcon(null);
                                    boardUpdate();
                                    resetBool();
                                    disp = true;

                                }
                            }
                        }

                        if ((i == aux1 - 2) && (j == aux2 - 2)) {


                            if (posizioni[aux1 - 1][aux2 - 1] == 'b') {

                                if (doppiaWhite == false) {
                                    posizioni[aux1 - 2][aux2 - 2] = 'w';
                                    if (canDoubleWhite(i, j) == true) {
                                        posizioni[aux1 - 2][aux2 - 2] = 'W';
                                        doppiaWhite = true;
                                    }
                                } else {
                                    posizioni[aux1 - 2][aux2 - 2] = 'W';
                                }
                                posizioni[aux1 - 1][aux2 - 1] = '-';
                                pulsanti[aux1 - 1][aux2 - 1].setIcon(null);
                                boardUpdate();
                                resetBool();
                                disp = true;

                            }
                        }

                        if (((i == aux1 + 2) && (j == aux2 - 2)) && doppiaWhite == true) {

                            if (doppiaWhite == true) {


                                if (posizioni[aux1 + 1][aux2 - 1] == 'b') {

                                    posizioni[aux1 + 2][aux2 - 2] = 'W';


                                    posizioni[aux1 + 1][aux2 - 1] = '-';
                                    pulsanti[aux1 + 1][aux2 - 1].setIcon(null);
                                    boardUpdate();
                                    resetBool();
                                    disp = true;

                                }

                            }

                        }
                        else if (posizioni[i][j] == 'b') {
                            JOptionPane.showMessageDialog(null, "Casella già occupata", "MOSSA NON VALIDA", JOptionPane.INFORMATION_MESSAGE);
                            if(doppiaWhite == false){
                                posizioni[aux1 - 2][aux2 + 2] = 'w';
                            }

                            else{
                                posizioni[aux1 - 2][aux2 + 2] = 'W';
                            }
                            primo = false;
                            boardUpdate();
                            disp = false;

                        }
                    }

                }
            }
        }
        return (disp);
    }


    private void resetBool() {

        primo = false;
        secondo = false;
    }


    private void vittoriaGB() {

        int cont = 0;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {

                if (posizioni[i][j] == 'w' || posizioni[i][j] == 'W') {


                    cont++;
                }


            }
        }


        if (cont == 0) {

            frame.dispose();


            checkVittoria = 2;

            VictoryGUI v = new VictoryGUI();


        }


    }


    private void vittoriaGW() {

        int cont = 0;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {

                if (posizioni[i][j] == 'b') {


                    cont++;
                }


            }
        }


        if (cont == 0) {


            frame.dispose();

            checkVittoria = 1;

            VictoryGUI v = new VictoryGUI();


        }


    }








    @Override
    public void actionPerformed(ActionEvent e) {


        if (comp == false) {

            if (cont < 2) {

                if (turnWhite(e) == true) {
                    cont++;


                } else {
                    cont--;

                    if (cont < 0) {
                        cont = 0;
                    }
                }

                System.out.println(cont + " " + comp);

                vittoriaGW();

            }


            if (cont == 2) {
                comp = true;
                cont = 3;
                lb.setText("TURNO DI " + u1.getNome().toUpperCase());



            }

            System.out.println(cont + " " + comp);
        } else if (cont < 5 && cont > 2) {

            if (comp == true) {


                if (turnBlack(e) == true) {


                    cont++;

                } else {

                    cont--;

                    if (cont < 3) {

                        cont = 3;

                    }

                }

            }

            vittoriaGB();

        }

        if (cont == 5) {

            cont = 0;
            comp = false;
            lb.setText("TURNO DI " + u2.getNome().toUpperCase());

        }

        System.out.println(cont + " " + comp);

        return;

    }


    @Override
    public void windowOpened(WindowEvent e) {
        boolean g1 = true;
        BufferedReader inputStream = null;

        try {
            inputStream = new BufferedReader(new FileReader("FILE/Data.txt"));
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }

        try {
            temp = inputStream.readLine();
            while (temp != null) {
                if (g1 == true) {
                    System.out.println(temp);
                    u1.setNome(temp);
                    g1 = false;
                } else {
                    System.out.println(temp);
                    u2.setNome(temp);
                    g1 = true;
                }

                temp = inputStream.readLine();
            }
        } catch (Exception fileNotFoundException) {
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


