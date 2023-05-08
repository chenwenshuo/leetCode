//给你一个字符串 croakOfFrogs，它表示不同青蛙发出的蛙鸣声（字符串 "croak" ）的组合。由于同一时间可以有多只青蛙呱呱作响，所以 
//croakOfFrogs 中会混合多个 “croak” 。 
//
// 请你返回模拟字符串中所有蛙鸣所需不同青蛙的最少数目。 
//
// 要想发出蛙鸣 "croak"，青蛙必须 依序 输出 ‘c’, ’r’, ’o’, ’a’, ’k’ 这 5 个字母。如果没有输出全部五个字母，那么它就不会
//发出声音。如果字符串 croakOfFrogs 不是由若干有效的 "croak" 字符混合而成，请返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：croakOfFrogs = "croakcroak"
//输出：1 
//解释：一只青蛙 “呱呱” 两次
// 
//
// 示例 2： 
//
// 
//输入：croakOfFrogs = "crcoakroak"
//输出：2 
//解释：最少需要两只青蛙，“呱呱” 声用黑体标注
//第一只青蛙 "crcoakroak"
//第二只青蛙 "crcoakroak"
// 
//
// 示例 3： 
//
// 
//输入：croakOfFrogs = "croakcrook"
//输出：-1
//解释：给出的字符串不是 "croak" 的有效组合。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= croakOfFrogs.length <= 10⁵ 
// 字符串中的字符只有 'c', 'r', 'o', 'a' 或者 'k' 
// 
//
// Related Topics 字符串 计数 👍 149 👎 0


package leetcode.editor.cn;

/**
 * 数青蛙
 *
 * @author chenws
 * @date 2023-05-06 14:59:16
 */
public class P1419_MinimumNumberOfFrogsCroaking {

    public static void main(String[] args) {
        //测试代码
        Solution solution = new P1419_MinimumNumberOfFrogsCroaking().new Solution();
        System.out.println(solution.minNumberOfFrogs(""));
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int minNumberOfFrogs(String croakOfFrogs) {
            //croakcrook

            int length = croakOfFrogs.length();
            int[] nums = new int[5];
            for (int i = 0; i < length; i++) {
                char c = croakOfFrogs.charAt(i);
                switch (c) {
                    case 'c':
                        nums[0] += 1;
                        nums[4] = nums[4] == 0 ? nums[4] : nums[4] - 1;
                        break;
                    case 'r':
                        if (nums[0] == 0) {
                            return -1;
                        }
                        nums[1]++;
                        nums[0]--;
                        break;
                    case 'o':
                        if (nums[1] == 0) {
                            return -1;
                        }
                        nums[2]++;
                        nums[1]--;
                        break;
                    case 'a':
                        if (nums[2] == 0) {
                            return -1;
                        }
                        nums[3]++;
                        nums[2]--;
                        break;
                    case 'k':
                        if (nums[3] == 0) {
                            return -1;
                        }
                        nums[4]++;
                        nums[3]--;
                        break;

                }
            }
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] != 0) {
                    return -1;
                }
            }
            return nums[4]==0?-1:nums[4];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
