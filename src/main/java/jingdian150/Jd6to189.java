package jingdian150;

public class Jd6to189 {

    //输入: nums = [1,2,3,4,5,6,7], k = 3
    //输出: [5,6,7,1,2,3,4]
    //解释:
    //向右轮转 1 步: [7,1,2,3,4,5,6]
    //向右轮转 2 步: [6,7,1,2,3,4,5]
    //向右轮转 3 步: [5,6,7,1,2,3,4]

    //  7 6 5  4 3 2 1 -> 567 1234
    public void rotate(int[] nums, int k) {

        int length = nums.length;

        k = k%length;

        res(nums,0,length-1);
        res(nums,0,k-1);
        res(nums,k,length-1);
    }

    private void res(int[] nums, int l, int r) {
        while (l<r){
            int t = nums[l];
            nums[l++] = nums[r];
            nums[r--] = t;
        }
    }
}
