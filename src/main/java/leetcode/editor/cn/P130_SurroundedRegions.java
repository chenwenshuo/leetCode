//给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充
//。
//
// 
// 
// 
// 
// 
//
// 示例 1： 
// 
// 
//输入：board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O",
//"X","X"]]
//输出：[["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
//解释：被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都
//会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
// 
//
// 示例 2： 
//
// 
//输入：board = [["X"]]
//输出：[["X"]]
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n == board[i].length 
// 1 <= m, n <= 200 
// board[i][j] 为 'X' 或 'O' 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 958 👎 0


package leetcode.editor.cn;

/**
 * 被围绕的区域
 * @author chenws
 * @date 2023-04-27 16:01:06
 */
public class P130_SurroundedRegions{

	public static void main(String[] args) {
		//测试代码
		Solution solution = new P130_SurroundedRegions().new Solution();
	}

	//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {

		int h,l;

		public void solve(char[][] board) {
			l = board.length;
			h = board[0].length;

			for (int i = 0; i < h; i++) {
				dfs(board,0,i);
				dfs(board,l-1,i);
			}
			for (int i = 0; i < l; i++) {
				dfs(board,i,0);
				dfs(board,i,h-1);
			}
			for (int i = 0; i < l; i++) {
				for (int i1 = 0; i1 < h; i1++) {
					if (board[i][i1]=='A'){
						board[i][i1] = 'X';
					}
				}
			}

		}

		private void dfs(char[][] board, int i, int j) {
			if (i>=l||i<0||j>=h||j<0||board[i][j]!='O'){
				return;
			}
			board[i][j]='A';

			dfs(board,i+1,j);
			dfs(board,i-1,j);
			dfs(board,i,j+1);
			dfs(board,i,j-1);
		}
	}

	public class Solution1 {

		public void solve(char[][] board) {
			int rows = board.length;
			if (rows == 0) {
				return;
			}
			int cols = board[0].length;
			if (cols == 0) {
				return;
			}

			UnionFind unionFind = new UnionFind(rows * cols + 1);
			int dummyNode = rows * cols;

			// 填写第 1 行和最后一行
			for (int j = 0; j < cols; j++) {
				if (board[0][j] == 'O') {
					unionFind.union(getIndex(0, j, cols), dummyNode);
				}
				if (board[rows - 1][j] == 'O') {
					unionFind.union(getIndex(rows - 1, j, cols), dummyNode);
				}
			}

			// 填写第 1 列和最后一列
			for (int i = 1; i < rows - 1; i++) {
				if (board[i][0] == 'O') {
					unionFind.union(getIndex(i, 0, cols), dummyNode);
				}
				if (board[i][cols - 1] == 'O') {
					unionFind.union(getIndex(i, cols - 1, cols), dummyNode);
				}
			}


			int[][] directions = new int[][]{{0, 1}, {1, 0}};
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					if (board[i][j] == 'O') {
						for (int[] direction : directions) {
							int newX = i + direction[0];
							int newY = j + direction[1];
							if (newX < rows && newY < cols && board[newX][newY] == 'O') {
								unionFind.union(getIndex(i, j, cols), getIndex(newX, newY, cols));
							}
						}
					}
				}
			}

			for (int i = 1; i < rows - 1; i++) {
				for (int j = 0; j < cols - 1; j++) {
					if (board[i][j] == 'O') {
						if (!unionFind.isConnected(getIndex(i, j, cols), dummyNode)) {
							board[i][j] = 'X';
						}
					}
				}
			}
		}

		private int getIndex(int x, int y, int cols) {
			return x * cols + y;
		}

		class UnionFind {

			private int[] parent;

			public UnionFind(int n) {
				this.parent = new int[n];
				for (int i = 0; i < n; i++) {
					parent[i] = i;
				}
			}

			public boolean isConnected(int x, int y) {
				return find(x) == find(y);
			}

			public int find(int x) {
				while (x != parent[x]) {
					parent[x] = parent[parent[x]];
					x = parent[x];
				}
				return x;
			}

			public void union(int x, int y) {
				int xRoot = find(x);
				int yRoot = find(y);
				if (xRoot == yRoot) {
					return;
				}
				parent[xRoot] = yRoot;
			}
		}
	}



//leetcode submit region end(Prohibit modification and deletion)

}
