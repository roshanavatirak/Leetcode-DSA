class Solution {
    public int[][] updateMatrix(int[][] grid) {
        int n= grid.length;
        int m=grid[0].length;
        
        boolean[][] visited= new boolean[n][m];
        int[][] dist= new int[n][m];
        Queue<int[]> q= new LinkedList<>();
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==0){
                    q.add(new int[]{i,j,0});
                    visited[i][j]=true;
                }
            }
        }
        
        int[] dx={-1,1,0,0};
        int[] dy={0,0,-1,1 };
        
        while(!q.isEmpty()){
            int[] curr= q.poll();
            int x= curr[0];
            int y=curr[1];
            int d=curr[2];
            
            dist[x][y]=d;
            
            for(int k=0; k<4; k++){
                int nx=x+dx[k];
                int ny=y+dy[k];
                
                if(nx>=0 && ny>=0 && nx<n &&ny<m && !visited[nx][ny]){
                    q.add(new int[]{nx,ny, d+1});
                    visited[nx][ny]=true;
                }
            }
        }
        
       
        
        return dist;
    }
}