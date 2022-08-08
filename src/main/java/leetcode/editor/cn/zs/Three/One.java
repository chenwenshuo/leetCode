package leetcode.editor.cn.zs.Three;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: chenwenshuo
 * @Date: 2022/08/07/10:32 上午
 */
public class One {
    //nums = [0,1,4,6,7,10], diff = 3
    static int ans=0;


    public  int arithmeticTriplets(int[] nums, int diff) {
        int n = nums.length;

        for (int i = 0; i < n-2; i++) {
            for (int j = i+1; j < n-1; j++) {
                for (int k = j+1; k < n; k++) {
                    if (nums[k]-nums[j]==diff&&nums[j]-nums[i]==diff){
                        ans++;
                    }
                }
            }
        }
        return ans;

    }

    private void dfs(int[] nums, int diff, int ta, int num) {
        if (num==3){
            ans++;
            return;
        }
        for (int i = 0; i < nums.length; i++) {

        }
    }
}
