package com.chessgame;

import java.util.ArrayList;

public abstract class ChessFigure {

    // 2-digit num that represents position
    // (14 -- 2nd column, 5th row)
    Position startPosition;

    // 0 for white and 1 for black
    int side;

    public ChessFigure(int column, int row, int side){
        this.startPosition = new Position(column, row);
        this.side = side;
    }

    // returns array of positions that available for move on
    public abstract ArrayList<Position> showPossibleMoves(Game game);

    public Position getPosition(Board board) {
        for(int i=0; i<board.coordinates.length; i++)
            for(int j=0; j<board.coordinates[i].length; j++)
                if(this == board.coordinates[i][j]) return new Position(i, j);
        return null;
    }

    public Position getStartPosition() {
        return startPosition;
    }

    public int getSide() {
        return side;
    }
}
