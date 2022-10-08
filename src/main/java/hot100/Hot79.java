package hot100;

/**
 * 79. 单词搜索
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * 示例 2：
 *
 *
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
 * 输出：true
 * 示例 3：
 *
 *
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
 * 输出：false
 *
 *
 * 提示：
 *
 * m == board.length
 * n = board[i].length
 * 1 <= m, n <= 6
 * 1 <= word.length <= 15
 * board 和 word 仅由大小写英文字母组成
 *
 */
public class Hot79 {

    public boolean exist(char[][] board, String word) {
        int l = board.length;
        int h = board[0].length;
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < h; j++) {
                if (board[i][j]==word.charAt(0)){
                    boolean b=existWord(word,board,i,j,new boolean[l][h],0);
                    if (b) return true;
                }

            }
        }
        return false;
    }

    private boolean existWord(String word, char[][] board, int i, int j, boolean[][] tem,int begin) {
        int l = board.length;
        int h = board[0].length;

        if (word.charAt(begin)!=board[i][j]){
            return false;
        }

        if (word.length()==begin+1) return  true;

        tem[i][j]=true;
        boolean r=false;
        int[][] ar=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        for (int[] ints : ar) {
            int a=ints[0]+i,b=ints[1]+j;
            if (a<l&&a>=0&&b<h&&b>=0){
                if (!tem[a][b]) continue;
                boolean b1 = existWord(word, board, a, b, tem, begin + 1);
                if (b1){
                    r=true;
                    break;
                }
            }
        }
        tem[i][j]=false;
        return r;
    }
}
