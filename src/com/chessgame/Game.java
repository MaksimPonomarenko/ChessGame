package com.chessgame;

import com.chessgame.figures.Pawn;

import java.util.ArrayList;

public class Game {

    ChessFigure previousFigure;
    Position beforeMove;
    Position afterMove;
    Board board;

    public void start() {
        board = new Board(8);

        Pawn pawn = new Pawn(3, 4, 0);
        Pawn pawn1 = new Pawn(2, 5, 1);
        previousFigure = new Pawn(3, 3, 1);

        beforeMove = new Position(1, 3);
        afterMove = new Position(3, 3);

        board.coordinates[pawn.getStartPosition().column][pawn.getStartPosition().row] = pawn;
        board.coordinates[pawn1.getStartPosition().column][pawn1.getStartPosition().row] = pawn1;
        board.coordinates[previousFigure.getStartPosition().column][previousFigure.getStartPosition().row] = previousFigure;

        ArrayList<Position> moves = pawn.showPossibleMoves(this);
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
