package com.chessgame;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Game game = new Game();
        Window window = new Window(game);
        window.initializeWindow();
    }
}
