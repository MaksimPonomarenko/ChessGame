package com.chessgame;

import com.chessgame.figures.*;

public class Board {

    public ChessPiece[][] coordinates;

    public Board(int size) {
        coordinates = new ChessPiece[size][size];
    }

    public void init() {
        coordinates[6][0] = new Pawn(6, 0, 0);
        coordinates[6][1] = new Pawn(6, 1, 0);
        coordinates[6][2] = new Pawn(6, 2, 0);
        coordinates[6][3] = new Pawn(6, 3, 0);
        coordinates[6][4] = new Pawn(6, 4, 0);
        coordinates[6][5] = new Pawn(6, 5, 0);
        coordinates[6][6] = new Pawn(6, 6, 0);
        coordinates[6][7] = new Pawn(6, 7, 0);
        coordinates[7][0] = new Rook(7, 0, 0);
        coordinates[7][1] = new Knight(7, 1, 0);
        coordinates[7][2] = new Bishop(7, 2, 0);
        coordinates[7][3] = new Queen(7, 3, 0);
        coordinates[7][4] = new King(7, 4, 0);
        coordinates[7][5] = new Bishop(7, 5, 0);
        coordinates[7][6] = new Knight(7, 6, 0);
        coordinates[7][7] = new Rook(7, 7, 0);

        coordinates[1][0] = new Pawn(1, 0, 1);
        coordinates[1][1] = new Pawn(1, 1, 1);
        coordinates[1][2] = new Pawn(1, 2, 1);
        coordinates[1][3] = new Pawn(1, 3, 1);
        coordinates[1][4] = new Pawn(1, 4, 1);
        coordinates[1][5] = new Pawn(1, 5, 1);
        coordinates[1][6] = new Pawn(1, 6, 1);
        coordinates[1][7] = new Pawn(1, 7, 1);
        coordinates[0][0] = new Rook(0, 0, 1);
        coordinates[0][1] = new Knight(0, 1, 1);
        coordinates[0][2] = new Bishop(0, 2, 1);
        coordinates[0][3] = new Queen(0, 3, 1);
        coordinates[0][4] = new King(0, 4, 1);
        coordinates[0][5] = new Bishop(0, 5, 1);
        coordinates[0][6] = new Knight(0, 6, 1);
        coordinates[0][7] = new Rook(0, 7, 1);
    }
}
