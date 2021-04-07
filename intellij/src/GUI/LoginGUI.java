package GUI;

import User.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGUI extends JFrame implements ActionListener {

    User user1 = new User();
    User user2 = new User();

    public LoginGUI() {
        setTitle("LOGIN");
        setBounds(100, 100, 1280, 720);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c=getContentPane();
        c.setLayout(new BorderLayout(5, 5));
        JPanel p = new JPanel();
        p.setLayout(null);
        c.add(p, BorderLayout.CENTER);

        JButton b1= new JButton("Registrazione dati");
        b1.setBounds(230,250,200,30);
        p.add(b1);

        JLabel nm = new JLabel("Nome Giocatore 1:");
        nm.setFont(new Font("Tahoma", Font.BOLD, 18));
        nm.setBounds(150, 80, 180, 29);
        p.add(nm);

        JLabel nm1 = new JLabel("Nome Giocatore 2:");
        nm1.setFont(new Font("Tahoma", Font.BOLD, 18));
        nm1.setBounds(150, 150, 200, 29);
        p.add(nm1);

        JTextField a1 = new JTextField();
        a1.setBounds(350,80,200,30);
        p.add(a1);

        JTextField a2 = new JTextField();
        a2.setBounds(350,150,200,30);
        p.add(a2);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                user1.setNome(a1.getText());
                user2.setNome(a2.getText());

                System.out.println( user1.getNome()+ "\n");
                System.out.println( user2.getNome()+ "\n");

                dispose();
            }
        });
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
