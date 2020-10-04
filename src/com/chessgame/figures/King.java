package com.chessgame.figures;

import com.chessgame.ChessPiece;
import com.chessgame.Game;
import com.chessgame.Position;

import java.util.ArrayList;

public class King extends ChessPiece {

    public King(int column, int row, int side) {
        super(column, row, side);
    }

    @Override
    public ArrayList<Position> showPossibleMoves(Game game) {
        long startTime = System.nanoTime();
        ChessPiece[][] board = game.getBoard().coordinates;
        ArrayList<Position> moves = new ArrayList<>();
        Position position = this.getPosition(board);

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++){
                if (i == 0 && j == 0) continue;
                int x = position.column + i, y = position.row + j;
                if (x > 7 || x < 0 || y > 7 || y < 0) continue;
                if (board[x][y] == null || board[x][y].getSide() != this.getSide()) moves.add(new Position(x, y));
            }
        }

        long endTime = System.nanoTime();
        System.out.println("Time spent: " + (endTime - startTime) + " nanos");

        moves.removeIf(move -> game.getKing(this.getSide()).checkMove(game, this, move));

        return moves;
    }

    public boolean checkMove(Game game, ChessPiece piece, Position movePosition) {

        // making virtual move
        Position startPosition = new Position(piece.getPosition(game.getBoard().coordinates).column, piece.getPosition(game.getBoard().coordinates).row);
        game.getBoard().coordinates[startPosition.column][startPosition.row] = null;
        game.getBoard().coordinates[movePosition.column][movePosition.row] = piece;

        // if virtualMove is for the king -> check for danger from knights
        boolean danger = checkMove(game, startPosition, movePosition, piece.getClass().getSimpleName().equals("King"));

        // getting piece back
        game.getBoard().coordinates[startPosition.column][startPosition.row] = game.getBoard().coordinates[movePosition.column][movePosition.row];
        game.getBoard().coordinates[movePosition.column][movePosition.row] = null;

        return danger;
    }

    private boolean checkMove(Game game, Position startPosition, Position movePosition, boolean checkKnights) {

        ChessPiece[][] board = game.getBoard().coordinates;

        // getting movePosition relative to targeted piece
        Position move = new Position(movePosition.column - startPosition.column, movePosition.row - startPosition.row);

        // getting piece position relative to king position
        Position relativeToKingPosition = new Position(startPosition.column - this.getPosition(board).column, startPosition.row - this.getPosition(board).row);

        // the chess piece is located on one of the king's axes without moving from this axis (nothing dangerous)
        if (move.column == 0 && relativeToKingPosition.column == 0 ||
            move.row == 0 && relativeToKingPosition.row == 0 ||
            move.column == move.row && relativeToKingPosition.column == relativeToKingPosition.row ||
            move.column == -move.row && relativeToKingPosition.column == -relativeToKingPosition.row) {
            return false;
        }

        Position kingPosition = new Position(this.getPosition(board).column, this.getPosition(board).row);

        int axisX = 2, axisY = 2;

        // finding the axis on which the figure is moved
        if (movePosition.column < 0 && (movePosition.column + 1) / (movePosition.row + 1) == (kingPosition.column + 1) / (kingPosition.row + 1)) {axisX = -1; axisY = -1;}
        if (movePosition.column < 0 && movePosition.row == kingPosition.row) {axisX = -1; axisY = 0;}
        if (movePosition.column < 0 && (movePosition.column + 1) / (movePosition.row + 1) == -(kingPosition.column + 1) / (kingPosition.row + 1)) {axisX = -1; axisY = 1;}
        if (movePosition.row > 0 && movePosition.column == kingPosition.column) {axisX = 0; axisY = 1;}
        if (movePosition.column > 0 && (movePosition.column + 1) / (movePosition.row + 1) == (kingPosition.column + 1) / (kingPosition.row + 1)) {axisX = 1; axisY = 1;}
        if (movePosition.column > 0 && movePosition.row == kingPosition.row) {axisX = 1; axisY = 0;}
        if (movePosition.column > 0 && (movePosition.column + 1) / (movePosition.row + 1) == -(kingPosition.column + 1) / (kingPosition.row + 1)) {axisX = 1; axisY = -1;}
        if (movePosition.row < 0 && movePosition.column == kingPosition.column) {axisX = 0; axisY = -1;}

        // checking all axis except for the axis on which the piece
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++){
                if ((i == 0 && j == 0) || (i == axisX && j == axisY)) continue;
                if (checkAxis(board, i, j)) return true;
            }
        }

        if (checkKnights) {
            return  board[kingPosition.column + 2][kingPosition.row + 1].getClass().getSimpleName().equals("Knight") ||
                    board[kingPosition.column + 1][kingPosition.row + 2].getClass().getSimpleName().equals("Knight") ||
                    board[kingPosition.column - 1][kingPosition.row + 2].getClass().getSimpleName().equals("Knight") ||
                    board[kingPosition.column - 2][kingPosition.row + 1].getClass().getSimpleName().equals("Knight") ||
                    board[kingPosition.column - 2][kingPosition.row - 1].getClass().getSimpleName().equals("Knight") ||
                    board[kingPosition.column - 1][kingPosition.row - 2].getClass().getSimpleName().equals("Knight") ||
                    board[kingPosition.column + 1][kingPosition.row - 2].getClass().getSimpleName().equals("Knight") ||
                    board[kingPosition.column + 2][kingPosition.row - 1].getClass().getSimpleName().equals("Knight");
        }
        return false;
    }

    private boolean checkAxis(ChessPiece[][] board, int changeX, int changeY) {
        Position kingPosition = new Position(this.getPosition(board).column, this.getPosition(board).row);
        int x = kingPosition.column, y = kingPosition.row;
        do {
            x += changeX;
            y += changeY;
            if (x < 0 || x > 7 || y < 0 || y > 7) return false;
        } while (board[x][y] == null);
        if ((board[x][y].getClass().getSimpleName().equals("Bishop") || board[x][y].getClass().getSimpleName().equals("Queen")) &&
                board[x][y].getSide() != this.getSide() && changeX != 0 && changeY != 0) return true;
        if ((board[x][y].getClass().getSimpleName().equals("Rook") || board[x][y].getClass().getSimpleName().equals("Queen")) &&
                board[x][y].getSide() != this.getSide() && (changeX == 0 || changeY == 0)) return true;
        return false;
    }

    public boolean checkIfMate(Game game) {
        ArrayList<Position> moves = this.showPossibleMoves(game);
        for (Position i : moves) {
            if (checkMove(game, this, i)) {
                return true;
            }
        }
        return false;
    }
}
