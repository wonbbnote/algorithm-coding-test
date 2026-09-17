class Solution {

    static ArrayList<int[]>[] adjList;
    static boolean[] visited;

    public int minReorder(int n, int[][] connections) {

        // 양방향 그래프를 그리고 dfs를 돌고, 현재 만들어져 있는 연결 상태와 비교
        // 근데 dfs 0으로 돌아서 connections랑 거꾸로 됨

        adjList = new ArrayList[n];
        for(int i = 0; i < n; i++){
            adjList[i] = new ArrayList<>();
        }

        for(int i = 0; i < connections.length; i++){
            int from = connections[i][0];
            int to = connections[i][1];
            adjList[from].add(new int[] {to, 1});
            adjList[to].add(new int[] {from, 0});
        }

        visited = new boolean[n];
        List<String> route = new ArrayList<>();

        return dfs(0);
        
    }

    public int dfs(int start){
        int count = 0;
        visited[start] = true;
        for(int[] next : adjList[start]){
            int edge = next[0];
            int cost = next[1];

            if(!visited[edge]){
                visited[edge] = true;
                count += cost + dfs(edge);
            }
        }

        return count;
    }
}