class Solution {

    static ArrayList<Integer>[] adjList;
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
            adjList[from].add(to);
            adjList[to].add(from);
        }

        visited = new boolean[n];
        List<String> route = new ArrayList<>();
        dfs(0, route);

        Set<String> set = new HashSet<>();

        for(int i = 0; i < connections.length; i++){
            String s = connections[i][1] + " " + connections[i][0];
            set.add(s);
        }

        int cnt = 0;
        for(String s: route){
            if(!set.contains(s)){
                cnt++;
            }
        }

        return cnt;
        
    }

    public void dfs(int start, List<String> route){
        visited[start] = true;
        for(int next : adjList[start]){
            if(!visited[next]){
                route.add(start + " " + next);
                visited[next] = true;
                dfs(next, route);
            }
        }
    }
}