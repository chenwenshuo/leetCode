package qiusai;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: chenwenshuo
 * @Date: 2022/09/24/16:03
 */
public class Three {
    /**
     * num = 4
     * plate = ["..E.",".EOW","..W."]
     * @param args
     */
    public static void main(String[] args) {
        Three three = new Three();
        three.ballGame(4,new String[]{"..E.",".EOW","..W."});
    }

    List<Integer[]> alist=new ArrayList();
    public int[][] ballGame(int num, String[] plate) {
        int h = plate[0].length();

        int l = plate.length;

        char[][] arr=new char[l][h];

        List<Integer[]> list=new ArrayList<>();
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < h; j++) {
                arr[i][j]=plate[i].charAt(j);
                if (plate[i].charAt(j)=='O'){
                    list.add(new Integer[]{i,j});
                }
            }
        }
        if (list.size()==0) return new int[][]{};

        for (Integer[] integers : list) {
            find(integers,arr,num,0,0);
        }

        return null;

    }

    private void find(Integer[] tem, char[][] arr, int num, int I, int J) {

        int l = arr.length;
        int h = arr[0].length;
        Integer l1 = tem[0];
        Integer h1 = tem[1];

        if (arr[I][J]!='.') return;



        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < h; j++) {
                if (i==0&&j==0)continue;
                if (num>=0&&(I==l1&&J==h1)){
                    alist.add(new Integer[]{i,j});
                }
            }
        }





    }
}
