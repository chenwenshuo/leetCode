package jingdian150;

public class Jd3to26 {
    public int removeDuplicates(int[] nums) {
        int l = 0;
        int r = 0;

        //1 2 2 2 2 3 4 4 4 5 6 6
        boolean b = false;
        for (int i = 1; i < nums.length; i++) {
            if (!b && nums[i] == nums[i - 1]) {
                l = i;
                b = true;
            }
            if (nums[i]!=nums[i-1]){
                nums[l] = nums[i];
                l++;
            }
        }
        return l;
    }
}
