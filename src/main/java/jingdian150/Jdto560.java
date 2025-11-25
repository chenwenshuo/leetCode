package jingdian150;

import java.util.HashMap;
import java.util.Map;

public class Jdto560 {
    int ans;

    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int pre = 0;
        int ans = 0;
        for (int num : nums) {
            pre += num;
            ans+=map.getOrDefault(pre-k,0);
            map.put(pre,map.getOrDefault(pre,0));
        }
        return ans;
    }

    private void dfs(int[] nums, int k, int index) {
        if (k < 0) return;
        if (k == 0) {
            ans++;
            return;
        }
        for (int i = index; i < nums.length; i++) {
            dfs(nums, k - nums[i], i + 1);
        }
    }
}
