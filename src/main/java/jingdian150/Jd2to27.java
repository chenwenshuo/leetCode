package jingdian150;

public class Jd2to27 {
    public static void main(String[] args) {
        Jd2to27 jd = new Jd2to27();
        int[] nums = {1};
        int val = 2;
        int res = jd.removeElement(nums, val);
        System.out.println(res);
    }
    public int removeElement(int[] nums, int val) {
//0,1,2,2,3,0,4,2
        int l = 0;
        int r = nums.length-1;
        while (l <= r) {
            if (nums[l] == val) {
                while (l < r && nums[r] == val) {
                    r--;
                }

                nums[l] = nums[r--];
            }
            l++;
        }
        return 1+r;
    }
}
