package jingdian150;

public class Jdto74 {
    public static void main(String[] args) {
        //[[1,3,5,7],[10,11,16,20],[23,30,34,60]]
        System.out.println(new Jdto74().searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}},3));
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix[0].length-1;
        int l =0;
        int n =0;
        while (l<=r){
            int mid = l+r>>1;
            if (matrix[0][mid]==target){
                return true;
            }
            if (matrix[0][mid]>target) {
                n = mid;
                r = mid - 1;
            } else {
                l=mid+1;
            }
        }

        if (matrix[0][n]==target){
            return false;
        }

        r = matrix.length-1;
        l = 0;
        while (l<=r){
            int mid = l+r>>1;
            if (matrix[mid][n]==target) return true;
            if (matrix[mid][n]>target) r = mid-1;
            else  l =mid+1;
        }
        return false;
    }
}
