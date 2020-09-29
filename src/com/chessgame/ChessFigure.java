package com.chessgame;

public abstract class ChessFigure {

    // 2-digit num that represents position
    // (14 -- 2nd column, 5th row)
    int position;

    // 0 for white and 1 for black
    int side;

    public ChessFigure(int position, int side){

        this.position = position;
        this.side = side;
    }

    // returns array of positions that available for move on
    public abstract int[] showPossibleMoves();

    public int getPosition() {
        return position;
    }
}
