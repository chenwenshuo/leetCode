package leetcode.editor.cn.zs.Two99;

/**
 * @Author: chenwenshuo
 * @Date: 2022/06/26/10:33 上午
 */
public class One {
    public static void main(String[] args) {
          int[][] a=new int[5][5];
          a= new int[][]
                  {{0,0,0,0,1},
                  {0,4,0,1,0},
                  {0,0,5,0,0},
                  {0,5,0,2,0},
                  {4,0,0,0,2}};
        /**
         * [[0,0,0,0,1],[0,4,0,1,0],[0,0,5,0,0],[0,5,0,2,0],[4,0,0,0,2]]
         * 0 3
         * 1 2
         * 2 1
         * 3,0
         */
        System.out.println(checkXMatrix(a));
    }
    public static boolean checkXMatrix(int[][] grid) {

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if ((i==j||i+j==grid.length-1)&&grid[i][j]==0) {
                    return false;
                }
                if (i!=j&&((i+j!=grid.length-1))&&grid[i][j]!=0) return false;
            }
        }

        return true;
    }
}
