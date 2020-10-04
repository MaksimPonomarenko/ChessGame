package com.chessgame;

public class Board {

    public ChessPiece[][] coordinates;

    public Board(int size) {
        coordinates = new ChessPiece[size][size];
        System.out.println("Board have created");
    }
}
