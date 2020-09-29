package com.chessgame.figures;

import com.chessgame.Board;
import com.chessgame.ChessFigure;
import com.chessgame.Game;
import com.chessgame.Position;

import java.util.ArrayList;

public class Bishop extends ChessFigure {
    public Bishop(int column, int row, int side) {
        super(column, row, side);
    }

    @Override
    public ArrayList<Position> showPossibleMoves(Game game) {
        return null;
    }
}
