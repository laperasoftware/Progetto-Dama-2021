package GUI;

import user.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGUI extends JFrame implements ActionListener {

    private User user1 = new User();
    private User user2 = new User();
    public boolean logCheck;
    private JPanel p = new JPanel();
    private JButton b1= new JButton("Registrazione dati");
    private JLabel nm = new JLabel("Nome Giocatore Bianco:");
    private JLabel nm1 = new JLabel("Nome Giocatore Nero:");
    private JTextField a1 = new JTextField();
    private JTextField a2 = new JTextField();

    public LoginGUI() {

            setLogGUI();
    }

private void setLogGUI(){

    setTitle("LOGIN");
    setBounds(100, 100, 900, 450);
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



    Container c=getContentPane();
    c.setLayout(new BorderLayout(5, 5));
    p.setLayout(null);
    c.add(p, BorderLayout.CENTER);

    b1.setBounds(380,300,200,30);
    p.add(b1);


    //////////////////////////////////////////////////////////


    nm.setFont(new Font("Tahoma", Font.BOLD, 18));
    nm.setBounds(200, 80, 300, 29);
    p.add(nm);

    nm1.setFont(new Font("Tahoma", Font.BOLD, 18));
    nm1.setBounds(200, 200, 300, 29);
    p.add(nm1);

    /////////////////////////////////////////////////////////////

    a1.setBounds(450,80,200,30);
    p.add(a1);

    a2.setBounds(450,200,200,30);
    p.add(a2);



    b1.addActionListener(this);
}

    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame f = new JFrame();


        user1.setNome(a1.getText());
        user2.setNome(a2.getText());

        if((user1.getNome().equals(user2.getNome()) == true)){
            JOptionPane.showMessageDialog(f,"I nomi inseriti sono uguali");
        }
        else{

            user1.setColore(1);
            user2.setColore(0);

            JOptionPane.showMessageDialog(f, "Login completato");

            logCheck = true;

        }

        if(logCheck == true){
            dispose();
            logCompleto();
        }

    }

    public boolean logCompleto(){
        boolean complete = logCheck;
        return  complete;
    }
}
