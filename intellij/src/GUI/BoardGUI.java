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
    private JPanel score = new JPanel(new BorderLayout());

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

        frame.setSize(800, 800);
        frame.setLocationRelativeTo(null);
        frame.setBackground(Color.lightGray);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);


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

        scacchiera.setPreferredSize(new Dimension(600, 600));
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
        lb.setForeground(new Color(0, 0, 0));
        lb.setFont(new Font("Consalas", Font.BOLD, 30));


    }


    public void setScoreBoard() {

        lb.setHorizontalAlignment(JLabel.CENTER);

        score.add(lb);

        score.setPreferredSize(new Dimension(100, 100));
        c.add(score, BorderLayout.SOUTH);


    }


    public boolean canDoubleBlack(int i, int j){
        boolean doppia = false;

        if(i == 7){
            posizioni[i][j] = 'B';
            doppia = true;
        }

        return (doppia);
    }


    public boolean canDoubleWhite(int i, int j){
        boolean doppia = false;

        if(i == 0){
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
                }
                else if(posizioni[i][j] == 'B'){
                    pulsanti[i][j].setIcon(new ImageIcon("IMG/ckW_Dama.png"));
                }

                if (posizioni[i][j] == 'w') {
                    pulsanti[i][j].setIcon(new ImageIcon("IMG/ckB.png"));

                }

                else if(posizioni[i][j] == 'W'){
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
                        }

                        else if (posizioni[i][j] == 'b' || posizioni[i][j] == 'B') {

                            if(posizioni[i][j] == 'b'){
                                doppiaBlack = false;
                            }

                            else if( posizioni[i][j] == 'B'){
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

                            if(doppiaBlack == false){
                                posizioni[aux1][aux2] = 'b';
                            }

                            else{
                                posizioni[aux1][aux2] = 'B';
                            }

                            JOptionPane.showMessageDialog(null, "La casella selezionata è occupata", "MOSSA NON VALIDA", JOptionPane.INFORMATION_MESSAGE);
                            primo = false;
                            boardUpdate();
                            disp = false;

                        }

                        else if(i == aux1 && j == aux2){

                            if(doppiaBlack == false){
                                posizioni[aux1][aux2] = 'b';
                            }

                            else{
                                posizioni[aux1][aux2] = 'B';
                            }
                            JOptionPane.showMessageDialog(null, "Pedina riposizionata alla posizione iniziale", "MOSSA", JOptionPane.INFORMATION_MESSAGE);
                            primo = false;
                            secondo = false;
                            boardUpdate();
                            disp = false;
                        }

                        else if (((i == aux1 - 1) && (j == aux2 + 1)) || ((i == aux1 - 1) && (j == aux2 - 1))) {

                            if(doppiaBlack == false){
                                JOptionPane.showMessageDialog(null, "Tornare indietro non è permesso", "MOSSA NON VALIDA", JOptionPane.INFORMATION_MESSAGE);
                                posizioni[aux1][aux2] = 'b';
                                primo = false;
                                boardUpdate();
                                disp = false;
                            }

                            else {
                                if(posizioni[i][j] == 'w' || posizioni[i][j] == 'W'){
                                    JOptionPane.showMessageDialog(null, "Casella occupata", "MOSSA NON VALIDA", JOptionPane.INFORMATION_MESSAGE);
                                    posizioni[aux1][aux2] = 'B';
                                    secondo = false;
                                    disp = false;
                                    boardUpdate();

                                }

                                else if(posizioni[i][j] == '-'){
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

                                if(canDoubleBlack( i,  j) == true || doppiaBlack == true){
                                    posizioni[i][j] = 'B';
                                    pulsanti[i][j].setIcon(new ImageIcon("IMG/ckW_Dama.png"));
                                    doppiaBlack = true;
                                    disp = true;
                                }
                                else{
                                    posizioni[i][j] = 'b';
                                    pulsanti[i][j].setIcon(new ImageIcon("IMG/ckW.png"));
                                    disp = true;
                                }

                                secondo = true;
                                boardUpdate();
                                resetBool();

                            }

                            else if((i == aux1 + 2) && (j == aux2 + 2)){
                                if(j < 6 && j > 0) {


                                    if (posizioni[aux1 + 1][aux2 + 1] == 'w') {

                                        if(doppiaBlack == false){
                                            posizioni[aux1 + 2][aux2 +2] = 'b';
                                            if(canDoubleBlack(i,j) == true){
                                                posizioni[aux1 + 2][aux2 +2] = 'B';
                                                doppiaBlack = true;
                                            }
                                        }

                                        else{
                                            posizioni[aux1 + 2][aux2 +2] = 'B';
                                        }

                                        posizioni[aux1 + 1][aux2 + 1] = '-';
                                        pulsanti[aux1 + 1][aux2 + 1].setIcon(null);
                                        boardUpdate();
                                        resetBool();
                                        disp = true;

                                    }
                                }

                                if(j == 7 || j == 6){
                                    if (posizioni[aux1 + 1][aux2 + 1] == 'w') {

                                        if(doppiaBlack == false){
                                            posizioni[aux1 + 2][aux2 +2] = 'b';
                                            if(canDoubleBlack(i,j) == true){
                                                posizioni[aux1 + 2][aux2 +2] = 'B';
                                                doppiaBlack = true;
                                            }
                                        }

                                        else{
                                            posizioni[aux1 + 2][aux2 +2] = 'B';
                                        }

                                        posizioni[aux1 + 1][aux2 + 1] = '-';
                                        pulsanti[aux1 + 1][aux2 + 1].setIcon(null);
                                        boardUpdate();
                                        resetBool();
                                        disp = true;

                                    }
                                }

                                else if(j == 0){
                                    if (posizioni[aux1 + 1][aux2 + 1] == 'w') {

                                        if(doppiaBlack == false){
                                            posizioni[aux1 + 2][aux2 +2] = 'b';
                                            if(canDoubleBlack(i,j) == true){
                                                posizioni[aux1 + 2][aux2 +2] = 'B';
                                                doppiaBlack = true;
                                            }
                                        }

                                        else{
                                            posizioni[aux1 + 2][aux2 +2] = 'B';
                                        }

                                        posizioni[aux1 + 1][aux2 + 1] = '-';
                                        pulsanti[aux1 + 1][aux2 + 1].setIcon(null);
                                        boardUpdate();
                                        resetBool();
                                        disp = true;

                                    }
                                }
                            }

                            else if((i == aux1 + 2) && (j == aux2 - 2)){
                                if(j < 6 && j > 0) {


                                    if (posizioni[aux1 + 1][aux2 - 1] == 'w') {

                                        if(doppiaBlack == false){
                                            posizioni[aux1 + 2][aux2 - 2] = 'b';
                                            if(canDoubleBlack(i,j) == true){
                                                posizioni[aux1 + 2][aux2 - 2] = 'B';
                                            }
                                        }

                                        else{
                                            posizioni[aux1 + 2][aux2 -2] = 'B';
                                        }

                                        posizioni[aux1 + 1][aux2 - 1] = '-';
                                        pulsanti[aux1 + 1][aux2 - 1].setIcon(null);
                                        boardUpdate();
                                        resetBool();
                                        disp = true;

                                    }
                                }

                                if(j == 7 || j == 6){
                                    if (posizioni[aux1 + 1][aux2 - 1] == 'w') {

                                            if(doppiaBlack == false){
                                                posizioni[aux1 + 2][aux2 - 2] = 'b';
                                                if(canDoubleBlack(i,j) == true){
                                                    posizioni[aux1 + 2][aux2 - 2] = 'B';
                                                }
                                            }

                                            else{
                                                posizioni[aux1 + 2][aux2 -2] = 'B';
                                            }
                                        posizioni[aux1 + 1][aux2 - 1] = '-';
                                        pulsanti[aux1 + 1][aux2 - 1].setIcon(null);
                                        boardUpdate();
                                        resetBool();
                                        disp = true;

                                    }
                                }

                                else if(j == 0){
                                    if (posizioni[aux1 + 1][aux2 - 1] == 'w') {

                                            if(doppiaBlack == false){
                                                posizioni[aux1 + 2][aux2 - 2] = 'b';
                                                if(canDoubleBlack(i,j) == true){
                                                    posizioni[aux1 + 2][aux2 - 2] = 'B';
                                                }
                                            }

                                            else{
                                                posizioni[aux1 + 2][aux2 -2] = 'B';
                                            }
                                        posizioni[aux1 + 1][aux2 - 1] = '-';
                                        pulsanti[aux1 + 1][aux2 - 1].setIcon(null);
                                        boardUpdate();
                                        resetBool();
                                        disp = true;

                                    }
                                }
                            }

                            else if((i == aux1 - 2) && (j == aux2 - 2)){
                                if(j < 6 && j > 0) {


                                    if (posizioni[aux1 - 1][aux2 - 1] == 'w') {

                                        if(doppiaBlack == false){
                                            posizioni[aux1 - 2][aux2 - 2] = 'b';
                                            if(canDoubleBlack(i,j) == true){
                                                posizioni[aux1 + 2][aux2 + 2] = 'B';
                                            }
                                        }

                                        else{
                                            posizioni[aux1 - 2][aux2 - 2] = 'B';
                                        }
                                        posizioni[aux1 - 1][aux2 - 1] = '-';
                                        pulsanti[aux1 - 1][aux2 - 1].setIcon(null);
                                        boardUpdate();
                                        resetBool();
                                        disp = true;

                                    }
                                }

                                if(j == 7 && i == 6){
                                    if (posizioni[aux1 - 1][aux2 - 1] == 'w') {

                                        if(doppiaBlack == false){
                                            posizioni[aux1 - 2][aux2 - 2] = 'b';
                                            if(canDoubleBlack(i,j) == true){
                                                posizioni[aux1 + 2][aux2 + 2] = 'B';
                                            }
                                        }

                                        else{
                                            posizioni[aux1 - 2][aux2 - 2] = 'B';
                                        }
                                        posizioni[aux1 - 1][aux2 - 1] = '-';
                                        pulsanti[aux1 - 1][aux2 - 1].setIcon(null);
                                        boardUpdate();
                                        resetBool();
                                        disp = true;

                                    }
                                }

                                else if(j == 0){
                                    if (posizioni[aux1 - 1][aux2 - 1] == 'w') {

                                        if(doppiaBlack == false){
                                            posizioni[aux1 - 2][aux2 - 2] = 'b';
                                            if(canDoubleBlack(i,j) == true){
                                                posizioni[aux1 + 2][aux2 + 2] = 'B';
                                            }
                                        }

                                        else{
                                            posizioni[aux1 - 2][aux2 - 2] = 'B';
                                        }
                                        posizioni[aux1 - 1][aux2 - 1] = '-';
                                        pulsanti[aux1 - 1][aux2 - 1].setIcon(null);
                                        boardUpdate();
                                        resetBool();
                                        disp = true;

                                    }
                                }
                            }

                            else if((i == aux1 - 2) && (j == aux2 + 2)){
                                if(j < 6 && j > 0) {


                                    if (posizioni[aux1 - 1][aux2 + 1] == 'w') {

                                        if(doppiaBlack == false){
                                            posizioni[aux1 - 2][aux2 + 2] = 'b';
                                            if(canDoubleBlack(i,j) == true){
                                                posizioni[aux1 + 2][aux2 + 2] = 'B';
                                            }
                                        }

                                        else{
                                            posizioni[aux1 - 2][aux2 + 2] = 'B';
                                        }
                                        posizioni[aux1 - 1][aux2 + 1] = '-';
                                        pulsanti[aux1 - 1][aux2 + 1].setIcon(null);
                                        boardUpdate();
                                        resetBool();
                                        disp = true;

                                    }
                                }

                                if(j == 7 && i == 6){
                                    if (posizioni[aux1 - 1][aux2 + 1] == 'w') {

                                        if(doppiaBlack == false){
                                            posizioni[aux1 - 2][aux2 + 2] = 'b';
                                            if(canDoubleBlack(i,j) == true){
                                                posizioni[aux1 + 2][aux2 + 2] = 'B';
                                            }
                                        }

                                        else{
                                            posizioni[aux1 - 2][aux2 + 2] = 'B';
                                        }
                                        posizioni[aux1 - 1][aux2 + 1] = '-';
                                        pulsanti[aux1 - 1][aux2 + 1].setIcon(null);
                                        boardUpdate();
                                        resetBool();
                                        disp = true;

                                    }
                                }

                                else if(j == 0){
                                    if (posizioni[aux1 - 1][aux2 + 1] == 'w') {

                                        if(doppiaBlack == false){
                                            posizioni[aux1 - 2][aux2 + 2] = 'b';
                                            if(canDoubleBlack(i,j) == true){
                                                posizioni[aux1 + 2][aux2 + 2] = 'B';
                                            }
                                        }

                                        else{
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

                            if(doppiaBlack == true){
                                posizioni[aux1][aux2] = 'B';
                            }

                            else{
                                posizioni[aux1][aux2] = 'b';
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


                        }

                        else if (posizioni[i][j] == 'w' || posizioni[i][j] == 'W') {

                            if(posizioni[i][j] == 'w'){
                                doppiaWhite = false;
                            }
                            else if(posizioni[i][j] == 'W'){
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

                            if(doppiaWhite == false ){
                                posizioni[aux1][aux2] = 'w';
                            }

                            else{
                                posizioni[aux1][aux2] = 'W';
                            }

                            JOptionPane.showMessageDialog(null, "La casella selezionata è occupata", "MOSSA NON VALIDA", JOptionPane.INFORMATION_MESSAGE);
                            primo = false;
                            boardUpdate();
                            disp = false;


                        }

                        else if(i == aux1 && j == aux2){

                            if(doppiaWhite == false){
                                posizioni[aux1][aux2] = 'w';
                            }

                            else{
                                posizioni[aux1][aux2] = 'W';
                            }

                            JOptionPane.showMessageDialog(null, "Pedina riposizionata alla posizione iniziale", "MOSSA", JOptionPane.INFORMATION_MESSAGE);
                            primo = false;
                            secondo = false;
                            boardUpdate();
                            disp = false;
                        }

                        else if (((i == aux1 + 1) && (j == aux2 + 1)) || ((i == aux1 + 1) && (j == aux2 - 1))) {

                            if(doppiaWhite == false){
                                JOptionPane.showMessageDialog(null, "Tornare indietro non è permesso", "MOSSA NON VALIDA", JOptionPane.INFORMATION_MESSAGE);
                                posizioni[aux1][aux2] = 'w';
                                primo = false;
                                boardUpdate();
                                disp = false;
                            }

                            else{

                                if(posizioni[i][j] == 'b' || posizioni[i][j] == 'B'){
                                    JOptionPane.showMessageDialog(null, "Casella occupata", "MOSSA NON VALIDA", JOptionPane.INFORMATION_MESSAGE);
                                    posizioni[aux1][aux2] = 'W';
                                    secondo = false;
                                    disp = false;
                                    boardUpdate();

                                }

                                else if(posizioni[i][j] == '-'){
                                    pulsanti[i][j].setIcon(new ImageIcon("IMG/ckB_Dama.png"));
                                    posizioni[i][j] = 'W';
                                    posizioni[aux1][aux2] = '-';
                                    secondo = true;
                                    boardUpdate();
                                    resetBool();
                                    disp = true;
                                }
                            }

                        }

                        else if ((posizioni[i][j] == '-' && secondo == false)) {

                            if (((i == aux1 - 1) && (j == aux2 + 1)) || ((i == aux1 - 1) && (j == aux2 - 1))) {

                                if(canDoubleWhite( i,  j) == true || doppiaWhite == true){
                                    posizioni[i][j] = 'W';
                                    pulsanti[i][j].setIcon(new ImageIcon("IMG/ckB_Dama.png"));
                                    doppiaWhite = true;
                                    disp = true;
                                }
                                else{
                                    posizioni[i][j] = 'w';
                                    pulsanti[i][j].setIcon(new ImageIcon("IMG/ckB.png"));
                                    disp = true;
                                }
                                secondo = true;
                                boardUpdate();
                                resetBool();

                            }

                            if ((i == aux1 - 2) && (j == aux2 + 2)){
                                if(j < 6 && j > 0) {

                                    if (posizioni[aux1 - 1][aux2 + 1] == 'b') {

                                        if(doppiaWhite == false){
                                            posizioni[aux1 - 2][aux2 + 2] = 'w';
                                            if(canDoubleWhite(i,j) == true){
                                                posizioni[aux1 - 2][aux2 + 2] = 'W';
                                                doppiaWhite = true;
                                            }
                                        }

                                        else{
                                            posizioni[aux1 - 2][aux2 + 2] = 'W';
                                        }

                                        posizioni[aux1 - 1][aux2 + 1] = '-';
                                        pulsanti[aux1 - 1][aux2 + 1].setIcon(null);
                                        boardUpdate();
                                        resetBool();
                                        disp = true;

                                    }
                                }

                                if(j == 7 || j == 6){
                                    if (posizioni[aux1 - 1][aux2 + 1] == 'b') {

                                        if(doppiaWhite == false){
                                            posizioni[aux1 - 2][aux2 + 2] = 'w';
                                            if(canDoubleWhite(i,j) == true){
                                                posizioni[aux1 - 2][aux2 + 2] = 'W';
                                            }
                                        }

                                        else{
                                            posizioni[aux1 - 2][aux2 + 2] = 'W';
                                        }
                                        posizioni[aux1 - 1][aux2 + 1] = '-';
                                        pulsanti[aux1 - 1][aux2 + 1].setIcon(null);
                                        boardUpdate();
                                        resetBool();
                                        disp = true;

                                    }
                                }

                                else if(j == 0){
                                    if (posizioni[aux1 - 1][aux2 + 1] == 'b') {

                                        if(doppiaWhite == false){
                                            posizioni[aux1 - 2][aux2 + 2] = 'w';
                                            if(canDoubleWhite(i,j) == true){
                                                posizioni[aux1 - 2][aux2 + 2] = 'W';
                                            }
                                        }

                                        else{
                                            posizioni[aux1 - 2][aux2 + 2] = 'W';
                                        }
                                        posizioni[aux1 - 1][aux2 + 1] = '-';
                                        pulsanti[aux1 - 1][aux2 + 1].setIcon(null);
                                        boardUpdate();
                                        resetBool();
                                        disp = true;

                                    }
                                }
                            }

                            if (((i == aux1 + 2) && (j == aux2 + 2)) && doppiaWhite == true){

                                if(doppiaWhite == true){

                                if(j < 6 && j > 0) {

                                    if (posizioni[aux1 + 1][aux2 - 1] == 'b') {

                                        if(doppiaWhite == false){
                                            posizioni[aux1 + 2][aux2 + 2] = 'w';
                                            if(canDoubleWhite(i,j) == true){
                                                posizioni[aux1 + 2][aux2 + 2] = 'W';
                                            }
                                        }

                                        else{
                                            posizioni[aux1 + 2][aux2 + 2] = 'W';
                                        }

                                        posizioni[aux1 + 1][aux2 + 1] = '-';
                                        pulsanti[aux1 + 1][aux2 + 1].setIcon(null);
                                        boardUpdate();
                                        resetBool();
                                        disp = true;

                                    }
                                }

                                if(j == 7 || j == 6){
                                    if (posizioni[aux1 + 1][aux2 + 1] == 'b') {

                                        if(doppiaWhite == false){
                                            posizioni[aux1 + 2][aux2 + 2] = 'w';
                                            if(canDoubleWhite(i,j) == true){
                                                posizioni[aux1 + 2][aux2 + 2] = 'W';
                                            }
                                        }

                                        else{
                                            posizioni[aux1 + 2][aux2 + 2] = 'W';
                                        }
                                        posizioni[aux1 + 1][aux2 + 1] = '-';
                                        pulsanti[aux1 + 1][aux2 + 1].setIcon(null);
                                        boardUpdate();
                                        resetBool();
                                        disp = true;

                                    }
                                }

                                else if(j == 0) {
                                    if (posizioni[aux1 + 1][aux2 + 1] == 'b') {

                                        if (doppiaWhite == false) {
                                            posizioni[aux1 + 2][aux2 + 2] = 'w';
                                            if (canDoubleWhite(i, j) == true) {
                                                posizioni[aux1 + 2][aux2 + 2] = 'W';
                                            }
                                        } else {
                                            posizioni[aux1 + 2][aux2 + 2] = 'W';
                                        }
                                        posizioni[aux1 + 1][aux2 + 1] = '-';
                                        pulsanti[aux1 + 1][aux2 + 1].setIcon(null);
                                        boardUpdate();
                                        resetBool();
                                        disp = true;

                                        }
                                    }
                                }

                                else{
                                    JOptionPane.showMessageDialog(null, "Tornare indietro non è permesso", "MOSSA NON VALIDA", JOptionPane.INFORMATION_MESSAGE);
                                    posizioni[aux1][aux2] = 'w';
                                    secondo = false;
                                    boardUpdate();
                                    disp = false;
                                }
                            }

                            if((i == aux1 - 2) && (j == aux2 - 2)){

                                if(j < 6 && j > 0) {


                                    if (posizioni[aux1 - 1][aux2 - 1] == 'b') {

                                        if(doppiaWhite == false){
                                            posizioni[aux1 - 2][aux2 - 2] = 'w';
                                            if(canDoubleWhite(i,j) == true){
                                                posizioni[aux1 - 2][aux2 - 2] = 'W';
                                                doppiaWhite = true;
                                            }
                                        }

                                        else{
                                            posizioni[aux1 - 2][aux2 - 2] = 'W';
                                        }
                                        posizioni[aux1 - 1][aux2 - 1] = '-';
                                        pulsanti[aux1 - 1][aux2 - 1].setIcon(null);
                                        boardUpdate();
                                        resetBool();
                                        disp = true;

                                    }
                                }

                                if(j == 7 && i == 6){
                                    if (posizioni[aux1 - 1][aux2 - 1] == 'b') {

                                        if(doppiaWhite == false){
                                            posizioni[aux1 - 2][aux2 - 2] = 'w';
                                        }

                                        else{
                                            posizioni[aux1 - 2][aux2 - 2] = 'W';
                                        }
                                        posizioni[aux1 - 1][aux2 - 1] = '-';
                                        pulsanti[aux1 - 1][aux2 - 1].setIcon(null);
                                        boardUpdate();
                                        resetBool();
                                        disp = true;

                                    }
                                }

                                else if(j == 0){
                                    if (posizioni[aux1 - 1][aux2 - 1] == 'b') {

                                        if(doppiaWhite == false){
                                            posizioni[aux1 - 2][aux2 - 2] = 'w';
                                        }

                                        else{
                                            posizioni[aux1 - 2][aux2 - 2] = 'W';
                                        }
                                        posizioni[aux1 - 1][aux2 - 1] = '-';
                                        pulsanti[aux1 - 1][aux2 - 1].setIcon(null);
                                        boardUpdate();
                                        resetBool();
                                        disp = true;

                                    }
                                }
                            }

                            if (((i == aux1 + 2) && (j == aux2 - 2)) && doppiaWhite == true){

                                if(doppiaWhite == true) {

                                    if (j < 6 && j > 0) {

                                        if (posizioni[aux1 + 1][aux2 - 1] == 'b') {

                                            if (doppiaWhite == false) {
                                                posizioni[aux1 + 2][aux2 - 2] = 'w';
                                                if (canDoubleWhite(i, j) == true) {
                                                    posizioni[aux1 + 2][aux2 - 2] = 'W';
                                                }
                                            } else {
                                                posizioni[aux1 + 2][aux2 - 2] = 'W';
                                            }

                                            posizioni[aux1 + 1][aux2 - 1] = '-';
                                            pulsanti[aux1 + 1][aux2 - 1].setIcon(null);
                                            boardUpdate();
                                            resetBool();
                                            disp = true;

                                        }
                                    }

                                    if (j == 7 || j == 6) {
                                        if (posizioni[aux1 + 1][aux2 - 1] == 'b') {

                                            if (doppiaWhite == false) {
                                                posizioni[aux1 + 2][aux2 - 2] = 'w';
                                                if (canDoubleWhite(i, j) == true) {
                                                    posizioni[aux1 + 2][aux2 - 2] = 'W';
                                                }
                                            } else {
                                                posizioni[aux1 + 2][aux2 - 2] = 'W';
                                            }
                                            posizioni[aux1 + 1][aux2 - 1] = '-';
                                            pulsanti[aux1 + 1][aux2 - 1].setIcon(null);
                                            boardUpdate();
                                            resetBool();
                                            disp = true;

                                        }
                                    } else if (j == 0) {
                                        if (posizioni[aux1 + 1][aux2 - 1] == 'b') {

                                            if (doppiaWhite == false) {
                                                posizioni[aux1 + 2][aux2 - 2] = 'w';
                                                if (canDoubleWhite(i, j) == true) {
                                                    posizioni[aux1 + 2][aux2 - 2] = 'W';
                                                }
                                            } else {
                                                posizioni[aux1 + 2][aux2 - 2] = 'W';
                                            }
                                            posizioni[aux1 + 1][aux2 - 1] = '-';
                                            pulsanti[aux1 + 1][aux2 - 1].setIcon(null);
                                            boardUpdate();
                                            resetBool();
                                            disp = true;

                                        }
                                    }
                                }

                                else{
                                    JOptionPane.showMessageDialog(null, "Tornare indietro non è permesso", "MOSSA NON VALIDA", JOptionPane.INFORMATION_MESSAGE);
                                    posizioni[aux1][aux2] = 'w';
                                    secondo = false;
                                    boardUpdate();
                                    disp = false;
                                }

                            }
                        }
                    }

                    else if (posizioni[i][j] == 'b') {
                        JOptionPane.showMessageDialog(null, "Casella già occupata", "MOSSA NON VALIDA", JOptionPane.INFORMATION_MESSAGE);
                        /*if(doppia == false){
                            posizioni[aux1 - 2][aux2 + 2] = 'w';
                        }

                        else{
                            posizioni[aux1 - 2][aux2 + 2] = 'W';
                        }*/
                        primo = false;
                        boardUpdate();
                        disp = false;

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

            JOptionPane.showMessageDialog(null, "HA VINTO IL GIOCATORE " + u2.getNome(), "VITTORIA", JOptionPane.INFORMATION_MESSAGE);
            frame.dispose();


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

            JOptionPane.showMessageDialog(null, "HA VINTO IL GIOCATORE 1", "VITTORIA", JOptionPane.INFORMATION_MESSAGE);
            frame.dispose();


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
                lb.setText("TURNO: " + u1.getNome().toUpperCase());
                lb.setForeground(Color.WHITE);
                score.setBackground(Color.BLACK);
            }

            System.out.println(cont + " " + comp);
        }





        else if (cont < 5 && cont > 2) {

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
            lb.setText("TURNO: " + u2.getNome().toUpperCase());
            lb.setForeground(Color.BLACK);
            score.setBackground(Color.WHITE);

        }

        System.out.println(cont + " " + comp);

        return;

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


