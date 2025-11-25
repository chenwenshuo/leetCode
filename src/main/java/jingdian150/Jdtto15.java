package jingdian150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Jdtto15 {
    public static void main(String[] args) {
     //   System.out.println(threeSum(new int[]{-100, -70, -60, 110, 120, 130, 160}));
        System.out.println(threeSum(new int[]{2,-3,0,-2,-5,-5,-4,1,2,-2,2,0,2,-4,5,5,-10}));
        //0,0,0,0
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();

        // 输入：nums = [-1,0,1,2,-1,-4]  -4 -1 -1 0 1 2  3
        //输出：[[-1,-1,2],[-1,0,1]]
        //[0,0,0,0]
        // List<String> tem = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int f = nums[i];
            if (f > 0) continue;
            if (i > 0 && f == nums[i - 1]) continue;
            int l = i + 1;
            int r = nums.length - 1;
            int s = Integer.MAX_VALUE;
            while (l < r) {
                if (l != i + 1 && nums[l] == nums[l - 1]) {
                    l++;
                    continue;
                }
                if (f + nums[l] > 0) break;
                if (f + nums[l] == -nums[r]) {
                    ans.add(List.of(f, nums[l], nums[r]));
                    r--;
                }
                if (nums[l] + nums[r] > -f) {
                    r--;
                    continue;
                }
                l++;

            }

        }
        return ans;
    }
}
