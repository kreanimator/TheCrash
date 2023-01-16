package main;

import javax.swing.*;

public class Main {

    public static JFrame window;

    public static void main(String[] args) {
        window = new JFrame();
        window.setUndecorated(true);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setResizable(false);

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);

        gamePanel.config.loadConfig();

        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);


        gamePanel.setUpGame();
        gamePanel.startGameThread();
    }
}
