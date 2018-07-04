package com.weizhang;


/**
 * Given a matrix of M x N elements (M rows, N columns), return all elements of the matrix in diagonal order as shown in the below image.
 *
 * Example:
 * Input:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * Output:  [1,2,4,7,5,3,6,8,9]
 * Explanation: see image on https://leetcode.com/problems/diagonal-traverse/description/
 *
 * Note:
 * The total number of elements of the given matrix will not exceed 10,000.
 */

public class DiagonalTraverse {

    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return new int[0];

        int maxRow = matrix.length;
        int maxCol = matrix[0].length;

        int output[] = new int[maxRow * maxCol];
        int outputIndex = 0;

        int row = 0;
        int col = 0;
        boolean down = false;

        while (outputIndex < maxRow * maxCol) {
            if (row >= 0 && row < maxRow && col >= 0 && col < maxCol) {
                output[outputIndex] = matrix[row][col];
                outputIndex++;
                if (down) {
                    row++;
                    col--;
                } else {
                    row--;
                    col++;
                }
            } else {
                // correct the path when pointer is out of bound
                if (row < 0 && col >= maxCol) {
                    col--;
                    row += 2;
                    down = true;
                } else if (row >= maxRow && col < 0) {
                    col += 2;
                    row--;
                    down = false;
                } else if (row < 0) {
                    row = 0;
                    down = true;
                } else if (col < 0){
                    col = 0;
                    down = false;
                } else if (col >= maxCol) {
                    row += 2;
                    col--;
                    down = true;
                } else if (row >= maxRow) {
                    row--;
                    col += 2;
                    down = false;
                }
            }

        }
        return output;
    }

    //TODO: column and row number itself could decide where is the next item (up or down). Observing, every diagonal row has a different direction


    public static void main(String[] args) {
        DiagonalTraverse problem = new DiagonalTraverse();
        int input[][] = new int[2][3];
        int row1[] = {1, 2, 3};
        input[0] = row1;
        int row2[] = {4, 5, 6};
        input[1] = row2;
//        int row3[] = {7, 8, 9};
//        input[2] = row3;

        int output[] = problem.findDiagonalOrder(input);
    }
}
