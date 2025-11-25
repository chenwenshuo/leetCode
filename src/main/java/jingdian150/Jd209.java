package jingdian150;

public class Jd209 {

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7,new int[]{2,3,1,2,4,3}));
    }
    public static int minSubArrayLen(int target, int[] nums) {
        int ans = Integer.MAX_VALUE;

        int r = 0;
        int l = 0;
        int t = 0;
        for (int i = 0; i < nums.length; i++) {
            t += nums[i];
            while (t >= target) {
                ans = Math.min(ans, i - l + 1);
                t -= nums[l++];
            }

        }
        return ans==Integer.MAX_VALUE?0:ans;
    }
}
