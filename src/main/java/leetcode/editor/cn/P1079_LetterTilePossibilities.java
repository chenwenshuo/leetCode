//你有一套活字字模 tiles，其中每个字模上都刻有一个字母 tiles[i]。返回你可以印出的非空字母序列的数目。 
//
// 注意：本题中，每个活字字模只能使用一次。 
//
// 
//
// 示例 1： 
//
// 
//输入："AAB"
//输出：8
//解释：可能的序列为 "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA"。
// 
//
// 示例 2： 
//
// 
//输入："AAABBC"
//输出：188
// 
//
// 示例 3： 
//
// 
//输入："V"
//输出：1 
//
// 
//
// 提示： 
//
// 
// 1 <= tiles.length <= 7 
// tiles 由大写英文字母组成 
// 
//
// Related Topics 哈希表 字符串 回溯 计数 👍 210 👎 0


package leetcode.editor.cn;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 活字印刷
 * @author chenws
 * @date 2023-05-19 14:28:31
 */
public class P1079_LetterTilePossibilities{

	public static void main(String[] args) {
		//测试代码
		Solution solution = new P1079_LetterTilePossibilities().new Solution();
	}

	//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

		int ans = 0;
    public int numTilePossibilities(String tiles) {

			char[] charArray = tiles.toCharArray();
			Set<String> set =new HashSet<>();
			dfs(set,0,charArray);

			return 0;

    }

		private void dfs(Set<String> set, int i, char[] charArray) {
			if (i == charArray.length){
				return;
			}
			for (int j = 0; j < charArray.length; j++) {

			}
		}
}
//leetcode submit region end(Prohibit modification and deletion)

}
