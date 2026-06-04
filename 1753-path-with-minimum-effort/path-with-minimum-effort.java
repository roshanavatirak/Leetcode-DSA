class Solution {
    public int minimumEffortPath(int[][] heights) {
        int rows=heights.length;
        int cols=heights[0].length;

        int[][] effort=new int[rows][cols];

        for(int[] row: effort){
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        effort[0][0]=0;

        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->a[0]-b[0]);

        pq.offer(new int[]{0,0,0});
        int[][] directions={
            {1,0},
            {-1,0},
            {0,1},
            {0,-1}
        };

        while( !pq.isEmpty()){
            int[] current=pq.poll();

            int currentEffort=current[0];
            int r=current[1];
            int c=current[2];

            if(r==rows-1 && c==cols-1){
                return currentEffort;
            }

            if(currentEffort> effort[r][c]){
                continue;
            }

            for(int[] dir:directions){
                int nr=r+dir[0];
                int nc=c+dir[1];

                if(nr<0 || nr>=rows|| nc<0 || nc>=cols){
                    continue;
                }

                int difference=Math.abs(heights[nr][nc]-heights[r][c]);

                int newEffort=Math.max(currentEffort, difference);

                if(newEffort<effort[nr][nc]){
                    effort[nr][nc]=newEffort;
                    pq.offer(new int[]{newEffort, nr, nc});
                }

            }
        }

        return 0;
    }
}