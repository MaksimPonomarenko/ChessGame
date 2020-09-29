package com.chessgame;

public class Board {

    public ChessFigure[][] coordinates;

    public Board(int size) {
        coordinates = new ChessFigure[size][size];
        System.out.println("Board have created");
    }
}
