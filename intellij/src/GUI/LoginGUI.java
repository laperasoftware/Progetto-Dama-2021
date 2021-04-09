package GUI;

import User.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGUI extends JFrame implements ActionListener {

    User user1 = new User();
    User user2 = new User();
    boolean logCheck;

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


        JLabel nm = new JLabel("Giocatore 1:");
        nm.setFont(new Font("Tahoma", Font.BOLD, 18));
        nm.setBounds(200, 80, 180, 29);
        p.add(nm);

        JLabel nm1 = new JLabel("Giocatore 2:");
        nm1.setFont(new Font("Tahoma", Font.BOLD, 18));
        nm1.setBounds(200, 200, 200, 29);
        p.add(nm1);

        /////////////////////////////////////////////////////////////

        JTextField a1 = new JTextField();
        a1.setBounds(380,80,200,30);
        p.add(a1);

        JTextField a2 = new JTextField();
        a2.setBounds(380,200,200,30);
        p.add(a2);


        /////////////////////////////////////////////////////


        JRadioButton rb1 = new JRadioButton();
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
        p.add(rw2);

        ////////////////////////////////////////////////////


        JLabel lb1 = new JLabel("Nero");
        lb1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lb1.setBounds(795, 65, 180, 29);
        p.add(lb1);

        JLabel lw1 = new JLabel("Bianco");
        lw1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lw1.setBounds(795, 90, 200, 29);
        p.add(lw1);

        JLabel lb2 = new JLabel("Nero");
        lb2.setFont(new Font("Tahoma", Font.BOLD, 14));
        lb2.setBounds(795, 185, 185, 29);
        p.add(lb2);

        JLabel lw2 = new JLabel("Bianco");
        lw2.setFont(new Font("Tahoma", Font.BOLD, 14));
        lw2.setBounds(795, 210, 210, 29);
        p.add(lw2);

        //////////////////////////////////////////////////////////

        JLabel c1 = new JLabel("Colore 1:");
        c1.setFont(new Font("Tahoma", Font.BOLD, 16));
        c1.setBounds(650, 80, 210, 29);
        p.add(c1);

        JLabel c2 = new JLabel("Colore 2:");
        c2.setFont(new Font("Tahoma", Font.BOLD, 16));
        c2.setBounds(650, 200, 210, 29);
        p.add(c2);

        /////////////////////////////////////////////////////////////////////

        ButtonGroup g1 = new ButtonGroup();

        ButtonGroup g2 = new ButtonGroup();

        g1.add(rb1);
        g1.add(rw1);

        g2.add(rb2);
        g2.add(rw2);




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

                if(rb1.isSelected() && rb2.isSelected()){
                    JOptionPane.showMessageDialog(f,"I due colori sono uguali");
                    user1.setColore(0);
                    rw2.setSelected(true);
                    user2.setColore(1);
                }

                else if(rw1.isSelected()){
                    user1.setColore(1);
                    rb2.setSelected(true);
                    user2.setColore(0);
                }

                if(rb2.isSelected()){
                    JOptionPane.showMessageDialog(f,"I due colori sono uguali");
                    user1.setColore(0);
                    rw1.setSelected(true);
                    user2.setColore(1);
                }

                else if(rw2.isSelected()){
                    user1.setColore(1);
                    rb1.setSelected(true);
                    user2.setColore(0);
                }

                if(user1.getColore() == user2.getColore()){
                    while(user1.getColore() == user2.getColore()){

                        JOptionPane.showMessageDialog(f,"I due colori sono uguali");

                        if(rb1.isSelected()){

                            user1.setColore(0);
                            rw2.setSelected(true);
                            user2.setColore(1);
                        }

                        else if(rw1.isSelected()){
                            user1.setColore(1);
                            rb2.setSelected(true);
                            user2.setColore(0);
                        }
                    }

                }


                else{


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

    public boolean check(){
        return (logCheck);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
