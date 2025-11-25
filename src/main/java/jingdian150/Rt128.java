package jingdian150;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Rt128 {

    public int longestConsecutive(int[] nums) {
        int ans = 0;

        //[100,4,200,1,3,2]
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        for (Integer integer : set) {
            if (set.contains(integer+1)) continue;
            int t = 1;
            while (set.contains(integer--)){
                t++;
            }
            ans=Math.max(ans,t);
        }

        return ans;
    }
}
