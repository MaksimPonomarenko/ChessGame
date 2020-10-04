package com.chessgame.figures;

import com.chessgame.ChessPiece;
import com.chessgame.Game;
import com.chessgame.Position;

import java.util.ArrayList;

public class Rook extends ChessPiece {
    public Rook(int column, int row, int side) {
        super(column, row, side);
    }

    @Override
    public ArrayList<Position> showPossibleMoves(Game game) {
        ChessPiece[][] board = game.getBoard().coordinates;
        ArrayList<Position> moves = new ArrayList<>();
        Position position = this.getPosition(board);

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++){
                if ((i != 0) == (j != 0)) continue;
                System.out.println(i + " " + j);
                checkAxis(board, i, j, moves);
            }
        }

        moves.removeIf(move -> game.getKing(this.getSide()).checkMove(game, this, move));

        return moves;
    }

    private void checkAxis(ChessPiece[][] board, int changeX, int changeY, ArrayList<Position> moves) {
        Position rookPosition = new Position(this.getPosition(board).column, this.getPosition(board).row);
        int x = rookPosition.column + changeX, y = rookPosition.row + changeY;
        while (board[x][y] == null) {
            moves.add(new Position(x, y));
            x += changeX;
            y += changeY;
            if (x > 7 || x < 0 || y > 7 || y < 0) return;
        }
        if (board[x][y].getSide() != this.getSide()) moves.add(new Position(x, y));
    }
}
