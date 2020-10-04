package com.chessgame;

import com.chessgame.figures.*;

import java.util.ArrayList;

public class Game {

    ChessPiece previousFigure;
    Position beforeMove;
    Position afterMove;
    Board board;

    public void start() {
        board = new Board(8);
        board.init();

        previousFigure = board.coordinates[0][1];
        beforeMove = new Position(1, 3);
        afterMove = new Position(3, 4);
    }

    public King getKing(int side) {
        if (side == 0) {
            for(int i=0; i<board.coordinates.length; i++)
                for(int j=0; j<board.coordinates[i].length; j++)
                    if (board.coordinates[i][j] != null && board.coordinates[i][j].getClass().getSimpleName().equals("King") && board.coordinates[i][j].getSide() == 0) return (King) board.coordinates[i][j];
        }
        if (side == 1) {
            for(int i=0; i<board.coordinates.length; i++)
                for(int j=0; j<board.coordinates[i].length; j++)
                    if (board.coordinates[i][j] != null && board.coordinates[i][j].getClass().getSimpleName().equals("King") && board.coordinates[i][j].getSide() == 1) return (King) board.coordinates[i][j];
        }
        return null;
    }

    public Board getBoard() {
        return board;
    }

    public ChessPiece getPreviousFigure() {
        return previousFigure;
    }

    public Position getBeforeMove() {
        return beforeMove;
    }

    public Position getAfterMove() {
        return afterMove;
    }

    public ArrayList<Position> getCoords() {
        return previousFigure.showPossibleMoves(this);
    }
}
