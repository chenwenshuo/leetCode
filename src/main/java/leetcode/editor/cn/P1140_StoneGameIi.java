//爱丽丝和鲍勃继续他们的石子游戏。许多堆石子 排成一行，每堆都有正整数颗石子 piles[i]。游戏以谁手中的石子最多来决出胜负。 
//
// 爱丽丝和鲍勃轮流进行，爱丽丝先开始。最初，M = 1。 
//
// 在每个玩家的回合中，该玩家可以拿走剩下的 前 X 堆的所有石子，其中 1 <= X <= 2M。然后，令 M = max(M, X)。 
//
// 游戏一直持续到所有石子都被拿走。 
//
// 假设爱丽丝和鲍勃都发挥出最佳水平，返回爱丽丝可以得到的最大数量的石头。 
//
// 
//
// 示例 1： 
//
// 
//输入：piles = [2,7,9,4,4]
//输出：10
//解释：如果一开始Alice取了一堆，Bob取了两堆，然后Alice再取两堆。爱丽丝可以得到2 + 4 + 4 = 10堆。如果Alice一开始拿走了两堆，那
//么Bob可以拿走剩下的三堆。在这种情况下，Alice得到2 + 7 = 9堆。返回10，因为它更大。
// 
//
// 示例 2: 
//
// 
//输入：piles = [1,2,3,4,5,100]
//输出：104
// 
//
// 
//
// 提示： 
//
// 
// 1 <= piles.length <= 100 
// 
// 1 <= piles[i] <= 10⁴ 
// 
//
// Related Topics 数组 数学 动态规划 博弈 👍 231 👎 0


package leetcode.editor.cn;

/**
 * 石子游戏 II
 * @author chenws
 * @date 2023-02-22 18:03:52
 */
public class P1140_StoneGameIi{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P1140_StoneGameIi().new Solution();
			solution.stoneGameII(new int[]{2,7,9,4,4} );
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	int[] suffixSum;
	Integer[][] cache;
	int n;

	public int stoneGameII(int[] piles) {
		n = piles.length;   // 获取数组长度
		suffixSum = new int[n + 1]; // 后缀和数组
		for(int i = n - 1; i >= 0; i--){
			suffixSum[i] = suffixSum[i + 1] + piles[i];
		}
		cache = new Integer[n][n + 1];  // 缓存数组
		return dfs(0, 1);   // 答案为[0, n-1]堆，M=1的最大收益
	}

	private int dfs(int idx, int m){
		if(idx >= n){
			return 0;   // 索引越界，表示没有剩下的石子堆可以选了，返回0
		}
		if(idx + 2 * m >= n){
			return suffixSum[idx];  // 可以把剩下的石子堆全选了，返回剩下的石子堆石子总数
		}
		if(cache[idx][m] == null){
			// 当前(i,m)的值尚未缓存，枚举每一种情况，记录对手最小的最大收益minStones
			int minStones = Integer.MAX_VALUE;
			for(int x = 1; x <= 2 * m; x++){
				minStones = Math.min(minStones, dfs(idx + x, Math.max(x, m)));
			}
			cache[idx][m] = suffixSum[idx] - minStones; // 记忆该值
		}
		return cache[idx][m];
	}
}


//leetcode submit region end(Prohibit modification and deletion)

}
