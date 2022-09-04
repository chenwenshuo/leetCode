package leetcode.editor.cn.zs.zhousai;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author: chenwenshuo
 * @Date: 2022/09/04/10:55
 */
public class Ftwo {
    public static void main(String[] args) {
        int a=6;
        int b=2&4;
        System.out.println(a&48&4);
    }

    @Test
    public void test(){
        int i = longestNiceSubarray(new int[]{1, 3, 8, 48, 10});
        System.out.println(i);
    }

    public int longestNiceSubarray(int[] nums) {

        int ans=0;
        int tem=0;
        int pre=0;
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list=new ArrayList<Integer>();
            list.add(nums[i]);
            int a=1;
            for (int j = i+1; j < nums.length; j++) {
                list.add(nums[j]);

                boolean f=parse(list);
                if (f){
                    a++;
                }else {
                    break;
                }
            }
            ans= Math.max(a,ans);
        }

        return ans;
    }

    private boolean parse(List<Integer> list) {
        for (int s = 0; s < list.size(); s++) {
            for (int s1 = s+1; s1 < list.size(); s1++) {
                int k = list.get(s).intValue();
                int k1 = list.get(s1).intValue();
                int h=k&k1;
                if (h!=0){
                   return false;
                }

            }
        }
        return true;
    }
}
