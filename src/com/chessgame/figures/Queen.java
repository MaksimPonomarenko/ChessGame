package com.chessgame.figures;

import com.chessgame.ChessPiece;
import com.chessgame.Game;
import com.chessgame.Position;

import java.util.ArrayList;

public class Queen extends ChessPiece {

    public Queen(int column, int row, int side) {
        super(column, row, side);
    }

    @Override
    public ArrayList<Position> showPossibleMoves(Game game) {
        return null;
    }

}
