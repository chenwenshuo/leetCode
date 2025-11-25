package jingdian150;

public class Jd70 {

    public int climbStairs(int n) {
        int[] nums = new int[n+1];
        nums[1]=1;
        nums[0]=1;
        for (int i = 2; i <= n; i++) {
            nums[i]=nums[i-1]+nums[i-2];
        }
        return nums[n];
    }
}
