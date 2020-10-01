package com.chessgame.figures;

import com.chessgame.Board;
import com.chessgame.ChessFigure;
import com.chessgame.Game;
import com.chessgame.Position;

import java.util.ArrayList;

public class Pawn extends ChessFigure {
    public Pawn(int column, int row, int side) {
        super(column, row, side);
    }

    @Override
    public ArrayList<Position> showPossibleMoves(Game game) {
        Board board = game.getBoard();
        ArrayList<Position> moves = new ArrayList<>();
        Position position = this.getPosition(board.coordinates);
        Position startPosition = this.getStartPosition();

        try {

            if (this.getSide() == 0) {
                // move forward
                if (board.coordinates[position.column-1][position.row] == null) {
                    moves.add(new Position(position.column-1, position.row));
                }

                // attacking move diagonally to the right
                if (board.coordinates[position.column-1][position.row+1] != null && board.coordinates[position.column-1][position.row+1].getSide() != this.getSide()) {
                    moves.add(new Position(position.column-1, position.row+1));
                }

                // attacking move diagonally to the left
                if (board.coordinates[position.column-1][position.row-1] != null && board.coordinates[position.column-1][position.row-1].getSide() != this.getSide()) {
                    moves.add(new Position(position.column-1, position.row-1));
                }

                // starting opportunity
                if (position.equals(startPosition) && board.coordinates[position.column-2][position.row] == null) {
                    moves.add(new Position(position.column-2, position.row));
                }

                // en passant
                if (game.getPreviousFigure().getClass().getSimpleName().equals("Pawn") &&
                        game.getBeforeMove().column == game.getAfterMove().column-2 &&
                        position.column == game.getAfterMove().column &&
                        game.getPreviousFigure().getSide() != this.getSide() &&
                        board.coordinates[game.getAfterMove().column-1][game.getAfterMove().row] == null) {
                    moves.add(new Position(game.getAfterMove().column-1, game.getAfterMove().row));
                }
            } else {
                // move forward
                if (board.coordinates[position.column+1][position.row] == null) {
                    moves.add(new Position(position.column-1, position.row));
                }

                // attacking move diagonally to the right
                if (board.coordinates[position.column+1][position.row+1] != null && board.coordinates[position.column+1][position.row+1].getSide() != this.getSide()) {
                    moves.add(new Position(position.column+1, position.row+1));
                }

                // attacking move diagonally to the left
                if (board.coordinates[position.column+1][position.row-1] != null && board.coordinates[position.column+1][position.row-1].getSide() != this.getSide()) {
                    moves.add(new Position(position.column+1, position.row-1));
                }

                // starting opportunity
                if (position.equals(startPosition) && board.coordinates[position.column+2][position.row] == null) {
                    moves.add(new Position(position.column+2, position.row));
                }

                // en passant
                if (game.getPreviousFigure().getClass().getSimpleName().equals("Pawn") &&
                        game.getBeforeMove().column == game.getAfterMove().column+2 &&
                        position.column == game.getAfterMove().column &&
                        game.getPreviousFigure().getSide() != this.getSide() &&
                        board.coordinates[game.getAfterMove().column+1][game.getAfterMove().row] == null) {
                    moves.add(new Position(game.getAfterMove().column+1, game.getAfterMove().row));
                }
            }
        } catch (ArrayIndexOutOfBoundsException exception) {
            return null;
        }

        King king;

        if (this.getSide() == 0){
            king = game.getKing(0);
        } else {
            king = game.getKing(1);
        }

        System.out.println("Moves before checking:");
        for (Position move : moves) System.out.println(move.column + " " + move.row);
        System.out.println("end");

        moves.removeIf(move -> !king.checkIfMate(game, this, move));

        System.out.println("Moves after checking:");
        for (Position move : moves) System.out.println(move.column + " " + move.row);
        System.out.println("end");

        return moves;
    }

}
