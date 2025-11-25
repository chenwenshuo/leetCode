package jingdian150;

public class Jdto33 {

    public static void main(String[] args) {
        System.out.println(search(new int[]{1,3},3));
    }
    public static int search(int[] nums, int target) {
        int l = 0,r = nums.length-1;
        //[4,5,6,7,0,1,2]
        //5  1 3
        //1 3 5
        while (l<=r){
            int mid = l+r>>1;
            if (nums[mid]==target){
                return mid;
            }
            int m = nums[mid];
            if (m>nums[0]){
                if (target<m&&target>=nums[0]){
                    r = mid-1;
                }else {
                    l = mid+1;
                }
            }else {
                if (target>m&&target<nums[0]){
                    l=mid+1;
                }else {
                    r = mid-1;
                }
            }
        }
        return -1;
    }
}
