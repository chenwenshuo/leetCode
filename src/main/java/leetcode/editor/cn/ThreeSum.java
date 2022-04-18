package leetcode.editor.cn;

//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -10⁵ <= nums[i] <= 10⁵ 
// 
// Related Topics 数组 双指针 排序 👍 4656 👎 0

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum{
         public static void main(String[] args) {
            Solution solution = new ThreeSum().new Solution();
 }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int length = nums.length;
        List<List<Integer>> list=new ArrayList<>();

        for (int i = 1; i < length; i++) {
            if (i!=0&&nums[i]==nums[i-1]) continue;

            int one=-nums[i];

            int three=length-1;

            for (int j = i+1; j <length ; j++) {
                if (j>i+1&&nums[j]==nums[j-1]) continue;
                while (j<three&&nums[three]+nums[j]>one){
                    --three;
                }

                if (three==j) break;
                if (nums[three]+nums[j]==one){
                    List<Integer>  list1=new LinkedList<>();
                    list1.add(i);
                    list1.add(j);
                    list1.add(three);
                    list.add(list1);

                }

            }

        }
        return list;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
