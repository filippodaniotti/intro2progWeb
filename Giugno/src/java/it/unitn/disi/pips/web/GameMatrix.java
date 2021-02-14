/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.disi.pips.web;


/**
 *
 * @author Filippo
 */
public class GameMatrix {
    
    private int[][] matrix;
    
    public GameMatrix() {
        matrixInit();
        generateBombs();
        fillMatrix();
    }
    
    public int getValue(int row, int col) {
        return this.matrix[row][col];
    }
    
    private void matrixInit() {
        matrix = new int[Global.matrixDim][Global.matrixDim];
        for (int[] i : matrix) {
            for (int j : i) {
                j = 0;
            }
        }
    }
    
    private void generateBombs() {
        int count = 0;
        int row = 0;
        int col = 0;
        while (count != Global.bombCount) {
            row = Global.rand.nextInt(Global.matrixDim);
            col = Global.rand.nextInt(Global.matrixDim);
            if (matrix[row][col] != Global.bomb) {
                matrix[row][col] = Global.bomb;
            }
            ++count;
        }
    }
    
    private void fillMatrix() {
        for (int i = 0; i < Global.matrixDim; ++i) {
            for (int j = 0; j < Global.matrixDim; ++j) {
                if (matrix[i][j] == Global.bomb) {
                    
                    if (i-1 > 0 && matrix[i-1][j] != -1) 
                        matrix[i-1][j] += 1;
                    
                    if (i-1 > 0 && j+1 < Global.matrixDim && matrix[i-1][j+1] != -1)
                        matrix[i-1][j+1] += 1;
                    
                    if (j+1 < Global.matrixDim && matrix[i][j+1] != -1)
                        matrix[i][j+1] += 1;
                    
                    if (i+1 < Global.matrixDim && j+1 < Global.matrixDim && matrix[i+1][j+1] != -1)
                        matrix[i+1][j+1] += 1;
                    
                    if (i+1 < Global.matrixDim && matrix[i+1][j] != -1)
                        matrix[i+1][j] += 1;
                    
                    if (i+1 < Global.matrixDim && j-1 > 0 && matrix[i+1][j-1] != -1)
                        matrix[i+1][j-1] += 1;
                    
                    if (matrix[i][j] != -1)
                        matrix[i][j] += 1;
                    
                    if (i-1 > 0 && j-1 > 0 && matrix[i-1][j-1] != -1)
                        matrix[i-1][j-1] += 1;
                }
            }
        }
    }
    
}
