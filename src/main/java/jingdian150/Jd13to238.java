package jingdian150;

public class Jd13to238 {
    public int[] productExceptSelf(int[] nums) {
       int ans[]  = new int[nums.length];

       if (nums.length==1) return new int[1];

       int tem = 1;
       ans[1] = 1;
       //1 2 3 0 1 2
        for (int i = 1; i < nums.length; i++) {
            ans[i] = ans[i-1]*nums[i-1];
        }

        for (int i = nums.length - 2; i >= 0; i--) {
            tem = tem*nums[i+1];
            ans[i]*=tem;
        }
        return ans;

    }

}
