package jingdian150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//[[1,2,3],[4,5,6],[7,8,9]]
//输出
//[1,2,3,5,5,5,5,5,5]
//预期结果
//[1,2,3,6,9,8,7,4,5]
public class Jdto54 {
    public static void main(String[] args) {
        System.out.println(spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0) return new ArrayList<Integer>();
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1, x = 0;
        List<Integer> ans = new ArrayList<>();

        while (true) {
            for (int i = l; i <= r; i++) {
                ans.add(matrix[t][i]);
            }
            if (++t > b) break;
            for (int i = t; i <= b; i++) {
                ans.add(matrix[i][r]);
            }
            if (l > --r) break;
            for (int i = r; i >= l; i--) {
                ans.add(matrix[b][i]);
            }
            if (t > --b) break;
            for (int i = b; i >= t; i--) {
                ans.add(matrix[i][l]);
            }
            if (++l>r) break;
        }
        return ans;
    }
}
