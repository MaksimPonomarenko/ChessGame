package com.chessgame;

public class Board {

    ChessFigure[][] coordinates;

    public Board(int size) {
        coordinates = new ChessFigure[size][size];
        System.out.println("I have created");
    }
}
