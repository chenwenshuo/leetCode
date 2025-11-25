package jingdian150;

public class Jdto130 {
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
                    board[i][i1] = 'O';
                }else if (board[i][i1]=='O'){
                    board[i][i1] ='X';
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
