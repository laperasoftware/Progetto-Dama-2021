package GUI;
import User.User;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LogGUI extends JFrame implements ActionListener, WindowListener {

    private JFrame frame = new JFrame();

    private JLabel lb1 = new JLabel("DAMA");
    private JLabel lbb = new JLabel("Nome del Giocatore Nero");
    private JLabel lbw = new JLabel("Nome del Giocatore Bianco");

    private JLabel lb4 = new JLabel("ENTRA");


    private JButton enter = new JButton();


    private JTextField tb = new JTextField(null);
    private JTextField tw = new JTextField(null);

    ImagePanel p = new ImagePanel(new ImageIcon("IMG/Sfondo_Log_In.jpg").getImage());


    private User user1 = new User();
    private User user2 = new User();


    FileWriter fWR = null;
    PrintWriter fOUT;



    public boolean logCheck;


    public LogGUI(){

        super("LogIn");

        setFrame();
        setPanel();
        setLabel();
        setButton();
        setTextField();

        frame.setVisible(true);

    }



    private void setFrame(){

        frame.setSize(1650,1080);
        frame.setLocationRelativeTo(null);

        frame.setBackground(Color.WHITE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setResizable(false);

        frame.addWindowListener(this);

    }


    private void setPanel(){

            frame.getContentPane().add(p);

    }

    


    private void setLabel(){

        lb1.setBounds(820,90,800,250);
        lb1.setFont(new Font("Stencil", Font.BOLD, 96));



        lbb.setBounds(400, 300, 842,262);
        lbb.setFont(new Font("Arial", Font.BOLD, 26));



        lbw.setBounds(400, 360, 842,262);
        lbw.setFont(new Font("Arial", Font.BOLD, 26));



        lb4.setBounds(880,520,800,250);
        lb4.setFont(new Font("Stencil", Font.BOLD, 46));

        p.add(lb1);
        p.add(lbb);
        p.add(lbw);
        p.add(lb4);

    }


    private void setTextField(){

        tb.setBounds(790, 400, 342,62);
        tb.setForeground(new Color(255,255,255));
        tb.setFont(new Font("Consalas", Font.BOLD, 30));
        tb.setBackground(new Color(0,0,0));

        tw.setBounds(790, 460, 342,62);
        tw.setForeground(new Color(0,0,0));
        tw.setFont(new Font("Consalas", Font.BOLD, 30));
        tw.setBackground(new Color(255,255,255));

        p.add(tb);
        p.add(tw);


        tb.setText(null);
        tw.setText(null);


    }




    private void setButton(){

        enter.setBounds(710,690,500,100);
        enter.addActionListener(this);
        enter.setBackground(new Color(255,255,255));

        enter.setText("ENTRA NEL GIOCO");

        enter.setForeground(new Color(0,0,0));
        enter.setFont(new Font("Consalas", Font.BOLD, 30));

        p.add(enter);

    }




    @Override
    public void actionPerformed(ActionEvent e) {

        user1.setNome(tb.getText());
        user2.setNome(tw.getText());


        if (tb.getText().equals("") || tw.getText().equals("") ) {

            JOptionPane.showMessageDialog(null, "Devi riempire i campi", "ERRORE", JOptionPane.INFORMATION_MESSAGE);
            logCheck = false;

        }

        else if (user1.getNome().equals(user2.getNome()) == true) {

            JOptionPane.showMessageDialog(null, "I nomi inseriti sono uguali", "ERRORE", JOptionPane.INFORMATION_MESSAGE);
            tb.setText(null);
            tw.setText(null);
            logCheck = false;


        } else {


            user1.setColore(1);
            user2.setColore(0);

            JOptionPane.showMessageDialog(null, "Login Completato", "AVVIO", JOptionPane.INFORMATION_MESSAGE);

            logCheck = true;

        }

        if (logCheck == true) {

            frame.dispose();
            BoardGUI b = new BoardGUI();
            b.boardDisplay();
        }


    }




    @Override
    public void windowOpened(WindowEvent e) {

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

        try {

            fWR = new FileWriter("FILE/Data.txt");
            fOUT = new PrintWriter(fWR);
            fOUT.println(tb.getText());
            fOUT.flush();
            fOUT.println(tw.getText());
            fOUT.flush();

        } catch (Exception ioException) {
            System.out.println("Errore nel File");
        }

        try {

            fWR.close();

        }

        catch (IOException ioException) {

            ioException.printStackTrace();
        }

    }

}