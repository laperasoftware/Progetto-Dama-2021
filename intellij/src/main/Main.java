package main;

import GUI.BoardGUI;
import GUI.LoginGUI;
import User.User;

public class Main {

    public static void main(String[] args) {

        User u1 = new User();
        User u2 = new User();

        BoardGUI b = new BoardGUI();
        b.boardDisplay();
        b.setEnabled(false);
        LoginGUI gui = new LoginGUI();
    }
}
