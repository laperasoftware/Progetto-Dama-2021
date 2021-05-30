package GUI;

import GUI.BoardGUI;
import GUI.ImagePanel;
import GUI.TitleGUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import javax.swing.*;


public class GuideGUI implements ActionListener {


    private JFrame f = new JFrame();

    ImagePanel b = new ImagePanel((new ImageIcon("IMG/Istruzioni.png")).getImage());




    public GuideGUI() {


        setFrame();
        setSfondo();

    }


    private void setFrame() {

        f.setSize(615, 860);
        f.setLocationRelativeTo((Component) null);

        f.setVisible(true);
        f.setResizable(false);

    }



    private void setSfondo() {

        f.getContentPane().add(b);
    }


    public void actionPerformed(ActionEvent e) {


    }
}

