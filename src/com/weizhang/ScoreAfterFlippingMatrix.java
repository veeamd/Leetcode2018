package com.weizhang;


/**
 * We have a two dimensional matrix A where each value is 0 or 1.
 *
 * A move consists of choosing any row or column, and toggling each value in that row or column: changing all 0s to 1s, and all 1s to 0s.
 *
 * After making any number of moves, every row of this matrix is interpreted as a binary number, and the score of the matrix is the sum of these numbers.
 *
 * Return the highest possible score.
 *
 *
 *
 * Example 1:
 *
 * Input: [[0,0,1,1],[1,0,1,0],[1,1,0,0]]
 * Output: 39
 * Explanation:
 * Toggled to [[1,1,1,1],[1,0,0,1],[1,1,1,1]].
 * 0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39
 *
 *
 * Note:
 *
 * 1 <= A.length <= 20
 * 1 <= A[0].length <= 20
 * A[i][j] is 0 or 1.
 */

public class ScoreAfterFlippingMatrix {

    public int matrixScore(int[][] A) {
        if (A.length == 0 || A[0].length == 0) {
            return 0;
        }

        for (int i = 0; i < A.length; i++) {
            if (A[i][0] == 0) {
                flipRow(i, A);
            }
        }

        for (int j = 0; j < A[0].length; j++) {
            int countOfOne = 0;
            for (int i = 0; i < A.length; i++) {
                if (A[i][j] == 1) {
                    countOfOne++;
                }
            }
            if (A.length % 2 == 0 && countOfOne < A.length / 2) {
                flipColumn(j, A);
            } else if (A.length % 2 == 1 && countOfOne <= A.length / 2) {
                flipColumn(j, A);
            }
        }

        return sum(A);

    }


    private void flipRow(int row, int[][] array) {
        for (int j = 0; j < array[row].length; j++) {
            array[row][j] = array[row][j] ^ 1;
        }
    }

    private void flipColumn(int column, int[][] array) {
        for (int i = 0; i < array.length; i++) {
            array[i][column] = array[i][column] ^ 1;
        }
    }

    private int sum(int[][] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == 1) {
                    sum += Math.pow(2, array[i].length - 1 - j);
                }
            }
        }
        return sum;
    }


    public static void main(String[] args) {
        int[][] arr = new int[][] {{0,0,1,1},{1,0,1,0},{1,1,0,0}};
        ScoreAfterFlippingMatrix problem = new ScoreAfterFlippingMatrix();
        int output = problem.matrixScore(arr);
    }
}
