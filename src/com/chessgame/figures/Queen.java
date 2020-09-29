package com.chessgame.figures;

import com.chessgame.Board;
import com.chessgame.ChessFigure;

public class Queen extends ChessFigure {

    public Queen(int position, int side) {
        super(position, side);
    }

    @Override
    public int[] showPossibleMoves(Board board) {
        int[] possibleMoves = new int[];
        return new int[0];
    }
}
