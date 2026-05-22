class Solution {
    public int numEnclaves(int[][] board) {
        int n= board.length;
        int m=board[0].length;

        for(int i=0; i<n; i++){
            if(board[i][0]==1){
                dfs(board,i,0);
            }

            if(board[i][m-1]==1){
                dfs(board,i, m-1);
            }


        }

        for(int j=0; j<m; j++){
            if(board[0][j]==1){
                dfs(board,0, j);
            }

            if(board[n-1][j]==1){
                dfs(board, n-1, j);
            }
        }

int count=0;
        for(int i=0; i<n; i++ ){
            for(int j=0; j<m; j++){
                if(board[i][j]==1){
                    count++;
                }
            }
        }

        return count;
    }

    private void dfs(int[][] board, int row, int col){
        int n=board.length;
        int m=board[0].length;

        if(row<0 ||row>n-1 || col<0 || col>m-1|| board[row][col]!=1){
            return;
        }

        board[row][col]=2;

        dfs(board, row-1, col);
        dfs(board, row+1, col);
        dfs(board, row, col-1);
        dfs(board, row, col+1);
        
    }
}
