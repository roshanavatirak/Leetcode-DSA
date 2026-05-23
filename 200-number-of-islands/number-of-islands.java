class Solution {
    public int numIslands(char[][] grid) {
        int n= grid.length;
        int m=grid[0].length;
        boolean[][] visited=new boolean[n][m];
        int islands=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]=='1'&& !visited[i][j]){
islands++;
bfs(grid, i, j, visited);
                }
            }
        }

        return islands;
    }

    private void bfs(char[][] grid, int row, int col, boolean[][] visited){
        int n= grid.length;
        int m=grid[0].length;
        
        Queue<int[]> q=new LinkedList<>();

        q.offer(new int[]{row, col});
        visited[row][col]=true;

        int[] dx={-1,1,0,0};
        int[] dy={0,0,-1,1};

        while(!q.isEmpty()){
            int[] curr=q.poll();
            int x=curr[0];
            int y=curr[1];

            for(int k=0; k<4; k++){
                int nx=x+dx[k];
                int ny=y+dy[k];

                if(nx>=0 && nx<n && ny>=0 && ny<m && grid[nx][ny]=='1'&& !visited[nx][ny]){
                    visited[nx][ny]=true;
                    q.offer(new int[] {nx, ny});
                }
            }
        }

    }
}