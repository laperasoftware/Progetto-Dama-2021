package GUI;

import User.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGUI extends JFrame implements ActionListener {

    User user1 = new User();
    User user2 = new User();
    boolean logCheck = false;


    public LoginGUI() {


        setTitle("LOGIN");
        setBounds(100, 100, 900, 450);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        Container c=getContentPane();
        c.setLayout(new BorderLayout(5, 5));
        JPanel p = new JPanel();
        p.setLayout(null);
        c.add(p, BorderLayout.CENTER);

        JButton b1= new JButton("Registrazione dati");
        b1.setBounds(380,300,200,30);
        p.add(b1);


        //////////////////////////////////////////////////////////


        JLabel nm = new JLabel("Nome Giocatore Bianco:");
        nm.setFont(new Font("Tahoma", Font.BOLD, 18));
        nm.setBounds(200, 80, 300, 29);
        p.add(nm);

        JLabel nm1 = new JLabel("Nome Giocatore Nero:");
        nm1.setFont(new Font("Tahoma", Font.BOLD, 18));
        nm1.setBounds(200, 200, 300, 29);
        p.add(nm1);

        /////////////////////////////////////////////////////////////

        JTextField a1 = new JTextField();
        a1.setBounds(450,80,200,30);
        p.add(a1);

        JTextField a2 = new JTextField();
        a2.setBounds(450,200,200,30);
        p.add(a2);


        /////////////////////////////////////////////////////


       /* JRadioButton rb1 = new JRadioButton();
        rb1.setBounds(750, 65, 29, 29);
        p.add(rb1);

        JRadioButton rw1 = new JRadioButton();
        rw1.setBounds(750, 90, 29, 29);
        p.add(rw1);



        JRadioButton rb2 = new JRadioButton();
        rb2.setBounds(750, 185, 29, 29);
        p.add(rb2);

        JRadioButton rw2 = new JRadioButton();
        rw2.setBounds(750, 210, 29, 29);
        p.add(rw2);*/




        b1.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {

                JFrame f = new JFrame();

                user1.setNome(a1.getText());
                user2.setNome(a2.getText());




                System.out.println( user1.getNome() + " Colore: ");
                System.out.println( user1.getColore()+ "\n");
                System.out.println( user2.getNome()+ " Colore: ");
                System.out.println( user2.getColore()+ "\n");


                if(user1.getNome().equals(user2.getNome())==true){

                    JOptionPane.showMessageDialog(f,"I due nomi sono uguali");

                }

                else{

                    user1.setColore(1);
                    user2.setColore(0);

                    JOptionPane.showMessageDialog(f,"Login completato");
                    System.out.println( user1.getNome() + " Colore: ");
                    System.out.println( user1.getColore()+ "\n");
                    System.out.println( user2.getNome()+ " Colore: ");
                    System.out.println( user2.getColore()+ "\n");
                    logCheck = true;

                     dispose();
                }

            }
        });
    }
    public boolean getLogCheck(boolean a){
        a = logCheck;

        return a;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
