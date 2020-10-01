package com.chessgame;

import com.chessgame.figures.King;
import com.chessgame.figures.Pawn;
import com.chessgame.figures.Queen;
import com.chessgame.figures.Rook;

import java.util.ArrayList;

public class Game {

    ChessFigure previousFigure;
    Position beforeMove;
    Position afterMove;
    Board board;

    public void start() {
        board = new Board(8);

        Pawn pawn = new Pawn(4, 4, 0);
        King king = new King(5, 4, 0);
        previousFigure = new Rook(1, 4, 1);

        beforeMove = new Position(0, 4);
        afterMove = new Position(1, 4);

        board.coordinates[pawn.getStartPosition().column][pawn.getStartPosition().row] = pawn;
        board.coordinates[king.getStartPosition().column][king.getStartPosition().row] = king;
        board.coordinates[previousFigure.getStartPosition().column][previousFigure.getStartPosition().row] = previousFigure;

        ArrayList<Position> moves = pawn.showPossibleMoves(this);
    }

    public King getKing(int side) {
        if (side == 0) {
            for(int i=0; i<board.coordinates.length; i++)
                for(int j=0; j<board.coordinates[i].length; j++)
                    if (board.coordinates[i][j] != null && board.coordinates[i][j].getClass().getSimpleName().equals("King")) return (King) board.coordinates[i][j];
        }
        return null;
    }

    public Board getBoard() {
        return board;
    }

    public ChessFigure getPreviousFigure() {
        return previousFigure;
    }

    public Position getBeforeMove() {
        return beforeMove;
    }

    public Position getAfterMove() {
        return afterMove;
    }
}
