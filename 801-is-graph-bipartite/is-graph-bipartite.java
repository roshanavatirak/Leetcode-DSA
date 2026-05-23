class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int[] color=new int[n];

        for(int i=0; i<n; i++){
            color[i]=-1;
        
        }

        for(int i=0; i<n; i++){
            if(color[i]==-1){
                if(!dfs(graph, i, 0, color)){
                    return false;
                }
            }
        }


        return true;
    }

    private boolean dfs(int[][] graph, int node, int curr, int[] color){
        color[node]= curr;

        for(int nei : graph[node]){
            if(color[nei]==-1){
                if(!dfs(graph, nei, 1-curr, color)){
                    return false;
                }
            }

            else if(color[nei]==curr){
                return false;
            }
        }

        return true;
    }
}