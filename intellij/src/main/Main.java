package main;

import GUI.BoardGUI;
import GUI.LoginGUI;
import user.User;

public class Main {

    public static void main(String args[]) {

        BoardGUI b = new BoardGUI();

        LoginGUI gui = new LoginGUI();

        b.boardDisplay();

    }
}
