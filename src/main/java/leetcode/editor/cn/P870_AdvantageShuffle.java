//给定两个长度相等的数组 nums1 和 nums2，nums1 相对于 nums2 的优势可以用满足 nums1[i] > nums2[i] 的索引 i 的
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
// 1 <= nums1.length <= 10⁵ 
// nums2.length == nums1.length 
// 0 <= nums1[i], nums2[i] <= 10⁹ 
// 
//
// Related Topics 贪心 数组 双指针 排序 👍 400 👎 0


package leetcode.editor.cn;

import java.util.TreeMap;

/**
 * 优势洗牌
 *
 * @author chenws
 * @date 2023-11-06 17:38:03
 */
public class P870_AdvantageShuffle {

    public static void main(String[] args) {
        //测试代码
        Solution solution = new P870_AdvantageShuffle().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] advantageCount(int[] nums1, int[] nums2) {
            TreeMap<Integer, Integer> treeMap = new TreeMap<>();
            for (int i : nums1) {
                treeMap.merge(i, 1, (a, b) -> a + 1);
            }
            int[] ans = new int[nums1.length];
            for (int i = 0; i < nums2.length; i++) {
                Integer integer = treeMap.higherKey(nums2[i]);
                int a;
                if (integer == null) {
                    a = treeMap.firstKey();
                } else {
                    a = integer;
                }
                ans[i] = a;
                Integer v = treeMap.get(a);
                if (v == 1) {
                    treeMap.remove(a);
                } else {
                    treeMap.put(a, v - 1);
                }
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
