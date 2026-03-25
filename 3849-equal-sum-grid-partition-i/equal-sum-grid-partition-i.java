class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        long totalSum = 0;
        for (int[] row : grid) {
            for (int val : row) {
                totalSum += val;
            }
        }
        
        
        long rowSum = 0;
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n; j++) {
                rowSum += grid[i][j];
            }
            if (rowSum * 2 == totalSum) {
                return true;
            }
        }

        
        long[] colSums = new long[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                colSums[j] += grid[i][j];
            }
        }

        long leftSum = 0;
        for (int j = 0; j < n - 1; j++) { 
            leftSum += colSums[j];
            if (leftSum * 2 == totalSum) {
                return true;
            }
        }

        return false;
    }
}