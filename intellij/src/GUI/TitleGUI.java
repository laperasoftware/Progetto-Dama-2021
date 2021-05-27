package GUI;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TitleGUI extends JFrame implements ActionListener {

    private JFrame frame = new JFrame();
    private JPanel p = new JPanel();

    Container c;

    //private ImageIcon img = new ImageIcon("Sfondo_Log_In.png");

    private JLabel lb1 = new JLabel("DAMA");
    private JLabel lb2 = new JLabel("Alessandro Orlando");
    private JLabel lb3 = new JLabel("Massimiliano Lisi");
    private JLabel lb4 = new JLabel("ENTRA");

    private JButton enter = new JButton();


    ImagePanel panel = new ImagePanel(new ImageIcon("IMG/Sfondo_Log_In.jpg").getImage());




    public TitleGUI(){

        super("LogIn");


        setFrame();
        setPanel();
        setLabel();
        setButton();

        //c = frame.getContentPane();

    }


    private void setFrame(){

        frame.setSize(1650,1080);
        frame.setLocationRelativeTo(null);

        frame.setBackground(Color.WHITE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setResizable(false);

    }


    private void setPanel(){


        frame.getContentPane().add(panel);

    }








    private void setLabel(){

        lb1.setBounds(820,90,800,250);
        lb1.setFont(new Font("Stencil", Font.BOLD, 100));
        lb1.setForeground(Color.BLACK);



        lb2.setBounds(1500, 721, 842,262);
        lb2.setFont(new Font("Arial", Font.BOLD, 26));
        lb2.setForeground(Color.BLACK);


        lb3.setBounds(1500, 761, 842,262);
        lb3.setFont(new Font("Arial", Font.BOLD, 26));
        lb3.setForeground(Color.BLACK);


        lb4.setBounds(880,520,800,250);
        lb4.setFont(new Font("Stencil", Font.BOLD, 46));
        lb4.setForeground(Color.BLACK);



        panel.add(lb1);
        panel.add(lb2);
        panel.add(lb3);
        panel.add(lb4);

    }



    private void setButton(){

        enter.setBounds(835,330,250,250);
        enter.addActionListener(this);
        enter.setBackground(new Color(255,255,255));
        enter.setVisible(true);
        enter.setIcon(new ImageIcon("IMG/entra.png"));



        panel.add(enter);


    }



    @Override
    public void actionPerformed(ActionEvent e) {


        frame.setVisible(false);
        frame.dispose();
        LogGUI b = new LogGUI();

    }


}
