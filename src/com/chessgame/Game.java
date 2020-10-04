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

        Pawn pawn = new Pawn(5, 3, 0);
        King king = new King(5, 4, 0);
        King king1 = new King(0, 3, 1);
        Pawn pawn1 = new Pawn(5,1, 0);
        previousFigure = new Knight(3, 4, 1);

        beforeMove = new Position(1, 3);
        afterMove = new Position(3, 4);

        board.coordinates[pawn.getStartPosition().column][pawn.getStartPosition().row] = pawn;
        board.coordinates[king.getStartPosition().column][king.getStartPosition().row] = king;
        board.coordinates[king1.getStartPosition().column][king1.getStartPosition().row] = king1;
        board.coordinates[pawn1.getStartPosition().column][pawn1.getStartPosition().row] = pawn1;
        board.coordinates[previousFigure.getStartPosition().column][previousFigure.getStartPosition().row] = previousFigure;

        long startTime = System.nanoTime();
        ArrayList<Position> moves = previousFigure.showPossibleMoves(this);
        long endTime = System.nanoTime();
        System.out.println("Time spent: " + (endTime - startTime) + " nanosec");

        for (Position move : moves) System.out.println(move.column + " " + move.row);
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
}
