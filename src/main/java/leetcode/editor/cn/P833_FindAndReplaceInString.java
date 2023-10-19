//你会得到一个字符串 s (索引从 0 开始)，你必须对它执行 k 个替换操作。替换操作以三个长度均为 k 的并行数组给出：indices, sources,
// targets。 
//
// 要完成第 i 个替换操作: 
//
// 
// 检查 子字符串 sources[i] 是否出现在 原字符串 s 的索引 indices[i] 处。 
// 如果没有出现， 什么也不做 。 
// 如果出现，则用 targets[i] 替换 该子字符串。 
// 
//
// 例如，如果 s = "abcd" ， indices[i] = 0 , sources[i] = "ab"， targets[i] = "eee" ，那么
//替换的结果将是 "eeecd" 。 
//
// 所有替换操作必须 同时 发生，这意味着替换操作不应该影响彼此的索引。测试用例保证元素间不会重叠 。 
//
// 
// 例如，一个 s = "abc" ， indices = [0,1] ， sources = ["ab"，"bc"] 的测试用例将不会生成，因为 "ab" 
//和 "bc" 替换重叠。 
// 
//
// 在对 s 执行所有替换操作后返回 结果字符串 。 
//
// 子字符串 是字符串中连续的字符序列。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：s = "abcd", indexes = [0,2], sources = ["a","cd"], targets = ["eee","ffff"]
//
//输出："eeebffff"
//解释：
//"a" 从 s 中的索引 0 开始，所以它被替换为 "eee"。
//"cd" 从 s 中的索引 2 开始，所以它被替换为 "ffff"。
// 
//
// 示例 2： 
//
// 
//输入：s = "abcd", indexes = [0,2], sources = ["ab","ec"], targets = ["eee",
//"ffff"]
//输出："eeecd"
//解释：
//"ab" 从 s 中的索引 0 开始，所以它被替换为 "eee"。
//"ec" 没有从原始的 S 中的索引 2 开始，所以它没有被替换。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// k == indices.length == sources.length == targets.length 
// 1 <= k <= 100 
// 0 <= indexes[i] < s.length 
// 1 <= sources[i].length, targets[i].length <= 50 
// s 仅由小写英文字母组成 
// sources[i] 和 targets[i] 仅由小写英文字母组成 
// 
//
// Related Topics 数组 字符串 排序 👍 112 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 字符串中的查找与替换
 *
 * @author chenws
 * @date 2023-08-15 10:03:48
 */
public class P833_FindAndReplaceInString {

    public static void main(String[] args) {
        //测试代码
        Solution solution = new P833_FindAndReplaceInString().new Solution();
       System.out.println(solution.findReplaceString("abcd",new int[]{0,2},new String[]{"ab","cd"},new String[]{"eee","fff"}));
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
            int length = indices.length;
            String[] tem = new String[length + 1];
           // Map<Integer,String[]> map= new HashMap<>();
            int[] map =new int[s.length()];
            for (int i = 0; i < indices.length; i++) {
                map[indices[i]] = i;
             //   map.put(indices[i],new String[]{sources[i],targets[i]});
            }
            Arrays.sort(indices);

            tem[0] = s.substring(0, indices[0]);

          /*  for (int i = 0; i < length - 1; i++) {
                tem[i + 1] = s.substring(indices[i], indices[i + 1]);

            }*/
            tem[length] = s.substring(indices[length - 1]);

            StringBuilder ans = new StringBuilder(tem[0]);
            for (int i = 1; i < tem.length; i++) {
                tem[i] = s.substring(indices[i-1], indices[i]);
                int k = map[indices[i - 1]];
                if (tem[i].startsWith(sources[k])) {
                    ans.append(tem[i].replaceFirst(sources[k], targets[k]));
                } else {
                    ans.append(tem[i]);
                }
            }

            return ans.toString();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
