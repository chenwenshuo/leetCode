package jingdian150;

public class Jdto153 {
    public static void main(String[] args) {
        System.out.println(findMin(new int[]{3,1,2}));
    }
    public static int findMin(int[] nums) {
        int ans = 0;
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int mid = l + r >> 1;
            // 4 5 6 1 2 3
            // 3 1 2
            if (nums[mid] <= nums[nums.length-1]) {
                ans = nums[mid];
                r = mid-1 ;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }
}
