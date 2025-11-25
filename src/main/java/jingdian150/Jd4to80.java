package jingdian150;

public class Jd4to80 {
    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1,1,1,2,2,3}));
    }

    public static int removeDuplicates(int[] nums) {
//[1,1,1,2,2,3]
        int l = 1;
        boolean b = true;
        int t = 0;
        for (int i = 2; i < nums.length; i++) {
            if (b && nums[i] == nums[i - 2]) {
                l = i;
                t = nums[i];
                b = false;
            }
            if (nums[i] != t) {
                nums[l] = nums[i];
                l++;

            }
        }
        return l;
    }
}
