package com.chessgame.figures;

import com.chessgame.ChessPiece;
import com.chessgame.Game;
import com.chessgame.Position;

import java.util.ArrayList;

public class Knight extends ChessPiece {
    public Knight(int column, int row, int side) {
        super(column, row, side);
    }

    @Override
    public ArrayList<Position> showPossibleMoves(Game game) {
        ChessPiece[][] board = game.getBoard().coordinates;
        ArrayList<Position> moves = new ArrayList<>();
        Position position = this.getPosition(board);

        for (int i = -2; i <= 2; i++) {
            for (int j = -2; j <= 2; j++){
                if ((i == 0 || j == 0) || (Math.abs(i) == Math.abs(j))) continue;
                int x = position.column + i, y = position.row + j;
                if (x > 7 || x < 0 || y > 7 || y < 0) continue;
                if (board[x][y] == null || board[x][y].getSide() != this.getSide()) moves.add(new Position(x, y));
            }
        }

        moves.removeIf(move -> game.getKing(this.getSide()).checkMove(game, this, move));

        return moves;
    }
}
