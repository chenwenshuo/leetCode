package hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: chenwenshuo
 * @Date: 2022/09/22/11:15
 */
public class One {
    public int[] twoSum(int[] nums, int target) {

        int[] ans=new int[2];
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num=nums[i];
            if (map.containsKey(target-num)){
                ans[0]=map.get(target-num);
                ans[1]=i;
                return nums;
            }
            map.put(num,i);
        }

        return nums;

    }
}
