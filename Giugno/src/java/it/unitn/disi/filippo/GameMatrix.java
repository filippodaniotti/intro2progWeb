/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.disi.filippo;

import java.util.Random;

/**
 *
 * @author Filippo
 */
public class GameMatrix {

    private Cell[][] board;

    public GameMatrix() {
        this.board = new Cell[9][9];
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                board[i][j] = new Cell();
            }
        }
        this.placeBombs();
        this.fillMatrix();
    }

    public void placeBombs() {
        Random rand = new Random();
        int counter = 0;
        while (counter != 10) {
            int x = rand.nextInt(9);
            int y = rand.nextInt(9);
            if (!this.board[x][y].isBomb()) {
                this.board[x][y].placeBomb();
                ++counter;
            }
        }
    }

    private void fillMatrix() {
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (!board[i][j].isBomb()) {
                    if (onBound(i - 1, j) && board[i - 1][j].isBomb()) {
                        board[i][j].updateNeighbors();
                    }

                    if (onBound(i, j - 1) && board[i][j - 1].isBomb()) {
                        board[i][j].updateNeighbors();
                    }

                    if (onBound(i + 1, j) && board[i + 1][j].isBomb()) {
                        board[i][j].updateNeighbors();
                    }

                    if (onBound(i, j + 1) && board[i][j + 1].isBomb()) {
                        board[i][j].updateNeighbors();
                    }

                    if (onBound(i + 1, j + 1) && board[i + 1][j + 1].isBomb()) {
                        board[i][j].updateNeighbors();
                    }

                    if (onBound(i - 1, j - 1) && board[i - 1][j - 1].isBomb()) {
                        board[i][j].updateNeighbors();
                    }

                    if (onBound(i - 1, j + 1) && board[i - 1][j + 1].isBomb()) {
                        board[i][j].updateNeighbors();
                    }

                    if (onBound(i + 1, j - 1) && board[i + 1][j - 1].isBomb()) {
                        board[i][j].updateNeighbors();
                    }
                }
            }
        }
    }

    public boolean onBound(int x, int y) {
        return x >= 0 && x < 9 && y >= 0 && y < 9;
    }

    public Cell getCell(int x, int y) {
        return this.board[x][y];
    }
}
