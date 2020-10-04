package com.chessgame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Painter {

    Game game;
    JPanel pane;

    BufferedImage whiteTile, blackTile, blueTile;
    BufferedImage whitePawn, whiteRook, whiteKnight, whiteBishop, whiteQueen, whiteKing;
    BufferedImage blackPawn, blackRook, blackKnight, blackBishop, blackQueen, blackKing;

    public Painter(Game game) {
        this.game = game;
    }

    public void paint() throws IOException {
        whiteTile = ImageIO.read(new File("C:\\Users\\maks\\IdeaProjects\\Chess\\src\\com\\chessgame\\images\\whiteTile.png"));
        blackTile = ImageIO.read(new File("C:\\Users\\maks\\IdeaProjects\\Chess\\src\\com\\chessgame\\images\\blackTile.png"));
        blueTile = ImageIO.read(new File("C:\\Users\\maks\\IdeaProjects\\Chess\\src\\com\\chessgame\\images\\blueTile.png"));

        whitePawn = ImageIO.read(new File("C:\\Users\\maks\\IdeaProjects\\Chess\\src\\com\\chessgame\\images\\whitePawn.png"));
        whiteRook = ImageIO.read(new File("C:\\Users\\maks\\IdeaProjects\\Chess\\src\\com\\chessgame\\images\\whiteRook.png"));
        whiteKnight = ImageIO.read(new File("C:\\Users\\maks\\IdeaProjects\\Chess\\src\\com\\chessgame\\images\\whiteKnight.png"));
        whiteBishop = ImageIO.read(new File("C:\\Users\\maks\\IdeaProjects\\Chess\\src\\com\\chessgame\\images\\whiteBishop.png"));
        whiteQueen = ImageIO.read(new File("C:\\Users\\maks\\IdeaProjects\\Chess\\src\\com\\chessgame\\images\\whiteQueen.png"));
        whiteKing = ImageIO.read(new File("C:\\Users\\maks\\IdeaProjects\\Chess\\src\\com\\chessgame\\images\\whiteKing.png"));

        blackPawn = ImageIO.read(new File("C:\\Users\\maks\\IdeaProjects\\Chess\\src\\com\\chessgame\\images\\blackPawn.png"));
        blackRook = ImageIO.read(new File("C:\\Users\\maks\\IdeaProjects\\Chess\\src\\com\\chessgame\\images\\blackRook.png"));
        blackKnight = ImageIO.read(new File("C:\\Users\\maks\\IdeaProjects\\Chess\\src\\com\\chessgame\\images\\blackKnight.png"));
        blackBishop = ImageIO.read(new File("C:\\Users\\maks\\IdeaProjects\\Chess\\src\\com\\chessgame\\images\\blackBishop.png"));
        blackQueen = ImageIO.read(new File("C:\\Users\\maks\\IdeaProjects\\Chess\\src\\com\\chessgame\\images\\blackQueen.png"));
        blackKing = ImageIO.read(new File("C:\\Users\\maks\\IdeaProjects\\Chess\\src\\com\\chessgame\\images\\blackKing.png"));

        pane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++){
                        if ((i + j) % 2 == 0) {
                            g.drawImage(whiteTile, i*75, j*75, null);
                        } else {
                            g.drawImage(blackTile, i*75, j*75, null);
                        }
                    }
                }
                ChessPiece[][] board = game.getBoard().coordinates;
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++){
                        if (board[i][j] == null) continue;
                        if (board[i][j].getClass().getSimpleName().equals("Pawn") && board[i][j].getSide() == 0) {
                            g.drawImage(whitePawn, j*75+(25/2), i*75+(25/2), null);
                        }
                        if (board[i][j].getClass().getSimpleName().equals("Pawn") && board[i][j].getSide() == 1) {
                            g.drawImage(blackPawn, j*75+(25/2), i*75+(25/2), null);
                        }
                        if (board[i][j].getClass().getSimpleName().equals("Knight") && board[i][j].getSide() == 0) {
                            g.drawImage(whiteKnight, j*75+(25/2), i*75+(25/2), null);
                        }
                        if (board[i][j].getClass().getSimpleName().equals("Knight") && board[i][j].getSide() == 1) {
                            g.drawImage(blackKnight, j*75+(25/2), i*75+(25/2), null);
                        }
                        if (board[i][j].getClass().getSimpleName().equals("Bishop") && board[i][j].getSide() == 0) {
                            g.drawImage(whiteBishop, j*75+(25/2), i*75+(25/2), null);
                        }
                        if (board[i][j].getClass().getSimpleName().equals("Bishop") && board[i][j].getSide() == 1) {
                            g.drawImage(blackBishop, j*75+(25/2), i*75+(25/2), null);
                        }
                        if (board[i][j].getClass().getSimpleName().equals("Rook") && board[i][j].getSide() == 0) {
                            g.drawImage(whiteRook, j*75+(25/2), i*75+(25/2), null);
                        }
                        if (board[i][j].getClass().getSimpleName().equals("Rook") && board[i][j].getSide() == 1) {
                            g.drawImage(blackRook, j*75+(25/2), i*75+(25/2), null);
                        }
                        if (board[i][j].getClass().getSimpleName().equals("Queen") && board[i][j].getSide() == 0) {
                            g.drawImage(whiteQueen, j*75+(25/2), i*75+(25/2), null);
                        }
                        if (board[i][j].getClass().getSimpleName().equals("Queen") && board[i][j].getSide() == 1) {
                            g.drawImage(blackQueen, j*75+(25/2), i*75+(25/2), null);
                        }
                        if (board[i][j].getClass().getSimpleName().equals("King") && board[i][j].getSide() == 0) {
                            g.drawImage(whiteKing, j*75+(25/2), i*75+(25/2), null);
                        }
                        if (board[i][j].getClass().getSimpleName().equals("King") && board[i][j].getSide() == 1) {
                            g.drawImage(blackKing, j*75+(25/2), i*75+(25/2), null);
                        }
                    }
                }
            }
        };
    }
}
