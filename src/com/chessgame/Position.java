package com.chessgame;

public class Position {

    public int column;
    public int row;

    public Position(int column, int row) {
        this.column = column;
        this.row = row;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Position position = (Position) o;
        return column == position.column &&
                row == position.row;
    }
}
