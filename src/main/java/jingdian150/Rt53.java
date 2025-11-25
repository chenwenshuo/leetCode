package jingdian150;

public class Rt53 {
    public int maxSubArray(int[] nums) {
        int ans = nums[0];

        int tem = Math.max(0, nums[0]);

        for (int i = 1; i < nums.length; i++) {
            ans = Math.max(ans, tem + nums[i]);
            tem = Math.max(0, tem + nums[i]);
        }

        return ans;

    }
}
