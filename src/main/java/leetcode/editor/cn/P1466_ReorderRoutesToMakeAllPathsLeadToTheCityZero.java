//n 座城市，从 0 到 n-1 编号，其间共有 n-1 条路线。因此，要想在两座不同城市之间旅行只有唯一一条路线可供选择（路线网形成一颗树）。去年，交通运输
//部决定重新规划路线，以改变交通拥堵的状况。 
//
// 路线用 connections 表示，其中 connections[i] = [a, b] 表示从城市 a 到 b 的一条有向路线。 
//
// 今年，城市 0 将会举办一场大型比赛，很多游客都想前往城市 0 。 
//
// 请你帮助重新规划路线方向，使每个城市都可以访问城市 0 。返回需要变更方向的最小路线数。 
//
// 题目数据 保证 每个城市在重新规划路线方向后都能到达城市 0 。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：n = 6, connections = [[0,1],[1,3],[2,3],[4,0],[4,5]]
//输出：3
//解释：更改以红色显示的路线的方向，使每个城市都可以到达城市 0 。 
//
// 示例 2： 
//
// 
//
// 输入：n = 5, connections = [[1,0],[1,2],[3,2],[3,4]]
//输出：2
//解释：更改以红色显示的路线的方向，使每个城市都可以到达城市 0 。 
//
// 示例 3： 
//
// 输入：n = 3, connections = [[1,0],[2,0]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 2 <= n <= 5 * 10^4 
// connections.length == n-1 
// connections[i].length == 2 
// 0 <= connections[i][0], connections[i][1] <= n-1 
// connections[i][0] != connections[i][1] 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 图 👍 117 👎 0


package leetcode.editor.cn;

import java.util.*;

/**
 * 重新规划路线
 * @author chenws
 * @date 2023-06-07 17:33:14
 */
public class P1466_ReorderRoutesToMakeAllPathsLeadToTheCityZero{

	public static void main(String[] args) {
		//测试代码
		Solution solution = new P1466_ReorderRoutesToMakeAllPathsLeadToTheCityZero().new Solution();
	}

	//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {

		public int minReorder(int n, int[][] connections) {
			List<Integer>[] g = new List[n];
			Arrays.setAll(g, k -> new ArrayList<>());

			for (int[] connection : connections) {
				g[connection[0]].add(connection[1]);
				g[connection[1]].add(connection[0]);
			}

			int ans = 0;
			int[] l = new int[n];
			Arrays.fill(l,-1);
			l[0]=0;
			Queue<Integer> queue = new LinkedList<>();
			queue.offer(0);
			while (!queue.isEmpty()){
				Integer poll = queue.poll();
				List<Integer> list = g[poll];
				for (Integer x : list) {
					if (l[x]==-1){
						l[x]=l[poll]+1;
						queue.offer(x);
					}
				}
			}

			for (int[] connection : connections) {
				if (l[connection[0]] < l[connection[1]]) {
					ans++;
				}
			}
			return ans;
		}
	}

	public int minReorder(int n, int[][] connections) {
		List<Integer>[] g = new List[n];
		Arrays.setAll(g, k -> new ArrayList<>());

		for (int[] connection : connections) {
			g[connection[0]].add(connection[1]);
			g[connection[1]].add(connection[0]);
		}

		int ans = 0;
		int[] le = new int[n];
		Arrays.fill(le,-1);
		le[0]=0;
		dfs(0,le,g);
		for (int[] connection : connections) {
			if (le[connection[0]]<le[connection[1]]){
				ans++;
			}
		}
		return ans;
	}

	private void dfs(int k, int[] le, List<Integer>[] g) {
		List<Integer> list = g[k];
		for (Integer next : list) {
			if (le[next]<0){
				le[next]=le[k]+1;
				dfs(next,le,g);

			}
		}
	}
}


