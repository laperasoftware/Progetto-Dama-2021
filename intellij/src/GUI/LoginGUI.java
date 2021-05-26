package GUI;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class LoginGUI extends JFrame implements ActionListener {

    private JFrame frame = new JFrame();
    private JPanel p = new JPanel();

    Container c;

    private ImageIcon img = new ImageIcon("Sfondo_Log_In.png");

    private JLabel lb1 = new JLabel("DAMA");
    private JLabel lb2 = new JLabel("Alessandro Orlando");
    private JLabel lb3 = new JLabel("Massimiliano Lisi");
    private JLabel lb4 = new JLabel("ENTRA");
    private JLabel background = new JLabel("",img,JLabel.CENTER);

    private JButton enter = new JButton();


    public LoginGUI(){

        super("LogIn");
         c = frame.getContentPane();

        setFrame();
        setPanel();
        setSfondo();
        setLabel();
        setButton();

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

        frame.add(p);

        p.setLayout(null);




    }



    private void setSfondo(){

        background.setBounds(0,0,1650,1080);
        p.add(background);




    }








    private void setLabel(){

        lb1.setBounds(820,90,800,250);
        lb1.setFont(new Font("Stencil", Font.BOLD, 96));



        lb2.setBounds(1500, 721, 842,262);
        lb2.setFont(new Font("Arial", Font.BOLD, 26));



        lb3.setBounds(1500, 761, 842,262);
        lb3.setFont(new Font("Arial", Font.BOLD, 26));



        lb4.setBounds(880,520,800,250);
        lb4.setFont(new Font("Stencil", Font.BOLD, 46));



        p.add(lb1);
        p.add(lb2);
        p.add(lb3);
        p.add(lb4);

    }




    private void setButton(){

        enter.setBounds(800,290,300,300);
        enter.addActionListener(this);
        enter.setBackground(new Color(255,255,255));
        enter.setVisible(true);
        enter.setIcon(new ImageIcon("IMG/entra.png"));



        p.add(enter);


    }



    @Override
    public void actionPerformed(ActionEvent e) {


        frame.setVisible(false);
        frame.dispose();
        LogGUI b = new LogGUI();

    }


}
