//给定两个大小相等的数组 nums1 和 nums2，nums1 相对于 nums2 的优势可以用满足 nums1[i] > nums2[i] 的索引 i 的
//数目来描述。 
//
// 返回 nums1 的任意排列，使其相对于 nums2 的优势最大化。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [2,7,11,15], nums2 = [1,10,4,11]
//输出：[2,11,7,15]
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [12,24,8,32], nums2 = [13,25,32,11]
//输出：[24,32,8,12]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums1.length <= 105 
// nums2.length == nums1.length 
// 0 <= nums1[i], nums2[i] <= 109 
// 
// Related Topics 贪心 数组 双指针 排序 
// 👍 303 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class AdvantageShuffle {
    public static void main(String[] args) {
        Solution solution = new AdvantageShuffle().new Solution();
        System.out.println(solution.advantageCount(new int[]{2,7,11,15},new int[]{1,10,4,11}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] advantageCount(int[] nums1, int[] nums2) {
            int n = nums1.length;
            TreeSet<Integer> tset = new TreeSet<>();
            Map<Integer, Integer> map = new HashMap<>();
            for (int x : nums1) {
                map.put(x, map.getOrDefault(x, 0)/ + 1);
                if (map.get(x) == 1) tset.add(x);
            }
            int[] ans = new int[n];
            for (int i = 0; i < n; i++) {
                Integer cur = tset.ceiling(nums2[i] + 1);
                if (cur == null) cur = tset.ceiling(-1);
                ans[i] = cur;
                map.put(cur, map.get(cur) - 1);
                if (map.get(cur) == 0) tset.remove(cur);
            }
            return ans;
        }
    }


//leetcode submit region end(Prohibit modification and deletion)

}