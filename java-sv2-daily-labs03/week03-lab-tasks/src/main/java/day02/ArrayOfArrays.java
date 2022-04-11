package day02;

import java.util.Arrays;

public class ArrayOfArrays {

    private int[][] matrix;

    public ArrayOfArrays(int[][] matrix) {
          this.matrix = matrix;
          this.cleanMatrix();
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
        this.cleanMatrix();
    }

    private void cleanMatrix(){
        if (matrix == null) {
            matrix = new int[][]{};
            return;
        }
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i] == null) {
                matrix[i] = new int[]{};
            }
        }
    }

    private boolean checkUpperTriangular() {
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                if (matrix[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkLowerTriangular() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[i].length; j++) {
                if (matrix[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isSquare() {
        if (matrix.length != 0) {
            for (int[] ints : matrix)
                if (ints.length != matrix.length) {
                    return false;
                }
        }
        return true;
    }

    public boolean isUpperTriangular() {
        return isSquare() && checkUpperTriangular();

    }

    public boolean isLowerTriangular() {
        return isSquare() && checkLowerTriangular();
    }

    public boolean isDiagonal() {
        return isSquare() && checkLowerTriangular() && checkUpperTriangular();
    }

    @Override
    public String toString() {
        return Arrays.deepToString(matrix).replace("],", "]\n");
    }

}
