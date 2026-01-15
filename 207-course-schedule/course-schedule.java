class Solution {
    List<List<Integer>> graph;

    int[] visited;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        graph=new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] pre: prerequisites){
            graph.get(pre[1]).add(pre[0]);
        }

        visited=new int[numCourses];

        for(int i=0; i<numCourses; i++){
            if(visited[i]==0){
                if(!dfs(i)){
                    return false;
                }
            }
        }

        return true;
    }

    private boolean dfs(int course){
        if(visited[course]==1){
            return false;
        }

        if(visited[course]==2){
            return true;
        }

        visited[course]=1;
        for(int next: graph.get(course)){
            if(!dfs(next)){
                return false;
            }
        }

        visited[course]=2;
        return true;
    }
}