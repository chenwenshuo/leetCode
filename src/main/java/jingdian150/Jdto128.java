package jingdian150;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Jdto128 {
    //：nums = [100,4,200,1,3,2]
    //输出：4
    //解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
    //示例 2：
    //
    //输入：nums = [0,3,7,2,5,8,4,6,0,1]
    //输出：9
    //示例 3：
    //
    //输入：nums = [1,0,1,2]
    //输出：3w
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int ans = 0;

        for (Integer n : set) {
            if (set.contains(n-1)) continue;;
            int t = 0;
            while (set.contains(n++)){
                t++;
            }
            ans = Math.max(ans,t);
        }
        return ans;
    }
}
