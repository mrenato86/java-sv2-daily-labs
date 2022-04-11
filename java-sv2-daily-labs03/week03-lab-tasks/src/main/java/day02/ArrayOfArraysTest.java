package day02;

import java.util.ArrayList;
import java.util.List;

public class ArrayOfArraysTest {

    public static void main(String[] args) {

        List<int[][]> testCases = new ArrayList<>(List.of(
                new int[][]{{0, 1, 2}, {0, 1, 2}, {0, 1, 2}},
                new int[][]{null, {0, 1, 2}, {0, 2}},
                new int[][]{{1, 2, 3, 4, 5}, {0, 1, 2, 3, 4}, {0, 0, 1, 2, 3}, {0, 0, 0, 1, 2}, {0, 0, 0, 0, 1}},
                new int[][]{{1, 0, 0, 0, 0}, {1, 2, 0, 0, 0}, {1, 2, 3, 0, 0}, {1, 2, 3, 4, 0}, {1, 2, 3, 4, 5}},
                new int[][]{{1, 0, 0, 0, 0}, {0 , 2, 0, 0, 0}, {0, 0, 3, 0, 0}, {0, 0, 0, 4, 0}, {0, 0, 0, 0, 5}},
                new int[][]{{0}, {0}},
                new int[][]{{0}}
        ));
        testCases.add(null);
        ArrayOfArrays aa = new ArrayOfArrays(null);
        for (int[][] test : testCases) {
            aa.setMatrix(test);
            System.out.println(aa);
            System.out.println("Square: " + aa.isSquare());
            System.out.println("UpperTriangle: " + aa.isUpperTriangular() + " // LowerTriangle: " + aa.isLowerTriangular());
            System.out.println("Diagonal: " + aa.isDiagonal());
            System.out.println();
        }

    }

}
