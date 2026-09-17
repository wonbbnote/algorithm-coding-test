class Solution {
    public int findCircleNum(int[][] isConnected) {
        // n개의 도시
        int n = isConnected.length;

        // return 직간접적으로 연결된 province의 개수를 구하기
        // visited[nth]이 false이면 dfs 돌리기, dfs 돌린 개수를 구하면 됨

        boolean[] visited = new boolean[n];
        int cnt = 0;
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                System.out.println(Arrays.toString(visited));
                dfs(i, visited, isConnected);
                cnt++;
            }
        }
        return cnt;

    }

    public void dfs(int start, boolean[] visited, int[][] isConnected){
        
        visited[start] = true;
        for(int i = 0; i < visited.length; i++){
            if(!visited[i] && isConnected[start][i] == 1){
                dfs(i, visited, isConnected);
            }
        }
    }
}