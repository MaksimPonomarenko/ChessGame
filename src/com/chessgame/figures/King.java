package com.chessgame.figures;

import com.chessgame.ChessFigure;
import com.chessgame.Game;
import com.chessgame.Position;

import java.util.ArrayList;

public class King extends ChessFigure {

    public King(int column, int row, int side) {
        super(column, row, side);
    }

    @Override
    public ArrayList<Position> showPossibleMoves(Game game) {
        return null;
    }

    public boolean checkIfMate(Game game, ChessFigure piece, Position movePosition) {
        ChessFigure[][] board = game.getBoard().coordinates;
        Position startPosition = piece.getPosition(board);
        Position move = new Position(movePosition.column - startPosition.column, movePosition.row - startPosition.row);
        Position relativeToKingPosition = new Position(startPosition.column - this.getPosition(board).column, startPosition.row - this.getPosition(board).row);

        // the chess piece is located on one of the king's axes without moving from this axis (nothing dangerous)
        if (move.column == 0 && relativeToKingPosition.column == 0 ||
            move.row == 0 && relativeToKingPosition.row == 0 ||
            move.column == move.row && relativeToKingPosition.column == relativeToKingPosition.row ||
            move.column == -move.row && relativeToKingPosition.column == -relativeToKingPosition.row) {
            return false;
        }

        // moving target chess piece to the theoretical point
        ChessFigure target = board[piece.getPosition(board).column][piece.getPosition(board).row];
        board[piece.getPosition(board).column][piece.getPosition(board).row] = null;
        board[movePosition.column][movePosition.row] = target;

        boolean danger = false;

        // king coordinates
        int x = this.getPosition(board).column;
        int y = this.getPosition(board).row;

        // the chess piece is moving from diagonal left to right axis
        if (relativeToKingPosition.column == relativeToKingPosition.row) {
            int beginX = x;
            int beginY = y;
            while (game.getBoard().coordinates[x][y] == null) {
                x--;
                y--;
            }

            if (game.getBoard().coordinates[x][y].getClass().getSimpleName().equals("Queen") && game.getBoard().coordinates[x][y].getSide() != piece.getSide() ||
                game.getBoard().coordinates[x][y].getClass().getSimpleName().equals("Bishop") && game.getBoard().coordinates[x][y].getSide() != piece.getSide()) {
                danger = true;
            }

            while (game.getBoard().coordinates[beginX][beginY] == null) {
                beginX++;
                beginY++;
            }

            if (game.getBoard().coordinates[beginX][beginY].getClass().getSimpleName().equals("Queen") && game.getBoard().coordinates[beginX][beginY].getSide() != piece.getSide() ||
                game.getBoard().coordinates[beginX][beginY].getClass().getSimpleName().equals("Bishop") && game.getBoard().coordinates[beginX][beginY].getSide() != piece.getSide()) {
                danger = true;
            }
        } else if (relativeToKingPosition.row == 0) { // the chess piece is moving from vertical axis
            int beginY = y;
            while (game.getBoard().coordinates[x][y] == null) {
                y--;
            }

            if (game.getBoard().coordinates[x][y].getClass().getSimpleName().equals("Queen") && game.getBoard().coordinates[x][y].getSide() != piece.getSide() ||
                game.getBoard().coordinates[x][y].getClass().getSimpleName().equals("Rook") && game.getBoard().coordinates[x][y].getSide() != piece.getSide()) {
                danger = true;
            }

            while (game.getBoard().coordinates[x][beginY] == null) {
                beginY++;
            }

            if (game.getBoard().coordinates[x][beginY].getClass().getSimpleName().equals("Queen") && game.getBoard().coordinates[x][beginY].getSide() != piece.getSide() ||
                game.getBoard().coordinates[x][beginY].getClass().getSimpleName().equals("Rook") && game.getBoard().coordinates[x][beginY].getSide() != piece.getSide()) {
                danger = true;
            }
        } else if (relativeToKingPosition.column == -relativeToKingPosition.row) { // the chess piece is moving from diagonal right to left axis
            int beginX = x;
            int beginY = y;
            while (game.getBoard().coordinates[x][y] == null) {
                x--;
                y++;
            }

            if (game.getBoard().coordinates[x][y].getClass().getSimpleName().equals("Queen") && game.getBoard().coordinates[x][y].getSide() != piece.getSide() ||
                game.getBoard().coordinates[x][y].getClass().getSimpleName().equals("Bishop") && game.getBoard().coordinates[x][y].getSide() != piece.getSide()) {
                danger = true;
            }

            while (game.getBoard().coordinates[beginX][beginY] == null) {
                beginX++;
                beginY--;
            }

            if (game.getBoard().coordinates[beginX][beginY].getClass().getSimpleName().equals("Queen") && game.getBoard().coordinates[beginX][beginY].getSide() != piece.getSide() ||
                game.getBoard().coordinates[beginX][beginY].getClass().getSimpleName().equals("Bishop") && game.getBoard().coordinates[beginX][beginY].getSide() != piece.getSide()) {
                danger = true;
            }
        } else if (relativeToKingPosition.column == 0) { // the chess piece is moving from horizontal axis
            int beginX = x;
            while (game.getBoard().coordinates[x][y] == null) {
                x--;
            }

            if (game.getBoard().coordinates[x][y].getClass().getSimpleName().equals("Queen") && game.getBoard().coordinates[x][y].getSide() != piece.getSide() ||
                game.getBoard().coordinates[x][y].getClass().getSimpleName().equals("Rook") && game.getBoard().coordinates[x][y].getSide() != piece.getSide()) {
                danger = true;
            }

            while (game.getBoard().coordinates[beginX][y] == null) {
                beginX++;
            }

            if (game.getBoard().coordinates[beginX][y].getClass().getSimpleName().equals("Queen") && game.getBoard().coordinates[beginX][y].getSide() != piece.getSide() ||
                game.getBoard().coordinates[beginX][y].getClass().getSimpleName().equals("Rook") && game.getBoard().coordinates[beginX][y].getSide() != piece.getSide()) {
                danger = true;
            }
        }

        // moving target chess piece back
        target = board[movePosition.column][movePosition.row];
        board[movePosition.column][movePosition.row] = null;
        board[startPosition.column][startPosition.row] = target;

        return danger;
    }
}
