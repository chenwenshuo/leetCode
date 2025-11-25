package jingdian150;

public class Jdto48 {
    public void rotate(int[][] matrix) {

        int length = matrix.length;

        for (int i = 0; i < length / 2; ++i) {
            for (int j = 0; j < length; ++j) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[length - 1 - i][j];
                matrix[length - 1 - i][j] = t;
            }
        }

        for (int i = 0; i < length; ++i) {
            for (int j = i; j < length; ++j) {
                int t = matrix[i][j];

                matrix[i][j] = matrix[j][i];
                matrix[j][i] = t;
            }
        }

    }
}
