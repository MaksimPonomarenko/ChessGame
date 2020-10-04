package com.chessgame;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

public class Window extends JFrame {

    Game game;
    Painter painter;

    public Window(Game game) {
        this.game = game;
    }

    public void initializeWindow() throws IOException {
        game.start();
        painter = new Painter(game);
        painter.paint();
        JFrame frame = buildFrame();
        frame.add(painter.pane);
    }

    private static JFrame buildFrame() {
        JFrame frame = new JFrame("ChessGame");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(616, 640);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        return frame;
    }

}
