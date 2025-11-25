package jingdian150;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Jdto73 {
    public void setZeroes(int[][] matrix) {

        Set<Integer> lSet = new HashSet<>();
        Set<Integer> hSet = new HashSet<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    lSet.add(i);
                    hSet.add(j);
                }
            }
        }

        for (Integer l : lSet) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[l][i] = 0;
            }
        }
        for (Integer h : hSet) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][h] = 0;
            }
        }
    }
}
